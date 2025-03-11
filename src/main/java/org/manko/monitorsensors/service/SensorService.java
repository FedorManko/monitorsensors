package org.manko.monitorsensors.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.entity.Customer;
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
@Transactional
@RequiredArgsConstructor
public class SensorService {

    private final SensorTypeRepository sensorTypeRepository;
    private final SensorUnitRepository sensorUnitRepository;
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;
    private final CommonDatabaseValidator commonDatabaseValidator;

    /**
     * Method returns an instance of SensorResponseDto.
     *
     * @param loggedInCustomerEmail {@link Customer}.
     * @param request               SensorRequestDto information.
     * @return an instance of {@link SensorResponseDto}.
     */
    public SensorResponseDto createSensor(
        SensorRequestDto request,
        String loggedInCustomerEmail
    ) {
        commonDatabaseValidator.validate(context -> {
            context.setSensorTypeId(request.getSensorTypeId());
            context.setSensorUnitId(request.getSensorUnitId());
            context.setLoggedInCustomerEmail(loggedInCustomerEmail);
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
     * @param loggedInCustomerEmail {@link Customer}.
     * @param searchTerm            search parameter.
     * @return a list of {@link SensorResponseDto}.
     */
    @Transactional(readOnly = true)
    public List<SensorResponseDto> findAllSensors(String loggedInCustomerEmail, String searchTerm) {
        validateEmail(loggedInCustomerEmail);
        return sensorMapper.toDtoList(sensorRepository.findAllWithSearch(searchTerm));
    }

    /**
     * Method delete sensor by id.
     *
     * @param sensorId              {@link Sensor} id.
     * @param loggedInCustomerEmail {@link Customer}.
     */
    public void deleteSensor(Long sensorId, String loggedInCustomerEmail) {
        validateEmail(loggedInCustomerEmail);
        sensorRepository.deleteById(sensorId);
    }

    /**
     * Method updates current Sensor by id.
     *
     * @param sensorId              id of {@link Sensor}.
     * @param request               SensorRequestDto information.
     * @param loggedInCustomerEmail {@link Customer}.
     * @return an instance of {@link SensorResponseDto}.
     */
    public SensorResponseDto updateSensor(
        Long sensorId,
        SensorRequestDto request,
        String loggedInCustomerEmail
    ) {
        commonDatabaseValidator.validate(context -> {
            context.setSensorTypeId(request.getSensorTypeId());
            context.setSensorUnitId(request.getSensorUnitId());
            context.setLoggedInCustomerEmail(loggedInCustomerEmail);
            context.setSensorId(sensorId);
        });

        Sensor sensor = sensorRepository.getReferenceById(sensorId);
        SensorType type =
            sensorTypeRepository.getReferenceById(request.getSensorTypeId());
        SensorUnit unit =
            sensorUnitRepository.getReferenceById(request.getSensorUnitId());
        return sensorMapper.toDto(sensorMapper.updateEntity(sensor, request, type, unit));
    }

    private void validateEmail(String loggedInCustomerEmail) {
        commonDatabaseValidator.validate(context ->
            context.setLoggedInCustomerEmail(loggedInCustomerEmail));
    }
}
