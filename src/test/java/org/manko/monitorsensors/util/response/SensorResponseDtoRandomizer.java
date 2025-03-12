package org.manko.monitorsensors.util.response;


import static org.manko.monitorsensors.util.FakerUtils.fakeDescription;
import static org.manko.monitorsensors.util.FakerUtils.fakeId;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorName;
import static org.manko.monitorsensors.util.FakerUtils.fakeSensorType;

import org.jeasy.random.api.Randomizer;
import org.manko.monitorsensors.dto.response.SensorResponseDto;

/**
 * This class provides randomizer for SensorResponseDto {@link SensorResponseDto} dto type.
 *
 * @author f.manko
 * @since 11.03.2025
 */
public class SensorResponseDtoRandomizer implements Randomizer<SensorResponseDto> {

    @Override
    public SensorResponseDto getRandomValue() {

        SensorResponseDto response = new SensorResponseDto();

        response.setId(fakeId());
        response.setDescription(fakeDescription());
        response.setName(fakeSensorName());
        response.setSensorType(fakeSensorType());
        return response;
    }
}
