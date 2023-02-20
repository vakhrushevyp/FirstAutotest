package ru.ibs.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.properties.TestProperties;
import ru.ibs.framework.managers.DriverManager;

import java.util.Properties;


public class BaseTests {

   private static Properties properties = TestProperties.getInstance().getProperties();
   private final DriverManager driverManager = DriverManager.getDriverManager();


        @Before
        public void before () {
            driverManager.getDriver().get(properties.getProperty("HOSTNAME"));
        }




        @After
                public void after() {
            driverManager.closeDriver();
            }





}





