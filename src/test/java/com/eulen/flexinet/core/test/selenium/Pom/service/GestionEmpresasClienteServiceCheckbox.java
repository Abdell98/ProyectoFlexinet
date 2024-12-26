package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionEmpresasClienteServiceCheckbox extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionEmpresasClienteServiceCheckbox(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void checkClientesNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getChk_clientesNacional();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_clientesNacional();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_CLIENTESNACIONAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkLaEmpresaProvieneDeMarketing(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getChk_LaEmpresaProvieneDeMarketing();
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_LAEMPRESAPROVIENEDEMARKETING,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkFacturaGlobalizada(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getChk_facturaGlobalizada();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_facturaGlobalizada();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_FACTURAGLOBALIZADA,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkEnvioCPD(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getChk_envioCPD();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_envioCPD();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ENVIOCPD,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkEnvioFacturaDigital(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getChk_envioFacturaDigital();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_envioFacturaDigital();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ENVIOFACTURADIGITAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkRappel_CheckBox(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getChk_rappel_Checkbox();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_rappel_Checkbox();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_RAPPEL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getChk_personalizable();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getChk_personalizable();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PERSONALIZABLE,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorTiposDeHoras(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porTiposDeHoras();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porTiposDeHoras();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORTIPOSDEHORAS,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorCentrosDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porCentrosDeTrabajo();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porCentrosDeTrabajo();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCENTROSDETRABAJO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorCategoriaProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porCategoriaProfesional();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porCategoriaProfesional();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCATEGORIAPROFESIONAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkMostrarPrecioUnidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_mostrarPrecioUnidad();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_mostrarPrecioUnidad();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_MOSTRARPRECIOUNIDAD,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porColaborador();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porColaborador();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCOLABORADOR,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkColaboradorConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_colaboradorConcepto();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_colaboradorConcepto();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_COLABORADORCONCEPTO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkMostrarMinFinicioMaxFFinPartes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_mostrarMinFInicioMaxFFinPartes();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_mostrarMinFInicioMaxFFinPartes();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_MOSTRARMINFINICIOMAXFFINPARTES,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorDuracionDelContrato5Dias5Dias(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porDuracionDelContrato5Dias5Dias();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porDuracionDelContrato5Dias5Dias();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORDURACIONDELCONTRATO5DIAS5DIAS,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORDEPARTAMENTOALQUESEINCORPORARAELCOLABORADORENELCENTRODETRABAJO,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorNumeroDeColaboradores(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porNumeroDeColaboradores();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porNumeroDeColaboradores();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORNUMERODECOLABORADORES,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPorImporteGlobal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_porImporteGlobal();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_porImporteGlobal();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORIMPORTEGLOBAL,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkElTipoDeFacturacionEsPersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getChk_elTipoDeFacturacionEsPersonalizable();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_elTipoDeFacturacionEsPersonalizable();
                break;
        }

        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ELTIPODEFACTURACIONESPERSONALIZABLE,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkFirmanteCPDPRLPersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getChk_firmanteCPDPRLPersonalizable();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getChk_firmanteCPDPRLPersonalizable();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_FIRMANTECPDPRLPERSONALIZABLE,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void checkPRLPersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getChk_prlPersonalizable();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getChk_prlPersonalizable();
                break;
        }
        commonService.checkBoxField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PRLPERSONALIZABLE,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

}
