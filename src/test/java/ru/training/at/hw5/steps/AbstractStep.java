package ru.training.at.hw5.steps;

import driver.DriverWrapper;
import page.objects.DifferentElementsPage;
import page.objects.JdiTestingIndexPage;
import page.objects.UserTablePage;
import ru.training.at.hw5.hooks.CucumberHook;

public class AbstractStep {
    protected final JdiTestingIndexPage indexPage;
    protected final DifferentElementsPage dePage;
    protected final UserTablePage userTablePage;

    protected AbstractStep() {
        DriverWrapper driver = CucumberHook.getDriver();
        indexPage = new JdiTestingIndexPage(driver);
        dePage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
