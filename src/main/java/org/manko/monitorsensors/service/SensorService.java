package org.manko.monitorsensors.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a class that describes service that provides entity crud operations for Sensor.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SensorService {

    private final SensorTypeRepository sensorTypeRepository;
    private final SensorUnitRepository sensorUnitRepository;
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    private final CommonDatabaseValidator commonDatabaseValidator;

    /**
     * Method returns an instance of SensorResponseDto.
     *
     * @param request SensorRequestDto information.
     * @return an instance of {@link SensorResponseDto}.
     */
    public SensorResponseDto createSensor(SensorRequestDto request) {
        commonDatabaseValidator.validate(context -> {
            context.setSensorTypeId(request.getSensorTypeId());
            context.setSensorUnitId(request.getSensorUnitId());
        });

        SensorType type =
            sensorTypeRepository.getReferenceById(request.getSensorTypeId());
        SensorUnit unit =
            sensorUnitRepository.getReferenceById(request.getSensorUnitId());

        Sensor sensor = sensorMapper.toEntity(request, type, unit);
        return sensorMapper.toDto(sensorRepository.save(sensor));
    }

    /**
     * Method returns a list of SensorResponseDto.
     *
     * @return a list of {@link SensorResponseDto}.
     */
    @Transactional(readOnly = true)
    public List<SensorResponseDto> findAllSensors() {
        return sensorMapper.toDtoList(sensorRepository.findAll());
    }

    /**
     * Method delete sensor by id.
     */
    public void deleteSensor(Long sensorId) {
        sensorRepository.deleteById(sensorId);
    }

    /**
     * Method updates current Sensor by id.
     *
     * @param sensorId id of {@link Sensor}.
     * @param request  SensorRequestDto information.
     * @return an instance of {@link SensorResponseDto}.
     */
    public SensorResponseDto updateSensor(Long sensorId, SensorRequestDto request) {
        commonDatabaseValidator.validate(context -> {
            context.setSensorTypeId(request.getSensorTypeId());
            context.setSensorUnitId(request.getSensorUnitId());
        });

        Sensor sensor = sensorRepository.getReferenceById(sensorId);
        SensorType type =
            sensorTypeRepository.getReferenceById(request.getSensorTypeId());
        SensorUnit unit =
            sensorUnitRepository.getReferenceById(request.getSensorUnitId());
        return sensorMapper.toDto(sensorMapper.updateEntity(sensor, request, type, unit));
    }
}
