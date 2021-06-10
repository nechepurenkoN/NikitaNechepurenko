package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubtractionTest {
    private Calculator calculator;
    private static final double DOUBLE_COMPARISON_DELTA = 1e-9;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION},
        dataProvider = "positive-long",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void positiveLongSubtractionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION},
        dataProvider = "negative-long",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void negativeLongSubtractionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION},
        dataProvider = "mixed-long",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void mixedLongSubtractionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-long",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void boundaryLongSubtractionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION},
        dataProvider = "low-precision-double",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void lowPrecisionDoubleSubtractionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION},
        dataProvider = "high-precision-double",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void highPrecisionDoubleSubtractionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.SUBTRACTION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-double",
        dataProviderClass = SubtractionDataProvider.class
    )
    public void boundaryDoubleSubtractionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sub(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }
}
