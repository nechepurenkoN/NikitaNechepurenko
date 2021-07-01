package ru.training.at.hw4.steps;

import driver.DriverWrapper;
import lombok.Setter;
import page.objects.DifferentElementsPage;
import page.objects.JdiTestingIndexPage;

@Setter
public abstract class AbstractStep {
    protected JdiTestingIndexPage indexPage;
    protected DifferentElementsPage dePage;

    protected AbstractStep(DriverWrapper driver) {
        indexPage = new JdiTestingIndexPage(driver);
        dePage = new DifferentElementsPage(driver);
    }

}
