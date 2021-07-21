package ru.training.at.hw7.tests;

import static ru.training.at.hw7.page.objects.JdiTestingSite.homePage;
import static ru.training.at.hw7.page.objects.JdiTestingSite.metalAndColorsPage;
import static ru.training.at.hw7.providers.UsersProvider.DEFAULT_USERNAME;

import org.testng.annotations.Test;
import ru.training.at.hw7.annotations.LoginAs;
import ru.training.at.hw7.dto.MetalAndColors;
import ru.training.at.hw7.providers.MetalAndColorsData;

public class MetalsAndColorsPageTest implements TestsInit, HomePageStart, PossibleLogin {

    @Test(
        dataProvider = "romanWithMetalAndColors",
        dataProviderClass = MetalAndColorsData.class
    )
    @LoginAs(username = DEFAULT_USERNAME)
    public void metalAndColorsPageFormTest(MetalAndColors formData) {
        homePage.openMetalsAndColorsPage();
        metalAndColorsPage.checkOpened();
        metalAndColorsPage.submit(formData);
        metalAndColorsPage.assertThat().resultIsMatch(formData);
    }
}
