package page.elements;

import driver.DriverWrapper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePageElement;

public abstract class RadioButtonGroup extends BasePageElement {
    private static final By PARENT_NODE = By.xpath("./..");
    private final By selector;

    public RadioButtonGroup(DriverWrapper driver, By selector) {
        super(driver);
        this.selector = selector;
    }

    public boolean isDisplayed() {
        return getButtons().stream().allMatch(WebElement::isDisplayed);
    }

    private WebElement getElementByText(String text) {
        return getButtons().stream()
                      .filter(webElement -> webElement.findElement(PARENT_NODE).getText().equals(text))
                      .findFirst()
                      .orElseThrow();
    }

    public boolean isSelectedByOrder(int order) {
        return getButtons().get(order).isSelected();
    }

    public boolean isSelectedByText(String text) {
        return getElementByText(text).isSelected();
    }

    public void selectButtonByOrder(int order) {
        getButtons().get(order).click();
    }

    public String getButtonTextByOrder(int order) {
        return getButtons().get(order).findElement(PARENT_NODE).getText();
    }

    public void selectButtonByText(String text) {
        getElementByText(text).click();
    }

    private List<WebElement> getButtons() {
        return driver.findElements(selector);
    }
}
