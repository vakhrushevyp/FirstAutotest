package ru.ibs.tests;


import org.junit.Test;
import ru.ibs.framework.pages.*;


public class FirstAutotest extends BaseTests {


    BasePage basePage = new BasePage();
    AuthPage authPage = new AuthPage();
    HomePage homePage = new HomePage();
    TripsPage tripsPage = new TripsPage();
    TripCreatePage tripCreatePage = new TripCreatePage();

    @Test
    public void test() {
        // Авторизация
        authPage.authentication();
        homePage.checkTitle();
        // Открываем страницу создания командировки
        homePage.mainMenuCoast();
        homePage.mainMenuCostsTrips();
        basePage.loadingEscape();
        tripsPage.createTrip();
        basePage.loadingEscape();
        tripCreatePage.checkTitle();
        basePage.loadingEscape();
        //Заполняем поля для создания командировки
        tripCreatePage.businessUnit("Отдел внутренней разработки");
        tripCreatePage.selectCompany("Aplana");
        tripCreatePage.selectTasks("Заказ билетов");
        tripCreatePage.setDepartureCity("Россия, Ижевск");
        tripCreatePage.setArrivalCity("Россия, Москва");
        tripCreatePage.setDepartureDatePlan("15.04.2023");
        tripCreatePage.setReturnDatePlan("14.05.2023");
        //нажимаем кнопку "Сохранить и закрыть"
        tripCreatePage.saveCloseBtn();
        basePage.loadingEscape();
        tripCreatePage.errorTextEmployees();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
