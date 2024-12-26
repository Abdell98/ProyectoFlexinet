package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformeDigitalParaCierreDeNominaServiceLookupField extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private InformeDigitalParaCierreDeNominaServiceClick InformeDigitalParaCierreDeNominaServiceClick;
    private InformeDigitalParaCierreDeNominaServiceType InformeDigitalParaCierreDeNominaServiceType;


    public InformeDigitalParaCierreDeNominaServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        InformeDigitalParaCierreDeNominaServiceClick = new InformeDigitalParaCierreDeNominaServiceClick(driver);
        InformeDigitalParaCierreDeNominaServiceType = new InformeDigitalParaCierreDeNominaServiceType(driver);
    }

    public void lkpEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosInformeDigitalParaCierreDeNomina.getInforme().getEmpresa();
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

        Thread.sleep(2000);

        commonService.click(lupa);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        InformeDigitalParaCierreDeNominaServiceType.typeEmpresaCliente(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceClick.clickBtnBuscar(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                true,
                true,
                true
        );

        InformeDigitalParaCierreDeNominaServiceType.typeQbeBusquedaEmpresa(
                scn,
                page,
                PanelTitle.DIALOG_BUSQUEDADEEMPRESAS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeQbeBusquedaNif(
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

        Thread.sleep(2000);

        String datosJson = "TestDatosInformeDigitalParaCierreDeNomina->GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA->DIALOGO_BUSQUEDADEEMPRESAS->TABLE";

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

    public void lkpHorasExtras(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getExtra();
        if (jsonFieldData == null) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, ingresar un valor valido en el archivo de datos");
            } else {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...SALTADO!!");
                return;
            }
        }

        WebElement element = pageLocators.getBtnLupaUnidadesExtra();

        waitUntilIsDisplayed(element);

        commonService.click(element);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        InformeDigitalParaCierreDeNominaServiceType.typeUnidadesExtra(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeTotalExtra(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeImporteExtra(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                file,
                1,
                false,
                false,
                false
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                FieldByTagLabelText.BTN_ACEPTAR,
                1,
                true,
                true
        );
    }

    public void lkpHorasFestiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getFestiva();
        if (jsonFieldData == null) {
            if (isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, ingresar un valor valido en el archivo de datos");
            } else {
                System.out.println("campo `" + FieldByTagLabelText.EMPRESA + "`...SALTADO!!");
                return;
            }
        }

        WebElement element = pageLocators.getBtnLupaUnidadesFestiva();

        waitUntilIsDisplayed(element);

        commonService.click(element);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        InformeDigitalParaCierreDeNominaServiceType.typeUnidadesFestiva(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeTotalFestiva(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeImporteFestiva(
                scn,
                page,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                file,
                1,
                false,
                false,
                false
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                FieldByTagLabelText.BTN_ACEPTAR,
                1,
                true,
                true
        );
    }

    public void lkpConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getConcepto();
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
                FieldByTagLabelText.CONCEPTO,
                FieldType.input,
                cajaNumero
        );

        WebElement lupa = waitUntilIsDisplayed(element, By.xpath(".//following::button[1]"));

        Thread.sleep(2000);

        commonService.click(lupa);

        if (waitForSpinner) {
            commonService.waitUntilSpinnerIsNotDisplayed();
        }

        if (checkNoMessageShown) {
            commonService.checkNoUnexpectedMessageIsShown();
        }

        InformeDigitalParaCierreDeNominaServiceType.typeConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        InformeDigitalParaCierreDeNominaServiceType.typeQbeConceptosDisponible(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.QBE_CONCEPTOSDISPONIBLES,
                1
        ).sendKeys(Keys.ENTER);

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                "TestDatosInformeDigitalParaCierreDeNomina->GESTION_DE_INFORMES__INFORME_DE_CONTRATACION_Y_PERSONAL__INFORME_DIGITAL_PARA_CIERRE_DE_NOMINA->DIALOGO_DETALLEDELCOLABORADOR->SECCIONNOMINAS->LISTADODECONCEPTOS->TABLE",
                1,
                true
        );

        InformeDigitalParaCierreDeNominaServiceType.typeUnidadesConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeSalarialConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeTotalSalConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeCoeficienteConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typePvpConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        InformeDigitalParaCierreDeNominaServiceType.typeTotalPvpConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                false,
                false
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.BTN_ACEPTAR,
                1,
                true,
                true
        );
    }
}
