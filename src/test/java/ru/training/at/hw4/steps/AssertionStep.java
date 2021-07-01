package ru.training.at.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import data.DifferentElementsPageData;
import data.JdiTestingIndexPageData;
import driver.DriverWrapper;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import page.elements.Benefit;
import page.elements.ElementCheckboxGroup;
import page.elements.HeaderNavbar;
import page.elements.IFrame;
import page.elements.MetalRadioButtonGroup;
import page.elements.SidebarNav;

public class AssertionStep extends AbstractStep {

    public AssertionStep(DriverWrapper driver) {
        super(driver);
    }

    @Step("Assert that url for index page is correct")
    public void indexPageIsOpenedCorrectlyByURL() {
        assertThat(indexPage.getActualURL()).isEqualTo(JdiTestingIndexPageData.PAGE_URL);
    }

    @Step("Assert that title for index page is correct")
    public void indexPageTitleIsCorrect() {
        assertThat(indexPage.getActualTitle()).isEqualTo(JdiTestingIndexPageData.PAGE_TITLE);
    }

    @Step("Assert that user is logged in")
    public void usernameIsLoggedInSuccessfully(String username) {
        SoftAssertions sa = new SoftAssertions();

        assertThat(indexPage.getLoginForm().isLoggedIn()).isTrue();
        sa.assertThat(indexPage.getLoginForm().isUsernameLabelDisplayed()).isTrue();
        sa.assertThat(indexPage.getLoginForm().getCurrentUser()).isEqualTo(username.toUpperCase());

        sa.assertAll();
    }

    @Step("Assert that title for de page is correct")
    public void dePageTitleIsCorrect() {
        assertThat(dePage.getActualTitle()).isEqualTo(DifferentElementsPageData.DIFFERENT_ELEMENTS_TITLE);
    }

    @Step("Assert that checkboxes with Water and Wind values are selected")
    public void elementCheckboxesSelectedCorrectly() {
        ElementCheckboxGroup checkboxGroup = dePage.getCheckboxGroup();
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(checkboxGroup.getWaterCheckboxText()).isEqualTo(DifferentElementsPageData.WATER_CHECKBOX_LABEL);
        sa.assertThat(checkboxGroup.isWaterCheckboxSelected()).isTrue();
        sa.assertThat(checkboxGroup.getWindCheckboxText()).isEqualTo(DifferentElementsPageData.WIND_CHECKBOX_LABEL);
        sa.assertThat(checkboxGroup.isWindCheckboxSelected()).isTrue();

        sa.assertAll();
    }

    @Step("Assert that selected radiobutton is Selen")
    public void metalRadioButtonSelectedCorrectly() {
        MetalRadioButtonGroup radioButtonGroup = dePage.getRadioButtonGroup();
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(radioButtonGroup.isSelenButtonSelected()).isTrue();
        sa.assertThat(radioButtonGroup.getSelenButtonText()).isEqualTo(DifferentElementsPageData.SELEN);

        sa.assertAll();
    }

    @Step("Assert that selected color is yellow")
    public void colorDropdownListValueIsCorrect() {
        assertThat(dePage.getColorDropdownList().getActualColor()).isEqualTo(DifferentElementsPageData.YELLOW);
    }

    @Step("Assert that logs without timestamps contain selection actions in the correct order")
    public void logsAreCorrect() {
        assertThat(
            dePage.getLogArea().getLogEntries().stream()
                  .map(entry -> entry.substring(9)).collect(Collectors.toList())
        ).hasSize(DifferentElementsPageData.LOGS_SUFFIXES.size())
         .hasSameElementsAs(DifferentElementsPageData.LOGS_SUFFIXES);
    }

    @Step("Assert that header navbar have proper elements")
    public void headerNavbarIsDisplayedWithProperTexts() {
        HeaderNavbar headerNavbar = indexPage.getHeaderNavbar();
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(headerNavbar.isDisplayed()).isTrue();
        sa.assertThat(headerNavbar.getItemsTexts())
            .hasSize(JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT.size())
            .hasSameElementsAs(JdiTestingIndexPageData.HEADER_MENU_ITEMS_TEXT);

        sa.assertAll();
    }

    @Step("Assert that benefit block have proper images and texts below")
    public void benefitGroupItemsAreDisplayedWithProperContent() {
        Benefit benefitBlock = indexPage.getBenefitBlock();
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(benefitBlock.areImagesDisplayed()).isTrue();
        sa.assertThat(benefitBlock.getImages().size()).isEqualTo(JdiTestingIndexPageData.IMAGE_COUNT);
        sa.assertThat(benefitBlock.areTextsDisplayed()).isTrue();
        sa.assertThat(benefitBlock.getTextsAsStrings()).isEqualTo(JdiTestingIndexPageData.BENEFIT_TEXTS);
        sa.assertThat(benefitBlock.getTextsAsStrings()).hasSameElementsAs(JdiTestingIndexPageData.BENEFIT_TEXTS);

        sa.assertAll();
    }

    @Step("Assert that there is a iframe with a button in it")
    public void thereIsAFrameWithButton() {
        assertThat(indexPage.getIframeWithButton().isDisplayed()).isTrue();
    }

    @Step("Assert that iframe with a button is in scope of driver")
    public void iframeWithButtonInScope() {
        IFrame iframeWithButton = indexPage.getIframeWithButton();
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(iframeWithButton.isInScope()).isTrue();
        sa.assertThat(iframeWithButton.isButtonDisplayed()).isTrue();
        sa.assertThat(iframeWithButton.getButtonText()).isEqualTo(JdiTestingIndexPageData.FRAME_INNER_BUTTON_TEXT);

        sa.assertAll();
    }

    @Step("Assert that original window is in scope of driver")
    public void windowInScope() {
        assertThat(indexPage.isInScope()).isTrue();
    }

    @Step("Assert that sidebar navigation have proper elements")
    public void sidebarNavIsDisplayedWithProperTexts() {
        SidebarNav sidebarNav = indexPage.getSidebarNav();
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(sidebarNav.isDisplayed()).isTrue();
        sa.assertThat(sidebarNav.getItemsTexts().size()).isEqualTo(JdiTestingIndexPageData.SIDEBAR_ITEMS.size());
        sa.assertThat(sidebarNav.getItemsTexts()).hasSameElementsAs(JdiTestingIndexPageData.SIDEBAR_ITEMS);

        sa.assertAll();
    }

    @Step("Assert that checkboxes with {labels} selected")
    public void checkboxesSelectedCorrectly(String... labels) {
        ElementCheckboxGroup checkboxGroup = dePage.getCheckboxGroup();
        assertThat(Arrays.stream(labels).map(checkboxGroup::isCheckedByText)).allMatch(x -> x);
    }

    @Step("Assert that radio button with value {value} is selected")
    public void radioButtonSelectedCorrectly(String value) {
        assertThat(dePage.getRadioButtonGroup().isSelectedByText(value)).isTrue();
    }

    @Step("Assert that dropdown list value {value} is selected")
    public void dropdownListValueIsCorrect(String value) {
        assertThat(dePage.getColorDropdownList().getActualColor()).isEqualTo(value);
    }
}
