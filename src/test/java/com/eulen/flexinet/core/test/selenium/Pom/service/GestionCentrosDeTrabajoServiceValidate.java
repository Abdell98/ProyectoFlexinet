package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionCentroDeTrabajoQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class GestionCentrosDeTrabajoServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionCentrosDeTrabajoServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void validateTipoVia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        String dato = "";

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TIPOVIA,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getTipoVia(),
                isRequired
        );
    }

    public void validateConvColectivoEmpresaUsuaria(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CONVCOLECTIVOEMPRESAUSUARIA2, //esto cambia a diferencia del shared
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getConvColectivoEmpresaUsuaria(),
                isRequired
        );
    }

    public void validateNombreEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getNombreEmpresa(),
                isRequired
        );
    }

    public void validateNombreDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getNombreDireccion(),
                isRequired
        );
    }

    public void validateMedioDeCaptacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPTACION,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getMedioDeCaptacion(),
                isRequired
        );
    }

    public void validateDiasFijosDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASFIJOSDEPAGO,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getDiasFijosDePago(),
                isRequired
        );
    }

    public void validateDespuesDeGuardarSiHayNuevasEntidadesCentro(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------LEYENDO-CSV-DESPUES-DE-GUARDAR----------------");
        System.out.println("Leemos el csv y lo comparamos con los resultados de la query para saber si se ha creado algún centro nuevo...");

        this.jsonFile("datosLogin.json");
        String user = loginData.getUser();

        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionCentroDeTrabajoQuery.getConsulta(nif, user)
        );

        if(rows.size() > 1) {
            throw new AssertionError("FAIL: Se ha encontrado mas de un cliente contrato para la oficina, lo cual no debería ocurrir, analizar el motivo");
        }

        if(rows.size() < 1) {
            switch (scn) {//@scenarios
                case "AltaCentroDeTrabajoEnvioKO":
                    System.out.println("PASS: No se ha creado ningún cliente contrato, dado que hubo un error...");
                    return;
                case "AltaCentroDeTrabajoEnvioOK":
                    throw new AssertionError("FAIL: la query no ha devuelto ningun resultado, por lo que no se ha registrado el cliente contrato cuando si debería...");
            }
        } else {
            boolean tableHasMoreRecordsThanCsv = rows.size() > countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");
            boolean tableHasLessRecordsThanCsv = rows.size() < countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");
            boolean tableHasEqualRecordsThanCsv = rows.size() == countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");

            if(tableHasMoreRecordsThanCsv) { //Esto solo quiere decir que en vez de 0 habrá 1 si hay mas de uno dará error antes
                switch (scn) {//@scenarios
                    case "AltaCentroDeTrabajoEnvioKO":
                        throw new AssertionError("FAIL: se ha encontrado un cliente contrato cuando no debería...");
                    case "AltaCentroDeTrabajoEnvioOK":
                        String numCliente = "";
                        try {
                            numCliente = rows.get(0).get("NUMERO_CLIENTE").toString();
                        } catch (Exception e) {
                            throw new NullPointerException("ERROR: El ID_CLIENTE es null lo cual no debería ser, analizar el motivo...");
                        }
                        System.out.println("PASS: Se ha encontrado el nuevo cliente contrato `"+numCliente+"` para la oficina `"+oficina+"`...");
                }
            } else if (tableHasLessRecordsThanCsv) {
                throw new AssertionError("FAIL: La tabla tiene menos filas que el CSV, analizar el problema...");
            } else if (tableHasEqualRecordsThanCsv) {
                /** Posible supuestos del siguiente error:
                 * 1. El botón alta cliente contrato estaba activo a pesar de que la query devolvio un cliente contrato existente para la oficina.
                 * 2. El csv no se ha sobre escrito antes de guardar, por algun problema que hay que analizar.
                 */
                throw new AssertionError("FAIL: Se he detectado que ya existia un registro en el CSV cuando debería estar vacio...");
            }
        }

    }


    public void validateAntesDeGuardarCSVconDatosActualesDeClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------ESCRIBIENDO-CSV-ANTES-DE-GUARDAR-----------------");
        System.out.println("Registramos los centros de trabajo encontrado en el csv...");

        this.jsonFile("datosLogin.json");
        String user = loginData.getUser();

        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionCentroDeTrabajoQuery.getConsulta(nif, user)
        );

        if(rows.size() > 1) {
            throw new AssertionError("FAIL: Se ha encontrado mas de un cliente contrato para la oficina, lo cual no debería ocurrir.");
        }

        if(rows.size() < 1) {
            System.out.println("INFO: No hay resultados en la tabla cliente contrato...");
            writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".clientecontrato.csv");
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

        writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".clientecontrato.csv");
    }


}
