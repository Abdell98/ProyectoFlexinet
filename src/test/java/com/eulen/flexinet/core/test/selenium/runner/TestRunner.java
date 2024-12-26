package com.eulen.flexinet.core.test.selenium.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.eulen.flexinet.core.test.selenium.steps",
        tags = "@Facturacion"
)

public class TestRunner {
}
