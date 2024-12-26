package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.WebDriver;

public class GestionClientesContratoTask extends BasePage {

    private GestionClientesContratoServiceClick serviceClick;
    private GestionClientesContratoServiceType serviceType;
    private GestionClientesContratoServiceSelect serviceSelect;
    private GestionClientesContratoServiceValidate serviceValidate;

    private GestionEmpresasClienteServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType commonServiceType;
    private GestionEmpresasClienteServiceSelect commonServiceSelect;
    private GestionEmpresasClienteServiceValidate commonServiceValidate;

    private CommonService commonService;
    private CommonServiceClick newCommonServiceClick;

    public GestionClientesContratoTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        newCommonServiceClick = new CommonServiceClick(driver);

        //TODO: deprecar antiguos common services de Gestion de empresas
        commonServiceClick = new GestionEmpresasClienteServiceClick(driver);
        commonServiceType = new GestionEmpresasClienteServiceType(driver);
        commonServiceSelect = new GestionEmpresasClienteServiceSelect(driver);
        commonServiceValidate = new GestionEmpresasClienteServiceValidate(driver);

        serviceClick = new GestionClientesContratoServiceClick(driver);
        serviceType = new GestionClientesContratoServiceType(driver);
        serviceSelect = new GestionClientesContratoServiceSelect(driver);
        serviceValidate = new GestionClientesContratoServiceValidate(driver);

    }

    // rellena razon social y click en boton buscar empresa
    public void buscarEmpresa(String scn, SystemPages page, String file) throws Exception {
            serviceType.typeRazonSocial(
                    scn,
                    page,
                    null,
                    file,
                    1,
                    true,
                    true,
                    true
            );

            commonServiceClick.clickBtnBuscar();
    }

    // seleccionar primer resultado de la tabla
    public void seleccionarHacerClickEnPrimerResultado(String scn, SystemPages page, String file) throws Exception {
        switch (page) { //@paginas
            case GESTION_CENTROS_DE_TRABAJO__ALTA:
                commonService.clickFirstValidRowResultOnTable(scn, page, null, file, 1, false);
                commonService.waitUntilSpinnerIsNotDisplayed();
                break;
            case GESTION_CENTROS_DE_TRABAJO__CONSULTA:
                commonService.clickFirstValidRowResultOnTable(scn, page, null, file, 1, true);
                commonServiceClick.clickBtnAceptarModalSeleccioneEmpresa();
                break;
            default:
                commonService.clickFirstValidRowResultOnTable(scn, page, null, file, 1, false);
        }

    }


    // click botones
    public void hacerClickAltaContrato() throws Exception {
        serviceClick.clickBtnAltaClienteContrato();
    }

    public void hacerClickModificacion() throws Exception {
        serviceClick.clickBtnModificacion();
    }


    // validacion campos

    /**
     * Dado que el objetivo de este metodo es probar que algun dato requerido no esté relleno,
     * Hay que poner en el archivo de datos el valor de alguno de los campos siguientes vacios
     * o en un valor equivalente como `- Seleccione XXXX -` en el campo select
     *
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    public void validarCampos(String scn, SystemPages page, String file) throws Exception {

        //TODO: Borrar cuando compruebe que el nuevo funciona bien
//        commonServiceClick.clickTab(PanelTitle.OTROSDATOSIDENTIFICATIVOS.getValue());
        newCommonServiceClick.clickTab(PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS.getValue());

        serviceValidate.validateEjecutivoDeCuenta(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
        serviceValidate.validateMedioDeCapt(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
        serviceValidate.validateTelefono(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
        serviceValidate.validateClausuladoDelContratoLaboral(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
        serviceValidate.validateClausuladoDelCPD(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
        serviceValidate.validateObservaciones(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, false);

        //TODO: Borrar cuando compruebe que el nuevo funciona bien
//        commonServiceClick.clickTab(PanelTitle.DATOSECONOMICOS.getValue());
        newCommonServiceClick.clickTab(PanelTitle.TAB_DATOSECONOMICOS.getValue());
        //TODO @REFACTOR @FIX @PRE
//        serviceValidate.validateEntidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateSucursal(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateDC(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateNCuenta(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateIBANPais(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateIBANDC(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateIBANExtranjero(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
//        serviceValidate.validateTipo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
//        serviceValidate.validateNombreDireccionDeFactura(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
//        serviceValidate.validateLocalidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
//        serviceValidate.validateProvincia(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
//        serviceValidate.validateCP(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
//        serviceValidate.validateDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);

        //TODO: Borrar cuando compruebe que el nuevo funciona bien
//        commonServiceClick.clickTab(PanelTitle.RETRATOROBOT.getValue());
        newCommonServiceClick.clickTab(PanelTitle.TAB_RETRATOROBOT.getValue());
        //TODO @REFACTOR @FIX @PRE
//        serviceValidate.validateVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
//        serviceValidate.validateNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
    }


    // verificacion de mensajes
    public void verificaElMensajeDeAtencion() throws Exception {
        commonServiceValidate.validateModalTexto(ModalTitle.ATENCION, "Alguno de los campos requeridos no ha sido informado");
    }

    public void verificaElMensajeAltaKO() throws Exception {
        //TODO: pasar este metodo a commonTask.waitGrowlMessage directament en el step
        commonService.waitMessageIsVisible(
                ModalTitle.ERROR,
                "Error en el envio al ERP del cliente-contrato",
                120
        );
    }

    public void verificaElMensajeAltaOK() throws Exception {
        commonService.waitMessageIsVisible(
                ModalTitle.INFORMACION,
                "Los datos del cliente contrato han sido almacenados correctamente",
                120
        );
    }

    public void verificaElMensajeModificacionKO() throws Exception {
        commonService.waitMessageIsVisible(
                ModalTitle.ERROR,
                "Error en el envio al ERP del cliente-contrato",
                120
        );
    }

    public void verificaElMensajeModificacionOK() throws Exception {
        commonService.waitMessageIsVisible(
                ModalTitle.INFORMACION,
                //"Los datos del cliente contrato han sido almacenados correctamente y se ha realizado el envío al ERP",
                "Los datos del cliente contrato han sido almacenados correctamente",
                120
        );
    }

    //TODO: PENDING_DELETE, luego de hablarlo con raquel el requisito al parecer ya no hace falta para clientes contrato y centros de trabajo
    //  Pendiente de borrar el metodo siguiente
    public void verificaElMensajeDatosGuardadoPeroNoEnvioERP() throws Exception {
        commonService.waitMessageIsVisible(
                ModalTitle.INFORMACION,
                "Los datos del cliente contrato han sido almacenados correctamente, pero no se realiza envío al ERP al no haber cambios en los campos necesarios",
                120
        );
        commonService.waitUntilSpinnerIsNotDisplayed();
    }


    // valida si el campo ya tiene el valor esperado, si no, lo modifica
    public void modificaAlgunosCampos(String scn, SystemPages page, String file) throws Exception {

        //campos de cliente contrato
        { //@bloque : unicamente para uso en desarrollo para ocultar el grupo de campos de este metodo
            commonService.waitUntilSpinnerIsNotDisplayed();
            commonServiceClick.clickTab(PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS.getValue());

            try {
                serviceValidate.validateEjecutivoDeCuenta(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectEjecutivoDeCuenta(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateMedioDeCapt(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectMedioDeCapt(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateConvenio(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO: ver como rellenar convenio
                    System.out.println("TODO!!\n");
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateBoe(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO: ver como rellenar boe
                    System.out.println("TODO!!\n");
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateTelefono(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
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
                serviceValidate.validateClausuladoDelContratoLaboral(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectClausuradoDelContratoLaboral(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateClausuladoDelCPD(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceSelect.selectClausuradoDelCPD(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                serviceValidate.validateObservaciones(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    serviceType.typeObservaciones(scn, page, PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, file + "." + PanelTitle.TAB_OTROSDATOSIDENTIFICATIVOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            commonServiceClick.clickTab(PanelTitle.TAB_DATOSECONOMICOS.getValue());

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateEntidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceSelect.selectEntidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateSucursal(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceSelect.selectSucursal(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateIBANDC(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceType.typeIBANdc(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateIBANPais(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceType.typeIBANPais(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateIBANExtranjero(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceType.typeIBANextranjero(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateTipo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
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
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateNombreDireccionDeFactura(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    commonServiceType.typeNombreDireccionDeFactura(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateLocalidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
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
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateProvincia(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
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
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateCP(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, true);
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
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    commonServiceType.typeDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file + "." + PanelTitle.TAB_DATOSECONOMICOS, 1, false, false, false);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            commonServiceClick.clickTab(PanelTitle.TAB_RETRATOROBOT.getValue());

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceSelect.selectVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }

            try {
                //TODO @REFACTOR @FIX @PRE
//                serviceValidate.validateNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true);
            } catch (AssertionError e) {
                if (e.getMessage().contains("FAIL: El campo no tiene el valor esperado")) {
                    //TODO @REFACTOR @FIX @PRE
//                    serviceSelect.selectNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file + "." + PanelTitle.TAB_RETRATOROBOT, 1, true, true, true);
                } else {
                    throw new AssertionError(e);
                }
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }



    // trabajando con la tabla de client_cont (DB) y el csv asociado
    public void escribirCSVconDatosActualesDeClienteContratoAntesDeGuardar(String scn, SystemPages page, String file, String oficina) throws Exception {
        serviceValidate.escribirAntesDeGuardarCSVconDatosActualesDeClienteContrato(scn, page, file, oficina);
    }

    public void confirmarSiHayNuevasEntidadesClienteContratoDespuesDeGuardar(String scn, SystemPages page, String file, String oficina) throws Exception {
        serviceValidate.confirmarDespuesDeGuardarSiHayNuevasEntidadesClienteContrato(scn, page, file, oficina);
    }

    public void confirmarCambiosGuardadosEnTablaClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        serviceValidate.confirmarDespuesDeGuardarLaModificacionDelClienteContrato(scn, page, file, oficina);
    }

    public void confirmarDespuesDeGuardarQueNoHaSidoModificadoElClienteContrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        serviceValidate.confirmarDespuesDeGuardarQueNoHaSidoModificadoElClienteContrato(scn, page, file, oficina);
    }


    // trabajando con la base de datos de external_misc_envio (DB) y el csv asociado
    public void escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(String scn, SystemPages page, String file) throws Exception {
        commonServiceValidate.escribirCSVconDatosActualesDeExternalMiscEnvioAntesDeGuardar(scn, page, file);
    }

    public void confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(String scn, SystemPages page, String file) throws Exception {
        commonServiceValidate.confirmarSihayNuevosRegistrosEnExternalMiscEnvioDespuesDeGuardar(scn, page, file);
    }


}
