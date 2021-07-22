package ru.training.at.hw7.page.objects;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class HomePage extends WebPage {
    @UI("//header//a[@href='metals-colors.html']")
    public static Link headerMetalAndColorsLink;

    public void openMetalsAndColorsPage() {
        headerMetalAndColorsLink.click();
    }
}
