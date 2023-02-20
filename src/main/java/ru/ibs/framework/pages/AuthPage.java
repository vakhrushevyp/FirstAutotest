package ru.ibs.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import project.properties.TestProperties;
import ru.ibs.framework.managers.DriverManager;

import java.util.Properties;


public class AuthPage {


protected Properties properties = TestProperties.getInstance().getProperties();
protected DriverManager driverManager = DriverManager.getDriverManager();

    @FindBy(  xpath = "//input[@id='prependedInput']" )
    private WebElement login;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement enterBtn;

    public AuthPage (WebDriver driver) {
        this.driverManager.getDriver();
        PageFactory.initElements(driver,this);
    }




    public void authentication() {
        login.sendKeys(properties.getProperty("LOGIN"));
        password.sendKeys(properties.getProperty("PASSWORD"));
        enterBtn.click();
    }
}
