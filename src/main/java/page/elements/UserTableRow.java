package page.elements;

import data.UserRow;
import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import page.BasePageElement;

public class UserTableRow extends BasePageElement {

    @FindBy(css = "td:nth-child(1)")
    @Getter
    private WebElement numberHolder;

    @FindBy(css = "td:nth-child(2)")
    @Getter
    private WebElement role;

    @FindBy(css = "td:nth-child(3)")
    @Getter
    private WebElement userHolder;

    @FindBy(css = "td:nth-child(4)")
    @Getter
    private WebElement description;

    public UserTableRow(DriverWrapper driver, WebElement webElement) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(webElement), this);
    }

    public String getName() {
        return userHolder.findElement(By.tagName("a")).getText();
    }

    public UserRow getUser() {
        return new UserRow(
            numberHolder.getText(),
            getName(),
            description.findElement(By.tagName("span")).getText(),
            getRolesList()
        );
    }

    public List<String> getRolesList() {
        return new Select(role.findElement(By.tagName("select"))).getOptions().stream()
                                                                 .map(WebElement::getText)
                                                                 .collect(Collectors.toList());
    }

    public void selectVipCheckbox() {
        if (!isCheckBoxChecked()) {
            click(description.findElement(By.tagName("input")));
        }
    }

    public boolean isCheckBoxChecked() {
        return description.findElement(By.tagName("input")).isSelected();
    }
}
