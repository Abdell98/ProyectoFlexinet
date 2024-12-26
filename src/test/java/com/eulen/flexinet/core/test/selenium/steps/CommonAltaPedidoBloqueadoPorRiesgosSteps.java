package com.eulen.flexinet.core.test.selenium.steps;

import com.eulen.flexinet.core.test.selenium.Locators.FieldByTagLabelText;
import com.eulen.flexinet.core.test.selenium.Locators.PanelTitle;
import com.eulen.flexinet.core.test.selenium.Pom.service.ContratosServiceDataBaseProcedure;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.steps.util.Environments;
import com.eulen.flexinet.core.test.selenium.steps.util.Hooks;
import com.eulen.flexinet.core.test.selenium.steps.util.TestBase;
import io.cucumber.java.en.Given;

public class CommonAltaPedidoBloqueadoPorRiesgosSteps extends TestBase {

    @Given("^un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente traspasado (.*),(.*),(.*),(.*)$")
    public void unPedidoInicialmenteBloqueadoPorRiesgosLuegoDesbloqueadoYFinalmenteTraspasado(String scn, SystemPages page, String file, String oficina) throws Exception {
        //INFO: Para este step el json debe tener por lo menos PEDIDOS_ALTA_SIMPLE,RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS,PEDIDOS__CONSULTA,PEDIDOS__MODIFICACION
        // - Si el pedido se usará en Partes de Horas también tiene que tener al menos PARTES_DE_HORAS__ALTA
        // - Si el pedido se usará en Contratos también tiene que tener al menos CONTRATO
        //IMPORTANTE: este step, guarda el npedido en PEDIDOS_ALTA y luego obtiene y guarda el id contrato en PARTES_DE_HORAS__ALTA, tambien guarda el num contrato
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

        //@STEP aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta, tambien guarda en el json el n pedido y los datos en el json
        {
            boolean validaDialogoBloqueadoPorRiesgos = true; //@MOCK
            if(Hooks.getEnv().equals(Environments.UAT)) {
                if (validaDialogoBloqueadoPorRiesgos) {
                    commonTask.validateDialogMessage(
                            PanelTitle.DIALOG_ESTADODEPEDIDO,
                            "El pedido con ID (.*) ha sido bloqueado por Riesgos",
                            false,
                            file
                    );
                }
            }else {
                if (validaDialogoBloqueadoPorRiesgos) {
                    commonTask.validateDialogMessage(
                            null,
                            "El pedido ha sido autorizado por Riesgos",
                            false,
                            file
                    );
                }
            }
        }

        //@STEP se guardar el numero de pedido en el json, en alta, consulta y en riesgos pedidos bloqueados
        {
            //INFO: Se consulta en base de datos el numero de pedido y se copian los datos de colaborador, empresa etc al json en sus objetos correspondientes
            //luego se hace click en ok para cerrar el dialogo y confirmamos que nos ha llevado auntomaticamente a la página de consulta.
            pedidosTask.consultarYGuardarNumeroPedido(file, true, false, true, true);
            pedidosTask.copiarYGuardarDatosEnPedidosConsulta(scn, page, file);
            pedidosTask.copiarYGuardarDatosEnRiesgosGestionPedidosBloqueados(scn, page, file);
            commonTask.clickBtn(FieldByTagLabelText.BTN_OK, null, PanelTitle.DIALOG_ESTADODEPEDIDO, true, true);
            commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
        }

        //@STEP se dirige al menu riesgos, gestion de pedidos bloqueados, donde busca y desbloquea el registro
        {
            navigationService.navigateToSubPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS, oficina, scn);
            commonTask.waitToAccessPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS);
            riesgosTask.completeGestionPedidosBloqueadosSearchForm(scn, SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS, file);
            commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
            commonTask.doScreenshot("RECORD TO UNBLOCK");
            riesgosTask.selectRecordFoundOnGestionPedidosBloqueadosTable(scn, page, file);
        }

        //@STEP se dirige a la pagina pedidos consulta y busca el pedido por su numero
        {
            navigationService.navigateToSubPage(SystemPages.PEDIDOS__CONSULTA,oficina,scn);
            commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
            pedidosTask.completePedidosConsultaSearchForm(scn,SystemPages.PEDIDOS__CONSULTA,file);
            commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
            commonTask.clickFirstValidRowResultOnTable(scn,SystemPages.PEDIDOS__CONSULTA,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA",1,false);
        }

        //@STEP hace click en Modificar
        {
            commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAR, null, null, true, false);
        }

        //@STEP es redirigido a la página de modificación de pedidos donde hace click en Generar Contratos
        {
            commonTask.waitToAccessPage(SystemPages.PEDIDOS__MODIFICACION);
            commonTask.clickBtnGenerarContratos();
        }

        //IMPORTANTE: dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
        //@STEP en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato
        {
            pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, SystemPages.PEDIDOS__MODIFICACION, file);
        }

        //@STEP hace click en Si
        {
            //INFO: IMPORTANTE!!! dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
            commonTask.clickBtn(FieldByTagLabelText.BTN_SI,null,PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO,true,false);
        }

        //@STEP aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato
        {
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
                case CONTRATOS__NOVACION_ALTA:
                    ContratosServiceDataBaseProcedure con = new ContratosServiceDataBaseProcedure(driver);
                    con.consultandoID_CONTRATODePedidosAltaYCopiarDatosProrrogasConsulta(scn, page, pagePedidoAltaSimple, file);
                    break;
                case CONTRATOS__ALTA_SUSTITUCION:
                    contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
                    break;
                case PARTES_DE_HORAS__ALTA:
                case PARTES_DE_HORAS__TRASPASO:
                case PARTES_DE_HORAS__CONSULTA:
                case PARTES_DE_HORAS__MODIFICACION:
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasAlta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasConsulta(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasModificacion(file, pagePedidoAltaSimple);
                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(file, pagePedidoAltaSimple);
                    break;
            }
        }
    }

    //TODO Borrar si no se usa
//
//    @Given("^un pedido de alta simple inicialmente bloqueado por riesgos, luego desbloqueado y finalmente NO ES traspasado (.*),(.*),(.*),(.*)$")
//    public void unPedidoInicialmenteBloqueadoPorRiesgosLuegoDesbloqueadoYFinalmenteNOESTraspasado(String scn, SystemPages page, String file, String oficina) throws Exception {
//        //INFO: Para este step el json debe tener por lo menos PEDIDOS_ALTA_SIMPLE,RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS,PEDIDOS__CONSULTA,PEDIDOS__MODIFICACION
//        // - Si el pedido se usará en Partes de Horas también tiene que tener al menos PARTES_DE_HORAS__ALTA
//        // - Si el pedido se usará en Contratos también tiene que tener al menos CONTRATO
//        //IMPORTANTE: este step, guarda el npedido en PEDIDOS_ALTA y luego obtiene y guarda el id contrato en PARTES_DE_HORAS__ALTA, tambien guarda el num contrato
//        SystemPages pagePedidoAltaSimple = SystemPages.PEDIDOS__ALTA_SIMPLE;
//
//        //@STEP entra a flexinet, navega a la página de alta simple selecciona empresa rellena campos y le da a finalizar
//        {
//            System.out.println("@DEBUG 1 colaborador");
//            navigationService.navigateToSubPage(pagePedidoAltaSimple, oficina, scn);
//            pedidosTask.clickBtnBuscarEmpresa();
//            pedidosTask.waitToDialogSeleccionEmpresaIsVisible();
//            pedidosTask.searchFieldsOnDialogSeleccionEmpresa(scn, pagePedidoAltaSimple, file);
//            pedidosTask.selectRecordFoundOnDialogSeleccionEmpresaTable(scn, pagePedidoAltaSimple, file);
//            pedidosTask.clickBtnAsociarAEmpresa();
//            pedidosTask.completeFields(scn, pagePedidoAltaSimple, file, false, false);
//            commonTask.clickBtn(FieldByTagLabelText.BTN_FINALIZAR, null, null, true, true);
//        }
//
//        //@STEP aparece un mensaje indicando que el pedido ha sido bloqueado por riesgos y es llevado a la pagina de consulta, tambien guarda en el json el n pedido y los datos en el json
//        {
//            boolean validaDialogoBloqueadoPorRiesgos = true; //@MOCK
//            if(Hooks.getEnv().equals(Environments.UAT)) {
//                if (validaDialogoBloqueadoPorRiesgos) {
//                    commonTask.validateDialogMessage(
//                            PanelTitle.DIALOG_ESTADODEPEDIDO,
//                            "El pedido con ID (.*) ha sido bloqueado por Riesgos",
//                            false,
//                            file
//                    );
//                }
//            }else {
//                if (validaDialogoBloqueadoPorRiesgos) {
//                    commonTask.validateDialogMessage(
//                            null,
//                            "El pedido ha sido autorizado por Riesgos",
//                            false,
//                            file
//                    );
//                }
//            }
//        }
//
//        //@STEP se guardar el numero de pedido en el json, en alta, consulta y en riesgos pedidos bloqueados
//        {
//            //INFO: Se consulta en base de datos el numero de pedido y se copian los datos de colaborador, empresa etc al json en sus objetos correspondientes
//            //luego se hace click en ok para cerrar el dialogo y confirmamos que nos ha llevado auntomaticamente a la página de consulta.
//            pedidosTask.consultarYGuardarNumeroPedido(file, true, false, true, true);
//            pedidosTask.copiarYGuardarDatosEnPedidosConsulta(scn, page, file);
//            pedidosTask.copiarYGuardarDatosEnRiesgosGestionPedidosBloqueados(scn, page, file);
//            commonTask.clickBtn(FieldByTagLabelText.BTN_OK, null, PanelTitle.DIALOG_ESTADODEPEDIDO, true, true);
//            commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
//        }
//
//        //@STEP se dirige al menu riesgos, gestion de pedidos bloqueados, donde busca y desbloquea el registro
//        {
//            navigationService.navigateToSubPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS, oficina, scn);
//            commonTask.waitToAccessPage(SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS);
//            riesgosTask.completeGestionPedidosBloqueadosSearchForm(scn, SystemPages.RIESGOS__GESTION_DE_PEDIDOS_BLOQUEADOS, file);
//            commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR, null, null, true, true);
//            commonTask.doScreenshot("RECORD TO UNBLOCK");
//            riesgosTask.selectRecordFoundOnGestionPedidosBloqueadosTable(scn, page, file);
//        }
//
//        //@STEP se dirige a la pagina pedidos consulta y busca el pedido por su numero
//        {
//            navigationService.navigateToSubPage(SystemPages.PEDIDOS__CONSULTA,oficina,scn);
//            commonTask.waitToAccessPage(SystemPages.PEDIDOS__CONSULTA);
//            pedidosTask.completePedidosConsultaSearchForm(scn,SystemPages.PEDIDOS__CONSULTA,file);
//            commonTask.clickBtn(FieldByTagLabelText.BTN_BUSCAR,null,null,true,true);
//            commonTask.clickFirstValidRowResultOnTable(scn,SystemPages.PEDIDOS__CONSULTA,null,file,"TestDatos->PEDIDOS__CONSULTA->TABLE_EMPRESA",1,false);
//        }
//
//        //@STEP hace click en Modificar
//        {
//            commonTask.clickBtn(FieldByTagLabelText.BTN_MODIFICAR, null, null, true, false);
//        }
//
//        //@STEP es redirigido a la página de modificación de pedidos donde hace click en Generar Contratos
//        {
//            commonTask.waitToAccessPage(SystemPages.PEDIDOS__MODIFICACION);
//            commonTask.clickBtnGenerarContratos();
//        }
//
//        //IMPORTANTE: dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
//        //@STEP en la página de modificacion, aparece un dialogo indicando que el pedido se ha realizado con exito y pregunta si generar contratos de los colaboradores y la fecha de antiguedad del contrato
//        {
//            pedidosTask.completeSolicitudDeFechaDeAltaContratoDialog(scn, SystemPages.PEDIDOS__MODIFICACION, file);
//        }
//
//        //@STEP hace click en Si
//        {
//            //INFO: IMPORTANTE!!! dado que este step va de que SI debe traspasarse el contrato, debemos indicar en el json que SI traspase  "rad_RealizandoElTraspasoDeLosContratos": "true",
//            commonTask.clickBtn(FieldByTagLabelText.BTN_SI,null,PanelTitle.DIALOG_SOLICITUDDEFECHADEALTADELCONTRATO,true,false);
//        }
//
//        //@STEP aparece una notificacion, un dialogo indicando que los documentos están listos para imprimir y un dialogo informando generacion y traspaso el contrato
//        {
//            pedidosTask.validarMensajesFinalesAltaUnColaboradorNoTraspasado(scn, page, file);
//        }
//
//        //@STEP se consulta el id de contrato y se guardan los datos en el json
//        {
//            switch (page) { //@page
//                case CONTRATOS__BAJA_DAR_DE_BAJA:
//                case CONTRATOS__ANULACION:
//                case CONTRATOS__CONSULTA:
//                case CONTRATOS__BAJA_BAJAS_MASIVAS:
//                case CONTRATOS__TRASPASO_MASIVO:
//                case CONTRATOS__PRORROGAS_ALTA:
//                case CONTRATOS__PRORROGAS_ANULACION:
//                case CONTRATOS__BAJA_CONSULTA:
//                case CONTRATOS__NOVACION_ALTA:
//                case CONTRATOS__PRORROGAS_CONSULTA:
//                case CONTRATOS__ALTA_SUSTITUCION:
//                    contratosTask.consultarIdDelContratoDelIdDePedidoGenerado(scn, page, file);
//                    break;
//                case PARTES_DE_HORAS__ALTA:
//                case PARTES_DE_HORAS__TRASPASO:
//                case PARTES_DE_HORAS__CONSULTA:
//                case PARTES_DE_HORAS__MODIFICACION:
//                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasAlta(file, pagePedidoAltaSimple);
//                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasConsulta(file, pagePedidoAltaSimple);
//                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasModificacion(file, pagePedidoAltaSimple);
//                    partesDeHorasTask.copiarYGuardarDatosEnPartesDeHorasEnvioPartesAOracle(file, pagePedidoAltaSimple);
//                    break;
//            }
//        }
//    }
//

}
