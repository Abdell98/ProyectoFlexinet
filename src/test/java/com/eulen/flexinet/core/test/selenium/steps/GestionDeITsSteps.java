package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GestionDeITsSteps extends TestBase {

    @And("^se ingresan los datos del colaborador (.*),(.*),(.*)$")
    public void  rellanaLosDatosNecesariosParaLaGestionDeITs(String scn, SystemPages page, String file) throws Exception {
        gestionITsTask.completeFieldsGestionITs(scn, page, file);
        gestionITsTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,false);
    }

    @And("^hace click en Añadir IT")
    public void haceClickEnElBotonAnadirIT() throws Exception {
        gestionITsTask.click(driver.findElement(By.xpath("//div[@class='ui-growl-icon-close fa fa-close']")));
        gestionITsTask.clickBtn(FieldByTagLabelText.BTN_ANADIRIT,null, null,  true, true);
    }

    @Then("^se ingresan los datos del IT (.*),(.*),(.*)$")
    public void rellanaLosDatosNecesariosParaAnadirIT(String scn, SystemPages page, String file) throws Exception {
        gestionITsTask.completeFieldsAniadirIT(scn, page, file);
    }

    @And("^hace click en Aceptar")
    public void haceClickEnElBotonAceptar() throws Exception {
        gestionITsTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR,null, PanelTitle.DIALOG_ALTADEIT, true, true);
        gestionITsTask.clickBtn(FieldByTagLabelText.BTN_OK,null, PanelTitle.DIALOG_INFORMACION, true, true);
    }

    @Then("^comprueba que se ha creado el IT (.*),(.*),(.*)$")
    public void comprobarCreacionIT(String scn, SystemPages page, String file) throws Exception {
        commonTask.waitUntilIsDisplayed(By.xpath("//th/span[contains(text(), 'Fecha Inicio')]"));
        commonTask.clickFirstValidRowResultOnTable(scn, page, null, file, "TestDatosGestionITs->GESTION_DE_ITS->TABLE", 1, false);

    }

    @And("^borra el IT creado")
    public void haceClickEnElBotonBorrarIT() throws Exception {
        gestionITsTask.clickBtnBorrarIT();
    }

    @And("^filtrar por fecha de IT (.*),(.*),(.*)$")
    public void filtrarPorFechaDeIT(String scn, SystemPages page, String file) throws Exception {
        gestionITsTask.rellenarFechaYFiltrarTabla(scn, page, file );
    }

    @And("^comprobar 'Traspasado' no esta checkeado (.*)$")
    public void comprobarTraspasadoNoCheckeado(String file) throws Exception {
        gestionITsTask.comprobarTraspasado(file);
    }
}
