package com.eulen.flexinet.core.test.selenium.Pom.service;

import com.eulen.flexinet.core.test.selenium.Locators.HomePageLocators;
import com.eulen.flexinet.core.test.selenium.Locators.PageLocators;
import com.eulen.flexinet.core.test.selenium.database.DBQueries;
import com.eulen.flexinet.core.test.selenium.database.GestionEmpresaClienteQuery;
import com.eulen.flexinet.core.test.selenium.pages.BasePage;
import com.eulen.flexinet.core.test.selenium.pages.SystemPages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class GestionITsServiceDataBaseProcedure extends BasePage {

    private PageLocators pageLocators;
    private HomePageLocators homePageLocators;
    private CommonService commonService;

    public GestionITsServiceDataBaseProcedure(WebDriver driver) {
        super(driver);
        pageLocators = new PageLocators(driver);
        homePageLocators = new HomePageLocators(driver);
        commonService = new CommonService(driver);
    }

    public void validarEmpresaEnEMPTIPOFA(String scn, SystemPages page, String file) throws Exception {
        System.out.println("------------VALIDAR-EMPRESA-TABLA--EMP_TIPOFA-----------------");
        System.out.println("Consultamos la tabla para ver que existe un registro del nif de la empresa...");

        jsonFileNew(file);
        String nif = datosGestionDeEmpresaCliente.getGestionDeEmpresaClienteModificar().getTabDatosRiesgos().getLkp_cif();

        List<Map<String, Object>> rows = DBQueries.getAllFieldsByQuery(GestionEmpresaClienteQuery.getEmpTipoFaBy(nif));

        Assert.assertFalse("FAIL: No hay registros de la empresa`"+nif+"` en la tabla EMP_TIPOFA", rows.isEmpty());
    }
}
