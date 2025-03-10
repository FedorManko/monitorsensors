package org.manko.monitorsensors.dto.request;

import static org.manko.monitorsensors.config.i18n.I18nMessages.SENSOR_DESCRIPTION_WRONG_SIZE;
import static org.manko.monitorsensors.config.i18n.I18nMessages.SENSOR_LOCATION_WRONG_SIZE;
import static org.manko.monitorsensors.config.i18n.I18nMessages.SENSOR_MODEL_WRONG_SIZE;
import static org.manko.monitorsensors.config.i18n.I18nMessages.SENSOR_NAME_IS_BLANK;
import static org.manko.monitorsensors.config.i18n.I18nMessages.SENSOR_NAME_WRONG_SIZE;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.manko.monitorsensors.validation.annotation.ValidRangeDto;

/**
 * Data Transfer Object for SensorRequestDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorRequestDto {

    @NotBlank(message = SENSOR_NAME_IS_BLANK)
    @Size(min = 3, max = 30, message = SENSOR_NAME_WRONG_SIZE)
    @Schema(example = "Sensor name", description = "Sensor name")
    private String name;

    @NotBlank(message = SENSOR_NAME_IS_BLANK)
    @Size(max = 15, message = SENSOR_MODEL_WRONG_SIZE)
    @Schema(example = "Sensor model", description = "Sensor model")
    private String model;

    @ValidRangeDto
    @Schema(example = "Sensor range parameters", description = "Sensor range parameters")
    private RangeDto range;

    @Schema(example = "1", description = "Sensor type id")
    private Long sensorTypeId;

    @Schema(example = "1", description = "Sensor unit id")
    private Long sensorUnitId;

    @Size(max = 40, message = SENSOR_LOCATION_WRONG_SIZE)
    @Schema(example = "Kitchen", description = "Sensor location")
    private String location;

    @Size(max = 200, message = SENSOR_DESCRIPTION_WRONG_SIZE)
    @Schema(example = "Some description", description = "Sensor description")
    private String description;
}
