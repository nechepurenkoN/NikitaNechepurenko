package ru.training.at.hw7.page.elements;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw7.dto.User;

public class LoginForm extends Form<User> {
    @UI("#name")
    public static TextField name;
    @UI("#password")
    public static TextField password;
    @UI("#user-name")
    public static Text userName;
    @UI("#login-button")
    public static Button loginButton;
    @UI(".logout > button")
    public static Button logoutButton;
    @UI(".navbar-right .dropdown-toggle")
    public static Button dropdownButton;
    @UI(".login-txt")
    public static Text loginFailed;

    public void login(User user) {
        dropdownButton.click();
        this.fill(user);
        loginButton.click();
        loginFailed.assertThat().hidden();
        userName.assertThat().displayed();
    }

    public void logout() {
        if (!loginButton.isDisplayed()) {
            dropdownButton.click();
        }
        logoutButton.click();
    }
}
