package com.eulen.flexinet.core.test.selenium.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.eulen.flexinet.core.test.selenium.steps",
        tags = "@GestionClientesContrato"
)

public class TestSuiteClientesContrato {
}
