package page.elements;

import driver.DriverWrapper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePageElement;

public abstract class RadioButtonGroup extends BasePageElement {
    protected List<WebElement> buttons;
    private static final By PARENT_NODE = By.xpath("./..");

    public RadioButtonGroup(DriverWrapper driver, By selector) {
        super(driver);
        buttons = this.driver.findElements(selector);
    }

    public boolean isDisplayed() {
        return buttons.stream().allMatch(WebElement::isDisplayed);
    }

    private WebElement getElementByText(String text) {
        return buttons.stream()
                      .filter(webElement -> webElement.findElement(PARENT_NODE).getText().equals(text))
                      .findFirst()
                      .orElseThrow();
    }

    protected boolean isSelectedByOrder(int order) {
        return buttons.get(order).isSelected();
    }

    protected boolean isSelectedByText(String text) {
        return getElementByText(text).isSelected();
    }

    protected void selectButtonByOrder(int order) {
        buttons.get(order).click();
    }

    protected String getButtonTextByOrder(int order) {
        return buttons.get(order).findElement(PARENT_NODE).getText();
    }

    protected void selectButtonByText(String text) {
        getElementByText(text).click();
    }
}
