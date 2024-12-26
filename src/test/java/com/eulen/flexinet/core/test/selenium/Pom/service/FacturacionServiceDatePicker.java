package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class FacturacionServiceDatePicker extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public FacturacionServiceDatePicker(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void pickDateDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getRangoFechaDesde();
                break;
        }
        commonService.datePickerField( scn, panelTitle, FieldByTagLabelText.DATE_DESDE_SIN_PUNTOS, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void pickDateHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getRangoFechaHasta();
                break;
        }
        commonService.datePickerField( scn, panelTitle, FieldByTagLabelText.DATE_HASTA_SIN_PUNTOS, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

}
