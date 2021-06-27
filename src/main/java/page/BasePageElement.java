package page;

import static com.google.inject.Guice.createInjector;

import driver.DriverWrapper;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageElement {
    private static final long TIMEOUT_IN_SECONDS = 10;

    protected DriverWrapper driver;

    protected BasePageElement(DriverWrapper driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private BasePageElement() {
    }

    protected void click(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        webElement.click();
    }

    protected void sendKeys(WebElement webElement, String message) {
        waitForElementIsVisible(webElement);
        webElement.clear();
        webElement.sendKeys(message);
    }

    protected String getText(WebElement webElement) {
        waitForElementIsVisible(webElement);
        return webElement.getText();
    }

    protected void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver.self(), Duration.ofSeconds(TIMEOUT_IN_SECONDS))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementIsVisible(WebElement element) {
        new WebDriverWait(driver.self(), Duration.ofSeconds(TIMEOUT_IN_SECONDS))
            .until(ExpectedConditions.visibilityOf(element));
    }
}
