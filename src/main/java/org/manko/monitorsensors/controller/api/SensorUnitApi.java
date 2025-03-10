package org.manko.monitorsensors.controller.api;

import static org.manko.monitorsensors.controller.api.ApiConstants.FORBIDDEN_CODE;
import static org.manko.monitorsensors.controller.api.ApiConstants.FORBIDDEN_MESSAGE;
import static org.manko.monitorsensors.controller.api.ApiConstants.OK_CODE;
import static org.manko.monitorsensors.controller.api.ApiConstants.UNAUTHORIZED_CODE;
import static org.manko.monitorsensors.controller.api.ApiConstants.UNAUTHORIZED_MESSAGE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.manko.monitorsensors.dto.response.SensorUnitResponseDto;

/**
 * This is an interface that describes sensorUnit operation contracts.
 *
 * @author f.manko
 * @since 10.03.2024
 */
public interface SensorUnitApi {

    String API_TAG = "Sensor Unit";

    /**
     * Method used to get all sensorUnit's.
     *
     * @return an instance of {@link SensorUnitResponseDto}.
     */
    @Operation(
        summary = "Get sensorUnit's information",
        tags = {API_TAG},
        description = "Retrieves data from db regarding sensorUnit's information"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = OK_CODE,
            description = "Retrieved sensorUnit's information",
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorUnitResponseDto.class),
                examples = @ExampleObject(
                    """
                        [
                           {
                             "id": 1,
                             "sensorUnit": "voltage"
                           },
                           {
                             "id": 2,
                             "sensorUnit": "°С"
                           },
                           {
                             "id": 3,
                             "sensorUnit": "%"
                           },
                           {
                             "id": 4,
                             "sensorUnit": "bar"
                           }
                         ]
                        """
                )
            )),
        @ApiResponse(
            responseCode = UNAUTHORIZED_CODE,
            description = UNAUTHORIZED_MESSAGE,
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = FORBIDDEN_CODE,
            description = FORBIDDEN_MESSAGE,
            content = @Content(schema = @Schema(hidden = true)))
    })
    List<SensorUnitResponseDto> findAllSensorUnits();

}
