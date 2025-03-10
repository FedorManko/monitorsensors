package org.manko.monitorsensors.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for SensorUnitResponseDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorUnitResponseDto {

    @Schema(example = "1", description = "Sensor unit id")
    private Long id;

    @Schema(example = "%", description = "Sensor unit")
    private String sensorUnit;
}
