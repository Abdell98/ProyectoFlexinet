package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class FacturacionServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public FacturacionServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkBusquedaANivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_busquedaANivelNacional();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_REALIZARBUSQUEDAANIVELNACIONAL, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkPrefacturas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_preFacturadas();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_PREFACTURAS, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkFacturas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_facturas();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_FACTURAS, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);

    }

    public void checkSpf(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_sPF();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_SPF, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkAbonosTotales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_abonosTotales();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_ABONOSTOTALES, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkAbonosParciales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_abonosParciales();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_ABONOSPARCIALES, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkValidadasEmisionMasiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_validadasEmisionMasiva();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_VALIDADASEMISIONMASIVA, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkMarcarDesmarcarParaEmitir(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_marcarDesmarcarEmitir();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_MARCARDESMARCAREMITIR, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkFacturadasManuales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_facturasManuales();
                break;
        }
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_FACTURADASMANUALES, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void clickRadUltimoMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_ultimoMes();
                break;
        }
        commonService.clickRadioField(scn, panelTitle, FieldByTagLabelText.CHK_ULTIMOMES, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void clickRadDentroRangoFechas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception{
        jsonFileNew(file);
        String datos = "";
        switch (page) {
            case FACTURACION__CONSULTA:
                datos = datosFacturacion.getFacturacionConsulta().getChk_rangoFecha();
                break;
        }
        commonService.clickRadioField(scn, panelTitle, FieldByTagLabelText.CHK_DENTRORANGOFECHAS, cajaNumero, datos, isRequired, waitForSpinner, checkNoMessageShown);
    }

    public void checkBusquedaErp(String scn, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.checkBoxField(scn, panelTitle, FieldByTagLabelText.CHK_BUSQUEDAERP, cajaNumero, datosFacturacion.getFacturacionConsulta().getChk_busquedaErp(), isRequired, waitForSpinner, checkNoMessageShown);
    }
}
