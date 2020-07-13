package utils;

import appium.testcases.TestBase;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class TestListener extends TestBase implements ITestListener {

    ExtentTest test;
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println(iTestContext.getName() + " started");
        iTestContext.setAttribute("MobileDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println(iTestContext.getName()+" finished");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extentReports.createTest(getTestMethodName(iTestResult));

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            test.pass("Test Passed").addScreenCaptureFromPath(CommonOperations.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            test.fail("Test Failed").addScreenCaptureFromPath(CommonOperations.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        try {
            test.skip("Test Skipped").addScreenCaptureFromPath(CommonOperations.captureScreenshot());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        test.skip("Test Failed");
    }

}