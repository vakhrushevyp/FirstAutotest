package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.properties.TestProperties;
import ru.ibs.framework.managers.DriverManager;

import java.util.Properties;

public class BasePage {

    protected Properties properties = TestProperties.getInstance().getProperties();
    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 20, 2000);

    @FindBy(xpath = "//div[@class='loader-content']")
    WebElement loadingEscape;

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);

    }



    public void loadingEscape()     {
                wait.until(ExpectedConditions.invisibilityOf(loadingEscape));
    }


}
