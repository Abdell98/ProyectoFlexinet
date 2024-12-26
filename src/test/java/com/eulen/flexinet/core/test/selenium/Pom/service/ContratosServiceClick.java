package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContratosServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ContratosServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnAsociarColaborador(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton( null, dialogTitle, "Asociar Colaborador", 1 );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnBuscar(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton( null, dialogTitle, "Buscar", 1 );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnTraspasarAErp(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton( null, dialogTitle, "Traspasar a Erp", 1 );
        commonService.verticalScrollTo(button);
        commonService.click(button);
        commonService.waitUntilSpinnerIsDisplayed();
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnContrato(PanelTitle tabTitle, PanelTitle dialogTitle, FieldByTagLabelText buttonLabel, Integer cajaNumero, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButtonContrato( tabTitle, dialogTitle, buttonLabel.getCodigo(), cajaNumero );
        commonService.verticalScrollTo(button);
        commonService.click(button);

        if (waitForSpinner.equals(Boolean.TRUE)) {
            commonService.waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        }
        if (checkNoMessageShown.equals(Boolean.TRUE)) {
            commonService.checkNoUnexpectedMessageIsShown();
        }
    }
}
