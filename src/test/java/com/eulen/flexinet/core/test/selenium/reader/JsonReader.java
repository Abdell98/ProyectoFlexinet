package com.eulen.flexinet.core.test.selenium.reader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.NotFoundException;

public class JsonReader {

    private LoginData loginData;

    //TODO: borrar la siguiente linea luego de probar GestionEmpresaCliente
    //private GestionEmpresaClienteData gestionEmpresaClienteData;
    private GestionClientesContratoData gestionClientesContratoData;
    private GestionCentrosDeTrabajoData gestionCentrosDeTrabajoData;

    public JsonReader(String filePath) {
        Gson gson = new Gson();
        try (InputStream inputStream = new FileInputStream(filePath);

        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            //@data
            this.loginData = gson.fromJson(jsonObject, LoginData.class);
            //TODO: borrar la siguiente linea luego de probar GestionEmpresaCliente
            //this.gestionEmpresaClienteData = gson.fromJson(jsonObject, GestionEmpresaClienteData.class);
            this.gestionClientesContratoData = gson.fromJson(jsonObject, GestionClientesContratoData.class);
            this.gestionCentrosDeTrabajoData = gson.fromJson(jsonObject, GestionCentrosDeTrabajoData.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new NotFoundException("Archivo no encontrado", e);
        }
    }

    public LoginData getData() {
        return this.loginData;
    }

    //TODO: borrar la siguiente linea luego de probar GestionEmpresaCliente
//    public GestionEmpresaClienteData getGestionEmpresaClienteData() {
//        return this.gestionEmpresaClienteData;
//    }

    public GestionClientesContratoData getGestionClientesContratoData() {
        return this.gestionClientesContratoData;
    }

    public GestionCentrosDeTrabajoData gestionCentrosDeTrabajoData() {
        return this.gestionCentrosDeTrabajoData;
    }

}

