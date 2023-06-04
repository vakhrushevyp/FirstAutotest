package ru.ibs.framework.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthPage extends BasePage {


    @FindBy(xpath = "//input[@id='prependedInput']")
    WebElement login;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    WebElement enterBtn;

    public HomePage authentication() {
        login.sendKeys(properties.getProperty("LOGIN"));
        password.sendKeys(properties.getProperty("PASSWORD"));
        enterBtn.click();
        takeScreenshot();
        return pageManager.getHomePage();
    }
}
