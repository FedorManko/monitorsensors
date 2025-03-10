package org.manko.monitorsensors.exception;


import java.time.Instant;
import java.util.Map;

/**
 * This is a class, that represents the common error model for REST exceptions.
 *
 * @author f.manko
 * @since 09.03.2025
 */
public record RestError(
    String requestUri,
    String method,
    Instant timestamp,
    String message,
    Map<String, Object> meta
) {

}
