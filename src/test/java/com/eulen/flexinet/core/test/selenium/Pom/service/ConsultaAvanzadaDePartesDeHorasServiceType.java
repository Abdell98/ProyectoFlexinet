package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class ConsultaAvanzadaDePartesDeHorasServiceType extends BasePage {
    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;
    public ConsultaAvanzadaDePartesDeHorasServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    /*----------------   IMPUT  -----------------*/

    public void typeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getEmpresa();
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

    public void typeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getNombre();
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getPrimerApellido();
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getSegundoApellido();
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

    public void typeAnio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getAnio();
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

    public void typeNIF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getNIF();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    /*----------------   TABLA PARTES  -----------------*/

    public void typeQbeNParte(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_nroParte();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NROPARTE,
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_idContrato();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_IDCONTRATO,
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_nIF();
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

    public void typeQbeColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_colaborador();
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

    public void typeQbeEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_empresa();
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

    public void typeQbeMes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_mes();
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

    public void typeQbeDiaDeInicio(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_diaDeInicio();
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_diaDeFin();
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

    public void typeQbeParteOriginal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getTable().getQbe_parteOriginal();
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

    /*----------------   TABLA COLABORADOR  -----------------*/

    public void typeQbeNombreYApellido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getDialogoSeleccionDeColaboradores().getTable().getQbe_nombreYApellidos();
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
        String datosAux = datosConsultaAvanzadaDePartesDeHoras.getGestionAvanzadaConsultaAvanzadaDePartesDeHoras().getDialogoSeleccionDeColaboradores().getTable().getQbe_direccion();
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
}
