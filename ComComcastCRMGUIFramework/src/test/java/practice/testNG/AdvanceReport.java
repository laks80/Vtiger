package practice.testNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvanceReport {
	
	@Test
	
	public void ex() {
		
		System.out.println("this is a test for extent reporting");
	ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/athar/Desktop/extent_report/report.html");
	spark.config().setDocumentTitle("This ia an example");
	spark.config().setReportName("example");
	spark.config().setTheme(Theme.STANDARD);
	ExtentReports report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("os", "windows 11");
	report.setSystemInfo("browser", "chrome");
	ExtentTest test = report.createTest("createExample");
	test.log(Status.INFO, "This is an example test");
	if("Home".equals("Homee"))
		test.log(Status.PASS, "this test is pass");
	else
		
		test.log(Status.FAIL, "this test is fail");
	report.flush();

	}

}
