package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class InformeDigitalParaCierreDeNominaServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private InformeDigitalParaCierreDeNominaServiceClick InformeDigitalParaCierreDeNominaServiceClick;
    private InformeDigitalParaCierreDeNominaServiceType InformeDigitalParaCierreDeNominaServiceType;

    public InformeDigitalParaCierreDeNominaServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        InformeDigitalParaCierreDeNominaServiceClick = new InformeDigitalParaCierreDeNominaServiceClick(driver);
        InformeDigitalParaCierreDeNominaServiceType = new InformeDigitalParaCierreDeNominaServiceType(driver);
    }

    public void selectOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getOficina();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFICINA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getMes();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_MES,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
