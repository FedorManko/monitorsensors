package org.manko.monitorsensors.service.vaiidator.impl;


import static org.manko.monitorsensors.config.i18n.I18nPlaceholders.ENTITY_NOT_FOUND_EXCEPTION;
import static org.manko.monitorsensors.service.vaiidator.context.ValidationConstants.SENSOR_UNIT_ID;

import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.repository.SensorUnitRepository;
import org.manko.monitorsensors.service.vaiidator.AbstractDatabaseValidator;
import org.manko.monitorsensors.service.vaiidator.context.ValidationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * This class describes custom database validator for {@link SensorUnit} to exist by id.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Component
public class SensorUnitByIdDatabaseValidator extends AbstractDatabaseValidator<Long> {

    private final SensorUnitRepository sensorUnitRepository;

    /**
     * Default constructor that provides injection of required spring beans.
     *
     * @param messageSource        instance of {@link MessageSource}
     * @param sensorUnitRepository instance of {@link SensorUnitRepository}
     */
    public SensorUnitByIdDatabaseValidator(
        MessageSource messageSource,
        SensorUnitRepository sensorUnitRepository
    ) {
        super(messageSource);
        this.sensorUnitRepository = sensorUnitRepository;
    }

    @Override
    public Long discriminator(ValidationContext context) {
        return context.getSensorUnitId();
    }

    @Override
    public void resetDiscriminator(ValidationContext context) {
        context.setSensorUnitId(null);
    }

    @Override
    public void validate(ValidationContext context) {

        boolean isSensorUnitExists = sensorUnitRepository.existsById(discriminator(context));

        if (!isSensorUnitExists) {
            throwLocalized(
                ENTITY_NOT_FOUND_EXCEPTION,
                SensorUnit.class,
                SENSOR_UNIT_ID,
                discriminator(context)
            );
        }
    }
}
