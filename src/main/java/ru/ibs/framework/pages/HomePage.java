package ru.ibs.framework.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement header;

    @FindBy(xpath = "//span[@class='title' and contains(text(),'Расходы')]")
    WebElement mainMenuCosts;

    @FindBy(xpath = "//span[contains(text(),'Командировки')]")
    WebElement mainMenuCostsTrips;

    @Step("Проверка соответствия заголовка")
    public HomePage checkTitle() {
        wait.until(ExpectedConditions.visibilityOf(header));

        assertEquals( "Панель быстрого запуска", header.getText(),"Текст заголовка не соответствует");
        return pageManager.getHomePage();

    }
    @Step("Выбираем в меню 'Расходы'")
    public HomePage mainMenuCoast() {
        mainMenuCosts.click();
        return pageManager.getHomePage();

    }
    @Step("Выбираем в меню 'Командировки'")
    public TripsPage mainMenuCostsTrips() {
        mainMenuCostsTrips.click();
        loadingEscape();
        takeScreenshot();
        return pageManager.getTripsPage();
    }

}
