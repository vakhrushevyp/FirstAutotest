package ru.ibs.tests;


import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.properties.TestProperties;
import ru.ibs.framework.managers.DriverManager;

import java.util.Properties;



public class FirstAutotest extends BaseTests {


    protected  DriverManager driverManager = DriverManager.getDriverManager();
    protected Properties properties = TestProperties.getInstance().getProperties();

    protected WebDriver driver = driverManager.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),20,2000);





    @Test
    public void test() {
        // Авторизация
        WebElement loginForm = driver.findElement(By.xpath("//form[@id='login-form']//fieldset"));
        loginForm.findElement(By.xpath(".//input[@id='prependedInput']")).sendKeys(properties.getProperty("LOGIN"));
        loginForm.findElement(By.xpath(".//input[@id='prependedInput2']")).sendKeys(properties.getProperty("PASSWORD"));
        loginForm.findElement(By.xpath(".//button[@id='_submit']")).click();

        // Проверка наличия заголовка
        WebElement header = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        wait.until(ExpectedConditions.visibilityOf(header));
        String headerText = header.getText();
        Assert.assertEquals("Текст заголовка не соответствует", "Панель быстрого запуска", headerText);
        //Создание командировки

        WebElement mainMenu = driver.findElement(By.xpath("//ul[@class='nav nav-multilevel main-menu']"));
        mainMenu.findElement(By.xpath(".//span[contains(text(),'Расходы')]")).click();
        wait.until(ExpectedConditions.visibilityOf(mainMenu.findElement
                (By.xpath(".//span[contains(text(),'Командировки')]")))).click();
        loadingEscape();

        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();

        loadingEscape();

        Assert.assertTrue("не отображается заголовок \"Создать командировку\" ",
                driver.findElement(By.xpath("//h1[contains(text(),'Создать командировку')]")).isDisplayed());
        loadingEscape();

        //Заполняем поля для создания командировки


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                ("//select[@name='crm_business_trip[businessUnit]']/..")))).click();

        driver.findElement(By.xpath("//div//select//option[contains(text(),'Отдел внутренней разработки')]")).click();

        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//input[contains(@class,'select2-input')]")))).sendKeys("Aplana");

        wait.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath("//span[@class='select2-match']")))).click();

        WebElement tasks = driver.findElement(By.xpath("//div[@data-name='field__tasks']"));

        tasks.findElement(By.xpath(".//label[contains(text(),'Заказ билетов')]")).click();

        driver.findElement(By.xpath("//input[@name='crm_business_trip[departureCity]']")).clear();
        driver.findElement(By.xpath("//input[@name='crm_business_trip[departureCity]']")).sendKeys("Россия, Ижевск");

        driver.findElement(By.xpath("//input[@name='crm_business_trip[arrivalCity]']")).clear();
        driver.findElement(By.xpath("//input[@name='crm_business_trip[arrivalCity]']")).sendKeys("Россия, Москва");


        driver.findElement(By.xpath("//input[contains(@id,'date_selector_crm_business_trip_departureDatePlan')]")).
                sendKeys("15.12.2022");


        driver.findElement(By.xpath("//input[contains(@id,'date_selector_crm_business_trip_returnDatePlan')]")).
                sendKeys("30.12.2022");


        new Actions(driver).sendKeys(Keys.TAB).perform();



        //Проверяем правильность заполнения полей

        Assert.assertEquals("Ошибка при выборе подразделения", "Отдел внутренней разработки",driver.findElement(
                By.xpath("//select[@name='crm_business_trip[businessUnit]']/..//span")).getText() );

        Assert.assertEquals("Организация заполнена неправильно", "Aplana",driver.findElement(
                By.xpath("//span[@class='select2-chosen']")).getText() );

        Assert.assertEquals("Чекбокс \"Задачи\" не установлен", "true",
                driver.findElement(By.xpath("//label[contains(text(),'Заказ билетов')]/..//input")).getAttribute("checked"));

        Assert.assertEquals("Город выбытия заполнен неправильно", "Россия, Ижевск",driver.findElement(
                By.xpath("//input[@name='crm_business_trip[departureCity]']")).getAttribute("value") );

        Assert.assertEquals("Город прибытия заполнен неправильно", "Россия, Москва",driver.findElement(
                By.xpath("//input[@name='crm_business_trip[arrivalCity]']")).getAttribute("value") );

        Assert.assertEquals("Планируемая дата выезда заполнена неправильно", "2022-12-15",driver.findElement(
                By.xpath("//input[@name='crm_business_trip[departureDatePlan]']")).getAttribute("value") );

        Assert.assertEquals("Планируемая дата выезда заполнена неправильно", "30.12.2022",driver.findElement(
                By.xpath("//input[contains(@id,'date_selector_crm_business_trip_returnDatePlan')]")).getAttribute("value") );

        //нажимаем кнопку "Сохранить и закрыть"


        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        loadingEscape();

        Assert.assertTrue("Текст не отобразился", driver.findElement
                (By.xpath("//span[contains(text(),'Список командируемых сотрудников не может быть пустым')]")).isDisplayed());





        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    public void loadingEscape()     {
        WebElement loading = driver.findElement(By.xpath("//div[@class='loader-content']"));
        wait.until(ExpectedConditions.invisibilityOf(loading));
    }

}
