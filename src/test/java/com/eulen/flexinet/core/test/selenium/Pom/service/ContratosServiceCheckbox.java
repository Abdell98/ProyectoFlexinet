package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class ContratosServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ContratosServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkGenerados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_GENERADOS, cajaNumero, datosContrato.getContratosConsulta().getGenerados(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkTraspasados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_TRASPASADOS, cajaNumero, datosContrato.getContratosConsulta().getTraspasados(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkActivos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_ACTIVOS, cajaNumero, datosContrato.getContratosConsulta().getActivos(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkBajas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_BAJAS, cajaNumero, datosContrato.getContratosConsulta().getBajas(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkConProrrogas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_CONPRORROGAS, cajaNumero, datosContrato.getContratosConsulta().getConProrrogas(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkNovacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_NOVACION, cajaNumero, datosContrato.getContratosConsulta().getNovacion(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkLlamamiento(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_LLAMAMIENTO, cajaNumero, datosContrato.getContratosConsulta().getLlamamiento(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkCeseVoluntario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_CESEVOLUNTARIO, cajaNumero, datosContrato.getContratosConsulta().getCeseVoluntario(), isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkBusquedaANivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getBusquedaANivelNacional();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getBusquedaANivelNacional();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getBuscarANivelNacional();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getBusquedaANivelNacional();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getBuscarANivelNacional();
                break;
        }

        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_BUSQUEDAANIVELNACIONAL, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void checkBuscarNivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getBuscarANivelNacional();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getBuscarANivelNacional();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getBuscarANivelNacional();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getBuscarANivelNacional();
                break;

        }
        commonService.checkBoxField( scn, panelTitle, FieldByTagLabelText.CHK_BUSCARANIVELNACIONAL, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
}
