package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ContratosServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public ContratosServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getEmpresa();
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.EMPRESA, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeNifPasaporte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";

        datos = datosContrato.getContratoAltaSustitucion().getNIF();

        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.NIEDNIPASAPORTE, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getNIF();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getNIF();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.NIF, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
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
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getDialogSeleccionDeEmpresa().getQbe_empresaCliente();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.EMPRESACLIENTERAZONSOCIAL, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getNCliente();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.NCLIENTE, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getNombre();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getNombre();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.NOMBRE, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getPrimerApellido();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getPrimerApellido();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.PRIMERAPELLIDO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
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
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getSegundoApellido();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getSegundoApellido();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.SEGUNDOAPELLIDO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeNContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getNContrato();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getNContrato();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getNContrato();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getNContrato();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getNContrato();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getNContrato();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getNContrato();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getNContrato();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getNContrato();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getTable().getNContrato();
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getNContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.NCONTRATO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeSecuencial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.SECUENCIAL, FieldType.input, cajaNumero, datosContrato.getContratosConsulta().getSecuencial(), isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeSec(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_sec();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_SEC,
                FieldType.input,
                1,
                datos,
                false,
                true,
                true
        );
    }
    public void typeQbeNombreYApellidos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getDialogSeleccionDeColaboradores().getQbe_nombreYApellidos();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getDialogSeleccionColaboradores().getQbe_nombreYApellidos();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREYAPELLIDOS,
                FieldType.input,
                1,
                datos,
                false,
                true,
                true
        );
    }

    public void typeQbeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONSULTA:
                datos = datosContrato.getContratosConsulta().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = datosContrato.getContratosBajaConsulta().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__ANULACION:
                datos = datosContrato.getContratosAnulacion().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = datosContrato.getContratosBajaDarDeBaja().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = datosContrato.getContratosProrrogasAlta().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getDialogSeleccionDeColaboradores().getQbe_direccion();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getDialogSeleccionColaboradores().getQbe_direccion();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_DIRECCION, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
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
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getQbe_empresa();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getDialogSeleccionDeEmpresa().getQbe_empresaCliente();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_EMPRESA, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeQbeNroContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getDialogSeleccionContrato().getQbe_nroContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_NROCONTRATO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeQbeColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getQbe_colaborador();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_COLABORADOR, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeNombre (String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_nombre();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_NOMBRE1, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeCpdPro (String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_cpd_pro();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_CPD_PRO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeSeguridadSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getQbe_seguridadSocialContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_SEGURIDADSOCIAL, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeFechaInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getFecInicioContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_INICIO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    //TODO -> Este sirve para rellenar los QBE de la tabla que tenga la fecha escrita asi: Fecha Inicio y no Fec. Inicio
    public void typeQbeFechaInicio1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_fecInicio();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_INICIO1, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeFechaFin1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_fecFin();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_FIN1, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeFechaEnvio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_fecEnvio();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_ENVIO, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeFecharRec(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_fecRecep();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_RECEP, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeQbeFechaFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getFecFinContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_FIN, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeFechaAntiguedad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getFecAntiguedadContrato();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_FECHA_ANTIGUEDAD, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }

    public void typeQbeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = datosContrato.getContratosProrrogasAnulacion().getDialogSeleccionDeEmpresa().getQbe_nIF();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getQbe_nIF();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getDialogSeleccionDeEmpresa().getQbe_nIF();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_NIF, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeQbeNif2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getQbe_nIF();
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = datosContrato.getContratosControlEnviosCpds().getTable().getQbe_nIF();
                break;
        }
        commonService.typeInputField( scn, panelTitle, FieldByTagLabelText.QBE_NIF2, FieldType.input, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown );
    }
    public void typeselElegirNacionalidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIRPAISDENACIONALIDAD,
                FieldType.input,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getDialogPerfilDatoUnico().getElegirPaisDeNacionalidad(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeselFechaInicioDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAINICIODESDE,
                FieldType.input,
                cajaNumero,
                datosContrato.getContratosTraspasoMasivos().getFechadeInicioDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeselElegirMpieResidencia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIRMPIORESIDENCIA,
                FieldType.input,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getDialogPerfilDatoUnico().getElegirMpioResidencia(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselElegirOcupacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIROCUPACION,
                FieldType.input,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getDialogPerfilDatoUnico().getElegirOcupacion(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselSeleccionarTitulacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.SELECCIONARTITULACION,
                FieldType.input,
                cajaNumero,
                datosContrato.getContratoAltaSustitucion().getDialogPerfilDatoUnico().getSeleccionarTitulacion(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeLog(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getLog();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_LOG,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeLote(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getLote();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_LOTE,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeAccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getAccion();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ACCION,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getEstado();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ESTADO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeEstado2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getEstado2();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ESTADO2,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeNumProyect(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getNumeroproyecto();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NUMPROYECT,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeFechaCreacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getFechacreacion();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHACREACION,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeFechaActualizacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getFechaactualizacion();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHAACTUALIZACION,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeFechaEnvioAOracle(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getFecha_env_oracle();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHAENVIOAORACLE,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeFechaProcesado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getFechaprocesado();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHAPROCESADO,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeUsuarioCreador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__PRORROGAS_CONSULTA:
                datos = datosContrato.getContratosProrrogasConsulta().getTable().getDialoghistoricodetraspasosaoracle().getTable().getUsuariocreador();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_USUARIOCREADOR,
                FieldType.input,
                cajaNumero,
                datos,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
    public void typeQbeNContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page){
            case CONTRATOS__NOVACION_ALTA:
                datos = datosContrato.getContratosNovacionAlta().getTable().getQbe_nContrato();
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = datosContrato.getContratoAltaSustitucion().getTable().getNContrato();
                break;
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getNContrato();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NCONTRATO,
                FieldType.input,
                1,
                datos,
                false,
                true,
                true
        );
    }
    public void FiltrarPorEstadoCheckBox(String file) throws Exception{
        jsonFileNew(file);
            if (datosContrato.getContratosControlEnviosCpds().getFiltrarEstado().equals("Generado") || datosContrato.getContratosControlEnviosCpds().getFiltrarEstado().equals("Enviado")){
                for (WebElement chbox: pageLocators.getCheckboxes()){
                    if (chbox.isEnabled() && chbox.isDisplayed() && !chbox.isSelected()){
                        chbox.click();
                        Thread.sleep(1500);
                        System.out.println("INFO -> Se ha seleccionado el checkbox Correctamente \n");
                    }
                    String CheckBoxActive = chbox.getAttribute("class");
                    if (CheckBoxActive.contains("ui-state-active")){
                        System.out.println("INFO -> El CheckBox está activo y esta marcado, DESMARCAMOS \n");
                        chbox.click();
                        Thread.sleep(1500);
                    }
                }
                //TODO -> este sirve para resolver el error de "element-is-not-clickable-at-point-error"
                Actions actions = new Actions(driver);
                actions.moveToElement(pageLocators.getCheckboxes().get(0)).click().perform();
            }
            else if (datosContrato.getContratosControlEnviosCpds().getFiltrarEstado().equals("Anulado") || datosContrato.getContratosControlEnviosCpds().getFiltrarEstado().equals("Recibido")){
               // List<WebElement> checkBoxDisabled = driver.findElements(By.xpath("//div[contains(@class, 'cajaResultados')]//div[@class=\"ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled\"]"));
                for (WebElement chbox : pageLocators.getCheckBoxDisabled()) {
                    String CheckBoxActive = chbox.getAttribute("class");
                    if (!CheckBoxActive.contains("ui-state-disabled")){
                        chbox.click();
                        Thread.sleep(1000);
                        System.out.println("ERROR: El check se ha seleccionado aunque el elemento es Disabled ");
                    }
                    System.out.println("ERROR: El check no es editable...\n " );
                }
            }
        }
    }

