package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PedidosServiceSelect extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectConvenio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getConvenio();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getConvenio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getConvenio();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CONVENIO,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectSupuestoCelebracion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.waitUntilSpinnerIsNotDisplayed();
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getSupuestoCelebracion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getSupuestoCelebracion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getSupuestoCelebracion();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SUPUESTOCELEBRACION,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectCategoriaLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCategoriaLaboral();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getCategoriaLaboral();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCategoriaLaboral();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CATEGORIALABORAL,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMotivoDeSustitucion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMotivoDeSustitucion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getMotivoDeSustitucion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMotivoDeSustitucion();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.MOTIVODESUSTITUCION,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectSexo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSexo();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSexo();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSexo();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEXO,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getEstado();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.ESTADO,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectCategoriaProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCategoriaProfesional();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getCategoriaProfesional();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCategoriaProfesional();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CATEGORIAPROFESIONAL,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectTCont(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getTCont();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getTCont();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getTCont();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.TCONT,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectClausulas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getClausulas();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getClausulas();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getClausulas();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULAS,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectSeleccioneDuracionYTipoJornada(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getSeleccioneDuracionYTipoDeJornadaDeLaTarifa();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getSeleccioneDuracionYTipoDeJornadaDeLaTarifa();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getSeleccioneDuracionYTipoDeJornadaDeLaTarifa();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SELECCIONEDURACIONYTIPODEJORNADADELATARIFA,
                FieldType.selectalt,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectCompPago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCompPago();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getCompPago();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getCompPago();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.COMPPAGO,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectGrupoCotizacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getGrupoCotizacion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getGrupoCotizacion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getGrupoCotizacion();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.GRUPOCOTIZACION,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectOcupacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getOcupacion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getOcupacion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getOcupacion();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.OCUPACION,
                FieldType.select,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
