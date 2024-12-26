package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionCentroDeTrabajoQuery;
import com.eulen.flexinet.core.test.selenium.database.PedidosQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import com.eulen.flexinet.core.test.selenium.reader.JsonUpdater;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class PedidosServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public PedidosServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void consultandoEXTERNAL_CPD_ENVIO(String file) throws Exception {
        System.out.println("------------EJECUTANDO CONSULTA A LA TABLA EXTERNAL_CPD_ENVIO----------------");

        jsonFileNew(file);
        String idPedidoJson = datos.getPedidosAlta().getTabDatosDelPedido().getNPedido(); //TODO: comprobar si es aqui donde se guarda el n pedido
        String query = PedidosQuery.getConsultaEXTERNAL_CPD_ENVIO(idPedidoJson);
        System.out.println("CONSULTA:`" + query + "`");
        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(
                query
        );

        String cdStatus;
        if(!rows.isEmpty()) {
            System.out.println("INFO: Se han encontrado " + rows.size()+ " registros");
            cdStatus = rows.get(0).get("CD_STATUS").toString();
            Assert.assertEquals("ERP_SEND_DISCARD", cdStatus);
            System.out.println("PASS: CD_STATUS = ERP_SEND_DISCARD");
        } else {
            throw new AssertionError("FAIL: No hay registros con el ID_PEDIDO " + idPedidoJson);
        }

    }



}
