package page.elements;

import driver.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.Attribute;
import page.BasePageElement;

public class Title extends BasePageElement {
    @FindBy(tagName = "title")
    private WebElement title;

    public Title(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public String getTitle() {
        return title.getAttribute(Attribute.INNER_HTML_ATTRIBUTE);
    }
}
