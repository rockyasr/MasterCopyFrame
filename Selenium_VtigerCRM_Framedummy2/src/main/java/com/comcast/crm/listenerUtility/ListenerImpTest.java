package com.comcast.crm.listenerUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpTest implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
	System.out.println("====onStartISuite====");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("====onFinishonISuite====");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===onTestStartITest====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====onTestSuccessITest===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("====onTestFailureITest====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("====onTestSkippedITest====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("===onTestFailedButWithinSuccessPercentageITest===");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("====onTestFailedWithTimeoutITest==="); 
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("====onStartITest====");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("====onFinishITest===");
	}
    
}
