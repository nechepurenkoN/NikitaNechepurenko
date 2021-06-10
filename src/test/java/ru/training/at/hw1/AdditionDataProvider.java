package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class AdditionDataProvider {

    @DataProvider(name = "positive-long")
    public static Object[][] positiveLong() {
        return new Object[][] {
            {123456789L, 123456789101112L, 123456912557901L},
            {42L, 42L, 84L},
            {56386594L, 5638598687392395687L, 5638598687448782281L}
        };
    }

    @DataProvider(name = "negative-long")
    public static Object[][] negativeLong() {
        return new Object[][] {
            {-12378484859L, -5729059478L, -18107544337L},
            {-1L, -1L, -2L},
            {-4756748949L, -2345L, -4756751294L}
        };
    }

    @DataProvider(name = "mixed-long")
    public static Object[][] mixedLong() {
        return new Object[][] {
            {0L, 0L, 0L},
            {0L, 909090L, 909090L},
            {-476949348L, 264645858L, -212303490L},
            {13L, -12L, 1L}
        };
    }

    @DataProvider(name = "boundary-long")
    public static Object[][] boundaryLong() {
        return new Object[][] {
            {Long.MAX_VALUE, Long.MIN_VALUE, -1L},
            {Long.MIN_VALUE, Long.MAX_VALUE, -1L},
            {Long.MIN_VALUE, 0L, Long.MIN_VALUE},
            {0L, Long.MAX_VALUE, Long.MAX_VALUE},
            {Long.MAX_VALUE, -1L, 9223372036854775806L},
            {Long.MAX_VALUE, Long.MAX_VALUE, -2L}
        };
    }

    @DataProvider(name = "low-precision-double")
    public static Object[][] lowPrecisionDouble() {
        return new Object[][] {
            {0.1234d, 0.4321d, 0.5555d},
            {0.389573d, -0.456545d, -0.066972},
            {-0.111111d, 0.222222d, 0.111111d}
        };
    }

    @DataProvider(name = "high-precision-double")
    public static Object[][] highPrecisionDouble() {
        return new Object[][] {
            {0.0d, -0.123456789101112d, -0.123456789101112d},
            {0.43895394593547d, 0.238784537894d, 0.67773848382947d},
            {-2.234782634837d, -3.432589754383d, -5.6673723892200005d}
        };
    }

    @DataProvider(name = "boundary-double")
    public static Object[][] boundaryDouble() {
        return new Object[][] {
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN},
            {Double.NaN, 0.12345d, Double.NaN},
            {Double.MAX_VALUE, Double.MIN_VALUE, 1.7976931348623157E308},
            {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY}
        };
    }
}
