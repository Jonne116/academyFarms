package dev.academy.academyFarms;

import dev.academy.academyFarms.farm.Farm;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CSVInit {

     public static @NotNull List<Farm> CSVHelper() throws IOException, NumberFormatException {

        String[] files = new File("./sourceFiles").list();
        List<Farm> farmList = new ArrayList<>();

        assert files != null;
        for (String file : files) {
            BufferedReader reader = Files.newBufferedReader(Paths.get("./sourceFiles/" + file));

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("location", "dateTime", "sensorType", "value")
                    .withIgnoreHeaderCase().withSkipHeaderRecord().withIgnoreEmptyLines().withTrim());

            for (CSVRecord csvRecord : csvParser) {

                try {
                    Farm farm = new Farm(
                            csvRecord.get("location"),
                            Instant.parse(csvRecord.get("dateTime")),
                            csvRecord.get("sensorType"),
                            Float.parseFloat(csvRecord.get("value"))
                    );

                    switch (farm.getSensorType().toLowerCase()) {
                        case "ph":
                            if (farm.getValue() >= 0 && farm.getValue() <= 14) {
                                farmList.add(farm);
                            }
                            break;
                        case "temperature":
                            if (farm.getValue() >= -50 && farm.getValue() <= 100) {
                                farmList.add(farm);
                            }
                            break;
                        case "rainfall":
                            if (farm.getValue() >= 0 && farm.getValue() <= 500) {
                                farmList.add(farm);
                            }
                            break;
                        default:
                            throw new Exception();
                    }
                }
                catch (Exception e) {
                    System.out.println("ERROR in File: " + file + " Line: " + (csvRecord.getRecordNumber() + 1));
                }
            }
        }
        return farmList;
    }
}

