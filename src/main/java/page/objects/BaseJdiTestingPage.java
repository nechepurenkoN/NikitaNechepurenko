package page.objects;

import driver.DriverWrapper;
import lombok.Getter;
import page.BasePageElement;
import page.elements.HeaderNavbar;
import page.elements.LoginForm;
import page.elements.SidebarNav;

@Getter
public class BaseJdiTestingPage extends BasePageElement {
    protected final LoginForm loginForm;
    protected final HeaderNavbar headerNavbar;
    protected final SidebarNav sidebarNav;

    public BaseJdiTestingPage(DriverWrapper driver) {
        super(driver);
        loginForm = new LoginForm(driver);
        headerNavbar = new HeaderNavbar(driver);
        sidebarNav = new SidebarNav(driver);
    }

    public String getActualURL() {
        return driver.getCurrentUrl();
    }

    public String getActualTitle() {
        return driver.getTitle();
    }

    public void loginUser(String login, String password) {
        loginForm.loginUser(login, password);
    }

    public boolean isLoggedIn() {
        return loginForm.isLoggedIn();
    }

    public String getCurrentUser() {
        return loginForm.getCurrentUser();
    }

    public boolean isUsernameLabelDisplayed() {
        return loginForm.isUsernameLabelDisplayed();
    }
}
