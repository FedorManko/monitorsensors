package org.manko.monitorsensors.config.i18n;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * This is a configuration class for setting application locales.
 *
 * @author f.manko
 * @since 07.03.2025
 */
@Configuration
public class LocaleConfig {

    /**
     * Defines a bean for {@link LocaleResolver}. This bean overrides default locale resolver
     *
     * @return an instance of {@link LocaleResolver}
     */
    @Bean
    public LocaleResolver localeResolver() {
        FixedLocaleResolver localeResolver = new FixedLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }
}
