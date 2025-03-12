package org.manko.monitorsensors.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.entity.SensorUnit;
import org.springframework.beans.factory.annotation.Autowired;

class SensorUnitMapperTest extends BaseMapperContext {

    @Autowired
    private SensorUnitMapper sensorUnitMapper;

    @Test
    void testToDto() {
        SensorUnit sensorUnit = new SensorUnit();
        sensorUnit.setSensorUnit("test");
        SensorUnitResponseDto expected = new SensorUnitResponseDto();
        expected.setSensorUnit("test");

        SensorUnitResponseDto actual = sensorUnitMapper.toDto(sensorUnit);

        assertThat(actual.getSensorUnit()).isEqualTo(expected.getSensorUnit());
    }

    @Test
    void testToDtoList() {
        SensorUnit sensorUnit = new SensorUnit();
        sensorUnit.setSensorUnit("test");
        SensorUnitResponseDto expected = new SensorUnitResponseDto();
        expected.setSensorUnit("test");
        List<SensorUnitResponseDto> expectedList = List.of(expected);

        List<SensorUnitResponseDto> actual = sensorUnitMapper.toDtoList(List.of(sensorUnit));

        assertThat(actual.getFirst().getSensorUnit())
            .isEqualTo(expectedList.getFirst().getSensorUnit());
    }

}
