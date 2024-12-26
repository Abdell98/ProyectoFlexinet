package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GeneracionMasivaServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    private ContratosServiceClick contratosServiceClick;
    private ContratosServiceType contratosServiceType;

    private CommonServiceClick commonServiceClick;

    public GeneracionMasivaServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        contratosServiceType = new ContratosServiceType(driver);
        contratosServiceClick = new ContratosServiceClick(driver);
    }

    public void selectMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGeneracionMasivaPartes.
                getGeneradorAutomaticoPartesHoras().
                getMes();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_MES,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectAnio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getAnio();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.INP_ANIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectZona(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getZona();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_ZONA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectProvincia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getProvincia();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_PROVINCIA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getOficina();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_OFICINA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
