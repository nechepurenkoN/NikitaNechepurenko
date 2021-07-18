package ru.training.at.hw7.tests;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.jdi.light.driver.WebDriverUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw7.page.objects.JdiTestingSite;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initSite(JdiTestingSite.class);
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
