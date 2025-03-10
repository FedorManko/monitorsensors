package org.manko.monitorsensors.service.vaiidator;


import java.util.Locale;
import java.util.Map;
import org.manko.monitorsensors.config.i18n.I18nPlaceholders;
import org.manko.monitorsensors.exception.ApplicationException;
import org.springframework.context.MessageSource;

/**
 * This class describes the common functionality for database validators.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public abstract class AbstractDatabaseValidator<T> implements DatabaseValidator<T> {

    protected final MessageSource messageSource;

    /**
     * Protected constructor with {@link MessageSource} injection to provide message localization.
     *
     * @param messageSource message source bean that provides localized output
     */
    protected AbstractDatabaseValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Method provides {@link ApplicationException} invocation using localized message using
     * {@link I18nPlaceholders}.
     *
     * @param i18nPlaceholder i18n placeholder
     * @param clazz           class instance for parameterization at message template
     * @param messageKey      application exception meta key
     * @param message         application exception meta value
     */
    protected void throwLocalized(
        I18nPlaceholders i18nPlaceholder,
        Class<?> clazz,
        String messageKey,
        T message
    ) {
        String errorMessage = messageSource.getMessage(
            i18nPlaceholder.getPlaceholder(),
            new Object[] {clazz.getSimpleName()},
            Locale.ENGLISH
        );
        throw new ApplicationException(errorMessage, Map.of(messageKey, message));
    }
}
