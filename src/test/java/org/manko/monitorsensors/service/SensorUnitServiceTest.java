package org.manko.monitorsensors.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.manko.monitorsensors.util.RandomUtils.RANDOM;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.mapper.SensorUnitMapper;
import org.manko.monitorsensors.repository.SensorUnitRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class SensorUnitServiceTest {

    @InjectMocks
    private SensorUnitService sensorUnitService;

    @Mock
    private SensorUnitRepository sensorUnitRepository;

    @Mock
    private SensorUnitMapper sensorUnitMapper;

    @Test
    @DisplayName("Should find all sensor units")
    void findAllSensorUnits() {
        SensorUnit sensorType = RANDOM.nextObject(SensorUnit.class);
        SensorUnitResponseDto response = RANDOM.nextObject(SensorUnitResponseDto.class);

        when(sensorUnitRepository.findAll()).thenReturn(List.of(sensorType));
        when(sensorUnitMapper.toDtoList(anyList())).thenReturn(List.of(response));

        List<SensorUnitResponseDto> actual = sensorUnitService.findAllSensorUnits();

        assertAll(
            () -> assertThat(actual).hasSize(1),
            () -> verify(sensorUnitRepository).findAll(),
            () -> verify(sensorUnitMapper).toDtoList(anyList()),
            () -> verifyNoMoreInteractions(sensorUnitRepository, sensorUnitMapper)
        );
    }
}
