package org.manko.monitorsensors.config;


import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.SWAGGER_DESCRIPTION;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class for setting up openapi description using swagger.
 *
 * @author f.manko
 * @since 10.03.2025
 */
@Configuration
@RequiredArgsConstructor
public class OpenApiConfiguration {

    public static final String SECURITY_REQUIREMENT_NAME = "basicAuth";
    private final MessageSource messageSource;


    /**
     * Defines a bean for {@link OpenAPI}. This bean overrides default swagger-ui representation.
     *
     * @return an instance of {@link OpenAPI}
     */
    @Bean
    public OpenAPI baseOpenApi(BuildProperties buildProperties) {

        var swaggerDescription = messageSource.getMessage(
            SWAGGER_DESCRIPTION.getPlaceholder(), null, Locale.ENGLISH
        );

        final Info openapiInfo = new Info()
            .title(buildProperties.getName())
            .version(buildProperties.getVersion())
            .description(swaggerDescription);

        SecurityScheme basicAuthScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("basic");

        return new OpenAPI()
            .info(openapiInfo)
            .addSecurityItem(new SecurityRequirement().addList(SECURITY_REQUIREMENT_NAME))
            .schemaRequirement(SECURITY_REQUIREMENT_NAME, basicAuthScheme);
    }
}
