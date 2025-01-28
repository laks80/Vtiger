package com.comcast.crm.leadsTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.BaseClassTest.BaseClass;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.ProprtiesUtility;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewLeadPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LeadInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LeadsPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

public class CreateLeadTest extends BaseClass {

	@Test(groups = "smoketest")
	public void CreateLead() throws EncryptedDocumentException, IOException {

		String lastName = eLib.getDataFromExcel("leads", 1, 2).toString() + jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("leads", 1, 3).toString() + jLib.getRandomNumber();
		String user = eLib.getDataFromExcel("leads", 1, 4).toString();

		HomePage homeP = new HomePage(driver);

		LeadsPage leadP = new LeadsPage(driver);

		CreatingNewLeadPage createLeadP = new CreatingNewLeadPage(driver);
		LeadInformationPage leadInfoP = new LeadInformationPage(driver);
		// click on leads link
		homeP.getLeadsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on leads link");
		// click on + button
		leadP.getLeadBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on + button");
		// enter product name
		createLeadP.getLastNameTxt().sendKeys(lastName);
		UtilityClassObject.getTest().log(Status.INFO, "enter product name");
		// enter company
		createLeadP.getCompanyTxt().sendKeys(company);
		UtilityClassObject.getTest().log(Status.INFO, "enter company");
		// select user
		createLeadP.getUserRadioBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "select user");
		// select user info
		WebElement element = createLeadP.getUserDd();

		wLib.selectDropdown(element, user);
		UtilityClassObject.getTest().log(Status.INFO, "select user info");
		// click on save button
		createLeadP.getSaveBtn().click();

		wLib.waitForPageLoad(driver);
		// validate product name in header of details page

		String header = leadInfoP.getLeadHeader().getText();
		//
		wLib.verifyMandatory(header,lastName );
		UtilityClassObject.getTest().log(Status.INFO, "validate product name in header of details page");
		// validate last name in details page

		String actlastname = leadInfoP.getLeadInfo().getText();
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actlastname, lastName);
		
		wLib.verifyNotMandatory(actlastname, lastName);

		// validate company in details page

		String actcompany = leadInfoP.getCompanyInfo().getText();

		wLib.verifyNotMandatory(actcompany, company);
		UtilityClassObject.getTest().log(Status.INFO, "validate product name in header of details page");
		// validate user in details page

		String actuser = driver.findElement(By.xpath("//a[contains(text(),'" + user + "')]")).getText();
		//wLib.verifyNotMandatory(actuser, user);
		
		s.assertEquals(actuser, user);
		s.assertAll("Asserted all");

	}

	@Test(groups = "regressiontest")
	public void CreateLeadwithLeadStatus() throws EncryptedDocumentException, IOException {

		String lastName = eLib.getDataFromExcel("leads", 4, 2).toString() + jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("leads", 4, 3).toString() + jLib.getRandomNumber();
		String group = eLib.getDataFromExcel("leads", 4, 4).toString();
		String status = eLib.getDataFromExcel("leads", 4, 5).toString();

		HomePage homeP = new HomePage(driver);

		LeadsPage leadP = new LeadsPage(driver);
		CreatingNewLeadPage createLeadP = new CreatingNewLeadPage(driver);
		LeadInformationPage leadInfoP = new LeadInformationPage(driver);

		// click on leads link
		homeP.getLeadsLink().click();

		// click on + button
		leadP.getLeadBtn().click();

		// enter product name
		createLeadP.getLastNameTxt().sendKeys(lastName);

		createLeadP.getCompanyTxt().sendKeys(company);

		// select group
		createLeadP.getGroupRadioBtn().click();

		// select group info

		WebElement s = createLeadP.getGroupDd();
		wLib.selectDropdown(s, group);
		// select status
		WebElement s1 = createLeadP.getStatusDd();

		wLib.selectDropdown(s1, status);
		// click on save button
		createLeadP.getSaveBtn().click();
		wLib.waitForPageLoad(driver);
		// validate product name in header of details page

		String header = leadInfoP.getLeadHeader().getText();

		wLib.verifyMandatory(header, lastName);

		// validate last name in details page

		String actlastname = leadInfoP.getLeadInfo().getText();
		SoftAssert soft = new SoftAssert();
	
		
		soft.assertEquals(actlastname, lastName);
		// validate company in details page

		String actcompany = leadInfoP.getCompanyInfo().getText();

		
		soft.assertEquals(actcompany, company);
		// validate group in details page

		String actgroup = driver.findElement(By.xpath("//a[contains(text(),'" + group + "')]")).getText();
		
		soft.assertEquals(actgroup, group);
		
		// validate status in details page

		String actstatus = leadInfoP.getStatusinfo().getText();

		
		soft.assertEquals(actstatus, status);
		soft.assertAll();
	}

	@Test(groups = "regressiontest")

	public void DeleteLead() throws EncryptedDocumentException, IOException {

		String lastName = eLib.getDataFromExcel("leads", 7, 2).toString() + jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("leads", 7, 3).toString() + jLib.getRandomNumber();
		String user = eLib.getDataFromExcel("leads", 7, 4).toString();

		HomePage homeP = new HomePage(driver);

		LeadsPage leadP = new LeadsPage(driver);
		CreatingNewLeadPage createLeadP = new CreatingNewLeadPage(driver);
		LeadInformationPage leadInfoP = new LeadInformationPage(driver);

		// click on leads link
		homeP.getLeadsLink().click();

		// click on + button
		leadP.getLeadBtn().click();

		// enter product name
		createLeadP.getLastNameTxt().sendKeys(lastName);

		// enter company
		createLeadP.getCompanyTxt().sendKeys(company);

		// select user
		createLeadP.getUserRadioBtn().click();

		// select user info
		WebElement s = createLeadP.getUserDd();

		wLib.selectDropdown(s, user);

		// click on save button
		createLeadP.getSaveBtn().click();
		;

		wLib.waitForPageLoad(driver);
		// validate lead name in header of details page

		String header = leadInfoP.getLeadHeader().getText();

		wLib.verifyMandatory(header, lastName);

		// validate last name in details page

		String actlastname = leadInfoP.getLeadInfo().getText();
		
        SoftAssert soft = new SoftAssert();
	
		
        soft.assertEquals(actlastname, lastName);
		

		// validate company in details page

		String actcompany = leadInfoP.getCompanyInfo().getText();
		 soft.assertEquals(actcompany, company);
		

		// validate user in details page

		String actuser = driver.findElement(By.xpath("//a[contains(text(),'" + user + "')]")).getText();

		
		soft.assertEquals(actuser, user);
		// click on leads link
		homeP.getLeadsLink().click();

		// search for company created
		leadP.getSearchTxt().sendKeys(company);

		// select category
		String category = eLib.getDataFromExcel("leads", 7, 5).toString();

		WebElement s1 = leadP.getInDd();

		wLib.selectDropdown(s1, category);

		// click on search button
		wLib.waitForPageLoad(driver);
		leadP.getSearchBtn().click();

		// check the box to be deleted
		wLib.waitForPageLoad(driver);
		leadP.getCheckBox().click();

		wLib.waitForPageLoad(driver);
		// click on delete
		leadP.getDeleteBtn().click();

		// click on ok in confirmation pop up
		wLib.switchToAlertAccept(driver);

		wLib.waitForPageLoad(driver);
		// search for company created
		leadP.getSearchTxt().click();
		leadP.getSearchTxt().sendKeys(company);

		// select category

		WebElement s2 = leadP.getInDd();

		wLib.selectDropdown(s2, category);

		wLib.waitForPageLoad(driver);
		// click on search button
		leadP.getSearchBtn().click();

		wLib.waitForPageLoad(driver);
		// verify record deleted

		String msg = leadP.getMsgBox().getText();
		soft.assertEquals(msg," No Lead Found");
		
		soft.assertAll();

	}

}
