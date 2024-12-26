package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PedidosServiceLookupField extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private PedidosServiceClick pedidosServiceClick;
    private PedidosServiceType pedidosServiceType;

    private CommonServiceClick commonServiceClick;

    public PedidosServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        pedidosServiceClick = new PedidosServiceClick(driver);
        pedidosServiceType = new PedidosServiceType(driver);
        commonServiceClick = new CommonServiceClick(driver);
    }

    //INFO: el siguiente metodo solo sirve para TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSCOLABORADORES->DIALOG_SELECCIONDECOLABORADORES->TABLE
    //  cambiar si se tiene que ajustar para otra página
    public void lkpNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datos.getPedidosConsulta().getNIF();
        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.NIF +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.NIF +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.NIF.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        pedidosServiceType.typeQbeNombreYApellidos( 
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                true,
                true
        );

        pedidosServiceType.typeQbeDireccion( 
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                true,
                true
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                FieldByTagLabelText.QBE_DIRECCION,
                1
        ).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        String jsonObjPathAux = "";
        switch (page) {
            case PEDIDOS__CONSULTA:
                jsonObjPathAux = "TestDatos->PEDIDOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            default:
                jsonObjPathAux = "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSCOLABORADORES->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
        }

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                jsonObjPathAux,
                1,
                true
        );

        pedidosServiceClick.clickBtnAsociarColaborador( //INFO: Este campo solo utiliza el panelTitle
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                true,
                true,
                true
        );

    }

    //TODO: lo siguiente solo sirve para la página  TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE
    // ajutar si se quiere para otra
    public void lkpEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown)  throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datos.getPedidosConsulta().getEmpresa();

        if(jsonFieldData == null || jsonFieldData.isEmpty()) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.EMPRESA +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.EMPRESA +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.EMPRESA.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if(waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if(checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        pedidosServiceType.typeEmpresaClienteRazonSocial( 
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        pedidosServiceType.typeQbeEmpresa( 
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        pedidosServiceType.typeQbeNif( 
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                FieldByTagLabelText.QBE_NIF,
                1
        ).sendKeys(Keys.ENTER);

        String jsonObjPathAux = "";
        switch (page) {
            case PEDIDOS__CONSULTA:
                jsonObjPathAux = "TestDatos->PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->TABLE";
                break;
            default:
                jsonObjPathAux = "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSCOLABORADORES->DIALOG_BUSQUEDADEEMPRESAS->TABLE";
                break;
        }

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                jsonObjPathAux,
                1,
                true
        );

    }

}
