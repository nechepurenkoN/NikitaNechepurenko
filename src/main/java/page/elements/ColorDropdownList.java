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

    private final Select select;

    public ColorDropdownList(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
        select = new Select(dropdownList);
    }

    public String getActualColor() {
        return select.getFirstSelectedOption().getText();
    }

    public void selectYellow() {
        select.selectByVisibleText(DifferentElementsPageData.YELLOW);
    }

}
