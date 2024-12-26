package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionCentroDeTrabajoQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class GestionCentrosDeTrabajoServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionCentrosDeTrabajoServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void guardarCSVconDatosActualesDeCentroDeTrabajo(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------ESCRIBIENDO-CSV-ANTES-DE-GUARDAR-----------------");
        System.out.println("Registramos los centros de trabajo encontrado en el csv...");

        this.jsonFile("datosLogin.json");
        String user = loginData.getUser();

        commonService.getJsonFileData(scn,page,file);
        String[] idcliente = gestionCentrosDeTrabajoData.getClienteContrato().split(" ",2);

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionCentroDeTrabajoQuery.getConsulta(idcliente[0], user)
        );

        if(rows.size() < 1) {
            System.out.println("INFO: No hay resultados en la tabla cliente contrato...");
            writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".centrosdetrabajo.csv");
            return;
        }
        // Esto es para quitar los espacios de todos los valores del mapa
        for (Map<String, Object> row : rows) {
            for(Map.Entry<String, Object> column : row.entrySet()) {
                if(column.getValue() != null) {
                    column.setValue(column.getValue().toString().trim());
                }
            }
        }

        writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".centrosdetrabajo.csv");
    }

    public void confirmarDespuesDeGuardarSiHayNuevasEntidadesCentroDeTrabajo(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------LEYENDO-CSV-DESPUES-DE-GUARDAR----------------");
        System.out.println("Leemos el csv y lo comparamos con los resultados de la query para saber si se ha creado algún centro nuevo...");

        this.jsonFile("datosLogin.json");
        String user = loginData.getUser();

        commonService.getJsonFileData(scn,page,file);
        String[] idCliente = gestionCentrosDeTrabajoData.getClienteContrato().split(" ",2);

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionCentroDeTrabajoQuery.getConsulta(idCliente[0], user)
        );

        if(rows.size() < 1) {
            switch (scn) {//@scenarios
                case "AltaCentroDeTrabajoEnvioKO":
                    System.out.println("PASS: No se ha creado ningún centro de trabajo, dado que hubo un error...");
                    return;
                case "AltaCentroDeTrabajoEnvioOK":
                    throw new AssertionError("FAIL: la query no ha devuelto ningun resultado, por lo que no se ha registrado el centro de trabajo cuando si debería...");
            }
        } else {
            boolean tableHasMoreRecordsThanCsv = rows.size() > countSizeInCSV(page  + "/" + scn + "/"+ file +".centrosdetrabajo.csv");
            boolean tableHasLessRecordsThanCsv = rows.size() < countSizeInCSV(page  + "/" + scn + "/"+ file +".centrosdetrabajo.csv");
            boolean tableHasEqualRecordsThanCsv = rows.size() == countSizeInCSV(page  + "/" + scn + "/"+ file +".centrosdetrabajo.csv");

            if(tableHasMoreRecordsThanCsv) {
                switch (scn) {//@scenarios
                    case "AltaCentroDeTrabajoEnvioKO":
                        throw new AssertionError("FAIL: se ha encontrado un centro de trabajo cuando no debería...");
                    case "AltaCentroDeTrabajoEnvioOK":
                        String idCentro = "";
                        try {
                            idCentro = rows.get(0).get("ID_CEN").toString();
                        } catch (Exception e) {
                            throw new NullPointerException("ERROR: El ID_CEN es null lo cual no debería ser, analizar el motivo...");
                        }
                        System.out.println("PASS: Se ha encontrado el nuevo centro de trabajo `"+idCentro+"` para el cliente `"+idCliente+"`...");
                }
            } else if (tableHasLessRecordsThanCsv) {
                throw new AssertionError("FAIL: La tabla tiene menos filas que el CSV, analizar el problema...");
            } else if (tableHasEqualRecordsThanCsv) {
                switch (scn) {
                    case "AltaCentroDeTrabajoEnvioKO":
                        System.out.println("PASS: Ha ocurrido un error y por lo tanto no se ha creado un nuevo centro de trabajo correctamente.");
                        break;
                    case "AltaCentroDeTrabajoEnvioOK":
                        throw new AssertionError("FAIL: No se han detectado nuevos centros de trabajo.");
                }
            }
        }

    }


}
