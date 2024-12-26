package com.eulen.flexinet.core.test.selenium.steps.util;

import com.eulen.flexinet.core.test.selenium.Pom.Task.*;
import com.eulen.flexinet.core.test.selenium.Pom.service.CommonServiceClick;
import com.eulen.flexinet.core.test.selenium.Pom.service.ContratosServiceDataBaseProcedure;
import com.eulen.flexinet.core.test.selenium.Pom.service.ContratosServiceType;
import com.eulen.flexinet.core.test.selenium.Pom.service.PedidosServiceType;
import com.eulen.flexinet.core.test.selenium.Pom.service.util.NavigationService;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = Hooks.getSerenityDriver();
//    protected LoginPageTask loginPageTask = new LoginPageTask(driver);
//    protected HomePageTask homePageTask = new HomePageTask(driver);
    protected NavigationService navigationService = new NavigationService(driver);
    protected GestionEmpresasClienteTask gestionEmpresasClienteTask = new GestionEmpresasClienteTask(driver);
    protected GestionClientesContratoTask gestionClientesContratoTask = new GestionClientesContratoTask(driver);
    protected GestionCentrosDeTrabajoTask gestionCentrosDeTrabajoTask = new GestionCentrosDeTrabajoTask(driver);
    protected PedidosTask pedidosTask = new PedidosTask(driver);
    protected PartesDeHorasTask partesDeHorasTask = new PartesDeHorasTask(driver);
    protected ContratosTask contratosTask = new ContratosTask(driver);
    protected FacturacionTask facturacionTask = new FacturacionTask(driver);
    protected RiesgosTask riesgosTask = new RiesgosTask(driver);
    protected GeneracionMasivaPartesTask generacionMasivaPartesTask = new GeneracionMasivaPartesTask(driver);
    protected GestionITsTask gestionITsTask = new GestionITsTask(driver);
    protected CommonTask commonTask = new CommonTask(driver);
    protected ConsultaAvanzadaDePartesDeHorasTask consultaAvanzadaDePartesDeHorasTask = new ConsultaAvanzadaDePartesDeHorasTask(driver);
    protected InformeDigitalParaCierreDeNominaTask informeDigitalParaCierreDeNominaTask = new InformeDigitalParaCierreDeNominaTask(driver);
    //services
    protected ContratosServiceDataBaseProcedure contratosServiceDataBaseProcedure = new ContratosServiceDataBaseProcedure(driver);
}
