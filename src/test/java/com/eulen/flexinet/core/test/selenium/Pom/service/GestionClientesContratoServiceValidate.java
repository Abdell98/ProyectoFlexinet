package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionClienteContratoQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class GestionClientesContratoServiceValidate extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionClientesContratoServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void validateEjecutivoDeCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.EJECUTIVODECUENTA,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getEjecutivoDeCuenta(),
                isRequired
        );
    }

    public void validateMedioDeCapt(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPT,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getMedioDeCapt(),
                isRequired
        );
    }

    public void validateConvenio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CONVENIO,
                FieldType.input,
                cajaNumero,
                gestionClientesContratoData.getConvenio(),
                isRequired
        );
    }

    public void validateBoe(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.BOE,
                FieldType.input,
                cajaNumero,
                gestionClientesContratoData.getBOE(),
                isRequired
        );
    }

    public void validateTelefono(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELEFONO,
                FieldType.input,
                cajaNumero,
                gestionClientesContratoData.getTelefono(),
                isRequired
        );
    }

    public void validateClausuladoDelContratoLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCONTRATOLABORAL,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getClausuladoDelContratoLaboral(),
                isRequired
        );
    }

    public void validateClausuladoDelCPD(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCPD,
                FieldType.select,
                cajaNumero,
                gestionClientesContratoData.getClausuladoDelCPD(),
                isRequired
        );
    }

    public void validateObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                gestionClientesContratoData.getObservaciones(),
                isRequired
        );
    }
//TODO @REFACTOR @FIX @PRE
//    public void validateEntidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.ENTIDAD,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getEntidad(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateSucursal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.SUCURSAL,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getSucursal(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.DC,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getDC(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateNCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NCUENTA,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getNCuenta(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateIBANPais(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANPAIS,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANPais(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateIBANDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANDC,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANDC(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateIBANExtranjero(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.IBANEXTRANJERO,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getIBANExtranjero(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateTipo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.TIPO,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getTipo(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateNombreDireccionDeFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NOMBRE,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getNombreDireccionDeFactura(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateLocalidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.LOCALIDAD,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getLocalidad(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateProvincia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.PROVINCIA,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getProvincia(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateCP(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.CP,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getCP(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateDestinatario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.DESTINATARIO,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getDestinatario(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateVentas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.VENTAS,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getVentas(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void validateNEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.validateField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NEMPLEADOS,
//                FieldType.select,
//                cajaNumero,
//                gestionEmpresaClienteData.getNEmpleados(), //TODO: pasar a clientecontrato data
//                isRequired
//        );
//    }

    /** VALIDACIONES FINALES **/


    /**
     * Este metodo es utilizado por confirmarCambiosGuardadosEnTablaClienteContrato
     * @param scn
     * @param dataValue
     * @param column
     */
    public void compararValoresJsonContraBaseDatos(String scn, String dataValue, Map.Entry<String, Object> column, Boolean isRequired){
        System.out.println("Verificando...`" + column.getKey() + "`: `" + column.getValue().toString().trim() + "`");
        if(dataValue == null || dataValue.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("En el JSON el valor del campo está vacio o bien no existe...\n");
            } else {
                System.err.println("...SKIPED!!");
                return;
            }
        }
        // Si dataValue viene de el json, al comparar con DB si son iguales quiere decir que se ha registrado el cambio
        // Si dataValue viene del csv, al comparar con DB si son iguales quiere decir que no ha habido modificaciones
        Assert.assertEquals(dataValue,column.getValue().toString().trim());

        System.out.println("..."+column.getKey()+"...PASS!!!");
    }

    public void escribirAntesDeGuardarCSVconDatosActualesDeClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------ESCRIBIENDO-CSV-ANTES-DE-GUARDAR-----------------");
        System.out.println("Registramos el cliente contrato encontrado en el csv...");
        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionClienteContratoQuery.getConsulta(nif, oficina)
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

    public void confirmarDespuesDeGuardarSiHayNuevasEntidadesClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------LEYENDO-CSV-DESPUES-DE-GUARDAR----------------");
        System.out.println("Leemos el csv y lo comparamos con los resultados de la query para saber si se ha creado algún cliente contrato...");
        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionClienteContratoQuery.getConsulta(nif, oficina)
        );

        if(rows.size() > 1) {
            throw new AssertionError("FAIL: Se ha encontrado mas de un cliente contrato para la oficina, lo cual no debería ocurrir, analizar el motivo");
        }

        if(rows.size() < 1) {
            switch (scn) {
                case "AltaClienteContratoEnvioKO":
                    System.out.println("PASS: No se ha creado ningún cliente contrato, dado que hubo un error...");
                    return;
                case "AltaClienteContratoEnvioOK":
                    throw new AssertionError("FAIL: la query no ha devuelto ningun resultado, por lo que no se ha registrado el cliente contrato cuando si debería...");
            }
        } else {
            boolean tableHasMoreRecordsThanCsv = rows.size() > countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");
            boolean tableHasLessRecordsThanCsv = rows.size() < countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");
            boolean tableHasEqualRecordsThanCsv = rows.size() == countSizeInCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv");

            if(tableHasMoreRecordsThanCsv) { //Esto solo quiere decir que en vez de 0 habrá 1 si hay mas de uno dará error antes
                switch (scn) {
                    case "AltaClienteContratoEnvioKO":
                        throw new AssertionError("FAIL: se ha encontrado un cliente contrato cuando no debería...");
                    case "AltaClienteContratoEnvioOK":
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

    public void confirmarDespuesDeGuardarLaModificacionDelClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------CONFIRMANDO-CAMBIOS-GUARDADOS-EN-CLIENT_CONTRATO----------------");
        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionClienteContratoQuery.getConsulta(nif, oficina)
        );

        if(rows.size() > 1) {
            System.err.println("WARNING: Se ha encontrado mas de 1 compañia para el NIF "+ nif);
        }

        if(rows.size() < 1) {
            throw new AssertionError("ERROR: la query no ha devuelto resultados...");
        }

        commonService.getJsonFileData(scn,page,file+"."+ PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS);
        String ejecutivoDeCuenta = gestionClientesContratoData.getEjecutivoDeCuenta();
        String medioDeCapt = gestionClientesContratoData.getMedioDeCapt();
        String convenio = gestionClientesContratoData.getConvenio();
        String bOE = gestionClientesContratoData.getBOE();
        String telefono = gestionClientesContratoData.getTelefono();
        String clausuladoDelContratoLaboral = gestionClientesContratoData.getClausuladoDelContratoLaboral();
        String clausuladoDelCPD = gestionClientesContratoData.getClausuladoDelCPD();
        String observaciones = gestionClientesContratoData.getObservaciones();
        //INFO: Añadir nuevos campos aqui, si son campos de OTROSDATOSIDENTIFICATIVOS
        //TODO Pasar los data a cliente contrato o convertir gestionEmpresaClienteData en shared
        commonService.getJsonFileData(scn,page,file+"."+ PanelTitle.TAB_DATOSECONOMICOS);
        //TODO @REFACTOR @FIX @PRE
//        String entidad = gestionEmpresaClienteData.getEntidad();
//        String sucursal = gestionEmpresaClienteData.getSucursal();
//        String dc = gestionEmpresaClienteData.getDC();
//        String numeroCuenta = gestionEmpresaClienteData.getNCuenta();
//        String ibanPais = gestionEmpresaClienteData.getIBANPais();
//        String ibanDc = gestionEmpresaClienteData.getIBANDC();
//        String ibanExtranjero = gestionEmpresaClienteData.getIBANExtranjero();
//        String tipo = gestionEmpresaClienteData.getTipo();
//        String nombreDireccionDeFactura = gestionEmpresaClienteData.getNombreDireccionDeFactura();
//        String localidad = gestionEmpresaClienteData.getLocalidad();
//        String provincia = gestionEmpresaClienteData.getProvincia();
//        String cP = gestionEmpresaClienteData.getCP();
//        String destinatario = gestionEmpresaClienteData.getDestinatario();
        //INFO: Añadir nuevos campos aqui, si son campos de DATOSECONOMICOS

        commonService.getJsonFileData(scn,page,file+"."+ PanelTitle.TAB_RETRATOROBOT);
        //TODO @REFACTOR @FIX @PRE
//        String ventas = gestionEmpresaClienteData.getVentas();
//        String rangoDeEmpleados = gestionEmpresaClienteData.getNEmpleados();
        //INFO: Añadir nuevos campos aqui, si son campos de RETRATOROBOT

        for (Map<String, Object> row : rows) {

            for(Map.Entry<String, Object> column : row.entrySet()) {
                if(column.getValue() == null) {
                    column.setValue("");
                }
                switch (column.getKey()) {

                    case "EJECUTIVO_DE_CUENTA":
                        compararValoresJsonContraBaseDatos(scn,ejecutivoDeCuenta,column,true);
                        break;
                    case "MEDIO_DE_CAPT":
                        compararValoresJsonContraBaseDatos(scn,medioDeCapt,column,true);
                        break;
                    case "CONVENIO":
                        compararValoresJsonContraBaseDatos(scn,convenio,column,true);
                        break;
                    case "BOE":
                        compararValoresJsonContraBaseDatos(scn,bOE,column,true);
                        break;
                    case "TELEFONO":
                        compararValoresJsonContraBaseDatos(scn,telefono,column,true);
                        break;
                    case "CLAUSURADO_CONTRATO_LABORAL":
                        compararValoresJsonContraBaseDatos(scn,clausuladoDelContratoLaboral,column,true);
                        break;
                    case "CLAUSURADO_CPD":
                        compararValoresJsonContraBaseDatos(scn,clausuladoDelCPD,column,true);
                        break;
                    case "OBSERVACIONES":
                        compararValoresJsonContraBaseDatos(scn,observaciones,column,false);
                        break;
                    case "ENTIDAD":
                        //TODO @REFACTOR FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,entidad,column,false);
                        break;
                    case "SUCURSAL":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,sucursal,column,false);
                        break;
                    case "DC":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,dc,column,false);
                        break;
                    case "NUMERO_CUENTA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,numeroCuenta,column,false);
                        break;
                    case "IBAN_PAIS":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,ibanPais,column,false);
                        break;
                    case "IBAN_DC":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,ibanDc,column,false);
                        break;
                    case "IBAN_EXTRANJERO":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,ibanExtranjero,column,false);
                        break;
                    case "TIPO_DIR_FACTURA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,tipo,column,true);
                        break;
                    case "NOMBRE_DIR_FACTURA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,nombreDireccionDeFactura,column,true);
                        break;
                    case "LOCALIDAD_DIR_FACTURA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,localidad,column,true);
                        break;
                    case "PROVINCIA_DIR_FACTURA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,provincia,column,true);
                        break;
                    case "CP_DIR_FACTURA":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,cP,column,true);
                        break;
                    case "DESTINATARIO":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,destinatario,column,false);
                        break;
                    case "VENTAS":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,ventas,column,true);
                        break;
                    case "RANGO_EMPLEADOS":
                        //TODO @REFACTOR @FIX @PRE
//                        compararValoresJsonContraBaseDatos(scn,rangoDeEmpleados,column,true);
                        break;
                }
            }
        }
    }

    public void confirmarDespuesDeGuardarQueNoHaSidoModificadoElClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        System.out.println("------------LEYENDO-CSV-DESPUES-DE-GUARDAR----------------");
        System.out.println("Leemos el csv y lo comparamos con los resultados de la query para saber si se ha creado algún cliente contrato...");
        commonService.getJsonFileData(scn,page,file);
        String nif = gestionClientesContratoData.getNIF();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                GestionClienteContratoQuery.getConsulta(nif, oficina)
        );

        if(rows.size() > 1) {
            throw new AssertionError("FAIL: Se ha encontrado mas de un cliente contrato para la oficina, lo cual no debería ocurrir, analizar el motivo");
        }

        if(rows.size() < 1) {
            throw new AssertionError("FAIL: No se han encontrado clientes contrato con los datos indicados...");
        } else {
            for (Map<String, Object> row : rows) {

                for(Map.Entry<String, Object> column : row.entrySet()) {
                    if(column.getValue() == null) {
                        column.setValue("");
                    }
                    switch (column.getKey()) {

                        case "EJECUTIVO_DE_CUENTA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","EJECUTIVO_DE_CUENTA", 0),
                                    column, true);
                            break;
                        case "MEDIO_DE_CAPT":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","MEDIO_DE_CAPT", 0),
                                    column, true);
                            break;
                        case "CONVENIO":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","CONVENIO", 0),
                                    column, true);
                            break;
                        case "BOE":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","BOE", 0),
                                    column, true);
                            break;
                        case "TELEFONO":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","TELEFONO", 0),
                                    column, true);
                            break;
                        case "CLAUSURADO_CONTRATO_LABORAL":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","CLAUSURADO_CONTRATO_LABORAL", 0),
                                    column, true);
                            break;
                        case "CLAUSURADO_CPD":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","CLAUSURADO_CPD", 0),
                                    column, true);
                            break;
                        case "OBSERVACIONES":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","OBSERVACIONES", 0),
                                    column, false);
                            break;
                        case "ENTIDAD":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","ENTIDAD", 0),
                                    column, false);
                            break;
                        case "SUCURSAL":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","SUCURSAL", 0),
                                    column, false);
                            break;
                        case "DC":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","DC", 0),
                                    column, false);
                            break;
                        case "NUMERO_CUENTA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","NUMERO_CUENTA", 0),
                                    column, false);
                            break;
                        case "IBAN_PAIS":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","IBAN_PAIS", 0),
                                    column, false);
                            break;
                        case "IBAN_DC":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","IBAN_DC", 0),
                                    column, false);
                            break;
                        case "IBAN_EXTRANJERO":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","IBAN_EXTRANJERO", 0),
                                    column, false);
                            break;
                        case "TIPO_DIR_FACTURA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","TIPO_DIR_FACTURA", 0),
                                    column, true);
                            break;
                        case "NOMBRE_DIR_FACTURA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","NOMBRE_DIR_FACTURA", 0),
                                    column, true);
                            break;
                        case "LOCALIDAD_DIR_FACTURA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","LOCALIDAD_DIR_FACTURA", 0),
                                    column, true);
                            break;
                        case "PROVINCIA_DIR_FACTURA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","PROVINCIA_DIR_FACTURA", 0),
                                    column, true);
                            break;
                        case "CP_DIR_FACTURA":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","CP_DIR_FACTURA", 0),
                                    column, true);
                            break;
                        case "DESTINATARIO":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","DESTINATARIO", 0),
                                    column, false);
                            break;
                        case "VENTAS":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","VENTAS", 0),
                                    column, true);
                            break;
                        case "RANGO_EMPLEADOS":
                            compararValoresJsonContraBaseDatos(
                                    scn,
                                    getValueFromCSV(page  + "/" + scn + "/"+ file +".clientecontrato.csv","RANGO_EMPLEADOS", 0),
                                    column, true);
                            break;
                    }
                }
            }
        }

    }

}
