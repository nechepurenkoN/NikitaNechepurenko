package ru.training.at.hw3;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.elements.ColorDropdownList;
import page.elements.ElementCheckboxGroup;
import page.elements.LogArea;
import page.elements.LoginForm;
import page.elements.MetalRadioButtonGroup;
import page.objects.DifferentElementsPage;
import page.objects.JdiTestingIndexPage;
import utils.DifferentElementsPageData;
import utils.JdiTestingIndexPageData;

public class DifferentElementsPageTest extends BaseJdiTestingIndexPageTest {

    @Test
    public void secondExerciseDifferentElementsTest() {
        SoftAssertions assertAccumulator = new SoftAssertions();
        JdiTestingIndexPage indexPage = new JdiTestingIndexPage(driver);
        // 1. Open test site by URL
        indexPage.open();
        assertOpenedSiteIsCorrectByURL(assertAccumulator, indexPage.getActualURL(), JdiTestingIndexPageData.PAGE_URL);

        // 2. Assert Browser title
        assertBrowserTitle(assertAccumulator, indexPage.getActualTitle(), JdiTestingIndexPageData.PAGE_TITLE);

        // 3. Perform login
        LoginForm loginForm = indexPage.getLoginForm();
        loginForm.loginUser(JdiTestingIndexPageData.LOGIN, JdiTestingIndexPageData.PASSWORD);

        // 4. Assert Username is loggined
        assertLoginSuccess(assertAccumulator, loginForm.isLoggedIn());
        assertUsernameLabelIsDisplayed(assertAccumulator, loginForm.isUsernameLabelDisplayed());
        assertUsername(
            assertAccumulator,
            loginForm.getCurrentUser(),
            JdiTestingIndexPageData.USERNAME.toUpperCase()
        );

        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage dePage = indexPage.openDifferentElementsPage();
        assertCurrentPageIsDifferentElementsPage(
            assertAccumulator,
            dePage.getActualTitle(),
            DifferentElementsPageData.DIFFERENT_ELEMENTS_TITLE
        );

        // 6. Select checkboxes
        ElementCheckboxGroup checkboxGroup = dePage.getCheckboxGroup();
        checkboxGroup.selectWaterCheckbox()
                     .selectWindCheckbox();
        assertCheckBoxText(
            assertAccumulator,
            checkboxGroup.getWaterCheckboxText(),
            DifferentElementsPageData.WATER_CHECKBOX_LABEL
        );
        assertCheckboxChecked(assertAccumulator, checkboxGroup.isWaterCheckboxSelected());
        assertCheckBoxText(
            assertAccumulator,
            checkboxGroup.getWindCheckboxText(),
            DifferentElementsPageData.WIND_CHECKBOX_LABEL
        );
        assertCheckboxChecked(assertAccumulator, checkboxGroup.isWindCheckboxSelected());

        // 7. Select radio
        MetalRadioButtonGroup radioGroup = dePage.getRadioButtonGroup();
        assertRadioButtonIsSelected(assertAccumulator, !radioGroup.isSelenButtonSelected());
        radioGroup.selectSelenButton();
        assertRadioButtonIsSelected(assertAccumulator, radioGroup.isSelenButtonSelected());
        assertRadioButtonText(assertAccumulator, radioGroup.getSelenButtonText(), DifferentElementsPageData.SELEN);

        // 8. Select in dropdown
        ColorDropdownList colorDropdownList = dePage.getColorDropdownList();
        colorDropdownList.selectYellow();
        assertDropdownListSelectedText(
            assertAccumulator,
            colorDropdownList.getActualColor(),
            DifferentElementsPageData.YELLOW
        );

        /* 9. Assert that
                for each checkbox there is an individual log row and value is corresponded to the status of checkbox
                for radio button there is a log row and value is corresponded to the status of radio button
                for dropdown there is a log row and value is corresponded to the selected value.
        */
        LogArea logArea = dePage.getLogArea();
        assertTimelessLogsAreCorrect(
            assertAccumulator,
            logArea.getLogEntries(),
            DifferentElementsPageData.LOGS_SUFFIXES
        );

        assertAccumulator.assertAll();
    }

    private void assertCurrentPageIsDifferentElementsPage(SoftAssertions assertAccumulator, String actualTitle,
                                                          String expectedTitle) {
        assertAccumulator.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    private void assertCheckBoxText(SoftAssertions assertAccumulator, String actualText, String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
    }

    private void assertCheckboxChecked(SoftAssertions assertAccumulator, boolean isChecked) {
        assertAccumulator.assertThat(isChecked).isTrue();
    }

    private void assertRadioButtonIsSelected(SoftAssertions assertAccumulator, boolean isSelected) {
        assertAccumulator.assertThat(isSelected).isTrue();
    }

    private void assertRadioButtonText(SoftAssertions assertAccumulator, String actualText, String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
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
}
