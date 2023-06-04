package ru.ibs.framework.pages;



import io.qameta.allure.Step;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertTrue(title.isDisplayed(), "не отображается заголовок \"Создать командировку\" ");
        loadingEscape();
        return this;
    }


    public TripCreatePage businessUnit(String businessUnitValue) {
        businessUnit.click();
        for (int i = 0; i < businessUnitList.stream().count(); i++) {
            if (businessUnitList.get(i).getText().equals(businessUnitValue)) {
                businessUnitList.get(i).click();
                return pageManager.getTripCreatePage();

            }
        }
        assertEquals("Ошибка при выборе подразделения", businessUnitValue, businessUnitText.getText());

        return pageManager.getTripCreatePage();
    }


    public TripCreatePage selectCompany(String companyName) {
        selectCompany.click();
        selectCompanyOpen.click();
        selectCompanyInput.sendKeys(companyName);
        wait.until(ExpectedConditions.visibilityOf(selectCompanyMatch)).click();
        assertEquals( companyName, selectCompanyChosen.getText(),"Организация заполнена неправильно");
        takeScreenshot();
        return pageManager.getTripCreatePage();
    }


    public TripCreatePage selectTasks(String task) {
        int i;
        for (i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getText().contains(task)) {
                tasksCheckbox.get(i).click();
                break;
            }
            return pageManager.getTripCreatePage();
        }

        assertTrue( tasksCheckbox.get(i).isSelected(), "Чекбокс \"Задачи\" не установлен напротив " + task);
        takeScreenshot();
        return pageManager.getTripCreatePage();

    }


    public TripCreatePage setDepartureCity(String departureCityValue) {
        departureCity.clear();
        departureCity.sendKeys(departureCityValue);

        assertEquals(
                departureCityValue, departureCity.getAttribute("value"), "Город выбытия заполнен неправильно");
        return pageManager.getTripCreatePage();
    }


    public TripCreatePage setArrivalCity(String arrivalCityValue) {
        arrivalCity.clear();
        arrivalCity.sendKeys(arrivalCityValue);
        assertEquals(
                arrivalCityValue, arrivalCity.getAttribute("value"),"Город прибытия заполнен неправильно");
        return pageManager.getTripCreatePage();
    }


    public TripCreatePage setDepartureDatePlan(String departureDatePlanValue) {
        departureDatePlan.clear();
        departureDatePlan.sendKeys(departureDatePlanValue);
        assertEquals(departureDatePlanValue, departureDatePlan.getAttribute("value"),
                "Планируемая дата выезда заполнена неправильно");
        return pageManager.getTripCreatePage();
    }


    public TripCreatePage setReturnDatePlan(String returnDatePlanValue) {
        returnDatePlan.clear();
        returnDatePlan.sendKeys(returnDatePlanValue);
        new Actions(driverManager.getDriver()).sendKeys(Keys.TAB).perform();
        assertEquals(returnDatePlanValue, returnDatePlan.getAttribute("value"),
                "Планируемая дата отъезда заполнена неправильно");
        takeScreenshot();
        return this;
    }


    public TripCreatePage saveCloseBtn() {
        saveCloseBtn.click();
        loadingEscape();
        takeScreenshot();
        return this;
    }



    public TripCreatePage errorTextEmployees(String textErrorMessage) {
        loadingEscape();
       scrollToElementJs(errorTextEmployees);
        wait.until(ExpectedConditions.visibilityOf(errorTextEmployees));
        takeScreenshot();
        assertEquals(textErrorMessage, errorTextEmployees.getText(), "Текст ошибки по сотрудникам не соответствует");
        return this;

    }





}
