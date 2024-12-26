package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class GestionCentrosDeTrabajoServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionCentrosDeTrabajoServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnAltaCentroDeTrabajo(boolean waitForSpinner, boolean checkNoUnexpectedMessage) throws Exception {
        click(pageLocators.getBtnAltaCentroDeTrabajo());

        if(waitForSpinner) {
            waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }

        if(checkNoUnexpectedMessage) {
            commonService.checkNoUnexpectedMessageIsShown();
        }
    }

    public void clickBtnLupa() throws Exception {
        click(pageLocators.getBtnLupa());
    }

    public void clickBtnModificarCentrodeTrabajo() throws Exception {
        click(pageLocators.getBtnModificarCentroDeTrabajo());
    }
}
