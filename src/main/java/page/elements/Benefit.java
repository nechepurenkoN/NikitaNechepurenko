package page.elements;

import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

@Getter
public class Benefit extends BasePageElement {
    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> texts;

    public Benefit(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public boolean areImagesDisplayed() {
        return images.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areTextsDisplayed() {
        return texts.stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getTextsAsStrings() {
        return texts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
