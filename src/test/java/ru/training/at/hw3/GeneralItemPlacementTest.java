package ru.training.at.hw3;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.elements.Benefit;
import page.elements.HeaderNavbar;
import page.elements.IFrame;
import page.elements.SidebarNav;
import page.objects.JdiTestingIndexPage;
import utils.JdiTestingIndexPageData;

public class GeneralItemPlacementTest extends BaseJdiTestingIndexPageTest {

    @Test
    public void firstExerciseItemPlacementTest() {
        SoftAssertions assertAccumulator = new SoftAssertions();
        JdiTestingIndexPage indexPage = new JdiTestingIndexPage(driver);
        // 1. Open test site by URL
        indexPage.open();
        assertOpenedSiteIsCorrectByURL(assertAccumulator, indexPage.getActualURL(), JdiTestingIndexPageData.PAGE_URL);

        // 2. Assert Browser title
        assertBrowserTitle(assertAccumulator, indexPage.getActualTitle(), JdiTestingIndexPageData.PAGE_TITLE);

        // 3. Perform login
        indexPage.loginUser(JdiTestingIndexPageData.LOGIN, JdiTestingIndexPageData.PASSWORD);

        // 4. Assert Username is loggined
        assertLoginSuccess(assertAccumulator, indexPage.isLoggedIn());
        assertUsernameLabelIsDisplayed(assertAccumulator, indexPage.isUsernameLabelDisplayed());
        assertUsername(
            assertAccumulator,
            indexPage.getCurrentUser(),
            JdiTestingIndexPageData.USERNAME.toUpperCase()
        );

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        HeaderNavbar headerNavbar = indexPage.getHeaderNavbar();
        assertHeaderNavbarItemsCount(
            assertAccumulator,
            headerNavbar.getItemsTexts().size(),
            JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT.size()
        );
        assertHeaderNavbarItemsAllDisplayed(assertAccumulator, headerNavbar.isDisplayed());
        assertHeaderNavbarItemsHaveProperTexts(
            assertAccumulator,
            headerNavbar.getItemsTexts(),
            JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT
        );

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        Benefit benefitBlock = indexPage.getBenefitBlock();
        assertImagesCount(assertAccumulator, benefitBlock.getImages().size(), JdiTestingIndexPageData.IMAGE_COUNT);
        assertAllImagesDisplayed(assertAccumulator, benefitBlock.areImagesDisplayed());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertBenefitTextsCount(
            assertAccumulator,
            benefitBlock.getTexts().size(),
            JdiTestingIndexPageData.BENEFIT_TEXTS.size()
        );
        assertBenefitTextsAreCorrect(
            assertAccumulator,
            benefitBlock.getTextsAsStrings(),
            JdiTestingIndexPageData.BENEFIT_TEXTS
        );

        // 8. Assert that there is the iframe with “Frame Button” exist
        IFrame frame = indexPage.getIframeWithButton();
        assertFrameExists(assertAccumulator, frame.isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        frame.getInScope();
        assertFrameInScope(assertAccumulator, frame.isInScope());
        assertFrameButtonDisplayed(assertAccumulator, frame.isButtonDisplayed());
        assertFrameButtonText(
            assertAccumulator,
            frame.getButtonText(),
            JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT
        );

        // 10. Switch to original window back
        indexPage.getInScope();
        assertOriginalWindowInScope(assertAccumulator, indexPage.isInScope());

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        SidebarNav sidebarNav = indexPage.getSidebarNav();
        assertSidebarItemsCount(
            assertAccumulator,
            sidebarNav.getItemsTexts().size(),
            JdiTestingIndexPageData.SIDEBAR_ITEMS.size()
        );
        assertSidebarItemsDisplayed(assertAccumulator, sidebarNav.isDisplayed());
        assertSidebarItemsHaveProperTexts(
            assertAccumulator,
            sidebarNav.getItemsTexts(),
            JdiTestingIndexPageData.SIDEBAR_ITEMS
        );

        assertAccumulator.assertAll();
    }

    private void assertHeaderNavbarItemsCount(SoftAssertions assertAccumulator, int actualCount, int expectedCount) {
        assertAccumulator.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private void assertHeaderNavbarItemsAllDisplayed(SoftAssertions assertAccumulator, boolean isDisplayed) {
        assertAccumulator.assertThat(isDisplayed).isTrue();
    }

    private void assertHeaderNavbarItemsHaveProperTexts(SoftAssertions assertAccumulator, List<String> actualTexts,
                                                        List<String> expectedTexts) {
        assertAccumulator.assertThat(actualTexts).hasSize(expectedTexts.size()).hasSameElementsAs(expectedTexts);
    }

    private void assertImagesCount(SoftAssertions assertAccumulator, int actualImagesCount, int imageCount) {
        assertAccumulator.assertThat(actualImagesCount).isEqualTo(imageCount);
    }

    private void assertAllImagesDisplayed(SoftAssertions assertAccumulator, boolean areImagesDisplayed) {
        assertAccumulator.assertThat(areImagesDisplayed).isTrue();
    }

    private void assertBenefitTextsCount(SoftAssertions assertAccumulator, int actualCount, int expectedCount) {
        assertAccumulator.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private void assertBenefitTextsAreCorrect(SoftAssertions assertAccumulator, List<String> actualTexts,
                                              List<String> expectedTexts) {
        assertAccumulator.assertThat(actualTexts).hasSize(expectedTexts.size()).hasSameElementsAs(expectedTexts);
    }

    private void assertFrameExists(SoftAssertions assertAccumulator, boolean frameDisplayed) {
        assertAccumulator.assertThat(frameDisplayed).isTrue();
    }

    private void assertFrameInScope(SoftAssertions assertAccumulator, boolean frameWithButtonInScope) {
        assertAccumulator.assertThat(frameWithButtonInScope).isTrue();
    }

    private void assertFrameButtonDisplayed(SoftAssertions assertAccumulator, boolean frameButtonDisplayed) {
        assertAccumulator.assertThat(frameButtonDisplayed).isTrue();
    }

    private void assertFrameButtonText(SoftAssertions assertAccumulator, String actualText, String expectedText) {
        assertAccumulator.assertThat(actualText).isEqualTo(expectedText);
    }


    private void assertOriginalWindowInScope(SoftAssertions assertAccumulator, boolean originalWindowInScope) {
        assertAccumulator.assertThat(originalWindowInScope).isTrue();
    }

    private void assertSidebarItemsCount(SoftAssertions assertAccumulator, int actualCount, int expectedCount) {
        assertAccumulator.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private void assertSidebarItemsDisplayed(SoftAssertions assertAccumulator, boolean areSidebarItemsDisplayed) {
        assertAccumulator.assertThat(areSidebarItemsDisplayed).isTrue();
    }

    private void assertSidebarItemsHaveProperTexts(SoftAssertions assertAccumulator, List<String> actualTexts,
                                                   List<String> expectedTexts) {
        assertAccumulator.assertThat(actualTexts).hasSize(expectedTexts.size()).hasSameElementsAs(expectedTexts);
    }
}
