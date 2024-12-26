package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContratosSteps extends TestBase {

    @And("^se ingresa los datos de la empresa y número cliente (.*),(.*),(.*)$")
    public void seIngresaLosDatosDeLaEmpresaYNumeroCliente(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeContratosConsultaEmpresaColaboradorForm(scn, page, file);
    }

    //TODO: Pendiente borrar si el step `un pedido inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>` cubre las necesidades
    // - revisar en cada metodo donde se utiliza
    @And("^se consulta el id de contrato en la tabla Contrato enviando el id del pedido (.*),(.*),(.*)$")
    public void seConsultaElIdDeContratoPorElIdDePedidoGeneradoEnBaseDeDatos(String scn, SystemPages page, String file) throws Exception {
        contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
    }

    @And("^se actualiza la tabla contrato sobre el campo F_TRS_FACT (.*),(.*),(.*)$")
    public void seActualizaLaTablaContratoSobreElCampoFTrsFact(String scn, SystemPages page, String file) throws Exception{
        contratosTask.actualizarCampoFTrsFactDelContratoTraspasado(scn, page, file);
    }


    @And("^se selecciona la lupa para buscar los datos de la empresa a filtrar y contrato (.*),(.*),(.*)$")
    public void seSeleccionaLaLupaParaBuscarLosDatosDeLaEmpresaAFiltrarYContratos(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeDatosEmpresaContratosSearchForm(scn, page, file);
    }

    @And("^se buscan los datos de la empresa a filtrar y nro de cliente (.*),(.*),(.*)$")
    public void seBuscanLosDatosDeLaEmpresaAFiltrarYNroCliente(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeDatosEmpresaNroClientSearchForm(scn, page, file);
    }


    @And("^se ingresa los datos del empleador tal como nombre, apellidos y nif y selecciona la lupa para buscar datos (.*),(.*),(.*)$")
    public void seIngresaLosDatosDelEmpleadorTalComoNombreApellidoNifSeleccionaLaLupaParaBuscarDatos(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeContratosConsultaColaboradorSearchForm(scn, page, file);
    }

    @And("^en el dialogo selecciona el registro deseado de colaboradores, buscado por nombre, apellidos y dirección (.*),(.*),(.*)$")
    public void enElDialogoSeleccionaElRegistroDeseadoDeColaboradoresBuscadoPorNombreApellidosDireccion(String scn, SystemPages page, String file) throws Exception {
        contratosTask.searchFieldsOnDialogSeleccionColaborador(scn, page, file);
    }

    @And("^rellena datos necesarios para realizar una anulación de contrato (.*),(.*),(.*)$")
    public void rellenaDatosNecesariosParaRealizarUnaAnulacionDeContrato(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFieldsContratoAnulacion(scn, page, file);
    }

    @And("^rellena datos necesarios para realizar un traspaso masivo (.*),(.*),(.*)$")
    public void rellenaDatosNecesariosParaRealizarUnTraspasoMasivo(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFieldsTraspasoMasivo(scn, page, file);
    }

    @And("^rellena datos necesarios para realizar una consulta de baja de contratos (.*),(.*),(.*)$")
    public void rellanaDatosNecesariosParaRealizarUnaConsultaDeBajaDeContratos(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFielsContratosBaja(scn, page, file);
    }

    @And("^se realiza una busqueda por columna nro contrato (.*),(.*),(.*)$")
    public void elUsuarioRealizaUnaBusquedaPorColumnaNroContrato(String scn, SystemPages page, String file) throws Exception{
        contratosTask.busquedaNroContrato(scn, page, file);
    }

    @And("^rellena los datos necesarios en las pestañas de contratos (.*),(.*),(.*)$")
    public void rellanaLosDatosNecesariosEnLasPestaniasDeContratos(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFieldsContratos(scn, page, file);
    }

    @And("^se selecciona los datos de la empresa (.*),(.*),(.*)$")
    public void seSeleccionaLosDatosDeLaEmpresa(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFieldsEmpresa(scn, page, file);
    }

    @When("^hace click en opción Buscar$")
    public void haceClickEnOpcionBuscar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
    }

    @And("^hace click en el botón Mas$")
    public void haceClickEnBotonMas() throws Exception {
        //TODO remplazar por clickBtn
        if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
            contratosTask.clickBtnMasProrrogas();
        } else {
            System.out.println("WARNING: En pre este step no se ejecuta, dado que no existe el botón");
        }

    }

    @Then("^selecciona el registro deseado de la tabla en el dialogo seleccion de Historico de traspasos a Oracle (.*),(.*),(.*)$")
    public void seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeHistoricoDeTraspasosAOracle(String scn, SystemPages page, String file) throws Exception {
        if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
            ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);

            //Rellenar los datos
            contratosServiceType.typeQbeLog(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeLote(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeAccion(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeEstado(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeEstado2(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeNumProyect(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeFechaCreacion(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeFechaActualizacion(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeFechaEnvioAOracle(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeFechaProcesado(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);
            contratosServiceType.typeQbeUsuarioCreador(scn, page, PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, file, 1, false, true, true);

            commonServiceClick.sendEnterOnQbeFilter(PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE, FieldByTagLabelText.QBE_LOG, 1);

            //Seleccionar el dialogo
            commonTask.clickFirstValidRowResultOnTable(
                    scn,
                    page,
                    PanelTitle.DIALOG_HISTORICODETRASPASOSAORACLE,
                    file,
                    "TestDatosContrato->CONTRATOS__PRORROGAS_CONSULTA->TABLE->DIALOG_HISTORICODETRASPASOSAORACLE->TABLE1",
                    1,
                    true);
        } else {
            System.out.println("WARNING: En pre dado que no existe el botón + no se valida el popup de historico");
        }
    }

    @And("^rellena datos necesarios para realizar una anulación de prorroga de contrato (.*),(.*),(.*)$")
    public void rellanaDatosNecesariosParaRealizarUnaAnulacionDeProrrogaDeContrato(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeDatosAnulacionDeContrato(scn, page, file);
    }

    @And("^selecciona el contrato (.*),(.*),(.*)$")
    public void seleccionaElContrato(String scn, SystemPages page, String file) throws Exception {
        CommonService commonService = new CommonService(driver);
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
            case CONTRATOS__BAJA_CONSULTA:
                datos = "TestDatosContrato->CONTRATOS__BAJA_CONSULTA->TABLE";
                break;
            case CONTRATOS__CONTROL_ENVIOS_CPDS:
                datos = "TestDatosContratos->CONTRATOS__CONTROL_ENVIOS_CPDS->TABLE";
                break;
        }
        commonService.clickFirstValidRowResultOnTableNew(scn, page, null, file, datos, 1, false);
    }

    @And("^filtrar el contrato recién creado (.*),(.*),(.*)$")
    public void seleccionaElContratoRecienCreado(String scn, SystemPages page,String file) throws Exception {
          CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
          ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
          contratosServiceType.typeQbeNContrato(scn,page,null, file , 1, false,true,false);
          commonServiceClick.sendEnterOnQbeFilter(null, FieldByTagLabelText.QBE_NCONTRATO, 1);
    }

    @And("^hace click en opción Crear Prórroga (.*),(.*),(.*)$")
    public void haceClickEnOpcionCrearProrroga(String scn, SystemPages page, String file) throws Exception {
        contratosTask.capturarDateBaja(scn,page,file,true);
        commonTask.clickBtn(FieldByTagLabelText.BTN_CREARPRORROGA, null, null, true, true);
    }

    @And("^hace click sobre la opción Crear Prórroga$")
    public void haceClickSobreLaOpcionCrearProrroga() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_CREARPRORROGA, null, PanelTitle.DIALOG_CREACIONPRORROGA, true, true);
    }

    @And("^se va a proceder a la creación de la prórroga, hace click boton aceptar$")
    public void seVaAProcederALaCreacionDeLaProrrogaHaceClickBotonAceptar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_CREACIONPRORROGA, true, true);
    }

    @And("^selecciona la fecha de finalización de prorroga (.*),(.*),(.*)$")
    public void seleccionaLaFechaDeFinalizacionDeProrroga(String scn, SystemPages page, String file) throws Exception {
        contratosTask.seleccionarFechaFinalizacionProrroga(scn, page, file);
    }

    @And("^hace click en opción anular contrato$")
    public void haceClickEnOpcionAnularContrato() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ANULARCONTRATO, null, null, true, true);
    }

    @And("^hace click en opción novar contrato (.*),(.*),(.*)$")
    public void haceClilcEnOpcionNovarContrato(String scn, SystemPages page, String file) throws Exception{
        contratosTask.capturarDateBaja(scn,page,file,true);
        commonTask.clickBtn(FieldByTagLabelText.BTN_NOVARCONTRATO, null, null, true, true);
    }

    @Then("^seleccionar la opción editar pedidos (.*)$")
    public void seleccionarLaOpcionEditarPedidos(String scn) throws Exception{
        //TODO -> GIO REVISAR
        switch (scn){
            case "Flexinet19910" :
                commonTask.clickBtn(FieldByTagLabelText.BTN_EDITARPEDIDO, null, PanelTitle.DIALOG_ALTANOVACION, true, true);
        }
    }

    @And("^hace click en opción Aceptar, sobre la anulación de contrato$")
    public void haceClickEnOpcionAceptarSobreLaAnulacionDeContratos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_ANULACIONDECONTRATO, true, true);
    }

    @And("^hace click en opción dar de baja$")
    public void haceClickEnOpcionDarDeBaja() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_DARDEBAJA, null, null, true, false);
    }

    @And("^hace click en opción anular baja$")
    public void haceClickEnOpcionAnularBaja() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ANULARBAJA, null, null, true, false);
    }

    @And("^el usuario hace click en opción Si anular baja$")
    public void elUsuarioHaceClickEnOpcionSiAnularBaja() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO, null, PanelTitle.DIALOG_ANULACIONBAJA, true, false);
    }

    @Then("^hace click en boton aceptar anulación baja$")
    public void haceClickEnBotonAceptarAnulacionBaja() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, null, true, false);
    }

    @And("^hace click en opción alta de sustitución$")
    public void haceClickEnOpcionAltaDeSustitucion() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ALTADESUSTITUCION, null, PanelTitle.DIALOG_ALTASUSTITUCION, true, true);
    }

    @And("^se selecciona la opción aceptar sobre la sustitución$")
    public void seSeleccionaLaOpcionAceptarSobreLaSustitucion() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_ALTASUSTITUCION, true, false);
    }
    @Then("^se ha creado correctamente la sustitución del contrato$")
    public void seHaCreadoCorrectamenteLaSustitucionDelContrato() throws Exception{
        commonTask.waitForGrowlNotifToBeVisible(ModalTitle.INFORMACION,"Se ha creado correctamente",false, false, false);
    }
    @And("^selecciona el motivo de la baja y su fecha (.*),(.*),(.*)$")
    public void seleccionaElMotivoDeLaBajaYSuFecha(String scn, SystemPages page, String file) throws Exception {
        ContratosServiceSelect contratosServiceSelect = new ContratosServiceSelect(driver);
        ContratosServiceDatePicker contratosServiceDatePicker = new ContratosServiceDatePicker(driver);
        contratosServiceSelect.selectMotivoBaja(scn, page, PanelTitle.DIALOG_MOTIVOBAJA, file, 1, false, false, false);
        contratosServiceDatePicker.pickDateBaja(scn, page, PanelTitle.DIALOG_MOTIVOBAJA, file, 1, false, false, false);
    }

    @And("^se ingresa los datos baja de contrato (.*),(.*),(.*)$")
    public void seIngresaLosDatosBajaDeContrato(String scn, SystemPages page, String file) throws Exception{
        contratosTask.completeDatosBajaDeContrato(scn, page, file, false, false);
    }

    @And("^hace click en opción Si, para continuar la anulación de contrato$")
    public void haceClikEnOpcionSiParaContinuarLaAnulacionDeContrato() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO, null, PanelTitle.DIALOG_BAJADECONTRATO, true, true);
    }

    @And("^se selecciona el botón traspaso masivo$")
    public void seSeleccionaElBotonTraspasoMasivo() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_TRASPASOMASIVO, null, null, true, true);
    }

    @And("^hace click sobre la opcion de aceptar (.*)$")
    public void haceClickSobreLaOpcionDeAceptar(String pagina) throws Exception {
        switch (pagina) { //@scn
            case "CONTRATOS__BAJA_CONSULTA":
            case "CONTRATOS__BAJA_DAR_DE_BAJA":
            case "CONTRATOS__CONSULTA":
                commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
                break;
            case "CONTRATOS__BAJA_BAJAS_MASIVAS":
                commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_DETALLEBAJAMASIVACONTRATO, true, true);
                break;
            case "CONTRATOS__NOVACION_ALTA":
                commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_ALTANOVACION, true, true);
                break;
        }
    }

    @And("^selecciona opción aceptar para realizar la sustitución del contrato$")
    public void seleccionaOpcionAceptarParaRealizarLaSustitucionDelContrato() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
    }

    @And("^se ingresan los datos para completar el Alta de Sustitución (.*),(.*),(.*)$")
    public void seIngresanLosDatosParaCompletarElAltaDeSustitucion(String scn, SystemPages page, String file) throws Exception{
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        ContratosServiceDatePicker contratosServiceDatePicker = new ContratosServiceDatePicker(driver);
        CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
        CommonService commonService = new CommonService(driver);
        ContratosServiceSelect contratosServiceSelect = new ContratosServiceSelect(driver);
        CommonServiceValidate commonServiceValidate = new CommonServiceValidate(driver);
        contratosServiceType.typeNombre(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        contratosServiceType.typePrimerApellido(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        contratosServiceType.typeSegundoApellido(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        contratosServiceType.typeNifPasaporte(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
        commonServiceClick.clickBtn(null, PanelTitle.DIALOG_ALTASUSTITUCION, FieldByTagLabelText.BTN_BUSCARCOLABORADOR, 1,true, true);
        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                "TestDatos->CONTRATOS__ALTA_SUSTITUCION->DIALOG_SELECCIONDECOLABORADORES->TABLE",
                1,
                true
        );
        commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_PERFILDATOUNICO,1,true,true);
        contratosServiceType.typeselElegirNacionalidad( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        contratosServiceType.typeselElegirMpieResidencia( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        contratosServiceType.typeselElegirOcupacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        contratosServiceType.typeselSeleccionarTitulacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        contratosServiceSelect.selectSexo( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        commonServiceClick.clickBtn(null,PanelTitle.DIALOG_PERFILDATOUNICO,FieldByTagLabelText.BTN_GUARDAR,1,true,true);
        //TOFIX: Revisar mensaje colaboradores
        commonService.waitUntilSpinnerIsNotDisplayed(); //TODO: esto hace falta? revisar
        commonServiceValidate.validateGrowlMessage(ModalTitle.CORRECTO, "El dato único del colaborador ha sido modificado", true, true);
        commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_ASOCIARCOLABORADOR,1,true,true);
        contratosServiceSelect.selectSexoColaborador(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, true, true);
        contratosServiceDatePicker.pickDateInicioDeLaSustitucion(scn, page, PanelTitle.DIALOG_ALTASUSTITUCION, file, 1, false, false, false);
    }

    @And("^hace click sobre el diagolo baja de contrato, para continuar la anulación de contrato$")
    public void haceClickSobreElDialogoBajaDeContratoParaContinuarLaAnulacionDeContrato() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
    }

    @Then("^aparece un mensaje indicando que el contrato se ha traspasado (.*)$")
    public void apareceUnMensajeIndicandoContratoTraspasado(String fileAux) throws Exception{
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO,"Se ha traspasado la baja correctamente",false, true, false);
    }

    @And("^se selecciona la opción de cancelar para no sustituir el contrato$")
    public void seSeleccionaLaOpcionDeCancelarParaNoSustituirElContrato() throws Exception{
        commonTask.clickBtn(FieldByTagLabelText.BTN_CANCELAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"No existen Contratos con ese criterio de búsqueda.",false, true, false);
        CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
        commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
    }

    @Then("^se visualiza un mensaje indicando que el contrato tiene un proceso pendiente con oracle o dicho proceso erróneo.$")
    public void seVisualizaUnMensajeIndicandoQueElContratoTieneUnProcesoPendienteConOracleODichoProcesoErroneo() throws Exception{
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"El contrato tiene un proceso pendiente con oracle o dicho proceso es erróneo.",false, true, false);
    }

    @And("^aparece un mensaje indicando que el contrato ha sido dado de baja correctamente (.*)$")
    public void apareceUnMensajeIndicandoQueElContratoHaSidoDadoBajaCorrectamente(String fileAux) throws Exception{
        commonTask.validateDialogMessage(
                null,
                "El contrato (.*) ha sido dado de baja correctamente. Se dió de alta el pedido (.*)",
                false,
                fileAux);
        commonTask.clickBtnCerrarModal();
    }

    @And("^hace click en opción Aceptar, traspaso masivo de alta de contratos$")
    public void haceCliclEnOpcionAceptarTraspasoMasivoDeAltaDeContratos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, null, true, true);
    }

    @And("^hace click en aceptar para proceder a la baja masiva de contratos$")
    public void haceClickEnAceptarParaProcederALaBajaMasivaContratos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, null, true, true);
    }

    @And("^hace click sobre el boton aceptar$")
    public void haceClickSobreElBotonAceptar() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_GENERARINCIDENCIACONTRATO, true, true);
    }

    @And("^hace click en opción baja de contratos$")
    public void haceClickEnOpcionBajaDeContratos() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_BAJACONTRATOS, null, null, true, true);
    }

    @And("^selecciona la fecha sobre el detalle de la baja masiva (.*),(.*),(.*)$")
    public void seleccionaLaFechaSobreElDetalleDeLaBajaMasiva(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeFechaBajaMasiva(scn, page, file, false, false);
    }

    @Then("^se visualiza dialogo para realizar traspaso masivo de alta, seleccionar la opción aceptar$")
    public void seVisualizaDialogoParaRealizarTraspasoMasivoDeAltaSeleccionarLaOpcionAceptar() throws Exception {
        contratosTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_DETALLEMENSAJETRASPASOMASIVOALTA, true, false);
    }

    @Then("^aparecen las opciones de los distintos colores del semaforos (.*),(.*),(.*)$")
    public void aparecenLasOpcionesDeLosDistintosColoresDelSemaforos(String scn, SystemPages page, String file) throws Exception {
        if(Hooks.getEnv().equals(Environments.UAT)) {
            contratosTask.validacionSemaforoSobreLaTabla(scn, page, file);
        }
    }

    @And("^presionamos el contrato a trapasar (.*),(.*),(.*)$")
    public void seleccionarElContratoATraspasar(String scn, SystemPages page, String file) throws Exception {
        contratosTask.seleccionarContratoATraspasar(scn, page, file);
    }

    @And("^seleccionar sobre la tabla el contrato (.*),(.*),(.*)$")
    public void seleccionarSobreLaTablaElContrato(String scn, SystemPages page, String file) throws Exception {
        switch (page){ //@scn
            case CONTRATOS__BAJA_BAJAS_MASIVAS:
                contratosTask.seleccionarContratoATraspasarMasivo(scn, page, file);
                contratosTask.capturarDateBaja(scn,page,file,true);
                break;
            default:
                contratosTask.seleccionarContratoATraspasarMasivo(scn,page,file);
                break;
        }
    }

    @And("^hace click en opción Ver Detalle Contrato$")
    public void haceClickEnOpcionVerDetalleContrato() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_VERDETALLECONTRATO, null, null, true, true);
    }

    @And("^hace click en opción Traspasar$")
    public void haceClickEnOpcionTraspasar() throws Exception {
        contratosTask.clickBtnContrato(null, null, FieldByTagLabelText.BTN_TRASPASAR, 1, true, true);
        //TODO: AJUSTAR PARA QUE EL METODO COJA CAJA NUMERO
        //commonTask.clickBtn(FieldByTagLabelText.BTN_TRASPASAR,null,null,true,true);
    }

    @And("^el usuario hace click en opción Traspasar al ERP$")
    public void elUsuarioHaceClickEnOpcionTraspasarAlErp() throws Exception{
        contratosTask.clickBtnContrato(null, null, FieldByTagLabelText.BTN_TRASPASARAORACLE, 1, true, true);
    }

    @And("^se selecciona la opción si, para proceder a traspasar el contrato$")
    public void seSeleccionaLaOpcionSiParaProcederATraspasarElContrato() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO,null,PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, true);
    }

    //TODO: @PRE: Funcionalidad no existente, sobre el ambiente de UAT.
    @And("^se selecciona la opción si, para proceder a traspasar el secuencial del contrato$")
    public void seSeleccionaLaOpcionSiParaProcederATraspasarElSecuencialDelContrato() throws Exception {
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI_SINACENTO,null,PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, true);
    }

    @And("^hace click en opción Aceptar, traspaso contrato (.*)$")
    public void haceClickEnOpcionAceptarTraspasoContrato(String scn) throws Exception {
        switch (scn) { //@scn
            case "Flexinet-19822":
                commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, false);
                break;
            case "Flexinet-19884":
                commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, null, true, false);
                //TODO: Validar en los steps.
                //commonTask.clickFirstValidRowResultOnTable();
                break;
        }
    }

    @And("^Se debe ingresar un pedido por alta simple sin realizar el traspaso de contrato (.*),(.*),(.*)$")
    public void seDebeIngresarUnPedidoPorAltaSimpleSinRealizarElTraspasoDeContrato(String scn, String file, String oficina) throws Exception {
        SystemPages page = null;
        String fileAux = "";
        fileAux = file.replace(".json", "");
        fileAux = fileAux + "_AltaSimple" + ".json";
        BasePage.setAuxiliarFile(fileAux);

        PedidosSteps pedidosSteps = new PedidosSteps();

        page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        navigationService.navigateToSubPage(page, oficina, scn);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, true);
        pedidosSteps.buscaUnaEmpresaPorAlgunoDeLosCampos(scn, page, fileAux);
        pedidosSteps.seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeEmpresa(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ASOCIARAEMPRESA, null, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, true, true);
        pedidosTask.completeFields(scn, page, fileAux, false, false);
        commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El pedido ha sido autorizado por Riesgos", true, true, true);
        pedidosTask.consultarYGuardarNumeroPedido(fileAux, true, false, true, false);
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        //pedidosTask.validandoMensajesDeFinalizacionAltaPedido(scn, page, file, "El contrato para el colaborador (.*) ha sido generado con éxito.", true, true);
        // VALIDAR GROWL
        Thread.sleep(8000); //TODO @MOCK falta un mock aqui
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento RPD generado correctamente", false, false, false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento Riesgos generado correctamente", false, false, false);
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CL generado correctamente",false, false, false);
        commonTask.doScreenshot("Mensajes Finales");

        switch (page) { //TODO @MOCK falta un mock aqui
            case PEDIDOS__ALTA_LV3233:
                commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente",true, true,false);
                break;
            default:
                commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente",false, false,false);
                commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CPD generado correctamente", true, true,false);
                break;
        }

        //VALIDAR DOCUMENTOS A IMPRIMIR
        switch (page) { //TODO @MOCK falta un mock aqui
            case PEDIDOS__ALTA_LV3233:
                commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                break;
            default:
                commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
                commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
                break;
        }

        //VALIDAR ESTADO DEL PEDIDO
        commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO); //TODO @MOCK falta un mock aqui
        //Los siguientes escenarios usan 2 colaboradores, por lo que salen 2 mensajes al final de que ha sido traspasado con exito
        //Flexinet-19885 - alta simple 2 colaboradores
        //Flexinet-19887 - alta indefinidos 2 colaboradores
        //Flexinet-19891 - alta lv3233 2 colaboradores
        if(scn.equals("Flexinet-19885") || scn.equals("Flexinet-19887") || scn.equals("Flexinet-19891")) {
            String colaborador1 = commonTask.getNombreColaborador(page, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador1 + " ha sido generado y traspasado con éxito.", false, file);
            file = file.replace(".json","");
            String colaborador2 = commonTask.getNombreColaborador(page, file + "_ColaboradorAdicional.json");
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador2 + " ha sido generado y traspasado con éxito.", false, file);
        } else {
            String colaborador = commonTask.getNombreColaborador(page, fileAux);

            //TODO:Se coloca esta condición dado que para escenario el coloborador se coloco en minuscula, cambiar para usar algo generico.
            if(scn.equals("Flexinet-19822")) {
                colaborador = colaborador.toLowerCase();
            }
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado con éxito.", false, fileAux);
            commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);
        }
    }

    @And("^Se debe ingresar un pedido por alta simple y traspasar o no el contrato (.*),(.*),(.*)$")
    public void seDebeIngresarUnPedidoPorAltaSimpleYTraspasarONoElContrato(String scn, String file, String oficina) throws Exception{
        SystemPages page = null;
        /*String fileAux = "";
        fileAux = file.replace(".json", "");
        fileAux = fileAux + "_AltaSimple" + ".json";
        BasePage.setAuxiliarFile(fileAux);*/

        PedidosSteps pedidosSteps = new PedidosSteps();

        page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        navigationService.navigateToSubPage(page, oficina, scn);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, true);
        pedidosSteps.buscaUnaEmpresaPorAlgunoDeLosCampos(scn, page, file);
        pedidosSteps.seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeEmpresa(scn, page, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ASOCIARAEMPRESA, null, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, true, true);
        pedidosTask.completeFields(scn, page, file, false, false);
        commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        boolean validarmensaje1 = true; //@MOCK
        if(validarmensaje1) {
            commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El pedido ha sido autorizado por Riesgos", true, true, true);
        }
        pedidosTask.consultarYGuardarNumeroPedido(file, true, false,true, false);
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, page, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        //pedidosTask.validandoMensajesDeFinalizacionAltaPedido(scn, page, file, "El contrato para el colaborador (.*) ha sido generado con éxito.", true, true);
        // VALIDAR GROWL
        Thread.sleep(8000);
        boolean validarmensaje2 = true; //@MOCK
        if(validarmensaje2) {
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false, false);
            commonTask.doScreenshot("Mensajes Finales");

            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", true, true, false);
                    break;
                default:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", false, false, false);
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CPD generado correctamente", true, true, false);
                    break;
            }
        }

        //VALIDAR DOCUMENTOS A IMPRIMIR
        boolean validarmensaje3 = true; //@MOCK
        if(validarmensaje3) {
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    break;
                default:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
                    break;
            }
        }
        //VALIDAR ESTADO DEL PEDIDO
        commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
        //Los siguientes escenarios usan 2 colaboradores, por lo que salen 2 mensajes al final de que ha sido traspasado con exito
        //Flexinet-19885 - alta simple 2 colaboradores
        //Flexinet-19887 - alta indefinidos 2 colaboradores
        //Flexinet-19891 - alta lv3233 2 colaboradores
        if(scn.equals("Flexinet-19885") || scn.equals("Flexinet-19887") || scn.equals("Flexinet-19891")) {
            String colaborador1 = commonTask.getNombreColaborador(page, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador1 + " ha sido generado y traspasado con éxito.", false, file);
            file = file.replace(".json","");
            String colaborador2 = commonTask.getNombreColaborador(page, file + "_ColaboradorAdicional.json");
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador2 + " ha sido generado y traspasado con éxito.", false, file);
        } else {
            String colaborador = commonTask.getNombreColaborador(page, file);

            //TODO:Se coloca esta condición dado que para escenario el coloborador se coloco en minuscula, cambiar para usar algo generico.
            //INFO: Flexinet-19822, existen aparte dos condiciones ya que uno es por contrato no ha sido traspasado.
            //INFO: Flexinet-19884, contrato ha sido traspasado con exito.
            if(scn.equals("Flexinet-19822")) {
                //TODO: VALIDAR TEXTO POR EL USUARIO QUE SE INGRESA TANTO EN PRE COMO EN UAT
                //colaborador = colaborador.toLowerCase();
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado con éxito.", false, file);
            } else if(scn.equals("Flexinet-19884")){
                colaborador = colaborador.toLowerCase();
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado y traspasado con éxito.", false, file);
            }
            commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);

        }
    }

    //TODO: Pendiente borrar si el step `un pedido inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado <scenario>,<pagina>,<fichero_datos>,<oficina>` cubre las necesidades
    @And("^Se ingresa un pedido por alta simple bloqueado por riesgos y luego traspasar o no el contrato (.*),(.*),(.*)$")
    public void seIngresaUnPedidoPorAltaSimpleBloqueadoPorRiesgosYLuegoTraspasarONoElContrato(String scn, String file, String oficina) throws Exception{
        SystemPages page = null;
        String fileAux = "";
        fileAux = file.replace(".json", "");
        fileAux = fileAux + "_AltaSimple" + ".json";
        BasePage.setAuxiliarFile(fileAux);

        PedidosSteps pedidosSteps = new PedidosSteps();

        page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        navigationService.navigateToSubPage(page, oficina, scn);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, true);
        pedidosSteps.buscaUnaEmpresaPorAlgunoDeLosCampos(scn, page, fileAux);
        pedidosSteps.seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeEmpresa(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ASOCIARAEMPRESA, null, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, true, true);
        pedidosTask.completeFields(scn, page, fileAux, false, false);
        commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        boolean validarmensaje1 = false; //@MOCK
        if(validarmensaje1) {
            commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El pedido ha sido autorizado por Riesgos", true, true, true);
        }
        pedidosTask.consultarYGuardarNumeroPedido(fileAux, true, false,true, false);
        commonTask.clickBtn(FieldByTagLabelText.BTN_GENERARCONTRATOS, null, null, true, true);
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        //pedidosTask.validandoMensajesDeFinalizacionAltaPedido(scn, page, file, "El contrato para el colaborador (.*) ha sido generado con éxito.", true, true);
        // VALIDAR GROWL
        Thread.sleep(8000);
        boolean validarmensaje2 = false; //@MOCK
        if(validarmensaje2) {
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false, false);
            commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false, false);
            commonTask.doScreenshot("Mensajes Finales");

            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", true, true, false);
                    break;
                default:
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CLCB generado correctamente", false, false, false);
                    commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CPD generado correctamente", true, true, false);
                    break;
            }
        }

        //VALIDAR DOCUMENTOS A IMPRIMIR
        boolean validarmensaje3 = false; //@MOCK
        if(validarmensaje3) {
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    break;
                default:
                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
                    break;
            }
        }
        //VALIDAR ESTADO DEL PEDIDO
        commonTask.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
        //Los siguientes escenarios usan 2 colaboradores, por lo que salen 2 mensajes al final de que ha sido traspasado con exito
        //Flexinet-19885 - alta simple 2 colaboradores
        //Flexinet-19887 - alta indefinidos 2 colaboradores
        //Flexinet-19891 - alta lv3233 2 colaboradores
        if(scn.equals("Flexinet-19885") || scn.equals("Flexinet-19887") || scn.equals("Flexinet-19891")) {
            String colaborador1 = commonTask.getNombreColaborador(page, file);
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador1 + " ha sido generado y traspasado con éxito.", false, file);
            file = file.replace(".json","");
            String colaborador2 = commonTask.getNombreColaborador(page, file + "_ColaboradorAdicional.json");
            commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador2 + " ha sido generado y traspasado con éxito.", false, file);
        } else {
            String colaborador = commonTask.getNombreColaborador(page, fileAux);

            //TODO:Se coloca esta condición dado que para escenario el coloborador se coloco en minuscula, cambiar para usar algo generico.
            //INFO: Flexinet-19822, existen aparte dos condiciones ya que uno es por contrato no ha sido traspasado.
            //INFO: Flexinet-19884, contrato ha sido traspasado con exito.
            if(scn.equals("Flexinet-19822")) {
                colaborador = colaborador.toLowerCase();
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado con éxito.", false, fileAux);
            } else if(scn.equals("Flexinet-19884")){
                colaborador = colaborador.toLowerCase();
                commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado y traspasado con éxito.", false, fileAux);
            }
            commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);
        }
    }

    @And("^Se debe ingresar un pedido por alta simple con un colaborador sin irpf (.*),(.*),(.*)$")
    public void seDebeIngresarUnPedidoPorAltaSimpleConUnColaboradorSinIRPF(String scn, String file, String oficina) throws Exception {
        SystemPages page = null;
        String fileAux = "";
        fileAux = file.replace(".json", "");
        fileAux = fileAux + "_AltaSimpleColaboradorSinIRPF" + ".json";
        BasePage.setAuxiliarFile(fileAux);

        PedidosSteps pedidosSteps = new PedidosSteps();

        page = SystemPages.PEDIDOS__ALTA_SIMPLE;
        navigationService.navigateToSubPage(page, oficina, scn);
        commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, true);
        pedidosSteps.buscaUnaEmpresaPorAlgunoDeLosCampos(scn, page, fileAux);
        pedidosSteps.seleccionaElRegistroDeseadoDeLaTablaEnElDialogoSeleccionDeEmpresa(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_ASOCIARAEMPRESA, null, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, true, true);
        pedidosTask.completeFields(scn, page, fileAux, false, false);
        commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El pedido ha sido autorizado por Riesgos", true, true, true);
        pedidosTask.consultarYGuardarNumeroPedido(fileAux, true, false, false, false);
        pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, page, fileAux);
        commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        pedidosTask.validandoMensajesDeFinalizacionAltaPedido(scn, page, file, "El contrato para el colaborador (.*) pero no se ha podido traspasar por estos motivos:", false, true);
        commonTask.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO,"El colaborador no dispone de datos de IRPF", false, file);
        commonTask.clickBtn(FieldByTagLabelText.BTN_OK,null,PanelTitle.DIALOG_ESTADODEPEDIDO,true,true);
        System.out.println("@DEBUG ... seDebeIngresarUnPedidoPorAltaSimpleConUnColaboradorSinIRPF  -- fin -- ");
    }

    @And("^Se debe realizar un traspaso para dar de baja un contrato (.*),(.*)$")
    public void seDebeRealizarUnTraspasoParaDarDeBajaUnContrato(String scn, String file) throws Exception {
        SystemPages page = null;
        String oficina = "";
        SystemPages pageJson = null;
        switch (Hooks.getEnv()) {
            case PRE:
                page = SystemPages.CONTRATOS__CONSULTA;
                oficina = "451-FLX-TOLEDO";
                navigationService.navigateToSubPage(page, oficina, scn);
                contratosTask.completeFieldsContratos(scn, page, file);
                commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
                contratosTask.seleccionarContratoATraspasar(scn, page, file);
                commonTask.clickBtn(FieldByTagLabelText.BTN_VERDETALLECONTRATO, null, null, true, true);
                contratosTask.clickBtnContrato(null, null, FieldByTagLabelText.BTN_TRASPASAR, 1, true, true);
                contratosTask.clickBtnSiSecuencial(FieldByTagLabelText.BTN_SI_SINACENTO, null, PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, true);
                contratosTask.clickBtnSi(FieldByTagLabelText.BTN_SI_SINACENTO, null, PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, true);
                switch (scn) { //@scn
                    case "Flexinet19896": //LV3233
                    case "Flexinet-19822":
                    case "Flexinet19899":
                    case "Flexinet19921":
                    case "Flexinet19907":
                        contratosTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_CONFIRMARTRASPASOCONTRATO, true, false);
                        break;
                    default:
                        commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, null, true, true);
                        break;
                }
                commonTask.clickBtnCerrarModal();
                contratosTask.clickBtnContrato(null, null, FieldByTagLabelText.BTN_CANCELAR, 2, true, true);
        }
    }

    @Then("^aparece un mensaje indicando que se ha realizado el traspaso con éxito (.*)$")
    public void apareceUnMensajeIndicandoQueSeHaRealizadoElTraspadoConExito(String file) throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"Se ha realizado el traspaso con éxito",true, true, true);
        //contratosTask.clickBtnContrato(null, null, FieldByTagLabelText.BTN_CANCELAR, 2, true, true);
    }

    @Then("^aparece un mensaje de error indicando que el colaborador no tiene datos de irpf (.*)$")
    public void errorElColaboradorNoTieneDatosDeIRPF(String file) throws Exception {
        commonTask.validateGrowlMessage(ModalTitle.ERROR,"El colaborador no dispone de datos de IRPF",true, true, true);
    }

    @Then("^aparece una notificacion indicando que el contrato ha sido dado de baja correctamente (.*)$")
    public void apareceUnaNotificacionIndicandoQueElContratoHaSidoAutorizado(String file) throws Exception {
        commonTask.validateDialogMessage(
                PanelTitle.DIALOG_INFORMACIONRESULTADO,
                "-El contrato (.*) ha sido dado de baja correctamente",
                false,
                file
        );
    }

    @Then("^validar información que el contrato se ha anulado$")
    public void validarInformacionQueElContratoSeHaAnulado() throws Exception{
        commonTask.validateGrowlMessage(ModalTitle.CORRECTO, "El contrato ha sido anulado.", false,true,true);
    }

    @And("^hace click en Anular Prórroga")
    public void haceClickAnularProrroga() throws Exception {
        contratosTask.clickBtn( FieldByTagLabelText.BTN_ANULARPRORROGA, null, null, true, true);
    }

    @Then("^comprobar resultado esperado(.*)$")
    public void comprobarResultadoEsperado(String scn) throws Exception {
        switch (scn) { //@scn
            case "Flexinet19961":
                commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"El contrato se ha anulado correctamente",true, true, true);
                break;
            case "Flexinet19960":
            case "Flexinet19959":
                commonTask.validateGrowlMessage(ModalTitle.INFORMACION,"El contrato tiene un proceso pendiente con oracle o dicho proceso es erróneo.",true, true, true);
                break;

        }
    }

    @And("^el usuario ingresa los datos del formulario de busqueda de prorroga de contrato (.*),(.*),(.*)$")
    public void elUsuarioIngresaLosDatosDelFormularioDeBusquedaDeProrrogaDeContratoScenarioPaginaFichero_datos(String scn, SystemPages page, String file) throws Exception {
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        ContratosServiceLookupField contratosServiceLookupField = new ContratosServiceLookupField(driver);

        contratosServiceType.typeEmpresa(scn, page, null, file, 1, false, false, false);
        contratosServiceType.typeNCliente(scn, page, null, file, 1, false, false, false);
        contratosServiceType.typeNombre(scn, page, null, file, 1, false, false, false);
        contratosServiceType.typePrimerApellido(scn, page, null, file, 1, false, false, false);
        contratosServiceType.typeSegundoApellido(scn, page, null, file, 1, false, false, false);
        contratosServiceType.typeNif(scn, page, null, file, 1, false, false, false);
        contratosServiceLookupField.lkpNif(scn, page, null, file, 1, false, true, true);
        contratosServiceType.typeNContrato(scn, page, null, file, 1, false, false, false);

    }
    @And("ingresamos los datos para completar el Alta de Sustitución (.*),(.*),(.*)$")
    public void ingresamos_los_datos_para_completar_el_alta_de_sustituciónn(String scn, SystemPages page, String file) throws Exception {
        contratosTask.completeContratosAltaDeSustitucion(scn, page, file);
        contratosTask.completeDatosColaboradorAltaSustitucion(scn, page, file, false, false);
    }
    @And("selecciona el colaborador (.*),(.*),(.*)$")
    public void selecciona_el_colaborador(String scn, SystemPages page, String file) throws Exception {
        CommonService commonService = new CommonService(driver);
        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                file,
                "TestDatosContratos->CONTRATOS__ALTA_SUSTITUCION->DIALOG_SELECCIONDECOLABORADORES->TABLE",
                1,
                true
        );
    }
    @And("^rellena los datos de la tabla de Pérfil Dato Único (.*),(.*),(.*)$")
    public void rellana_datos_perfil_dato_unico(String scn,SystemPages page, String file) throws Exception {
        ContratosServiceType serviceType = new ContratosServiceType(driver);
        ContratosServiceSelect serviceSelect = new ContratosServiceSelect(driver);
        serviceType.typeselElegirNacionalidad( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        serviceType.typeselElegirMpieResidencia( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        serviceType.typeselElegirOcupacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        serviceType.typeselSeleccionarTitulacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
        serviceSelect.selectSexo( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
    }
    @And("verifica que aparece el mensaje del modal correctamente y lo cierra")
    public void verificar_modal_mensaje()throws Exception {
        CommonService commonService = new CommonService(driver);
        CommonServiceValidate commonServiceValidate = new CommonServiceValidate(driver);
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonServiceValidate.validateGrowlMessage(ModalTitle.CORRECTO, "El dato único del colaborador ha sido modificado", true, true);
    }
    @Given("^un contrato creado para darle de baja (.*),(.*),(.*),(.*)$")
    public void baja_contrato(String scn, SystemPages page, String file, String oficina) throws Exception {
        SystemPages pageDardeBajaContrato = SystemPages.CONTRATOS__BAJA_DAR_DE_BAJA;
        {
            navigationService.navigateToSubPage(pageDardeBajaContrato, oficina, scn);
            contratosTask.completeContratosConsultaEmpresaColaboradorForm(scn, page, file);
            contratosTask.completeContratosConsultaColaboradorSearchForm(scn, page, file);
            contratosTask.searchFieldsOnDialogSeleccionColaborador(scn, page, file);
            contratosTask.completeFieldsContratoAnulacion(scn, page, file);
            commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
            contratosTask.seleccionarContrato(scn, page, file);
            commonTask.clickBtn(FieldByTagLabelText.BTN_DARDEBAJA, null, null, true, false);
            contratosTask.completeMotivoBajaFecha(scn, page, file, false, false);
            commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_MOTIVOBAJA, true, true);
            commonTask.clickBtn(FieldByTagLabelText.BTN_ACEPTAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
            commonTask.validateGrowlMessage(ModalTitle.CORRECTO,"Se ha traspasado la baja correctamente",false, true, false);
            commonTask.clickBtn(FieldByTagLabelText.BTN_CANCELAR, null, PanelTitle.DIALOG_BAJACONTRATO, true, true);
        }
    }
    @And("^rellena los datos de la tabla y seleccionamos el registro (.*),(.*),(.*)$")
    public void rellenarFormularioDeTraspasosMasivosDeAltas(String scn,SystemPages page,String file) throws Exception{
        CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        contratosServiceType.typeQbeNContrato(scn,page,null, file , 1, false,true,false);
        contratosServiceType.typeQbeEmpresa(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeNif2(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeColaborador(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeSeguridadSocial(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeFechaInicio(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeFechaFin(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeFechaAntiguedad(scn,page,null,file,1,false,true,false);
        commonServiceClick.sendEnterOnQbeFilter(null, FieldByTagLabelText.QBE_NCONTRATO, 1);
    }
    @And("^seleccionamos los checkbox para realizar el Traspaso Masivo")
    public void seleccionarCheckBoxex() throws Exception{
        //List<WebElement> checkboxes = driver.findElements(By.xpath("//div[contains(@class, 'cajaResultados')]//div[@class=\"ui-chkbox-box ui-widget ui-corner-all ui-state-default\"]"));
        PageLocators pageLocators = new PageLocators(driver);
         for (WebElement chbox: pageLocators.getCheckboxex()){
            if (chbox.isDisplayed() && chbox.isEnabled() && !chbox.isSelected()){
                chbox.click();
                Thread.sleep(1000);
                System.out.println("INFO->Se ha seleccionado el CheckBox Correctamente \n");
            }
             String CheckBoxActive = chbox.getAttribute("class");
             if (CheckBoxActive.contains("ui-state-active")){
                 System.out.println("INFO -> El CheckBox está activo y esta marcado, DESMARCAMOS \n");
                 chbox.click();
                 Thread.sleep(1500);
             }
        }
         pageLocators.getCheckboxex().get(0).click();
      /*  checkboxes.stream().forEach(c ->{
            if (c.isDisplayed() && c.isEnabled() && !c.isSelected()){
                c.click();
            }
        });*/
    }
    @And("^seleccionamos los checkbox filtrados por estado (.*)")
    public void SeleccionCheckBoxPorEstado(String file) throws Exception{
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        contratosServiceType.FiltrarPorEstadoCheckBox(file);
    }
    @And("^en la tabla rellenamos los datos y buscamos el registro (.*),(.*),(.*)$")
    public void RellenarTablaYseleccionarRegistro(String scn,SystemPages page,String file) throws Exception{
        CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
        ContratosServiceType contratosServiceType = new ContratosServiceType(driver);
        contratosServiceType.typeQbeEmpresa(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeNif2(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeSec(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeNombre(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeCpdPro(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeFechaInicio1(scn,page,null,file,1,false,true,false);
        contratosServiceType.typeQbeFechaFin1(scn,page,null,file,1,false,true,false);
       // contratosServiceType.typeQbeFechaEnvio(scn,page,null,file,1,false,true,false);
       // contratosServiceType.typeQbeFecharRec(scn,page,null,file,1,false,true,false);
        commonServiceClick.sendEnterOnQbeFilter(null, FieldByTagLabelText.QBE_EMPRESA, 1);
    }
    @And("ingresamos la fecha de envío (.*),(.*),(.*)$")
    public void ingresamos_la_fecha_de_envío(String scn, SystemPages page, String file) throws  Exception{
        ContratosServiceDatePicker contratosServiceDatePicker = new ContratosServiceDatePicker(driver);
        contratosServiceDatePicker.pickFechaEnvioCpdsProrrogas(scn, page, PanelTitle.DIALOG_FECHAENVIOCPDS_PRORROGAS, file, 1, false, false, false);
    }
}
