package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdditionTest {

    private Calculator calculator;
    private static final double DOUBLE_COMPARISON_DELTA = 1e-9;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        groups = {TestGroupTags.ADDITION},
        dataProvider = "positive-long",
        dataProviderClass = AdditionDataProvider.class
    )
    public void positiveLongAdditionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.ADDITION},
        dataProvider = "negative-long",
        dataProviderClass = AdditionDataProvider.class
    )
    public void negativeLongAdditionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.ADDITION},
        dataProvider = "mixed-long",
        dataProviderClass = AdditionDataProvider.class
    )
    public void mixedLongAdditionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.ADDITION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-long",
        dataProviderClass = AdditionDataProvider.class
    )
    public void boundaryLongAdditionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.ADDITION},
        dataProvider = "low-precision-double",
        dataProviderClass = AdditionDataProvider.class
    )
    public void lowPrecisionDoubleAdditionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.ADDITION},
        dataProvider = "high-precision-double",
        dataProviderClass = AdditionDataProvider.class
    )
    public void highPrecisionDoubleAdditionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.ADDITION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-double",
        dataProviderClass = AdditionDataProvider.class
    )
    public void boundaryDoubleAdditionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.sum(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }
}
