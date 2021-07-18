package ru.training.at.hw7.tests;

import static ru.training.at.hw7.page.elements.LoginForm.userName;
import static ru.training.at.hw7.page.objects.JdiTestingSite.homePage;
import static ru.training.at.hw7.page.objects.JdiTestingSite.loginForm;
import static ru.training.at.hw7.page.objects.JdiTestingSite.metalAndColorsPage;

import org.testng.annotations.Test;
import ru.training.at.hw7.dto.MetalAndColors;
import ru.training.at.hw7.dto.User;
import ru.training.at.hw7.providers.MetalAndColorsData;

public class MetalsAndColorsPageTest implements TestsInit {

    @Test(
        dataProvider = "romanWithMetalAndColors",
        dataProviderClass = MetalAndColorsData.class
    )
    public void openJdiTestingSite(User user, MetalAndColors formData) {
        homePage.open();
        homePage.checkOpened();
        loginForm.login(user);
        userName.assertThat().displayed();
        homePage.openMetalsAndColorsPage();
        metalAndColorsPage.checkOpened();
        metalAndColorsPage.submit(formData);
        metalAndColorsPage.assertThat().resultIsMatch(formData);
        loginForm.logout();
    }
}
