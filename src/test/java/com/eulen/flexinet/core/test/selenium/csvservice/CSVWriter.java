package com.eulen.flexinet.core.test.selenium.csvservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class CSVWriter {
    public static void writeDataToCSV(List<Map<String, Object>> data, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            if(!data.isEmpty()) {
                // Escribir los encabezados
                StringJoiner headerJoiner = new StringJoiner("\t");
                data.get(0).keySet().forEach(headerJoiner::add);
                fileWriter.write(headerJoiner.toString() + "\n");

                // Escribir los datos
                for (Map<String, Object> row : data) {
                    StringJoiner rowJoiner = new StringJoiner("\t");
                    row.values().stream()
                            .map(value -> value == null ? "" : value.toString())
                            .forEach(rowJoiner::add);
                    fileWriter.write(rowJoiner.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
