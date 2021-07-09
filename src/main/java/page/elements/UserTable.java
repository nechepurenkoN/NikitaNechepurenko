package page.elements;

import driver.DriverWrapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class UserTable extends BasePageElement {

    @FindBy(css = "#user-table > tbody > tr")
    protected List<WebElement> rows;

    public UserTable(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public UserTableRow getRow(int index) {
        return new UserTableRow(driver, rows.get(index));
    }

    public UserTableRow getRow(String username) {
        return getRows().stream()
                        .filter(row -> row.getName().equals(username))
                        .findFirst()
                        .get();
    }

    public List<UserTableRow> getRows() {
        return rows.stream().map(row -> new UserTableRow(driver, row)).collect(Collectors.toList());
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return getRows().stream()
                        .map(UserTableRow::getRole)
                        .collect(Collectors.toList());
    }

    public List<WebElement> getUsernames() {
        return getRows().stream()
                        .map(UserTableRow::getUserHolder)
                        .map(holder -> holder.findElement(By.tagName("a")))
                        .collect(Collectors.toList());
    }

    public List<WebElement> getDescriptionTextsUnderImages() {
        return getRows().stream()
                        .map(UserTableRow::getDescription)
                        .map(holder -> holder.findElement(By.tagName("span")))
                        .collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxes() {
        return getRows().stream()
                        .map(UserTableRow::getDescription)
                        .map(holder -> holder.findElement(By.tagName("input")))
                        .collect(Collectors.toList());
    }
}
