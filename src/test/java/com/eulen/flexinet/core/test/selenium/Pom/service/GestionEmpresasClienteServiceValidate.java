package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionEmpresaClienteQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.List;

public class GestionEmpresasClienteServiceValidate extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionEmpresasClienteServiceValidate(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void validateCIF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getLkp_cif();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CIF,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateEstado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getEstado();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getEstado();
                break;
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.ESTADO,
                FieldType.label,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    /*** VALIDATIONS ALTA ***/

    public void validateRazonSocial(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getRazonSocial();

        FieldType fieldtype;

        switch (panelTitle) {
            case CABECERA:
                fieldtype = FieldType.label;
                break;
            default:
                fieldtype = FieldType.input;
                break;
        }

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIAL,
                fieldtype,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateRazonSocialFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getRazonSocialFactura();

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.RAZONSOCIALFACTURA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateMargenBruto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getMargenBruto();

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.MARGENBRUTO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateLimiteRiesgo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getLimiteRiesgo();

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LIMITERIESGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );

    }

    public void validateMedioDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getMedioDePago();

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODEPAGO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateFormaDePago(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosRiesgos().
                getFormaDePago();

        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.FORMADEPAGO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateModalTexto(ModalTitle title, String message) throws Exception {
        try {
            System.out.println("Validando mensaje `"+message+"`");
            pageLocators.getTextoModalInformacion(title,message);
        } catch (Exception e) {
            throw new AssertionError("\nERROR: No se ha mostrado el mensaje esperado....", e);
        }
    }

    public void validateModalSeleccioneEmpresaEsVisible() throws Exception {
        waitUntilIsDisplayed(pageLocators.getDialogSeleccioneEmpresa());
    }

    /*** Validate Identificativos ***/


    //TODO: deprecar metodo siglas antiguo anterior por el nuevo siguiente
    public void validateSiglas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getSiglas();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.SIGLAS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateRappelInput(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getRappel_input();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_RAPPEL,
                FieldType.checkboxinput,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo es usado por centros de trabajo, copiarlo a su propio service
    public void validateTipo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux=null;
        if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_IDENTIFICATIVOS)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getTipo_DomicilioSocial();
                    break;
                case 2:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getTipo_DomicilioFiscal();
                    break;
            }
        } else if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_DATOSECONOMICOS)){
            datosAux = datosGestionDeEmpresaCliente.
                    getGestionDeEmpresaClienteModificar().
                    getTabDatosEconomicos().
                    getTipo();
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TIPO,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateDireccion(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (cajaNumero) {
            case 1:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getDireccion_DomicilioSocial();
                break;
            case 2:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getDireccion_DomicilioFiscal();
                break;
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.DIRECCION,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateLocalidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_IDENTIFICATIVOS)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getLocalidad_DomicilioSocial();
                    break;
                case 2:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getLocalidad_DomicilioFiscal();
                    break;
            }
        } else if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_DATOSECONOMICOS)) {
            datosAux = datosGestionDeEmpresaCliente.
                    getGestionDeEmpresaClienteModificar().
                    getTabDatosEconomicos().
                    getLocalidad();
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LOCALIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateProvincia(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_IDENTIFICATIVOS)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getProvincia_DomicilioSocial();
                    break;
                case 2:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getProvincia_DomicilioFiscal();
                    break;
            }
        } else if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_DATOSECONOMICOS)) {
            datosAux = datosGestionDeEmpresaCliente.
                    getGestionDeEmpresaClienteModificar().
                    getTabDatosEconomicos().
                    getProvincia();
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.PROVINCIA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateCP(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_IDENTIFICATIVOS)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getCP_DomicilioSocial();
                    break;
                case 2:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabIdentificativos().
                            getCP_DomicilioFiscal();
                    break;
            }
        } else if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_DATOSECONOMICOS)) {
            datosAux = datosGestionDeEmpresaCliente.
                    getGestionDeEmpresaClienteModificar().
                    getTabDatosEconomicos().
                    getCP();
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CP,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateConvColectivoEmpresaUsuaria(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getLkp_convColectivoEmpresaUsuaria();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LKP_CONVCOLECTIVOEMPRESAUSUARIA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateBoe(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getBOE();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.BOE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateMedioDeCapt(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getMedioDeCapt();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.MEDIODECAPT,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateOficinaOrigenDelContrato1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getOficinaOrigenDelContrato1();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.OFICINAORIGENDELCONTRATO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateOficinaOrigenDelContrato2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getOficinaOrigenDelContrato2();

        WebElement element = null;

        waitUntilIsDisplayed(element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.OFICINAORIGENDELCONTRATO,
                FieldType.input,
                cajaNumero
        ).findElement(By.xpath("./parent::div/following-sibling::div[1]/input")));

        commonService.validateField(
                scn,
                element,
                datosAux,
                isRequired
        );
    }

    public void validateRespDeCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getRespDeCuenta();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.RESPDECUENTA,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    //TODO para centros de trabajo copiar este validate a su propio service
    public void validateTelefono(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getTelefono();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELEFONO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validatePaginaWeb(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getPaginaWeb();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.PAGINAWEB,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateObservaciones(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getObservaciones();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.OBSERVACIONES,
                FieldType.textarea,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    /*** CHECKBOX ***/

    public void validateClientesNacional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getChk_clientesNacional();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_CLIENTESNACIONAL,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkFacturaGlobalizada(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        switch (panelTitle) {
            case TAB_IDENTIFICATIVOS:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabIdentificativos().
                        getChk_facturaGlobalizada();
                break;
            case TAB_RETRATOROBOT:
                datosAux = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabRetratoRobot().
                        getChk_facturaGlobalizada();
                break;
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_FACTURAGLOBALIZADA,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateEnvioCpd(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getChk_envioCPD();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ENVIOCPD,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateEnvioFacturaDigital(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getChk_envioFacturaDigital();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_ENVIOFACTURADIGITAL,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateRappelCheckBox(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabIdentificativos().
                getChk_rappel_Checkbox();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_RAPPEL,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    /** Validate Datos Economicos **/

    public void validateNumeroCliente(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getNumeroDeCliente();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NUMERODECLIENTE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateBanco(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getBanco();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.BANCO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateEntidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getEntidad();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.ENTIDAD,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateSucursal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getSucursal();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.SUCURSAL,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getDC();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.DC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateNCuenta(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getNCuenta();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NCUENTA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateIBANPais(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getIBANPais();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANPAIS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateIBANDC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getIBANDC();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANDC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateIBANExtranjero(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getIBANExtranjero();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.IBANEXTRANJERO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validatePersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getChk_personalizable();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PERSONALIZABLE,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateNombre(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = null;
        if(panelTitle != null && panelTitle.equals(PanelTitle.TAB_DATOSECONOMICOS)) {
            switch (cajaNumero) {
                case 1:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabDatosEconomicos().
                            getNombre_DireccionFactura();
                    break;
                case 2:
                    datosAux = datosGestionDeEmpresaCliente.
                            getGestionDeEmpresaClienteModificar().
                            getTabDatosEconomicos().
                            getNombre_Contacto();
                    break;
            }
        }
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NOMBRE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateDestinatario(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getDestinatario();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.DESTINATARIO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateClausuladoDelContratoLaboral(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getClausuladoDelContratoLaboral();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCONTRATOLABORAL,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }
    //TODO este metodo se usa en centros de trabajo, verlo de pasar a su propio service
    public void validateClausuladoDelCPD(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, Boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getClausuladoDelCPD();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CLAUSULADODELCPD,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateNIF(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getNIF();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NIF,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateApellido1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getApellidos1();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.APELLIDOS,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateApellido2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getApellidos1();

        WebElement element;

        waitUntilIsDisplayed(element = pageLocators.getField(
                panelTitle,
                FieldByTagLabelText.APELLIDOS,
                FieldType.input,
                cajaNumero
        ).findElement(By.xpath("./parent::div/following-sibling::div[1]/input")));

        commonService.validateField(
                scn,
                element,
                datosAux,
                isRequired
        );
    }

    public void validateCargo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getCargo();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CARGO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateTelf1(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getTelf1();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELF1,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateTelf2(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getTelf2();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.TELF2,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateEmail(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getEmail();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.EMAIL,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateFirmanteCPDPRLPersonalizable(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabDatosEconomicos().
                getChk_firmanteCPDPRLPersonalizable();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_FIRMANTECPDPRLPERSONALIZABLE,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    /** Retrato Robot **/

    public void validateLkpActividad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getLkp_actividad();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LKP_ACTIVIDAD,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateLkpCNAE(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getLkp_cNAE();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LKP_CNAE,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateLkpSIC(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getLkp_sIC();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.LKP_SIC,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateVentas(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getVentas();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.VENTAS,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateNEmpleados(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getNEmpleados();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NEMPLEADOS,
                FieldType.select,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorTiposDeHoras(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porTiposDeHoras();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORTIPOSDEHORAS,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorCentrosDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porCentrosDeTrabajo();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCENTROSDETRABAJO,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorCategoriaProfesional(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porCategoriaProfesional();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCATEGORIAPROFESIONAL,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkMostrarPrecioUnidad(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_mostrarPrecioUnidad();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_MOSTRARPRECIOUNIDAD,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorColaborador(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porColaborador();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORCOLABORADOR,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkColaboradorConcepto(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_colaboradorConcepto();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_COLABORADORCONCEPTO,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkMostrarMinFInicioMaxFFinPartes(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_mostrarMinFInicioMaxFFinPartes();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_MOSTRARMINFINICIOMAXFFINPARTES,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorDuracionDelContrato5Dias5Dias(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porDuracionDelContrato5Dias5Dias();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORDURACIONDELCONTRATO5DIAS5DIAS,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORDEPARTAMENTOALQUESEINCORPORARAELCOLABORADORENELCENTRODETRABAJO,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorNumeroDeColaboradores(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porNumeroDeColaboradores();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORNUMERODECOLABORADORES,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateNumeroMaximoDeColaboradoresEnFactura(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getNumeroMaximoDeColaboradoresEnFactura();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.NUMEROMAXIMODECOLABORADORESENFACTURA,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateChkPorImporteGlobal(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getChk_porImporteGlobal();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.CHK_PORIMPORTEGLOBAL,
                FieldType.checkbox,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    public void validateImporteMaximoPorFacturaImporteCorrespondienteIncluido(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired) throws Exception {
        jsonFileNew(file);
        String datosAux = datosGestionDeEmpresaCliente.
                getGestionDeEmpresaClienteModificar().
                getTabRetratoRobot().
                getImporteMaximoPorFacturaImporteCorrespondienteIncluido();
        commonService.validateField(
                scn,
                panelTitle,
                FieldByTagLabelText.IMPORTEMAXIMOPORFACTURAIMPORTECORRESPONDIENTEINCLUIDO,
                FieldType.input,
                cajaNumero,
                datosAux,
                isRequired
        );
    }

    /*** Modificar Empresa ***/

    /**
     * Este metodo va a cambiar su comportamiento según el escenario a probar 'scn',
     * Si el escenario es 'ModificarEmpresaEnvioKO' confirmará que lo que hay en BD no sea lo mismo que pasamos en el json
     * Si el escenario es 'ModificarEmpresaSinEnvioERP' confirmará que lo que hay en BD es igual a lo del json
     * Si alguno de los datos no existe en el json se json se ese campo se saltará
     */
    public void confirmarCambiosGuardadosEnTablaEmpresa(String scn, SystemPages page, PanelTitle panelTitle, String file) throws Exception {
        System.out.println("------------CONFIRMANDO-CAMBIOS-GUARDADOS-EN-EMPRESA----------------");
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        //String data = gestionEmpresaClienteData.getNIFempresa();
        String data = datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteAlta().getTabDatosRiesgos().getLkp_cif();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(GestionEmpresaClienteQuery.getEmpresaBy(data));

        if(rows.size() > 1) {
            System.err.println("WARNING: Se ha encontrado mas de 1 compañia para el CIF "+ data);
        }

        if(rows.size() < 1) {
            throw new AssertionError("ERROR: la query no ha devuelto resultados...");
        }

        commonService.getJsonFileData(scn,page,file+"."+ panelTitle);
        for (Map<String, Object> row : rows) {

            for(Map.Entry<String, Object> column : row.entrySet()) {
                if(column.getValue() == null) {
                    column.setValue("");
                }
//                switch (column.getKey()) {
//                    case "ENTIDAD":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getEntidad(),column);
//                        break;
//                    case "SUCURSAL":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getSucursal(),column);
//                        break;
//                    case "DC":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getDC(),column);
//                        break;
//                    case "NUMERO_CUENTA":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getNCuenta(),column);
//                        break;
//                    case "IBAN_PAIS":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getIBANPais(),column);
//                        break;
//                    case "IBAN_DC":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getIBANDC(),column);
//                        break;
//                    case "IBAN_EXTRANJERO":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getIBANExtranjero(),column);
//                        break;
//                    case "TIPO_DIR_FACTURA":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getTipo(),column);
//                        break;
//                    case "DIRECCION_DIR_FACTURA":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getNombreDireccionDeFactura(),column);
//                        break;
//                    case "LOCALIDAD_DIR_FACTURA":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getLocalidad(),column);
//                        break;
//                    case "PROVINCIA_DIR_FACTURA":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getProvincia(),column);
//                        break;
//                    case "CP_DIR_FACTURA":
//                        if(gestionEmpresaClienteData.getCP() != null)
//                            datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getCP().startsWith("0") ? gestionEmpresaClienteData.getCP().replaceFirst("^0", "") : gestionEmpresaClienteData.getCP(),column);
//                        else
//                            datosEconomicosBDvalidation(scn, null, column);
//                        break;
//                    case "DESTINATARIO":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getDestinatario(),column);
//                        break;
//                    case "CLAUSURADO_CONTRATO_LABORAL":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getClausuladoDelContratoLaboral(),column);
//                        break;
//                    case "CLAUSURADO_CPD":
//                        datosEconomicosBDvalidation(scn, gestionEmpresaClienteData.getClausuladoDelCPD(),column);
//                        break;
//                        //TODO: faltan campos por añadir, pero hay que analizar si son necesarios
//                }
            }
        }
    }

    /**
     * El siguiente metodo se usa unicamente dentro de confirmarCambioGuardadoEnBDdatosEconomicos
     * @param scn
     * @param jsonDataValue
     * @param column
     * @return
     */
    public void datosEconomicosBDvalidation(String scn, String jsonDataValue, Map.Entry<String, Object> column){
        System.out.println("Verificando...`" + column.getKey() + "`: `" + column.getValue() + "`");
        if(jsonDataValue == null || jsonDataValue.isEmpty()) {
            System.out.println("..."+column.getKey()+"...SKIPPED");
            return;
            //return false; // Retorna false si el json viene vacio, para saltarnos el campo
        }
        switch (scn){
            case "ModificarEmpresaEnvioKO":
                Assert.assertNotEquals(jsonDataValue,column.getValue().toString().trim()); // Se valida que el dato no se haya registrado en BD
                break;
            case "ModificarEmpresaEnvioOK":
            case "ModificarEmpresaSinEnvioERP":
                Assert.assertEquals(jsonDataValue,column.getValue().toString().trim()); // Se valida que el cambio se ha registrado en BD
                break;
        }
        System.out.println("..."+column.getKey()+"...PASS!!!");
        //return true; // Retorna true si la validación a sido correcta
    }

    // Los siguientes metodos son comunes
    public void escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------ESCRIBIENDO-CSV-EXTERNAL_MISC_ENVIO-ANTES-DE-GUARDAR-----------------");
        System.out.println("Se escribe el estado actual de external_misc_envios para compararlo despues de guardar.");
        this.jsonFile("datosLogin.json");
        String byUser = loginData.getUser();
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(GestionEmpresaClienteQuery.getExternalMiscEnvios(byUser));
        writeDataToCSV(rows,file+".externalMiscEnvios.csv");
        if(rows.size() < 1) {
            System.out.println("INFO: No hay resultados en la tabla...");
            //TODO: ajustar ruta para que sea compatible con la nueva estructura de datos
            //TODO: UPDATE 08/05/2024: ajustado, falta probar
            //writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");
            writeDataToCSV(rows,file+".externalMiscEnvios.csv");
            return;
        }
        //TODO: ajustar ruta para que sea compatible con la nueva estructura de datos
        //TODO: UPDATE0 08/05/2024: ajustado, falta probar
        //writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");
        writeDataToCSV(rows,file+".externalMiscEnvios.csv");
    }
    public void confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------COMPARANDO-CSV-EXTERNAL_MISC_ENVIO-DESPUES-DE-GUARDAR----------------");
        System.out.println("Se comprueba si hay alguna nueva traza comparardola con el csv guardado.");
        this.jsonFile("datosLogin.json");
        String byUser = loginData.getUser();

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(GestionEmpresaClienteQuery.getExternalMiscEnvios(byUser));

        boolean tableHasMoreRecordsThanCsv = rows.size() > countSizeInCSV(page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");
        boolean tableHasLessRecordsThanCsv = rows.size() < countSizeInCSV(page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");
        boolean tableHasEqualRecordsThanCsv = rows.size() == countSizeInCSV(page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");

        String cdStatusFromDB = "";

        if(rows.size() > 0) {
            cdStatusFromDB = rows.get(0).get("CD_STATUS").toString();
        }
        /** guardo el estado de external envios despues de haber guardado a modo de log
         * En esta iteración no se usará otra vez.
         */
        //TODO: ajustar ruta para que sea compatible con la nueva estructura de datos
        //TODO: UPDATE0 08/05/2024: ajustado, falta probar
        //writeDataToCSV(rows, page  + "/" + scn + "/"+ file +".externalMiscEnvios.csv");
        writeDataToCSV(rows,file+".externalMiscEnvios.csv");

        if(tableHasMoreRecordsThanCsv) {
            switch (scn) { //@scenarios
                case "ModificarEmpresaEnvioKO":
                case "AltaClienteContratoEnvioKO":
                case "ModificarClienteContratoEnvioKO":
                case "AltaCentroDeTrabajoEnvioKO":
                    if(cdStatusFromDB.equals("KO")) {
                        System.out.println("PASS: Se ha creado una nueva traza en la tabla EXTERNAL_MISC_ENVIO con estado `KO`...\n"+ rows.get(0));
                        return;
                    } else if(cdStatusFromDB.equals("OK")) {
                        throw new AssertionError("FAIL: Se ha creado una nueva traza en la tabla EXTERNAL_MISC_ENVIO con estado `OK`\n" + rows.get(0));
                    } else {
                        throw new Exception("ERROR: El campo CD_STATUS no tiene ninguno de los posibles los valores esperados...");
                    }
                case "ModificarEmpresaEnvioOK":
                case "AltaClienteContratoEnvioOK":
                case "ModificarClienteContratoEnvioOK":
                case "AltaCentroDeTrabajoEnvioOK":
                    if(cdStatusFromDB.equals("OK")) {
                        System.out.println("PASS: Se ha creado una nueva traza en la tabla EXTERNAL_MISC_ENVIO con estado `OK`...\n"+ rows.get(0));
                    } else if (cdStatusFromDB.equals("KO")) {
                        throw new AssertionError("FAIL: Se ha creado una nueva traza en la tabla EXTERNAL_MISC_ENVIO con estado `KO`\n" + rows.get(0));
                    } else {
                        throw new Exception("ERROR: El campo CD_STATUS no tiene ninguno de los posibles los valores esperados...");
                    }
                    break;
                case "ModificarClienteContratoSinEnvioERP":
                case "ModificarEmpresaSinEnvioERP":
                case "ModificarCentroDeTrabajoSinEnvioERP":
                    throw new AssertionError("FAIL: Se han detectado nuevas trazas en EXTERNAL_MISC_ENVIO cuando no debería haberlas...");
            }
        } else if(tableHasLessRecordsThanCsv) {
            /**
             * Supuesto para este caso:
             * - Dado que en la consulta inicialmente miraba todas las columnas, la columna DES_MENSAJE_ENVIO
             * mostraba texto de errores, y algunos podían tener comas, por ello es posible que detectase
             * que el csv tuviese mas columnas.
             */
            throw new AssertionError("FAIL: La tabla tiene menos filas que el CSV, analizar el problema...");
        } else if(tableHasEqualRecordsThanCsv) {
            switch (scn) {
                case "ModificarClienteContratoSinEnvioERP":
                case "ModificarEmpresaSinEnvioERP":
                    System.out.println("PASS: No se ha registrado ninguna traza nueva en la tabla external_misc_envios...");
                    break;
                default:
                    throw new AssertionError("FAIL: No se han detectado nuevas trazas en EXTERNAL_MISC_ENVIO...");
            }
        }

    }

}
