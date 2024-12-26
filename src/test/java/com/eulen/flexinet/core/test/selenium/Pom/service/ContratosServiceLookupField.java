package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.reader.TestDatosContrato;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContratosServiceLookupField extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    private ContratosServiceClick contratosServiceClick;
    private ContratosServiceType contratosServiceType;

    private CommonServiceClick commonServiceClick;

    public ContratosServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        contratosServiceType = new ContratosServiceType(driver);
        contratosServiceClick = new ContratosServiceClick(driver);
    }

    //TODO: el siguiente metodo solo sirve para TestDatosContrato->CONTRATOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE
    //  cambiar si se tiene que ajustar para otra página
    public void lkpNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getLkp_nIF();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getLkp_nIF();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getLkp_nIF();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getLkp_nIF();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getLkp_nIF();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getLkp_nIF();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getLkp_nIF();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getLkp_nIF();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getLkp_nIF();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getLkp_nIF();
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getLkp_nIF();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getLkp_nIF();
                break;
        }
        String jsonFieldData = datos;
        if (jsonFieldData == null) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `" + FieldByTagLabelText.NIF + "`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, ingresar un valor valido en el archivo de datos");
            } else {
                System.out.println("campo `" + FieldByTagLabelText.NIF + "`...SALTADO!!");
                return;
            }
        }

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }


        contratosServiceType.typeQbeNombreYApellidos(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                false,
                false
        );

        contratosServiceType.typeQbeDireccion(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                FieldByTagLabelText.QBE_DIRECCION,
                1
        ).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        String datosJson = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datosJson = "TestDatosContrato->CONTRATOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datosJson = "TestDatosContrato->CONTRATOS__TRASPASO_MASIVO->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datosJson = "TestDatosContrato->CONTRATOS__BAJA_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__ANULACION:
                datosJson = "TestDatosContrato->CONTRATOS__ANULACION->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datosJson = "TestDatosContrato->CONTRATOS__BAJA_DARDEBAJA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datosJson = "TestDatosContrato->CONTRATOS__BAJA_BAJAS_MASIVAS->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datosJson = "TestDatosContrato->CONTRATOS__PRORROGAS_CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datosJson = "TestDatosContrato->CONTRATOS__PRORROGAS_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datosJson = "TestDatosContrato->CONTRATOS__PRORROGAS_ANULACION->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__NOVACION_ALTA:
                datosJson = "TestDatosContrato->CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datosJson = "TestDatosContrato->CONTRATOS__ALTA_SUSTITUCION->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datosJson = "TestDatosContrato->CONTRATOS__CONTROL_ENVIOS_CPDS->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                datosJson,
                1,
                true
        );

        contratosServiceClick.clickBtnAsociarColaborador( //INFO: Este campo solo utiliza el panelTitle
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

    public void lkpEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getLkp_empresa();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getLkp_empresa();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getLkp_empresa();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getLkp_empresa();
                break;
        }
        String jsonFieldData = datos;
        if (jsonFieldData == null) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, ingresar un valor valido en el archivo de datos");
            } else {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...SALTADO!!");
                return;
            }
        }

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        commonService.click(lupa);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        contratosServiceType.typeEmpresaCliente(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        Thread.sleep(2000);

        contratosServiceClick.clickBtnBuscar( //INFO: Este campo solo utiliza el panelTitle
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                true,
                true,
                true
        );

        contratosServiceType.typeQbeEmpresa(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        contratosServiceType.typeQbeNif(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        Thread.sleep(2000);

        String datosJson = "";
        switch (page){
            case CONTRATOS__PRORROGAS_ANULACION:
                datosJson = "TestDatosContrato->CONTRATOS__PRORROGAS_ANULACION->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datosJson = "TestDatosContrato->CONTRATOS__PRORROGAS_ALTA->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case CONTRATOS__NOVACION_ALTA:
                datosJson = "TestDatosContrato->CONTRATOS__NOVACION_ALTA->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datosJson = "TestDatosContrato->CONTRATOS__CONTROL_ENVIOS_CPDS->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                datosJson,
                1,
                true
        );

    }

}
