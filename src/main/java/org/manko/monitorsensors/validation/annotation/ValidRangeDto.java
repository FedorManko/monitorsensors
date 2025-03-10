package org.manko.monitorsensors.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.manko.monitorsensors.config.i18n.I18nMessages.RANGE_WRONG_PARAMETERS;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.manko.monitorsensors.validation.impl.RangeDtoValidator;

/**
 * Custom annotation, that defines validation for {@link RangeDtoValidator}.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = RangeDtoValidator.class)
public @interface ValidRangeDto {

    /**
     * Method returns custom validation message.
     *
     * @return an instance of {@link String}
     */
    String message() default RANGE_WRONG_PARAMETERS;

    /**
     * Method returns groups.
     *
     * @return an instance of {@link Class}
     */
    Class<?>[] groups() default {};

    /**
     * Method returns payload.
     *
     * @return an instance of {@link Class}
     */
    Class<? extends Payload>[] payload() default {};

}
