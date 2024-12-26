package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionEmpresasClienteServiceSelect extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionEmpresasClienteServiceSelect(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void selectVentas(String scn, SystemPages page, PanelTitle panelTitle, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getVentas();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getVentas();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getVentas();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.VENTAS,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectNEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getNEmpleados();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getNEmpleados();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.NEMPLEADOS,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
//TODO @REFACTOR @FIX @PRE
//    public void selectRangoDeEmpleados(String scn, SystemPages page, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.selectField(
//                scn,
//                pageLocators.getField(FieldByTagLabelText.RANGODEEMPLEADOS, FieldType.select, cajaNumero),
//                gestionEmpresaClienteData.getRangoDeEmpleados(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

    public void selectRangoDeEmpleadosNew(String scn, SystemPages page, PanelTitle panelTitle, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getRangoDeEmpleados();
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.RANGODEEMPLEADOS,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void selectClausuladoDelContratoLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getClausuladoDelContratoLaboral();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getClausuladoDelContratoLaboral();
                        break;
                }
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCONTRATOLABORAL,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void selectClausuladoDelCPD(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getClausuladoDelCPD();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getClausuladoDelCPD();
                        break;
                }
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCPD,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void selectTipo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getTipo_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getTipo_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getTipo();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getTipo_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getTipo_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getTipo();
                        break;
                }
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.TIPO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void selectProvincia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getProvincia_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getProvincia_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getProvincia();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getProvincia_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getProvincia_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getProvincia();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getProvincia();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.PROVINCIA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMedioDeCapt(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getMedioDeCapt();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getMedioDeCapt();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPT,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectMedioDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getMedioDePago();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getMedioDePago();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODEPAGO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectFormaDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getFormaDePago();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getFormaDePago();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.FORMADEPAGO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectRespDeCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getRespDeCuenta();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getRespDeCuenta();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.RESPDECUENTA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectImpuestosTipoPorcentaje(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getImpuestosTipoPorcentaje();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getImpuestosTipoPorcentaje();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.IMPUESTOSTIPOPORCENTAJE,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectEntidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getEntidad();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getEntidad();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.ENTIDAD,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectSucursal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getSucursal();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getSucursal();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SUCURSAL,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectRegimenDeLaSegSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getRegimenDeLaSegSocial();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getRegimenDeLaSegSocial();
                break;
        }
        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.SEL_REGIMENSDELASEGSOCIAL,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void selectGrupo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeCNAE().
                        getGrupo();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeCNAE().
                        getGrupo();
                break;
        }

        commonService.selectField(
                scn,
                panelTitle,
                FieldByTagLabelText.GRUPO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
