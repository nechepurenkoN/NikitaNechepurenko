package ru.training.at.hw2.data;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DifferentElementsPageData {
    public static final String HREF_ATTRIBUTE = "href";

    public static final String DIFFERENT_ELEMENTS_PAGE_LINK =
        JdiTestingIndexPageData.BASE_URL + "different-elements.html";

    public static final String DIFFERENT_ELEMENTS_TITLE = "Different Elements";

    public static final int CHECKBOXES_COUNT = 4;

    public static final int WATER_CHECKBOX_ORDER = 0;

    public static final int WIND_CHECKBOX_ORDER = 2;

    public static final int RADIO_BUTTONS_COUNT = 4;

    public static final int SELEN_RADIO_ORDER = 3;

    public static final String WATER_CHECKBOX_LABEL = "Water";

    public static final String WIND_CHECKBOX_LABEL = "Wind";

    public static final String YELLOW = "Yellow";

    public static final int EXPECTED_LOGS_COUNT = 4;

    public static final List<String> LOGS_SUFFIXES = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true"
    );
}
