package org.manko.monitorsensors.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for RangeDto.
 *
 * @author f.manko
 * @since 09.03.2025
 */
@Getter
@Setter
@NoArgsConstructor
public class RangeDto {

    @Schema(example = "10", description = "Range from")
    private Integer from;

    @Schema(example = "10", description = "Range to")
    private Integer to;
}
