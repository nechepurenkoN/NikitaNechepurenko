package page.objects;

import driver.DriverWrapper;
import lombok.Getter;
import page.elements.LogArea;
import page.elements.UserTable;

public class UserTablePage extends BaseJdiTestingPage {
    @Getter
    protected final UserTable table;

    @Getter
    protected final LogArea logArea;

    public UserTablePage(DriverWrapper driver) {
        super(driver);
        table = new UserTable(driver);
        logArea = new LogArea(driver);
    }
}
