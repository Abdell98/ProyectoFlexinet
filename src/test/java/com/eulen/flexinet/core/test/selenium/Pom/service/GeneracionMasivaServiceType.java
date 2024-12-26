package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GeneracionMasivaServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GeneracionMasivaServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getNIF();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getNIF();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getNIF();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getNIF();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getNIF();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getNIF();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getNIF();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getNIF();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getNIF();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getNIF();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getEmpresa();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getEmpresa();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getEmpresa();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getEmpresa();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getEmpresa();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getEmpresa();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getEmpresa();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getEmpresa();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEmpresaCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getDialogSeleccionDeEmpresa().getQbe_empresaCliente();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getDialogSeleccionDeEmpresa().getQbe_empresaCliente();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getDialogSeleccionDeEmpresa().getQbe_empresaCliente();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESACLIENTERAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getNCliente();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getNCliente();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getNCliente();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getNCliente();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getNCliente();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getNCliente();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getNCliente();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getNCliente();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NCLIENTE,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getNombre();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getNombre();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getNombre();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getNombre();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getNombre();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getNombre();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getNombre();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getNombre();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getNombre();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getNombre();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePrimerApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getPrimerApellido();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getPrimerApellido();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getPrimerApellido();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getPrimerApellido();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getPrimerApellido();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getPrimerApellido();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getPrimerApellido();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getPrimerApellido();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getPrimerApellido();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getPrimerApellido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PRIMERAPELLIDO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSegundoApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getSegundoApellido();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getSegundoApellido();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getSegundoApellido();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getSegundoApellido();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getSegundoApellido();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getSegundoApellido();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getSegundoApellido();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getSegundoApellido();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getSegundoApellido();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getSegundoApellido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEGUNDOAPELLIDO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeAnio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        datos = datosGeneracionMasivaPartes.getGeneradorAutomaticoPartesHoras().getAnio();

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.INP_ANIO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}

