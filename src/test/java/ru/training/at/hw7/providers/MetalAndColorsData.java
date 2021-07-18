package ru.training.at.hw7.providers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7.dto.MetalAndColors;
import ru.training.at.hw7.dto.User;

public class MetalAndColorsData {
    private static final String JDI_EX8_PATH = "src\\test\\resources\\data\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "romanWithMetalAndColors")
    public static Object[][] romanWithMetalAndColors() {
        User roman = UsersProvider.ROMAN;
        return getMetalAndColorsValuesFromEx8().values().stream()
                                               .map(e -> new Object[] {roman, e})
                                               .toArray(Object[][]::new);
    }

    @SneakyThrows
    private static Map<String, MetalAndColors> getMetalAndColorsValuesFromEx8() {
        return new ObjectMapper().readValue(
            new File(JDI_EX8_PATH),
            new TypeReference<>() {
            }
        );
    }
}
