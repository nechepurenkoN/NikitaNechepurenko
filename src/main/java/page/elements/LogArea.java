package page.elements;

import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class LogArea extends BasePageElement {
    @FindBy(css = ".logs li")
    private List<WebElement> logEntries;

    private final int timeMarkSplitIndex = 9;

    public LogArea(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public List<String> getLogEntries() {
        return logEntries.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTimelessEntries() {
        return logEntries.stream()
                         .map(WebElement::getText)
                         .map(row -> row.substring(timeMarkSplitIndex))
                         .collect(Collectors.toList());
    }
}
