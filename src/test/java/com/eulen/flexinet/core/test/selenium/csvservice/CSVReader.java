package com.eulen.flexinet.core.test.selenium.csvservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class CSVReader {
    public static String getValueFromCSV(String filePath, String columnName, int rowIndex) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Lee los encabezados
            if(line == null) {
                return null;
            }
            String[] headers = line.split("\t");

            // Encuentra el indice de la columna por su nombre
            int columnIndex = Arrays.asList(headers).indexOf(columnName);
            if(columnIndex == -1) {
                throw new IllegalArgumentException("Column not found: " + columnName);
            }

            // Recorre las filas hasta encontrar el indice deseado
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine == rowIndex) {
                    String[] values = line.split("\t");
                    return values[columnIndex];
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("ERROR: No se ha encontrado el CSV..." + e);
        }
        return null; // Retorna null si no se encuentra el valor
    }

    public static int countSizeInCSV(String filePath) throws IOException {
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Lee los encabezados

            while (br.readLine() != null) {
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("ERROR: No se ha encontrado el CSV..." + e);
        }
        return rowCount;
    }
}
