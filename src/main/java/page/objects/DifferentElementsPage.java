package page.objects;

import driver.DriverWrapper;
import lombok.Getter;
import page.elements.ColorDropdownList;
import page.elements.ElementCheckboxGroup;
import page.elements.LogArea;
import page.elements.MetalRadioButtonGroup;
import utils.DifferentElementsPageData;

@Getter
public class DifferentElementsPage extends BaseJdiTestingPage {

    private final ElementCheckboxGroup checkboxGroup;
    private final MetalRadioButtonGroup radioButtonGroup;
    private final ColorDropdownList colorDropdownList;
    private final LogArea logArea;

    public DifferentElementsPage(DriverWrapper driver) {
        super(driver);
        checkboxGroup = new ElementCheckboxGroup(driver);
        radioButtonGroup = new MetalRadioButtonGroup(driver);
        colorDropdownList = new ColorDropdownList(driver);
        logArea = new LogArea(driver);
    }

    public DifferentElementsPage open() {
        driver.navigate().to(DifferentElementsPageData.DIFFERENT_ELEMENTS_PAGE_LINK);
        return this;
    }
}
