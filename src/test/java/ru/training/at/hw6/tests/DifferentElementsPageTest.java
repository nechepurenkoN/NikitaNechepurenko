package ru.training.at.hw6.tests;

import data.DifferentElementsPageData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Testing different elements page by selecting inputs and validating logs")
public class DifferentElementsPageTest extends BaseJdiTestingIndexPageTest {

    @Story("Selecting checkboxes, radio buttons and dropdown lists with log validation")
    @Test
    public void secondExerciseDifferentElementsTest() {

        // 1. Open test site by URL
        actionStep.openJdiTestingIndexPage();
        assertionStep.indexPageIsOpenedCorrectlyByURL();

        // 2. Assert Browser title
        assertionStep.indexPageTitleIsCorrect();
        // 3. Perform login
        actionStep.performLogin(user.getLogin(), user.getPassword());

        // 4. Assert Username is loggined
        assertionStep.usernameIsLoggedInSuccessfully(user.getUsername());

        // 5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();
        assertionStep.dePageTitleIsCorrect();

        // 6. Select checkboxes
        actionStep.selectCheckboxesByValues(
            DifferentElementsPageData.WATER_CHECKBOX_LABEL,
            DifferentElementsPageData.WIND_CHECKBOX_LABEL
        );

        assertionStep.checkboxesSelectedCorrectly(
            DifferentElementsPageData.WATER_CHECKBOX_LABEL,
            DifferentElementsPageData.WIND_CHECKBOX_LABEL
        );

        // 7. Select radio
        actionStep.selectRadioButton(DifferentElementsPageData.SELEN);
        assertionStep.radioButtonSelectedCorrectly(DifferentElementsPageData.SELEN);

        // 8. Select in dropdown
        actionStep.selectDropdownList(DifferentElementsPageData.YELLOW);
        assertionStep.dropdownListValueIsCorrect(DifferentElementsPageData.YELLOW);

        /* 9. Assert that
                for each checkbox there is an individual log row and value is corresponded to the status of checkbox
                for radio button there is a log row and value is corresponded to the status of radio button
                for dropdown there is a log row and value is corresponded to the selected value.
        */
        assertionStep.logsAreCorrect();
    }
}
