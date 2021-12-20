package dev.academy.academyFarms.farm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FarmConfig {

    @Bean
    CommandLineRunner commandLineRunner(FarmRepository repository) {
        return args -> {

        };
    }

}
