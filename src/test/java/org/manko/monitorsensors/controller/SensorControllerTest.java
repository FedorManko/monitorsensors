package org.manko.monitorsensors.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.manko.monitorsensors.util.HeaderUtils.ADMIN_USERNAME;
import static org.manko.monitorsensors.util.HeaderUtils.emailHeader;
import static org.manko.monitorsensors.util.RandomUtils.RANDOM;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.manko.monitorsensors.dto.request.RangeDto;
import org.manko.monitorsensors.dto.request.SensorRequestDto;
import org.manko.monitorsensors.dto.response.SensorResponseDto;
import org.manko.monitorsensors.service.SensorService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(SensorController.class)
class SensorControllerTest extends AbstractControllerTest {

    private static final String PATH = "/api/v1/sensors";

    @MockBean
    private SensorService sensorService;

    @Test
    @WithMockUser(ADMIN_USERNAME)
    @DisplayName("Should display all sensors")
    void findAllSensors() throws Exception {
        SensorResponseDto response = RANDOM.nextObject(SensorResponseDto.class);
        when(sensorService.findAllSensors(anyString(), anyString())).thenReturn(List.of(response));

        this.mockMvc.perform(get(PATH)
                .headers(emailHeader())
                .param("searchTerm", "text")
            )
            .andDo(print())
            .andExpectAll(
                status().isOk(),
                jsonPath("$.[0].id").value(response.getId()),
                jsonPath("$.[0].name").value(response.getName())
            );

        assertAll(
            () -> verify(sensorService).findAllSensors(anyString(), anyString()),
            () -> verifyNoMoreInteractions(sensorService)
        );
    }

    @Test
    @WithMockUser(ADMIN_USERNAME)
    @DisplayName("Should delete sensor sensors")
    void deleteSensor() throws Exception {
        doNothing().when(sensorService).deleteSensor(anyLong(), anyString());

        this.mockMvc.perform(delete(PATH + "/{sensorId}", 1)
                .headers(emailHeader())
                .with(csrf())
            )
            .andDo(print())
            .andExpectAll(
                status().isNoContent()
            );

        assertAll(
            () -> verify(sensorService).deleteSensor(anyLong(), anyString()),
            () -> verifyNoMoreInteractions(sensorService)
        );
    }

    @Test
    @WithMockUser(ADMIN_USERNAME)
    @DisplayName("Should create sensor sensors")
    void createSensor() throws Exception {
        SensorRequestDto request = RANDOM.nextObject(SensorRequestDto.class);
        RangeDto rangeDto = new RangeDto();
        rangeDto.setFrom(5);
        rangeDto.setTo(10);
        request.setRange(rangeDto);
        String requestBody = objectMapper.writeValueAsString(request);
        SensorResponseDto response = RANDOM.nextObject(SensorResponseDto.class);

        when(sensorService.createSensor(any(SensorRequestDto.class), anyString()))
            .thenReturn(response);

        var requestBuilder = MockMvcRequestBuilders.post(PATH)
            .with(csrf())
            .headers(emailHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody);

        this.mockMvc.perform(requestBuilder)
            .andDo(print())
            .andExpectAll(
                status().isCreated(),
                jsonPath("$.id").value(response.getId()),
                jsonPath("$.name").value(response.getName())
            );

        assertAll(
            () -> verify(sensorService).createSensor(any(SensorRequestDto.class), anyString()),
            () -> verifyNoMoreInteractions(sensorService)
        );
    }

    @Test
    @WithMockUser(ADMIN_USERNAME)
    @DisplayName("Should update sensor sensors")
    void updateSensor() throws Exception {
        SensorRequestDto request = RANDOM.nextObject(SensorRequestDto.class);
        RangeDto rangeDto = new RangeDto();
        rangeDto.setFrom(5);
        rangeDto.setTo(10);
        request.setRange(rangeDto);
        String requestBody = objectMapper.writeValueAsString(request);
        SensorResponseDto response = RANDOM.nextObject(SensorResponseDto.class);

        when(sensorService.updateSensor(anyLong(), any(SensorRequestDto.class), anyString()))
            .thenReturn(response);

        var requestBuilder = MockMvcRequestBuilders.patch(PATH + "/{sensorId}", 1)
            .with(csrf())
            .headers(emailHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody);

        this.mockMvc.perform(requestBuilder)
            .andDo(print())
            .andExpectAll(
                status().isOk(),
                jsonPath("$.id").value(response.getId()),
                jsonPath("$.name").value(response.getName())
            );

        assertAll(
            () -> verify(sensorService)
                .updateSensor(anyLong(), any(SensorRequestDto.class), anyString()),
            () -> verifyNoMoreInteractions(sensorService)
        );
    }
}
