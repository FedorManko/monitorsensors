package org.manko.monitorsensors.service.vaiidator.impl;


import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.ENTITY_NOT_FOUND_EXCEPTION;
import static org.manko.monitorsensors.service.vaiidator.context.ValidationConstants.SENSOR_ID;

import org.manko.monitorsensors.entity.Sensor;
import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.repository.SensorRepository;
import org.manko.monitorsensors.service.vaiidator.AbstractDatabaseValidator;
import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class describes custom database validator for {@link Sensor} to exist by id.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Component
public class SensorByIdDatabaseValidator extends AbstractDatabaseValidator<Long> {

    private final SensorRepository sensorRepository;

    /**
     * Default constructor that provides injection of required spring beans.
     *
     * @param messageSource    instance of {@link MessageSource}
     * @param sensorRepository instance of {@link SensorRepository}
     */
    public SensorByIdDatabaseValidator(
        MessageSource messageSource,
        SensorRepository sensorRepository
    ) {
        super(messageSource);
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Long discriminator(ValidationContext context) {
        return context.getSensorId();
    }

    @Override
    public void resetDiscriminator(ValidationContext context) {
        context.setSensorId(null);
    }

    @Override
    public void validate(ValidationContext context) {

        boolean isSensorExists = sensorRepository.existsById(discriminator(context));

        if (!isSensorExists) {
            throwLocalized(
                ENTITY_NOT_FOUND_EXCEPTION,
                SensorUnit.class,
                SENSOR_ID,
                discriminator(context)
            );
        }
    }
}
