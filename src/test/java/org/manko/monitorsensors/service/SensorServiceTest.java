package org.manko.monitorsensors.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.manko.monitorsensors.util.FakerUtils.FAKE;
import static org.manko.monitorsensors.util.RandomUtils.RANDOM;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.entity.Sensor;
import org.manko.monitorsensors.entity.SensorType;
import org.manko.monitorsensors.entity.SensorUnit;
import org.manko.monitorsensors.mapper.SensorMapper;
import org.manko.monitorsensors.repository.SensorRepository;
import org.manko.monitorsensors.repository.SensorTypeRepository;
import org.manko.monitorsensors.repository.SensorUnitRepository;
import org.manko.monitorsensors.service.vaiidator.CommonDatabaseValidator;
import org.manko.monitorsensors.util.FakerUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class SensorServiceTest {

    @InjectMocks
    private SensorService sensorService;

    @Mock
    private CommonDatabaseValidator validator;

    @Mock
    private SensorRepository sensorRepository;

    @Mock
    private SensorTypeRepository sensorTypeRepository;

    @Mock
    private SensorUnitRepository sensorUnitRepository;

    @Mock
    private SensorMapper sensorMapper;

    private String email;
    private Sensor sensor;
    private SensorResponseDto response;
    private Long sensorId;

    @BeforeEach
    void setUp() {
        email = FAKE.siliconValley().email();
        sensor = RANDOM.nextObject(Sensor.class);
        response = RANDOM.nextObject(SensorResponseDto.class);
        sensorId = FakerUtils.fakeId();
    }

    @Test
    @DisplayName("Should find all sensors")
    void findAllSensors() {
        doNothing().when(validator).validate(any());
        when(sensorRepository.findAllWithSearch(anyString())).thenReturn(List.of(sensor));
        when(sensorMapper.toDtoList(anyList())).thenReturn(List.of(response));

        List<SensorResponseDto> actual = sensorService
            .findAllSensors(email, "");

        assertAll(
            () -> assertThat(actual).hasSize(1),
            () -> verify(validator).validate(any()),
            () -> verify(sensorRepository).findAllWithSearch(anyString()),
            () -> verify(sensorMapper).toDtoList(anyList()),
            () -> verifyNoMoreInteractions(
                validator,
                sensorRepository,
                sensorMapper)
        );
    }

    @Test
    @DisplayName("Should delete sensors")
    void deleteSensor() {

        doNothing().when(validator).validate(any());
        doNothing().when(sensorRepository).deleteById(anyLong());

        sensorService
            .deleteSensor(sensorId, email);

        assertAll(
            () -> verify(validator).validate(any()),
            () -> verify(sensorRepository).deleteById(anyLong()),
            () -> verifyNoMoreInteractions(sensorRepository, validator)
        );
    }

    @Test
    @DisplayName("Should create sensors")
    void createSensor() {
        SensorType sensorType = RANDOM.nextObject(SensorType.class);
        SensorUnit sensorUnit = RANDOM.nextObject(SensorUnit.class);
        SensorRequestDto request = RANDOM.nextObject(SensorRequestDto.class);

        doNothing().when(validator).validate(any());
        when(sensorTypeRepository.getReferenceById(anyLong())).thenReturn(sensorType);
        when(sensorUnitRepository.getReferenceById(anyLong())).thenReturn(sensorUnit);
        when(sensorMapper.toEntity(
            any(SensorRequestDto.class),
            any(SensorType.class),
            any(SensorUnit.class)
        )).thenReturn(sensor);
        when(sensorRepository.save(any(Sensor.class))).thenReturn(sensor);
        when(sensorMapper.toDto(any(Sensor.class))).thenReturn(response);

        SensorResponseDto actual = sensorService.createSensor(request, email);

        assertAll(
            () -> assertThat(actual.getModel()).isEqualTo(sensor.getModel()),
            () -> verify(validator).validate(any()),
            () -> verify(sensorTypeRepository).getReferenceById(anyLong()),
            () -> verify(sensorUnitRepository).getReferenceById(anyLong()),
            () -> verify(sensorMapper).toEntity(
                any(SensorRequestDto.class),
                any(SensorType.class),
                any(SensorUnit.class)),
            () -> verify(sensorRepository).save(any(Sensor.class)),
            () -> verify(sensorMapper).toDto(any(Sensor.class)),
            () -> verifyNoMoreInteractions(
                validator,
                sensorRepository,
                sensorTypeRepository,
                sensorUnitRepository,
                sensorMapper)
        );
    }

    @Test
    @DisplayName("Should update sensors")
    void updateSensor() {
        SensorType sensorType = RANDOM.nextObject(SensorType.class);
        SensorUnit sensorUnit = RANDOM.nextObject(SensorUnit.class);
        SensorRequestDto request = RANDOM.nextObject(SensorRequestDto.class);

        doNothing().when(validator).validate(any());
        when(sensorRepository.getReferenceById(anyLong())).thenReturn(sensor);
        when(sensorTypeRepository.getReferenceById(anyLong())).thenReturn(sensorType);
        when(sensorUnitRepository.getReferenceById(anyLong())).thenReturn(sensorUnit);
        when(sensorMapper.updateEntity(
            any(Sensor.class),
            any(SensorRequestDto.class),
            any(SensorType.class),
            any(SensorUnit.class)
        )).thenReturn(sensor);
        when(sensorMapper.toDto(any(Sensor.class))).thenReturn(response);

        SensorResponseDto actual = sensorService.updateSensor(sensorId, request, email);

        assertAll(
            () -> assertThat(actual.getModel()).isEqualTo(sensor.getModel()),
            () -> verify(validator).validate(any()),
            () -> verify(sensorRepository).getReferenceById(anyLong()),
            () -> verify(sensorTypeRepository).getReferenceById(anyLong()),
            () -> verify(sensorUnitRepository).getReferenceById(anyLong()),
            () -> verify(sensorMapper).updateEntity(
                any(Sensor.class),
                any(SensorRequestDto.class),
                any(SensorType.class),
                any(SensorUnit.class)),
            () -> verify(sensorMapper).toDto(any(Sensor.class)),
            () -> verifyNoMoreInteractions(
                validator,
                sensorRepository,
                sensorTypeRepository,
                sensorUnitRepository,
                sensorMapper)
        );
    }
}
