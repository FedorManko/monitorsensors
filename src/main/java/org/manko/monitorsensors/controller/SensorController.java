package org.manko.monitorsensors.controller;

import static org.manko.monitorsensors.config.security.CustomHttpHeaders.X_CUSTOMER_EMAIL_HEADER;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.manko.monitorsensors.config.security.access.AdminAccess;
import org.manko.monitorsensors.config.security.access.FullAccess;
import org.manko.monitorsensors.controller.api.SensorApi;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.service.SensorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class SensorController implements SensorApi {

    private final SensorService sensorService;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    @AdminAccess
    public SensorResponseDto createSensor(
        @RequestHeader(X_CUSTOMER_EMAIL_HEADER) String loggedInCustomerEmail,
        @Valid @RequestBody SensorRequestDto request) {
        return sensorService.createSensor(request, loggedInCustomerEmail);
    }

    @Override
    @GetMapping
    @FullAccess
    public List<SensorResponseDto> findAllSensors(
        @RequestParam(required = false) String searchTerm,
        @RequestHeader(X_CUSTOMER_EMAIL_HEADER) String loggedInCustomerEmail) {
        return sensorService.findAllSensors(loggedInCustomerEmail, searchTerm);
    }

    @Override
    @DeleteMapping("/{sensorId}")
    @ResponseStatus(NO_CONTENT)
    @AdminAccess
    public void deleteSensor(
        @PathVariable Long sensorId,
        @RequestHeader(X_CUSTOMER_EMAIL_HEADER) String loggedInCustomerEmail) {
        sensorService.deleteSensor(sensorId, loggedInCustomerEmail);
    }

    @Override
    @PatchMapping("/{sensorId}")
    @AdminAccess
    public SensorResponseDto updateSensor(
        @PathVariable Long sensorId,
        @Valid @RequestBody SensorRequestDto request,
        @RequestHeader(X_CUSTOMER_EMAIL_HEADER) String loggedInCustomerEmail) {
        return sensorService.updateSensor(sensorId, request, loggedInCustomerEmail);
    }
}
