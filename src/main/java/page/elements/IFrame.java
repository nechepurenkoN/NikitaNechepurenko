package page.elements;

import data.JdiTestingIndexPageData;
import driver.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class IFrame extends BasePageElement {
    private final Title title;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement button;

    public IFrame(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
        title = new Title(driver);
    }

    public void getInScope() {
        driver.switchTo().frame(frame);
    }

    public boolean isInScope() {
        return title.getTitle().equals(JdiTestingIndexPageData.FRAME_TITLE);
    }

    public boolean isDisplayed() {
        return frame.isDisplayed();
    }

    public boolean isButtonDisplayed() {
        return button.isDisplayed();
    }

    public String getButtonText() {
        return button.getAttribute(JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT_ATTRIBUTE);
    }
}
