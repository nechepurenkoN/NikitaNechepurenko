package ru.training.at.hw2;

import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;

public class BaseJdiTestingIndexPageTest extends SeleniumTestsSetup {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClassTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void openSiteByURL(String url) {
        driver.navigate().to(url);
    }

    protected void assertOpenedSiteIsCorrectByURL(SoftAssertions assertAccumulator, String actualURL,
                                                  String expectedURL) {
        assertAccumulator.assertThat(actualURL).isEqualTo(expectedURL);
    }

    protected void assertBrowserTitle(SoftAssertions assertAccumulator, String actualTitle, String expectedTitle) {
        assertAccumulator.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    protected void performLogin(String login, String password) {
        driver.findElement(LoginFormLocators.DROPDOWN).click();
        driver.findElement(LoginFormLocators.LOGIN_INPUT).sendKeys(login);
        driver.findElement(LoginFormLocators.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LoginFormLocators.LOGIN_BUTTON).click();
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

    protected String getActualURL() {
        return driver.getCurrentUrl();
    }

    protected String getActualTitle() {
        return driver.getTitle();
    }

    protected boolean isUsernameLabelDisplayed() {
        return driver.findElement(LoginFormLocators.USERNAME_PLACEHOLDER).isDisplayed();
    }

    protected boolean isLogoutButtonDisplayed() {
        return driver.findElement(LoginFormLocators.LOGOUT_BUTTON).isDisplayed();
    }

    protected String getActualUsername() {
        return driver.findElement(LoginFormLocators.USERNAME_PLACEHOLDER).getText();
    }

    protected static class LoginFormLocators {
        public static final By DROPDOWN = By.cssSelector(".navbar-right .dropdown-toggle");
        public static final By LOGIN_INPUT = By.id("name");
        public static final By PASSWORD_INPUT = By.id("password");
        public static final By LOGIN_BUTTON = By.id("login-button");
        public static final By USERNAME_PLACEHOLDER = By.id("user-name");
        public static final By LOGOUT_BUTTON = By.cssSelector(".logout > button");
    }
}
