package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class HomePageSteps {


    public PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем соответствие заголовка страницы HomePage$")
    public void checkTitle(){
        pageManager.getHomePage().checkTitle();
    }

    @И("^Выбираем в меню 'Расходы'$")
    public void mainMenuCoast(){
        pageManager.getHomePage().mainMenuCoast();
    }

    @И("^Выбираем в меню 'Командировки'$")
    public void mainMenuCostsTrips(){
        pageManager.getHomePage().mainMenuCostsTrips();
    }
}
