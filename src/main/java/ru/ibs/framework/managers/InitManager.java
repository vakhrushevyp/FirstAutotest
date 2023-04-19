package ru.ibs.framework.managers;


import java.util.concurrent.TimeUnit;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    public static void initFramework() {

        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }


}
