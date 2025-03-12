package org.manko.monitorsensors.util.response;


import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorType;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;

/**
 * This class provides randomizer for SensorTypeResponseDto {@link SensorTypeResponseDto} dto type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorTypeResponseDtoRandomizer implements Randomizer<SensorTypeResponseDto> {

    @Override
    public SensorTypeResponseDto getRandomValue() {

        SensorTypeResponseDto response = new SensorTypeResponseDto();

        response.setId(fakeId());
        response.setSensorType(fakeSensorType());
        return response;
    }
}
