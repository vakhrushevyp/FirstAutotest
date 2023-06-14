package ru.ibs.framework;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios",
        glue = "ru.ibs.framework.steps",
        tags = "@firstTest",
        plugin = "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
)


public class CucumberRunnerTest {
}
