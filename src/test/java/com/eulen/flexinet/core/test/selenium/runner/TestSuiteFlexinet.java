package com.eulen.flexinet.core.test.selenium.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestSuiteEmpresasCliente.class,
    TestSuiteClientesContrato.class,
    TestSuiteCentrosDeTrabajo.class
})

public class TestSuiteFlexinet {
}
