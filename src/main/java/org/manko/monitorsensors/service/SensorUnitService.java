package org.manko.monitorsensors.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.mapper.SensorUnitMapper;
import org.manko.monitorsensors.repository.SensorUnitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is a class that describes service that provides entity crud operations for SensorUnit.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorUnitService {

    private final SensorUnitMapper sensorUnitMapper;
    private final SensorUnitRepository sensorUnitRepository;

    /**
     * Method returns a list of SensorUnitResponseDto.
     *
     * @return a list of {@link SensorUnitResponseDto}.
     */
    public List<SensorUnitResponseDto> findAllSensorUnits() {
        return sensorUnitMapper.toDtoList(sensorUnitRepository.findAll());
    }
}
