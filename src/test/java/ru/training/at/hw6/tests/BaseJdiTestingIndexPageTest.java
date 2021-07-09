package ru.training.at.hw6.tests;

import static com.google.inject.Guice.createInjector;

import data.User;
import di.DriverSingleton;
import di.PropertiesModule;
import driver.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public class BaseJdiTestingIndexPageTest {
    protected ThreadLocal<DriverWrapper> driver = new ThreadLocal<>();
    protected User user;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeMethod(alwaysRun = true)
    public void beforeClassSetUp(ITestContext testContext) {
        driver.set(new DriverWrapper(createInjector(new DriverSingleton()).getInstance(WebDriver.class)));
        user = createInjector(new PropertiesModule()).getInstance(User.class);
        actionStep = new ActionStep(driver.get());
        assertionStep = new AssertionStep(driver.get());
        testContext.setAttribute("driver", driver.get());
    }

    @AfterMethod(alwaysRun = true)
    public void afterClassTearDown(ITestResult testResult) {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
