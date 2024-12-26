package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.ehcache.xml.model.ServiceType;

public class PartesDeHorasSteps extends TestBase {
    @And("^rellena los campos necesarios para dar de alta el parte (.*),(.*),(.*)$")
    public void rellenaLosCamposNecesarioParaDarDeAltaElParte(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.cabeceraYPiePartesDeHoras(scn, page, file, false, true);
        partesDeHorasTask.tabPartesDeHorasNominas(scn, page, file, false, false);
        partesDeHorasTask.tabPartesDeHorasFacturacion(scn, page, file, false, false);
        partesDeHorasTask.tabConceptosIT(scn, page, file, false, false, false);
        partesDeHorasTask.tabConceptosColaborador(scn, page, file, false, false);
    }

    @And("^selecciona empresa y contrato (.*),(.*),(.*)$")
    public void seleccionaEmpresaYContratoScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.seleccionaEmpresaYContrato(scn, page, file, true, true);
    }

    @And("^aparece una notificación indicando que el parte se ha insertado con exito (.*),(.*),(.*)$")
    public void apareceUnaNotificacionIndicandoQueElParteSeHaInsertadoConExito(String scn, SystemPages page, String file) throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "Parte de Horas ha sido insertado con éxito", false, true, true);
    }

    @And("^rellena los campos necesarios del formulario para buscar un parte (.*),(.*),(.*)$")
    public void rellenaLosCamposNecesariosDelFormularioParaBuscarUnParte(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.formularioConsultaTraspasoDeParteDeHoras(scn, page, file, true, true);
    }

    //TODO: reemplazar este paso por el `selecciona el resultado esperado de la tabla` cuando sea posible
    @And("^hace click en el botón Buscar y selecciona el resultado esperado de la tabla (.*),(.*),(.*)$")
    public void haceClickEnElBotónBuscarYSeleccionaElResultadoEsperadoDeLaTablaScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                partesDeHorasTask.filterByQbeOnTableConsultaParteDeHoras(scn,page,file,false,false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                break;
            case PARTES_DE_HORAS__TRASPASO:
                partesDeHorasTask.filterByQbeOnTable1TraspasoParteDeHoras(scn,page,file,false,false);
                //INFO: @PRE aqui hay 2 veces el mismo metodo, porque la primera vez, cuando hace click salta un sp
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                break;
        }

    }

    @And("^selecciona el resultado esperado de la tabla1 (.*),(.*),(.*)$")
    public void seleccionaElResultadoEsperadoDeLaTablaScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                partesDeHorasTask.filterByQbeOnTableConsultaParteDeHoras(scn, page, file, false, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                break;
            case PARTES_DE_HORAS__TRASPASO:
                partesDeHorasTask.filterByQbeOnTable1TraspasoParteDeHoras(scn, page, file, false, false);
                //INFO: @PRE aqui hay 2 veces el mismo metodo, porque la primera vez, cuando hace click salta un sp
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                break;
        }
    }

    @And("^selecciona el resultado esperado de la tabla2 (.*),(.*),(.*)$")
    public void seleccionaElResultadoEsperadoDeLaTabla2ScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        switch (page) {
            case PARTES_DE_HORAS__TRASPASO:
                partesDeHorasTask.filterByQbeOnTable2TraspasoParteDeHoras(scn, page, file, false, false);
                //INFO: @PRE aqui hay 2 veces el mismo metodo, porque la primera vez, cuando hace click salta un sp
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE2", 2, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE2", 2, false);
                break;
        }
    }


    @And("^selecciona el registro modificado (.*),(.*),(.*)$")
    public void seleccionaElRegistroModificado(String scn, SystemPages page, String file) throws Exception {
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                partesDeHorasTask.filterByQbeOnTableConsultaParteDeHoras(scn,page,file,false,false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->TABLE", 1, false);
                break;
            case PARTES_DE_HORAS__TRASPASO:
                partesDeHorasTask.filterByQbeOnTable1TraspasoParteDeHoras(scn,page,file,false,false);
                //INFO: @PRE aqui hay 2 veces el mismo metodo, porque la primera vez, cuando hace click salta un sp
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE1", 1, false);
                break;
            default:
                System.out.println("@DEBUG no se ha seleccionado nada");
        }
    }

    @And("^hace click en Anadir Parte y selecciona el registro en la tabla siguiente (.*),(.*),(.*)$")
    public void haceClickEnAnadirParteYSeleccionaElRegistroEnLaTablaSiguienteScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ANADIRPARTE,null,null,true,true);
        partesDeHorasTask.filterByQbeOnTable2TraspasoParteDeHoras(scn,page,file,false,false);
        commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->TABLE2", 2, false);
    }

    @And("^hace click en Traspasar$")
    public void haceClickEnTraspasar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_TRASPASAR,null,null,true,true);
    }

    @Then("^aparece una notifación que indica que el parte se ha traspasado correctamente$")
    public void apareceUnaNotifacionQueIndicaQueElParteSeHaTraspasadoCorrectamente() throws Exception{
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Los partes de horas seleccionados han sido traspasados correctamente",true, true, true);
    }

    @And("^hace click en el botón Modificar$")
    public void haceClickEnElBotónModificar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAR,null,null,true,true);
    }

    @And("^hace click en el botón Guardar Traspasar$")
    public void haceClickEnElBotónGuardarTraspasar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GUARDARTRASPASAR,null,null,true,true);
    }

    /**
     * Este  metodo desactiva el check del validado, pero depende del dato el cual debe ser "chk_aNivelNacional": "false"
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    @Then("^desactiva el check de validado (.*),(.*),(.*)$")
    public void desactivaElCheckDeValidado(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.seleccionarCheckValidado(scn,page,file,true,true);
    }

    @And("^hace click en el boton Eliminar$")
    public void haceClickEnElBotonEliminar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ELIMINAR,null,null,true,true);
    }

    @Then("^se visualiza una notificación con el mensaje `Antes debe enviar la baja a Oracle`$")
    public void seVisualizaUnaNotificaciónConElMensajeAntesDebeEnviarLaBajaAOracle() {
        //TODO: saber el mensaje exacto y saber si es un dialogo o una notifiación
        throw new io.cucumber.java.PendingException();
    }

    @And("^aparece el dialogo de Borrado de parte y hacemos click en SI$")
    public void apareceElDialogoDeBorradoDeParteYHacemosClickEnSI() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO, null, PanelTitle.DIALOG_BORRADODEPARTE, true, true);
    }

    @Then("aparece una notificación que dice El parte de horas ha sido eliminado correctamente")
    public void apareceUnaNotificacionQueDiceElParteDeHorasHaSidoEliminadoCorrectamente() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El parte de horas ha sido eliminado correctamente", false, true, true);
    }

    @Then("aparece una notificación indicando que el parte ha sido insertado y traspasado con exito")
    public void apareceUnaNotificaciónIndicandoQueElParteSeHaSidoInsertadoYTraspasadoConExito() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "El parte de horas ha sido insertado y traspasado con éxito", false, true, true);
    }

    @Then("aparece una notificación indicando que el parte ha sido modificado y traspasado con exito")
    public void apareceUnaNotificaciónIndicandoQueElParteHaSidoModificadoYTraspasadoConExito() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "El parte de horas ha sido modificado y traspasado con éxito", false, true, true);
    }

    @Then("aparece una notificación indicando que el parte se ha sido modificado con exito")
    public void apareceUnaNotificaciónIndicandoQueElParteSeHaSidoModificadoConExito() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "Parte de Horas ha sido modificado con éxito", false, true, true);
    }


    @And("^se toma nota del numero de parte (.*),(.*),(.*)$")
    public void seTomaNotaDelNumeroDeParte(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.consultarYGuardarNumeroDeParte(file, page);
    }

    @And("^añadimos un concepto nomina (.*),(.*),(.*)$")
    public void anadimosUnConceptoNomina(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.tabConceptosColaborador(scn, page, file, false, false);
    }

    @And("^activa el check de validado (.*),(.*),(.*)$")
    public void activaElCheckDeValidadoScenarioPARTES_DE_HORAS__MODIFICACIONFichero_datos(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.seleccionarCheckValidado(scn,page,file,true,true);
    }

    @And("^rellena los campos necesarios del formulario de busqueda de partes para enviar a oracle (.*),(.*),(.*)$")
    public void rellenaLosCamposNecesariosDelFormularioDeBusquedaDePartesParaEnviarAOracleScenario(String scn, SystemPages page, String file) throws Exception {
        if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
            PartesDeHorasServiceType partesDeHorasServiceType = new PartesDeHorasServiceType(driver);
            PartesDeHorasServiceSelect partesDeHorasServiceSelect = new PartesDeHorasServiceSelect(driver);
            PartesDeHorasServiceLookupField partesDeHorasServiceLookupField = new PartesDeHorasServiceLookupField(driver);
            PartesDeHorasServiceCheckbox partesDeHorasServiceCheckbox = new PartesDeHorasServiceCheckbox(driver);

            partesDeHorasServiceType.typeEmpresa( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceSelect.selectMes( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceType.typeAnio( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceType.typeNombre( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceType.typePrimerApellido( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceType.typeSegundoApellido( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceLookupField.lkpNif( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceCheckbox.checkPartesEnviadosAOracle( scn, page, null, file, 1, false, true, true );
            partesDeHorasServiceCheckbox.checkANivelNacional( scn, page, null, file, 1, false, true, true );

        }
    }

    @Then("aparece una notificación indicando que el parte ha sido insertado con exito")
    public void apareceUnaNotificaciónIndicandoQueElParteHaSidoInsertadoConExito() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "Parte de Horas ha sido insertado con éxito", false, true, true);
    }

}


