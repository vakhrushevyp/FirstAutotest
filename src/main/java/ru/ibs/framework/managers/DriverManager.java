package ru.ibs.framework.managers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import project.properties.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static Properties properties = TestProperties.getInstance().getProperties();

    private WebDriver driver;
    private static DriverManager INSTANCE = null;


    private DriverManager(){


    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }



    public  WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;

    }

    public  void initDriver() {
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public  void closeDriver() {
        driver.quit();
    }
}
