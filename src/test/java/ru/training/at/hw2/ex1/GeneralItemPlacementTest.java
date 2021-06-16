package ru.training.at.hw2.ex1;

import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseJdiTestingIndexPageTest;
import ru.training.at.hw2.data.JdiTestingIndexPageData;

public class GeneralItemPlacementTest extends BaseJdiTestingIndexPageTest {

    private static final String INNER_HTML_ATTRIBUTE = "innerHTML";

    @Test
    public void firstExerciseItemPlacementTest() {
        openTestSiteByURL();
        assertBrowserTitle();
        performLogin();
        assertUserName();
        assertHeaderNavbarItems();
        assertThereAreFourImagesOnThePage();
        checkIfTextsUnderTheImagesAreCorrect();
        checkIfThereIsAFrameWithButton();
        checkFrameInnerButton();
        switchToOriginalWindowBack();
        assertSidebarItems();
        assertAccumulator.assertAll();
    }

    private void assertHeaderNavbarItems() {
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuItems = driver.findElements(Locators.HEADER_NAVBAR_ITEMS);

        assertAccumulator.assertEquals(headerMenuItems.size(), JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT.size());

        IntStream.range(0, headerMenuItems.size())
                 .peek(index -> assertAccumulator.assertTrue(headerMenuItems.get(index).isDisplayed()))
                 .forEachOrdered(index -> {
                     assertAccumulator.assertEquals(
                         headerMenuItems.get(index).getText(),
                         JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT.get(index)
                     );
                 });
    }

    private void assertThereAreFourImagesOnThePage() {
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(Locators.BENEFIT_IMAGES);

        assertAccumulator.assertEquals(images.size(), JdiTestingIndexPageData.IMAGE_COUNT);
        images.forEach(image -> assertAccumulator.assertTrue(image.isDisplayed()));
    }

    private void checkIfTextsUnderTheImagesAreCorrect() {
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(Locators.BENEFIT_TEXTS);

        assertAccumulator.assertEquals(benefitTexts.size(), JdiTestingIndexPageData.BENEFIT_TEXTS.size());
        IntStream.range(0, JdiTestingIndexPageData.BENEFIT_TEXTS.size())
                 .peek(index -> benefitTexts.get(index).isDisplayed())
                 .forEachOrdered(index -> {
                     assertAccumulator.assertEquals(
                         benefitTexts.get(index).getText(),
                         JdiTestingIndexPageData.BENEFIT_TEXTS.get(index)
                     );
                 });
    }

    private void checkIfThereIsAFrameWithButton() {
        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement frame = driver.findElement(Locators.IFRAME_WITH_BUTTON);
        assertAccumulator.assertTrue(frame.isDisplayed());
    }

    private void checkFrameInnerButton() {
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement frame = driver.findElement(Locators.IFRAME_WITH_BUTTON);
        driver.switchTo().frame(frame);
        assertAccumulator.assertEquals(
            driver.findElement(Locators.TITLE).getAttribute(INNER_HTML_ATTRIBUTE),
            JdiTestingIndexPageData.FRAME_TITLE
        );

        WebElement button = driver.findElement(Locators.IFRAME_INNER_BUTTON);

        assertAccumulator.assertTrue(button.isDisplayed());
        assertAccumulator.assertEquals(
            button.getAttribute(JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT_ATTRIBUTE),
            JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT
        );
    }

    private void switchToOriginalWindowBack() {
        // 10. Switch to original window back
        driver.switchTo().defaultContent();
        assertAccumulator.assertEquals(
            driver.findElement(Locators.TITLE).getAttribute(INNER_HTML_ATTRIBUTE),
            JdiTestingIndexPageData.PAGE_TITLE
        );
    }

    private void assertSidebarItems() {
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarItems = driver.findElements(Locators.SIDEBAR_ITEMS);

        assertAccumulator.assertEquals(sidebarItems.size(), JdiTestingIndexPageData.SIDEBAR_ITEMS.size());

        IntStream.range(0, sidebarItems.size())
                 .peek(index -> assertAccumulator.assertTrue(sidebarItems.get(index).isDisplayed()))
                 .forEachOrdered(index -> {
                     assertAccumulator.assertEquals(
                         sidebarItems.get(index).getText(),
                         JdiTestingIndexPageData.SIDEBAR_ITEMS.get(index)
                     );
                 });
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
