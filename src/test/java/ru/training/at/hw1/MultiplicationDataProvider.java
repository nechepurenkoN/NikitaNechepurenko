package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class MultiplicationDataProvider {
    @DataProvider(name = "positive-long")
    public static Object[][] positiveLong() {
        return new Object[][] {
            {123456789L, 123456789L, 15241578750190521L},
            {987654321L, 123456L, 121931851853376L},
            {14L, 37L, 518L}
        };
    }

    @DataProvider(name = "negative-long")
    public static Object[][] negativeLong() {
        return new Object[][] {
            {-48694736L, -563057373L, 27417930131088528L},
            {-1L, -1L, 1L},
            {-47L, -28L, 1316L}
        };
    }

    @DataProvider(name = "mixed-long")
    public static Object[][] mixedLong() {
        return new Object[][] {
            {0L, 0L, 0L},
            {0L, 90L, 0L},
            {90L, 0L, 0L},
            {-476949348L, 264645858L, -126222669424000584L},
            {13L, -12L, -156L}
        };
    }

    @DataProvider(name = "boundary-long")
    public static Object[][] boundaryLong() {
        return new Object[][] {
            {Long.MAX_VALUE, -1L, Long.MIN_VALUE + 1},
        };
    }

    @DataProvider(name = "low-precision-double")
    public static Object[][] lowPrecisionDouble() {
        return new Object[][] {
            {0.5656d, 0.1212d, 0.06855072d},
            {0.389573d, -0.456545d, -0.177857605285d},
            {-0.111111d, 0.222222d, -0.024691308642d}
        };
    }

    @DataProvider(name = "high-precision-double")
    public static Object[][] highPrecisionDouble() {
        return new Object[][] {
            {0.0d, -0.123456789101112d, -0.0d},
            {0.43895394593547d, 0.238784537894d, 0.10481541513694906d},
            {-2.234782634837d, -3.432589754383d, 7.671091975614531d}
        };
    }

    @DataProvider(name = "boundary-double")
    public static Object[][] boundaryDouble() {
        return new Object[][] {
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
            {Double.NaN, 0.12345d, Double.NaN},
        };
    }
}
