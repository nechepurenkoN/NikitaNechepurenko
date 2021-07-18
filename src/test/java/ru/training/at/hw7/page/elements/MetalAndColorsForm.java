package ru.training.at.hw7.page.elements;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw7.dto.MetalAndColors;

public class MetalAndColorsForm extends Form<MetalAndColors> {

    @JDropdown(
        root = "#odds-selector",
        list = ".radio"
    )
    public static RadioButtons odds;

    @JDropdown(
        root = "#even-selector",
        list = ".radio"
    )
    public static RadioButtons evens;

    @JDropdown(
        root = "#colors",
        expand = ".caret"
    )
    public static Dropdown color;

    @JDropdown(
        root = "#metals",
        expand = ".caret"
    )
    public static Dropdown metal;

    @UI("#vegetables input")
    public static Checklist vegetables;

    @UI("#vegetables .caret")
    private static Button vegetablesCaret;

    @JDropdown(
        root = "#elements-checklist",
        list = ".checkbox"
    )
    public static Checklist elements;

    @UI("#submit-button")
    public static Button submitBtn;

    @Override
    public void fill(MetalAndColors entity) {
        odds.select(entity.getOdd());
        evens.select(entity.getEven());
        entity.getElements().forEach(element -> elements.select(element));
        color.select(entity.getColors());
        metal.select(entity.getMetals());
        fillVegetables(entity);
    }

    private void fillVegetables(MetalAndColors entity) {
        vegetablesCaret.click();
        vegetables.list().stream().filter(UIElement::isSelected).map(UIElement::label).forEach(HasClick::click);
        entity.getVegetables().forEach(veg -> vegetables.select(veg));
    }

    @Override
    public void submit() {
        submitBtn.click();
    }
}
