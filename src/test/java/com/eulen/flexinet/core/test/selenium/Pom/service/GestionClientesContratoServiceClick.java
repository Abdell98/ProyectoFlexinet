package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

public class GestionClientesContratoServiceClick extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public GestionClientesContratoServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnAltaClienteContrato() throws Exception {
        try {
            click(pageLocators.getBtnAltaClienteContrato());
        } catch (Exception e) {
            throw new NotFoundException("ERROR: El botón de alta cliente contrato está deshabilitado o no se ha encontrado.");
        }
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnModificacion() throws Exception {
        click(pageLocators.getBtnModificacion());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

}
