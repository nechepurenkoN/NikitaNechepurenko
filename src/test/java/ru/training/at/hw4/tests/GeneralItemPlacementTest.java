package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature("Testing index page for correct placement of elements")
public class GeneralItemPlacementTest extends BaseJdiTestingIndexPageTest {

    @Story("Checking the content of navbar, sidebar, iframe and benefit group")
    @Test
    public void firstExerciseItemPlacementTest() {

        // 1. Open test site by URL
        actionStep.openJdiTestingIndexPage();
        assertionStep.indexPageIsOpenedCorrectlyByURL();

        // 2. Assert Browser title
        assertionStep.indexPageTitleIsCorrect();

        // 3. Perform login
        actionStep.performLogin(user.getLogin(), user.getPassword());

        // 4. Assert Username is loggined
        assertionStep.usernameIsLoggedInSuccessfully(user.getUsername());

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.headerNavbarIsDisplayedWithProperTexts();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.benefitGroupItemsAreDisplayedWithProperContent();

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.thereIsAFrameWithButton();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.getIframeInScope();
        assertionStep.iframeWithButtonInScope();

        // 10. Switch to original window back
        actionStep.getWindowInScope();
        assertionStep.windowInScope();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.sidebarNavIsDisplayedWithProperTexts();
    }

}
