package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaAvanzadaDePartesDeHorasServiceLookupField extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private ConsultaAvanzadaDePartesDeHorasServiceClick ConsultaAvanzadaDePartesDeHorasServiceClick;
    private ConsultaAvanzadaDePartesDeHorasServiceType ConsultaAvanzadaDePartesDeHorasServiceType;

    public ConsultaAvanzadaDePartesDeHorasServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        ConsultaAvanzadaDePartesDeHorasServiceClick = new ConsultaAvanzadaDePartesDeHorasServiceClick(driver);
        ConsultaAvanzadaDePartesDeHorasServiceType = new ConsultaAvanzadaDePartesDeHorasServiceType(driver);
    }

    public void lkpNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getNIF();
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


        ConsultaAvanzadaDePartesDeHorasServiceType.typeQbeNombreYApellido(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                false,
                false
        );

        ConsultaAvanzadaDePartesDeHorasServiceType.typeQbeDireccion(
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

        String datosJson = "TestDatosConsultaAvanzadaDePartesDeHoras->GESTION_AVANZADA__CONSULTA_AVANZADA_DE_PARTES_DE_HORAS->DIALOG_SELECCIONDECOLABORADORES->TABLE_COLABORADORES";

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                datosJson,
                1,
                true
        );

        ConsultaAvanzadaDePartesDeHorasServiceClick.clickBtnAsociarColaborador( //INFO: Este campo solo utiliza el panelTitle
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

}
