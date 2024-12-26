package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionCentrosDeTrabajoTask extends BasePage {

    private GestionEmpresasClienteServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType commonServiceType;
    private GestionEmpresasClienteServiceSelect commonServiceSelect;
    private GestionEmpresasClienteServiceValidate commonServiceValidate;

    private GestionCentrosDeTrabajoServiceSelect serviceSelect;
    private GestionCentrosDeTrabajoServiceClick serviceClick;
    private GestionCentrosDeTrabajoServiceType serviceType;
    private GestionCentrosDeTrabajoServiceValidate serviceValidate;
    private GestionCentrosDeTrabajoServiceDataBaseProcedure serviceDataBaseProcedure;

    private CommonService commonService;

    public GestionCentrosDeTrabajoTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new GestionEmpresasClienteServiceClick(driver);
        commonServiceType = new GestionEmpresasClienteServiceType(driver);
        commonServiceSelect = new GestionEmpresasClienteServiceSelect(driver);
        commonServiceValidate = new GestionEmpresasClienteServiceValidate(driver);

        serviceClick = new GestionCentrosDeTrabajoServiceClick(driver);
        serviceType = new GestionCentrosDeTrabajoServiceType(driver);
        serviceSelect = new GestionCentrosDeTrabajoServiceSelect(driver);
        serviceValidate = new GestionCentrosDeTrabajoServiceValidate(driver);
        serviceDataBaseProcedure = new GestionCentrosDeTrabajoServiceDataBaseProcedure(driver);
    }

    public void seleccionarClienteContrato(String scn, SystemPages page, String file) throws Exception {
        serviceSelect.selectClienteContrato(scn,  page, null, file, 1,true,true, true);
    }

    public void hacerClickAltaCentroDeTrabajo(String scn) throws Exception {
        switch (scn) { //@scenarios
            case "AltaCentroDeTrabajoEnvioOK":
                serviceClick.clickBtnAltaCentroDeTrabajo(true, true);
                break;
            case "AltaCentroDeTrabajoEnvioKO":
                serviceClick.clickBtnAltaCentroDeTrabajo(true, false);
                compruebaSiSaleAlgunMensaje();
                break;
        }
    }

    public void modificaAlgunosCampos(String scn, SystemPages page, String file) throws Exception {

        //campos de cliente contrato
        { //@bloque : unicamente para uso en desarrollo para ocultar el grupo de campos de este metodo
            commonServiceClick.clickTab(PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS.getValue());

            try {
                serviceValidate.validateNombreEmpresa(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceType.typeNombreEmpresa(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateTipoVia(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectTipoVia(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateNombreDireccion(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 2, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceType.typeNombreDireccion(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 2, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateLocalidad(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeLocalidad(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateProvincia(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceSelect.selectProvincia(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, false);
                    if(commonService.checkMsgInfoProvinceChange()) {
                        commonServiceSelect.selectProvincia(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                    }
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateCP(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeCP(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateMedioDeCaptacion(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectMedioDeCaptacion(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateTelefono(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeTelefono(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateConvColectivoEmpresaUsuaria(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO: crear metodo para este campo tipo LOV
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateBoe(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO: crear metodo para este campo tipo LOV
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateClausuladoDelContratoLaboral(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceSelect.selectClausuladoDelContratoLaboral(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateClausuladoDelCPD(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceSelect.selectClausuladoDelCPD(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            commonServiceClick.clickTab(PanelTitle.TAB_DATOSECONOMICOS.getValue());

            try {
                serviceValidate.validateDiasFijosDePago(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceType.typeDiasFijosDePago(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateTipo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceSelect.selectTipo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateProvincia(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceSelect.selectProvincia(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateLocalidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeLocalidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateCP(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeCP(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            commonServiceClick.clickTab(PanelTitle.TAB_RETRATOROBOT.getValue());

            try {
                commonServiceValidate.validateVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                commonServiceValidate.validateNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

        } //@bloque fin
    }


    public void guardarCSVconDatosActualesDeCentroDeTrabajo(String scn, SystemPages page, String file) throws Exception{
        serviceDataBaseProcedure.guardarCSVconDatosActualesDeCentroDeTrabajo(scn,page,file);
    }

    public void confirmarDespuesDeGuardarSiHayNuevasEntidadesCentroDeTrabajo(String scn, SystemPages page, String file, String oficina) throws Exception{
        serviceDataBaseProcedure.confirmarDespuesDeGuardarSiHayNuevasEntidadesCentroDeTrabajo(scn,page,file,oficina);
    }

    public void verificaElMensajeModificacionKO() throws Exception {
//        commonService.waitMessageIsVisible(
//                MessageModal.INFORMACION,
//                "Los datos del centro han sido almacenados correctamente y se ha realizado el envío al ERP",
//                120
//        ); //Si activo este metodo, hay que asegurarse de que en el paso anterior usar el guardar con waitforspinner false
        String message = "Error en el envio al ERP del centro";
        commonServiceValidate.validateModalTexto(ModalTitle.ERROR, message);
        commonServiceClick.clickBtnCerrarModalInformacion();
    }

    public void verificaElMensajeModificacionOK() throws Exception {
//        commonService.waitMessageIsVisible(
//                MessageModal.INFORMACION,
//                "Los datos del centro han sido almacenados correctamente y se ha realizado el envío al ERP",
//                120
//        ); //Si activo este metodo, hay que asegurarse de que en el paso anterior usar el guardar con waitforspinner false
        String message = "Los datos del centro han sido almacenados correctamente y se ha realizado el envío al ERP";
        commonServiceValidate.validateModalTexto(ModalTitle.INFORMACION, message);
        commonServiceClick.clickBtnCerrarModalInformacion();
    }

    public void verificaElMensajeAltaOK() throws Exception {
//        commonService.waitMessageIsVisible(
//                MessageModal.INFORMACION,
//                "Los datos del centro han sido almacenados correctamente y se ha realizado el envío al ERP",
//                120
//        ); //Si activo este metodo, hay que asegurarse de que en el paso anterior usar el guardar con waitforspinner false
        String message = "Los datos del centro han sido almacenados correctamente y se ha realizado el envío al ERP";
        commonServiceValidate.validateModalTexto(ModalTitle.INFORMACION, message);
        commonServiceClick.clickBtnCerrarModalInformacion();
    }

    public void verificaElMensajeAltaKO() throws Exception {
//        commonService.waitMessageIsVisible(
//                MessageModal.ERROR,
//                "Error en el envio al ERP del centro",
//                120
//        );
        String message = "Error en el envio al ERP del centro";
        commonServiceValidate.validateModalTexto(ModalTitle.ERROR, message);
        commonServiceClick.clickBtnCerrarModalInformacion();
    }

    //TODO este metodo puede ser compartido, por lo que ver de pasarlo al task commun.
    public void compruebaSiSaleAlgunMensaje() throws Exception {
        try {
            commonService.checkMsgInfoIsNotShown();
        } catch (AssertionError e) {
            System.out.println("WARNING: Se ha mostrado un mensaje de información");
            commonServiceClick.clickBtnCerrarModalInformacion();
            return;
        }
        commonService.checkMsgErrorIsNotShown(true);
    }

    public void buscarEmpresa(String scn, SystemPages page, String file) throws Exception {
        switch (page) { //@paginas
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                //TODO pendiente a ajustar para pantalla consulta
                serviceClick.clickBtnLupa();
                commonServiceValidate.validateModalSeleccioneEmpresaEsVisible();
                //TODO pendiente ajustar para quitar dependencia de GestionEmpresaClienteData
                //commonServiceType.typeRazonSocialDialogSeleccioneEmpresa(scn, page, file, true, true, true); //TODO: CAMPO OPCIONAL, lo marcamos true de momento para hacer pruebas, cambiar mas adelante
                commonServiceClick.clickBtnBuscarEmpresaModalSeleccioneEmpresa();
                break;
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                serviceType.typeRazonSocial(scn, page, file, 1, true, true, true);
                commonServiceClick.clickBtnBuscar();
        }
    }

    public void seleccionarPrimerRecordDeLaTabla(String scn,SystemPages page, String file) throws Exception {
        commonService.clickFirstValidRowResultOnTable(scn, page, null, file+".second", 1,false);
    }

    /** clicks **/

    public void clickBtnBuscar() throws Exception{
        commonServiceClick.clickBtnBuscar();
    }

    public void clickModificarCentroDeTrabajo() throws Exception {
        serviceClick.clickBtnModificarCentrodeTrabajo();
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }
}
