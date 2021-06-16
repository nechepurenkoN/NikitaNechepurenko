package ru.training.at.hw2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.data.JdiTestingIndexPageData;

public class BaseJdiTestingIndexPageTest extends SeleniumTestsSetup {
    protected WebDriver driver;

    protected SoftAssert assertAccumulator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        assertAccumulator = new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void afterClassTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void openTestSiteByURL() {
        // 1. Open test site by URL
        driver.navigate().to(JdiTestingIndexPageData.PAGE_URL);
        assertAccumulator.assertEquals(driver.getCurrentUrl(), JdiTestingIndexPageData.PAGE_URL);
    }

    protected void assertBrowserTitle() {
        // 2. Assert Browser title
        assertAccumulator.assertEquals(driver.getTitle(), JdiTestingIndexPageData.PAGE_TITLE);
    }

    protected void performLogin() {
        // 3. Perform login
        driver.findElement(LoginFormLocators.DROPDOWN).click();
        driver.findElement(LoginFormLocators.LOGIN_INPUT).sendKeys(JdiTestingIndexPageData.LOGIN);
        driver.findElement(LoginFormLocators.PASSWORD_INPUT).sendKeys(JdiTestingIndexPageData.PASSWORD);
        driver.findElement(LoginFormLocators.LOGIN_BUTTON).click();

        assertAccumulator.assertTrue(driver.findElement(LoginFormLocators.LOGOUT_BUTTON).isDisplayed());
    }

    protected void assertUserName() {
        // 4. Assert Username is loggined
        WebElement userNameHolderSpan = driver.findElement(LoginFormLocators.USERNAME_PLACEHOLDER);

        assertAccumulator.assertTrue(userNameHolderSpan.isDisplayed());
        assertAccumulator.assertEquals(
            userNameHolderSpan.getText(),
            JdiTestingIndexPageData.USERNAME.toUpperCase()
        );
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
