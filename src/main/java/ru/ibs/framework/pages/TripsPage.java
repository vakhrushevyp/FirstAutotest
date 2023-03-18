package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripsPage extends BasePage {

    @FindBy(xpath = "//a[@title='Создать командировку']")
    WebElement createTrip;


    public TripCreatePage createTrip() {
        createTrip.click();
        loadingEscape();
        return pageManager.getTripCreatePage();
    }


}
