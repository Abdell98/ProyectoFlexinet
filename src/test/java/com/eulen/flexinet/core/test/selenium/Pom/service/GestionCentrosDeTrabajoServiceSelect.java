package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionCentrosDeTrabajoServiceSelect extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionCentrosDeTrabajoServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectClienteContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLIENTECONTRATO,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getClienteContrato(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectTipoVia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.TIPOVIA,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getTipoVia(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMedioDeCaptacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPTACION,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getMedioDeCaptacion(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectVentas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.VENTAS,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getVentas(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectNEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.getJsonFileData(scn,page,file);
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.NEMPLEADOS,
                FieldType.select,
                cajaNumero,
                gestionCentrosDeTrabajoData.getNEmpleados(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
