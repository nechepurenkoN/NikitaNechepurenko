package page.elements;

import driver.DriverWrapper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.BasePageElement;

public abstract class CheckboxGroup extends BasePageElement {
    protected List<WebElement> checkboxList;
    private static final By PARENT_NODE = By.xpath("./..");

    protected CheckboxGroup(DriverWrapper driver, By selector) {
        super(driver);
        checkboxList = driver.findElements(selector);
    }

    public boolean isDisplayed() {
        return checkboxList.stream().allMatch(WebElement::isDisplayed);
    }

    private WebElement getElementByText(String text) {
        return checkboxList.stream()
                           .filter(webElement -> webElement.findElement(PARENT_NODE).getText().equals(text))
                           .findFirst()
                           .orElseThrow();
    }

    protected boolean isCheckedByOrder(int order) {
        return checkboxList.get(order).isSelected();
    }

    protected boolean isCheckedByText(String text) {
        return getElementByText(text).isSelected();
    }

    protected void selectCheckboxByOrder(int order) {
        checkboxList.get(order).click();
    }

    protected String getCheckboxTextByOrder(int order) {
        return checkboxList.get(order).findElement(PARENT_NODE).getText();
    }

    protected void selectCheckboxByText(String text) {
        getElementByText(text).click();
    }
}
