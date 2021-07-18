package ru.training.at.hw7.page.objects;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class HomePage extends WebPage {
    @UI(".nav > li:nth-child(4) > a")
    public static Link headerMetalAndColorsLink;

    public void openMetalsAndColorsPage() {
        headerMetalAndColorsLink.click();
    }
}
