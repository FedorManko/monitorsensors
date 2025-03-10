package org.manko.monitorsensors.service.vaiidator;


import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;
import org.springframework.stereotype.Component;

/**
 * This class describes database-layer component, required for validation of requested entities to
 * exist / exist with certain conditions. It allows to validate request parameters using cheap exist
 * queries and throw i18n messages in case of entity not exist / already exist.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Component
@RequiredArgsConstructor
public class CommonDatabaseValidator {

    private final List<DatabaseValidator<?>> validators;

    /**
     * Facade method, that run's injected validations by {@link ValidationContext}. After validation
     * is being processed - purges discriminator at context to allow usage.
     *
     * @param appliedContext an instance of {@link Consumer} for {@link ValidationContext}
     *                       mutation.
     */
    public void validate(Consumer<ValidationContext> appliedContext) {

        ValidationContext context = new ValidationContext();
        appliedContext.accept(context);

        validators.forEach(v -> {
            if (Objects.nonNull(v.discriminator(context))) {
                v.validate(context);
                v.resetDiscriminator(context);
            }
        });
    }
}
