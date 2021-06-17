package ru.training.at.hw2.ex1;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseJdiTestingIndexPageTest;
import ru.training.at.hw2.data.JdiTestingIndexPageData;

public class GeneralItemPlacementTest extends BaseJdiTestingIndexPageTest {

    private static final String INNER_HTML_ATTRIBUTE = "innerHTML";

    @Test
    public void firstExerciseItemPlacementTest() {
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

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertHeaderNavbarItemsCount(
            assertAccumulator,
            getActualNavbarItemsCount(),
            JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT.size()
        );
        assertHeaderNavbarItemsAllDisplayed(assertAccumulator, isHeaderNavbarItemsDisplayed());
        assertHeaderNavbarItemsHaveProperTexts(
            assertAccumulator,
            getActualNavbarItemsTexts(),
            JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT
        );

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        assertImagesCount(assertAccumulator, getActualImagesCount(), JdiTestingIndexPageData.IMAGE_COUNT);
        assertAllImagesDisplayed(assertAccumulator, areImagesDisplayed());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertBenefitTextsCount(
            assertAccumulator,
            getBenefitTextsCount(),
            JdiTestingIndexPageData.BENEFIT_TEXTS.size()
        );
        assertBenefitTextsAreCorrect(assertAccumulator, getBenefitTexts(), JdiTestingIndexPageData.BENEFIT_TEXTS);

        // 8. Assert that there is the iframe with “Frame Button” exist
        assertFrameExists(assertAccumulator, isFrameWithButtonDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        switchToFrame(getFrameWithButton());
        assertFrameInScope(assertAccumulator, isFrameWithButtonInScope());
        assertFrameButtonDisplayed(assertAccumulator, isFrameButtonDisplayed());
        assertFrameButtonText(assertAccumulator, getFrameButtonText(), JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT);

        // 10. Switch to original window back
        switchToOriginalWindowBack();
        assertOriginalWindowInScope(assertAccumulator, isOriginalWindowInScope());

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertSidebarItemsCount(
            assertAccumulator,
            getActualSidebarItemsCount(),
            JdiTestingIndexPageData.SIDEBAR_ITEMS.size()
        );
        assertSidebarItemsDisplayed(assertAccumulator, areSidebarItemsDisplayed());
        assertSidebarItemsHaveProperTexts(
            assertAccumulator,
            getActualSidebarItemsTexts(),
            JdiTestingIndexPageData.SIDEBAR_ITEMS
        );

        assertAccumulator.assertAll();
    }

    private void assertHeaderNavbarItemsCount(SoftAssertions assertAccumulator, int actualCount, int expectedCount) {
        assertAccumulator.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private void assertHeaderNavbarItemsAllDisplayed(SoftAssertions assertAccumulator, List<Boolean> isDisplayed) {
        assertAccumulator.assertThat(isDisplayed).allMatch(x -> x);
    }

    private void assertHeaderNavbarItemsHaveProperTexts(SoftAssertions assertAccumulator, List<String> actualTexts,
                                                        List<String> expectedTexts) {
        assertAccumulator.assertThat(actualTexts).hasSize(expectedTexts.size()).hasSameElementsAs(expectedTexts);
    }

    private void assertImagesCount(SoftAssertions assertAccumulator, int actualImagesCount, int imageCount) {
        assertAccumulator.assertThat(actualImagesCount).isEqualTo(imageCount);
    }

    private void assertAllImagesDisplayed(SoftAssertions assertAccumulator, List<Boolean> areImagesDisplayed) {
        assertAccumulator.assertThat(areImagesDisplayed).allMatch(x -> x);
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

    private void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
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

    private void switchToOriginalWindowBack() {
        driver.switchTo().defaultContent();
    }

    private void assertOriginalWindowInScope(SoftAssertions assertAccumulator, boolean originalWindowInScope) {
        assertAccumulator.assertThat(originalWindowInScope).isTrue();
    }

    private void assertSidebarItemsCount(SoftAssertions assertAccumulator, int actualCount, int expectedCount) {
        assertAccumulator.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private void assertSidebarItemsDisplayed(SoftAssertions assertAccumulator, List<Boolean> areSidebarItemsDisplayed) {
        assertAccumulator.assertThat(areSidebarItemsDisplayed).allMatch(x -> x);
    }

    private void assertSidebarItemsHaveProperTexts(SoftAssertions assertAccumulator, List<String> actualTexts,
                                                   List<String> expectedTexts) {
        assertAccumulator.assertThat(actualTexts).hasSize(expectedTexts.size()).hasSameElementsAs(expectedTexts);
    }

    private List<Boolean> isHeaderNavbarItemsDisplayed() {
        return driver.findElements(Locators.HEADER_NAVBAR_ITEMS).stream()
                     .map(WebElement::isDisplayed).collect(Collectors.toList());
    }

    private int getActualNavbarItemsCount() {
        return driver.findElements(Locators.HEADER_NAVBAR_ITEMS).size();
    }

    private List<String> getActualNavbarItemsTexts() {
        return driver.findElements(Locators.HEADER_NAVBAR_ITEMS).stream()
                     .map(WebElement::getText).collect(Collectors.toList());
    }

    private int getActualImagesCount() {
        return driver.findElements(Locators.BENEFIT_IMAGES).size();
    }

    private List<Boolean> areImagesDisplayed() {
        return driver.findElements(Locators.BENEFIT_IMAGES).stream()
                     .map(WebElement::isDisplayed).collect(Collectors.toList());
    }

    private List<String> getBenefitTexts() {
        return driver.findElements(Locators.BENEFIT_TEXTS).stream()
                     .map(WebElement::getText).collect(Collectors.toList());
    }

    private int getBenefitTextsCount() {
        return driver.findElements(Locators.BENEFIT_TEXTS).size();
    }

    private boolean isFrameWithButtonDisplayed() {
        return driver.findElement(Locators.IFRAME_WITH_BUTTON).isDisplayed();
    }

    private WebElement getFrameWithButton() {
        return driver.findElement(Locators.IFRAME_WITH_BUTTON);
    }

    private boolean isFrameWithButtonInScope() {
        return driver.findElement(Locators.TITLE).getAttribute(INNER_HTML_ATTRIBUTE)
                     .equals(JdiTestingIndexPageData.FRAME_TITLE);
    }

    private boolean isFrameButtonDisplayed() {
        return driver.findElement(Locators.IFRAME_INNER_BUTTON).isDisplayed();
    }

    private String getFrameButtonText() {
        return driver.findElement(Locators.IFRAME_INNER_BUTTON)
                     .getAttribute(JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT_ATTRIBUTE);
    }

    private boolean isOriginalWindowInScope() {
        return driver.findElement(Locators.TITLE).getAttribute(INNER_HTML_ATTRIBUTE)
                     .equals(JdiTestingIndexPageData.PAGE_TITLE);
    }

    private int getActualSidebarItemsCount() {
        return driver.findElements(Locators.SIDEBAR_ITEMS).size();
    }

    private List<Boolean> areSidebarItemsDisplayed() {
        return driver.findElements(Locators.SIDEBAR_ITEMS).stream()
                     .map(WebElement::isDisplayed).collect(Collectors.toList());
    }

    private List<String> getActualSidebarItemsTexts() {
        return driver.findElements(Locators.SIDEBAR_ITEMS).stream()
                     .map(WebElement::getText).collect(Collectors.toList());
    }

    private static class Locators {
        public static final By HEADER_NAVBAR_ITEMS = By.cssSelector(".nav > li > a");
        public static final By BENEFIT_IMAGES = By.className("icons-benefit");
        public static final By BENEFIT_TEXTS = By.className("benefit-txt");
        public static final By IFRAME_WITH_BUTTON = By.id("frame");
        public static final By IFRAME_INNER_BUTTON = By.id("frame-button");
        public static final By TITLE = By.tagName("title");
        public static final By SIDEBAR_ITEMS = By.cssSelector(".sidebar-menu > li > a > span");
    }
}
