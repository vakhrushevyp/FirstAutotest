package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.TestProperties;

import java.util.Properties;

public class Hooks {

    private final Properties properties = TestProperties.getInstance().getProperties();
    private final DriverManager driverManager = DriverManager.getDriverManager();


    @Before
    public void before() {
        InitManager.initFramework();
        driverManager.getDriver().get(properties.getProperty("HOSTNAME"));

    }


    @After
    public void after() {
        InitManager.quitFramework();

    }


}
