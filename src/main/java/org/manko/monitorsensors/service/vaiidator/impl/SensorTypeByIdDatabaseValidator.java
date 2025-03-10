package org.manko.monitorsensors.service.vaiidator.impl;


import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.ENTITY_NOT_FOUND_EXCEPTION;
import static org.manko.monitorsensors.service.vaiidator.context.ValidationConstants.SENSOR_TYPE_ID;

import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.repository.SensorTypeRepository;
import org.manko.monitorsensors.service.vaiidator.AbstractDatabaseValidator;
import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class describes custom database validator for {@link SensorType} to exist by id.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Component
public class SensorTypeByIdDatabaseValidator extends AbstractDatabaseValidator<Long> {

    private final SensorTypeRepository sensorTypeRepository;

    /**
     * Default constructor that provides injection of required spring beans.
     *
     * @param messageSource        instance of {@link MessageSource}
     * @param sensorTypeRepository instance of {@link SensorTypeRepository}
     */
    public SensorTypeByIdDatabaseValidator(
        MessageSource messageSource,
        SensorTypeRepository sensorTypeRepository
    ) {
        super(messageSource);
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public Long discriminator(ValidationContext context) {
        return context.getSensorTypeId();
    }

    @Override
    public void resetDiscriminator(ValidationContext context) {
        context.setSensorTypeId(null);
    }

    @Override
    public void validate(ValidationContext context) {

        boolean isSensorTypeExists = sensorTypeRepository.existsById(discriminator(context));

        if (!isSensorTypeExists) {
            throwLocalized(
                ENTITY_NOT_FOUND_EXCEPTION,
                SensorType.class,
                SENSOR_TYPE_ID,
                discriminator(context)
            );
        }
    }
}
