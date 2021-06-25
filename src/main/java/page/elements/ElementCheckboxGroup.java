package page.elements;

import driver.DriverWrapper;
import org.openqa.selenium.By;
import utils.DifferentElementsPageData;

public final class ElementCheckboxGroup extends CheckboxGroup {
    private static final By selector = By.cssSelector(".checkbox-row .label-checkbox input");

    public ElementCheckboxGroup(DriverWrapper driver) {
        super(driver, selector);
    }

    public ElementCheckboxGroup selectWindCheckbox() {
        selectCheckboxByOrder(DifferentElementsPageData.WIND_CHECKBOX_ORDER);
        return this;
    }

    public String getWindCheckboxText() {
        return getCheckboxTextByOrder(DifferentElementsPageData.WIND_CHECKBOX_ORDER);
    }

    public boolean isWindCheckboxSelected() {
        return isCheckedByOrder(DifferentElementsPageData.WIND_CHECKBOX_ORDER);
    }

    public ElementCheckboxGroup selectWaterCheckbox() {
        selectCheckboxByOrder(DifferentElementsPageData.WATER_CHECKBOX_ORDER);
        return this;
    }

    public String getWaterCheckboxText() {
        return getCheckboxTextByOrder(DifferentElementsPageData.WATER_CHECKBOX_ORDER);
    }

    public boolean isWaterCheckboxSelected() {
        return isCheckedByOrder(DifferentElementsPageData.WATER_CHECKBOX_ORDER);
    }
}
