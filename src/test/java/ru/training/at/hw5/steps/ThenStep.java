package ru.training.at.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.base.CaseFormat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import page.elements.UserTable;
import page.elements.UserTableRow;

public class ThenStep extends AbstractStep {
    @Then("Log rows are displayed with the following content")
    public void assertLogsHaveCorrectValues(DataTable table) {
        int expectedSize = table.asMaps().size();
        assertThat(dePage.getLogArea().getTimelessEntries()).hasSize(expectedSize).hasSameElementsAs(
            table.asMaps()
                 .stream().map(entry -> entry.get("Type") + ": " + entry.get("Log"))
                 .collect(Collectors.toList())
        );
    }

    @Then("{int} log row has {string} text in log section")
    public void assertLogRows(int count, String value) {
        assertThat(userTablePage.getLogArea().getTimelessEntries()).hasSize(count).hasSameElementsAs(
            Collections.singletonList(value)
        );
    }

    @Then("{string} page should be opened")
    public void assertCorrectPageIsOpened(String pageName) {
        assertThat(indexPage.getActualTitle()).containsIgnoringCase(pageName);
    }

    @Then("{int} {} should be displayed on Users Table on User Table Page")
    public void assertThatUserPageElementsAreDisplayed(int count, String type) {
        List<WebElement> elements = getUserTableElements(type);
        assertThat(elements).hasSize(count).allMatch(WebElement::isDisplayed);
    }

    @SneakyThrows
    private List<WebElement> getUserTableElements(String type) {
        String methodName = "get" + CaseFormat.UPPER_UNDERSCORE
            .to(CaseFormat.UPPER_CAMEL, type.toUpperCase(Locale.ROOT).replaceAll(" ", "_"));
        UserTable table = userTablePage.getTable();
        return (List<WebElement>) table.getClass().getMethod(methodName).invoke(table);
    }

    @Then("droplist should contain values in column Type for user {}")
    public void droplistShouldContainSpecifiedValuesForUser(String username, DataTable table) {
        assertThat(table.asList().stream().skip(1).collect(Collectors.toList())).hasSameElementsAs(
            userTablePage.getTable().getRow(username).getRolesList()
        );
    }

    @Then("User table should contain following values:")
    public void assertThatTableContainSpecifiedValues(DataTable table) {
        SoftAssertions sa = new SoftAssertions();
        List<Map<String, String>> tableMap = table.asMaps();
        UserTable userTable = userTablePage.getTable();

        sa.assertThat(
            tableMap.stream()
                    .map(mapObj -> mapObj.get("Number"))
                    .collect(Collectors.toList())
        ).hasSameElementsAs(
            userTable.getRows().stream()
                     .map(UserTableRow::getNumberHolder)
                     .map(WebElement::getText)
                     .collect(Collectors.toList())
        );

        sa.assertThat(
            tableMap.stream()
                    .map(mapObj -> mapObj.get("User"))
                    .collect(Collectors.toList())
        ).hasSameElementsAs(
            userTable.getUsernames().stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList())
        );

        sa.assertThat(
            tableMap.stream()
                    .map(mapObj -> mapObj.get("Description"))
                    .collect(Collectors.toList())
        ).hasSameElementsAs(
            userTable.getDescriptionTextsUnderImages().stream()
                     .map(webElement -> webElement.getAttribute("innerHTML"))
                     .map(text -> text.replaceAll("<br>", ""))
                     .collect(Collectors.toList())
        );

        sa.assertAll();
    }
}
