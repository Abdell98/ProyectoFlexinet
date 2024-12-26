package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PedidosServiceDatePicker extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceDatePicker(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void pickDateFechaPrevistaDeInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHAPREVISTADEINICIO,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDatePrevistaDeFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeFin();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeFin();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeFin();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHAPREVISATADEFIN,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getFechaInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getFechaInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getFechaInicio();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHAINICIO,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getFechaFin();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getFechaFin();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getFechaFin();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.FECHAFIN,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateHaberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getHaberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getHaberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getHaberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.HABERTERMINADOLOSESTUDIOSQUELECAPACITANPARALAPRACTICAOBJETODEDICHOCONTRATOCONFECHA,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaInicioDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAINICIODESDE,
                cajaNumero,
                datos.getPedidosConsulta().getFechaDeInicioDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaInicioHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                cajaNumero, //INFO: esta tiene que ser caja 2
                datos.getPedidosConsulta().getFechaDeIniciohasta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaFinDesde(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_FECHAFINDESDE,
                cajaNumero,
                datos.getPedidosConsulta().getFechaDeFinDesde(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateFechaFinHasta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.HASTA,
                cajaNumero,
                datos.getPedidosConsulta().getFechaDeFinhasta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void pickDateIntroducirFechaAntiguedadDelContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";

        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                datosAux = datos.getPedidosAltaLv3233().getDialogSolicitudDeFechaDeAltaDelContrato().getIntroduzcaLaFechaDeAntiguedadDelContrato();
                break;
            case PEDIDOS__MODIFICACION:
            case PEDIDOS__CONSULTA:
                datosAux = datos.getPedidosModificacion().getDialogSolicitudDeFechaDeAltaDelContrato().getIntroduzcaLaFechaDeAntiguedadDelContrato();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                datosAux = datos.getPedidosAlta().getDialogSolicitudDeFechaDeAltaDelContrato().getIntroduzcaLaFechaDeAntiguedadDelContrato();
                break;
        }

        commonService.datePickerField(
                scn,
                panelTitle,
                FieldByTagLabelText.DATE_INTRODUZCAFECHAANTIGUEDADCONTRATO, //solo se utiliza para informar el nombre del campo en el log, el xpath se genera con un findby
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }




}
