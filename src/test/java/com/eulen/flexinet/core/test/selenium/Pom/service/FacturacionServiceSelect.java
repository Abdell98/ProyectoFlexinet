package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class FacturacionServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private ContratosServiceClick contratosServiceClick;
    private ContratosServiceType contratosServiceType;
    private CommonServiceClick commonServiceClick;

    public FacturacionServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        contratosServiceType = new ContratosServiceType(driver);
        contratosServiceClick = new ContratosServiceClick(driver);
    }

    public void selectFacturas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.selectField( scn, panelTitle, FieldByTagLabelText.FACTURAS, FieldType.select, cajaNumero, datosFacturacion.getFacturacionConsulta().getFacturas(), isRequired, waitForSpinner, checkNoMessageShown );
    }
}
