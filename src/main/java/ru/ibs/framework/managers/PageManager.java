package ru.ibs.framework.managers;

import ru.ibs.framework.pages.*;

public class PageManager {

    private static PageManager pageManager;


    private AuthPage authPage;
    private HomePage homePage;
    private TripsPage tripsPage;
    private TripCreatePage tripCreatePage;

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }



    public AuthPage getAuthPage() {
        if (authPage == null) {
            authPage = new AuthPage();
        }
        return authPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public TripsPage getTripsPage() {
        if (tripsPage == null) {
            tripsPage = new TripsPage();
        }
        return tripsPage;
    }

    public TripCreatePage getTripCreatePage() {
        if (tripCreatePage == null) {
            tripCreatePage = new TripCreatePage();
        }
        return tripCreatePage;
    }


}
