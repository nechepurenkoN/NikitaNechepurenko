package page.objects;

import driver.DriverWrapper;
import lombok.Getter;
import page.elements.Benefit;
import page.elements.IFrame;
import page.elements.Title;
import utils.JdiTestingIndexPageData;

@Getter
public class JdiTestingIndexPage extends BaseJdiTestingPage {
    private final Title title;
    private final Benefit benefitBlock;
    private final IFrame iframeWithButton;

    public JdiTestingIndexPage(DriverWrapper driver) {
        super(driver);
        title = new Title(driver);
        benefitBlock = new Benefit(driver);
        iframeWithButton = new IFrame(driver);
    }

    public void open() {
        driver.get(JdiTestingIndexPageData.PAGE_URL);
    }

    public void getInScope() {
        driver.switchTo().defaultContent();
    }

    public boolean isInScope() {
        return title.getTitle().equals(JdiTestingIndexPageData.PAGE_TITLE);
    }

    public DifferentElementsPage openDifferentElementsPage() {
        headerNavbar.clickOnDropdown().clickOnDifferentElementsPageLink();
        return new DifferentElementsPage(driver);
    }
}
