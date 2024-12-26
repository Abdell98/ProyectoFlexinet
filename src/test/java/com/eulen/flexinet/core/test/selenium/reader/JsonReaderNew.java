package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import org.openqa.selenium.NotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class JsonReaderNew {

    @Getter
    private TestDatos datos; //TODO: cambiar nombre a DatosPedidos
    @Getter
    private TestDatosContrato datosContrato;
    @Getter
    private TestDatosPartesDeHoras datosPartesDeHoras;
    @Getter
    private TestDatosGestionDeEmpresaCliente datosGestionEmpresaCliente;
    @Getter
    private TestDatosConsultaAvanzadaDePartesDeHoras datosConsultaAvanzadaDePartesDeHoras;
    @Getter
    private TestDatosInformeDigitalParaCierreDeNomina datosInformeDigitalParaCierreDeNomina;
    @Getter
    private TestDatosFacturacion datosFacturacion;
    @Getter
    private TestDatosGeneracionMasivaPartes datosGeneracionMasivaPartes;
    @Getter
    private TestDatosGestionITs datosGestionITs;

    //private TestDatosOtraPagina datosOtraPagina;

//    private Gson gson = new Gson();
    //INFO: @MODGIO01 detalles en joplin
    private Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Pretty printing para formato legible

    //TODO @MODGIO01 borrar este texto si el nuevo metodo funciona OK
//    public void leerJson(String path) {
//        //Crear una instancia de Gson
//        Gson gson = new Gson();
//
//        // Especificar el tipo de dato que Gson espera deserializar.
//
//        try (FileInputStream fileInputStream = new FileInputStream(path)) {
//            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datos = gson.fromJson(reader, TestDatos.class); //TODO: cambiar nombre a DatosPedidos
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosContrato = gson.fromJson(reader, TestDatosContrato.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosPartesDeHoras = gson.fromJson(reader, TestDatosPartesDeHoras.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosGestionEmpresaCliente = gson.fromJson(reader, TestDatosGestionDeEmpresaCliente.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosConsultaAvanzadaDePartesDeHoras = gson.fromJson(reader, TestDatosConsultaAvanzadaDePartesDeHoras.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosInformeDigitalParaCierreDeNomina = gson.fromJson(reader, TestDatosInformeDigitalParaCierreDeNomina.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosFacturacion = gson.fromJson(reader, TestDatosFacturacion.class);
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosGestionITs = gson.fromJson(reader, TestDatosGestionITs.class);
//
//
//            //INFO: en el caso de configurar otro fichero de datos descomentar y ajustar
//            fileInputStream.getChannel().position(0);
//            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            datosGeneracionMasivaPartes = gson.fromJson(reader, TestDatosGeneracionMasivaPartes.class);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new NotFoundException("Archivo no encontrado", e);
//        }
//    }

    //INFO: @MODGIO01 detalles en joplin
    /**
     *
     * @param input
     */
    public void leerJson(String input) {
//        Gson gson = new Gson();

        //Se divide la cadena por el primer ; que aparece, en 2 partes
        String[] parts = input.split(";", 2);

        //La primera parte que es la ruta del json se guarda en path
        String path = parts[0];

        //Parts viene con mas de 1 elemento, es decir si vienen updates en el example, la parte 2 se guarda en una lista por tantos elementos haya delimitados por ;
        List<String> updates = parts.length > 1 ? Arrays.asList(parts[1].split(";")) : new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datos = gson.fromJson(reader, TestDatos.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosContrato = gson.fromJson(reader, TestDatosContrato.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosPartesDeHoras = gson.fromJson(reader, TestDatosPartesDeHoras.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosGestionEmpresaCliente = gson.fromJson(reader, TestDatosGestionDeEmpresaCliente.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosConsultaAvanzadaDePartesDeHoras = gson.fromJson(reader, TestDatosConsultaAvanzadaDePartesDeHoras.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosInformeDigitalParaCierreDeNomina = gson.fromJson(reader, TestDatosInformeDigitalParaCierreDeNomina.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosFacturacion = gson.fromJson(reader, TestDatosFacturacion.class);

            // Repite el proceso para otras estructuras...
            fileInputStream.getChannel().position(0);
            reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            datosGestionITs = gson.fromJson(reader, TestDatosGestionITs.class);


            // Aplica las actualizaciones a cada estructura
            for (String update : updates) {
                String[] updateParts = update.split(":", 2);
                if (updateParts.length == 2) {
                    String pathToField = updateParts[0];
                    String value = updateParts[1];

                    JsonUpdater.applyUpdate(datos, pathToField, value);
                    JsonUpdater.applyUpdate(datosContrato, pathToField, value);
                    JsonUpdater.applyUpdate(datosPartesDeHoras, pathToField, value);
                    JsonUpdater.applyUpdate(datosGestionEmpresaCliente, pathToField, value);
                    JsonUpdater.applyUpdate(datosConsultaAvanzadaDePartesDeHoras, pathToField, value);
                    JsonUpdater.applyUpdate(datosInformeDigitalParaCierreDeNomina, pathToField, value);
                    JsonUpdater.applyUpdate(datosFacturacion, pathToField, value);
                    JsonUpdater.applyUpdate(datosGestionITs, pathToField, value);
                    // Aplica a otras estructuras según sea necesario...

                }
            }

            // Guardar los cambios en el archivo JSON
           // guardarJson(path, datos);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Archivo no encontrado", e);
        }
    }

    //INFO: @MODGIO01 detalles en joplin
    private void guardarJson(String path, Object obj) {
        try (FileWriter writer = new FileWriter(path, StandardCharsets.UTF_8)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el archivo JSON", e);
        }
    }

    //INFO: @MODGIO01 detalles en joplin
    /**
     *
     * @param rutaArchivo
     * @param rutaJson
     * @return
     */
    public Map<String, String> convertirTablaAMapDesdeJson(String rutaArchivo, String rutaJson) {
        Gson gson = new Gson();
        // Leer el contenido del archivo JSON en una estructura JsonElement
        try (FileInputStream fileInputStream = new FileInputStream(rutaArchivo)) {
            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

            // Navegar en el JSON según la ruta proporcionada
            String[] partesRuta = rutaJson.split("->");
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (int i = 1; i < partesRuta.length; i++) { // Comenzar en 1 porque 0 es el nombre de la clase
                jsonObject = jsonObject.getAsJsonObject(partesRuta[i]);
            }

            // Convertir el objeto JSON final a un mapa
            return convertirJsonObjectAMap(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private Map<String, String> convertirJsonObjectAMap(JsonObject jsonObject) {
        Map<String, String> mapa = new HashMap<>();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            JsonElement value = entry.getValue();
            // Asumir que todos los valores son primitivos o strings para simplificación
            if (!value.isJsonNull()) {
                mapa.put(entry.getKey(), value.getAsString());
            }
        }
        return mapa;
    }
}

