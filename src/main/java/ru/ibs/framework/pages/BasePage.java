package ru.ibs.framework.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.TestProperties;

import java.util.Properties;

public class BasePage {

    protected Properties properties = TestProperties.getInstance().getProperties();
    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 20, 2000);
    protected PageManager pageManager = PageManager.getPageManager();
    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

    @FindBy(xpath = "//div[@class='loader-content']")
    WebElement loadingEscape;

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);

    }

    public void loadingEscape() {
        wait.until(ExpectedConditions.invisibilityOf(loadingEscape));

    }

    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    @Attachment(value = "Скришот")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
