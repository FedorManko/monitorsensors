package org.manko.monitorsensors.util.entity;


import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorType;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.entity.SensorType;

/**
 * This class provides randomizer for SensorType {@link SensorType} entity type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorTypeRandomizer implements Randomizer<SensorType> {

    @Override
    public SensorType getRandomValue() {

        SensorType sensorType = new SensorType();

        sensorType.setId(fakeId());
        sensorType.setSensorType(fakeSensorType());

        return sensorType;
    }
}
