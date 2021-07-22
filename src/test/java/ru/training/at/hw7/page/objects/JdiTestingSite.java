package ru.training.at.hw7.page.objects;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.page.elements.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiTestingSite {
    @Url("/") @Title("Home Page")
    public static HomePage homePage;

    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalAndColorsPage metalAndColorsPage;

    public static LoginForm loginForm;
}
