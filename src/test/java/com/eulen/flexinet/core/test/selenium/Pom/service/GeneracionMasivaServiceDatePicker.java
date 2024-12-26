package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class GeneracionMasivaServiceDatePicker extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GeneracionMasivaServiceDatePicker(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void pickDateFechaDeInicioDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechadeInicioDesde();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getFechadeInicioDesde();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getFechadeInicioDesde();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getFechadeInicioDesde();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getFechadeInicioDesde();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getFechadeInicioDesde();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getFechadeInicioDesde();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getFechadeInicioDesde();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAINICIODESDE,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateInicioHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechadeInicioDesde();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getFechadeInicioDesde();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFinHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechaDeFinHasta();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getFechaDeFinHasta();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateBaja(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getDialogDarDeBaja().getFecha();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getDialogBajaMasivaContrato().getFecha();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void pickDateFechaDeInicioHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechadeInicioHasta();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getFechadeInicioHasta();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getFechadeInicioHasta();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getFechadeInicioHasta();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getFechadeInicioHasta();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getFechadeInicioHasta();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAINICIOHASTA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaFinalizacionProrroga(String scn, @NotNull SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getFechaDeFinalizacionProrroga();
                break;
        }
        commonService.datePickerField(
                scn,
                PanelTitle.DIALOG_CREACIONPRORROGA,
                FieldByTagLabelText.DATE_FECHAFINALIZACIONPRORROGA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaDeFinDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechaDeFinDesde();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getFechaDeFinDesde();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getFechaDeFinDesde();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getFechaDeFinDesde();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getFechaDeFinDesde();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getFechaDeFinDesde();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getFechaDeFinDesde();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getFechaDeFinDesde();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAFINDESDE,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaDeFinHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getFechaDeFinHasta();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getFechaDeFinHasta();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getFechaDeFinHasta();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getFechaDeFinHasta();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getFechaDeFinHasta();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getFechaDeFinHasta();
                break;
        }
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAFINHASTA,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
