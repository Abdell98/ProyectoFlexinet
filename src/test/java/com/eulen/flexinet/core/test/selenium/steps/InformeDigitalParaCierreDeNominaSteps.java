package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InformeDigitalParaCierreDeNominaSteps extends TestBase {

    @And("^el usuario hace click en boton detalle del colaborador$")
    public void elUsuarioHaceClickEnBotonDetalleDelColaborador() throws Exception {
        informeDigitalParaCierreDeNominaTask.clickBtnDetalleColaborador();
    }

    @When("el usuario rellena formulario de consulta pag. Informe Digital Para Cierre de Nominas(.*),(.*),(.*)$")
    public void elUsuarioIngresaLosDatosDelFormularioInformeDigitalParaCierredeNominas(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.ingresarDatosDelFormularioDeConsulta(scn, page, file);
    }

    @And("el usuario hace click en el boton presentar informe(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnPresentarInforme(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_PRESENTARINFORME, null, null, true, true);
    }

    @And("el usuario hace click en el boton si(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnSi(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, null, true, true);
    }

    @And("el usuario ingresa los datos de la tabla de informes(.*),(.*),(.*)$")
    public void elUsuarioIngresaDatosTablaInformes(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.ingresarDatosTablaInformes(scn, page, file);
    }

    @And("el usuario selecciona la primera fila de la tabla de informes(.*),(.*),(.*)$")
    public void elUsuarioSeleccionaPrimeraFila(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickFirstValidRowResultOnTable(scn, page,null, file,"TestDatosInformeDigitalParaCierreDeNomina->GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA->TABLE",1,false);
    }

    @And("el usuario ingresa los datos de la pagina detalle del colaborador(.*),(.*),(.*)$")
    public void elUsuarioIngresaDatosDetalleColaborador(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.ingresarDatosDetalleColaborador(scn, page, file);
    }

    @And("el usuario activa check (.*),(.*),(.*)$")
    public void elUsuarioActivaCheck(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.activarCheck(scn, page, file);
    }

    @And("el usuario hace click en el boton guardar(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnElBotonGuardar(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GUARDAR, null, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, true, true);
    }

    @And("el usuario hace click en el boton grabar(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnElBotonGrabar(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_GRABAR, null, null, true, true);
    }

    @And("el usuario elimina concepto de la tabla de conceptos(.*),(.*),(.*)$")
    public void elUsuarioEliminaConcepto(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickFirstValidRowResultOnTable(scn, page,PanelTitle.DIALOG_DETALLEDELCOLABORADOR, file,"TestDatosInformeDigitalParaCierreDeNomina->GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA->DIALOGO_DETALLEDELCOLABORADOR->SECCIONNOMINAS->TABLE",1,true);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ELIMINARCONCEPTO, null, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, true, false);
    }

    @And("el usuario hace click en boton cerrar aviso$")
    public void clickBtnCerrarAviso() throws Exception {
        informeDigitalParaCierreDeNominaTask.clickBtnCerrarAviso();
    }

    @And("el usuario hace click en boton eliminar linea(.*),(.*),(.*)$")
    public void elUsuarioHaceClickEnElBotonEliminarLinea(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ELIMINARLINEA, null, PanelTitle.DIALOG_DETALLEDELCOLABORADOR, true, true);
    }

    @Then("se muestra mensaje de exito")
    public void seMuestraMensajeDeExito() throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.EXITO, "Los datos han sido grabados.", false, true, true);
    }

    @And("el usuario modifica las horas extras(.*),(.*),(.*)$")
    public void elUsuarioModificaLasHorasExtras(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.ModificarHorasExtras(scn, page, file);
    }

    @And("el usuario modifica las horas festiva(.*),(.*),(.*)$")
    public void elUsuarioModificaLasHorasFestiva(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.ModificarHorasFestiva(scn, page, file);
    }

    @And("el usuario selecciona un concepto(.*),(.*),(.*)$")
    public void elUsuarioSeleccionaUnConcepto(String scn, SystemPages page, String file) throws Exception {
        informeDigitalParaCierreDeNominaTask.SeleccionarConcepto(scn, page, file);
    }
}
