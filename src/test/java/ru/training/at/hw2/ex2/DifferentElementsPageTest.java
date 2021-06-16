package ru.training.at.hw2.ex2;

import java.util.List;
import java.util.stream.IntStream;
import org.checkerframework.common.value.qual.IntRange;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseJdiTestingIndexPageTest;
import ru.training.at.hw2.data.DifferentElementsPageData;

public class DifferentElementsPageTest extends BaseJdiTestingIndexPageTest {

    private static final By PARENT_NODE = By.xpath("./..");

    @Test
    public void secondExerciseDifferentElementsTest() {
        openTestSiteByURL();
        assertBrowserTitle();
        performLogin();
        assertUserName();
        openDifferentElementsPage();
        selectWaterAndWindCheckboxes();
        selectSelenInRadio();
        selectYellowInDropdown();
        checkLogs();
        assertAccumulator.assertAll();
    }

    private void openDifferentElementsPage() {
        // 5. Open through the header menu Service -> Different Elements Page
        driver.findElement(Locators.DROPDOWN).click();
        WebElement linkElement = driver.findElement(Locators.DIFFERENT_ELEMENTS_PAGE_LINK);
        String link = linkElement.getAttribute(DifferentElementsPageData.HREF_ATTRIBUTE);
        assertAccumulator.assertEquals(link, DifferentElementsPageData.DIFFERENT_ELEMENTS_PAGE_LINK);

        linkElement.click();

        assertAccumulator.assertEquals(
            driver.getTitle(),
            DifferentElementsPageData.DIFFERENT_ELEMENTS_TITLE
        );
    }

    private void selectWaterAndWindCheckboxes() {
        // 6. Select checkboxes
        List<WebElement> checkboxes = driver.findElements(Locators.CHECKBOXES);
        assertAccumulator.assertEquals(checkboxes.size(), DifferentElementsPageData.CHECKBOXES_COUNT);

        WebElement waterCheckBox = checkboxes.get(DifferentElementsPageData.WATER_CHECKBOX_ORDER);
        assertAccumulator.assertEquals(
            waterCheckBox.findElement(PARENT_NODE).getText(),
            DifferentElementsPageData.WATER_CHECKBOX_LABEL
        );

        WebElement windCheckBox = checkboxes.get(DifferentElementsPageData.WIND_CHECKBOX_ORDER);
        assertAccumulator.assertEquals(
            windCheckBox.findElement(PARENT_NODE).getText(),
            DifferentElementsPageData.WIND_CHECKBOX_LABEL
        );

        assertAccumulator.assertTrue(waterCheckBox.isDisplayed());
        assertAccumulator.assertTrue(windCheckBox.isDisplayed());
        assertAccumulator.assertFalse(waterCheckBox.isSelected());
        assertAccumulator.assertFalse(windCheckBox.isSelected());

        waterCheckBox.click();
        windCheckBox.click();

        assertAccumulator.assertTrue(waterCheckBox.isSelected());
        assertAccumulator.assertTrue(windCheckBox.isSelected());
    }

    private void selectSelenInRadio() {
        // 7. Select radio
        List<WebElement> radioButtons = driver.findElements(Locators.RADIO_BUTTONS);
        assertAccumulator.assertEquals(radioButtons.size(), DifferentElementsPageData.RADIO_BUTTONS_COUNT);

        WebElement selenButton = radioButtons.get(DifferentElementsPageData.SELEN_RADIO_ORDER);
        assertAccumulator.assertTrue(selenButton.isDisplayed());
        assertAccumulator.assertFalse(selenButton.isSelected());

        selenButton.click();
        assertAccumulator.assertTrue(selenButton.isSelected());
    }

    private void selectYellowInDropdown() {
        // 8. Select in dropdown
        Select dropdownSelect = new Select(driver.findElement(Locators.COLOR_DROPDOWN));
        dropdownSelect.selectByVisibleText(DifferentElementsPageData.YELLOW);

        assertAccumulator.assertEquals(
            dropdownSelect.getFirstSelectedOption().getText(),
            DifferentElementsPageData.YELLOW
        );
    }

    private void checkLogs() {
        /* 9. Assert that
                for each checkbox there is an individual log row and value is corresponded to the status of checkbox
                for radio button there is a log row and value is corresponded to the status of radio button
                for dropdown there is a log row and value is corresponded to the selected value.
        */
        List<WebElement> logEntries = driver.findElements(Locators.LOG_ITEMS);
        assertAccumulator.assertEquals(logEntries.size(), DifferentElementsPageData.EXPECTED_LOGS_COUNT);

        IntStream.range(0, logEntries.size())
                 .forEach(index -> {
                     assertAccumulator.assertTrue(
                         logEntries.get(index).getText().endsWith(DifferentElementsPageData.LOGS_SUFFIXES.get(index))
                     );
                 });
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
