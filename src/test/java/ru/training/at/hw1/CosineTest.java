package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CosineTest {
    private Calculator calculator;
    private static final double DOUBLE_COMPARISON_DELTA = 1e-9;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
        groups = {TestGroupTags.TRIGONOMETRIC},
        dataProvider = "high-precision-double",
        dataProviderClass = CosineDataProvider.class
    )
    public void highPrecisionDoubleCosineCase(double arg, double expected) {
        Assert.assertEquals(calculator.cos(arg), expected, DOUBLE_COMPARISON_DELTA);
    }

    @Test(
        groups = {TestGroupTags.TRIGONOMETRIC, TestGroupTags.BOUNDARY_TEST},
        dataProvider = "boundary-double",
        dataProviderClass = CosineDataProvider.class
    )
    public void boundaryDoubleCosineCase(double arg, double expected) {
        Assert.assertEquals(calculator.cos(arg), expected, DOUBLE_COMPARISON_DELTA);

    }
}
