package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneracionMasivaPartesSteps extends TestBase {

    @And("^se ingresa el mes y el anio (.*),(.*),(.*)$")
    public void  rellanaLosDatosNecesariosParaPresentarInforme(String scn, SystemPages page, String file) throws Exception {
        generacionMasivaPartesTask.completeFieldsGeneracionMasivaPartes(scn, page, file);
    }

    @When("^hace click en Presentar Informe")
    public void haceClickEnElBotonPresentarInforme() throws Exception {
        generacionMasivaPartesTask.clickBtn(FieldByTagLabelText.PRESENTAR_INFORME,null, null,  true, true);
    }

    @Then("^hace click en Generar Partes")
    public void haceClickEnElBotonGenerarPartes() throws Exception {
        generacionMasivaPartesTask.clickBtn(FieldByTagLabelText.GENERAR_PARTES,null, null,  true, true);
    }

    @And("hace click en Si para confirmar")
    public void  haceClickEnElBotonSi() throws Exception {
        generacionMasivaPartesTask.clickBtn(FieldByTagLabelText.BTN_SI,null, null,  true, true);
    }
}
