package org.manko.monitorsensors.util.entity;


import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorUnit;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.entity.SensorUnit;

/**
 * This class provides randomizer for SensorUnit {@link SensorUnit} entity type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorUnitRandomizer implements Randomizer<SensorUnit> {

    @Override
    public SensorUnit getRandomValue() {

        SensorUnit sensorUnit = new SensorUnit();

        sensorUnit.setId(fakeId());
        sensorUnit.setSensorUnit(fakeSensorUnit());

        return sensorUnit;
    }
}
