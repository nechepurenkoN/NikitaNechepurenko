package ru.training.at.hw2;

import com.google.inject.Inject;
import di.DriverModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;

@Guice(modules = {DriverModule.class})
public class SeleniumTestsSetup {

    @Inject
    private DriverManagerType browserUsedType;

    @BeforeSuite(alwaysRun = true)
    protected void setUpDriver() {
        WebDriverManager.getInstance(browserUsedType).setup();
    }

    @SneakyThrows
    protected WebDriver getDriver() {
        return (WebDriver) Class.forName(browserUsedType.browserClass()).getConstructor().newInstance();
    }
}
