package com.comcast.crm.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.BaseClassTest.BaseClass;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.ProprtiesUtility;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups = "smoketest")
	
	public void createOrg() throws IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
	
		HomePage homeP = new HomePage(driver);
		
		
		OrganizationsPage orgP = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
		//click on organizations link
		homeP.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on organization link");
		//click on + button
		orgP.getOrgBtn().click();
		
		//enter account name
		createOrgP.getOrgNameTxt().sendKeys(orgName);
		UtilityClassObject.getTest().log(Status.INFO, "click on leads link");
		//click on save button
		createOrgP.getSaveBtn().click();
		
		wLib.waitForPageLoad(driver);
		//validate org name in header of details page
		
		String header = orgInfoP.getOrgHeader().getText();
				
		wLib.verifyMandatory(header,orgName);
		
		//validate org name in details page
		
		String actOrgName = orgInfoP.getOrgNameInfo().getText();
		UtilityClassObject.getTest().log(Status.INFO, "click on leads link");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgName.trim(), orgName);
		soft.assertAll();
	
	}
	
	@Test(groups = "regressiontest")
	
	public void CreateOrgIndustry() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
		
		 String industry = eLib.getDataFromExcel("org", 4, 3);
		 String type = eLib.getDataFromExcel("org", 4, 4);
		
		
			HomePage homeP = new HomePage(driver);
			OrganizationsPage orgP = new OrganizationsPage(driver);
			CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
			OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
			UtilityClassObject.getTest().log(Status.INFO, "navigate to organization link");
		//click on organizations link
			homeP.getOrgLink().click();
		
		//click on + button
			orgP.getOrgBtn().click();
			UtilityClassObject.getTest().log(Status.INFO, "Enter the account name");
		//enter account name
			createOrgP.getOrgNameTxt().sendKeys(orgName);
			
		//select industry
		
		WebElement s = createOrgP.getIndustryDd();
			
		wLib.selectDropdown(s, industry);
		UtilityClassObject.getTest().log(Status.INFO, "Select the industry");
		//select type
		WebElement s1 = createOrgP.getTypeDd();
			
		wLib.selectDropdown(s1, type);
		
		//click on save button
		createOrgP.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Click on save button");
		wLib.waitForPageLoad(driver);
		//validate org name in header of details page
		
		String header = orgInfoP.getOrgHeader().getText();
		UtilityClassObject.getTest().log(Status.INFO, "verify org name");		
		wLib.verifyMandatory(header,orgName);
		
		
		//validate org name in details page
		
				String actOrgName = orgInfoP.getOrgNameInfo().getText();
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(actOrgName.trim(), orgName);
				
				UtilityClassObject.getTest().log(Status.INFO, "verify industry");
		//validate industry in details page
		
				String actIndName = orgInfoP.getIndustryInfo().getText();
				soft.assertEquals(actIndName.trim(), industry);	
				
				soft.assertAll();
	}
	
	@Test(groups = "regressiontest")
	public void CreateOrgPhone() throws EncryptedDocumentException, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		 String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
			
		 String phoneNo = eLib.getDataFromExcel("org", 7, 3);
		 HomePage homeP = new HomePage(driver);
			OrganizationsPage orgP = new OrganizationsPage(driver);
			CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
			OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
			UtilityClassObject.getTest().log(Status.INFO, "navigate to organization link");
	//click on organizations link
	homeP.getOrgLink().click();
	
	//click on + button
	orgP.getOrgBtn().click();
	UtilityClassObject.getTest().log(Status.INFO, "Enter the account name");
	//enter account name
	createOrgP.getOrgNameTxt().sendKeys(orgName);
	UtilityClassObject.getTest().log(Status.INFO, "Enter the phone no");
	//enter phone no
	createOrgP.getPhoneTxt().sendKeys(phoneNo);
	UtilityClassObject.getTest().log(Status.INFO, "Click on save button");
	//click on save button
	createOrgP.getSaveBtn().click();

	wLib.waitForPageLoad(driver);
	//validate org name in header of details page
	
	String header = orgInfoP.getOrgHeader().getText();
	UtilityClassObject.getTest().log(Status.INFO, "verify org name");
	wLib.verifyMandatory(header,orgName);
	
	//validate phone no in details page
	UtilityClassObject.getTest().log(Status.INFO, "verify phone number");
			String actPhoneNo = orgInfoP.getPhoneInfo().getText();
			
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actPhoneNo.trim(), phoneNo);
			
			soft.assertAll();
}
}
	


