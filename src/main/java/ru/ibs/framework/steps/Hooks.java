package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.TestProperties;

import java.util.Properties;

public class Hooks {

    private final Properties properties = TestProperties.getInstance().getProperties();
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @Attachment(value = "Скришот")
    public byte[] takeScreenshot () {
        return ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Before
    public void before(){
        InitManager.initFramework();
        driverManager.getDriver().get(properties.getProperty("HOSTNAME"));

    }

    @After
    public void after() {
        InitManager.quitFramework();

    }



}
