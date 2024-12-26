package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class PartesDeHorasServiceType extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PartesDeHorasServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux  = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getEmpresa();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getEmpresa();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getEmpresa();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getEmpresa();
                break;

        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeAnio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getAnio();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getAnio();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getAnio();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getAnio();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.INP_ANIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable1().getQbe_empresa();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_empresa();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable1().getQbe_empresa();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_EMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeIdContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        FieldByTagLabelText fieldAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_idContrato();
                fieldAux = FieldByTagLabelText.QBE_IDCONTRATO;
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_idContrato();
                fieldAux = FieldByTagLabelText.QBE_IDCONTRATO;
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_idContrato();
                fieldAux = FieldByTagLabelText.QBE_IDCONTRATO2;
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                fieldAux,
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
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_colaborador();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_colaborador();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_colaborador();
                break;
        }
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

    public void typeQbeDiaDeInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_diaDeInicio();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_diaDeInicio();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_diaDeInicio();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DIADEINICIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeDiaDeFin(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_diaDeFin();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_diaDeFin();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_diaDeFin();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DIADEFIN,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeMotivoDeBaja(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_motivoDeBaja();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_MOTIVODEBAJA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCentroDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_centroDeTrabajo();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CENTRODETRABAJO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbePersonalizada(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_personalizada();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_PERSONALIZADA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNombreYApellidos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasConsulta().
                        getDialogSeleccionDeColaboradores().
                        getTable().
                        getQbe_nombreYApellidos();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasTraspaso().
                        getDialogSeleccionDeColaboradores().
                        getTable().
                        getQbe_nombreYApellidos();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREYAPELLIDOS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasConsulta().
                        getDialogSeleccionDeColaboradores().
                        getTable().
                        getDireccion();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasTraspaso().
                        getDialogSeleccionDeColaboradores().
                        getTable().
                        getDireccion();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DIRECCION,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getTable().
                getQbe_concepto();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getQbe_concepto();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CONCEPTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeDevengo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getTable().
                getQbe_devengo();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getQbe_devengo();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_DEVENGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUnidades(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getTable().
                getQbe_unidades();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getQbe_unidades();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNIDADES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeSalarioUnidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getTable().
                getSalarioUnidad();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getSalarioUnidad();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_SALARIOUNIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCoeficiente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getCoeficiente();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getCoeficiente();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_COEFICIENTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeTotal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getTable().
                getTotal();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getTable().
                        getTotal();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_TOTAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNParte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasConsulta().
                getTable().
                getQbe_nParte();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasTraspaso().
                getTable1().
                getQbe_nParte();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NPARTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_nif();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NIF2,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_mes();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_MES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeParteOriginal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_parteOriginal();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_PARTEORIGINAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_oficina();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_OFICINA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeTraspasado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getQbe_traspasado();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getTable2().getQbe_traspasado();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_TRASPASADO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }




    public void typeHorasNormales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasNormales();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasNormales();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASNORMALES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasExtras(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasExtras();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasExtras();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASEXTRAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasFestivas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasFestivas();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasFestivas();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASFESTIVAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasNocturnas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasNocturnas();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasNocturnas();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASNOCTURNAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasComplementarias(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasComplementarias();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasComplementarias();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASCOMPLEMENTARIAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasPermisoRetribuido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasPermisoRetribuido();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasPermisoRetribuido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASPERMISORETRIBUIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasPermisoRetribudo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getHorasPermisoRetribuido();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getHorasPermisoRetribuido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASPERMISORETRIBUIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeIT(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        switch (cajaNumero) {
            case 1:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionNomina().
                        getIt();
                break;
            case 2:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasAlta().
                        getTabParteDeHoras().
                        getSectionFacturacion().
                        getIt();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IT,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTotal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = "";
        if(panelTitle.equals(PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA)) {
            datosAux = null;
            switch (page) {
                case PARTES_DE_HORAS__ALTA:
            datosAux = datosPartesDeHoras.
                    getPartesDeHorasAlta().
                    getTabConceptosColaborador().
                    getSectionNomina().
                    getDialogAltaConceptoColaboradorNomina().
                    getTotal();
                    break;
                case PARTES_DE_HORAS__MODIFICACION:
                    datosAux = datosPartesDeHoras.
                            getPartesDeHorasModificacion().
                            getTabConceptosColaborador().
                            getSectionNomina().
                            getDialogAltaConceptoColaboradorNomina().
                            getTotal();
                    break;
            }
        } else if (panelTitle.equals(PanelTitle.TAB_CONCEPTOSCOLABORADOR)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosPartesDeHoras.
                            getPartesDeHorasAlta().
                            getTabParteDeHoras().
                            getSectionNomina().
                            getTotal();
                    break;
                case 2:
                    datosAux = datosPartesDeHoras.
                            getPartesDeHorasAlta().
                            getTabParteDeHoras().
                            getSectionFacturacion().
                            getTotal();
                    break;
            }
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.TOTAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDe(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosIT().
                getSectionNomina().
                getDe();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeA(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosIT().
                getSectionNomina().
                getA();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.A,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeHorasTotales(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosIT().
                getSectionNomina().
                getHorasTotales();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.HORASTOTALES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDevengo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getDevengo();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getDevengo();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DEVENGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeUnidades(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getUnidades();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getUnidades();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.UNIDADES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSalario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getSalario();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getSalario();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SALARIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeCoeficiente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getCoeficiente();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getCoeficiente();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.COEFICIENTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasConsulta().
                        getNombre();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasTraspaso().
                        getNombre();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getNombre();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePrimerApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasConsulta().
                        getPrimerApellido();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasTraspaso().
                        getPrimerApellido();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getPrimerApellido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PRIMERAPELLIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSegundoApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__CONSULTA:
                datosAux = datosPartesDeHoras.getPartesDeHorasConsulta().getSegundoApellido();
                break;
            case PARTES_DE_HORAS__TRASPASO:
                datosAux = datosPartesDeHoras.getPartesDeHorasTraspaso().getSegundoApellido();
                break;
            case PARTES_DE_HORAS__ENVIOSPARTESAORACLE:
                datosAux = datosPartesDeHoras.getEnvioPartesAOracle().getPrimerApellido();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEGUNDOAPELLIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getDialogListadoDeConceptos().
                getConcepto();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getDialogListadoDeConceptos().
                        getConcepto();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_CONCEPTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeConceptosDisponibles(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                datosAux = datosPartesDeHoras.
                getPartesDeHorasAlta().
                getTabConceptosColaborador().
                getSectionNomina().
                getDialogAltaConceptoColaboradorNomina().
                getDialogListadoDeConceptos().
                getTable().
                getQbe_conceptosDisponibles();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                datosAux = datosPartesDeHoras.
                        getPartesDeHorasModificacion().
                        getTabConceptosColaborador().
                        getSectionNomina().
                        getDialogAltaConceptoColaboradorNomina().
                        getDialogListadoDeConceptos().
                        getTable().
                        getQbe_conceptosDisponibles();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CONCEPTOSDISPONIBLES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
