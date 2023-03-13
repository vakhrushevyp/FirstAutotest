package ru.ibs.framework.pages;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TripCreatePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Создать командировку')]")
    WebElement title;

    @FindBy(xpath = "//select[@name='crm_business_trip[businessUnit]']")
    WebElement businessUnit;

    @FindBy(xpath = "//div//select//option[contains(text(),'')]")
    List<WebElement> businessUnitList;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    WebElement selectCompany;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    WebElement selectCompanyOpen;

    @FindBy(xpath = "//input[contains(@class,'select2-input')]")
    WebElement selectCompanyInput;

    @FindBy(xpath = "//span[@class='select2-match']")
    WebElement selectCompanyMatch;

    @FindBy(xpath = "//div[@data-name='field__tasks']//div//label")
    List<WebElement> tasks;

    @FindBy(xpath = "//div[@data-name='field__tasks']//div//input")
    List<WebElement> tasksCheckbox;

    @FindBy(xpath = "//input[@name='crm_business_trip[departureCity]']")
    WebElement departureCity;

    @FindBy(xpath = "//input[@name='crm_business_trip[arrivalCity]']")
    WebElement arrivalCity;

    @FindBy(xpath = "//input[contains(@id,'date_selector_crm_business_trip_departureDatePlan')]")
    WebElement departureDatePlan;

    @FindBy(xpath = "//input[contains(@id,'date_selector_crm_business_trip_returnDatePlan')]")
    WebElement returnDatePlan;

    @FindBy(xpath = "//select[@name='crm_business_trip[businessUnit]']/..//span")
    WebElement businessUnitText;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    WebElement selectCompanyChosen;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    WebElement saveCloseBtn;

    @FindBy(xpath = "//span[contains(text(),'Список командируемых сотрудников не может быть пустым')]")
    WebElement errorTextEmployees;

    public TripCreatePage checkTitle() {
        Assert.assertTrue("не отображается заголовок \"Создать командировку\" ",
                title.isDisplayed());
        return this;
    }


    public void businessUnit(String businessUnitValue) {
        businessUnit.click();
        for (int i = 0; i < businessUnitList.stream().count(); i++) {
            if (businessUnitList.get(i).getText().equals(businessUnitValue)) {
                businessUnitList.get(i).click();
            }
        }
        Assert.assertEquals("Ошибка при выборе подразделения", businessUnitValue, businessUnitText.getText());
    }

    public void selectCompany(String companyName) {
        selectCompany.click();
        selectCompanyOpen.click();
        selectCompanyInput.sendKeys(companyName);
        wait.until(ExpectedConditions.visibilityOf(selectCompanyMatch)).click();

        Assert.assertEquals("Организация заполнена неправильно", companyName, selectCompanyChosen.getText());
    }

    public TripCreatePage selectTasks(String task) {
        int i;
        for (i = 0; i < tasks.stream().count(); i++) {
            if (tasks.get(i).getText().contains(task)) {
                tasksCheckbox.get(i).click();
                break;
            }

        }

        Assert.assertTrue("Чекбокс \"Задачи\" не установлен напротив " + task, tasksCheckbox.get(i).isSelected());

        return this;

    }


    public void setDepartureCity(String departureCityValue) {
        departureCity.clear();
        departureCity.sendKeys(departureCityValue);

        Assert.assertEquals("Город выбытия заполнен неправильно",
                departureCityValue, departureCity.getAttribute("value"));
    }

    public void setArrivalCity(String arrivalCityValue) {
        arrivalCity.clear();
        arrivalCity.sendKeys(arrivalCityValue);
        Assert.assertEquals("Город прибытия заполнен неправильно",
                arrivalCityValue, arrivalCity.getAttribute("value"));
    }

    public void setDepartureDatePlan(String departureDatePlanValue) {
        departureDatePlan.clear();
        departureDatePlan.sendKeys(departureDatePlanValue);
        Assert.assertEquals("Планируемая дата выезда заполнена неправильно",
                departureDatePlanValue, departureDatePlan.getAttribute("value"));
    }

    public void setReturnDatePlan(String returnDatePlanValue) {
        returnDatePlan.clear();
        returnDatePlan.sendKeys(returnDatePlanValue);
        new Actions(driverManager.getDriver()).sendKeys(Keys.TAB).perform();
        Assert.assertEquals("Планируемая дата отъезда заполнена неправильно",
                returnDatePlanValue, returnDatePlan.getAttribute("value"));
    }

    public void saveCloseBtn() {
        saveCloseBtn.click();
    }

    public void errorTextEmployees() {
        Assert.assertTrue("Текст ошибки по сотрудникам не отобразился", errorTextEmployees.isDisplayed());
    }


}
