package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionCentrosDeTrabajoServiceType extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionCentrosDeTrabajoServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeNombreEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getNombreEmpresa(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNombreDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getNombreDireccion(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDiasFijosDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASFIJOSDEPAGO,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getDiasFijosDePago(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRazonSocial(String scn, SystemPages page, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.typeInputField(
                scn,
                null, //no está dentro de una pestaña
                FieldByTagLabelText.RAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                gestionCentrosDeTrabajoData.getRazonSocial(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
