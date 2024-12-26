package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PedidosServiceType extends BasePage {
    private CommonService commonService;

    public PedidosServiceType(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
    }

    public void typeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNIF();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNIF();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNIF();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        FieldByTagLabelText fieldLabel;

        String dato = "";

        switch (page) {
            case PEDIDOS__CONSULTA:
                fieldLabel = FieldByTagLabelText.NCLIENTE2;
                dato = datos.getPedidosConsulta().getNCliente();
                break;
            case PEDIDOS__ALTA_LV3233:
                fieldLabel = FieldByTagLabelText.NCLIENTE;
                dato = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNCliente();
                break;
            case PEDIDOS__ALTA_SIMPLE:
                fieldLabel = FieldByTagLabelText.NCLIENTE;
                dato = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNCliente();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
            default:
                fieldLabel = FieldByTagLabelText.NCLIENTE;
                dato = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNCliente();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                fieldLabel,
                FieldType.input,
                cajaNumero,
                dato,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }

    public void typeDescripcion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDescripcion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDescripcion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDescripcion();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESCRIPCION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNPedidoAuxiliar(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getNPedidoAuxiliar();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedidoAuxiliar();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getNPedidoAuxiliar();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NPEDIDOAUXILIAR,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeImporteDelAval(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getImporteDelAval();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getImporteDelAval();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getImporteDelAval();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IMPORTEDELAVAL,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getObservaciones();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getObservaciones();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getObservaciones();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDepartamento(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDepartamento();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getDepartamento();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDepartamento();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DEPARTAMENTO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNCandidatosSolicitados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getNCandidatosSolicitados();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getNCandidatosSolicitados();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getNCandidatosSolicitados();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NCANDIDATOSSOLICITADOS,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDiasTrabajadosALaSemana(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDiasTrabajadosALaSemana();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getDiasTrabajadosALaSemana();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDiasTrabajadosALaSemana();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASTRABAJADOSALASEMANA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasNormalesDiarias(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getHorasNormalesDiarias();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getHorasNormalesDiarias();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getHorasNormalesDiarias();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASNORMALESDIARIAS,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePeriodoDePrueba(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getPeriodoDePrueba();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getPeriodoDePrueba();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getPeriodoDePrueba();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PERIODODEPRUEBA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePorcentajeJornada(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getPorcentajeJornada();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getPorcentajeJornada();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getPorcentajeJornada();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PORCENTAJEJORNADA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getHorario();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getHorario();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getHorario();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORARIO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTurno(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getTurno();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getTurno();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getTurno();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.TURNO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeOferta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getOferta();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getOferta();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getOferta();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFERTA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeGrupoCotizacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
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
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getGrupoCotizacion();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.GRUPOCOTIZACION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeOcupacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OCUPACION,
                FieldType.input,
                cajaNumero,
                datos.getPedidosAlta().getTabDatosDeTarifa().getOcupacion(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeBonificacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getBonificacion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getBonificacion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getBonificacion();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.BONIFICACION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSustitucionDelTrabajador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getSustitucionDelTrabajador();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getSustitucionDelTrabajador();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getSustitucionDelTrabajador();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SUSTITUCIONDELTRABAJADOR,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeElLaTrabajadoraEstaEnPosesionDelTitulo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getElLaTrabajadoraEstaEnPosesionDelTitulo();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getElLaTrabajadoraEstaEnPosesionDelTitulo();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getElLaTrabajadoraEstaEnPosesionDelTitulo();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELLATRABAJADORAESTAENPOSESIONDELTITULO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeElLaTrabajadoraAcreditaConLaCertificacionPor(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getElLaTrabajadoraAcreditaConLaCertificacionPor();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getElLaTrabajadoraAcreditaConLaCertificacionPor();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getElLaTrabajadoraAcreditaConLaCertificacionPor();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELLATRABAJADORAACREDITACONLACERTIFICACIONPOR,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__CONSULTA:
                data = datos.getPedidosConsulta().getNombre();
                break;
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePrimerApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__CONSULTA:
                data = datos.getPedidosConsulta().getPrimerApellido();
                break;
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PRIMERAPELLIDO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSegundoApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = "";
        switch (page) {
            case PEDIDOS__CONSULTA:
                data = datos.getPedidosConsulta().getSegundoApellido();
                break;
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEGUNDOAPELLIDO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDNI(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DNI,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselElegirNacionalidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirPaisDeNacionalidad();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirPaisDeNacionalidad();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirPaisDeNacionalidad();
                break;
        }

        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIRPAISDENACIONALIDAD,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselElegirMpieResidencia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirMpioResidencia();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirMpioResidencia();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirMpioResidencia();
                break;
        }

        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIRMPIORESIDENCIA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselElegirOcupacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirOcupacion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirOcupacion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getElegirOcupacion();
                break;
        }

        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.ELEGIROCUPACION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeselSeleccionarTitulacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSeleccionarTitulacion();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSeleccionarTitulacion();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosColaboradores().getDialogPerfilDatoUnico().getSeleccionarTitulacion();
                break;
        }

        commonService.typeselField(
                scn,
                panelTitle,
                FieldByTagLabelText.SELECCIONARTITULACION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNPedido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getNPedido();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NPEDIDO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getEstado();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.ESTADO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEmpresaClienteRazonSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getDialogBusquedaDeEmpresa().getEmpresaClienteRazonSocial();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESACLIENTERAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNombreYApellidos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getDialogSeleccionColaboradores().getTable().getQbe_nombreYApellidos();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREYAPELLIDOS,
                FieldType.input,
                1,
                data,
                false,
                true,
                true
        );
    }

    public void typeQbeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getDialogSeleccionColaboradores().getTable().getQbe_direccion();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DIRECCION,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_empresa();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_empresa();
                break;
            case PEDIDOS__CONSULTA:
            default:
                data = datos.getPedidosConsulta().getDialogBusquedaDeEmpresa().getTable().getQbe_empresa();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_EMPRESA,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_nif();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_nif();
                break;
            case PEDIDOS__CONSULTA:
                data = datos.getPedidosConsulta().getDialogBusquedaDeEmpresa().getTable().getQbe_nif();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NIF,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNPedido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            default:
                data = datos.getPedidosConsulta().getTableEmpresa().getQbe_nPedido();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NPEDIDO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFechaDeInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux=datos.getPedidosConsulta().getTableEmpresa().getQbe_fechaDeInicio();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHADEINICIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFechaDeFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux=datos.getPedidosConsulta().getTableEmpresa().getQbe_fechaDeFin();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FECHADEFIN,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux=datos.getPedidosConsulta().getTableColaborador().getQbe_colaborador();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_COLABORADOR,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_nCliente();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_nCliente();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NCLIENTE,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_estado();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_estado();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ESTADO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


    public void typeQbeFormaDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_formaDePago();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_formaDePago();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FORMADEPAGO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeComportamientoDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_comportamientoDePago();
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getTable().getQbe_comportamientoDePago();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_COMPORTAMIENTODEPAGO,
                FieldType.input,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeCellSalarial(String scn, SystemPages page, PanelTitle panelTitle,int filaNumero, int tablaNumero, String file, boolean isRequired) throws Exception {
        jsonFileNew(file);

        String dato = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                dato = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getSalarial();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                dato = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getSalarial();
                break;
        }

        commonService.typeInputCell(
                scn,
                page,
                panelTitle,
                "Salarial",
                filaNumero,
                tablaNumero,
                dato,
                isRequired
        );
    }

    public void typeCellExtrasal(String scn, SystemPages page, PanelTitle panelTitle,int filaNumero, int tablaNumero, String file, boolean isRequired) throws Exception {
        jsonFileNew(file);

        String dato = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                dato = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getExtrasal();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                dato = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getExtrasal();
                break;
        }

        commonService.typeInputCell(
                scn,
                page,
                panelTitle,
                "Extrasal.",
                filaNumero,
                tablaNumero,
                dato,
                isRequired
        );
    }

    public void typeCellPlusSalarial(String scn, SystemPages page, PanelTitle panelTitle,int filaNumero, int tablaNumero, String file, boolean isRequired) throws Exception {
        jsonFileNew(file);

        String dato = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                dato = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getPlusSalarial();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                dato = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusSalarial();
                break;
        }

        commonService.typeInputCell(
                scn,
                page,
                panelTitle,
                "Plus Salarial",
                filaNumero,
                tablaNumero,
                dato,
                isRequired
        );
    }

    public void typeCellPlusExtrasal(String scn, SystemPages page, PanelTitle panelTitle,int filaNumero, int tablaNumero, String file, boolean isRequired) throws Exception {
        jsonFileNew(file);

        String dato = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                dato = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getPlusExtraSal();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                dato = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusExtraSal();
                break;
        }

        commonService.typeInputCell(
                scn,
                page,
                panelTitle,
                "Plus Extrasal.",
                filaNumero,
                tablaNumero,
                dato,
                isRequired
        );
    }


//    commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Salarial", 1, 1, datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getSalarial(), file, false );
//                    commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Extrasal.", 1, 1, datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getExtrasal(), file, false );
//                    commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Plus Salarial", 1, 1, datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusSalarial(), file, false );
//                    commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Plus Extrasal.", 1, 1, datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusExtraSal(), file, false );


}

