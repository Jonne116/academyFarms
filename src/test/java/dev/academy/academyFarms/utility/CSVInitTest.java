package dev.academy.academyFarms.utility;

import dev.academy.academyFarms.model.Farm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


class CSVInitTest {

    @Test
    @DisplayName("Should read csv files from directory and return List<Farm>")
    void CSVHelper() throws IOException {
        List<Farm> farmList = new ArrayList<Farm>();
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
        farmList.add(farm);
        farmList.add(farm1);

        Assertions.assertThat(CSVInit.CSVHelper("./csvTestFile"))
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(farmList);
    }

}