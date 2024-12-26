package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GestionCentrosDeTrabajoSteps extends TestBase {

    @And("^selecciona el cliente contrato (.*),(.*),(.*)$")
    public void seleccionaElClienteContratoYHaceClickEnAltaCentroDeTrabajo(String scn, SystemPages page, String file) throws Exception {
        gestionCentrosDeTrabajoTask.seleccionarClienteContrato(scn, page, file);
    }

    @And("^hace click en Alta Centro de Trabajo (.*)$")
    public void haceClickEnAltaCentroDeTrabajo(String scn) throws Exception {
        gestionCentrosDeTrabajoTask.hacerClickAltaCentroDeTrabajo(scn);
    }

    @Then("^aparece un mensaje que indica que el centro de trabajo ha sido de alta correctamente y se ha enviado al erp$")
    public void apareceUnMensajeQueIndicaQueElCentroDeTrabajoHaSidoDeAltaCorrectamenteYSeHaEnviadoAlErp() throws Exception {
        gestionCentrosDeTrabajoTask.verificaElMensajeAltaOK();
    }

    @And("^finalmente comprueba que SI se ha creado una nueva entidad en la tabla CENTRO (.*),(.*),(.*),(.*)$")
    public void finalmenteCompruebaQueSISeHaCreadoUnaNuevaEntidadEnLaTablaCENTROScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        gestionCentrosDeTrabajoTask.confirmarDespuesDeGuardarSiHayNuevasEntidadesCentroDeTrabajo(scn, page, file, oficina);
    }

    @Then("^aparece un mensaje de error indicando que el centro de trabajo no ha sido dado de alta$")
    public void apareceUnMensajeDeErrorIndicandoQueElCentroDeTrabajoNoHaSidoDadoDeAlta() throws Exception {
        gestionCentrosDeTrabajoTask.verificaElMensajeAltaKO();
    }

    @And("^finalmente comprueba que NO se ha creado una nueva entidad en la tabla CENTRO (.*),(.*),(.*),(.*)$")
    public void finalmenteCompruebaQueNOSeHaCreadoUnaNuevaEntidadEnLaTablaCENTROScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        gestionCentrosDeTrabajoTask.confirmarDespuesDeGuardarSiHayNuevasEntidadesCentroDeTrabajo(scn, page, file, oficina);
    }

    @And("^selecciona un resultado de la tabla (.*),(.*),(.*)$")
    public void seleccionaUnResultadoDeLaTabla(String scn, SystemPages page, String file) throws Exception {
        gestionCentrosDeTrabajoTask.seleccionarPrimerRecordDeLaTabla(scn, page, file);
    }

    @And("^hace click en Modificar Centro de Trabajo$")
    public void haceClickEnModificarCentroDeTrabajo() throws Exception{
        gestionCentrosDeTrabajoTask.clickModificarCentroDeTrabajo();
    }
}
