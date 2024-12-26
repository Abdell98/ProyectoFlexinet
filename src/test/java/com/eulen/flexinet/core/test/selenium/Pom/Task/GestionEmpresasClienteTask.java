package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;


public class GestionEmpresasClienteTask extends BasePage {

    private GestionEmpresasClienteServiceClick serviceClick;
    private GestionEmpresasClienteServiceType serviceType;
    private GestionEmpresasClienteServiceSelect serviceSelect;
    private GestionEmpresasClienteServiceCheckbox serviceCheckbox;
    private GestionEmpresasClienteServiceLookupField serviceLookupField;
    private GestionEmpresasClienteServiceValidate serviceValidate;
    private GestionEmpresasClienteServiceDatePicker serviceDatePicker;
    private GestionEmpresasClienteServiceDataBaseProcedure serviceDataBaseProcedure;
    private CommonService commonService;
    private CommonServiceClick commonServiceClick;
    private CommonServiceValidate commonServiceValidate;

    public GestionEmpresasClienteTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);

        serviceClick = new GestionEmpresasClienteServiceClick(driver);
        serviceType = new GestionEmpresasClienteServiceType(driver);
        serviceSelect = new GestionEmpresasClienteServiceSelect(driver);
        serviceCheckbox = new GestionEmpresasClienteServiceCheckbox(driver);
        serviceLookupField = new GestionEmpresasClienteServiceLookupField(driver);
        serviceValidate = new GestionEmpresasClienteServiceValidate(driver);
        serviceDatePicker = new GestionEmpresasClienteServiceDatePicker(driver);
        serviceDataBaseProcedure = new GestionEmpresasClienteServiceDataBaseProcedure(driver);
    }

    // ALTA
    public void buscarEmpresaPorBotonObtenerDatos(String scn, SystemPages page, String file) throws Exception {
        Thread.sleep(2000);
        serviceLookupField.lkpCIF( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, true, true );
    }

    // ALTA
    public void clickBtnEnviarARiesgosYes() throws Exception {
        serviceClick.clickBtnYesModalEnviarARiesgos();
    }

    public void clickBtnEnviarARiesgosNo() throws Exception {
        serviceClick.clickBtnNoModalEnviarARiesgos();
    }

    // ALTA
    public void validarQueSeMuestraElMensajeDeInformacion(String message) throws Exception {
        serviceValidate.validateModalTexto(ModalTitle.INFORMACION, message);
        serviceClick.clickBtnCerrarModalInformacion();
    }

    /** GESTION EMPRESA CLIENTE CONSULTA **/

    public void confirmarResultadoConsulta(String scn, SystemPages page, String file) throws Exception {
        commonService.clickFirstValidRowResultOnTable( scn,  page, null, file, 1, false);
    }


    public void formularioConsultaEmpresa(String scn, SystemPages page, String file) throws Exception {

        serviceType.typeRazonSocialEmpresaNew(scn,page,null,file,1,false,true, true);
        serviceType.typeNifEmpresaNew(scn,page,null,file,1,false,true, true);
        serviceSelect.selectVentas(scn, page, null, file, 1, false, false, false);
        serviceSelect.selectProvincia( scn, page, null, file, 1, false, false, false );
        serviceSelect.selectRangoDeEmpleadosNew( scn, page, null, file, 1, false, false, false );
        serviceType.typeCodigoPostalNew( scn, page, null, file, 1, false, false, false );
        serviceCheckbox.checkLaEmpresaProvieneDeMarketing( scn, page, null, file, 1, false, false, false );
        //TODO: types rango de fechas de importacion, estos campos son visibles si se marca checkLaEmpresaProvieneDeMarketing
        {
            serviceDatePicker.pickDateDesde( scn, page, null, file, 1, false, false, false );
            serviceDatePicker.pickDateHasta( scn, page, null, file, 1, false, false, false );
        }
        serviceClick.clickRadRealizarLaBusquedaANivelNacionalSi( scn, page, null, file, 1, false, false, false );
        serviceClick.clickRadRealizarLaBusquedaANivelNacionalNo( scn, page, null, file, 1, false, false, false );
    }

    public void tablaConsultaEmpresasQbe(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNombreEmpresa(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeNifEmpresa(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeDireccion(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeProvincia(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeCp(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeNombreContacto(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeCargoContacto(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeTelefonoContacto(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeCNAE(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeVentas(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeRangoEmpleados(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeResponsable(scn,page,null,file,1,false,false, false);
        serviceType.typeQbeNombreOficina(scn,page,null,file,1,false,false, false);
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_NOMBREOFICINA,1);
    }


    public void validateMessageInformacionDatosGuardadosNoEnvioERP() throws Exception {
        serviceValidate.validateModalTexto(ModalTitle.INFORMACION,"Los datos de la empresa han sido almacenados correctamente, pero no se realiza envío al ERP al no haber cambios en los campos necesarios");
        commonService.waitUntilSpinnerIsNotDisplayed();
    }

    public void confirmarCambiosGuardadosEnTablaEmpresa(String scn, SystemPages page, String file) throws Exception {
        serviceValidate.confirmarCambiosGuardadosEnTablaEmpresa(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file);
    }

    public void validateModalTexto(String scn, SystemPages page, String file) throws Exception {
        //commonService.getJsonFileData(scn,page,file);
        jsonFileNew(file);
        String data = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                data = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteAlta().
                        getTabDatosRiesgos().
                        getLkp_cif();
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                data = datosGestionDeEmpresaCliente.
                        getGestionDeEmpresaClienteModificar().
                        getTabDatosRiesgos().
                        getLkp_cif();
                break;

        }
        //TODO: borrar lo siguiente si lo anterior funciona
        //String data = gestionEmpresaClienteData.getNIFempresa();
        switch (scn) { //@scenarios
            case "ModificarEmpresaEnvioKO":
                serviceValidate.validateModalTexto(ModalTitle.ERROR, "Error en el envio al ERP de la empresa "+data+". Error Cliente: El cliente no se encuentra registrado en el sistema");
                break;
            case "ModificarEmpresaEnvioOK":
                serviceValidate.validateModalTexto(ModalTitle.INFORMACION, "Los datos de la empresa han sido almacenados correctamente y se ha realizado el envío al ERP");
        }
        commonService.waitUntilSpinnerIsNotDisplayed();
    }

    public void validaYRellenaTabs(String scn, SystemPages page, String file) throws Exception {
        tabDatosRiegos(scn,page,file, false, false);
        tabIdentificativos(scn,page,file, false, false);
        tabDatosEconomicos(scn,page,file, false, false);
        tabCategoriaSeguridadSocial(scn,page,file, false, false);
        tabRetratoRobot(scn,page,file, false, false);
    }

    public void validateTabDatosRiegosCamposNoEditables(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_DATOSRIESGOS.getValue());
        {
            serviceValidate.validateEstado( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false);
            serviceType.typeRazonSocial( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeRazonSocialFactura( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            try {
                serviceType.typeMargenBruto(scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown);
            } catch (JavascriptException e) {
                Assert.assertTrue("FAIL: error deconocido al interactuar con el campo", e.getMessage().contains("Element is not currently interactable and may not be manipulated"));
                System.out.println("PASS: El campo typeMargenBruto no es editable");
            }

            try {
                serviceType.typeLimiteRiesgo( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            } catch (JavascriptException e) {
                Assert.assertTrue("FAIL: error deconocido al interactuar con el campo", e.getMessage().contains("Element is not currently interactable and may not be manipulated"));
                System.out.println("PASS: El campo typeLimiteRiesgo no es editable");
            }

            try {
                serviceSelect.selectMedioDePago(scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown);
            } catch (JavascriptException e) {
                Assert.assertTrue("FAIL: error deconocido al interactuar con el campo", e.getMessage().contains("Element is not currently interactable and may not be manipulated"));
                System.out.println("PASS: El campo selectMedioDePago no es editable");
            }

            try {
                serviceSelect.selectFormaDePago(scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown);
            } catch (JavascriptException e) {
                Assert.assertTrue("FAIL: error deconocido al interactuar con el campo", e.getMessage().contains("Element is not currently interactable and may not be manipulated"));
                System.out.println("PASS: El campo selectFormaDePago no es editable");
            }
        }
    }


    public void tabDatosRiegos(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_DATOSRIESGOS.getValue());
        {
            serviceValidate.validateEstado( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false);
            serviceType.typeRazonSocial( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeRazonSocialFactura( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeMargenBruto( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeLimiteRiesgo( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectMedioDePago( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectFormaDePago( scn, page, PanelTitle.TAB_DATOSRIESGOS, file, 1, false, waitForSpinner, checkNoMessageShown );
        }
    }

    public void tabIdentificativos(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_IDENTIFICATIVOS.getValue());
        {
            serviceType.typeSiglas( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkClientesNacional( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkFacturaGlobalizada( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkEnvioCPD( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkEnvioFacturaDigital( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkRappel_CheckBox( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeRappel_Input( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectTipo( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDireccion( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeLocalidad( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectProvincia( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeCP( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectTipo( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDireccion( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeLocalidad( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectProvincia( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeCP( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceLookupField.lkpConColectivoEmpresaUsuaria( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeBOE( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectMedioDeCapt( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeOficinaOrigenDelContrato( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectRespDeCuenta( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeTelefono( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typePaginaWeb( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeObservaciones( scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false, waitForSpinner, checkNoMessageShown );
        }
    }

    public void tabDatosEconomicos(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_DATOSECONOMICOS.getValue());
        {
            serviceSelect.selectImpuestosTipoPorcentaje( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDiasFijosDePago( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeNumeroDeCliente( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeBanco( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectEntidad( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectSucursal( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDC( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeNCuenta( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeIBANPais( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeIBANDC( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeIBANExtranjero( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkPersonalizable( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectTipo( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeNombre( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeLocalidad( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectProvincia( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeCP( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDestinatario( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectClausuladoDelContratoLaboral( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectClausuladoDelCPD( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceCheckbox.checkFirmanteCPDPRLPersonalizable( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
        }

        boolean addNewContact = false;
        String jsonObjectPath = null;
        switch (page) {
            case GESTION_EMPRESAS_CLIENTE__ALTA:
                addNewContact = new JsonCommand().convertCommandBtnClickToBoolean(datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteAlta().getTabDatosEconomicos().getBtn_anadirContacto());
                jsonObjectPath = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_DATOSECONOMICOS->TABLE";
                break;
            case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                addNewContact = new JsonCommand().convertCommandBtnClickToBoolean(datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteModificar().getTabDatosEconomicos().getBtn_anadirContacto());
                jsonObjectPath = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_DATOSECONOMICOS->TABLE";
        }

        if(addNewContact) {
            serviceType.typeNIF( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeNombre( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 2, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeApellidos( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeCargo( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeTelf1( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeTelf2( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeEmail( scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false, waitForSpinner, checkNoMessageShown );
            commonServiceClick.clickBtn( PanelTitle.TAB_DATOSECONOMICOS, null, FieldByTagLabelText.BTN_ANADIRCONTACTO, 1, true, true );
            //TODO: hacer qbe en tabla contactos
            commonService.clickFirstValidRowResultOnTableNew(scn,page,PanelTitle.TAB_DATOSECONOMICOS,file,jsonObjectPath,1,false);
        } else {
            System.out.println("WARNING: El campo `btn_anadirContacto` está vacio, saltamos el completado de los datos de contacto....");
        }
    }

    public void tabCategoriaSeguridadSocial(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL.getValue());
        {
            boolean addNewCategoria = false;
            String jsonObjectPath = null;
            switch (page) {
                case GESTION_EMPRESAS_CLIENTE__ALTA:
                    addNewCategoria = new JsonCommand().convertCommandBtnClickToBoolean(datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteAlta().getTabCategoriaSeguridadSocial().getBtn_anadirCategoria());
                    jsonObjectPath = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__ALTA->TAB_CATEGORIASEGURIDADSOCIAL->TABLE";
                    break;
                case GESTION_EMPRESAS_CLIENTE__MODIFICAR:
                    addNewCategoria = new JsonCommand().convertCommandBtnClickToBoolean(datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteModificar().getTabCategoriaSeguridadSocial().getBtn_anadirCategoria());
                    jsonObjectPath = "TestDatosGestionDeEmpresaCliente->GESTION_EMPRESAS_CLIENTE__MODIFICAR->TAB_CATEGORIASEGURIDADSOCIAL->TABLE";
            }

            if(addNewCategoria) {
                serviceLookupField.lkpCategoriaLaboral( scn, page, PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL, file, 1, false, waitForSpinner, checkNoMessageShown );
                serviceLookupField.lkpCategoriaProfesional( scn, page, PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL, file, 1, false, waitForSpinner, checkNoMessageShown );
                serviceSelect.selectRegimenDeLaSegSocial( scn, page, PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL, file, 1, false, waitForSpinner, checkNoMessageShown );
                serviceCheckbox.checkPRLPersonalizable( scn, page, PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL, file, 1, false, waitForSpinner, true );
                //TODO falta añadir campos para rellenar ficha PRL y probar el clic en la tabla, de momento no mandar do_click porque salta un aviso
                commonServiceClick.clickBtn( PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL, null, FieldByTagLabelText.BTN_ANADIRCATEGORIA, 1, true, true );
                //TODO falta hace qbe de la tabla de categoria
                commonService.clickFirstValidRowResultOnTableNew(scn,page,PanelTitle.TAB_CATEGORIASEGURIDADSOCIAL,file,jsonObjectPath,1,false);
            } else {
                System.out.println("WARNING: el campo `btn_anadirCategoria` esta vacio por lo que no se rellenará la categoria");
            }
        }
    }

    public void tabRetratoRobot(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_RETRATOROBOT.getValue());
        {
            serviceLookupField.lkpActividad( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceLookupField.lkpCNAE( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceLookupField.lkpSIC( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceSelect.selectVentas( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceSelect.selectNEmpleados( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorTiposDeHoras( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorCentrosDeTrabajo( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorCategoriaProfesional( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkMostrarPrecioUnidad( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorColaborador( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkColaboradorConcepto( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkMostrarMinFinicioMaxFFinPartes( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorDuracionDelContrato5Dias5Dias( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorNumeroDeColaboradores( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceType.typeNumeroMaximoDeColaboradoresEnFactura( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkPorImporteGlobal( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceType.typeImporteMaximoPorFacturaImporteCorrespondienteIncluido( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
            serviceCheckbox.checkElTipoDeFacturacionEsPersonalizable( scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false, waitForSpinner, true );
        }
    }

    public void validarTabDatosRiesgos(String scn, SystemPages page, String file) throws Exception {
        serviceClick.clickTab("Datos Riesgos");
        serviceValidate.validateCIF(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateEstado(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateRazonSocial(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateRazonSocialFactura(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateMargenBruto(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateLimiteRiesgo(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateMedioDePago(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        serviceValidate.validateFormaDePago(scn, page, PanelTitle.TAB_DATOSRIESGOS,file, 1, false);
        //TODO: ver de añadir `Fecha Inicio Vigencia:`
        //TODO: ver de añadir `Estado:`
        //TODO: ver de añadir `Importe Asegurado:`
    }

    public void validarTabIdentificativos(String scn, SystemPages page, String file) throws Exception {
        serviceClick.clickTab("Identificativos");
        serviceValidate.validateSiglas(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateClientesNacional(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateChkFacturaGlobalizada(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateEnvioCpd(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateEnvioFacturaDigital(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateRappelCheckBox(scn, page, PanelTitle.TAB_IDENTIFICATIVOS,file, 1, false);
        serviceValidate.validateRappelInput(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateTipo(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateTipo(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false);
        serviceValidate.validateDireccion(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateDireccion(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false);
        serviceValidate.validateLocalidad(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateLocalidad(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false);
        serviceValidate.validateProvincia(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateProvincia(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false);
        serviceValidate.validateCP(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateCP(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 2, false);
        serviceValidate.validateConvColectivoEmpresaUsuaria(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateBoe(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateMedioDeCapt(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateOficinaOrigenDelContrato1(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateOficinaOrigenDelContrato2(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateRespDeCuenta(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateTelefono(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validatePaginaWeb(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
        serviceValidate.validateObservaciones(scn, page, PanelTitle.TAB_IDENTIFICATIVOS, file, 1, false);
    }

    public void validarTabDatosEconomicos(String scn, SystemPages page, String file) throws Exception {
        serviceClick.clickTab("Datos Económicos");
        serviceValidate.validateNumeroCliente(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateBanco(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateEntidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateSucursal(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateDC(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateNCuenta(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateIBANPais(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateIBANDC(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateIBANExtranjero(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validatePersonalizable(scn, page, PanelTitle.TAB_DATOSECONOMICOS,file, 1, false);
        serviceValidate.validateTipo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateNombre(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateLocalidad(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateProvincia(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateCP(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateDestinatario(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateClausuladoDelContratoLaboral(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateClausuladoDelCPD(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateNIF(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateNombre(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 2, false);
        serviceValidate.validateApellido1(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateApellido2(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateCargo(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateTelf1(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateTelf2(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateEmail(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
        serviceValidate.validateFirmanteCPDPRLPersonalizable(scn, page, PanelTitle.TAB_DATOSECONOMICOS, file, 1, false);
    }

    public void validarTabCategoriaSeguridadSocial(String scn, SystemPages page, String file) throws Exception {
        serviceClick.clickTab("Categoría / Seguridad Social");
    }

    public void validarTabRetratoRobot(String scn, SystemPages page, String file) throws Exception {
        serviceClick.clickTab("Retrato Robot");
        serviceValidate.validateLkpActividad(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateLkpCNAE(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateLkpSIC(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateVentas(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateNEmpleados(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorTiposDeHoras(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkFacturaGlobalizada(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false); //TODO @PRE en pre no existe este check en retrato robot
        serviceValidate.validateChkPorCentrosDeTrabajo(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorCategoriaProfesional(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkMostrarPrecioUnidad(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorColaborador(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkColaboradorConcepto(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkMostrarMinFInicioMaxFFinPartes(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorDuracionDelContrato5Dias5Dias(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorDepartamentoAlQueSeIncorporaraElColaboradorEnElCentroDeTrabajo(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorNumeroDeColaboradores(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateNumeroMaximoDeColaboradoresEnFactura(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateChkPorImporteGlobal(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
        serviceValidate.validateImporteMaximoPorFacturaImporteCorrespondienteIncluido(scn, page, PanelTitle.TAB_RETRATOROBOT, file, 1, false);
    }

    /**
     * Valida en la tabla EMP_TIPOFA que exista la empresa
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    public void validarQueryEMP_TIPO(String scn, SystemPages page, String file) throws Exception {
        serviceDataBaseProcedure.validarEmpresaEnEMPTIPOFA(scn, page, file);
    }
}