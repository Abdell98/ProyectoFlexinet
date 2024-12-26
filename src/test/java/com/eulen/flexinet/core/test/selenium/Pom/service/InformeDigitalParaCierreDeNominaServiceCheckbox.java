package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class InformeDigitalParaCierreDeNominaServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public InformeDigitalParaCierreDeNominaServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkExcluirGenerados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datoAux = datosInformeDigitalParaCierreDeNomina.getInforme().getExcluirGenerados();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_EXCLUIRGENERADOS,
                cajaNumero,
                datoAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkTodosValidados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datoAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getMarcarDesmarcarTodosComoValidados();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_TODOSVALIDADOS,
                cajaNumero,
                datoAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkDiferencia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datoAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getChk_diferencia();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_DIFERENCIA2,
                cajaNumero,
                datoAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkValidado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datoAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getBotones().getChk_validado();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_VALIDADO,
                cajaNumero,
                datoAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
