package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class ConsultaAvanzadaDePartesDeHorasServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private ConsultaAvanzadaDePartesDeHorasServiceClick ConsultaAvanzadaDePartesDeHorasServiceClick;
    private ConsultaAvanzadaDePartesDeHorasServiceType ConsultaAvanzadaDePartesDeHorasServiceType;

    public ConsultaAvanzadaDePartesDeHorasServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        ConsultaAvanzadaDePartesDeHorasServiceClick = new ConsultaAvanzadaDePartesDeHorasServiceClick(driver);
        ConsultaAvanzadaDePartesDeHorasServiceType = new ConsultaAvanzadaDePartesDeHorasServiceType(driver);
    }

    public void selectMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getMes();
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
