package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class TripsPageSteps {

    public PageManager pageManager = PageManager.getPageManager();

    @И("^Нажимаем на кнопку 'Создать командировку'$")
    public void createTrip(){
        pageManager.getTripsPage().createTrip();
    }
}
