package dev.academy.academyFarms.controller;

import dev.academy.academyFarms.model.Farm;
import dev.academy.academyFarms.service.FarmService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(controllers = FarmController.class)
class FarmControllerTest {

    @MockBean
    private FarmService farmService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/farm?location=Friman Metsola collective should return list of farms")
    void getFarms() throws Exception {

        Farm farm = new Farm(
                "Friman Metsola collective",
                Instant.parse("2018-12-31T22:00:00.000Z"),
                "pH",
                6.52F
        );

        Farm farm1 = new Farm(
                "Friman Metsola collective",
                Instant.parse("2018-12-31T22:00:00.000Z"),
                "rainFall",
                2.6F
        );

        Map<String, String> parameter = new HashMap<>();
        parameter.put("location", "Friman Metsola collective");


        Mockito.when(farmService.getFarms(parameter)).thenReturn(Arrays.asList(farm, farm1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/farm?location=Friman Metsola collective"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].location").value("Friman Metsola collective"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sensorType").value("pH"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].value").value(6.52));
    }
}