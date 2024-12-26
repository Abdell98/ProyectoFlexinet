package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.ModalTitle;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.ContratosServiceDataBaseProcedure;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.Given;

public class CommonAltaPedidoAutorizadoPorRiesgosSteps extends TestBase {

    @Given("^un pedido autorizado y traspasado de alta simple (.*),(.*),(.*),(.*)$")
    public void unPedidoAutorizadoYTraspasadoDeAltaSimple(String scn, SystemPages page, String file, String oficina) throws Exception {
        //INFO: Para este step el json debe tener por lo menos PEDIDOS_ALTA_SIMPLE


        //IMPORTANTE: este step, guarda el npedido en PEDIDOS_ALTA y luego obtiene y guarda el id contrato en PARTES_DE_HORAS__ALTA
        SystemPages pagePedidoAltaSimple = SystemPages.PEDIDOS__ALTA_SIMPLE;

        //@STEP entra a flexinet, navega a la página de alta simple selecciona empresa rellena campos y le da a finalizar
        {
            System.out.println("@DEBUG 1 colaborador");
            navigationService.navigateToSubPage(pagePedidoAltaSimple, oficina, scn);
            pedidosTask.clickBtnBuscarEmpresa();
            pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
            pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, pagePedidoAltaSimple, file);
            pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn, pagePedidoAltaSimple, file);
            pedidosTask.clickBtnAsociarAEmpresa();
            pedidosTask.completeFields(scn, pagePedidoAltaSimple, file, false, false);
            commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        }

        //STEP Se valida la notificación que indica que ha sido autorizado por riesgos
        {
            boolean validarNotificacionAutorizadoPorRiesgos = true; //@MOCK
            if (validarNotificacionAutorizadoPorRiesgos) {
                commonTask.validateGrowlMessage(
                        ModalTitle.CORRECTO,
                        "El pedido ha sido autorizado por Riesgos",
                        true,
                        true,
                        true
                );
            }
        }

        //@SREP se guarda el numero de pedido en el json, en altas
        {
            pedidosTask.consultarYGuardarNumeroPedido(file, true, false, false, false);
        }

        //IMPORTANTE: dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
        //@STEP en la página de alta, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato
        {
            pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, pagePedidoAltaSimple, file);
        }

        //@STEP hace click en Si
        {
            commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        }

        //@STEP aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato
        {
            //TODO revisarlo con verusca
            pedidosTask.validarMensajesFinalesAltaUnColaboradorTraspasadoConExito(scn, page, file);
        }

        //@STEP se consulta el id de contrato y se guardan los datos en el json
        {
            switch (page) { //@page
                case CONTRATOS__BAJA_DAR_DE_BAJA:
                case CONTRATOS__ANULACION:
                case CONTRATOS__CONSULTA:
                case CONTRATOS__BAJA_BAJAS_MASIVAS:
                case CONTRATOS__TRASPASO_MASIVO:
                case CONTRATOS__PRORROGAS_ALTA:
                case CONTRATOS__PRORROGAS_CONSULTA:
                case CONTRATOS__PRORROGAS_ANULACION:
                case CONTRATOS__BAJA_CONSULTA:
                case CONTRATOS__NOVACION_ALTA:{
                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn,page, pagePedidoAltaSimple, file);
                    break;
                }
                case CONTRATOS__ALTA_SUSTITUCION:
                    contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
                    break;
                //TODO eliminar, si comprobamos que no tiene impacto, no debería dado que es lo mismo que en el case anterior
//                case CONTRATOS__PRORROGAS_CONSULTA:{
//                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
//                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaSimple, file);
//                    break;
//                }
                case PARTES_DE_HORAS__ALTA:
                case PARTES_DE_HORAS__TRASPASO:
                case PARTES_DE_HORAS__CONSULTA:
                case PARTES_DE_HORAS__MODIFICACION:
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasAlta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasConsulta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasModificacion(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasTraspaso(file, pagePedidoAltaSimple);
                    if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
                        partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(file, pagePedidoAltaSimple);
                    }
                    break;
            }
        }
    }

    @Given("^un pedido autorizado y NO traspasado de alta simple (.*),(.*),(.*),(.*)$")
    public void unPedidoAutorizadoYNOTraspasadoDeAltaSimple(String scn, SystemPages page, String file, String oficina) throws Exception {
        //INFO: Para este step el json debe tener por lo menos PEDIDOS_ALTA_SIMPLE


        //IMPORTANTE: este step, guarda el npedido en PEDIDOS_ALTA y luego obtiene y guarda el id contrato en PARTES_DE_HORAS__ALTA
        SystemPages pagePedidoAltaSimple = SystemPages.PEDIDOS__ALTA_SIMPLE;

        //@STEP entra a flexinet, navega a la página de alta simple selecciona empresa rellena campos y le da a finalizar
        {
            System.out.println("@DEBUG 1 colaborador");
            navigationService.navigateToSubPage(pagePedidoAltaSimple, oficina, scn);
            pedidosTask.clickBtnBuscarEmpresa();
            pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
            pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, pagePedidoAltaSimple, file);
            pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn, pagePedidoAltaSimple, file);
            pedidosTask.clickBtnAsociarAEmpresa();
            pedidosTask.completeFields(scn, pagePedidoAltaSimple, file, false, false);
            commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        }

        //STEP Se valida la notificación que indica que ha sido autorizado por riesgos
        {
            boolean validarNotificacionAutorizadoPorRiesgos = true; //@MOCK
            if (validarNotificacionAutorizadoPorRiesgos) {
                commonTask.validateGrowlMessage(
                        ModalTitle.CORRECTO,
                        "El pedido ha sido autorizado por Riesgos",
                        true,
                        true,
                        true
                );
            }
        }

        //@SREP se guarda el numero de pedido en el json, en altas
        {
            pedidosTask.consultarYGuardarNumeroPedido(file, true, false, false, false);
        }

        //IMPORTANTE: dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
        //@STEP en la página de alta, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato
        {
            pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, pagePedidoAltaSimple, file);
        }

        //@STEP hace click en Si
        {
            commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        }

        //@STEP aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato
        {
            pedidosTask.validarMensajesFinalesAltaUnColaboradorNoTraspasado(scn, page, file);
        }

        //@STEP se consulta el id de contrato y se guardan los datos en el json
        {
            switch (page) { //@page
                case CONTRATOS__BAJA_DAR_DE_BAJA:
                case CONTRATOS__ANULACION:
                case CONTRATOS__CONSULTA:
                case CONTRATOS__BAJA_BAJAS_MASIVAS:
                case CONTRATOS__TRASPASO_MASIVO:
                case CONTRATOS__PRORROGAS_ALTA:
                case CONTRATOS__PRORROGAS_CONSULTA:
                case CONTRATOS__PRORROGAS_ANULACION:
                case CONTRATOS__BAJA_CONSULTA:
                case CONTRATOS__NOVACION_ALTA:{
                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaSimple, file);
                    break;
                }
                case CONTRATOS__ALTA_SUSTITUCION:
                    contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
                    break;
                //TODO eliminar, si comprobamos que no tiene impacto, no debería dado que es lo mismo que en el case anterior
//                case CONTRATOS__PRORROGAS_CONSULTA:{
//                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
//                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaSimple, file);
//                    break;}
                case PARTES_DE_HORAS__ALTA:
                case PARTES_DE_HORAS__TRASPASO:
                case PARTES_DE_HORAS__CONSULTA:
                case PARTES_DE_HORAS__MODIFICACION:
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasAlta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasConsulta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasModificacion(file, pagePedidoAltaSimple);
                    if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
                        partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(file, pagePedidoAltaSimple);
                    }
                    break;
            }
        }
    }

    @Given("^un pedido autorizado y traspasado LV3233 (.*),(.*),(.*),(.*)$")
    public void unPedidoAutorizadoYTraspasadoLV3233(String scn, SystemPages page, String file, String oficina) throws Exception {
        //INFO: Para este step el json debe tener por lo menos PEDIDOS_ALTA_SIMPLE


        //IMPORTANTE: este step, guarda el npedido en PEDIDOS_ALTA y luego obtiene y guarda el id contrato en PARTES_DE_HORAS__ALTA
        SystemPages pagePedidoAltaLV3233 = SystemPages.PEDIDOS__ALTA_LV3233;

        //@STEP entra a flexinet, navega a la página de alta simple selecciona empresa rellena campos y le da a finalizar
        {
            System.out.println("@DEBUG 1 colaborador");
            navigationService.navigateToSubPage(pagePedidoAltaLV3233, oficina, scn);
            switch (pagePedidoAltaLV3233) {
                case PEDIDOS__ALTA_LV3233:
                    //INFO: Este mensaje sale siempre, nos comenta roberto que en producción tambien sale
                    //INFO: EN uat 17/09/2024 ya no sale, cambio valor a false
                    boolean esperarMensaje = true; //@MOCK01 -- true para pre y false para uat salvo que cambie algo
                    if (esperarMensaje) {
                        commonTask.validateGrowlMessage(ModalTitle.INFORMACION, "No se ha podido obtener el listado de bonificaciones.", true, true, true);
                    }
                    commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, false);
                    break;
                default:
                    commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAREMPRESA, PanelTitle.TAB_DATOSDELPEDIDO, null, true, true);
                    break;
            }

            pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
            pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, pagePedidoAltaLV3233, file);
            pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn, pagePedidoAltaLV3233, file);
            pedidosTask.clickBtnAsociarAEmpresa();
            pedidosTask.completeFields(scn, pagePedidoAltaLV3233, file, false, false);
            commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
        }

        //@STEP Se valida la notificación que indica que ha sido autorizado por riesgos
        {
            boolean validarNotificacionAutorizadoPorRiesgos = true; //@MOCK
            if (validarNotificacionAutorizadoPorRiesgos) {
                commonTask.validateGrowlMessage(
                        ModalTitle.CORRECTO,
                        "El pedido ha sido autorizado por Riesgos",
                        true,
                        true,
                        true
                );
            }
        }

        //@STEP se guarda el numero de pedido en el json, en altas
        {
            pedidosTask.consultarYGuardarNumeroPedido(file, false, true,false, false);
        }

        //IMPORTANTE: dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
        //@STEP en la página de alta, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato
        {
            pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, pagePedidoAltaLV3233, file);
        }

        //@STEP hace click en Si
        {
            commonTask.clickBtn(FieldByTagLabelText.BTN_SI, null, PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO, true, false);
        }

        //@STEP aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato
        {
            pedidosTask.validarMensajesFinalesAltaUnColaboradorTraspasadoConExito(scn, pagePedidoAltaLV3233, file);
        }

        //@STEP se consulta el id de contrato y se guardan los datos en el json
        {
            switch (page) { //@page
                case CONTRATOS__BAJA_DAR_DE_BAJA:
                case CONTRATOS__ANULACION:
                case CONTRATOS__CONSULTA:
                case CONTRATOS__BAJA_BAJAS_MASIVAS:
                case CONTRATOS__TRASPASO_MASIVO:
                case CONTRATOS__PRORROGAS_ALTA:
                case CONTRATOS__PRORROGAS_CONSULTA:
                case CONTRATOS__PRORROGAS_ANULACION:
                case CONTRATOS__BAJA_CONSULTA:
                case CONTRATOS__NOVACION_ALTA:
                {
                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaLV3233, file);
                    break;
                }
                case CONTRATOS__ALTA_SUSTITUCION:
                    contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
                    break;
                    //TODO eliminar, si comprobamos que no tiene impacto, no debería dado que es lo mismo que en el case anterior
//                case CONTRATOS__PRORROGAS_CONSULTA:{
//                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
//                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaLV3233, file);
//                    break;}
                case PARTES_DE_HORAS__ALTA:
                case PARTES_DE_HORAS__TRASPASO:
                case PARTES_DE_HORAS__CONSULTA:
                case PARTES_DE_HORAS__MODIFICACION:
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasAlta(file, pagePedidoAltaLV3233);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasConsulta(file, pagePedidoAltaLV3233);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasModificacion(file, pagePedidoAltaLV3233);
                    if(Hooks.getEnv().equals(Environments.UAT)) { //@SHERPA
                        partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(file, pagePedidoAltaLV3233);
                    }
                    break;
            }
        }

    }

}
