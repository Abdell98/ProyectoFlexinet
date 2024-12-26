package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GestionEmpresasClienteServiceType extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionEmpresasClienteServiceType(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }
//TODO @REFACTOR @FIX @PRE
//    public void typeRazonSocialDialogSeleccioneEmpresa(String scn, SystemPages page, String file, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        WebElement field = pageLocators.getInputRazonSocialDialogSeleccioneEmpresa();
//
//        try {
//            String text = field.findElement(By.xpath("./parent::div/preceding-sibling::div/label")).getText();
//            System.out.println("campo `" + text + "`"); //TODO: Cambiar a logger, para verlo en el reporte
//        } catch (Exception e) {
//            System.err.println("DEFECT: No se ha obtenido el label del campo revisar automatizacion... xpath = `"+field+"`"); //TODO: Cambiar a logger, para verlo en el reporte
//        }
//
//        commonService.typeInputField(
//                scn,
//                field,
//                gestionEmpresaClienteData.getRazonSocial(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }
//TODO @REFACTOR @FIX @PRE
//    public void typeRazonSocialEmpresa(String scn, SystemPages page, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.typeInputField(
//                scn,
//                pageLocators.getField(FieldByTagLabelText.RAZONSOCIALEMPRESA, FieldType.input, cajaNumero),
//                gestionEmpresaClienteData.getRazonSocialEmpresa(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

    public void typeRazonSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = "";
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case DIALOG_SELECCIONEEMPRESA: //INFO: esto es porque hay 2 dialogos similares aunque cambia ligeramente el titulo
                    case DIALOG_SELECCIONDEEEMPRESA:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosRiesgos().
                                getDialogSeleccioneEmpresa().
                                getRazonSocial();
                        break;
                    default:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosRiesgos().
                                getRazonSocial();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case DIALOG_SELECCIONEEMPRESA: //INFO: esto es porque hay 2 dialogos similares aunque cambia ligeramente el titulo
                    case DIALOG_SELECCIONDEEEMPRESA:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosRiesgos().
                                getDialogSeleccioneEmpresa().
                                getRazonSocial();
                        break;
                    default:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosRiesgos().
                                getRazonSocial();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRazonSocialEmpresaNew(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getRazonSocialEmpresa();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIALEMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRazonSocialFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getRazonSocialFactura();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getRazonSocialFactura();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIALFACTURA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeMargenBruto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getMargenBruto();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getMargenBruto();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.MARGENBRUTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeLimiteRiesgo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getLimiteRiesgo();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getLimiteRiesgo();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.LIMITERIESGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
//TODO @REFACTOR @FIX @PRE
//    public void typeNifEmpresa(String scn, SystemPages page, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.typeInputField(
//                scn,
//                pageLocators.getField(FieldByTagLabelText.NIFEMPRESA, FieldType.input, cajaNumero),
//                gestionEmpresaClienteData.getNIFempresa(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

    public void typeNifEmpresaNew(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getNIFempresa();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIFEMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }
//TODO @REFACTOR @FIX @PRE
//    public void typeCodigoPostal(String scn, SystemPages page, String file,  Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//
//        commonService.typeInputField(
//                scn,
//                pageLocators.getField(FieldByTagLabelText.CODIGOPOSTAL, FieldType.input, cajaNumero),
//                gestionEmpresaClienteData.getCodigoPostal(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

    public void typeCodigoPostalNew(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getCodigoPostal();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.CODIGOPOSTAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void typeTelefono(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getTelefono();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getTelefono();
                        break;
                }
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELEFONO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }

    public void typeTelf1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getTelf1();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getTelf1();
                        break;
                }
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.INP_TELF1,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }

    public void typeTelf2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getTelf2();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getTelf2();
                        break;
                }
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELF2,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }
//TODO @REFACTOR @FIX @PRE
//    public void typeNombreDireccionDeFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
//        commonService.getJsonFileData(scn,page,file);
//        commonService.typeInputField(
//                scn,
//                panelTitle,
//                FieldByTagLabelText.NOMBRE,
//                FieldType.input,
//                cajaNumero,
//                gestionEmpresaClienteData.getNombreDireccionDeFactura(),
//                isRequired,
//                waitForSpinner,
//                checkNoMessageShown
//        );
//    }

    public void typeId(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case DIALOG_ACTIVIDAD:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeActividad().
                                getId();
                        break;
                    case DIALOG_SIC:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeSIC().
                                getId();
                        break;
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getId();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case DIALOG_ACTIVIDAD:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeActividad().
                                getId();
                        break;
                    case DIALOG_SIC:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeSIC().
                                getId();
                        break;
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getId();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.ID,
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
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) { //@panelTitle
                    case DIALOG_BUSQUEDADECONVENIOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getDialogBusquedaDeConvenios().
                                getNombre();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASLABORALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasLaborales().
                                getNombre();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASPROFESIONALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasProfesionales().
                                getNombre();
                        break;
                    case DIALOG_ACTIVIDAD:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeActividad().
                                getNombre();
                        break;
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getNombre();
                        break;
                    case DIALOG_SIC:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeSIC().
                                getNombre();
                        break;
                    case TAB_DATOSECONOMICOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabDatosEconomicos().
                                    getNombre_DireccionFactura();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabDatosEconomicos().
                                    getNombre_Contacto();
                        }
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) { //@panelTitle
                    case DIALOG_BUSQUEDADECONVENIOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getDialogBusquedaDeConvenios().
                                getNombre();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASLABORALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasLaborales().
                                getNombre();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASPROFESIONALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasProfesionales().
                                getNombre();
                        break;
                    case DIALOG_ACTIVIDAD:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeActividad().
                                getNombre();
                        break;
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getNombre();
                        break;
                    case DIALOG_SIC:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeSIC().
                                getNombre();
                        break;
                    case TAB_DATOSECONOMICOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabDatosEconomicos().
                                    getNombre_DireccionFactura();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabDatosEconomicos().
                                    getNombre_Contacto();
                        }
                        break;
                }
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

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void typeDestinatario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) { //@page
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getDestinatario();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getDestinatario();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESTINATARIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeSiglas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getSiglas();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getSiglas();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.SIGLAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeRappel_Input(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getRappel_input();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getRappel_input();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_RAPPEL,
                FieldType.checkboxinput,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
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
                                    getDireccion_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getDireccion_DomicilioFiscal();
                        }
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
                                    getDireccion_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getDireccion_DomicilioFiscal();
                        }
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIRECCION,
                FieldType.input,
                cajaNumero, //INFO: CAJA 1 en IDENTIFICATIVOS
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void typeLocalidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
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
                                    getLocalidad_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getLocalidad_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getLocalidad();
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
                                    getLocalidad_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getLocalidad_DomicilioFiscal();
                        }
                        break;
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getLocalidad();
                        break;

                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.LOCALIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    //TODO: pasar a common, porque se usa en otras páginas o crear otro identido para la pagina
    public void typeCP(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosEconomicos().
                                getCP();
                        break;
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getCP_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteAlta().
                                    getTabIdentificativos().
                                    getCP_DomicilioFiscal();
                        }
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_DATOSECONOMICOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosEconomicos().
                                getCP();
                        break;
                    case TAB_IDENTIFICATIVOS:
                        if(cajaNumero == 1) {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getCP_DomicilioSocial();
                        } else {
                            datosAux = datosGestionDeEmpresaCliente.
                                    getGestionDeEmpresaClienteModificar().
                                    getTabIdentificativos().
                                    getCP_DomicilioFiscal();
                        }
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.CP,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typePaginaWeb(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getPaginaWeb();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getPaginaWeb();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.PAGINAWEB,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeBOE(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getBOE();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case TAB_IDENTIFICATIVOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getBOE();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.BOE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeOficinaOrigenDelContrato(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        String datosAux2 = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getOficinaOrigenDelContrato1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getOficinaOrigenDelContrato2();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getOficinaOrigenDelContrato1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getOficinaOrigenDelContrato2();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFICINAORIGENDELCONTRATO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFICINAORIGENDELCONTRATO,
                FieldType.input2,
                cajaNumero,
                datosAux2,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDiasFijosDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        String datosAux2 = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getDiasFijosDePago1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getDiasFijosDePago2();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getDiasFijosDePago1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getDiasFijosDePago2();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASFIJOSDEPAGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIASFIJOSDEPAGO,
                FieldType.input2,
                cajaNumero,
                datosAux2,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }

    public void typeNumeroDeCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getNumeroDeCliente();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getNumeroDeCliente();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NUMERODECLIENTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeBanco(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getBanco();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getBanco();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.BANCO,
                FieldType.input,
                cajaNumero, //INFO: 1 y 2 para las 2 cajas en el formulario
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getDC();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getDC();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getNCuenta();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getNCuenta();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NCUENTA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeIBANPais(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getIBANPais();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getIBANPais();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANPAIS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeIBANDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getIBANDC();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getIBANDC();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANDC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeIBANExtranjero(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getIBANExtranjero();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getIBANExtranjero();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANEXTRANJERO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeNombre_DireccionFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteAlta().
                getTabDatosEconomicos().
                getNombre_DireccionFactura();
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

    public void typeDestinatario_DireccionFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteAlta().
                getTabDatosEconomicos().
                getDestinatario();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESTINATARIO,
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
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getNIF();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getNIF();
                break;
        }

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

    public void typeObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabIdentificativos().
                        getObservaciones();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getObservaciones();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeApellidos(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        String datosAux2 = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getApellidos1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getApellidos2();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getApellidos1();
                datosAux2 = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getApellidos2();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.APELLIDOS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.APELLIDOS,
                FieldType.input2,
                cajaNumero,
                datosAux2,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeCargo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getCargo();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getCargo();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.CARGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeEmail(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosEconomicos().
                        getEmail();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosEconomicos().
                        getEmail();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMAIL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );

    }

    public void typeNumeroMaximoDeColaboradoresEnFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getNumeroMaximoDeColaboradoresEnFactura();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getNumeroMaximoDeColaboradoresEnFactura();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.NUMEROMAXIMODECOLABORADORESENFACTURA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeImporteMaximoPorFacturaImporteCorrespondienteIncluido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getImporteMaximoPorFacturaImporteCorrespondienteIncluido();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getImporteMaximoPorFacturaImporteCorrespondienteIncluido();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.IMPORTEMAXIMOPORFACTURAIMPORTECORRESPONDIENTEINCLUIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


    /** QBE fields **/
    public void typeQbeNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case DIALOG_BUSQUEDADECONVENIOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabIdentificativos().
                                getDialogBusquedaDeConvenios().
                                getTable().
                                getQbe_nombre();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case DIALOG_BUSQUEDADECONVENIOS:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabIdentificativos().
                                getDialogBusquedaDeConvenios().
                                getTable().
                                getQbe_nombre();
                        break;
                }
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBRE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCodigo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case DIALOG_BUSQUEDADECATEGORIASLABORALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasLaborales().
                                getTable().
                                getQbe_codigo();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASPROFESIONALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasProfesionales().
                                getTable().
                                getQbe_codigo();
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case DIALOG_BUSQUEDADECATEGORIASLABORALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasLaborales().
                                getTable().
                                getQbe_codigo();
                        break;
                    case DIALOG_BUSQUEDADECATEGORIASPROFESIONALES:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabCategoriaSeguridadSocial().
                                getDialogBusquedasDeCategoriasProfesionales().
                                getTable().
                                getQbe_codigo();
                        break;
                }
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CODIGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCategoriaLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getDialogBusquedasDeCategoriasLaborales().
                        getTable().
                        getQbe_categoriaLaboral();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getDialogBusquedasDeCategoriasLaborales().
                        getTable().
                        getQbe_categoriaLaboral();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CATEGORIALABORAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCategoriaProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabCategoriaSeguridadSocial().
                        getDialogBusquedasDeCategoriasProfesionales().
                        getTable().
                        getQbe_categoriaProfesional();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabCategoriaSeguridadSocial().
                        getDialogBusquedasDeCategoriasProfesionales().
                        getTable().
                        getQbe_categoriaProfesional();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CATEGORIAPROFESIONAL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeIdActividad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeActividad().
                        getTable().
                        getQbe_idActividad();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeActividad().
                        getTable().
                        getQbe_idActividad();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_IDACTIVIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeActividad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeActividad().
                        getTable().
                        getQbe_actividad();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeActividad().
                        getTable().
                        getQbe_actividad();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_ACTIVIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeIDCNAE(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeCNAE().
                        getTable().
                        getQbe_idCnae();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeCNAE().
                        getTable().
                        getQbe_idCnae();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_IDCNAE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCNAE(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        FieldByTagLabelText fieldAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                switch (panelTitle) {
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getTable().
                                getQbe_cnae();
                        fieldAux = FieldByTagLabelText.QBE_CNAE;
                        break;
                    case DIALOG_SELECCIONEEMPRESA:
                    case DIALOG_SELECCIONDEEEMPRESA:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteAlta().
                                getTabDatosRiesgos().
                                getDialogSeleccioneEmpresa().
                                getTable().
                                getQbe_cnae();
                        fieldAux = FieldByTagLabelText.QBE_CNAE2;
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                switch (panelTitle) {
                    case DIALOG_CNAE:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabRetratoRobot().
                                getDialogBusquedaDeCNAE().
                                getTable().
                                getQbe_cnae();
                        fieldAux = FieldByTagLabelText.QBE_CNAE;
                        break;
                    case DIALOG_SELECCIONEEMPRESA:
                    case DIALOG_SELECCIONDEEEMPRESA:
                        datosAux = datosGestionDeEmpresaCliente.
                                getGestionDeEmpresaClienteModificar().
                                getTabDatosRiesgos().
                                getDialogSeleccioneEmpresa().
                                getTable().
                                getQbe_cnae();
                        fieldAux = FieldByTagLabelText.QBE_CNAE2;
                        break;
                }
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_cNAE();
                fieldAux = FieldByTagLabelText.QBE_CNAE2;
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

    public void typeQbeVentas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_ventas();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_VENTAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeRangoEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_rangoEmpleados();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_RANGOEMPLEADOS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeSIC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeSIC().
                        getTable().
                        getQbe_sic();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeSIC().
                        getTable().
                        getQbe_sic();
                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_SIC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeIDSIC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabRetratoRobot().
                        getDialogBusquedaDeSIC().
                        getTable().
                        getQbe_idSic();

                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getDialogBusquedaDeSIC().
                        getTable().
                        getQbe_idSic();

                break;
        }

        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_IDSIC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNombreEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_nombreEmpresa();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_nombreEmpresa();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREEMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_direccion();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_direccion();
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

    public void typeQbeProvincia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_provincia();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_provincia();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_PROVINCIA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCp(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_cP();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CP,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeCargoContacto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_cargoContacto();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_CARGOCONTACTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeTelefonoContacto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_telefonoContacto();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_TELEFONOCONTACTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNombreContacto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteConsulta().
                getTable().
                getQbe_nombreContacto();
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBRECONTACTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

    public void typeQbeNifEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_nifEmpresa();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_nIFEmpresa();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NIFEMPRESA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

   public void typeQbeResponsable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        commonService.jsonFileNew(file);
       String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_responsable();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_responsable();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_RESPONSABLE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }

   public void typeQbeNombreOficina(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonService.jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getDialogSeleccioneEmpresa().
                        getTable().
                        getQbe_responsable();
                break;
            case GESTION_EMPRESAS_CLIENTE__CONSULTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteConsulta().
                        getTable().
                        getQbe_nombreOficina();
                break;
        }
        commonService.typeInputField(
                scn,
                panelTitle,
                FieldByTagLabelText.QBE_NOMBREOFICINA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired,
                waitForSpinner,
                checkNoMessageShown
        );
    }


}
