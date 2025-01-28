package com.comcast.crm.generic.ListenerUtilty;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.BaseClassTest.BaseClass;
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;


public class ListenerImplementation extends BaseClass implements ITestListener,ISuiteListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String date = new Date().toString().replace(" ","_").replace(":","_");
		Reporter.log("start-->suite",true);
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport/report"+"_"+date+".html");
		spark.config().setDocumentTitle("This ia an example");
		spark.config().setReportName("example");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows 11");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("end-->suite",true);
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("start-->test",true);
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("end-->test",true);
		test.log(Status.PASS, result.getMethod().getMethodName()+"completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String date = new Date().toString().replace(" ","_").replace(":","_");
		String name = result.getName();
		TakesScreenshot tse = (TakesScreenshot)edriver;
		String filepath = tse.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,name+"_"+date);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"failed");
		/*File srcFile = tse.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshots/"+name+"+"+date+ ".png"));
		} catch (IOException e) {
			
		}*/
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("skipped-->test",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	

}
