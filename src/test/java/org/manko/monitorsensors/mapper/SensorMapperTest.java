package org.manko.monitorsensors.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;

class SensorMapperTest extends BaseMapperContext {

    @Autowired
    private SensorMapper sensorMapper;

    @Test
    void testToDto() {
        Sensor sensor = new Sensor();
        sensor.setName("test");
        SensorResponseDto expected = new SensorResponseDto();
        expected.setName("test");

        SensorResponseDto actual = sensorMapper.toDto(sensor);

        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    void testToDtoList() {
        Sensor sensor = new Sensor();
        sensor.setName("test");
        SensorResponseDto expected = new SensorResponseDto();
        expected.setName("test");
        List<SensorResponseDto> expectedList = List.of(expected);

        List<SensorResponseDto> actual = sensorMapper.toDtoList(List.of(sensor));

        assertThat(actual.getFirst().getName()).isEqualTo(expectedList.getFirst().getName());
    }

}
