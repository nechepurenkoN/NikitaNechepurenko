package page.elements;

import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class SidebarNav extends BasePageElement {
    @FindBy(css = ".sidebar-menu > li > a > span")
    private List<WebElement> items;

    public SidebarNav(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public List<String> getItemsTexts() {
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isDisplayed() {
        return items.stream().allMatch(WebElement::isDisplayed);
    }
}
