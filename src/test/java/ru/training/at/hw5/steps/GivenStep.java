package ru.training.at.hw5.steps;

import static com.google.inject.Guice.createInjector;
import static org.assertj.core.api.Assertions.assertThat;

import data.JdiTestingIndexPageData;
import data.User;
import di.PropertiesModule;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import org.assertj.core.api.SoftAssertions;
import page.elements.LoginForm;

public class GivenStep extends AbstractStep {

    @ParameterType("\"(.*)\"")
    public User user(String username) {
        User userFromProperties = createInjector(new PropertiesModule()).getInstance(User.class);
        if (userFromProperties.getUsername().equals(username)) {
            return userFromProperties;
        }
        throw new IllegalArgumentException("No such user in the database");
    }

    @Given("I open JDI Testing index page")
    public void openJdiTestingIndexPage() {
        indexPage.open();
        assertThat(indexPage.getActualURL()).isEqualTo(JdiTestingIndexPageData.PAGE_URL);
        assertThat(indexPage.getActualTitle()).isEqualTo(JdiTestingIndexPageData.PAGE_TITLE);
    }

    @Given("I open JDI GitHub site")
    public void openJdiGithubSite() {
        openJdiTestingIndexPage();
    }

    @Given("I login as user {user}")
    public void loginAsUser(User user) {
        LoginForm loginForm = indexPage.getLoginForm();
        loginForm.loginUser(user.getLogin(), user.getPassword());

        SoftAssertions sa = new SoftAssertions();
        assertThat(loginForm.isLoggedIn()).isTrue();
        sa.assertThat(loginForm.isUsernameLabelDisplayed()).isTrue();
        sa.assertThat(loginForm.getCurrentUser()).isEqualTo(user.getUsername().toUpperCase());
        sa.assertAll();
    }

    @Given("I click on \"Service\" button in Header")
    public void clickOnServiceButtonInHeader() {
        indexPage.getHeaderNavbar().clickOnDropdown();
    }

    @Given("I click on {string} button in Service dropdown")
    public void clickOnSpecifiedButtonInServiceDropdown(String item) {
        indexPage.getHeaderNavbar().clickOnDropdownItemByName(item);
    }
}
