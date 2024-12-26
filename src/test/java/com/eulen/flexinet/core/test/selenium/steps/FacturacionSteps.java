package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class FacturacionSteps extends TestBase {

    @And("^se ingresa los datos de la razon social y selecciona la lupa (.*),(.*),(.*)$")
    public void seIngresaLosDatosDeLaRazonSocialYSeleccionaLaLupa(String scn, SystemPages page, String file) throws Exception{
        facturacionTask.completeRazonSocialForm(scn, page, file);
    }

    @And("^se ingresa los campos del formulario de consulta sobre la facturación (.*),(.*),(.*)$")
    public void rellenaLosCamposDelFormularioDeConsulta(String scn, SystemPages page, String file) throws Exception{
        facturacionTask.completeformularioConsultaFacturacion(scn, page, file);
    }

    @When("^el usuario hace click sobre la opción Buscar$")
    public void elUsuarioHaceClickSobreLaOpcionBuscar() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
    }

    @And("^selecciona la factura (.*),(.*),(.*)$")
    public void seleccionaLaFactura(String scn, SystemPages page, String file) throws Exception {
        facturacionTask.seleccionarFactura(scn, page, file);
    }

    @Then("^la consulta es satisfactoria (.*),(.*),(.*)$")
    public void seleccionaLaPrimeraFila(String scn, SystemPages page, String file) throws Exception {
        commonTask.clickFirstValidRowResultOnTable(scn, page, null, file,"TestDatosFacturacion->FACTURACION__CONSULTA->TABLE",1,false);
    }

    @And("el usuario realiza una busqueda por columna (.*),(.*),(.*)$")
    public void elUsuarioRealizaUnaBusquedaPorColumna(String scn, SystemPages page, String file) throws Exception {
        facturacionTask.busquedaQbeEmpresa(scn, page, file);
    }

    @And("el usuario realiza paginacion cambia el numero de lineas del paginado validando que la consulta sale según el paginado esperado (.*)$")
    public void realizarPaginacionYCambiaNumeroDeLineas(String file) throws Exception {
        commonTask.validatePager(file);
    }
}
