package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.CommonServiceClick;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.PedidosQuery;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PedidosSteps extends TestBase {

    @And("^busca una empresa usando el botón Buscar Empresa de la pestaña Datos del pedido (.*)$")
    public void buscaUnaEmpresaUsandoElBotonBuscarEmpresaDeLaPestanaDatosDelPedido(SystemPages page) throws Exception {
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                //INFO: Este mensaje sale siempre, nos comenta roberto que en producción tambien sale
                //INFO: EN uat 17/09/2024 ya no sale, cambio valor a false
                boolean esperarMensaje = true; //@MOCK01 -- true para pre y false para uat salvo que cambie algo
                if(esperarMensaje) {
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"No se ha podido obtener el listado de bonificaciones.", true, true, true);
                }
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA,PanelTitle.TAB_DATOSDELPEDIDO,null,true,false);
                break;
            default:
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA,PanelTitle.TAB_DATOSDELPEDIDO,null,true,true);
                break;

        }

    }

    @And("^en el dialogo se seleccion de empresa, busca una empresa por alguno de los campos Empresa,Nif,Cliente (.*),(.*),(.*)$")
    public void buscaUnaEmpresaPorAlgunoDeLosCampos(String scn, SystemPages page, String file) throws Exception{
        pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
        pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, page, file);
        pedidosTask.filterByQbeOnDialogSeleccionEmpresa(scn, page, file);
    }

    @And("^selecciona el registro deseado de la tabla en el dialogo seleccion de empresa (.*),(.*),(.*)$")
    public void seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeEmpresa(String scn, SystemPages page, String file) throws Exception{
        String jsonObjectPath = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                jsonObjectPath = "TestDatos->PEDIDOS__ALTA_LV3233->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                jsonObjectPath = "TestDatos->PEDIDOS__ALTA_INDEFINIDOS->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                jsonObjectPath = "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;

        }

        commonTask.clickFirstValidRowResultOnTable(
                scn,
                page,
                null,
                file,
                jsonObjectPath,
                1,
                true);
    }

    @And("hace click en Asociar a Empresa")
    public void haceClickEnAsociarAEmpresa() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ASOCIARAEMPRESA,null,PanelTitle.DIALOG_SELECCIONDEEEMPRESA,true,true);
    }

    @And("^rellena los datos necesarios en las pestañas de gestión (.*),(.*),(.*)$")
    public void rellenaLosDatosNecesariosEnLasPestanasDeGestion(String scn, SystemPages page, String file) throws Exception{
        pedidosTask.completeFields(scn, page, file, true, true);
    }

    @And("^hace click en Finalizar$")
    public void haceClickEnFinalizar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR,null,null,true,true);
    }

    @And("^aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta (.*),(.*),(.*)$")
    public void apareceUnMensajeIndicandoQueElPedidoHaSidoBloqueadoPorRiesgos(String scn, SystemPages page, String file) throws Exception{
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_ESTADODEPEDIDO,
                "El pedido con ID (.*) ha sido bloqueado por Riesgos",
                false,
                file
        );
        pedidosTask.consultarYGuardarNumeroPedido(file,false, false,true,true);
        pedidosTask.copiarYGuardarDatosEnPedidosConsulta(scn, page, file);
        pedidosTask.copiarYGuardarDatosEnRiesgosGestionPedidosBloqueados(scn, page, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);
        commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
        System.out.println("@DEBUG");
    }

    @And("^se dirige al menu riesgos, gestion de pedidos bloqueados, donde busca y desbloquea el registro (.*),(.*),(.*),(.*)$")
    public void seDirigeAlMenuRiesgosGestionDePedidosBloqueadosYdesbloqueaElRegistro(String scn, SystemPages page, String file, String oficina) throws Exception {
        navigationService.navigateToSubPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS,oficina,scn);
        commonTask.waitToAccessPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS);
        riesgosTask.completeGestionPedidosBloqueadosSearchForm(scn,SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS,file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        commonTask.doScreenshot("RECORD TO UNBLOCK");
        riesgosTask.selectRecordFoundOnGestionPedidosBloqueadosTable(scn,page,file);
    }

    @And("^se dirige a la pagina pedidos consulta y busca el pedido por su numero (.*),(.*),(.*),(.*)$")
    public void vaALaPaginaPedidosConsultaYBuscaElPedidoPorSuNumero(String scn, SystemPages page, String file, String oficina) throws Exception {
        navigationService.navigateToSubPage(SystemPages.PEDIDOS__CONSULTA,oficina,scn);
        commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
        pedidosTask.completePedidosConsultaSearchForm(scn,SystemPages.PEDIDOS__CONSULTA,file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        commonTask.clickFirstValidRowResultOnTable(scn,SystemPages.PEDIDOS__CONSULTA,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA",1,false);
    }

    @And("^es llevado a la pagina pedidos consulta donde busca el pedido (.*),(.*),(.*),(.*)$")
    public void esLlevadoALaPaginaPedidosConsultaDondeBuscaElPedido(String scn, SystemPages page, String file, String oficina) throws Exception {
        commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
        pedidosTask.completePedidosConsultaSearchForm(scn,page,file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        pedidosTask.completePedidosConsultaQbeTablaEmpresa(scn,page,file);
        commonTask.clickFirstValidRowResultOnTable( scn,page,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA",1,false);
        pedidosTask.completePedidosConsultaQbeTablaColaborador(scn,page,file);
        commonTask.clickFirstValidRowResultOnTable( scn,page,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_COLABORADOR",2,false); //INFO `cajaNumero = 2` porque es la segunda tabla
    }


    @When("^hace click en Modificar (.*)$")
    public void haceClickEnModificar(SystemPages page) throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAR,null,null,true,false);
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                //INFO: Este mensaje sale siempre, nos comenta roberto que en producción tambien sale.
                boolean apareceNotificacion = true; //@MOCK01 -- true para pre y false para uat salvo que cambie algo
                if(apareceNotificacion) {
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"No se ha podido obtener el listado de bonificaciones.", true, true, true);
                }
                break;
            default:
                break;
        }
        System.out.println("@DEBUG modificar");
    }

    @And("^es redirigido a la página de modificación de pedidos donde hace click en Generar Contratos$")
    public void esRedirigidoALaPaginaDeModificacionDePedidosDondeHaceClickEnGenerarContratos() throws Exception{
        commonTask.waitToAccessPage(SystemPages.PEDIDOS__MODIFICACION);
        commonTask.clickBtnGenerarContratos();
    }

    @And("^aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato (.*),(.*),(.*),(.*)$")
    public void apareceUnDialogoIndicandoQueElPedidoSeHaRealizadoConExitoYPreguntaSiGenerarContratosDeLosColaboradoresYLaFechaDeAntiguedadDelContratoScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception{
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn,page,file);
    }

    @And("^en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato (.*),(.*),(.*),(.*)$")
    public void enLaPaginaDeModificacionApareceUnDialogoIndicandoQueElPedidoSeHaRealizadoConExitoYPreguntaSiGenerarContratosDeLosColaboradoresYLaFechaDeAntiguedadDelContratoScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception{
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn,SystemPages.PEDIDOS__MODIFICACION,file);
    }

    @And("^hace click en Si$")
    public void haceClickEnSi() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI,null,PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO,true,false);
    }

    //INFO: 1 colaborador
    @Then("^aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato (.*),(.*),(.*)$")
    public void apareceUnaNotificacionUnDialogoConDocumentosYUnDialogoConElEstado(String scn, SystemPages page, String file) throws Exception{
        // VALIDAR GROWL
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "", false, false, false);
        Thread.sleep(20000);
        commonTask.doScreenshot("notificacion documentos");
        boolean validarNotificacionDeDocumentos = false; //@MOCK desactivado por defecto porque los mensajes varian segun datos
        if(validarNotificacionDeDocumentos) {
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false, false);

            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", true, true, false);
                    break;
                default:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", false, false, false);
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CPD generado correctamente", true, true, false);
                    break;
            }
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarModal();
        }
        System.out.println("PASS: se cierra la notificación de documentos generados");

        //VALIDAR DOCUMENTOS A IMPRIMIR
        commonTask.doScreenshot("documentos a imprimir");
        boolean validarDocumentosAImprimir = false; //@MOCK desactivado por defecto porque los mensajes varian segun datos
        if(validarDocumentosAImprimir) {
        	switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    break;
                default:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
                    break;
            }
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
        }
        System.out.println("PASS: se cierra la notificación de documentos a imprimir");

        //VALIDAR ESTADO DEL PEDIDO
        commonTask.doScreenshot("estado del pedido");
        boolean validateDialogDelPedido = true; //@MOCK03 -- desactivado por defecto porque los mensajes varian segun datos
        if (validateDialogDelPedido) {
            commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
            //Los siguientes escenarios usan 2 colaboradores, por lo que salen 2 mensajes al final de que ha sido traspasado con exito
            //Flexinet-19885 - alta simple 2 colaboradores
            //Flexinet-19887 - alta indefinidos 2 colaboradores
            //Flexinet-19891 - alta lv3233 2 colaboradores
            if (scn.equals("Flexinet-19885") || scn.equals("Flexinet-19887") || scn.equals("Flexinet-19891")) {
                String colaborador1 = commonTask.getNombreColaborador(page, file);
                boolean convertirAMayusculasColaborador1 = false; //TODO: esto es para debugar
                if (convertirAMayusculasColaborador1) {
                    colaborador1 = colaborador1.toUpperCase();
                }
                commonTask.validateDialogMessage(
                        PanelTitle.DIALOG_ESTADODEPEDIDO,
                        "El contrato para el colaborador " + colaborador1 + " ha sido generado y traspasado con éxito.",
                        false,
                        file
                );
                file = file.replace(".json", "");
                String colaborador2 = commonTask.getNombreColaborador(page, file + "_ColaboradorAdicional.json");
                boolean convertirAMayusculasColaborador2 = false; //TODO: esto es para debugar
                if (convertirAMayusculasColaborador2) {
                    colaborador2 = colaborador2.toUpperCase();
                }
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador2 + " ha sido generado y traspasado con éxito.", false, file);
            } else {
                String colaborador = commonTask.getNombreColaborador(page, file);
                boolean convertirAMayusculas = true; //TODO: @MOCK02 -- convierte en mayusculas, analizar cuando usarlo
                if (convertirAMayusculas && !scn.equals("Flexinet-19761")) {
                    colaborador = colaborador.toUpperCase();
                }
                //TODO: el paso siguiente valida que el nombre del colaborador sea el que esperamos, pero aveces sale en
                // mayuscula y aveces en minuscula sin ninguna condicion clara, así que activamos el otro metodo solo para validar el mensaje no el nombre
//                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado y traspasado con éxito.", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.", false, file);
            }

            commonTask.clickBtn(
                    FieldByTagLabelText.BTN_OK,
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    true,
                    true
            );
        } else {
            commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);

            commonTask.clickBtn(
                    FieldByTagLabelText.BTN_OK,
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    true,
                    true
            );
        }
        System.out.println("PASS: se cierra el dialogo de estado de pedido");
    }

    @And("^aparece un mensaje indicando que el contrato para el colaborador ha sido generado con exito (.*)$")
    public void apareceUnMensajeIndicandoQueElContratoParaElColaboradorHaSidoGeneradoConExito(String file) throws Exception{
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_ESTADODEPEDIDO,
                "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.",
                false,
                file
        );
        //TODO: ver si podemos cambiar el metodo siguiente por el commonTask.clickBtn();
        commonTask.clickBtnOK(null,PanelTitle.DIALOG_ESTADODEPEDIDO);
    }

    @Then("^aparece una notificacion indicando que el pedido ha sido autorizado (.*),(.*),(.*)$")
    public void apareceUnaNotificacionIndicandoQueElPedidoHaSidoAutorizadoScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception{
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO,"El pedido ha sido autorizado por Riesgos",true, true, true);
    }

    @And("^hace click en Enviar a Riesgos$")
    public void haceClickEnEnviarARiesgos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ENVIARARIESGOS,null,null, false, false);
    }

    @Then("^aparece un mensaje indicando que el pedido ha sido autorizado por riesgos (.*),(.*),(.*)$")
    public void apareceUnMensajeIndicandoQueElPedidoHaSidoAutorizadoPorRiesgosScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception{
        commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO,"El pedido ha sido autorizado por Riesgos.",false, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null, PanelTitle.DIALOG_ESTADODEPEDIDO, true, true);
        pedidosTask.consultarYGuardarNumeroPedido(file, false, false,true, false);
        pedidosTask.copiarYGuardarDatosEnPedidosConsulta(scn, page, file);
        System.out.println("@DEBUG");
    }

    //TODO ver si se necesita si no borrar
//    @And("^aparece un mensaje indicando que el contrato para el colaborador ha sido generado con exito pero debido a que han pasado ya los 10 días permitidos se ha notificado de forma manual$")
//    public void apareceUnMensajeIndicandoQueElContratoParaElColaboradorHaSidoGeneradoConExitoPeroDebidoAQueHanPasadoYaLosDiasPermitidosSeHaNotificadoDeFormaManual(String file) throws Exception{
//        commonTask.validateDialogMessage(
//                PanelTitle.DIALOG_ESTADODEPEDIDO,
//                "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito pero debido a que han pasado ya los 10 días permitidos, la comunicación a AFILIACION y Contrat@ se ha notificado de forma manual.");
//        commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null, PanelTitle.DIALOG_ESTADODEPEDIDO, true, true);
//    }

    @And("en la página de consulta de pedidos rellena el formulario de consulta de pedidos, hace click en buscar y selecciona el registro en la tabla (.*),(.*),(.*),(.*)$")
    public void rellenaElFormularioDeConsultaDePedidos(String scn, SystemPages page, String file, String oficina) throws Exception {
        navigationService.navigateToSubPage(page, oficina, scn);
        pedidosTask.completePedidosConsultaSearchForm(scn,page,file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        commonTask.clickFirstValidRowResultOnTable(scn,SystemPages.PEDIDOS__CONSULTA,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA",1,false);
        commonTask.clickFirstValidRowResultOnTable(scn,SystemPages.PEDIDOS__CONSULTA,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_COLABORADOR",2,false);
    }

    @And("^cierra la notificación$")
    public void cierraLaNotificacion() throws Exception{
        commonTask.clickBtnCerrarModal();
    }

    @When("^se añade un segundo colaborador (.*),(.*),(.*)$")
    public void seAnadeUnSegundoColaborador(String scn, SystemPages page, String file) throws Exception {
        file = file.replace(".json",""); //quito la extensión para añadir el texto de colaborador adicional.
        pedidosTask.anadirColaboradorAdicional(scn,page,file + "_ColaboradorAdicional.json", false, false);
    }

    //OBS:Aqui se le da a guardar no a finalizar
    @And("^teniendo un pedido guardado por alta simple (.*),(.*),(.*)$")
    public void teniendoUnPedidoGuardadoPorAltaSimpleScenario(String scn, String file, String oficina) throws Exception {
        SystemPages page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        System.out.println("@DEBUG 1 colaborador");
        navigationService.navigateToSubPage(page, oficina, scn);
        pedidosTask.clickBtnBuscarEmpresa();
        pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
        pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, page, file);
        pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn,page,file);
        pedidosTask.clickBtnAsociarAEmpresa();
        pedidosTask.completeFields(scn, page, file, false, false);
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_GRABAR,
                null,
                null,
                true,
                true
        );
        boolean validarMensajePedidoGrabado = true; //@MOCK
        if(validarMensajePedidoGrabado) {
            commonTask.validateDialogMessage(
                    PanelTitle.DIALOG_GRABADODEPEDIDO,
                    "El pedido será grabado",
                    false,
                    file
            );
        }
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_SI,
                null,
                PanelTitle.DIALOG_GRABADODEPEDIDO,
                true,
                true
        );
        boolean validarMensajePedidoGrabado2 = true; //@MOCK
        if(validarMensajePedidoGrabado2) {
            commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "Pedido grabado con éxito", true, true, true);
        }
        commonTask.clickTab(PanelTitle.TAB_DATOSDELPEDIDO.getValue());
        //TODO: borrar el paso siguiente si no finalmente no se usa, en este se capturaba el numero de pedido desde la tab dados de pedido cuando se rellenaba el campo al final de proceso.
//        pedidosTask.captureNpedidoAndWriteToJsonPedidosConsulta(file);

        //INFO: el siguiente paso captura el numero de pedido mediante una query a base de datos
        pedidosTask.consultarYGuardarNumeroPedido(file,false, false,true,false);
    }

    @And("^teniendo 2 colaboradores en un pedido guardado por alta simple (.*),(.*),(.*)$")
    public void teniendoUnPedidoGuardadoPorAltaSimpleScenario2colaboradores(String scn, String file, String oficina) throws Exception {
        SystemPages page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        System.out.println("@DEBUG en este        escenario se añaden 2 colaboradores");
        navigationService.navigateToSubPage(page, oficina, scn);
        pedidosTask.clickBtnBuscarEmpresa();
        pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
        pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, page, file);
        pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn,page,file);
        pedidosTask.clickBtnAsociarAEmpresa();
        pedidosTask.completeFields(scn, page, file, false, false);
        //quito la extensión para añadir colaborador adicional al nombre del archivo.
        String fileSegundoColaborador = file.replace(".json","");
        pedidosTask.anadirColaboradorAdicional(scn,page,fileSegundoColaborador + "_AltaSimple_ColaboradorAdicional.json", false, false);
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_GRABAR,
                null,
                null,
                true,
                true
        );
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_GRABADODEPEDIDO,
                "El pedido será grabado",
                false,
                file
        );
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_SI,
                null,
                PanelTitle.DIALOG_GRABADODEPEDIDO,
                true,
                true
        );
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "Pedido grabado con éxito",true, true, true);
        commonTask.clickTab(PanelTitle.TAB_DATOSDELPEDIDO.getValue());
        pedidosTask.captureNpedidoAndWriteToJsonPedidosConsulta(file);
    }

    @And("^además rellena deglose de categoria profesional en datos de tarifa (.*),(.*),(.*)$")
    public void ademasRellenaDeglosDeCategoriaProfesionalEnDatosDeTarifaScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        pedidosTask.rellenaDesgloseCategoriaProfesional(scn,page,file);
        commonTask.clickTab(PanelTitle.TAB_DATOSDELPEDIDO.getValue()); //INFO: volvemos a la pestaña de pedidos par apoder capturar el numero luego de finalizar
    }

    //INFO: 2 colaboradores
    @Then("^aparece notificacion, dialogo de documentos a imprimir y dialogo informando contratos generados con exito pero uno de ellos sin traspasar (.*),(.*)$")
    public void apareceNotificacionDialogoDeDocumentosAImprimirYDialogoInformandoContratosGeneradosConExitoPeroUnoDeEllosSinTraspasar(String scn, String file) throws Exception {
        // VALIDAR GROWL
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "", false, false, false);
        Thread.sleep(20000);
        commonTask.doScreenshot("notificacion documentos");
        boolean validarNotificacionDeDocumentos = false; //@MOCK desactivado por defecto porque los mensajes varian segun datos
        if(validarNotificacionDeDocumentos) {
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CPD generado correctamente", false, true, true);
            commonTask.clickBtnCerrarModal(); //TODO: aveces es posible que cerrar dos veces porque hay un fallo en el front, cuando se cierra el modal vuelve a aparecer
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarModal();
        }
        System.out.println("PASS: se cierra la notificación de documentos generados");

        //VALIDAR DOCUMENTOS A IMPRIMIR
        commonTask.doScreenshot("documentos a imprimir");
        boolean validarDocumentosAImprimir = false; //@MOCK desactivado por defecto porque los mensajes varian segun datos
        if(validarDocumentosAImprimir) {
            commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
        }
        System.out.println("PASS: se cierra la notificación de documentos a imprimir");

        //VALIDAR ESTADO DEL PEDIDO
        commonTask.doScreenshot("estado del pedido");
        boolean validateDialogDelPedido = true; //@MOCK desactivado por defecto porque los mensajes varian segun datos
        if(validateDialogDelPedido) {
            commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);

            commonTask.validateDialogMessage(
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.",
                    false,
                    file
            );
            commonTask.validateDialogMessage(
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    "El contrato para el colaborador (.*) ha sido generado con éxito pero no se ha podido traspasar por estos motivos: El colaborador no dispone de datos de IRPF",
                    false,
                    file
            );

            commonTask.clickBtn(
                    FieldByTagLabelText.BTN_OK,
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    true,
                    true
            );
        } else {
            commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);

            commonTask.clickBtn(
                    FieldByTagLabelText.BTN_OK,
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    true,
                    true
            );
        }
        System.out.println("PASS: se cierra el dialogo de estado de pedido");
    }

    @And("^es llevado a la página de modificacion de pedidos$")
    public void esLlevadoALaPaginaDeModificacionDePedidos() throws Exception {
        pedidosTask.waitToAccessPagePedidosModificacion(SystemPages.PEDIDOS__MODIFICACION);
    }

    @Then("^aparece una notificacion de información indicando los documentos que que se han generado (.*),(.*),(.*)$")
    public void apareceUnaNotificacionIndicandoLosDocumentosQueQueSeHanGenerado(String scn, SystemPages page, String file) throws Exception{
        Thread.sleep(5000); //TODO @MOCK aqui falta un mock
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento RPD generado correctamente", false, false, false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento Riesgos generado correctamente", false,false,false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CL generado correctamente", false,false,false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente", false,false,false);
        commonTask.doScreenshot("Mensajes Finales");
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CPD generado correctamente", true, true, true);
        System.out.println("PASS: El mensaje indica que todos los documentos se han generado.");
    }

    @And("^aparece un dialogo de estado del pedido indicando que el contrato para el colaborador ha sido generado con exito pero para el segundo colaborador no se ha podido traspasar (.*)$")
    public void apareceUnDialogoDeEstadoDelPedidoIndicandoQueElContratoParaElColaboradorHaSidoGeneradoConExito(String file) throws Exception{
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_ESTADODEPEDIDO,
                "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.",
                false,
                file
        );
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_ESTADODEPEDIDO,
                "El contrato para el colaborador (.*) ha sido generado con éxito pero no se ha podido traspasar por estos motivos: El colaborador no dispone de datos de IRPF",
                false,
                file
        );
        commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);
    }

    @And("^se comprueba en bbdd en la tabla EXTERNAL_CPD_ENVIO.CD_STATUS = ERP_SEND_DISCARD (.*)$")
    public void seCompruebaEnBbddEnLaTablaEXTERNAL_CPD_ENVIOCD_STATUSERP_SEND_DISCARD(String file) throws Exception{
        pedidosTask.consultandoEXTERNAL_CPD_ENVIO(file);
    }

    @And("^toma nota del numero de pedido despues de finalizar (.*),(.*),(.*)$")
    public void tomaNotaDelNumeroDePedidoDespuesDeFinalizarScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        //INFO: en este punto, el numero de pedido se ha generado y se ha indicado en la página aunque no se vea dado que tenemos el popup encima, ya en el html existe.
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                pedidosTask.captureNpedidoAndWriteToJsonPedidosLV3233(file);
                break;
        }
    }


}

