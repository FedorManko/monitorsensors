package org.manko.monitorsensors.util.response;


import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorUnit;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;

/**
 * This class provides randomizer for SensorUnitResponseDto {@link SensorUnitResponseDto}dto type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorUnitResponseDtoRandomizer implements Randomizer<SensorUnitResponseDto> {

    @Override
    public SensorUnitResponseDto getRandomValue() {

        SensorUnitResponseDto response = new SensorUnitResponseDto();

        response.setId(fakeId());
        response.setSensorUnit(fakeSensorUnit());
        return response;
    }
}
