package ru.training.at.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import page.elements.ColorDropdownList;
import page.elements.ElementCheckboxGroup;
import page.elements.MetalRadioButtonGroup;
import page.elements.UserTableRow;

public class WhenStep extends AbstractStep {
    @When("I select the following element checkboxes")
    public void selectDifferentElementsCheckboxes(DataTable singleRecordTable) {
        ElementCheckboxGroup checkboxGroup = dePage.getCheckboxGroup();
        String[] labels = singleRecordTable.asList().get(0).split(", ");
        Stream.of(labels).forEach(checkboxGroup::selectCheckboxByText);
        assertThat(Arrays.stream(labels).map(checkboxGroup::isCheckedByText)).allMatch(x -> x);
    }

    @When("I select the following metal radio button")
    public void selectDifferentElementsRadioButton(DataTable singleRecordTable) {
        MetalRadioButtonGroup radioButtonGroup = dePage.getRadioButtonGroup();
        String value = singleRecordTable.asList().get(0);
        radioButtonGroup.selectButtonByText(value);
        assertThat(radioButtonGroup.isSelectedByText(value)).isTrue();
    }

    @When("I select the following color from dropdown list")
    public void selectDifferentElementsDropdownList(DataTable singleRecordTable) {
        ColorDropdownList colorDropdownList = dePage.getColorDropdownList();
        String value = singleRecordTable.asList().get(0);
        colorDropdownList.selectByValue(value);
        assertThat(colorDropdownList.getActualColor()).isEqualTo(value);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForUsername(String username) {
        Optional<UserTableRow> userRow = userTablePage.getTable().getRows().stream()
                                                    .filter(row -> row.getName().equals(username))
                                                    .findFirst();
        userRow.ifPresentOrElse(UserTableRow::selectVipCheckbox, () -> {
            throw new IllegalArgumentException(String.format("Cannot find user by %s username", username));
        });
        assertThat(userRow.get().isCheckBoxChecked()).isTrue();
    }
}
