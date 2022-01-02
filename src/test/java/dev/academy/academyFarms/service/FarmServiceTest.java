package dev.academy.academyFarms.service;

import dev.academy.academyFarms.model.Farm;
import dev.academy.academyFarms.repository.FarmRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.*;

public class FarmServiceTest {

    private final FarmRepository farmRepository = Mockito.mock(FarmRepository.class);
    FarmService farmService = new FarmService(farmRepository);

    @Test
    @DisplayName("Should get location and sensorType lists")
    void getLocations() {

        Mockito.when(farmRepository.getLocations()).thenReturn(new ArrayList<>(Collections.singleton("New York")));
        Mockito.when(farmRepository.getSensorTypes()).thenReturn(new ArrayList<>(Collections.singleton("humidity")));

        Farm farm = new Farm("New York", Instant.now(), "humidity", 25.11F);
        Map<String, List<String>> result = new HashMap<>();
        result.put("location", farmRepository.getLocations());
        result.put("sensorType", farmRepository.getSensorTypes());

        Assertions.assertThat(farmService.getLocationsSensors()).isEqualTo(result);
    }
}