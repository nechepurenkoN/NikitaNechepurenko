package ru.training.at.hw2.ex2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseJdiTestingIndexPageTest;
import ru.training.at.hw2.data.DifferentElementsPageData;
import ru.training.at.hw2.data.JdiTestingIndexPageData;

public class DifferentElementsPageTest extends BaseJdiTestingIndexPageTest {

    private static final By PARENT_NODE = By.xpath("./..");

    @Test
    public void secondExerciseDifferentElementsTest() {
        SoftAssertions assertAccumulator = new SoftAssertions();
        // 1. Open test site by URL
        openSiteByURL(JdiTestingIndexPageData.PAGE_URL);
        assertOpenedSiteIsCorrectByURL(assertAccumulator, getActualURL(), JdiTestingIndexPageData.PAGE_URL);

        // 2. Assert Browser title
        assertBrowserTitle(assertAccumulator, getActualTitle(), JdiTestingIndexPageData.PAGE_TITLE);

        // 3. Perform login
        performLogin(JdiTestingIndexPageData.LOGIN, JdiTestingIndexPageData.PASSWORD);

        // 4. Assert Username is loggined
        assertLoginSuccess(assertAccumulator, isLogoutButtonDisplayed());
        assertUsernameLabelIsDisplayed(assertAccumulator, isUsernameLabelDisplayed());
        assertUsername(assertAccumulator, getActualUsername(), JdiTestingIndexPageData.USERNAME.toUpperCase());

        // 5. Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage();
        assertCurrentPageIsDifferentElementsPage(
            assertAccumulator,
            getActualTitle(),
            DifferentElementsPageData.DIFFERENT_ELEMENTS_TITLE
        );

        // 6. Select checkboxes
        selectCheckbox(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WATER_CHECKBOX_ORDER));
        assertCheckBoxText(
            assertAccumulator,
            getCheckboxText(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WATER_CHECKBOX_ORDER)),
            DifferentElementsPageData.WATER_CHECKBOX_LABEL
        );
        assertCheckboxChecked(
            assertAccumulator,
            isChecked(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WATER_CHECKBOX_ORDER))
        );
        selectCheckbox(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WIND_CHECKBOX_ORDER));
        assertCheckBoxText(
            assertAccumulator,
            getCheckboxText(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WIND_CHECKBOX_ORDER)),
            DifferentElementsPageData.WIND_CHECKBOX_LABEL
        );
        assertCheckboxChecked(
            assertAccumulator,
            isChecked(getCheckboxByOrder(getCheckboxes(), DifferentElementsPageData.WIND_CHECKBOX_ORDER))
        );

        // 7. Select radio
        assertRadioButtonIsSelected(
            assertAccumulator,
            !isRadioSelected(getRadioByOrder(getRadioButtons(), DifferentElementsPageData.SELEN_RADIO_ORDER))
        );
        selectRadio(getRadioByOrder(getRadioButtons(), DifferentElementsPageData.SELEN_RADIO_ORDER));
        assertRadioButtonIsSelected(
            assertAccumulator,
            isRadioSelected(getRadioByOrder(getRadioButtons(), DifferentElementsPageData.SELEN_RADIO_ORDER))
        );
        assertRadioButtonText(
            assertAccumulator,
            getRadioButtonText(getRadioByOrder(getRadioButtons(), DifferentElementsPageData.SELEN_RADIO_ORDER)),
            DifferentElementsPageData.SELEN
        );

        // 8. Select in dropdown
        selectInDropdownListByText(getDropdownList(), DifferentElementsPageData.YELLOW);
        assertDropdownListSelectedText(assertAccumulator, getActualDropdownListValue(),
            DifferentElementsPageData.YELLOW);

        /* 9. Assert that
                for each checkbox there is an individual log row and value is corresponded to the status of checkbox
                for radio button there is a log row and value is corresponded to the status of radio button
                for dropdown there is a log row and value is corresponded to the selected value.
        */
        assertTimelessLogsAreCorrect(assertAccumulator, getActualLogEntries(), DifferentElementsPageData.LOGS_SUFFIXES);

        assertAccumulator.assertAll();
    }

    private void openDifferentElementsPage() {
        driver.findElement(Locators.DROPDOWN).click();
        driver.findElement(Locators.DIFFERENT_ELEMENTS_PAGE_LINK).click();
    }

    private void assertCurrentPageIsDifferentElementsPage(SoftAssertions assertAccumulator, String actualTitle,
                                                          String expectedTitle) {
        assertAccumulator.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    private void selectCheckbox(WebElement checkbox) {
        checkbox.click();
    }

    private void assertCheckBoxText(SoftAssertions assertAccumulator, String actualText, String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
    }

    private void assertCheckboxChecked(SoftAssertions assertAccumulator, boolean isChecked) {
        assertAccumulator.assertThat(isChecked).isTrue();
    }

    private void selectRadio(WebElement radio) {
        radio.click();
    }

    private void assertRadioButtonIsSelected(SoftAssertions assertAccumulator, boolean isSelected) {
        assertAccumulator.assertThat(isSelected).isTrue();
    }

    private void assertRadioButtonText(SoftAssertions assertAccumulator, String actualText, String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
    }

    private void selectInDropdownListByText(WebElement dropdownList, String text) {
        new Select(dropdownList).selectByVisibleText(text);
    }

    private void assertDropdownListSelectedText(SoftAssertions assertAccumulator, String actualText,
                                                String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
    }

    private void assertTimelessLogsAreCorrect(SoftAssertions assertAccumulator, List<String> actualEntries,
                                              List<String> expectedEntries) {
        assertAccumulator.assertThat(
            actualEntries.stream().map(entry -> entry.substring(9)).collect(Collectors.toList())
        ).hasSize(expectedEntries.size()).hasSameElementsAs(expectedEntries);

    }

    private String getCheckboxText(WebElement checkbox) {
        return checkbox.findElement(PARENT_NODE).getText();
    }

    private boolean isChecked(WebElement checkbox) {
        return checkbox.isSelected();
    }

    private WebElement getCheckboxByOrder(List<WebElement> checkboxes, int order) {
        return checkboxes.get(order);
    }

    private List<WebElement> getCheckboxes() {
        return driver.findElements(Locators.CHECKBOXES);
    }

    private boolean isRadioSelected(WebElement radioButton) {
        return radioButton.isSelected();
    }

    private String getRadioButtonText(WebElement radioButton) {
        return radioButton.findElement(PARENT_NODE).getText();
    }

    private WebElement getRadioByOrder(List<WebElement> radioButtons, int order) {
        return radioButtons.get(order);
    }

    private List<WebElement> getRadioButtons() {
        return driver.findElements(Locators.RADIO_BUTTONS);
    }

    private WebElement getDropdownList() {
        return driver.findElement(Locators.COLOR_DROPDOWN);
    }

    private String getActualDropdownListValue() {
        return new Select(getDropdownList()).getFirstSelectedOption().getText();
    }

    private List<String> getActualLogEntries() {
        return driver.findElements(Locators.LOG_ITEMS).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private static class Locators {
        public static final By DROPDOWN = By.cssSelector(".nav .dropdown-toggle");
        public static final By DIFFERENT_ELEMENTS_PAGE_LINK = By.cssSelector(
            ".nav .dropdown-menu li:nth-child(8) > a"
        );
        public static final By CHECKBOXES = By.cssSelector(".checkbox-row .label-checkbox input");
        public static final By RADIO_BUTTONS = By.cssSelector(".checkbox-row .label-radio input");
        public static final By COLOR_DROPDOWN = By.cssSelector(".colors select");
        public static final By LOG_ITEMS = By.cssSelector(".logs li");
    }
}
