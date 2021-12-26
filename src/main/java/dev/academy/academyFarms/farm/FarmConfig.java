package dev.academy.academyFarms.farm;

import dev.academy.academyFarms.CSVInit;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FarmConfig {

    @Bean
    ApplicationRunner runner(FarmRepository farmRepository) {
        return (arg) -> farmRepository.saveAll(CSVInit.CSVHelper());
    }
}


