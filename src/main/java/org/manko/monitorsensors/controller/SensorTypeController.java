package org.manko.monitorsensors.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.controller.api.SensorTypeApi;
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;
import org.manko.monitorsensors.service.SensorTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a class that describes entity rest controller for sensor type.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@RestController
@RequestMapping("/api/v1/sensors/types")
@RequiredArgsConstructor
public class SensorTypeController implements SensorTypeApi {

    private final SensorTypeService sensorTypeService;

    @Override
    @GetMapping
    public List<SensorTypeResponseDto> findAllSensorTypes() {
        return sensorTypeService.findAllSensorTypes();
    }

}
