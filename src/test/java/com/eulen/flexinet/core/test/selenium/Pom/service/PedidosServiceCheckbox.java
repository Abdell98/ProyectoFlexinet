package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PedidosServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkContratacion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getContratacionMenos100();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getContratacionMenos100();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getContratacionMenos100();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CONTRATACIONMENOS100,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkAvalNecesario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getAvalNecesario();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getAvalNecesario();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getAvalNecesario();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.AVALNECESARIO,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkDiasDeTrabajoSemanales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDiasDeTrabajoSemanales();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getDiasDeTrabajoSemanales();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getDiasDeTrabajoSemanales();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASDETRABAJOSEMANALES,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkBrutoMensual(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getBrutoMensual();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getBrutoMensual();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getBrutoMensual();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.BRUTOMENSUAL,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkAturnos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getATurnos();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeJornada().getATurnos();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeJornada().getATurnos();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.ATURNOS,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPrevisionarCompensacionFinContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getPrevisionarCompensacionFinContrato();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDeTarifa().getPrevisionarCompensacionFinContrato();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDeTarifa().getPrevisionarCompensacionFinContrato();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.PREVISIONARCOMPENSACIONFINCONTRATO,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.EXISTECONVCOLECTQUEPERMITACONTRATOSDE6A12MESESENUNPERIODODE18,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkMarqueExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMarqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getMarqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMarqueSiexisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.MARQUESIEXISTECONVCOLECTQUEPERMITACONTRATOSDE6A12MESESENUNPERIODODE18,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkCertificadoProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getCertificadoProfesional();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getCertificadoProfesional();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getCertificadoProfesional();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CERTIFICADOPROFESIONAL,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkDesempleadoYMenor30Anos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDesempleadoYMenor30Anos();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDesempleadoYMenor30Anos();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDesempleadoYMenor30Anos();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESEMPLEADOYMENOR30ANOS,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkDesempleadoYMenor35AnosYConDiscapacSup30(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDesempleadoYMenor35AnosYConDiscapacSup30();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDesempleadoYMenor35AnosYConDiscapacSup30();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getDesempleadoYMenor35AnosYConDiscapacSup30();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESEMPLEADOYMENOR35ANOSYCONDISCAPACSUP30,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkMenor30AnosRealizarPracticasNoLaboralesRD15432011(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);

        String data = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMenor30AnosRealizarPracticasNoLaboralesRD15432011();
                break;
            case PEDIDOS__ALTA_LV3233:
                data = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getMenor30AnosRealizarPracticasNoLaboralesRD15432011();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente crear @TestDatos
            default:
                data = datos.getPedidosAlta().getTabDatosDelPedido().getMenor30AnosRealizarPracticasNoLaboralesRD15432011();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.MENOR30ANOSREALIZARPRACTICASNOLABORALESRD15432011,
                cajaNumero,
                data,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


    public void checkOferta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_OFERTA,
                cajaNumero,
                datos.getPedidosConsulta().getOferta(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkBuscarNivelNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_BUSCARANIVELNACIONAL,
                cajaNumero,
                datos.getPedidosConsulta().getBuscarANivelNacional(),
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }



}
