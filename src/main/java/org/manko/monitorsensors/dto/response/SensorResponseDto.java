package org.manko.monitorsensors.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.manko.monitorsensors.dto.request.RangeDto;

/**
 * Data Transfer Object for SensorResponseDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorResponseDto {

    @Schema(example = "1", description = "Sensor id")
    private Long id;

    @Schema(example = "Sensor name", description = "Sensor name")
    private String name;

    @Schema(example = "Sensor model", description = "Sensor model")
    private String model;

    private RangeDto range;

    @Schema(example = "Temperature", description = "Sensor type")
    private String sensorType;

    @Schema(example = "%", description = "Sensor unit")
    private String sensorUnit;

    @Schema(example = "Kitchen", description = "Sensor location")
    private String location;

    @Schema(example = "Some description", description = "Sensor description")
    private String description;
}
