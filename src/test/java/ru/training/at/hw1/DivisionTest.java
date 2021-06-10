package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisionTest {
    private Calculator calculator;
    private static final double DOUBLE_COMPARISON_DELTA = 1e-9;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        groups = {TestGroupTags.DIVISION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "zero-long",
        dataProviderClass = DivisionDataProvider.class
    )
    public void zeroLongDivisionCase(long lhs, long rhs) {
        Assert.assertThrows(NumberFormatException.class, () -> {
            calculator.div(lhs, rhs);
        });
    }

    @Test(
        groups = {TestGroupTags.DIVISION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "zero-double",
        dataProviderClass = DivisionDataProvider.class
    )
    public void zeroLongDivisionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.DIVISION},
        dataProvider = "common-long",
        dataProviderClass = DivisionDataProvider.class
    )
    public void commonLongDivisionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.DIVISION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-long",
        dataProviderClass = DivisionDataProvider.class
    )
    public void boundaryLongDivisionCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.DIVISION},
        dataProvider = "low-precision-double",
        dataProviderClass = DivisionDataProvider.class
    )
    public void lowPrecisionDoubleDivisionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.DIVISION},
        dataProvider = "high-precision-double",
        dataProviderClass = DivisionDataProvider.class
    )
    public void highPrecisionDoubleDivisionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.DIVISION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-double",
        dataProviderClass = DivisionDataProvider.class
    )
    public void boundaryDoubleDivisionCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.div(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

}
