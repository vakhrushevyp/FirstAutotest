package ru.ibs.tests;



import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import ru.ibs.tests.Base.BaseTests;


public class TestFirstTest extends BaseTests {

    @Test
    @DisplayName("Создание командировки")
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
                .errorTextEmployees("Список командируемых сотрудников не может быть пустым");

    }


}
