package ru.ibs.framework.steps;


import io.cucumber.java.ru.Допустим;
import ru.ibs.framework.managers.PageManager;


public class AuthPageSteps {


    public PageManager pageManager = PageManager.getPageManager();


    @Допустим("Выполняем авторизацию")
    public void authentication() {
        pageManager.getAuthPage().authentication();

    }


}
