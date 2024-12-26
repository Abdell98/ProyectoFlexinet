package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GestionClientesContratoSteps extends TestBase {


    @And("^la selecciona y hace click en la fila correspondiente del resultado de la tabla (.*),(.*),(.*)$")
    public void laSeleccionaYHaceClickEnLaFilaCorrespondienteDelResultadoDeLaTabla(String scn, SystemPages page, String file) throws Exception{
        gestionClientesContratoTask.seleccionarHacerClickEnPrimerResultado(scn, page, file);
    }

    @When("^hace click en Alta Cliente Contrato$")
    public void haceClickEnAltaClienteContrato() throws Exception {
        gestionClientesContratoTask.hacerClickAltaContrato();
    }

    @And("hace click en Modificacion")
    public void haceClickEnModificacion() throws Exception {
        gestionClientesContratoTask.hacerClickModificacion();
    }

    @When("^aparecen las pestañas de gestion y se comprueba que existen campos obligatorios sin rellenar (.*),(.*),(.*)$")
    public void aparecenLasPestanasDeGestionYSeCompruebaQueExistenCamposObligatoriosSinRellenar(String scn, SystemPages page, String file) throws Exception{
        gestionClientesContratoTask.validarCampos(scn, page, file);
    }

    @Then("^aparece de atención indicando que faltan campos requeridos por rellenar$")
    public void apareceDeAtencionIndicandoQueFaltanCamposRequeridosPorRellenar() throws Exception{
        gestionClientesContratoTask.verificaElMensajeDeAtencion();
    }

    // comprobar mensaje
    @Then("^aparece un mensaje de error indicando que el cliente contrato no ha sido dado de alta$")
    public void apareceUnMensajeDeErrorIndicandoQueElClienteContratoNoHaSidoDadoDeAlta() throws Exception {
        gestionClientesContratoTask.verificaElMensajeAltaKO();
    }

    @Then("^aparece un mensaje que indica que el cliente contrato ha sido de alta correctamente y se ha enviado al erp$")
    public void apareceUnMensajeQueIndicaQueElClienteContratoHaSidoDeAltaCorrectamenteYSeHaEnviadoAlErp() throws Exception {
        gestionClientesContratoTask.verificaElMensajeAltaOK();
    }

    // comprobando entidades en client_con
    @And("^finalmente comprueba que NO se han creado entidades nuevas en la tabla CLIENT_CON (.*),(.*),(.*),(.*)$")
    public void finalmenteCompruebaQueNoSeHanCreadoEntidadesNuevasEnLaTablaCLIENT_CONScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        gestionClientesContratoTask.confirmarSiHayNuevasEntidadesClienteContratoDespuesDeGuardar(scn, page, file, oficina);
    }

    @And("^finalmente comprueba que SI se ha creado una nueva entidad en la tabla CLIENT_CON (.*),(.*),(.*),(.*)$")
    public void finalmenteCompruebaQueSeHaCreadoUnaNuevaEntidadEnLaTablaCLIENT_CONScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        gestionClientesContratoTask.confirmarSiHayNuevasEntidadesClienteContratoDespuesDeGuardar(scn, page, file, oficina);
    }

    @And("^finalmente se comprueba que NO se ha modificado la información del cliente contrato (.*),(.*),(.*),(.*)$")
    public void finalmenteCompruebaQueNOSeHaModificadoLaInformacionDelClienteContratoScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        if(scn.equals("ModificarCentroDeTrabajoEnvioKO")) return; //TODO Quitar
        gestionClientesContratoTask.confirmarDespuesDeGuardarQueNoHaSidoModificadoElClienteContrato(scn, page, file, oficina);
    }

    @And("^finalmente se comprueba que SI se ha modificado la información del cliente contrato (.*),(.*),(.*),(.*)$")
    public void finalmenteSeCompruebaQueSISeHaModificadoLaInformacionDelClienteContratoScenarioPaginaFichero_datosOficina(String scn, SystemPages page, String file, String oficina) throws Exception {
        if (scn.equals("ModificarCentroDeTrabajoEnvioOK")) return; //TODO Quitar
        gestionClientesContratoTask.confirmarCambiosGuardadosEnTablaClienteContrato(scn, page, file, oficina);
    }

}
