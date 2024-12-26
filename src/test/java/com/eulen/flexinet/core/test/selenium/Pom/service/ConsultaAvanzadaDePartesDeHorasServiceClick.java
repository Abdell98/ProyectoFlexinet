package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaAvanzadaDePartesDeHorasServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ConsultaAvanzadaDePartesDeHorasServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnBuscar(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                dialogTitle,
                "Buscar",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnAsociarColaborador(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                dialogTitle,
                "Asociar Colaborador",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnModificar(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                dialogTitle,
                "Modificar",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

}
