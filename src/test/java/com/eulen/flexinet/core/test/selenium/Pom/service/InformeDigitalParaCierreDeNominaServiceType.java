package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class InformeDigitalParaCierreDeNominaServiceType extends BasePage {
    private CommonService commonService;
    public InformeDigitalParaCierreDeNominaServiceType(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
    }

    /*----------------   IMPUT  -----------------*/

    public void typeAnio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getAnio();
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

    public void typeDniColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDniColaborador();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DNICOLABORADOR,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   DIALOGO BUSQUEDA DE EMPRESA  -----------------*/

    public void typeEmpresaCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoBusquedaDeEmpresas().getEmpresaClienteRazonSocial();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMPRESACLIENTERAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeBusquedaEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoBusquedaDeEmpresas().getTable().getQbe_empresa();
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

    public void typeQbeBusquedaNif(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoBusquedaDeEmpresas().getTable().getQbe_nif();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NIF,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   TABLA PARTES  -----------------*/

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_empresa();
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

    public void typeQbeCodCli(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_codCli();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_COD_CLI,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeIdCent(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_idCent();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ID_CENT,
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
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_colaborador();
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

    public void typeQbeNIF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nif();
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

    public void typeQbeSec(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_sec();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_SEC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fInicio();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_F_INICIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFBaja(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fBaja();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_F_BAJA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeMotivoBaja(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_motivoBaja();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_MOTIVO_BAJA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsSalarioNom(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsSalarioNom();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_SALARIO_NOM,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsSalarioFac(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsSalarioFac();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_SALARIO_FAC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsSalarioTeorico(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsSalarioTeorico();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_SALARIO_TEORICO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsExtra();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_EXTRA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsNocturnaNom(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsNocturnaNom();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_NOCTURNA_NOM,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsNocturnaFac(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsNocturnaFac();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_NOCTURNA_FAC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeUndsFestiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_undsFestiva();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS_FESTIVA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeConceptosN(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_conceptosN();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CONCEPTOS_N,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeConceptosF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_conceptosF();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CONCEPTOS_F,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNSalario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nSalario();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_N_SALARIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNImporte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nImporte();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_N_IMPORTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNSExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nsExtra();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NS_EXTRA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNSNoct(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nsNoct();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NS_NOCT,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNSFest(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_nsFest();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NS_FEST,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFSalario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fSalario();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_F_SALARIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFImporte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fImporte();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_F_IMPORTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFPVPExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fpvpExtra();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FPVP_EXTRA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFPVPNoct(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fpvpNoct();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FPVP_NOCT,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFPVPFest(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fpvpFest();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FPVP_FEST,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeFecGeneracion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_fecGeneracion();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_FEC_GENERACION,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getTable().getQbe_contrato();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CONTRATO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   DIALOGO DETALLE DE COLABORADOR  -----------------*/

    public void typeNomina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getNomina();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getNomina2();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMINA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePermisoRetribuido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getPermisoRetribuido();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PERMISORETRIBUIDO,
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
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_concepto();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_concepto();
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

    public void typeQbeTipo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_tipo();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBESEL_TIPO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCoef(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_coef();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_COEF,
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
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_devengo();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_devengo();
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

    public void typeQbeUnds(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_unds();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_unds();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_UNDS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeImporte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_importe();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_IMPORTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbePrecio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_precio();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_PRECIO,
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
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_total();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_total();
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

    public void typeQbeC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (cajaNumero){
            case 1:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getTable().getQbe_c();
                break;
            case 2:
                datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFacturas().getTable().getQbe_c();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_C,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   Modificación de Horas Extra -----------------*/

    public void typeUnidadesExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasExtra().getUnidades();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                FieldByTagLabelText.UNIDADES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTotalExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasExtra().getTotal();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                FieldByTagLabelText.TOTAL2,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeImporteExtra(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasExtra().getImporte();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASEXTRA,
                FieldByTagLabelText.IMPORTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   Modificación de Horas Festiva -----------------*/

    public void typeUnidadesFestiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasFestiva().getUnidades();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                FieldByTagLabelText.UNIDADES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTotalFestiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasFestiva().getTotal();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                FieldByTagLabelText.TOTAL2,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeImporteFestiva(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getFormulario().getModificaciondeHorasFestiva().getImporte();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_MODIFICACIONDEHORASFESTIVA,
                FieldByTagLabelText.IMPORTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   Listado de concepto -----------------*/

    public void typeConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getFormulario().getConcepto();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.CONCEPTO,
                FieldType.input,
                1,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeConceptosDisponible(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getTable().getQbe_conceptosDisponibles();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.QBE_CONCEPTOSDISPONIBLES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeUnidadesConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getUnidades();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.UNIDADES,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSalarialConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getSalarial();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.SALARIAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTotalSalConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getTotalSal();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.TOTALSAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeCoeficienteConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getCoeficiente();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.COEFICIENTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePvpConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getPVP();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.PVP,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeTotalPvpConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosInformeDigitalParaCierreDeNomina.getInforme().getDialogoDetalleDelColaborador().getNominas().getListadoDeConceptos().getConcepto().getTotalPVP();
        commonService.typeInputField(
                scn,
                PanelTitle.DIALOG_LISTADODECONCEPTOS,
                FieldByTagLabelText.TOTALPVP,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
