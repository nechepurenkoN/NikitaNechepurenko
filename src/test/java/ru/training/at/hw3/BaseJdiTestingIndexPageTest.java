package ru.training.at.hw3;

import static com.google.inject.Guice.createInjector;

import driver.DriverWrapper;
import driver.di.DriverSingleton;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseJdiTestingIndexPageTest {
    protected DriverWrapper driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClassSetUp() {
        driver = new DriverWrapper(createInjector(new DriverSingleton()).getInstance(WebDriver.class));
    }

    @AfterClass(alwaysRun = true)
    public void afterClassTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void assertOpenedSiteIsCorrectByURL(SoftAssertions assertAccumulator, String actualURL,
                                                  String expectedURL) {
        assertAccumulator.assertThat(actualURL).isEqualTo(expectedURL);
    }

    protected void assertBrowserTitle(SoftAssertions assertAccumulator, String actualTitle, String expectedTitle) {
        assertAccumulator.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    protected void assertLoginSuccess(SoftAssertions assertAccumulator, boolean isLogoutButtonDisplayed) {
        assertAccumulator.assertThat(isLogoutButtonDisplayed).isTrue();
    }

    protected void assertUsernameLabelIsDisplayed(SoftAssertions assertAccumulator, boolean isUsernameLabelDisplayed) {
        assertAccumulator.assertThat(isUsernameLabelDisplayed).isTrue();
    }

    protected void assertUsername(SoftAssertions assertAccumulator, String actualUsername, String expectedUsername) {
        assertAccumulator.assertThat(actualUsername).isEqualTo(expectedUsername);
    }
}
