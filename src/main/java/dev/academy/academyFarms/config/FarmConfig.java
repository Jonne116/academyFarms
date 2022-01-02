package dev.academy.academyFarms.config;

import dev.academy.academyFarms.utility.CSVInit;
import dev.academy.academyFarms.repository.FarmRepository;
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


