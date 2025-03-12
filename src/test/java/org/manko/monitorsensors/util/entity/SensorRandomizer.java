package org.manko.monitorsensors.util.entity;


import static org.manko.monitorsensors.util.FakerUtils.FAKE;
import static org.manko.monitorsensors.util.FakerUtils.fakeDescription;
import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorName;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.entity.Sensor;

/**
 * This class provides randomizer for Sensor {@link Sensor} entity type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorRandomizer implements Randomizer<Sensor> {

    @Override
    public Sensor getRandomValue() {

        Sensor sensor = new Sensor();

        sensor.setId(fakeId());
        sensor.setLocation(FAKE.location().work());
        sensor.setDescription(fakeDescription());
        sensor.setName(fakeSensorName());

        return sensor;
    }
}
