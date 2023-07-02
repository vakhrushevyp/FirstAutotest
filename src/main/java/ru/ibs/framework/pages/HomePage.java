package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement header;

    @FindBy(xpath = "//span[@class='title' and contains(text(),'Расходы')]")
    WebElement mainMenuCosts;

    @FindBy(xpath = "//span[contains(text(),'Командировки')]")
    WebElement mainMenuCostsTrips;


    public HomePage checkTitle() {
        wait.until(ExpectedConditions.visibilityOf(header));
        assertEquals("Панель быстрого запуска", header.getText(), "Текст заголовка не соответствует");
        return pageManager.getHomePage();

    }

    public HomePage mainMenuCoast() {
        mainMenuCosts.click();
        return pageManager.getHomePage();

    }

    public TripsPage mainMenuCostsTrips() {
        mainMenuCostsTrips.click();
        loadingEscape();
        takeScreenshot();
        return pageManager.getTripsPage();
    }

}
