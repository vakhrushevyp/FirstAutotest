package ru.ibs.tests;


import org.junit.Test;
import ru.ibs.tests.Base.BaseTests;


public class FirstTest extends BaseTests {

    @Test
    public void testExample() {

        pageManager.getAuthPage()
                .authentication()
                .checkTitle()
                .mainMenuCoast()
                .mainMenuCostsTrips()
                .createTrip()
                .checkTitle()
                .businessUnit("Отдел внутренней разработки")
                .selectCompany("Aplana")
                .selectTasks("Заказ билетов")
                .setDepartureCity("Россия, Ижевск")
                .setArrivalCity("Россия, Москва")
                .setDepartureDatePlan("15.04.2023")
                .setReturnDatePlan("14.05.2023")
                .saveCloseBtn()
                .errorTextEmployees();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
