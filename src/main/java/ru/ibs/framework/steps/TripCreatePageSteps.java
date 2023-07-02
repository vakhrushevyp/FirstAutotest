package ru.ibs.framework.steps;


import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;


public class TripCreatePageSteps {

    public PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем соответствие заголовка страницы создания командировки$")
    public void checkTitle() {
        pageManager.getTripCreatePage().checkTitle();
    }

    @И("^Выбираем подразделение (.+)$")
    public void businessUnit(String businessUnitValue) {
        pageManager.getTripCreatePage().businessUnit(businessUnitValue);

    }

    @И("^Выбираем компанию (.+)$")
    public void selectCompany(String companyName) {
        pageManager.getTripCreatePage().selectCompany(companyName);

    }

    @И("^Заполняем задачу значением (.+)$")
    public void selectTasks(String task) {
        pageManager.getTripCreatePage().selectTasks(task);

    }

    @И("^Заполняем город вылета: (.+)$")
    public void setDepartureCity(String departureCityValue) {
        pageManager.getTripCreatePage().setDepartureCity(departureCityValue);

    }

    @И("^Заполняем город прилета: (.+)$")
    public void setArrivalCity(String arrivalCityValue) {
        pageManager.getTripCreatePage().setArrivalCity(arrivalCityValue);

    }

    @И("^Заполняем дату вылета: (.+)$")
    public void setDepartureDatePlan(String departureDatePlanValue) {
        pageManager.getTripCreatePage().setDepartureDatePlan(departureDatePlanValue);

    }

    @И("^Заполняем дату отъезда: (.+)$")
    public void setReturnDatePlan(String returnDatePlanValue) {
        pageManager.getTripCreatePage().setReturnDatePlan(returnDatePlanValue);

    }

    @И("^Нажимаем кнопку Сохранить и закрыть$")
    public void saveCloseBtn() {
        pageManager.getTripCreatePage().saveCloseBtn();

    }

    @И("^Проверяем что текст ошибки у незаполненных полей: (.+)$")
    public void errorTextEmployees(String textErrorMessage) {
        pageManager.getTripCreatePage().errorTextEmployees(textErrorMessage);


    }


}






