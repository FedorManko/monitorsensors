package org.manko.monitorsensors.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.entity.SensorType;
import org.springframework.beans.factory.annotation.Autowired;

class SensorTypeMapperTest extends BaseMapperContext {

    @Autowired
    private SensorTypeMapper sensorTypeMapper;

    @Test
    void testToDto() {
        SensorType sensorType = new SensorType();
        sensorType.setSensorType("test");
        SensorTypeResponseDto expected = new SensorTypeResponseDto();
        expected.setSensorType("test");

        SensorTypeResponseDto actual = sensorTypeMapper.toDto(sensorType);

        assertThat(actual.getSensorType()).isEqualTo(expected.getSensorType());
    }

    @Test
    void testToDtoList() {
        SensorType sensorType = new SensorType();
        sensorType.setSensorType("test");
        SensorTypeResponseDto expected = new SensorTypeResponseDto();
        expected.setSensorType("test");
        List<SensorTypeResponseDto> expectedList = List.of(expected);

        List<SensorTypeResponseDto> actual = sensorTypeMapper.toDtoList(List.of(sensorType));

        assertThat(actual.getFirst().getSensorType())
            .isEqualTo(expectedList.getFirst().getSensorType());
    }

}
