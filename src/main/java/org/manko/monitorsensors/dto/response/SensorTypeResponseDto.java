package org.manko.monitorsensors.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for SensorTypeResponseDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorTypeResponseDto {

    @Schema(example = "1", description = "Sensor type id")
    private Long id;

    @Schema(example = "Temperature", description = "Sensor type")
    private String sensorType;
}
