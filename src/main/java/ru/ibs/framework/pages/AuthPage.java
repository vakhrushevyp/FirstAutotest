package ru.ibs.framework.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AuthPage extends BasePage {


    @FindBy(xpath = "//input[@id='prependedInput']")
    private WebElement login;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement enterBtn;


    public void authentication() {
        login.sendKeys(properties.getProperty("LOGIN"));
        password.sendKeys(properties.getProperty("PASSWORD"));
        enterBtn.click();
    }
}
