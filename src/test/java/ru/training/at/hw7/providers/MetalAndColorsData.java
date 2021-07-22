package ru.training.at.hw7.providers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7.dto.MetalAndColors;

public class MetalAndColorsData {
    private static final String JDI_EX8_PATH = "/data/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "romanWithMetalAndColors")
    public static Object[][] romanWithMetalAndColors() {
        return getMetalAndColorsValuesFromEx8().values().stream()
                                               .map(e -> new Object[] {e})
                                               .toArray(Object[][]::new);
    }

    @SneakyThrows
    private static Map<String, MetalAndColors> getMetalAndColorsValuesFromEx8() {
        return new ObjectMapper().readValue(
            MetalAndColorsData.class.getResourceAsStream(JDI_EX8_PATH),
            new TypeReference<>() {
            }
        );
    }
}
