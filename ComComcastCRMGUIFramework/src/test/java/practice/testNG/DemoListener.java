package practice.testNG;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoListener implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("start suite=======>");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("end suite=======>");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("method start=======>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("method start=======>success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("method start=======>failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("method start=======>skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("method start=======>success%");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("method start=======>failedto");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("test start=======>");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("test end=======>");
	}
	
	

}
