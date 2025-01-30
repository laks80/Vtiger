package com.comcast.crm.generic.BaseClassTest;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.DatabaseUtility.DatabaseUtility;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.ProprtiesUtility;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

import net.bytebuddy.implementation.bind.annotation.Default;


public class BaseClass {

	public ProprtiesUtility pLib = new ProprtiesUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();

	public  WebDriver driver;
	public static WebDriver edriver;

	@BeforeSuite
	public void configBeforeSuite() throws SQLException {

		dLib.getDatabaseConnection();
		System.out.println("Before suite=======>db open");
	}

	@AfterSuite
	public void configAfterSuite() {

		dLib.closeDatabaseConnection();
		System.out.println("After suite=======>db close");
	}

	//@Parameters("browser")

	@BeforeClass(alwaysRun = true)
	public void configBeforeClass() throws IOException {
		String browser = pLib.getDataFromPropertyFile("browser");
		
		driver = wLib.launchBrowser(browser);
		
		System.out.println("Before class=======>launch browser");
		
		edriver= driver;
	}

	@AfterClass(alwaysRun = true)
	public void configAfterClass() {

		wLib.closeBrowser();
		System.out.println("After Class=======>close browser");
		

	}

	@BeforeMethod(alwaysRun = true)
	public void configBeforeMethod() throws IOException {

		String browser = System.getProperty("browser", "pLib.getDataFromPropertyFile('browser')");
				//pLib.getDataFromPropertyFile("browser");
		
		String url = System.getProperty("url","pLib.getDataFromPropertyFile('url')");
		String username = System.getProperty("username","pLib.getDataFromPropertyFile('username')");
		String password = System.getProperty("password","pLib.getDataFromPropertyFile('password')");
		wLib.enterUrl(url);
		wLib.waitForPageLoad(driver);
		wLib.maximizeBrowser();
		LoginPage loginP = new LoginPage(driver);
		loginP.login(username, password);
		System.out.println("Before Method=======>login");
		//UtilityClassObject.getTest().log(Status.INFO, "this is a test");
	}

	@AfterMethod(alwaysRun = true)
	public void configAfterMethod() {
		HomePage homeP = new HomePage(driver);
		homeP.logout();

		System.out.println("After Method=======>logout");
	}
}
