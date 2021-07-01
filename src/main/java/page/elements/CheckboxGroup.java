package page.elements;

import driver.DriverWrapper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePageElement;

public abstract class CheckboxGroup extends BasePageElement {
    private static final By PARENT_NODE = By.xpath("./..");
    private final By selector;

    protected CheckboxGroup(DriverWrapper driver, By selector) {
        super(driver);
        this.selector = selector;
    }

    public boolean isDisplayed() {
        return getCheckboxList().stream().allMatch(WebElement::isDisplayed);
    }

    private WebElement getElementByText(String text) {
        return getCheckboxList().stream()
                           .filter(webElement -> webElement.findElement(PARENT_NODE).getText().equals(text))
                           .findFirst()
                           .orElseThrow();
    }

    public boolean isCheckedByOrder(int order) {
        return getCheckboxList().get(order).isSelected();
    }

    public boolean isCheckedByText(String text) {
        return getElementByText(text).isSelected();
    }

    public void selectCheckboxByOrder(int order) {
        getCheckboxList().get(order).click();
    }

    public String getCheckboxTextByOrder(int order) {
        return getCheckboxList().get(order).findElement(PARENT_NODE).getText();
    }

    public void selectCheckboxByText(String text) {
        getElementByText(text).click();
    }

    private List<WebElement> getCheckboxList() {
        return driver.findElements(selector);
    }
}
