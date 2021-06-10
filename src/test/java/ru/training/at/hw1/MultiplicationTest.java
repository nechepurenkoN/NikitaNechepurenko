package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiplicationTest {
    private Calculator calculator;
    private static final double DOUBLE_COMPARISON_DELTA = 1e-9;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION},
        dataProvider = "positive-long",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void positiveLongMultiplicationCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION},
        dataProvider = "negative-long",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void negativeLongMultiplicationCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION},
        dataProvider = "mixed-long",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void mixedLongMultiplicationCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-long",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void boundaryLongMultiplicationCase(long lhs, long rhs, long expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION},
        dataProvider = "low-precision-double",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void lowPrecisionDoubleMultiplicationCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION},
        dataProvider = "high-precision-double",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void highPrecisionDoubleMultiplicationCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.MULTIPLICATION, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-double",
        dataProviderClass = MultiplicationDataProvider.class
    )
    public void boundaryDoubleMultiplicationCase(double lhs, double rhs, double expected) {
        Assert.assertEquals(calculator.mult(lhs, rhs), expected, DOUBLE_COMPARISON_DELTA);
    }
}
