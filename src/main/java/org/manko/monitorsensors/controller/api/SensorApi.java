package org.manko.monitorsensors.controller.api;

import static org.manko.monitorsensors.controller.api.ApiConstants.CREATED;
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
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.entity.Customer;
import org.manko.monitorsensors.entity.Sensor;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * This is an interface that describes sensor operation contracts.
 *
 * @author f.manko
 * @since 10.03.2024
 */
public interface SensorApi {

    String API_TAG = "Sensor";

    /**
     * Method used to create sensor.
     *
     * @param loggedInCustomerEmail {@link Customer}.
     * @param request               SensorRequestDto information.
     * @return an instance of {@link SensorResponseDto}.
     */
    @Operation(
        summary = "Create sensor",
        tags = {API_TAG},
        description = "Create sensor with regarding information",
        requestBody = @RequestBody(
            description = "Body to Create",
            required = true,
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorRequestDto.class),
                examples = @ExampleObject("""
                    {
                      "name": "Sensor name",
                      "model": "Sensor model",
                      "range": {
                        "from": 10,
                        "to": 10
                      },
                      "sensorTypeId": 1,
                      "sensorUnitId": 1,
                      "location": "Kitchen",
                      "description": "Some description"
                    }
                    """
                )
            )
        )
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = CREATED,
            description = "Create sensor with regarding information",
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorResponseDto.class),
                examples = @ExampleObject(
                    """
                        {
                            "id": 1,
                            "name": "Sensor name",
                            "model": "Sensor model",
                            "range": {
                              "from": 10,
                              "to": 10
                            },
                            "sensorType": "Temperature",
                            "sensorUnit": "%",
                            "location": "Kitchen",
                            "description": "Some description"
                          }
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
    SensorResponseDto createSensor(
        String loggedInCustomerEmail,
        SensorRequestDto request
    );

    /**
     * Method used to get sensor's with search.
     *
     * @param loggedInCustomerEmail {@link Customer}.
     * @param searchTerm            search parameter.
     * @return a list of {@link SensorResponseDto}.
     */
    @Operation(
        summary = "Search for sensor",
        tags = {API_TAG},
        description = "Search for sensor by name, model"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = OK_CODE,
            description = "Search for sensor by name, model",
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorResponseDto.class),
                examples = @ExampleObject(
                    """
                        [
                             {
                               "id": 1,
                               "name": "Se sensor",
                               "model": "Z",
                               "range": {
                                 "from": 8,
                                 "to": 15
                               },
                               "sensorType": "Voltage",
                               "sensorUnit": "%",
                               "location": "kitchen",
                               "description": "description"
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
    List<SensorResponseDto> findAllSensors(
        String searchTerm,
        String loggedInCustomerEmail
    );

    /**
     * Method delete sensor by id.
     *
     * @param sensorId              {@link Sensor} id.
     * @param loggedInCustomerEmail {@link Customer}.
     */
    @Operation(
        summary = "Delete sensor by id",
        tags = {API_TAG},
        description = "Delete sensor by id"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = UNAUTHORIZED_CODE,
            description = UNAUTHORIZED_MESSAGE,
            content = @Content(schema = @Schema(hidden = true))),
        @ApiResponse(
            responseCode = FORBIDDEN_CODE,
            description = FORBIDDEN_MESSAGE,
            content = @Content(schema = @Schema(hidden = true)))
    })
    void deleteSensor(
        Long sensorId,
        String loggedInCustomerEmail
    );

    /**
     * Method used to create sensor.
     *
     * @param sensorId              id of {@link Sensor}.
     * @param request               SensorRequestDto information.
     * @param loggedInCustomerEmail {@link Customer}.
     * @return an instance of {@link SensorResponseDto}.
     */
    @Operation(
        summary = "Update existing sensor",
        tags = {API_TAG},
        description = "Update existing sensor by id",
        requestBody = @RequestBody(
            description = "Body to Update",
            required = true,
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorRequestDto.class),
                examples = @ExampleObject("""
                    {
                      "name": "Sensor name",
                      "model": "Sensor model",
                      "range": {
                        "from": 10,
                        "to": 10
                      },
                      "sensorTypeId": 1,
                      "sensorUnitId": 1,
                      "location": "Kitchen",
                      "description": "Some description"
                    }
                    """
                )
            )
        )
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = OK_CODE,
            description = "Update existing sensor id",
            content = @Content(
                mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = SensorResponseDto.class),
                examples = @ExampleObject(
                    """
                        {
                            "id": 1,
                            "name": "Sensor name",
                            "model": "Sensor model",
                            "range": {
                              "from": 10,
                              "to": 10
                            },
                            "sensorType": "Temperature",
                            "sensorUnit": "%",
                            "location": "Kitchen",
                            "description": "Some description"
                          }
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
    SensorResponseDto updateSensor(
        @PathVariable Long sensorId,
        SensorRequestDto request,
        String loggedInCustomerEmail
    );

}
