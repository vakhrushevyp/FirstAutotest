package ru.ibs.tests.Base;




import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.TestProperties;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;

import java.util.Properties;


public class BaseTests {

    private final Properties properties = TestProperties.getInstance().getProperties();
    private final DriverManager driverManager = DriverManager.getDriverManager();
    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeAll
    public static void beforeAll(){
        InitManager.initFramework();
    }


    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(properties.getProperty("HOSTNAME"));
    }



    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }




}





