package ru.training.at.hw2.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JdiTestingIndexPageData {
    public static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    public static final String PAGE_URL = BASE_URL + "index.html";

    public static final String PAGE_TITLE = "Home Page";

    public static final String LOGIN = "Roman";

    public static final String PASSWORD = "Jdi1234";

    public static final String USERNAME = "Roman Iovlev";

    public static final int IMAGE_COUNT = 4;

    private static final List<String> BASIC_NAVIGATION_LIST = List.of(
        "Home",
        "Contact form",
        "Service",
        "Metals & Colors"
    );

    public static final List<String> HEADER_MENU_ITEMS_TEXT = BASIC_NAVIGATION_LIST.stream()
                                                                                   .map(String::toUpperCase)
                                                                                   .collect(Collectors.toList());

    public static final List<String> BENEFIT_TEXTS = List.of(
        "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project",
        "To be flexible and\n"
            + "customizable",
        "To be multiplatform",
        "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…"
    );

    public static final String FRAME_INNER_BUTTON_TEXT = "Frame Button";

    public static final String FRAME_INNER_BUTTON_TEXT_ATTRIBUTE = "value";

    public static final String FRAME_TITLE = "Frame with button Page";

    public static final List<String> SIDEBAR_ITEMS = Stream.concat(
        BASIC_NAVIGATION_LIST.stream(),
        Stream.of("Elements packs")
    ).collect(Collectors.toList());
}
