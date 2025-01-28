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

import com.comcast.crm.generic.BaseClassTest.BaseClass;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.ProprtiesUtility;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups = "smoketest")
	
	public void createOrg() throws IOException {
		
		
		String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
	
		HomePage homeP = new HomePage(driver);
		
		
		OrganizationsPage orgP = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
		//click on organizations link
		homeP.getOrgLink().click();
		
		//click on + button
		orgP.getOrgBtn().click();
		
		//enter account name
		createOrgP.getOrgNameTxt().sendKeys(orgName);
		
		//click on save button
		createOrgP.getSaveBtn().click();
		
		wLib.waitForPageLoad(driver);
		//validate org name in header of details page
		
		String header = orgInfoP.getOrgHeader().getText();
				
		wLib.verifyMandatory(header,orgName);
		
		//validate org name in details page
		
		String actOrgName = orgInfoP.getOrgNameInfo().getText();
						
		wLib.verifyMandatory(actOrgName,"hate this");
		wLib.assertAll();
				
	
	}
	
	@Test(groups = "regressiontest")
	
	public void CreateOrgIndustry() throws EncryptedDocumentException, IOException {
		
		String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
		
		 String industry = eLib.getDataFromExcel("org", 4, 3);
		 String type = eLib.getDataFromExcel("org", 4, 4);
		
		
			HomePage homeP = new HomePage(driver);
			OrganizationsPage orgP = new OrganizationsPage(driver);
			CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
			OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
		
		//click on organizations link
			homeP.getOrgLink().click();
		
		//click on + button
			orgP.getOrgBtn().click();
		
		//enter account name
			createOrgP.getOrgNameTxt().sendKeys(orgName);
			
		//select industry
		
		WebElement s = createOrgP.getIndustryDd();
			
		wLib.selectDropdown(s, industry);
		
		//select type
		WebElement s1 = createOrgP.getTypeDd();
			
		wLib.selectDropdown(s1, type);
		
		//click on save button
		createOrgP.getSaveBtn().click();
		
		wLib.waitForPageLoad(driver);
		//validate org name in header of details page
		
		String header = orgInfoP.getOrgHeader().getText();
				
		wLib.verifyMandatory(header,orgName);
		
		
		//validate org name in details page
		
				String actOrgName = orgInfoP.getOrgNameInfo().getText();
								
				wLib.verifyNotMandatory(actOrgName,orgName);
		
		//validate industry in details page
		
				String actIndName = orgInfoP.getIndustryInfo().getText();
						
				wLib.verifyNotMandatory(actIndName,industry);
		
				wLib.assertAll();
	}
	
	@Test(groups = "regressiontest")
	public void CreateOrgPhone() throws EncryptedDocumentException, IOException {
		
		 String orgName = eLib.getDataFromExcel("org", 1, 2).toString()+ jLib.getRandomNumber();
			
		 String phoneNo = eLib.getDataFromExcel("org", 7, 3);
		 HomePage homeP = new HomePage(driver);
			OrganizationsPage orgP = new OrganizationsPage(driver);
			CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
			OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
		
	//click on organizations link
	homeP.getOrgLink().click();
	
	//click on + button
	orgP.getOrgBtn().click();
	
	//enter account name
	createOrgP.getOrgNameTxt().sendKeys(orgName);

	//enter phone no
	createOrgP.getPhoneTxt().sendKeys(phoneNo);

	//click on save button
	createOrgP.getSaveBtn().click();

	wLib.waitForPageLoad(driver);
	//validate org name in header of details page
	
	String header = orgInfoP.getOrgHeader().getText();
			
	wLib.verifyMandatory(header,orgName);
	
	//validate phone no in details page
	
			String actPhoneNo = orgInfoP.getPhoneInfo().getText();
			
			wLib.verifyNotMandatory(actPhoneNo,phoneNo);
			wLib.assertAll();
		
}
}
	


