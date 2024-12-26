package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class PartesDeHorasServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PartesDeHorasServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    //TODO pendiente borrar si no se usa
    public boolean anadirColaboradorConceptoNomina(String file) throws Exception {
        //Miramos si en el json indicamos `__TRUE__` al campo `btn_AnadirColaboradorConceptoNomina` para rellenar el dialogo de concepto colaborador
        jsonFileNew(file);
        JsonCommand btn = new JsonCommand();
        return btn.convertCommandBtnClickToBoolean(datosPartesDeHoras.getPartesDeHorasAlta().getTabConceptosColaborador().getSectionNomina().getBtn_AnadirColaboradorConceptoNomina());
    }

}
