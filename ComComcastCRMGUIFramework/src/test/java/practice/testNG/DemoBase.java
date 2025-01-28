package practice.testNG;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;

public class DemoBase {
	
	@BeforeSuite
	public void configBeforeSuite() throws SQLException {

		
		System.out.println("Before suite=======>db open");
	}

	@AfterSuite
	public void configAfterSuite() {

		
		System.out.println("After suite=======>db close");
	}

	//@Parameters("browser")

	@BeforeClass(alwaysRun = true)
	public void configBeforeClass() throws IOException {
		
		
		System.out.println("Before class=======>launch browser");
		
		
	}

	@AfterClass(alwaysRun = true)
	public void configAfterClass() {

		
		System.out.println("After Class=======>close browser");

	}

	@BeforeMethod(alwaysRun = true)
	public void configBeforeMethod() throws IOException {

		
		System.out.println("Before Method=======>login");
	}

	@AfterMethod(alwaysRun = true)
	public void configAfterMethod() {
		

		System.out.println("After Method=======>logout");
	}
}


