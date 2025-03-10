package org.manko.monitorsensors.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.mapper.SensorTypeMapper;
import org.manko.monitorsensors.repository.SensorTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a class that describes service that provides entity crud operations for SensorType.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorTypeService {

    private final SensorTypeMapper sensorTypeMapper;
    private final SensorTypeRepository sensorTypeRepository;

    /**
     * Method returns a list of SensorTypeResponseDto.
     *
     * @return a list of {@link SensorTypeResponseDto}.
     */
    public List<SensorTypeResponseDto> findAllSensorTypes() {
        return sensorTypeMapper.toDtoList(sensorTypeRepository.findAll());
    }
}
