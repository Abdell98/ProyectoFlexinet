package com.eulen.flexinet.core.test.selenium.Pom.Task;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.LocatorCondition;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.JsonCommand;
import com.eulen.flexinet.core.test.selenium.database.ContratosQuery;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.PedidosQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidosTask extends BasePage {

    private PedidosServiceClick serviceClick;
    private PedidosServiceType serviceType;
    private PedidosServiceSelect serviceSelect;
    private PedidosServiceValidate serviceValidate;
    private PedidosServiceDataBaseProcedure serviceDataBaseProcedure;
    private PedidosServiceDragAndDrop serviceDragAndDrop;
    private PedidosServiceCheckbox serviceCheckbox;
    private PedidosServiceDatePicker serviceDatePicker;
    private PedidosServiceLookupField serviceLookupField;

    private CommonServiceClick commonServiceClick;
    private GestionEmpresasClienteServiceType commonServiceType;
    private GestionEmpresasClienteServiceSelect commonServiceSelect;
    private CommonServiceValidate commonServiceValidate;
    private CommonService commonService;

    public PedidosTask(WebDriver driver) {
        super(driver);
        commonService = new CommonService(driver);
        //commonServiceClick = new GestionEmpresasClienteServiceClick(driver);
        commonServiceClick = new CommonServiceClick(driver);
        commonServiceType = new GestionEmpresasClienteServiceType(driver);
        commonServiceValidate = new CommonServiceValidate(driver);
        commonServiceSelect = new GestionEmpresasClienteServiceSelect(driver);

        serviceClick = new PedidosServiceClick(driver);
        serviceValidate = new PedidosServiceValidate(driver);
        serviceType = new PedidosServiceType(driver);
        serviceSelect = new PedidosServiceSelect(driver);
        serviceDataBaseProcedure = new PedidosServiceDataBaseProcedure(driver);
        serviceDragAndDrop = new PedidosServiceDragAndDrop(driver);
        serviceCheckbox = new PedidosServiceCheckbox(driver);
        serviceDatePicker = new PedidosServiceDatePicker(driver);
        serviceLookupField = new PedidosServiceLookupField((driver));
    }

    public void clickBtnBuscarEmpresa() throws Exception {
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkNoUnexpectedMessageIsShown();
        serviceClick.clickBtnBuscarEmpresa();
    }

    public void waitToDialogSeleccionEmpresaIsVisible() throws Exception {
        serviceValidate.waitToDialogSeleccionEmpresaIsVisible();
    }

    public void searchFieldsOnDialogSeleccionEmpresa(String scn, SystemPages page, String file) throws Exception {

        serviceType.typeEmpresa(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeNif(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        //TODO: ajustar para paginaConsulta
        serviceType.typeNCliente(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        commonServiceClick.clickBtn(null, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, FieldByTagLabelText.BTN_BUSCAR, 1, true, true);
    }

    public void filterByQbeOnDialogSeleccionEmpresa(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNif(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeQbeEmpresa(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeQbeNCliente(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeQbeEstado(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeQbeFormaDePago(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        serviceType.typeQbeComportamientoDePago(scn, page, PanelTitle.DIALOG_SELECCIONDEEEMPRESA, file, 1, false, true, true);
        commonServiceClick.sendEnterOnQbeFilter(PanelTitle.DIALOG_SELECCIONDEEEMPRESA, FieldByTagLabelText.QBE_FORMADEPAGO, 1);

    }

    public void selectRecordFoundOnDialogSeleccionEmpresaTable(String scn, SystemPages page, String file) throws Exception {

        String jsonObjectPath = null;
        switch (page) {
            case PEDIDOS__ALTA_SIMPLE:
                jsonObjectPath = "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case PEDIDOS__ALTA_LV3233:
                jsonObjectPath = "TestDatos->PEDIDOS__ALTA_LV3233->TAB_DATOSDELPEDIDO->DIALOG_SELECCIONDEEMPRESA->TABLE";
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                //TODO @TestDatos
                break;
        }

        commonService.clickFirstValidRowResultOnTableNew(
                scn,
                page,
                null,
                file,
                jsonObjectPath,
                1,
                true);
    }

    public void clickBtnAsociarAEmpresa() throws Exception {
        serviceClick.clickBtnAsociarAEmpresa();
    }

    public void completeFields(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        //@TAB__DATOSDELPEDIDO
        {
            commonServiceClick.clickTab("Datos del Pedido");

            serviceSelect.selectTCont(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceSelect.selectClausulas(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            if (!page.equals(SystemPages.PEDIDOS__ALTA_LV3233)) {
                serviceSelect.selectConvenio(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            }
            serviceDragAndDrop.dragAndDropCentrosDeTrabajo(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeNPedidoAuxiliar(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceSelect.selectSupuestoCelebracion(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, false);
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    //INFO: El mensaje siguiente aparecía en PRE, pero en UAT 17/09/2024 es referente a datos del entorno
                    boolean elMensajeAparece = true; //@MOCK01 -- true para pre y false para uat salvo que cambie algo
                    if (elMensajeAparece) {
                        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "No se ha podido obtener el listado de bonificaciones.", true, true);
                        commonService.doScreenshot("Notificación Mostrada");
                    }
                    break;
                default:
                    //INFO: este paso lo dejo por si necesitamos añadir comportamientos distintos para otra página.
                    break;
            }


            //INFO: Dependiendo del supuesto de celebración hay campos que se muestran o no, aqui están todos indicados
            // a la hora de ejecutar las pruebas simplemente hay que rellenar los campos que esperamos que se muestren
            // y dejar vacios, lo que no, si se deja un ' ' entonces si el campo es un input, borrará lo que tenga ese campo
            // y lo dejará vacio.

            //Supuesto Celebracion: LETRA (B) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    serviceCheckbox.checkMarqueExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
                    break;
                default:
                    serviceCheckbox.checkExisteConvColectQuePermitaContratosDe6A12MesesEnUnPeriodoDe18(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
                    break;
            }

            //Supuesto Celebracion: LETRA (C) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceType.typeSustitucionDelTrabajador(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (C) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceSelect.selectMotivoDeSustitucion(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceType.typeElLaTrabajadoraEstaEnPosesionDelTitulo(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceType.typeElLaTrabajadoraAcreditaConLaCertificacionPor(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceCheckbox.checkCertificadoProfesional(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceCheckbox.checkDesempleadoYMenor30Anos(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceCheckbox.checkDesempleadoYMenor35AnosYConDiscapacSup30(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceCheckbox.checkMenor30AnosRealizarPracticasNoLaboralesRD15432011(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //Supuesto Celebracion: LETRA (D) DEL APTDO. 2 DEL ART. 6 DE LA LEY 14/94
            serviceDatePicker.pickDateHaberTerminadoLosEstudiosQueLeCapacitanParaLaPracticaObjetoDeDichoContratoConFecha(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);

            //comunes
            serviceType.typeDescripcion(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceCheckbox.checkContratacion(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, false);
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    boolean elMensajeAparece = true; //@MOCK01 -- true para pre y false para uat salvo que cambie algo
                    if (elMensajeAparece) {
                        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "No se ha podido obtener el listado de bonificaciones.", true, true);
                        commonService.doScreenshot("Notificación Mostrada");
                    }
                    break;
                default:
                    break;
            }
            serviceDatePicker.pickDateFechaPrevistaDeInicio(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, true);

            //TODO: depues de rellenar la fecha, según el valor del convenio puede salir un mensaje de aviso
            //  analizar si es necesario automatizar la lectura de dicho mensaje o hacer algo con el, de momento
            //  hay que probar con datos que no provoquen que salta dicho mensaje (fechas anteriores 28/03/2022)
            // INFO 20/02/24: Luego de hablarlo con Alberto nos comenta que eso sale para el supuesto A

            serviceDatePicker.pickDatePrevistaDeFin(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, true);
            serviceClick.clickRadPrevisible(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceClick.clickRadImprevisible(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceCheckbox.checkAvalNecesario(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeImporteDelAval(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeObservaciones(scn, page, PanelTitle.TAB_DATOSDELPEDIDO, file, 1, false, waitForSpinner, checkNoMessageShown);
        }
        //FIXME: Revisar ejecucion Flexinet-19822:Traspasar Contrato
        //commonService.doScreenshot("TAB__DATOSDELPEDIDO");
        //@TAB__DATOSDEJORNADA
        {
            commonServiceClick.clickTab("Datos de Jornada");

            serviceType.typeDepartamento(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeNCandidatosSolicitados(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeDiasTrabajadosALaSemana(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeHorasNormalesDiarias(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typePeriodoDePrueba(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typePorcentajeJornada(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceCheckbox.checkDiasDeTrabajoSemanales(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeHorario(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceCheckbox.checkAturnos(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);
            serviceType.typeTurno(scn, page, PanelTitle.TAB_DATOSDEJORNADA, file, 1, false, waitForSpinner, checkNoMessageShown);

            commonServiceClick.clickBtn(PanelTitle.TAB_DATOSDEJORNADA, null, FieldByTagLabelText.BTN_ANADIR, 1, true, true);
        }
        //commonService.doScreenshot("TAB__DATOSDEJORNADA");
        //@TAB__DATOSDETARIFA
        {//@TAB__DATOSDETARIFA
            commonServiceClick.clickTab("Datos de Tarifa");

            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    serviceSelect.selectCategoriaProfesional( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
                    serviceSelect.selectSeleccioneDuracionYTipoJornada( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
                    serviceType.typeCellSalarial(scn,page,PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL,1,1,file,true);
                    serviceType.typeCellExtrasal(scn,page,PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL,1,1,file,true);
                    serviceType.typeCellPlusSalarial(scn,page,PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL,1,1,file,true);
                    serviceType.typeCellPlusExtrasal(scn,page,PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL,1,1,file,true);
                    break;
                default:
                    //INFO: este campo está visible pero lo vemos deshabilitado inicialmente
                    serviceType.typeOferta( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
                    serviceSelect.selectCategoriaLaboral( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
                    serviceClick.clickRadTarifaNormal( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
                    serviceClick.clickRadTarifaIgualOInferiorA5Dias( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
                    break;
            }
            //INFO: este campo es editable solo en Lv32-33
            serviceSelect.selectCompPago( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
            //INFO: este campo es editable solo en Lv32-33
            serviceSelect.selectGrupoCotizacion( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
            //INFO: este campo es editable solo en Lv32-33
            serviceSelect.selectOcupacion( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, true, true );
            //INFO: este campo es editable solo en Lv32-33
            serviceCheckbox.checkBrutoMensual( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
            //INFO: este campo es editable solo en Lv32-33
            serviceType.typeBonificacion( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
            //INFO: este campo es editable solo en Lv32-33
            serviceDatePicker.pickDateFechaInicio( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
            //INFO: este campo es editable solo en Lv32-33
            serviceDatePicker.pickDateFechaFin( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
            //INFO: este campo está visible pero lo vemos deshabilitado inicialmente
            serviceCheckbox.checkPrevisionarCompensacionFinContrato( scn, page, PanelTitle.TAB_DATOSDETARIFA, file, 1, false, waitForSpinner, checkNoMessageShown );
        }
        //commonService.doScreenshot("TAB__DATOSDETARIFA");
        //@TAB_DATOSDECOLABORADORES
        {//@TAB_DATOSDECOLABORADORES
            commonServiceClick.clickTab("Datos de Colaboradores");
            //TODO: falta configurar Datos para pagina consulta y añadir al json
            serviceType.typeNombre( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typePrimerApellido( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeSegundoApellido( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDNI( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );

            commonServiceClick.clickBtn(PanelTitle.TAB_DATOSDECOLABORADORES,null,FieldByTagLabelText.BTN_BUSQUEDARAPIDA,1,true,true);

            String data = null;
            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    data = "TestDatos->PEDIDOS__ALTA_LV3233->TAB_DATOSCOLABORADORES->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                    break;
                case PEDIDOS__ALTA_SIMPLE:
                default:
                    data = "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSCOLABORADORES->DIALOG_SELECCIONDECOLABORADORES->TABLE";
                    break;
            }

            commonService.clickFirstValidRowResultOnTableNew(
                    scn,
                    page,
                    PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                    file,
                    data,
                    1,
                    true
            );

            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_PERFILDATOUNICO,1,true,true);

            serviceType.typeselElegirNacionalidad( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselElegirMpieResidencia( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselElegirOcupacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselSeleccionarTitulacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceSelect.selectSexo( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );

            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_PERFILDATOUNICO,FieldByTagLabelText.BTN_GUARDAR,1,true,true);
            //TOFIX: Revisar mensaje colaboradores
            commonService.waitUntilSpinnerIsNotDisplayed(); //TODO: esto hace falta? revisar
            boolean validarMensajeDatoUnico = true; //@DEBUG: Esta variable es unicamente util para desactivar o activar la validación durante la ejecución
            if(validarMensajeDatoUnico){
                commonServiceValidate.validateGrowlMessage(ModalTitle.CORRECTO, "El dato único del colaborador ha sido modificado", true, true);
            }
            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_ASOCIARCOLABORADOR,1,true,false);
            Thread.sleep(3000);
            commonService.checkMsgErrorIsNotShown(true);
        }
       // commonService.doScreenshot("TAB_DATOSDECOLABORADORES");
    }

    public void anadirColaboradorAdicional(String scn, SystemPages page, String file, Boolean waitForSpinner, Boolean checkNoMessageShown) throws Exception {
        {//@TAB_DATOSDECOLABORADORES
            commonServiceClick.clickTab("Datos de Colaboradores");

            //TODO: falta configurar Datos para pagina consulta y añadir al json
            serviceType.typeNombre( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typePrimerApellido( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeSegundoApellido( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );
            serviceType.typeDNI( scn, page, PanelTitle.TAB_DATOSDECOLABORADORES, file, 1, false, waitForSpinner, checkNoMessageShown );

            commonServiceClick.clickBtn(PanelTitle.TAB_DATOSDECOLABORADORES,null,FieldByTagLabelText.BTN_BUSQUEDARAPIDA,1,true,true);

            commonService.clickFirstValidRowResultOnTableNew(
                    scn,
                    page,
                    PanelTitle.DIALOG_SELECCIONDECOLABORADORES,
                    file,
                    "TestDatos->PEDIDOS__ALTA_SIMPLE->TAB_DATOSCOLABORADORES->DIALOG_SELECCIONDECOLABORADORES->TABLE",
                    1,
                    true
            );
            //INFO: IMPORTANTE, si el numero de colaboradores es menor al numero de colaboradores que vamos a añadir, el siguiente no colaborador cuando
            // lo intente añadir no mostrará el siguiente boton
            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_PERFILDATOUNICO,1,true,true);

            serviceType.typeselElegirNacionalidad( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselElegirMpieResidencia( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselElegirOcupacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceType.typeselSeleccionarTitulacion( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );
            serviceSelect.selectSexo( scn, page, PanelTitle.DIALOG_PERFILDATOUNICO, file, 1, false, true, true );

            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_PERFILDATOUNICO,FieldByTagLabelText.BTN_GUARDAR,1,true,true);
            commonService.waitUntilSpinnerIsNotDisplayed(); //TODO esto es necesario? revisar
            //TODO: añadir alguna condicion que evalue si el mensaje dice modificado o guardado, dado que el mensaje dice guardado cuando se edita por primera vez
            try {
                commonServiceValidate.validateGrowlMessage(ModalTitle.CORRECTO, "El dato único del colaborador ha sido modificado", true, true);
            } catch (Exception e) {
                commonServiceValidate.validateGrowlMessage(ModalTitle.CORRECTO, "El dato único del colaborador ha sido guardado", true, true);
            }

            commonServiceClick.clickBtn(null,PanelTitle.DIALOG_SELECCIONDECOLABORADORES,FieldByTagLabelText.BTN_ASOCIARCOLABORADOR,1,true,false);
            Thread.sleep(3000);
            commonService.checkMsgErrorIsNotShown(true);
        }
    }

    public void captureIdPedidoFromDialogAndWriteToJson(String scn, SystemPages page, String file, Boolean writeIdPedidoOnJson) throws Exception {
        serviceValidate.captureIdPedidoAndWriteToJson(scn, page, file, writeIdPedidoOnJson);
    }

    public void completePedidosConsultaSearchForm(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeNPedido( scn, page, null, file, 1, false, true, true );
        serviceSelect.selectEstado( scn, page, null, file, 1, false, true, true );
        serviceCheckbox.checkOferta( scn, page, null, file, 1, false, true, true );
        serviceCheckbox.checkBuscarNivelNacional( scn, page, null, file, 1, false, true, true );
        serviceDatePicker.pickDateFechaInicioDesde( scn, page, null, file, 1, false, true, true );
        serviceDatePicker.pickDateFechaInicioHasta( scn, page, null, file, 1, false, true, true );
        serviceDatePicker.pickDateFechaFinDesde( scn, page, null, file, 1, false, true, true );
        //INFO: `cajaNumero = 2` esto es porque este campo tiene el mismo label que el FechaInicioHasta
        serviceDatePicker.pickDateFechaFinHasta( scn, page, null, file, 2, false, true, true );
        serviceType.typeNombre( scn, page, null, file, 1, false, true, true );
        serviceType.typePrimerApellido( scn, page, null, file, 1, false, true, true );
        serviceType.typeSegundoApellido( scn, page, null, file, 1, false, true, true );
        serviceLookupField.lkpNif( scn, page, null, file, 1, false, true, true );
        serviceLookupField.lkpEmpresa( scn, page, null, file, 1, false, true, true );
        serviceType.typeNCliente( scn, page, null, file, 1, false, true, true );
    }

    public void completePedidosConsultaQbeTablaEmpresa(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeNPedido( scn, page, null, file, 1, false, true, true );
        serviceType.typeQbeFechaDeInicio( scn, page, null, file, 1, false, true, true );
        serviceType.typeQbeFechaDeFin( scn, page, null, file, 1, false, true, true );
        //TODO QBESEL Estado, Oferta
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_FECHADEFIN,1);
    }

    public void completePedidosConsultaQbeTablaColaborador(String scn, SystemPages page, String file) throws Exception {
        serviceType.typeQbeColaborador( scn, page, null, file, 1, false, true, true );
        //TODO QBESEL Generado, Anulado, Sustituto,Prórroga
        commonServiceClick.sendEnterOnQbeFilter(null,FieldByTagLabelText.QBE_COLABORADOR,1);
        commonService.waitUntilSpinnerIsNotDisplayed();
    }


    public void completeSolicitudDeFechaDeAltaContratoDialog(String scn, SystemPages page, String file) throws Exception {
        serviceDatePicker.pickDateIntroducirFechaAntiguedadDelContrato( scn, page, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, file, 1, false, true, true );
        serviceClick.clickRadRealizandoElTraspasoDeLosContratos( scn, page, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, file, 1, false, true, true );
        serviceClick.clickRadSinTraspasarLosContratos( scn, page, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, file, 1, false, true, true );
    }

    public void rellenaDesgloseCategoriaProfesional(String scn, SystemPages page, String file) throws Exception {
        commonServiceClick.clickTab("Datos de Tarifa");
        jsonFileNew(file);

        String dataSalarial = null;
        String dataExtrasal = null;
        String dataPlusSalarial = null;
        String dataPlusExtrasal = null;
        switch (page) {
            case PEDIDOS__ALTA_LV3233:
                dataSalarial = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getSalarial();
                dataExtrasal = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getExtrasal();
                dataPlusSalarial = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getPlusSalarial();
                dataPlusExtrasal = datos.getPedidosAltaLv3233().getTabDesgloseDeCategoriaProfesional().getTable().getPlusExtraSal();
                break;
            case PEDIDOS__ALTA_INDEFINIDOS:
                dataSalarial = null;
                dataExtrasal = null;
                dataPlusSalarial = null;
                dataPlusExtrasal = null;
                //TODO: @TestDatos
                break;
            case PEDIDOS__ALTA_SIMPLE:
            default:
                dataSalarial = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getSalarial();
                dataExtrasal = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getExtrasal();
                dataPlusSalarial = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusSalarial();
                dataPlusExtrasal = datos.getPedidosAlta().getTabDesgloseDeCategoriaProfesional().getTable().getPlusExtraSal();
                break;
        }

        commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Salarial", 1, 1, dataSalarial, false );
        commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Extrasal.", 1, 1, dataExtrasal, false );
        commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Plus Salarial", 1, 1, dataPlusSalarial, false );
        commonService.typeInputCell( scn, page, PanelTitle.DESGLOSEDECATEGORIAPROFESIONAL, "Plus Extrasal.", 1, 1, dataPlusExtrasal, false );
    }

    public void validateMsgContratosGenerados() throws Exception {
        Thread.sleep(2000);
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento RPD generado correctamente",false, false);
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento Riesgos generado correctamente", false, false);
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CL generado correctamente",false, false);
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente",false, false);
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CPD generado correctamente",true, true);
        System.out.println("PASS: El mensaje indica que todos los documentos se han generado.");
    }

    public void captureNpedidoAndWriteToJsonPedidosConsulta(String file) throws Exception {
        String idPedido = commonService.getValueField(
                PanelTitle.TAB_DATOSDELPEDIDO,
                FieldByTagLabelText.NPEDIDO
        );

        jsonUpdate(file, "PEDIDOS__CONSULTA->nPedido", idPedido);
        jsonUpdate(file, "PEDIDOS__CONSULTA->TABLE_EMPRESA->Nº Pedido", idPedido);

    }

    public void captureNpedidoAndWriteToJsonPedidosLV3233(String file) throws Exception {
        commonService.waitUntilSpinnerIsNotDisplayed();
        commonService.checkMsgErrorIsNotShown(true);

        String idPedido = serviceValidate.waitUntilGetNPedido();

        jsonUpdate(file, "PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->nPedido", idPedido);
    }

    public void waitToAccessPagePedidosModificacion(SystemPages page) throws Exception {
        commonServiceValidate.waitToAccessPage(page);
    }

    public void consultandoEXTERNAL_CPD_ENVIO (String file) throws Exception{
        serviceDataBaseProcedure.consultandoEXTERNAL_CPD_ENVIO(file);
    }

    public void validandoMensajesDeFinalizacionAltaPedido(String scn, SystemPages page, String file, String messageEstadoDePedido, boolean cerrarDialogEstadoPedido, boolean hacerScreenShotEstadoPedido) throws Exception {
        int timeToWait = 120;
        Thread.sleep(6000);

        // Inicializar listas de localizadores esperados y no esperados

        By expectedNotifLocator =  commonService.getLocator(ModalTitle.INFORMACION, null, "Documento RPD generado correctamente", false);
        By expectedDialog1locator = commonService.getLocator(null, PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "", false);
        By expectedDialog2locator = commonService.getLocator(null, PanelTitle.DIALOG_ESTADODEPEDIDO, messageEstadoDePedido, false);

        By notifHasAnotherTextLocator = commonService.getLocator(ModalTitle.INFORMACION, null, "Documento RPD generado correctamente", true); //NOTCONTAINS TRUE
        By unwantedNotifErrorLocator = commonService.getLocator(ModalTitle.ERROR, null, "", false);
        By unwantedNotifAvisoLocator = commonService.getLocator(ModalTitle.AVISO, null, "", false);

        List<By> locatorsExpectedToBeVisible = new ArrayList<>(List.of(
                expectedNotifLocator,
                expectedDialog1locator,
                expectedDialog2locator
        ));

        List<By> locatorsExpectedNotToBeVisible = List.of(
                notifHasAnotherTextLocator,
                unwantedNotifErrorLocator,
                unwantedNotifAvisoLocator
        );

        try {
            System.out.println("---INICIANDO VALIDACION DE MENSAJES FINALES---");
            while (!locatorsExpectedToBeVisible.isEmpty()) {
                List<LocatorCondition> locatorConditions = commonService.createLocatorConditions(locatorsExpectedToBeVisible);
                // Esperar a que alguna condición se cumpla
                By visibleLocator = waitUntilConditionMet(locatorConditions, locatorsExpectedNotToBeVisible, timeToWait);

                // Procesar el localizador visible y eliminarlo de la lista
                if (visibleLocator != null) {
                    if (visibleLocator.equals(expectedNotifLocator)) {
                        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento RPD generado correctamente", false, false);
                        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento Riesgos generado correctamente", false, false);
                        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CL generado correctamente",false, false);

                        switch (page) {
                            case PEDIDOS__ALTA_LV3233:
                                commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente",true, true);
                                break;
                            default:
                                commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CLCB generado correctamente",false, false);
                                commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION,"Documento CPD generado correctamente", true, true);
                                break;
                        }

                        System.out.println("PASS: modal validado");

                        locatorsExpectedToBeVisible.remove(visibleLocator);
                    } else if (visibleLocator.equals(expectedDialog1locator)) {
                        //TODO: click en lupas y descargar pdf
                        System.out.println("PASS: dialogo imprimir validado");
                        commonService.doScreenshot("Dialogo de imprimir documentos");
                        commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
                        locatorsExpectedToBeVisible.remove(visibleLocator);
                    } else if (visibleLocator.equals(expectedDialog2locator)) {
                        if(hacerScreenShotEstadoPedido) {
                            commonService.doScreenshot("Dialogo estado de pedido");
                        }
                        System.out.println("PASS: dialogo mensaje final validado");
                        //Validado mensaje de estado de pedido
                        if(cerrarDialogEstadoPedido) {
                            commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_ESTADODEPEDIDO);
                        }
                        locatorsExpectedToBeVisible.remove(visibleLocator);
                    }
                }
            }
        } catch (AssertionError e) {
            throw new AssertionError("FAIL: Se ha mostrado un mensaje inesperado...", e);
        } catch (Exception e) {
            throw new AssertionError("No se ha mostrado el mensaje esperado transcurridos `" + timeToWait + "` segundos...", e);
        }
    }

    //@PEDIDOS @DATABASE
    /**
     * Este método consulta en base de datos, en la tabla de pedidos, el numero de pedido y lo guarda en el json en los campos donde se hace uso posteriormente.
     * @param file
     * @param guardarEnPEDIDOS__CONSULTA
     * @param guardarEnRIESGOS__BLOQUEADOS
     * @throws Exception
     */
    public void consultarYGuardarNumeroPedido(String file, boolean guardarEnPEDIDOS__ALTA, boolean guardarEnPEDIDOS__ALTA_LV3233, boolean guardarEnPEDIDOS__CONSULTA, boolean guardarEnRIESGOS__BLOQUEADOS) throws Exception {
        this.jsonFile("datosLogin.json");
        String user = loginData.getUser();
        String key = getAuxiliarKey();
        String idPedido = DBQueries.getFieldByQuery("ID_PEDIDO", PedidosQuery.getNumeroDePedido(user,key));
        Assert.assertTrue("FAIL: No se ha obtenido el ID de pedido...",idPedido != null && !idPedido.isEmpty() );
        if (guardarEnPEDIDOS__ALTA) {
            commonService.jsonUpdate(file, "PEDIDOS__ALTA_SIMPLE->TAB_DATOSDELPEDIDO->nPedido", idPedido);
            jsonFileNew(file);
            Assert.assertEquals(datos.getPedidosAlta().getTabDatosDelPedido().getNPedido(), idPedido);
        }
        if (guardarEnPEDIDOS__ALTA_LV3233) {
            commonService.jsonUpdate(file, "PEDIDOS__ALTA_LV3233->TAB_DATOSDELPEDIDO->nPedido", idPedido);
            jsonFileNew(file);
            Assert.assertEquals(datos.getPedidosAltaLv3233().getTabDatosDelPedido().getNPedido(), idPedido);
        }
        if (guardarEnPEDIDOS__CONSULTA) {
            commonService.jsonUpdate(file, "PEDIDOS__CONSULTA->nPedido", idPedido);
            commonService.jsonUpdate(file, "PEDIDOS__CONSULTA->TABLE_EMPRESA->qbe_nPedido", idPedido);
            commonService.jsonUpdate(file, "PEDIDOS__CONSULTA->TABLE_EMPRESA->Nº Pedido", idPedido);
            jsonFileNew(file);
            Assert.assertEquals(datos.getPedidosConsulta().getNPedido(), idPedido);
            Assert.assertEquals(datos.getPedidosConsulta().getTableEmpresa().getQbe_nPedido(), idPedido);
            Assert.assertEquals(datos.getPedidosConsulta().getTableEmpresa().getNPedido(), idPedido);
        }
        if (guardarEnRIESGOS__BLOQUEADOS) {
            commonService.jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->nPedidoDesde", idPedido);
            commonService.jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->nPedidoHasta", idPedido);
            commonService.jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->qbe_nPedido", idPedido);
            commonService.jsonUpdate(file, "RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->Nº Pedido", idPedido);
            jsonFileNew(file);
            Assert.assertEquals(datos.getRiesgosGestionPedidosBloqueados().getNPedidoDesde(),idPedido);
            Assert.assertEquals(datos.getRiesgosGestionPedidosBloqueados().getNPedidoHasta(),idPedido);
            Assert.assertEquals(datos.getRiesgosGestionPedidosBloqueados().getTable().getQbe_nPedido(),idPedido);
            Assert.assertEquals(datos.getRiesgosGestionPedidosBloqueados().getTable().getNPedido(),idPedido);
        }
    }

    public void copiarYGuardarDatosEnPedidosConsulta(String scn, SystemPages page, String file) throws Exception {
        //DATOS EMPRESA PASADOS AL JSON DE CONSULTA
        commonService.readJsonData(file);

        String empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
        String empresaNif = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNIF();
        String cliente = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getNCliente();
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->empresa",empresa);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->empresaClienteRazonSocial",empresa);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->TABLE->qbe_empresa",empresa);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->TABLE->qbe_nif",empresaNif);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->TABLE->Empresa",empresa);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_BUSQUEDADEEMPRESAS->TABLE->N.I.F.",empresaNif);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->TABLE_EMPRESA->qbe_empresa",empresa);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->TABLE_EMPRESA->Empresa",empresa);

        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->nCliente", cliente);

        //DATOS COLABORADOR PASADOS AL JSON DE CONSULTA
        String nombreColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
        String primerApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
        String segundoApellidoColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
        String nifColaborador = datos.getPedidosAlta().getTabDatosColaboradores().getDNI();
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->nombre",nombreColaborador);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->primerApellido", primerApellidoColaborador);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->segundoApellido", segundoApellidoColaborador);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->nIF", nifColaborador);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->qbe_nombreYApellidos",primerApellidoColaborador +" " +segundoApellidoColaborador +", "+nombreColaborador);
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->DIALOG_SELECCIONDECOLABORADORES->TABLE->Nombre y Apellidos",primerApellidoColaborador.toUpperCase() +" " +segundoApellidoColaborador.toUpperCase() +", "+nombreColaborador.toUpperCase());
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->TABLE_COLABORADOR->qbe_colaborador",nombreColaborador + " " +  primerApellidoColaborador +" " +segundoApellidoColaborador );
        commonService.jsonUpdate(file,"PEDIDOS__CONSULTA->TABLE_COLABORADOR->Colaborador",nombreColaborador + " " +  primerApellidoColaborador +" " +segundoApellidoColaborador );
    }

    public void copiarYGuardarDatosEnRiesgosGestionPedidosBloqueados(String scn, SystemPages page, String file) throws Exception {
        //DATOS EMPRESA PASADOS AL JSON DE RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS
        commonService.readJsonData(file);
        String empresa = datos.getPedidosAlta().getTabDatosDelPedido().getDialogSeleccionDeEmpresa().getEmpresa();
        commonService.jsonUpdate(file,"RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->empresa",empresa);
        commonService.jsonUpdate(file,"RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->qbe_empresa",empresa);
        commonService.jsonUpdate(file,"RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS->TABLE->Empresa",empresa);

    }

    /*** VALIDAR MENSAJES ***/

    /**
     * @param scn
     * @param file
     * @throws Exception
     */
    public void validarMensajesFinalesAltaUnColaboradorTraspasadoConExito(String scn, SystemPages page, String file) throws Exception {

        // VALIDAR GROWL
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "", false, false);
        Thread.sleep(20000);
        commonService.doScreenshot("notificacion documentos");
        boolean validarNotificacionDeDocumentos = false; //TODO: @MOCK03 -- validacion notificacion de documentos a imprimir, desactivado pendiente de analizar
        if(validarNotificacionDeDocumentos) {
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false);
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false);
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false);
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarModal();
        }
        System.out.println("PASS: se cierra la notificación de documentos generados");

        //VALIDAR DOCUMENTOS A IMPRIMIR
        commonService.doScreenshot("documentos a imprimir");
        boolean validarDocumentosAImprimir = false; //TODO: @MOCK03 -- validacion de los documentos a imprimir, desactivado pendiente de analizar
        if(validarDocumentosAImprimir) {
//            switch (page) {
//                case PEDIDOS__ALTA_LV3233:
//                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
//                    break;
//                default:
//                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
//                    break;
//            }
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
        }
        System.out.println("PASS: se cierra la notificación de documentos a imprimir");

        //VALIDAR ESTADO DEL PEDIDO
        commonService.doScreenshot("estado del pedido");
        boolean validateDialogEstadoDelPedido = true; //TODO: @MOCK03 -- validacion mensaje estado pedido, activado en principio funciona siempre
        if (validateDialogEstadoDelPedido) {
            commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
            jsonFileNew(file);

            String nombre = null;
            String apellido1 = null;
            String apellido2 = null;

            switch (page) {
                case PEDIDOS__ALTA_LV3233:
                    nombre = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getNombre();
                    apellido1 = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getPrimerApellido();
                    apellido2 = datos.getPedidosAltaLv3233().getTabDatosColaboradores().getSegundoApellido();
                    break;
                case PEDIDOS__ALTA_INDEFINIDOS:
                    //TODO @TestDatos
                    break;
                case PEDIDOS__ALTA_SIMPLE:
                default:
                    nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                    apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                    apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                    break;
            }

            String colaborador = nombre + " " + apellido1 + " " + apellido2;

            boolean convertirAMayusculas = true; //TODO: @MOCK02 -- convierte en mayusculas, analizar cuando usarlo
            //TODO: @MOCK02 el paso siguiente valida que el nombre del colaborador sea el que esperamos, pero aveces sale en
            // mayuscula y aveces en minuscula sin ninguna condicion clara, así que activamos el otro metodo solo para validar el mensaje no el nombre
            if (convertirAMayusculas) {
                colaborador = colaborador.toUpperCase();
                commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado y traspasado con éxito.", file);
            } else {
                commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.", file);
            }

            commonServiceClick.clickBtn(
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    FieldByTagLabelText.BTN_OK,
                    1,
                    true,
                    true
            );
        } else {
            commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);

            commonServiceClick.clickBtn(
                    null,
                    PanelTitle.DIALOG_ESTADODEPEDIDO,
                    FieldByTagLabelText.BTN_OK,
                    1,
                    true,
                    true
            );
        }
        System.out.println("PASS: se cierra el dialogo de estado de pedido");
    }

    /**
     * UPDATED 19/11/24
     * @param scn
     * @param file
     * @throws Exception
     */
    public void validarMensajesFinalesAltaUnColaboradorNoTraspasado(String scn, SystemPages page, String file) throws Exception {

        // VALIDAR GROWL
        commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "", false, false);
        Thread.sleep(20000);
        commonService.doScreenshot("notificacion documentos");
        boolean validarNotificacionDeDocumentos = false; //TODO: @MOCK03 -- validacion notificacion de documentos a imprimir, desactivado pendiente de analizar
        if (validarNotificacionDeDocumentos) {
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento RPD generado correctamente", false, false);
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento Riesgos generado correctamente", false, false);
//            commonServiceValidate.validateGrowlMessage(ModalTitle.INFORMACION, "Documento CL generado correctamente", false, false);
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarModal();
        }
        System.out.println("PASS: se cierra la notificación de documentos generados");

        //VALIDAR DOCUMENTOS A IMPRIMIR
        commonService.doScreenshot("documentos a imprimir");
        boolean validarDocumentosAImprimir = false; //TODO: @MOCK03 -- validacion de los documentos a imprimir, desactivado pendiente de analizar
        if (validarDocumentosAImprimir) {
//            switch (page) {
//                case PEDIDOS__ALTA_LV3233:
//                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
//                    break;
//                default:
//                    commonTask.validateDialogVisible(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRDP", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoRiesgos", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCL", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCLCB", false, file);
//                    commonTask.validateDialogMessage(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR, "DocumentoCPD", true, file);
//                    break;
//            }
        } else {
            CommonServiceClick commonServiceClick = new CommonServiceClick(driver);
            commonServiceClick.clickBtnCerrarDialog(PanelTitle.DIALOG_DOCUMENTOSLISTOSPARAIMPRIMIR);
        }
        System.out.println("PASS: se cierra la notificación de documentos a imprimir");

        //VALIDAR ESTADO DEL PEDIDO

        {
            commonService.doScreenshot("estado del pedido");
            boolean validateDialogEstadoDelPedido = true; //TODO: @MOCK03 -- validacion mensaje estado pedido, activado en principio funciona siempre
            if (validateDialogEstadoDelPedido) {
                commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
                jsonFileNew(file);
                String nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
                String apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
                String apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
                String colaborador = nombre + " " + apellido1 + " " + apellido2;

                boolean convertirAMayusculas = false; //TODO: @MOCK02 -- convierte en mayusculas, analizar cuando usarlo
                //TODO: @MOCK02 el paso siguiente valida que el nombre del colaborador sea el que esperamos, pero aveces sale en
                // mayuscula y aveces en minuscula sin ninguna condicion clara, así que activamos el otro metodo solo para validar el mensaje no el nombre
                if (convertirAMayusculas) {
                    colaborador = colaborador.toUpperCase();
                    commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado con éxito.", file);
                } else {
                    commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador (.*) ha sido generado con éxito.", file);
                }

                commonServiceClick.clickBtn(
                        null,
                        PanelTitle.DIALOG_ESTADODEPEDIDO,
                        FieldByTagLabelText.BTN_OK,
                        1,
                        true,
                        true
                );
            } else {
                commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);

                commonServiceClick.clickBtn(
                        null,
                        PanelTitle.DIALOG_ESTADODEPEDIDO,
                        FieldByTagLabelText.BTN_OK,
                        1,
                        true,
                        true
                );
            }
            System.out.println("PASS: se cierra el dialogo de estado de pedido");
        }

//        switch (page) { //@page
//            case CONTRATOS__BAJA_DAR_DE_BAJA:
//            case CONTRATOS__ANULACION:
//            case CONTRATOS__CONSULTA:
//            case CONTRATOS__TRASPASO_MASIVO:
//            case CONTRATOS__PRORROGAS_ALTA:
//            case CONTRATOS__PRORROGAS_ANULACION:
//            case CONTRATOS__BAJA_CONSULTA:
//            case CONTRATOS__NOVACION_ALTA:
//            case CONTRATOS__PRORROGAS_CONSULTA:
//            case CONTRATOS__ALTA_SUSTITUCION:
//                //@STEP validar mensaje estado de pedido (aqui solo se verifica que diga que se ha generado el contrato, pero no se ha traspasado)
//            {
//                commonService.doScreenshot("estado del pedido");
//                boolean validateDialogEstadoDelPedido = true; //TODO: @MOCK03 -- validacion mensaje estado pedido, activado en principio funciona siempre
//                if (validateDialogEstadoDelPedido) {
//                    commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
//                    jsonFileNew(file);
//                    String nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
//                    String apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
//                    String apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
//                    String colaborador = nombre + " " + apellido1 + " " + apellido2;
//
//                    boolean convertirAMayusculas = false; //TODO: @MOCK02 -- convierte en mayusculas, analizar cuando usarlo
//                    //TODO: @MOCK02 el paso siguiente valida que el nombre del colaborador sea el que esperamos, pero aveces sale en
//                    // mayuscula y aveces en minuscula sin ninguna condicion clara, así que activamos el otro metodo solo para validar el mensaje no el nombre
//                    if (convertirAMayusculas) {
//                        colaborador = colaborador.toUpperCase();
//                        commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado con éxito.", file);
//                    } else {
//                        commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador (.*) ha sido generado con éxito.", file);
//                    }
//
//                    commonServiceClick.clickBtn(
//                            null,
//                            PanelTitle.DIALOG_ESTADODEPEDIDO,
//                            FieldByTagLabelText.BTN_OK,
//                            1,
//                            true,
//                            true
//                    );
//                } else {
//                    commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
//
//                    commonServiceClick.clickBtn(
//                            null,
//                            PanelTitle.DIALOG_ESTADODEPEDIDO,
//                            FieldByTagLabelText.BTN_OK,
//                            1,
//                            true,
//                            true
//                    );
//                }
//                System.out.println("PASS: se cierra el dialogo de estado de pedido");
//            }
//            break;
//            default:
//                //@STEP validar mensaje estado de pedido (aqui se valida que el mensaje diga que se ha generado el contrato y se ha traspasado)
//            {
//                commonService.doScreenshot("estado del pedido");
//                boolean validateDialogEstadoDelPedido = true; //TODO: @MOCK03 -- validacion mensaje estado pedido, activado en principio funciona siempre
//                if (validateDialogEstadoDelPedido) {
//                    commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
//                    jsonFileNew(file);
//                    String nombre = datos.getPedidosAlta().getTabDatosColaboradores().getNombre();
//                    String apellido1 = datos.getPedidosAlta().getTabDatosColaboradores().getPrimerApellido();
//                    String apellido2 = datos.getPedidosAlta().getTabDatosColaboradores().getSegundoApellido();
//                    String colaborador = nombre + " " + apellido1 + " " + apellido2;
//
//                    boolean convertirAMayusculas = true; //TODO: @MOCK02 -- convierte en mayusculas, analizar cuando usarlo
//                    //TODO: @MOCK02 el paso siguiente valida que el nombre del colaborador sea el que esperamos, pero aveces sale en
//                    // mayuscula y aveces en minuscula sin ninguna condicion clara, así que activamos el otro metodo solo para validar el mensaje no el nombre
//                    if (convertirAMayusculas) {
//                        colaborador = colaborador.toUpperCase();
//                        commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador " + colaborador + " ha sido generado y traspasado con éxito.", file);
//                    } else {
//                        commonServiceValidate.validateDialogMessage(PanelTitle.DIALOG_ESTADODEPEDIDO, "El contrato para el colaborador (.*) ha sido generado y traspasado con éxito.", file);
//                    }
//
//                    commonServiceClick.clickBtn(
//                            null,
//                            PanelTitle.DIALOG_ESTADODEPEDIDO,
//                            FieldByTagLabelText.BTN_OK,
//                            1,
//                            true,
//                            true
//                    );
//                } else {
//                    commonServiceValidate.validateDialogVisible(PanelTitle.DIALOG_ESTADODEPEDIDO);
//
//                    commonServiceClick.clickBtn(
//                            null,
//                            PanelTitle.DIALOG_ESTADODEPEDIDO,
//                            FieldByTagLabelText.BTN_OK,
//                            1,
//                            true,
//                            true
//                    );
//                }
//                System.out.println("PASS: se cierra el dialogo de estado de pedido");
//            }
//            break;
//        }
    }



}
