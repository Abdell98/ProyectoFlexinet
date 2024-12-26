package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsultaAvanzadaDePartesDeHorasSteps extends TestBase {

    @When("^el usuario rellena los datos del formulario de consulta (.*),(.*),(.*)$")
    public void elUsuarioIngresaDatosDelFormulario(String scn, SystemPages page, String file) throws Exception {
        consultaAvanzadaDePartesDeHorasTask.ingresarDatosDelFormularioDeConsulta(scn, page, file);
    }

    @And("^el usuario hace click en buscar")
    public void clickEnBuscarYSeleccionaElRegistroEncontrado() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
    }

    @And("el usuario selecciona el primer parte encontrado(.*),(.*),(.*)$")
    public void elUsuarioSeleccionaElPrimerParteEncontrado(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickFirstValidRowResultOnTable(scn, page,null, file,"TestDatosConsultaAvanzadaDePartesDeHoras->GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS->TABLE_PARTES",1,false);
    }

    @And("el usuario hace click en el botón Modificar(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnElBotonModificar(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAR,null,null,true,true);
    }

    @And("el usuario rellena los datos de la tabla de partes de horas(.*),(.*),(.*)$")
    public void rellenarDatosDeTablaDePartes(String scn, SystemPages page, String file) throws Exception {
        consultaAvanzadaDePartesDeHorasTask.rellenarDatosDeTablaDePartes(scn, page, file);
    }

    @And("el usuario modifica los datos del parte (.*),(.*),(.*)$")
    public void modificarDatosDelParte(String scn, SystemPages page, String file) throws Exception {
        partesDeHorasTask.tabPartesDeHorasNominas(scn,page,file,false,false);
        partesDeHorasTask.tabPartesDeHorasFacturacion(scn,page,file,false,false);
        partesDeHorasTask.tabConceptosIT(scn,page,file,false,false, false);
        partesDeHorasTask.tabConceptosColaborador(scn,page,file,false,false);
        partesDeHorasTask.checkValidado(scn,page,null,file,1,false,true,true);
    }

    @And("el usuario presiona boton guardar y traspasar")
    public void elUsuarioPresionaBotonGuardarYTraspasar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GUARDARTRASPASAR,null,null,true,true);
    }

    @Then("se muestra mensaje de exito parte modificado y traspasado")
    public void mensajeDeExitoParteModificadoYTraspasado() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "El parte de horas ha sido modificado y traspasado con éxito", false, true, true);
    }
}
