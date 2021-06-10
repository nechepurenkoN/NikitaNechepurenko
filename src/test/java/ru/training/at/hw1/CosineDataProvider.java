package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class CosineDataProvider {

    @DataProvider(name = "high-precision-double")
    public static Object[][] highPrecisionDouble() {
        return new Object[][] {
            {0.0d, 1.0d},
            {0.234874659d, 0.9725435184659355d},
            {-0.234874659d, 0.9725435184659355d},
            {Math.PI / 2, 0.0d},
            {Math.PI / 4.0d, Math.sqrt(2) / 2.0d},
            {-Math.PI / 4.0d, Math.sqrt(2) / 2.0d}
        };
    }

    @DataProvider(name = "boundary-double")
    public static Object[][] boundaryDouble() {
        return new Object[][] {
            {Double.NaN, Double.NaN},
            {Double.POSITIVE_INFINITY, Double.NaN}
        };
    }

}
