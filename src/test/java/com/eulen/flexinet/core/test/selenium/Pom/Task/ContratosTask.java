package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ContratosTask extends BasePage {

    private ContratosServiceClick serviceClick;
    private ContratosServiceType serviceType;
    private ContratosServiceCheckbox serviceCheckbox;
    private ContratosServiceDatePicker serviceDatePicker;
    private ContratosServiceSelect serviceSelect;
    private ContratosServiceLookupField serviceLookupField;
    private ContratosServiceValidate serviceValidation;
    private ContratosServiceDataBaseProcedure serviceDataBaseProcedure;
    private CommonServiceClick commonServiceClick;
    private CommonService commonService;
    private CommonServiceValidate commonServiceValidate;

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;

    public ContratosTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        serviceClick = new ContratosServiceClick(driver);
        serviceType = new ContratosServiceType(driver);
        serviceCheckbox = new ContratosServiceCheckbox(driver);
        serviceDatePicker = new ContratosServiceDatePicker(driver);
        serviceLookupField = new ContratosServiceLookupField((driver));
        serviceValidation = new ContratosServiceValidate(driver);
        serviceDataBaseProcedure = new ContratosServiceDataBaseProcedure(driver);
        serviceSelect = new ContratosServiceSelect(driver);
        commonServiceValidate = new CommonServiceValidate(driver);

        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
    }

    public void completeContratosConsultaEmpresaColaboradorForm(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeEmpresa(scn, page, null, file, 1, false, false, false);
        serviceType.typeNCliente(scn, page, null, file, 1, false, false, false);
    }

    /**
     * Obteniene el pedido guardado en el json de PEDIDOS__ALTA y lo usa para buscar el contrato en base de datos
     * @param scn
     * @param page
     * @param file
     * @throws Exception
     */
    public void consultarIdDelContratoDelIdDePedidoGenerado(String scn, SystemPages page, String file) throws Exception {
        serviceDataBaseProcedure.consultandoID_CONTRATODePedidosAlta(scn, page, file);
    }


    public void actualizarCampoFTrsFactDelContratoTraspasado(String scn, SystemPages page, String file) throws Exception{
        serviceDataBaseProcedure.actualizarCampoFTrsFactContratoTraspasado(file, scn);
    }

    public void completeContratosConsultaColaboradorSearchForm(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNombre(scn, page, null, file, 1, false, false, false);
        serviceType.typePrimerApellido(scn, page, null, file, 1, false, false, false);
        serviceType.typeSegundoApellido(scn, page, null, file, 1, false, false, false);
        serviceType.typeNif(scn, page, null, file, 1, false, false, false);
    }

    public void completeDatosEmpresaNroClientSearchForm(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
        serviceType.typeNCliente(scn, page, null, file, 1, false, false, false);
    }

    public void completeDatosEmpresaContratosSearchForm(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
        serviceType.typeNContrato(scn, page, null, file, 1, false, false, false);
    }

    public void searchFieldsOnDialogSeleccionColaborador(String scn, SystemPages page, String file) throws Exception {
        serviceLookupField.lkpNif(scn, page, null, file, 1, false, true, true);
        //serviceType.typeNif(scn, page, null, file, 1, false, false, false);
    }

    public void completeFieldsEmpresa(String scn, SystemPages page, String file) throws Exception {
         serviceLookupField.lkpEmpresa(scn, page, null, file, 1, false, true, true);
    }

    public void completeFieldsContratos(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNContrato(scn, page, null, file, 1, false, false, false);
        serviceType.typeSecuencial(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkGenerados(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkTraspasados(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkActivos(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkBajas(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkConProrrogas(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkNovacion(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkLlamamiento(scn, page, null, file, 1, false, false, false);

        //TODO: @PRE: Funcionalidad no existente.
        //serviceCheckbox.checkBusquedaANivelNacional( scn, page, null, file, 1, false, false, false );

        serviceCheckbox.checkCeseVoluntario(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false, false, false);
    }

    public void completeFieldsContratoAnulacion(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNContrato(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkBusquedaANivelNacional(scn, page, null, file, 1, false, false, false);
    }

    public void completeFieldsTraspasoMasivo(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNContrato(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 1, false, false, false);
        serviceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, false, false, false); //TODO: perece que este valor lo recoje de contratos consulta y no de contratos traspaso masivo, revisarlo
    }

    public void completeDatosAnulacionDeContrato(String scn, SystemPages page, String file) throws Exception {
        serviceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioHasta(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinHasta(scn, page, null, file, 2, false, false, false);
        serviceCheckbox.checkBusquedaANivelNacional(scn, page, null, file, 1, false, false, false);
    }

    public void completeFielsContratosBaja(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNContrato(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeInicioDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateInicioHasta(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFechaDeFinDesde(scn, page, null, file, 1, false, false, false);
        serviceDatePicker.pickDateFinHasta(scn, page, null, file, 2, false, false, false);
        serviceCheckbox.checkBuscarNivelNacional(scn, page, null, file, 1, false, false, false);
    }

    public void busquedaNroContrato(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNroContrato(scn, page, null,file, 1, false, true, true);
        pageLocators.getQbEInputField(null,FieldByTagLabelText.QBE_NROCONTRATO,1).sendKeys(Keys.ENTER);
        commonService.waitUntilSpinnerIsDisplayed();
        commonService.waitUntilSpinnerIsNotDisplayed();
    }

    public void completeFechaBajaMasiva(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        serviceDatePicker.pickDateBaja(scn, page, PanelTitle.DIALOG_DETALLEBAJAMASIVACONTRATO, file, 1, false, false, false);
    }

    public void completeMotivoBajaFecha(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        serviceSelect.selectMotivoBaja(scn, page, PanelTitle.DIALOG_MOTIVOBAJA, file, 1, false, waitForSpinner, checkNoMessageShown);
        serviceDatePicker.pickDateBaja(scn, page, PanelTitle.DIALOG_MOTIVOBAJA, file, 1, false, false, false);
    }

    public void completeDatosBajaDeContrato(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        serviceSelect.selectTipoNovacion(scn, page, PanelTitle.DIALOG_ALTANOVACION, file, 1, false, waitForSpinner, checkNoMessageShown);
        serviceDatePicker.pickDateBajaContrato(scn, page, PanelTitle.DIALOG_ALTANOVACION, file, 1, false, false, false);
    }

    public void completeContratosAltaDeSustitucion(String scn, SystemPages page, String file) throws Exception{
        serviceType.typeNombre(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        serviceType.typePrimerApellido(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        serviceType.typeSegundoApellido(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        serviceType.typeNifPasaporte(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
    }

    public void completeDatosColaboradorAltaSustitucion(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception{
        serviceSelect.selectSexoColaborador(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, waitForSpinner, checkNoMessageShown);
        serviceDatePicker.pickDateInicioDeLaSustitucion(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
    }

    public void validacionSemaforoSobreLaTabla(String scn, SystemPages page, String file) throws Exception {
        serviceValidation.clickFirstValidRowResultOnTableNew(scn, page, null, file, "TestDatosContrato->CONTRATOS__CONSULTA->TABLE", 1, false);
    }

    public void seleccionarContratoATraspasar(String scn, SystemPages page, String file) throws Exception {
        commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, "TestDatosContrato->CONTRATOS__CONSULTA->TABLE", 1, false);
    }

    public void seleccionarContrato(String scn, SystemPages page, String file) throws Exception {
        String datos = "";
        switch (page) {
            case CONTRATOS__CONSULTA:
            case CONTRATOS__ANULACION:
                datos = "TestDatosContrato->CONTRATOS__ANULACION->TABLE";
                break;
            case CONTRATOS__BAJA_DAR_DE_BAJA:
                datos = "TestDatosContrato->CONTRATOS__BAJA_DARDEBAJA->TABLE";
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = "TestDatosContrato->CONTRATOS__BAJA_BAJAS_MASIVAS->TABLE";
                break;
            case CONTRATOS__PRORROGAS_ALTA:
                datos = "TestDatosContrato->CONTRATOS__PRORROGAS_ALTA->TABLE";
                break;
            case CONTRATOS__PRORROGAS_ANULACION:
                datos = "TestDatosContrato->CONTRATOS__PRORROGAS_ANULACION->TABLE";
                break;
            case CONTRATOS__NOVACION_ALTA:
                datos = "TestDatosContrato->CONTRATOS__NOVACION_ALTA->TABLE";
                break;
            case CONTRATOS__ALTA_SUSTITUCION:
                datos = "TestDatosContrato->CONTRATOS__ALTA_SUSTITUCION->TABLE";
                break;
            case CONTRATOS__BAJA_CONSULTA:
                datos = "TestDatosContrato->CONTRATOS__BAJA_CONSULTA->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
    }

    public void seleccionarFechaFinalizacionProrroga(String scn, SystemPages page, String file) throws Exception {
        serviceDatePicker.pickDateFechaFinalizacionProrroga(scn, page, null, file, 1, false, false, false);
    }

    public void seleccionarContratoATraspasarMasivo(String scn, SystemPages page, String file) throws Exception {
        String datos = "";
        int tablaNumero = 1;
        switch (page) {
            case CONTRATOS__TRASPASO_MASIVO:
                datos = datosContrato.getContratosTraspasoMasivos().getTable().getSeleccionarContrato();
                tablaNumero = 10;
                break;
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                datos = datosContrato.getContratosBajaBajasMasivas().getTable().getSeleccionarContrato();
                tablaNumero = 10;
                break;
        }
        commonService.typeInputCellCheckBox(scn, page, null, "Seleccionar", 1, tablaNumero, datos, file, false);
   }

    public void capturarDateBaja(String scn, SystemPages page, String file, Boolean writeIdPedidoOnJson) throws Exception {
        serviceValidation.capturarDateBaja(scn, page, file, writeIdPedidoOnJson);
    }

    public void clickBtnSiSecuencial(FieldByTagLabelText btnLabel, PanelTitle tabTitle, PanelTitle dialogTitle, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickBtn(tabTitle, dialogTitle, btnLabel, 1, true, false);
    }

    public void clickBtnSi(FieldByTagLabelText btnLabel, PanelTitle tabTitle, PanelTitle dialogTitle, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickBtn(tabTitle, dialogTitle, btnLabel, 2, true, false);
    }

    public void clickBtn(FieldByTagLabelText btnLabel, PanelTitle tabTitle, PanelTitle dialogTitle, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickBtn(tabTitle, dialogTitle, btnLabel, 1, true, false);
    }

    public void clickBtnContrato(PanelTitle tabTitle, PanelTitle dialogTitle, FieldByTagLabelText buttonLabel, Integer cajaNumero, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        serviceClick.clickBtnContrato(tabTitle, dialogTitle, buttonLabel, cajaNumero, waitForSpinner, checkNoMessageShown);
    }

    public void clickBtnMasProrrogas() throws Exception{
        commonService.click(pageLocators.getBtnMas());
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
    }
}
