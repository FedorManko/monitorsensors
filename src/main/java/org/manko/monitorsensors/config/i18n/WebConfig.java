package org.manko.monitorsensors.config.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is a configuration class for web servlet settings.
 *
 * @author f.manko
 * @since 07.03.2025
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Defines a bean for {@link MessageSource}. This bean overrides default message source
     *
     * @return an instance of {@link MessageSource}
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Defines a bean for {@link LocalValidatorFactoryBean}. This bean overrides default validator
     * factory
     *
     * @return an instance of {@link LocalValidatorFactoryBean}
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
