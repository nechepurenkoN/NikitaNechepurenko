package ru.training.at.hw4.listeners;

import driver.DriverWrapper;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        DriverWrapper driver = (DriverWrapper) result.getTestContext().getAttribute("driver");
        attachScreenShot(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenShot(DriverWrapper driver) {
        return driver.getScreenShot();
    }
}
