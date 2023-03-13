package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    WebElement header;

    @FindBy(xpath = "//span[@class='title' and contains(text(),'Расходы')]")
    WebElement mainMenuCosts;

    @FindBy(xpath = "//span[contains(text(),'Командировки')]")
    WebElement mainMenuCostsTrips;


    public HomePage checkTitle() {
        wait.until(ExpectedConditions.visibilityOf(header));
        Assert.assertEquals("Текст заголовка не соответствует", "Панель быстрого запуска", header.getText());
        return this;

    }

    public void mainMenuCoast() {
        mainMenuCosts.click();

    }

    public void mainMenuCostsTrips() {
        mainMenuCostsTrips.click();
    }

}
