package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionEmpresasClienteServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public GestionEmpresasClienteServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnLupaBuscarCif() throws Exception {
        waitUntilBeClickable(pageLocators.getBtnLupaCif());
        click(pageLocators.getBtnLupaCif());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnBuscarEmpresaModalSeleccioneEmpresa() throws Exception {
        click(pageLocators.getBtnBuscarEmpresaModalSeleccioneEmpresa());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }
    
    public void clickBtnAceptarModalSeleccioneEmpresa() throws Exception {
        click(pageLocators.getBtnAceptarModalSeleccioneEmpresa());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnObtenerDatos() throws Exception {
        click(pageLocators.getBtnObtenerDatos());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnEnviarARiesgos() throws Exception {
        click(pageLocators.getBtnEnviarARiesgos());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnYesModalEnviarARiesgos() throws Exception {
        waitUntilIsDisplayed(pageLocators.getTituloVentanaModalEnviarARiesgos());
        click(pageLocators.getBtnYesEnviarARiesgos());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
    }

    public void clickBtnNoModalEnviarARiesgos() throws Exception {
        waitUntilIsDisplayed(pageLocators.getTituloVentanaModalEnviarARiesgos());
        click(pageLocators.getBtnNoModalEnviarARiesgos());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnCerrarModalInformacion() throws Exception {
        click(pageLocators.getBtnCerrarModal());
    }

    /*** CONSULTA ***/
    public void clickBtnBuscar() throws Exception {
        click(pageLocators.getBtnBuscar());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnVerEmpresa() throws Exception {
        click(pageLocators.getBtnVerEmpresa());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnModificarEmpresa() throws Exception {
        click(pageLocators.getBtnModificarEmpresa());
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    //TODO: Creada clase commonClick, borrar metodo siguiente y corregir usos para cambiar al common
    public void clickTab(String tabName) throws Exception {
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        Thread.sleep(2000);
        click(pageLocators.getTab(tabName));
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        Thread.sleep(2000);
        click(pageLocators.getTab(tabName));
        waitForSpinner(homePageLocators.getFlexinetLoadingSpinner());
        commonService.checkNoUnexpectedMessageIsShown();
    }

    //TODO: Creada clase commonClick, borrar metodo siguiente y corregir usos para cambiar al common
    public void clickBtnGuardar() throws Exception {
        click(pageLocators.getBtnGuardar());
    }

    public void clickRadRealizarLaBusquedaANivelNacionalSi(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getRadio_realizarBusquedaANivelNacional_si();
        jsonFileNew(file);
        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_REALIZARLABUSQUEDAANIVELNACIONALSI,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickRadRealizarLaBusquedaANivelNacionalNo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getRadio_realizarBusquedaANivelNacional_no();
        jsonFileNew(file);
        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_REALIZARLABUSQUEDAANIVELNACIONALNO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
}
