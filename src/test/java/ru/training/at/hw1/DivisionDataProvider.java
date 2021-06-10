package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DivisionDataProvider {

    @DataProvider(name = "zero-long")
    public static Object[][] zeroLong() {
        return new Object[][] {
            {0L, 0L},
            {1234L, 0L},
            {-1234L, 0L}
        };
    }

    @DataProvider(name = "zero-double")
    public static Object[][] zeroDouble() {
        return new Object[][] {
            {0.0d, 0.0d, Double.NaN},
            {1234.12345d, 0.0d, Double.POSITIVE_INFINITY},
            {-4321.54321, 0.0d, Double.NEGATIVE_INFINITY}
        };
    }

    @DataProvider(name = "common-long")
    public static Object[][] commonLong() {
        return new Object[][] {
            {123456789101112L, 123456789L, 1000000L},
            {42L, 42L, 1L},
            {5638598687392395687L, 56386594L, 99998923279L},
            {121L, 11L, 11L},
            {0L, 12345L, 0L},
            {12193131840L, 123456L, 98765L},
            {12193131840L, 98765L, 123456L}
        };
    }

    @DataProvider(name = "boundary-long")
    public static Object[][] boundaryLong() {
        return new Object[][] {
            {Long.MAX_VALUE, Long.MIN_VALUE, 0L},
            {Long.MIN_VALUE, Long.MAX_VALUE, -1L},
            {0L, Long.MAX_VALUE, 0},
            {Long.MAX_VALUE, -1L, -Long.MAX_VALUE},
            {Long.MAX_VALUE, Long.MAX_VALUE, 1L}
        };
    }

    @DataProvider(name = "low-precision-double")
    public static Object[][] lowPrecisionDouble() {
        return new Object[][] {
            {0.1234d, 0.4321d, 0.285582041194168d},
            {0.389573d, -0.456545d, -0.8533069029339934d},
            {-0.111111d, 0.222222d, -0.5d}
        };
    }

    @DataProvider(name = "high-precision-double")
    public static Object[][] highPrecisionDouble() {
        return new Object[][] {
            {0.0d, -0.123456789101112d, 0.0d},
            {0.43895394593547d, 0.238784537894d, 1.8382846301812397d},
            {-2.234782634837d, -3.432589754383d, 0.6510485652948925d}
        };
    }

    @DataProvider(name = "boundary-double")
    public static Object[][] boundaryDouble() {
        return new Object[][] {
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN},
            {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN},
            {Double.NaN, 0.12345d, Double.NaN},
            {Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY},
            {Double.MAX_VALUE, Double.MAX_VALUE, 1.0d}
        };
    }
}
