package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class SubtractionDataProvider {
    @DataProvider(name = "positive-long")
    public static Object[][] positiveLong() {
        return new Object[][] {
            {123456789L, 123456789101112L, -123456665644323L},
            {42L, 42L, 0L},
            {56386594L, 5638598687392395687L, -5638598687336009093L}
        };
    }

    @DataProvider(name = "negative-long")
    public static Object[][] negativeLong() {
        return new Object[][] {
            {-12378484859L, -5729059478L, -6649425381L},
            {-1L, -1L, 0L},
            {-4756748949L, -2345L, -4756746604L}
        };
    }

    @DataProvider(name = "mixed-long")
    public static Object[][] mixedLong() {
        return new Object[][] {
            {0L, 0L, 0L},
            {0L, 909090L, -909090L},
            {-476949348L, 264645858L, -741595206L},
            {13L, -12L, 25L}
        };
    }

    @DataProvider(name = "boundary-long")
    public static Object[][] boundaryLong() {
        return new Object[][] {
            {Long.MAX_VALUE, Long.MIN_VALUE, -1L},
            {Long.MIN_VALUE, Long.MAX_VALUE, 1L},
            {Long.MIN_VALUE, 0L, Long.MIN_VALUE},
            {0L, Long.MAX_VALUE, -Long.MAX_VALUE},
            {Long.MAX_VALUE, -1L, -9223372036854775808L},
            {Long.MAX_VALUE, Long.MAX_VALUE, 0L}
        };
    }

    @DataProvider(name = "low-precision-double")
    public static Object[][] lowPrecisionDouble() {
        return new Object[][] {
            {0.1234d, 0.4321d, -0.3087d},
            {0.389573d, -0.456545d, 0.8461179999999999d},
            {-0.111111d, 0.222222d, -0.333333d}
        };
    }

    @DataProvider(name = "high-precision-double")
    public static Object[][] highPrecisionDouble() {
        return new Object[][] {
            {0.0d, -0.123456789101112d, 0.123456789101112d},
            {0.43895394593547d, 0.238784537894d, 0.20016940804147d},
            {-2.234782634837d, -3.432589754383d, 1.1978071195460003d}
        };
    }

    @DataProvider(name = "boundary-double")
    public static Object[][] boundaryDouble() {
        return new Object[][] {
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN},
            {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.NaN, 0.12345d, Double.NaN},
            {Double.MAX_VALUE, Double.MIN_VALUE, 1.7976931348623157E308},
            {Double.MAX_VALUE, Double.MAX_VALUE, 0.0d}
        };
    }
}
