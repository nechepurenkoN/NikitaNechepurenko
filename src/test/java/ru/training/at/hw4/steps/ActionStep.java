package ru.training.at.hw4.steps;

import driver.DriverWrapper;
import io.qameta.allure.Step;
import java.util.Arrays;
import page.elements.ElementCheckboxGroup;

public class ActionStep extends AbstractStep {
    public ActionStep(DriverWrapper driver) {
        super(driver);
    }

    @Step("Open JdiTesting index page")
    public void openJdiTestingIndexPage() {
        indexPage.open();
    }

    @Step("Perform login with login {login} and password {password}")
    public void performLogin(String login, String password) {
        indexPage.getLoginForm().loginUser(login, password);
    }

    @Step("Open JdiTesting different elements page")
    public void openDifferentElementsPage() {
        indexPage.openDifferentElementsPage();
    }

    @Step("Select Water and Wind checkboxes")
    public void selectElementCheckboxes() {
        dePage.getCheckboxGroup()
              .selectWaterCheckbox()
              .selectWindCheckbox();
    }

    @Step("Select {value} radio button")
    public void selectRadioButton(String value) {
        dePage.getRadioButtonGroup().selectButtonByText(value);
    }

    @Step("Select {value} from dropdown list")
    public void selectDropdownList(String value) {
        dePage.getColorDropdownList().selectByValue(value);
    }

    @Step("Set the window scope in iframe")
    public void getIframeInScope() {
        indexPage.getIframeWithButton().getInScope();
    }

    @Step("Set original window scope")
    public void getWindowInScope() {
        indexPage.getInScope();
    }

    @Step("Select checkboxes by values {values}")
    public void selectCheckboxesByValues(String... values) {
        ElementCheckboxGroup checkboxGroup = dePage.getCheckboxGroup();
        Arrays.stream(values).forEach(checkboxGroup::selectCheckboxByText);
    }
}
