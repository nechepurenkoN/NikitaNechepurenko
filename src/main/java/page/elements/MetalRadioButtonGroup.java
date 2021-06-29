package page.elements;

import data.DifferentElementsPageData;
import driver.DriverWrapper;
import org.openqa.selenium.By;

public class MetalRadioButtonGroup extends RadioButtonGroup {
    private static final By selector = By.cssSelector(".checkbox-row .label-radio input");

    public MetalRadioButtonGroup(DriverWrapper driver) {
        super(driver, selector);
    }

    public void selectSelenButton() {
        selectButtonByOrder(DifferentElementsPageData.SELEN_RADIO_ORDER);
    }

    public boolean isSelenButtonSelected() {
        return isSelectedByOrder(DifferentElementsPageData.SELEN_RADIO_ORDER);
    }

    public String getSelenButtonText() {
        return getButtonTextByOrder(DifferentElementsPageData.SELEN_RADIO_ORDER);
    }
}
