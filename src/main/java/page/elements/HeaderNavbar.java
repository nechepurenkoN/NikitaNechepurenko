package page.elements;

import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class HeaderNavbar extends BasePageElement {

    @FindBy(css = ".nav > li > a")
    private List<WebElement> items;

    public HeaderNavbar(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public List<String> getItemsTexts() {
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isDisplayed() {
        return items.stream().allMatch(WebElement::isDisplayed);
    }

    public HeaderNavbar clickOnDropdown() {
        click(driver.findElement(By.cssSelector(".nav .dropdown-toggle")));
        return this;
    }

    public void clickOnDifferentElementsPageLink() {
        click(driver.findElement(By.cssSelector(".nav .dropdown-menu li:nth-child(8) > a")));
    }

    public void clickOnDropdownItemByName(String item) {
        driver.findElements(By.cssSelector(".nav .dropdown-menu li > a"))
              .stream()
              .filter(webElement -> webElement.getText().equals(item.toUpperCase()))
              .findFirst()
              .ifPresent(this::click);
    }
}
