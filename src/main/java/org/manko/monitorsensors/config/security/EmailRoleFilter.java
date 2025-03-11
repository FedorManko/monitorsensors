package org.manko.monitorsensors.config.security;


import static java.util.Objects.isNull;
import static org.manko.monitorsensors.config.security.CustomHttpHeaders.X_CUSTOMER_EMAIL_HEADER;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.manko.monitorsensors.repository.CustomerRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Custom security filter that is applied after {@link BasicAuthenticationFilter} to provide roles
 * by specified customer email.
 *
 * @author f.manko
 * @since 11.03.2025
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailRoleFilter extends OncePerRequestFilter {

    private static final String SENSOR_URL = "api/v1/sensors";

    Predicate<HttpServletRequest> isProtectedAccess = r ->
        r.getRequestURI().contains(SENSOR_URL);

    private final CustomerRepository customerRepository;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        if (request.getRequestURI().contains("/api/v1")) {

            List<GrantedAuthority> authorities = new ArrayList<>();

            handleCustomersAccess(request, authorities);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (Objects.isNull(auth)) {

                var message = "Unauthenticated requests are forbidden. Method: %s, URI: %s"
                    .formatted(request.getMethod(), request.getRequestURI());

                logger.error(message);
                response.sendError(HttpServletResponse.SC_FORBIDDEN, message);
            } else {

                Authentication updatedAuthentication = new UsernamePasswordAuthenticationToken(
                    auth.getPrincipal(),
                    auth.getCredentials(),
                    authorities
                );

                SecurityContextHolder.getContext().setAuthentication(updatedAuthentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private void handleCustomersAccess(
        HttpServletRequest request,
        List<GrantedAuthority> authorities
    ) {

        if (!isProtectedAccess.test(request)) {
            return;
        }

        String customerEmailHeader = request.getHeader(X_CUSTOMER_EMAIL_HEADER);

        if (isNull(customerEmailHeader)) {
            return;
        }

        customerRepository
            .finCustomerAuthority(customerEmailHeader)
            .ifPresent(authority -> authorities.add(authority.toAuthority()));
    }

}

