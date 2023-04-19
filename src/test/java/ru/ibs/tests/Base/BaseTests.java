package ru.ibs.tests.Base;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.TestProperties;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;

import java.util.Properties;


public class BaseTests {

    private final Properties properties = TestProperties.getInstance().getProperties();
    private final DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeClass
    public static void beforeAll(){
        InitManager.initFramework();
    }


    @Before
    public void beforeEach() {
        driverManager.getDriver().get(properties.getProperty("HOSTNAME"));
    }


    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }




}





