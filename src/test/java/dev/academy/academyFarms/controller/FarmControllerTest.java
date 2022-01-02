package dev.academy.academyFarms.controller;

import dev.academy.academyFarms.model.Farm;
import dev.academy.academyFarms.service.FarmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class FarmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmService farmService;

    @Test
    void shouldGetTypes() throws Exception {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("location", "New York");
        Farm farm = new Farm("New York", Instant.now(), "humidy", 1.11F);
        Farm farm2 = new Farm("New York", Instant.now(), "humidy", 1.22F);
        List<Farm> farmList = new ArrayList<>();
        farmList.add(farm);
        farmList.add(farm2);

        when(farmService.getFarms(parameters))
                .thenReturn(farmList);

        mockMvc.perform(get("/api/farm"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{location:New York},{}]"));
    }

    @Test
    void getFarms() {
    }
}