package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class JsonUpdater {

    public void jsonUpdateGson(String jsonFilePath, String propertyPath, String newValue) {
        try {
            // Cargar el archivo Json original
            JsonElement rootElement = JsonParser.parseReader(new FileReader(jsonFilePath));
            JsonObject rootObject = rootElement.getAsJsonObject();

            // Dividir la ruta de la propiedad en sus partes
            String[] pathParts = propertyPath.split("->");

            // Inicializar el objeto actual al que apuntamos
            JsonObject currentObject = rootObject;
            for (int i = 0; i < pathParts.length - 1; i++) {
                // Avanzar al siguiente objeto en la ruta. Se asume que todos los elementos intermedios son JsonObject
                JsonElement nextElement = currentObject.get(pathParts[i]);
                if (nextElement != null && nextElement.isJsonObject()) {
                    currentObject = nextElement.getAsJsonObject();
                } else {
                    throw new IllegalArgumentException("Path not found: " + propertyPath);
                }
            }

            // Actualizar la propiedad especificada con el nuevo valor
            currentObject.addProperty(pathParts[pathParts.length - 1], newValue);

            // Escribir de vuelta el archivo JSON actualizado
            try (FileWriter writer = new FileWriter(jsonFilePath)) {
                writer.write(rootObject.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void applyUpdate(Object obj, String path, String value) {
        try {
            String[] keys = path.split("->");
            Object current = obj;
            Field field = null;

            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                field = findField(current.getClass(), key);
                if (field == null) {
                    System.out.println("Campo no encontrado: " + key);
                    return;
                }

                field.setAccessible(true);

                if (i == keys.length - 1) {
                    // Asignar el valor en el último campo
                    field.set(current, value);
                } else {
                    // Navegar al siguiente nivel del objeto
                    Object next = field.get(current);
                    if (next == null) {
                        // Crear una nueva instancia si es nulo
                        next = field.getType().getDeclaredConstructor().newInstance();
                        field.set(current, next);
                    }
                    current = next;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Field findField(Class<?> clazz, String fieldName) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.getName().equalsIgnoreCase(fieldName))
                .findFirst()
                .orElse(null);
    }

}
