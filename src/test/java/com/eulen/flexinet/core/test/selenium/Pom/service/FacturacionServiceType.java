package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class FacturacionServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public FacturacionServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getRazonSocial();
                break;
        }
        commonService.typeInputField(scn, panelTitle, FieldByTagLabelText.EMPRESACLIENTERAZONSOCIAL, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getTable().getQbe_empresa();
                break;
        }
        commonService.typeInputField(scn, panelTitle, FieldByTagLabelText.QBE_EMPRESA, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void typeQbeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getDialogSeleccionEmpresa().getQbe_nIF();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_NIF, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeNroDocumento(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getNDocumento();
                break;
        }
        commonService.typeInputField(scn, panelTitle, FieldByTagLabelText.NUMDOCUMENTO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

}

