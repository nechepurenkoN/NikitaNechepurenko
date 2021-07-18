package ru.training.at.hw7.page.elements;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import java.util.List;

public class ResultBlock {
    @UI(".results")
    public static JList<Text> resultLines;

    public List<String> getLines() {
        return resultLines.values();
    }

}
