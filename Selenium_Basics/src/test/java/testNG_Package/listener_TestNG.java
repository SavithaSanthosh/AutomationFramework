package testNG_Package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener_TestNG implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("=========");
        System.out.println("Testcase started");
    }


    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("=========");
        System.out.println("Testcase passed");
    }


    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("=========");
        System.out.println("Testcase failed");
    }


    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("=========");
        System.out.println("Testcase skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }


    public void onFinish(ITestContext iTestContext) {
        System.out.println("=========");
        System.out.println("Testcase finished");
    }
}
