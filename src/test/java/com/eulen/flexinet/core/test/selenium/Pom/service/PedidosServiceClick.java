package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PedidosServiceClick extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceClick(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void clickBtnBuscarEmpresa() throws Exception {
        commonService.click(pageLocators.getBtnBuscarEmpresa());
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickBtnAsociarAEmpresa() throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                PanelTitle.DIALOG_SELECCIONDEEEMPRESA,
                "Asociar a Empresa",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsDisplayed();
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickRadTarifaNormal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getTarifaNormal();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getTarifaNormal();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getTarifaNormal();
                break;
        }

        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.TARIFANORMAL,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown

        );
    }

    public void clickRadTarifaIgualOInferiorA5Dias(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getTarifaIgualOInferior5Dias();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getTarifaIgualOInferior5Dias();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getTarifaIgualOInferior5Dias();
                break;
        }

        commonService.clickRadioField( 
                scn,
                panelTitle,
                FieldByTagLabelText.TARIFAIGUALOINFERIOR5DIAS,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickRadPrevisible(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getRad_previsible();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getRad_previsible();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getRad_previsible();
                break;
        }

        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_PREVISIBLE,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickRadImprevisible(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getRad_imprevisible();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getRad_imprevisible();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getRad_imprevisible();
                break;
        }

        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_IMPREVISIBLE,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickBtnAsociarColaborador(String scn, SystemPages page, PanelTitle dialogTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        WebElement button = pageLocators.getButton(
                null,
                dialogTitle,
                "Asociar Colaborador",
                1
        );
        commonService.click(button);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }

    public void clickRadRealizandoElTraspasoDeLosContratos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {jsonFileNew(file);
       String datosAux = "";

        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                datosAux = datos.getPedidosAltaLv3233().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_RealizandoElTraspasoDeLosContratos();
                break;
            case PEDIDOS__MODIFICACION:
            case PEDIDOS__CONSULTA:
                datosAux = datos.getPedidosModificacion().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_RealizandoElTraspasoDeLosContratos();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                datosAux = datos.getPedidosAlta().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_RealizandoElTraspasoDeLosContratos();
                break;
        }

        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_REALIZANDOELTRASPASODELOSCONTRATOS,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void clickRadSinTraspasarLosContratos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String data = "";

        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_SinTraspasarLosContratos();
                break;
            case PEDIDOS__MODIFICACION:
            case PEDIDOS__CONSULTA:
                data = datos.getPedidosModificacion().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_SinTraspasarLosContratos();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                data = datos.getPedidosAlta().getDialogSolicitudDeFechaDeAltaDelContrato().getRad_SinTraspasarLosContratos();
                break;
        }

        commonService.clickRadioField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAD_SINTRASPASARCONTRATOS,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
