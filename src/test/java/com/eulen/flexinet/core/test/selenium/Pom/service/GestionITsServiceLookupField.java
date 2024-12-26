package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.Task.GestionITsTask;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.reader.TestDatosGestionITs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GestionITsServiceLookupField extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private GestionITsServiceType serviceType;
    private GestionITsServiceSelect serviceSelect;
    private GestionITsServiceClick serviceClick;

    public GestionITsServiceLookupField(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceType = new  GestionITsServiceType(driver);
        serviceSelect = new GestionITsServiceSelect(driver);
        serviceClick = new GestionITsServiceClick(driver);
    }

    public void lkpNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String jsonFieldData = datosGestionITs.getGestionITs().getNif();
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


        serviceType.typeQbeNombreYApellido(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                1,
                false,
                false,
                false
        );

        serviceType.typeQbeDireccion(
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

        String datosJson = "TestDatosGestionITs->GESTION_DE_ITS->DIALOG_SELECCIONDECOLABORADORES->TABLE_COLABORADORES";

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                datosJson,
                1,
                true
        );

        serviceClick.clickBtnAsociarColaborador( //INFO: Este campo solo utiliza el panelTitle
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
