package ru.training.at.hw5.hooks;

import static com.google.inject.Guice.createInjector;

import di.DriverSingleton;
import driver.DriverWrapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    @Getter
    private static DriverWrapper driver;

    @Before
    public void initDriver() {
        driver = new DriverWrapper(createInjector(new DriverSingleton()).getInstance(WebDriver.class));
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
