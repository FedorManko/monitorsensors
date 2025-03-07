package org.manko.monitorsensors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
