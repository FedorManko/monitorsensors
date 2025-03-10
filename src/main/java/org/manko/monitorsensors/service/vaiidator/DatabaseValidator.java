package org.manko.monitorsensors.service.vaiidator;


import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;

/**
 * This interface describes database validation api and defines discriminator usage.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public interface DatabaseValidator<T> {

    /**
     * Contract method that defines specific discriminator property within
     * {@link ValidationContext}.
     *
     * @param context instance of {@link ValidationContext}
     * @return generic discriminator type
     */
    T discriminator(ValidationContext context);

    /**
     * Contract method that defines discriminator property reset within {@link ValidationContext}.
     *
     * @param context instance of {@link ValidationContext}
     */
    void resetDiscriminator(ValidationContext context);

    /**
     * Contract method that defines database validation for implementations.
     *
     * @param context instance of {@link ValidationContext}
     */
    void validate(ValidationContext context);
}
