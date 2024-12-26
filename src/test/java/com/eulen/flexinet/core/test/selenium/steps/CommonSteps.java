package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.Task.PedidosTask;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.reader.TestDatosContrato;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends TestBase {
    @Given("^el usuario está en la página (.*), en la oficina (.*), probando el escenario (.*)$")
    public void elUsuarioEstaEnLaPaginaOficina(SystemPages page, String oficina, String scn) throws Exception {
        navigationService.navigateToSubPage(page, oficina, scn);
    }

    /** GESTION DE EMPRESAS **/

    @And("^busca una empresa por su razón social (.*),(.*),(.*)$")
    public void buscaUnaEmpresaPorSuRazonSocialScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception{
        switch (page) { //@paginas
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                gestionCentrosDeTrabajoTask.buscarEmpresa(scn, page, file);
                break;
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContratoTask.buscarEmpresa(scn, page, file);
                break;
        }
    }

    // boton guardar y escribir csv antes de guardar
    @And("^anota los resultados de la consulta en base de datos en un csv luego hace click en el botón guardar (.*),(.*),(.*),(.*)$")
    public void haceClickEnElBotonGuardarScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        switch (page){ //@paginas
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                gestionClientesContratoTask.escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(scn,page,file);
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
                break;
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContratoTask.escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(scn,page,file);
                if(scn.equals("AltaClienteContratoEnvioOK") ) {
                    commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
                } else {
                    commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
                }
                break;
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.escribirCSVconDatosActualesDeClienteContratoAntesDeGuardar(scn,page,file,oficina);
                gestionClientesContratoTask.escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(scn,page,file);
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                gestionCentrosDeTrabajoTask.guardarCSVconDatosActualesDeCentroDeTrabajo(scn,page,file);
                gestionClientesContratoTask.escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(scn,page,file);
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
                //TODO: Si no hay categorias, puede salir un mensaje indicando que hay que rellenarlo
                // en ese caso, hay que crear un metodo que detecte esto y en tal caso, vaya a categorias
                // y rellene los campos y cree una categoría, aunque hay casos donde si el cliente contrato no tiene
                // no se podrá crear entonces hay que probar con otro, analizar esto si es factible.
                break;
        }
    }

    @And("^se confirma que los datos modificados SI se han guardado en base de datos (.*),(.*),(.*),(.*)$")
    public void seConfirmaQueLosDatosModificadosSiSeHanGuardadoEnBaseDeDatos(String scn, SystemPages page, String file, String oficina) throws Exception{
        switch (page) { //@paginas
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                gestionEmpresasClienteTask.confirmarCambiosGuardadosEnTablaEmpresa(scn, page, file);
                break;
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.confirmarCambiosGuardadosEnTablaClienteContrato(scn, page, file, oficina);
                break;
        }
    }

    /** FIN GESTION DE EMPRESAS **/

    // comprobando entidades en external_misc_envios
    @And("^finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado KO (.*),(.*),(.*)$")
    public void finalmenteCompruebaQueHayTrazaNuevaEnLaTablaEXTERNAL_MISC_ENVIOconEstadoKO(String scn, SystemPages page, String file) throws Exception {
        gestionClientesContratoTask.confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(scn, page, file);
    }

    @And("finalmente comprueba que hay traza nueva en la tabla EXTERNAL_MISC_ENVIO con estado OK (.*),(.*),(.*)$")
    public void finalmenteCompruebaQueHayTrazaNuevaEnLaTablaEXTERNAL_MISC_ENVIOConEstadoOKScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionClientesContratoTask.confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(scn, page, file);
    }

    @When("^aparecen las pestañas de gestion accede a ellas y rellena los campos requeridos que no tengan valor (.*),(.*),(.*)$")
    public void aparecenLasPestanasDeGestionAccedeAEllasYRellenaLosCamposRequeridosQueNoTenganValor(String scn, SystemPages page, String file) throws Exception{
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContratoTask.modificaAlgunosCampos(scn, page, file);
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                gestionCentrosDeTrabajoTask.modificaAlgunosCampos(scn, page, file);
                break;
        }
    }

    @When("^aparecen las pestañas de gestion accede a ellas y modifica algunos campos (.*),(.*),(.*)$")
    public void aparecenLasPestanasDeGestionAccedeAEllasYModificaAlgunosCampos(String scn, SystemPages page, String file) throws Exception{
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.modificaAlgunosCampos(scn, page, file);
                break;
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                gestionCentrosDeTrabajoTask.modificaAlgunosCampos(scn, page, file);
                break;
        }
    }

    @Then("^aparece un mensaje de error indicando que los cambios no han sido enviados al erp (.*),(.*),(.*)$")
    public void apareceUnMensajeDeErrorIndicandoQueLosCambiosNoHanSidoEnviadosAlErp(String scn, SystemPages page, String file) throws Exception{
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.verificaElMensajeModificacionKO();
                break;
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                gestionCentrosDeTrabajoTask.verificaElMensajeModificacionKO();
                break;
        }

    }

    @Then("^aparece un mensaje que indica que la modificación se ha realizado correctamente y se ha enviado al erp (.*),(.*),(.*)$")
    public void apareceUnMensajeQueIndicaQueLaModificacionSeHaRealizadoCorrectamenteYSeHaEnviadoAlErp(String scn, SystemPages page, String file) throws Exception {
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.verificaElMensajeModificacionOK();
                break;
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                gestionCentrosDeTrabajoTask.verificaElMensajeModificacionOK();
                break;
        }
    }


    @Then("^aparece un mensaje de error de envio al ERP (.*),(.*),(.*)$")
    public void apareceUnMensajeDeErrorDeEnvioAlERP(String scn, SystemPages page, String file) throws Exception {
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContratoTask.verificaElMensajeAltaKO();
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                gestionCentrosDeTrabajoTask.verificaElMensajeAltaKO();
                break;
        }
    }

    @Then("^aparece un mensaje que indica que el alta se ha realizado correctamente y se ha enviado al ERP (.*),(.*),(.*)$")
    public void apareceUnMensajeQueIndicaQueElAltaSeHaRealizadoCorrectamente(String scn, SystemPages page, String file) throws Exception {
        switch (page) { //@paginas
            case GESTION_CLIENTES_CONTRATO__ALTA:
                gestionClientesContratoTask.verificaElMensajeModificacionOK();
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                gestionCentrosDeTrabajoTask.verificaElMensajeModificacionOK();
                break;
        }
    }

    @And("^hace click en el botón Guardar$")
    public void haceClickEnElBotonGuardar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GUARDAR,null,null,true,true);
    }

    @And("^hace click en el botón (.*) ubicado en (.*) (.*)")
    public void haceClickEnElBoton(FieldByTagLabelText button, PanelTitle located, boolean errorIFNotifShownAfter) throws Exception {
        //INFO: located puede ser TAB_ or DIALOG_ or MAIN si no está ni en una tab ni dentro de un dialogo

        PanelTitle tabTitle = null;
        PanelTitle dialogTitle = null;
        if(located.toString().startsWith("DIALOG_")) {
            dialogTitle = located;
        } else if (located.toString().startsWith("TAB_")) {
            tabTitle = located;
        } else if (located.toString().startsWith("CURRENTPAGE")) {
            //TODO: se queda vacio porque tabTitle y dialogTitle deben ser null y se deben pasar así al clickBtn, pero ver de añadir todo al clickBtn mas adelante
        } else {
            throw new AssertionError("ERROR: El botón no está definido correctamente");
        }

        commonTask.clickBtn(button,tabTitle,dialogTitle,true,errorIFNotifShownAfter);
    }


    @And("^el usuario comprueba que sale la notificación del tipo (.*) con el mensaje (.*)$")
    public void elUsuarioCompruebaQueSaleLaNotificaciónConElMensaje( ModalTitle tipo, String message) throws Exception {
        commonTask.validateGrowlMessage(tipo, message, false, true, true);
    }


    @And("^hace click en el botón Buscar$")
    public void haceClickEnElBotonBuscar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
    }

    @And("^hace click en Generar Contratos$")
    public void haceClickEnGenerarContratos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GENERARCONTRATOS,null,null,true,true);
    }

    @Then("^....PASOS PENDIENTES DE IMPLEMENTAR....$")
    public void pendiente() {
        throw new PendingException("Hay pasos pendientes de implementación...");
    }

    @And("^....PENDIENTE VALIDAR CAMPOS NO EDITABLES....$")
    public void pendienteVALIDARCAMPOSNOEDITABLES() {
        throw new PendingException("Pendiente implementar validación de campos que no deberían ser editables...");
    }

    @Then("^aparece un mensaje con la notificación esperada (.*),(.*),(.*)&")
    public void apareceUnMensajeConLaNotificacionEsperadaScenarioPaginaFichero_datos(String scn, SystemPages pages, String file) throws Exception {
//        commonTask.validateGrowlMessage(tipo, message, false, true, true);
    }

    @And("^rellena el formulario de (.*),(.*),(.*)$")
    public void rellenaElFormularioDePagina(String scn, SystemPages page, String file) throws Exception {
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        ContratosServiceDatePicker contratosServiceDatePicker = new ContratosServiceDatePicker(driver);
        ContratosServiceCheckbox contratosServiceCheckbox = new ContratosServiceCheckbox(driver);
        ContratosServiceLookupField contratosServiceLookupField = new ContratosServiceLookupField(driver);
        switch (page) {
            case CONTRATOS__ANULACION:
                contratosServiceType.typeEmpresa(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNCliente(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNombre(scn,page,null,file,1,false,true,true);
                contratosServiceType.typePrimerApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeSegundoApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNif(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNContrato(scn,page,null,file,1,true,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, false,true,true);
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                contratosServiceType.typeEmpresa(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNCliente(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNombre(scn,page,null,file,1,false,true,true);
                contratosServiceType.typePrimerApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeSegundoApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNif(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNContrato(scn,page,null,file,1,true,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, false,true,true);
                break;
            case CONTRATOS__BAJA_CONSULTA:
                contratosServiceType.typeEmpresa(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNCliente(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNombre(scn,page,null,file,1,false,true,true);
                contratosServiceType.typePrimerApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeSegundoApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNif(scn,page,null,file,1,false,true,true);

                contratosServiceType.typeNContrato(scn,page,null,file,1,true,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, false,true,true);
                break;
            case PEDIDOS__CONSULTA:
                pedidosTask.completePedidosConsultaSearchForm(scn,page,file);
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                contratosServiceType.typeEmpresa(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNCliente(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNombre(scn,page,null,file,1,false,true,true);
                contratosServiceType.typePrimerApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeSegundoApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNif(scn,page,null,file,1,false,true,true);
                /*contratosServiceLookupField.lkpNif(scn, page, null, file, 1, false, true, true);
                contratosServiceType.typeNContrato(scn,page,null,file,1,true,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false,true,true);*/
                contratosServiceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, true,false,false);
                break;

            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                ContratosServiceSelect contratosServiceSelect = new ContratosServiceSelect(driver);
                contratosServiceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
                contratosServiceType.typeNombre(scn,page,null,file,1,false,true,true);
                contratosServiceType.typePrimerApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeSegundoApellido(scn,page,null,file,1,false,true,true);
                contratosServiceType.typeNif(scn,page,null,file,1,false,true,true);
                contratosServiceLookupField.lkpNif(scn, page, null, file, 1, false, true, true);
                contratosServiceSelect.selectFiltrarPorEstado(scn, page, null, file, 1, false, true, true);
             /*   contratosServiceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false,true,true);
                contratosServiceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false,true,true);*/
                break;
        }
    }

    @And("^filtra y selecciona un resultado de la pagina (.*) ubicado en (.*),(.*),(.*)$")
    public void filtraSeleccionaUnResultadoDeLaPagina(SystemPages page, PanelTitle panelTitle, String scn, String file) throws Exception {
        CommonService commonService = new CommonService(driver);
        String datos = "";
        switch (page) {
            case PEDIDOS__CONSULTA:
                datos = "TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA";
                pedidosTask.completePedidosConsultaQbeTablaEmpresa(scn, page, file);
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                CommonServiceWait commonServiceWait = new CommonServiceWait(driver);
                commonServiceWait.waitLoadingSpinnerWrapper(5,10);
                datos = "TestDatos->PEDIDOS__CONSULTA->TABLE_COLABORADOR";
                pedidosTask.completePedidosConsultaQbeTablaColaborador(scn, page, file);
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 2, false);
                break;
            case CONTRATOS__CONSULTA:
                datos = "TestDatosContrato->CONTRATOS__CONSULTA->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__ANULACION:
                datos = "TestDatosContrato->CONTRATOS__ANULACION->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = "TestDatosContrato->CONTRATOS__BAJA_DARDEBAJA->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = "TestDatosContrato->CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = "TestDatosContrato->CONTRATOS__PRORROGAS_ALTA->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = "TestDatosContrato->CONTRATOS__PRORROGAS_ANULACION->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = "TestDatosContrato->CONTRATOS__NOVACION_ALTA->TABLE";
                commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
                break;
        }

        System.out.println("@DEBUG");



    }
}
