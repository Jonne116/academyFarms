package dev.academy.academyFarms.service;

import dev.academy.academyFarms.repository.FarmRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FarmServiceTest {

    private FarmRepository farmRepository = Mockito.mock(FarmRepository.class);

    @Test
    @DisplayName("Should get farms when passing parameters")
    void getFarms() {
        FarmService farmService = new FarmService(farmRepository);
        Mockito.when(farmRepository.findAllByParams())
    }

    @Test
    void getLocations() {
    }
}