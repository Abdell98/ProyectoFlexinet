package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.database.ContratosQuery;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.PedidosQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static com.eulen.flexinet.core.test.selenium.pages.SystemPages.PARTES_DE_HORAS__ALTA;
import static com.eulen.flexinet.core.test.selenium.pages.SystemPages.PARTES_DE_HORAS__CONSULTA;

public class PartesDeHorasTask extends BasePage {

    private PartesDeHorasServiceClick serviceClick;
    private PartesDeHorasServiceType serviceType;
    private PartesDeHorasServiceSelect serviceSelect;
    private PartesDeHorasServiceValidate serviceValidate;
    private PartesDeHorasServiceLookupField serviceLookupField;
    private PartesDeHorasServiceCheckbox serviceCheckbox;
    private PartesDeHorasServiceDataBaseProcedure serviceDataBaseProcedure;

    private CommonServiceClick commonServiceClick;
    private CommonServiceValidate commonServiceValidate;
    private CommonService commonService;

    public PartesDeHorasTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        commonServiceClick = new CommonServiceClick(driver);
        commonServiceValidate = new CommonServiceValidate(driver);

        serviceClick = new PartesDeHorasServiceClick(driver);
        serviceValidate = new PartesDeHorasServiceValidate(driver);
        serviceType = new PartesDeHorasServiceType(driver);
        serviceSelect = new PartesDeHorasServiceSelect(driver);
        serviceLookupField = new PartesDeHorasServiceLookupField(driver);
        serviceCheckbox = new PartesDeHorasServiceCheckbox(driver);
        serviceDataBaseProcedure = new PartesDeHorasServiceDataBaseProcedure(driver);
    }

    //TODO: @PRE creado en base a pre
    public void seleccionaEmpresaYContrato(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {

        serviceType.typeEmpresa( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.clickBtn( null, null, FieldByTagLabelText.BTN_MOSTRAREMPRESAS, 1, true, true );
        filterByQbeOnTable1AltaParteDeHoras(scn, page, file, waitForSpinner, checkNoMessageShown);
        commonService.clickFirstValidRowResultOnTableNew( scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__ALTA->TABLE1", 1, false );
        serviceType.typeAnio( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceSelect.selectMes( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.clickBtn( null, null, FieldByTagLabelText.BTN_MOSTRARCONTRATOS, 1, true, true );
        filterByQbeOnTable2AltaParteDeHoras(scn, page, file, waitForSpinner, checkNoMessageShown);
        commonService.clickFirstValidRowResultOnTableNew( scn, page, null, file, "TestDatosPartesDeHoras->PARTES_DE_HORAS__ALTA->TABLE2", 2, false );
        commonServiceClick.clickBtn( null, null, FieldByTagLabelText.BTN_CREARPARTEDEHORAS, 1, true, true );

    }

    public void filterByQbeOnTable1AltaParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeQbeEmpresa( scn, page, null, file, 1, false, true, true );
        commonServiceClick.sendEnterOnQbeFilter( null, FieldByTagLabelText.QBE_EMPRESA, 1 );
    }

    public void filterByQbeOnTable2AltaParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {

        serviceType.typeQbeIdContrato( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeColaborador( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeInicio( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeFin( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeMotivoDeBaja( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeCentroDeTrabajo( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbePersonalizada( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.sendEnterOnQbeFilter( null, FieldByTagLabelText.QBE_PERSONALIZADA, 1 );
    }

    public void filterByQbeOnTableConsultaParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeQbeNParte( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        //TODO QBESEL duracion
        //TODO QBESEL formato
        //TODO QBESEL validado
        //TODO QBESEL traspasado
        //TODO QBESEL facturado
        serviceType.typeQbeIdContrato( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeNif( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeColaborador( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeEmpresa( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeMes( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeInicio( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeFin( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeParteOriginal( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_PARTEORIGINAL,1);
    }

    public void filterByQbeOnTableConsultaParteDeHorasAlta(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeQbeIdContrato( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_IDCONTRATO,1);
    }

    public void filterByQbeOnTable1TraspasoParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeQbeNParte( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        //TODO QBESEL duracion
        //TODO QBESEL formato
        serviceType.typeQbeIdContrato( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeOficina( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeColaborador( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeEmpresa( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeInicio( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeFin( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeTraspasado( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_DIADEFIN,1);
    }

    public void filterByQbeOnTable2TraspasoParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeQbeNParte( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        //TODO QBESEL duracion
        //TODO QBESEL formato
        serviceType.typeQbeIdContrato( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeOficina( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeColaborador( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeEmpresa( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeInicio( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeQbeDiaDeFin( scn, page, null, file, 2, false, waitForSpinner, checkNoMessageShown );
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_DIADEFIN,2);
    }

    /**
     * Este metodo completa los checkbox que hay en la cabecera de Parte de Horas
     */
    public void cabeceraYPiePartesDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceCheckbox.checkDiario( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceCheckbox.checkParcial( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceCheckbox.checkEspeciales( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceCheckbox.checkValidado( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
    }

    public void tabPartesDeHorasNominas(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_PARTEDEHORAS.getValue());
        serviceType.typeHorasNormales( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasExtras( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasFestivas( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasNocturnas( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasComplementarias( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasPermisoRetribudo( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeIT( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeTotal( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 1, false, waitForSpinner, checkNoMessageShown );
    }

    public void tabPartesDeHorasFacturacion(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeHorasNormales( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasExtras( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasFestivas( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasNocturnas( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasComplementarias( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasPermisoRetribudo( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeIT( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeTotal( scn, page, PanelTitle.TAB_PARTEDEHORAS, file, 2, false, waitForSpinner, checkNoMessageShown );
    }

    public void tabConceptosIT(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown, boolean addConceptoIT) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_CONCEPTOSIT.getValue());
        serviceSelect.selectConcepto( scn, page, PanelTitle.TAB_CONCEPTOSIT, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeDe( scn, page, PanelTitle.TAB_CONCEPTOSIT, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeA( scn, page, PanelTitle.TAB_CONCEPTOSIT, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeHorasTotales( scn, page, PanelTitle.TAB_CONCEPTOSIT, file, 1, false, waitForSpinner, checkNoMessageShown );

        if(addConceptoIT) {
            commonServiceClick.clickBtn( PanelTitle.TAB_CONCEPTOSIT, null, FieldByTagLabelText.BTN_ANADIRCONCEPTO, 1, waitForSpinner, checkNoMessageShown );
        }
    }

    public void tabConceptosColaborador(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        commonServiceClick.clickTab(PanelTitle.TAB_CONCEPTOSCOLABORADOR.getValue());
        jsonFileNew(file);
        String jsonClickBtnData = "";
        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                jsonClickBtnData = datosPartesDeHoras.getPartesDeHorasAlta().getTabConceptosColaborador().getSectionNomina().getBtn_AnadirColaboradorConceptoNomina();
                break;
            case PARTES_DE_HORAS__MODIFICACION:
                jsonClickBtnData = datosPartesDeHoras.getPartesDeHorasModificacion().getTabConceptosColaborador().getSectionNomina().getBtn_AnadirColaboradorConceptoNomina();
                break;
        }

        JsonCommand btn = new JsonCommand();
        boolean anadirColaborador = btn.convertCommandBtnClickToBoolean(jsonClickBtnData);
        if(anadirColaborador) {
            //Rellena el dialogo de Alta Colaborador Concepto
            commonServiceClick.clickBtn(PanelTitle.TAB_CONCEPTOSCOLABORADOR,null,FieldByTagLabelText.BTN_ANADIR,1,true,true);
            serviceLookupField.lkpConcepto(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true);
            serviceCheckbox.checkDiferencia(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true);
            serviceSelect.selectTipo(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true);
            serviceType.typeDevengo(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true); //INFO: no editable, con los datos conocidos
            serviceType.typeUnidades(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true);
            serviceType.typeSalario(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true);
            serviceType.typeCoeficiente(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true); //INFO: no editable, con los datos conocidos
            serviceType.typeTotal(scn,page,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,file,1,false,true,true); //INFO: no editable, con los datos conocidos
            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_ALTACOLABORADORCONCEPTONOMINA,FieldByTagLabelText.BTN_ACEPTAR,1,true,true);

                //Filtra en la qbe el colaborador añadido
            serviceType.typeQbeConcepto(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
                //TODO: QBE SELECT DIFERENCIA
                //TODO: QBE SELECT TIPO
            serviceType.typeQbeDevengo(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
            serviceType.typeQbeUnidades(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
            serviceType.typeQbeSalarioUnidad(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
            serviceType.typeQbeCoeficiente(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
            serviceType.typeQbeTotal(scn,page,PanelTitle.TAB_CONCEPTOSCOLABORADOR,file,1,false,false,false);
            commonServiceClick.sendEnterOnQbeFilter(PanelTitle.TAB_CONCEPTOSCOLABORADOR,FieldByTagLabelText.QBE_TOTAL,1);

                //Selecciona el registro de la tabla que hemos filtrado, confirmando que tiene los valores esperados
                String jsonObjPathAux = "";
                switch (page) {
                    case PARTES_DE_HORAS__ALTA:
                        jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__ALTA->TAB_CONCEPTOSCOLABORADOR->SECTION_NOMINA->TABLE";
                        break;
                    case PARTES_DE_HORAS__MODIFICACION:
                        jsonObjPathAux = "TestDatosPartesDeHoras->PARTES_DE_HORAS__MODIFICACION->TAB_CONCEPTOSCOLABORADOR->SECTION_NOMINA->TABLE";
                        break;
                }
            commonService.clickFirstValidRowResultOnTableNew( scn, page, PanelTitle.TAB_CONCEPTOSCOLABORADOR, file, jsonObjPathAux, 1, false );
        }
    }



    /**
     * tanto el formulario de consulta como el de traspaso tienen los mismos campos
     * @param scn
     * @param page
     * @param file
     * @param waitForSpinner
     * @param checkNoMessageShown
     * @throws Exception
     */
    public void formularioConsultaTraspasoDeParteDeHoras(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceType.typeEmpresa( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceSelect.selectMes( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeAnio( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeNombre( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typePrimerApellido( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceType.typeSegundoApellido( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceLookupField.lkpNif( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceCheckbox.checkParteSinTraspasar( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
        serviceCheckbox.checkANivelNacional( scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown );
    }

    public void seleccionarCheckValidado(String scn, SystemPages page, String file, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceCheckbox.checkValidado(scn, page, null, file, 1, false, waitForSpinner, checkNoMessageShown);
    }

    public void checkValidado(String scn, SystemPages page, PanelTitle panelTitle, String file, Integer cajaNumero, boolean isRequired, boolean waitForSpinner, boolean checkNoMessageShown) throws Exception {
        serviceCheckbox.checkValidado(scn, page,null, file, 1, false, waitForSpinner, checkNoMessageShown );
    }

    public void consultarYGuardarNumeroDeParte(String file, SystemPages page) throws Exception {
        jsonFileNew(file);
        String idContrato = "";
        String idParte = "";

        switch (page) {
            case PARTES_DE_HORAS__ALTA:
                idContrato = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getIdContrato();
                break;
            case PARTES_DE_HORAS__CONSULTA:
                idContrato = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getIdContrato();
                break;
        }

        idParte = DBQueries.getFieldByQuery("ID_PARTE", serviceDataBaseProcedure.getNumeroDeParte(idContrato));

        commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_nParte",idParte);
        commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->Nº Parte",idParte);
        if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_nParte", idParte);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Nº Parte", idParte);
        }
        commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->qbe_nParte",idParte);
        commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->Nº Parte",idParte);
        commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->qbe_nParte",idParte);
        commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->Nº Parte",idParte);
    }

    public void copiarYGuardarDatosEnPartesDeHorasAlta(String file, SystemPages tipoPedidoOrigen) throws Exception {
        //@STEP obtenemos el id del pedido y consultamos a la base de datos cual es el numero de contrato asociado
        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa =  "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String fechaPrevistaDeInicio = "";
        String centroDeTrabajo = "";

        switch (tipoPedidoOrigen) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                fechaPrevistaDeInicio = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                centroDeTrabajo = datos.getPedidosAlta().getTabDatosDelPedido().getCentrosDeTrabajo();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                fechaPrevistaDeInicio = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                centroDeTrabajo = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getCentrosDeTrabajo();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente de crear la escructura en @TestDatos
                break;
        }

        //Se consulta a la base de datos el numero de contrato en base al id de pedido, se obtienen todos los registros.
        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("QUERY:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );

        if (rows.isEmpty()) {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }

        //Se obtiene el id de contrato del primer registro encontrado, con un pedido se pueden dar de alta mas de 1 contrato para tenerlo en cuenta.
        String idContrato = rows.get(0).get("ID_CON").toString();
        System.out.println("INFO: Se han encontrado " + rows.size() + "registros");

        //@STEP se guardan los datos en el json
        {
            //@STEP Convierte el mes y año del valor indicado en fechaPrevistaDeInicio, por ejemplo de 02/03/2024 a mes = Marzo y año = 2024
            JsonCommand dt = new JsonCommand();
            Map<String, String> fecha = dt.dateToYearMonthDay(fechaPrevistaDeInicio);

            //@STEP Convierte la fecha de incicio que fue copiada del objeto de alta de pedido y que puede venir como comando, a un formato de fecha
            String diaDeInicio = dt.convertCommandToDate(fechaPrevistaDeInicio);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->mes", fecha.get("mes"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->anio", fecha.get("anio"));

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE1->qbe_empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE1->Empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->Id. Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->qbe_colaborador", primerApellidoColaborador.toUpperCase() + " " + segundoApellidoColaborador.toUpperCase() + ", " + nombreColaborador.toUpperCase());
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->Colaborador", primerApellidoColaborador.toUpperCase() + " " + segundoApellidoColaborador.toUpperCase() + ", " + nombreColaborador.toUpperCase());
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->qbe_diaDeInicio", diaDeInicio);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->Día de Inicio", diaDeInicio);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->qbe_centroDeTrabajo", centroDeTrabajo);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ALTA->TABLE2->Centro de Trabajo", centroDeTrabajo);

            jsonFileNew(file);
            Assert.assertEquals(datosPartesDeHoras.getPartesDeHorasAlta().getTable1().getQbe_empresa(), empresa);
            Assert.assertEquals(datosPartesDeHoras.getPartesDeHorasAlta().getTable1().getEmpresa(), empresa);
            Assert.assertEquals(datosPartesDeHoras.getPartesDeHorasAlta().getEmpresa(), empresa);
            Assert.assertEquals(datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_idContrato(), idContrato);
            Assert.assertEquals(datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getIdContrato(), idContrato);
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_idContrato: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_idContrato());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->Id. Contrato: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getIdContrato());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_colaborador: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_colaborador());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->Colaborador: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getColaborador());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_diaDeInicio: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_diaDeInicio());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_diaDeInicio: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getDiaDeInicio());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_diaDeInicio: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getQbe_centroDeTrabajo());
            System.out.printf("PARTES_DE_HORAS__ALTA->TABLE2->qbe_diaDeInicio: `%s`", datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getCentroDeTrabajo());
        }
    }

    public void copiarYGuardarDatosEnPartesDeHorasConsulta(String file, SystemPages tipoPedidoOrigen) throws Exception {

        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa = "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String colaboradorDNI = "";
        String colaboradorNombreYApellidos = "";
        String colaboradorDireccion = "";
        String fechaPrevistaDeInicio = "";

        switch (tipoPedidoOrigen) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO pendiente de crear estructura en @TestDatos
                break;
        }

        //Se consulta a la base de datos el numero de contrato en base al id de pedido, se obtienen todos los registros.
        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("QUERY:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );

        if (rows.isEmpty()) {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }

        //Se obtiene el id de contrato del primer registro encontrado, con un pedido se pueden dar de alta mas de 1 contrato para tenerlo en cuenta.
        String idContrato = rows.get(0).get("ID_CON").toString();
        System.out.println("INFO: Se han encontrado " + rows.size() + "registros");

        //@STEP se guardan los datos en el json
        {

            //@STEP Convierte el mes y año del valor indicado en fechaPrevistaDeInicio, por ejemplo de 02/03/2024 a mes = Marzo y año = 2024
            JsonCommand dt = new JsonCommand();
            Map<String, String> fecha = dt.dateToYearMonthDay(fechaPrevistaDeInicio);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->mes", fecha.get("mes"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->anio", fecha.get("anio"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->nombre", nombreColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->primerApellido", primerApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->segundoApellido", segundoApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->lkp_nif", colaboradorDNI);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_nif", colaboradorDNI);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->qbe_mes", fecha.get("mes") + " " + fecha.get("anio"));

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->Id. Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->NIF", colaboradorDNI);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->Colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->Empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->TABLE->Mes", fecha.get("mes") + " " + fecha.get("anio"));

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_nombreYApellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_direccion", colaboradorDireccion);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Dirección", colaboradorDireccion);

        }
    }

    public void copiarYGuardarDatosEnPartesDeHorasTraspaso(String file, SystemPages tipoPedidoOrigen) throws Exception {

        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa = "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String colaboradorDNI = "";
        String colaboradorNombreYApellidos = "";
        String colaboradorDireccion = "";
        String fechaPrevistaDeInicio = "";

        switch (tipoPedidoOrigen) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
        }

        //Se consulta a la base de datos el numero de contrato en base al id de pedido, se obtienen todos los registros.
        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("QUERY:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );

        if (rows.isEmpty()) {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }

        //Se obtiene el id de contrato del primer registro encontrado, con un pedido se pueden dar de alta mas de 1 contrato para tenerlo en cuenta.
        String idContrato = rows.get(0).get("ID_CON").toString();
        System.out.println("INFO: Se han encontrado " + rows.size() + "registros");

        //@STEP se guardan los datos en el json
        {
            //@STEP Convierte el mes y año del valor indicado en fechaPrevistaDeInicio, por ejemplo de 02/03/2024 a mes = Marzo y año = 2024
            JsonCommand dt = new JsonCommand();
            Map<String, String> fecha = dt.dateToYearMonthDay(fechaPrevistaDeInicio);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->mes", fecha.get("mes"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->anio", fecha.get("anio"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->nombre", nombreColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->primerApellido", primerApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->segundoApellido", segundoApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->lkp_nif", colaboradorDNI);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->qbe_colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->qbe_empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->Id. Contrato", idContrato); //TODO: en pre
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->ID.Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->Colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE1->Empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->qbe_colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->qbe_empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->Id. Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->ID.Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->Colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->TABLE2->Empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_nombreYApellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_direccion", colaboradorDireccion);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__TRASPASO->DIALOG_SELECCIONDECOLABORADORES->TABLE->Dirección", colaboradorDireccion);
        }
    }

    public void copiarYGuardarDatosEnPartesDeHorasModificacion(String file, SystemPages tipoPedidoOrigen) throws Exception {

        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa = "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String colaboradorDNI = "";
        String colaboradorNombreYApellidos = "";
        String colaboradorDireccion = "";
        String fechaPrevistaDeInicio = "";

        switch (tipoPedidoOrigen) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
        }

        String idContrato = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getIdContrato();

        //@STEP se guardan los datos en el json
        {
            //@STEP Convierte el mes y año del valor indicado en fechaPrevistaDeInicio, por ejemplo de 02/03/2024 a mes = Marzo y año = 2024
            JsonCommand dt = new JsonCommand();
            Map<String, String> fecha = dt.dateToYearMonthDay(fechaPrevistaDeInicio);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->mes", fecha.get("mes"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->anio", fecha.get("anio"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->TABLE1->qbe_empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->TABLE1->Empresa", empresa);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->TABLE2->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__MODIFICACION->TABLE2->Id. Contrato", idContrato);

        }
    }

    public void copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(String file, SystemPages tipoPedidoOrigen) throws Exception {

        jsonFileNew(file);

        String idPedidoJson = "";
        String empresa = "";
        String nombreColaborador = "";
        String primerApellidoColaborador = "";
        String segundoApellidoColaborador = "";
        String colaboradorDNI = "";
        String colaboradorNombreYApellidos = "";
        String colaboradorDireccion = "";
        String fechaPrevistaDeInicio = "";

        switch (tipoPedidoOrigen) {
            case PEDIDOS__ALTA_SIMPLE:
                idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAlta().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAlta().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_LV3233:
                idPedidoJson = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido();
                empresa = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
                nombreColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                primerApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                segundoApellidoColaborador = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                colaboradorDNI = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDNI();
                colaboradorNombreYApellidos = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getNombreYApellidos();
                colaboradorDireccion = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getDialogSeleccionDeColaboradores().getTable().getDireccion();
                fechaPrevistaDeInicio = datos.getPedidosAltaLv3233().getTabDatosDelPedido().getFechaPrevistaDeInicio();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                break;
        }

        String idContrato = datosPartesDeHoras.getPartesDeHorasAlta().getTable2().getIdContrato();

//        String idParte = datosPartesDeHoras.getPartesDeHorasConsulta().getTable().getNParte();

        //@STEP se guardan los datos en el json
        {
            //@STEP Convierte el mes y año del valor indicado en fechaPrevistaDeInicio, por ejemplo de 02/03/2024 a mes = Marzo y año = 2024
            JsonCommand dt = new JsonCommand();
            Map<String, String> fecha = dt.dateToYearMonthDay(fechaPrevistaDeInicio);

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->mes", fecha.get("mes"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->anio", fecha.get("anio"));
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->nombre", nombreColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->primerApellido", primerApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->segundoApellido", segundoApellidoColaborador);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->lkp_nif", colaboradorDNI);

//            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_nParte",idParte);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_idContrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_nif", colaboradorDNI);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->qbe_mes", fecha.get("mes") + " " + fecha.get("anio"));

//            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Nº Parte",idParte);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Id. Contrato", idContrato);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->NIF", colaboradorDNI);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Colaborador", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Empresa", empresa);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__ENVIOSPARTESAORACLE->TABLE->Mes", fecha.get("mes") + " " + fecha.get("anio"));

            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_nombreYApellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos", colaboradorNombreYApellidos);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_direccion", colaboradorDireccion);
            commonService.jsonUpdate(file, "PARTES_DE_HORAS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Dirección", colaboradorDireccion);

        }
    }

}


