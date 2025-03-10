package org.manko.monitorsensors.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.service.SensorService;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a class that describes entity rest controller for sensor.
 *
 * @author f.manko
 * @since 06.03.2025
 */
@RestController
@RequestMapping("/api/v1/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    @ResponseStatus(CREATED)
    public SensorResponseDto createSensor(@Valid @RequestBody SensorRequestDto request) {
        return sensorService.createSensor(request);
    }

    @GetMapping
    public List<SensorResponseDto> findAllSensors() {
        return sensorService.findAllSensors();
    }

    @DeleteMapping("/{sensorId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteSensor(@PathVariable Long sensorId) {
        sensorService.deleteSensor(sensorId);
    }

    @PatchMapping("/{sensorId}")
    public SensorResponseDto updateSensor(@PathVariable Long sensorId,
                                          @Valid @RequestBody SensorRequestDto request) {
        return sensorService.updateSensor(sensorId, request);
    }
}
