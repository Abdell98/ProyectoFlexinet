package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.database.ContratosQuery;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class GeneracionMasivaServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GeneracionMasivaServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void consultandoID_CONTRATO(String file, String scn) throws Exception {
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA EXTERNAL_CPD_ENVIO----------------");
        String fileAux;
        {
            fileAux = file.replace(".json", "");
            fileAux = fileAux + "_AltaSimple" + ".json";
        }
        jsonFileNew(fileAux);
        String idPedidoJson = datos.getPedidosConsulta().getNPedido(); //TODO: comprobar si es aqui donde se guarda el n pedido

        String query = ContratosQuery.getConsultaID_CONTRATO(idPedidoJson);
        System.out.printf("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );
        String cdIdContrato;
        switch (scn) {
            case "Flexinet-19822":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19750":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__TRASPASO_MASIVO->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
            case "Flexinet19896":
                if (!rows.isEmpty()) {
                    System.out.println("INFO: Se han encontrado " + rows.size() + "registros");
                    cdIdContrato = rows.get(0).get("ID_CON").toString();
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__BAJA_DARDEBAJA->TABLE->Nº Contrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->nContrato", cdIdContrato);
                    commonService.jsonUpdate(file, "CONTRATOS__CONSULTA->TABLE->Nº Contrato", cdIdContrato);
                } else {
                    throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
                }
                break;
        }
    }
}
