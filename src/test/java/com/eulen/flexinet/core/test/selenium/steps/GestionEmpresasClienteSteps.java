package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GestionEmpresasClienteSteps extends TestBase {

    @When("^rellena el campo cif y hace click en el botón Obtener Datos  (.*),(.*),(.*)$")
    public void rellenaElCampoCifYHaceClickEnElBotonObtenerDatosScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.buscarEmpresaPorBotonObtenerDatos(scn, page, file);
    }

    /*** CONSULTA ***/

    @When("^rellena los campos del formulario de consulta (.*),(.*),(.*)$")
    public void rellenaLosCamposDelFormularioDeConsulta(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.formularioConsultaEmpresa(scn, page, file);
    }

    @And("^hace click en buscar y selecciona el registro encontrado (.*),(.*),(.*)$")
    public void haceClickEnBuscarYSeleccionaElRegistroEncontradoScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        gestionEmpresasClienteTask.tablaConsultaEmpresasQbe(scn,page,file);
        commonTask.clickFirstValidRowResultOnTable(scn,page,null,file,"TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__CONSULTA->TABLE",1,false);
    }

    @Then("^aparece una tabla inferior con los resultado de la busqueda que coinciden con los datos buscados. (.*),(.*),(.*)$")
    public void apareceUnaTablaInferiorConLosResultadoDeLaBusquedaQueCoincidenConLosDatosBuscados(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.confirmarResultadoConsulta(scn, page, file);
    }

    @When("^hace clic en el botón Enviar Riesgos$")
    public void haceClicEnElBotonEnviarRiesgos() throws Exception {
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_ENVIARARIESGOS,
                null,
                null,
                true,
                true
        );
    }

    @When("^ya ha verificado los valores ahora hace clic en el botón Guardar$")
    public void yaHaVerificadoLosValoresAhoraHaceClicEnElBotonGuardar() throws Exception {
        commonTask.clickBtn(
                FieldByTagLabelText.BTN_GUARDAR,
                null,
                null,
                true,
                true
        );
    }

    @And("^luego hace click en Yes, para confirmar el envio a riesgos$")
    public void luegoHaceClickEnYesParaConfirmaElEnvioARiesgos() throws Exception {
        //TODO: cambiar por el metodo commonServiceClick.clickBtn
        gestionEmpresasClienteTask.clickBtnEnviarARiesgosYes();
    }

    @Then("verifica que aparece un modal que informa que los datos de la empresa han sido enviados a riesgos para su estudio")
    public void verificaQueApareceUnModalQueInformaQueLosDatosDeLaEmpresaHanSidoEnviadosARiesgosParaSuEstudio() throws Exception {
        gestionEmpresasClienteTask.validarQueSeMuestraElMensajeDeInformacion("Los datos de la empresa han sido enviados a riesgos para su estudio");
    }

    @And("verifica el mensaje que indica que la empresa no puede ser dada de alta porque aún se encuentra en estudio por el Departamento de Riesgos")
    public void verificaElMensajeQueIndicaQueLaEmpresaNoPuedeSerDadaDeAltaPorqueAunSeEncuentraEnEstudioPorElDepartamentoDeRiesgos() throws Exception {
        gestionEmpresasClienteTask.validarQueSeMuestraElMensajeDeInformacion("Esta empresa no puede ser dada de alta porque aún se encuentra en estudio por el Departamento de Riesgos");
    }

    @And("^hace click en el boton ver empresa$")
    public void haceClickEnElBotonVerEmpresa() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_VEREMPRESA,null,null,true,true);
    }

    @And("^realiza la busqueda de una empresa en el fomulario de consulta (.*),(.*),(.*)$")
    public void realizaLaBusquedaDeUnaEmpresaEnElFomularioDeConsulta(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.formularioConsultaEmpresa(scn, page, file);
    }

    @Then("^valida que los valores indicados en los campos son correctos (.*),(.*),(.*)$")
    public void validaQueLosDatosSonCorrectosEnTodosLosCampos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validarTabDatosRiesgos(scn, page, file);
        gestionEmpresasClienteTask.validarTabIdentificativos(scn, page, file);
        gestionEmpresasClienteTask.validarTabDatosEconomicos(scn, page, file);
        gestionEmpresasClienteTask.validarTabCategoriaSeguridadSocial(scn, page, file);
        gestionEmpresasClienteTask.validarTabRetratoRobot(scn, page, file);
    }

    @And("^hace click en el boton Modificar Empresa$")
    public void haceClickEnElBotonModificarEmpresa() throws Exception {
        //gestionEmpresasClienteTask.clickBtnModificarEmpresa();
        commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAREMPRESA,null,null,true,true);
    }

    @When("^modifica algunos campos pero ninguno de la pestaña datos economicos dirección de facturación (.*), (.*), (.*)$")
    public void enLaPestanaDatosEconomicosModificaAlgunosCamposPeroNingunoDeLaDireccionDeFacturacion(String scn, SystemPages page, String file) throws Exception {
        //gestionEmpresasClienteTask.modificarDatosEconomicos(scn, page, file);
        gestionEmpresasClienteTask.tabDatosRiegos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabIdentificativos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabDatosEconomicos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabCategoriaSeguridadSocial(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabRetratoRobot(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
    }

    @Then("^aparece un mensaje indicando que se han guardado los cambios pero no se han enviado al ERP (.*),(.*),(.*)$")
    public void apareceUnMensajeIndicandoQueSeHanGuardadoLosCambiosPeroNoSeHanEnviadoAlERP(String scn, SystemPages page, String file) throws Exception {
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                gestionEmpresasClienteTask.validateMessageInformacionDatosGuardadosNoEnvioERP();
                break;
            case GESTION_CLIENTES_CONTRATO__CONSULTA:
                gestionClientesContratoTask.verificaElMensajeDatosGuardadoPeroNoEnvioERP();
                break;
        }
    }

    @And("^se confirma revisando la tabla de EXTERNAL_MISC_ENVIO que no se ha creado ningún registro de lote nuevo (.*), (.*), (.*)$")
    public void confirmaRevisandoLaTrazaQueFiguraEnLaTablaDeEXTERNAL_MISC_ENVIOQueNoHaHabidoEnvioAlERP(String scn, SystemPages page, String file) throws Exception {
        gestionClientesContratoTask.confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(scn, page, file);
    }

    @When("^va a la pestaña datos economicos y modifica algunos campos de la dirección de facturación (.*), (.*), (.*)$")
    public void vaALaPestanaDatosEconomicosYModificaAlgunosCamposDeLaDireccionDeFacturacionScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.tabDatosRiegos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabIdentificativos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabDatosEconomicos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabCategoriaSeguridadSocial(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabRetratoRobot(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
    }


    @Then("^aparece un mensaje de error indicando, error en envio ERP la empresa no se enuentra registrada en el sistema (.*), (.*), (.*)$")
    public void apareceUnMensajeDeErrorIndicandoErrorEnEnvioERPLaEmpresaNoSeEnuentraRegistradaEnElSistema(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validateModalTexto(scn, page, file);
    }

    @And("^se confirma que los datos modificados NO se han guardado en base de datos (.*), (.*), (.*)$")
    public void seConfirmaQueLosDatosModificadosNOSeHanGuardadoEnBaseDeDatosScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.confirmarCambiosGuardadosEnTablaEmpresa(scn, page, file);
    }

    @Then("^aparece un mensaje indicando que se han guardado los cambios y se han enviado al ERP (.*), (.*), (.*)$")
    public void apareceUnMensasjeIndicandoQueSeHanGuardadoLosCambiosYSeHanEnviadoAlERPScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validateModalTexto(scn, page, file);
    }

    @Then("^accede a las pestañas y rellena los campos requeridos (.*),(.*),(.*)$")
    public void accedeALasPestanasYRellenaLosCamposRequeridos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validaYRellenaTabs(scn, page, file);
    }

    @When("^hace clic en el botón Guardar (.*),(.*),(.*)$")
    public void haceClicEnElBotonGuardar(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GUARDAR,null,null,true,true);
    }

    /**
     * Este metodo es generico para editar las tabs de modificación de empresa, pasar los datos por el json segun requiera el test
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    @When("^modifica algunos campos indicando Globalizada ON (.*),(.*),(.*)$")
    @When("^modifica algunos campos indicando Globalizada OFF (.*),(.*),(.*)$")
    @When("^modifica algunos campos de manera que los campos Impuesto y Días Fijo de Pagos sean valores Nulos (.*),(.*),(.*)$")
    @When("^modifica algunos campos de manera que los campos Impuesto y Días Fijo de Pagos sean valores NO Nulos (.*),(.*),(.*)$")
    public void modificaAlgunosCamposIndicandoGlobalizadaONScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.tabDatosRiegos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabIdentificativos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabDatosEconomicos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabCategoriaSeguridadSocial(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
        gestionEmpresasClienteTask.tabRetratoRobot(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
    }

//    @When("^modifica algunos campos indicando Globalizada OFF (.*),(.*),(.*)$")
//    public void modificaAlgunosCamposIndicandoGlobalizadaOFFScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
//        gestionEmpresasClienteTask.tabDatosRiegos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
//        gestionEmpresasClienteTask.tabIdentificativos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
//        gestionEmpresasClienteTask.tabDatosEconomicos(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
//        gestionEmpresasClienteTask.tabCategoriaSeguridadSocial(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
//        gestionEmpresasClienteTask.tabRetratoRobot(scn,SystemPages.GESTION_EMPRESAS_CLIENTE__MODIFICAR,file, false, true);
//    }

    @And("^aparece un dialogo de Confirmación de Operacion por parte de riesgos, hace click en SI (.*),(.*),(.*)$")
    public void apareceUnDialogoDeConfirmaciónDeOperacionPorParteDeRiesgosHaceClickEnSIScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        commonTask.validateDialogMessage(PanelTitle.DIALOG_CONFIRMACIONDEOPERACION,"Ha modificado los datos relativos a Riesgos, por lo que este Departamento deberá revisar los nuevos valores insertados. ¿Desea continuar con la operación?", false, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO,null,PanelTitle.DIALOG_CONFIRMACIONDEOPERACION,true,true);
    }

    @Then("^aparece una notificacion indicando que los datos han sido enviados a riesgos (.*),(.*),(.*),(.*)$")
    public void apareceUnaNotificacionIndicandoQueLosDatosHanSidoEnviadosARiesgosScenarioPaginaFichero_datosOficina() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO,"Los datos de la empresa han sido enviados a riesgos para su estudio", false, true, true);
        System.out.println("@DEBUG");
    }

    @And("finalmente comprueba en la tabla EMP_TIPOFA que SI hay un registro para la empresa (.*),(.*),(.*)")
    public void finalmenteCompruebaEnLaTablaEMP_TIPOFAQueSIHayUnRegistroParaLaEmpresa(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validarQueryEMP_TIPO(scn,page,file);
    }

    @And("finalmente comprueba en la tabla EMP_TIPOFA que NO hay un registro para la empresa (.*),(.*),(.*)")
    public void finalmenteCompruebaEnLaTablaEMP_TIPOFAQueNOHayUnRegistroParaLaEmpresa(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validarQueryEMP_TIPO(scn,page,file);
    }

    @And("^valida que los campos de datos de riegos no sean editables (.*),(.*),(.*)$")
    public void validaQueLosCamposDeDatosDeRiegosNoSeanEditablesScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        gestionEmpresasClienteTask.validateTabDatosRiegosCamposNoEditables(scn,page,file, false, false);
    }
}
