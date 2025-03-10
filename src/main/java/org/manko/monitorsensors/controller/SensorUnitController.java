package org.manko.monitorsensors.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.controller.api.SensorUnitApi;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;
import org.manko.monitorsensors.service.SensorUnitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a class that describes entity rest controller for sensor unit.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@RestController
@RequestMapping("/api/v1/sensors/units")
@RequiredArgsConstructor
public class SensorUnitController implements SensorUnitApi {

    private final SensorUnitService sensorUnitService;

    @Override
    @GetMapping
    public List<SensorUnitResponseDto> findAllSensorUnits() {
        return sensorUnitService.findAllSensorUnits();
    }

}
