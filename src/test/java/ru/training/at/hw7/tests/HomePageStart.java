package ru.training.at.hw7.tests;

import static ru.training.at.hw7.page.objects.JdiTestingSite.homePage;

import org.testng.annotations.BeforeMethod;

public interface HomePageStart {
    @BeforeMethod(alwaysRun = true)
    static void setUpMethod() {
        homePage.open();
        homePage.checkOpened();
    }
}
