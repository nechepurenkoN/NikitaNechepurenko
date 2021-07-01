package page.elements;

import data.DifferentElementsPageData;
import driver.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import page.BasePageElement;

public class ColorDropdownList extends BasePageElement {
    @FindBy(css = ".colors select")
    private WebElement dropdownList;

    public ColorDropdownList(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public String getActualColor() {
        return new Select(dropdownList).getFirstSelectedOption().getText();
    }

    public void selectYellow() {
        new Select(dropdownList).selectByVisibleText(DifferentElementsPageData.YELLOW);
    }

    public void selectByValue(String value) {
        new Select(dropdownList).selectByVisibleText(value);
    }

}
