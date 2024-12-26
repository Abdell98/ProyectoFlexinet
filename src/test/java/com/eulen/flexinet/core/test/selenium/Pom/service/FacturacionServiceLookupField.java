package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacturacionServiceLookupField extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private FacturacionServiceClick facturacionServiceClick;
    private FacturacionServiceType facturacionServiceType;
    private CommonServiceClick commonServiceClick;

    public FacturacionServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        facturacionServiceType = new FacturacionServiceType(driver);
        facturacionServiceClick = new FacturacionServiceClick(driver);
    }

    //TODO: el siguiente metodo solo sirve para TestDatosContrato->CONTRATOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE
    //  cambiar si se tiene que ajustar para otra página
    public void lkpRazonSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getLkp_razonSocial();
                break;
        }
        String jsonFieldData = datos;
        if (jsonFieldData == null) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `" + FieldByTagLabelText.RAZONSOCIAL + "`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, ingresar un valor valido en el archivo de datos");
            } else {
                System.out.println("campo `" + FieldByTagLabelText.RAZONSOCIAL + "`...SALTADO!!");
                return;
            }
        }
        Thread.sleep(2000);
        WebElement element = pageLocators.getField( panelTitle, FieldByTagLabelText.RAZONSOCIAL, FieldType.input, cajaNumero );
        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));
        Thread.sleep(2000);
        commonService.click(lupa);

        if (waitForSpinner) {commonService.waitUntilSpinnerIsNotDisplayed();}
        if (checkNoMessageShown) {commonService.checkNoUnexpectedMessageIsShown();}

        facturacionServiceType.typeEmpresa( scn, page, PanelTitle.DIALOG_BUSQUEDADEEMPRESAS, file, 1, false, false, false );
        Thread.sleep(2000);
        facturacionServiceClick.clickBtnBuscar( scn, page, PanelTitle.DIALOG_BUSQUEDADEEMPRESAS, file, 1, true, true, true );
        facturacionServiceType.typeQbeEmpresa( scn, page, PanelTitle.DIALOG_BUSQUEDADEEMPRESAS, file, 1, false, false, false );
        facturacionServiceType.typeQbeNif( scn, page, PanelTitle.DIALOG_BUSQUEDADEEMPRESAS, file, 1, false, false, false );
        Thread.sleep(2000);

        String datosJson = "";
        switch (page){
            case FACTURACION__CONSULTA:
                datosJson = "TestDatosFacturacion->FACTURACION__CONSULTA->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew( scn, page, PanelTitle.DIALOG_BUSQUEDADEEMPRESAS, file, datosJson, 1, true );
    }
}
