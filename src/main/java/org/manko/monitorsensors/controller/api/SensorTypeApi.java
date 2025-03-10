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
import org.manko.monitorsensors.dto.response.SensorTypeResponseDto;

/**
 * This is an interface that describes sensorType operation contracts.
 *
 * @author f.manko
 * @since 10.03.2024
 */
public interface SensorTypeApi {

    String API_TAG = "Sensor Type";

    /**
     * Method used to get all sensorUnit's.
     *
     * @return an instance of {@link SensorTypeResponseDto}.
     */
    @Operation(
        summary = "Get sensorType's information",
        tags = {API_TAG},
        description = "Retrieves data from db regarding sensorType's information"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = OK_CODE,
            description = "Retrieved sensorType's information",
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorTypeResponseDto.class),
                examples = @ExampleObject(
                    """
                        [
                          {
                            "id": 1,
                            "sensorType": "Pressure"
                          },
                          {
                            "id": 2,
                            "sensorType": "Voltage"
                          },
                          {
                            "id": 3,
                            "sensorType": "Temperature"
                          },
                          {
                            "id": 4,
                            "sensorType": "Humidity"
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
    List<SensorTypeResponseDto> findAllSensorTypes();

}
