package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.database.ContratosQuery;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ContratosServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ContratosServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void consultandoID_CONTRATODePedidosAlta(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA EXTERNAL_CPD_ENVIO----------------");
        /*String fileAux;

        fileAux = getAuxiliarFile(); // El nombre del archivo donde se guarda el id de pedido es definido y guardado en el primer step

        jsonFileNew(fileAux);*/
        jsonFileNew(file);
        String idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();

        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );
        String cdIdContrato;
        String empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
        String nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
        String primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
        String segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
        String nif = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();

        String nombreYApellidos = String.format("%s %s, %s", primerApellidoColaborador,segundoApellidoColaborador,nombreColaborador);

        switch (page) {
            case CONTRATOS__PRORROGAS_CONSULTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                //OTROS DATOS
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__NOVACION_ALTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__NOVACION_ALTA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__ANULACION:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__ANULACION->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                //CONTRATO BAJA
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;

        }

        switch (scn) { //@SCN
            case "Flexinet-19884":
            case "Flexinet-19822":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getTable().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getTable().getNContrato(), cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19954":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA MASIVA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getTable().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getTable().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaBajasMasivas().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaBajasMasivas().getTable().getNContrato(), cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19953":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getTable().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getTable().getNContrato(), cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19750":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19896":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19899":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_SELECCIONDECONTRATOS->qbe_nroContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_SELECCIONDECONTRATOS->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19921":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__ANULACION->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19907":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet-19967":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__ALTA_SUSTITUCION->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__ALTA_SUSTITUCION->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratoAltaSustitucion().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratoAltaSustitucion().getTable().getNContrato(),cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
        }
    }

    public void consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(String scn, SystemPages page, SystemPages origenDataPage, String file) throws Exception {
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA EXTERNAL_CPD_ENVIO----------------");
        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa = "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String nif = "";

        switch (origenDataPage) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                nif = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                nif = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente definir TestDatos indefinidos
                break;
        }


        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );
        String cdIdContrato;

        String nombreYApellidos = String.format("%s %s, %s", primerApellidoColaborador,segundoApellidoColaborador,nombreColaborador);

        if(rows.isEmpty()) {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }

        switch (page) {
            case CONTRATOS__PRORROGAS_CONSULTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                //OTROS DATOS
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__NOVACION_ALTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__NOVACION_ALTA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->TABLE->qbe_nContrato", cdIdContrato);
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__PRORROGAS_ALTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
			case CONTRATOS__BAJA_CONSULTA:
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                //CONTRATO__BAJA
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                //CONTRATO__BAJA_CONSULTA
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__BAJA_CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                //CONTRATOS__ANULACION
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__ANULACION->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                //CONTRATO__BAJA_CONSULTA
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file,"CONTRATOS__BAJA_DARDEBAJA->TABLE->Colaborador", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                //CONTRATO__CONSULTA
                System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                cdIdContrato = rows.get(0).get("ID_CON").toString();
                commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                //CONTRATO__BAJA
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                //CONTRATO BAJA MASIVA
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->nContrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE->Nº Contrato", cdIdContrato);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->empresa", empresa);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nombre", nombreColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->primerApellido", primerApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->segundoApellido", segundoApellidoColaborador);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nIF", nif);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
                break;
        }

        switch (scn) { //@SCN
            case "Flexinet-19884":
            case "Flexinet-19822":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getTable().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getTable().getNContrato(), cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19953":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //CONTRATO BAJA
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    jsonFileNew(file);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosConsulta().getTable().getNContrato(),cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getNContrato(), cdIdContrato);
                    Assert.assertEquals(datosContrato.getContratosBajaDarDeBaja().getTable().getNContrato(), cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19750":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19896":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19899":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_SELECCIONDECONTRATOS->qbe_nroContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_SELECCIONDECONTRATOS->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19921":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__ANULACION->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__ANULACION->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19907":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_ALTA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;

            case "Flexinet-19909":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                    //OTROS DATOS
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->empresa", empresa);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nombre", nombreColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->primerApellido", primerApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->segundoApellido", segundoApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->nIF", nif);

                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);

                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;

            case "Flexinet19910" :
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    //OTROS DATOS
                    commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file,"CONTRATOS__NOVACION_ALTA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->empresa", empresa);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nombre", nombreColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->primerApellido", primerApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->segundoApellido", segundoApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nIF", nif);

                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);

                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
        }
    }

    public void actualizarCampoFTrsFactContratoTraspasado(String file, String scn) throws Exception{
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA CONTRATO PARA ACTUALIZAR DATOS -----------");
        //String fileAux;
//        {
//            fileAux = file.replace(".json", "");
//            fileAux = fileAux + "_AltaSimple" + ".json";
//        }
        //fileAux = getAuxiliarFile(); // El nombre del archivo donde se guarda el id de pedido es definido y guardado en el primer step
        //jsonFileNew(fileAux);
        String idContratoJson = datosContrato.getContratosConsulta().getNContrato();

        String query = ContratosQuery.getUpdateContratoF_TRS_FACT(idContratoJson);
        System.out.printf("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );
        if (!rows.isEmpty()) {
            System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
        }
    }

    public void consultandoID_CONTRATODePedidosAltaYCopiarDatosAltaNovacion(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA EXTERNAL_CPD_ENVIO----------------");
        jsonFileNew(file);
        String idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();

        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );
        String cdIdContrato;

        String empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
        String nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
        String primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
        String segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
        String nif = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();

        String nombreYApellidos = String.format("%s %s, %s", primerApellidoColaborador, segundoApellidoColaborador, nombreColaborador);

        if (!rows.isEmpty()) {
            System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
            cdIdContrato = rows.get(0).get("ID_CON").toString();
            commonService.jsonUpdate(file,"CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file,"CONTRATOS__NOVACION_ALTA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->empresa", empresa);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nombre", nombreColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->primerApellido", primerApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->segundoApellido", segundoApellidoColaborador);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->nIF", nif);

                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->qbe_nombreYApellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->Nombre y Apellidos", nombreYApellidos);
                    commonService.jsonUpdate(file, "CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", nombreYApellidos);
        } else {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }
    }
}
