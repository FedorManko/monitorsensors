package org.manko.monitorsensors.exception.handler;


import static java.util.Locale.ENGLISH;
import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.CUSTOM_VALIDATION_EXCEPTION;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.manko.monitorsensors.exception.ApplicationException;
import org.manko.monitorsensors.exception.RestError;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This is a Global REST exception handler for error customization.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    /**
     * Exception handler that handles message validation exceptions.
     *
     * @param ex      {@link MethodArgumentNotValidException} exception instance
     * @param request http request instance
     * @return custom rest error model {@link RestError}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                           HttpServletRequest request) {
        if (log.isErrorEnabled()) {
            log.error(ex.getMessage(), ex);
        }

        Map<String, Object> validationExceptions = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(FieldError::getField, this::createErrorMessage));

        String keys = String.join(", ", validationExceptions.keySet());

        String placeholderForMessage = CUSTOM_VALIDATION_EXCEPTION.getPlaceholder();
        var exceptionMessage = messageSource.getMessage(
            placeholderForMessage, new String[] {keys}, ENGLISH
        );

        return buildResponseBody(request, exceptionMessage, validationExceptions);
    }

    /**
     * Exception handler that handles common business exceptions.
     *
     * @param ex      {@link ApplicationException} exception instance
     * @param request http request instance
     * @return custom rest error model {@link RestError}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationException.class)
    public RestError handleApplicationException(
        ApplicationException ex,
        HttpServletRequest request
    ) {

        if (log.isErrorEnabled()) {
            log.error(ex.getMessage(), ex);
        }

        return buildResponseBody(request, ex.getErrorMessage(), ex.getMeta());
    }

    private String createErrorMessage(FieldError error) {
        StringBuilder sb = new StringBuilder();

        String defaultMessage = error.getDefaultMessage();
        Object[] arguments = error.getArguments();
        Object[] args = arguments != null && arguments.length > 1
            ? new Object[] {arguments[1], arguments[2]}
            : null;

        sb.append(Objects.nonNull(defaultMessage)
            ? messageSource.getMessage(defaultMessage, args, ENGLISH)
            : " Unknown error descriptor");

        return sb.toString();
    }

    private RestError buildResponseBody(
        HttpServletRequest request,
        String message,
        Map<String, Object> meta
    ) {
        return new RestError(
            request.getRequestURI(),
            request.getMethod(),
            Instant.now(),
            message,
            meta
        );
    }

}
