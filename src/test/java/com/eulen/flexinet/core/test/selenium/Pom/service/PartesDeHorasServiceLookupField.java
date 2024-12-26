package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartesDeHorasServiceLookupField extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private PartesDeHorasServiceType serviceType;

    public PartesDeHorasServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceType = new PartesDeHorasServiceType(driver);
    }

    public void lkpNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                jsonFieldData = datosPartesDeHoras.getPartesDeHorasConsulta().getLkp_nif();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                jsonFieldData = datosPartesDeHoras.getPartesDeHorasTraspaso().getLkp_nif();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                jsonFieldData = datosPartesDeHoras.getEnvioPartesAOracle().getLkp_nif();
                break;
        }
        if(jsonFieldData == null) {
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

        serviceType.typeQbeNombreYApellidos(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                true,
                true
        );

        serviceType.typeQbeDireccion(
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
            case PARTES_DE_HORAS__CONSULTA:
                jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case PARTES_DE_HORAS__TRASPASO:
                jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__TRASPASO->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__ENVIOSPARTESAORACLE->DIALOG_SELECCIONDECOLABORADORES->TABLE";
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

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                FieldByTagLabelText.BTN_ASOCIARCOLABORADOR,
                1,
                true,
                true
        );

    }


    public void lkpConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                jsonFieldData = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getLkp_concepto();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                jsonFieldData = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getLkp_concepto();
                break;
        }
        if(jsonFieldData == null) {
            if(isRequired.equals(Boolean.TRUE)) {
                System.out.println("campo `"+ FieldByTagLabelText.SEL_CONCEPTO +"`...REQUERIDO!!");
                throw new IllegalArgumentException("El campo es requerido, poner * para ejecutarlo...\n");
            } else {
                System.out.println("campo `"+ FieldByTagLabelText.SEL_CONCEPTO +"`...SALTADO!!");
                return;
            }
        }

        System.out.println("Abriendo LookUpField `"+FieldByTagLabelText.SEL_CONCEPTO.getCodigo()+"`...");

        WebElement element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.SEL_CONCEPTO,
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

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        commonService.doScreenshot("Conceptos Listados");

        serviceType.typeConcepto(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                true,
                true
        );

        commonServiceClick.clickBtn(
                null,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.BTN_BUSCAR,
                1,
                true,
                true
        );

        serviceType.typeQbeConceptosDisponibles(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                1,
                false,
                true,
                true
        );

        pageLocators.getQbEInputField(
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.QBE_CONCEPTOSDISPONIBLES,
                1
        ).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        commonService.doScreenshot("Concepto Filtrado");

        String jsonObjPathAux = "";
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__ALTA->TAB_CONCEPTOSCOLABORADOR->SECTION_NOMINA->DIALOG_ALTACONCEPTOCOLABORADORNOMINA->DIALOG_LISTADODECONCEPTOS->TABLE";
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__MODIFICACION->TAB_CONCEPTOSCOLABORADOR->SECTION_NOMINA->DIALOG_ALTACONCEPTOCOLABORADORNOMINA->DIALOG_LISTADODECONCEPTOS->TABLE";
                break;
        }

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                file,
                jsonObjPathAux,
                1,
                true
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
