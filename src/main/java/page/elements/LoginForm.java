package page.elements;

import driver.DriverWrapper;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.BasePageElement;

public class LoginForm extends BasePageElement {

    @FindBy(css = ".navbar-right .dropdown-toggle")
    private WebElement dropdownButton;

    @FindBy(id = "name")
    private WebElement loginInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernamePlaceholder;

    @FindBy(css = ".logout > button")
    private WebElement logoutButton;

    public LoginForm(DriverWrapper driver) {
        super(driver);
        PageFactory.initElements(driver.self(), this);
    }

    public void loginUser(String login, String password) {
        if (isLoggedIn()) {
            throw new InvalidElementStateException("User is already logged in");
        }

        if (!isLoginFormShown()) {
            click(dropdownButton);
        }

        sendKeys(loginInputField, login);
        sendKeys(passwordInputField, password);
        click(loginButton);
    }

    public void logoutUser() {
        if (!isLoggedIn()) {
            throw new InvalidElementStateException("User is not logged in");
        }

        if (!isLogoutFormShown()) {
            click(dropdownButton);
        }

        click(logoutButton);
    }

    public boolean isLoggedIn() {
        return usernamePlaceholder.isDisplayed();
    }

    private boolean isLoginFormShown() {
        return loginInputField.isDisplayed()
            && passwordInputField.isDisplayed()
            && loginButton.isDisplayed();
    }

    private boolean isLogoutFormShown() {
        return logoutButton.isDisplayed();
    }

    public String getCurrentUser() {
        if (!isLoggedIn()) {
            throw new IllegalStateException("User is not logged in");
        }

        return usernamePlaceholder.getText();
    }

    public boolean isUsernameLabelDisplayed() {
        return usernamePlaceholder.isDisplayed();
    }
}
