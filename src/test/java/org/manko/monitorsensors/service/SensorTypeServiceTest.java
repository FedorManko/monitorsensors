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
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.mapper.SensorTypeMapper;
import org.manko.monitorsensors.repository.SensorTypeRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class SensorTypeServiceTest {

    @InjectMocks
    private SensorTypeService sensorTypeService;

    @Mock
    private SensorTypeRepository sensorTypeRepository;

    @Mock
    private SensorTypeMapper sensorTypeMapper;

    @Test
    @DisplayName("Should find all sensor types")
    void findAllSensorTypes() {
        SensorType sensorType = RANDOM.nextObject(SensorType.class);
        SensorTypeResponseDto response = RANDOM.nextObject(SensorTypeResponseDto.class);
        when(sensorTypeRepository.findAll()).thenReturn(List.of(sensorType));
        when(sensorTypeMapper.toDtoList(anyList())).thenReturn(List.of(response));

        List<SensorTypeResponseDto> actual = sensorTypeService.findAllSensorTypes();

        assertAll(
            () -> assertThat(actual).hasSize(1),
            () -> verify(sensorTypeRepository).findAll(),
            () -> verify(sensorTypeMapper).toDtoList(anyList()),
            () -> verifyNoMoreInteractions(sensorTypeRepository, sensorTypeMapper)
        );
    }
}
