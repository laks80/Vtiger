package com.comcast.crm.contactTest;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.BaseClassTest.BaseClass;

import com.comcast.crm.generic.ObjectRespositoryUtility.ContactInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.ContactsPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewContactPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.WebdriverUtility.*;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smoketest")
	public void CreateContact() throws EncryptedDocumentException, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Getting the data from excel");
		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();

		HomePage homeP = new HomePage(driver);
		
		ContactsPage contactP = new ContactsPage(driver);
		CreatingNewContactPage createConP = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);

		// click on contacts link
		homeP.getContactsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contacts link");
		// click on + button
		contactP.getContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Enter the last name");
		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);
		UtilityClassObject.getTest().log(Status.INFO, "Save the contact");
		// click on save button
		createConP.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Getting the data from excel");
		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page

		String header = contactInfoP.getContactHeader().getText();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the result");
		wLib.verifyMandatory(header, contactName);
		
		

	}
	
@Test(groups = "regressiontest")
	public void CreateContactStartEndDate() throws EncryptedDocumentException, IOException {
		
	UtilityClassObject.getTest().log(Status.INFO, "Getting the data from excel");
		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();

		HomePage homeP = new HomePage(driver);

		ContactsPage contactP = new ContactsPage(driver);
		CreatingNewContactPage createConP = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);

		// click on contacts link
		homeP.getContactsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contacts link");
		// click on + button
		contactP.getContactBtn().click();
		
		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);
		UtilityClassObject.getTest().log(Status.INFO, "Enter the last name");
		String startDate = jLib.getDateYYYYMMDD();
		UtilityClassObject.getTest().log(Status.INFO, "Enter the start date");
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		System.out.println("ed" + endDate);
		// enter start date
		createConP.getStartDateTxt().clear();
		createConP.getStartDateTxt().sendKeys(startDate);
		UtilityClassObject.getTest().log(Status.INFO, "Enter the end date");
		// enter end date
		createConP.getEndDateTxt().clear();
		createConP.getEndDateTxt().sendKeys(endDate);
//click on save button
		UtilityClassObject.getTest().log(Status.INFO, "Save the contact");
		createConP.getSaveBtn().click();
		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page
		UtilityClassObject.getTest().log(Status.INFO, "verify contact name");
		String header = contactInfoP.getContactHeader().getText();
		wLib.verifyMandatory(header, contactName);
		String cname = contactInfoP.getContactInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cname.trim(), contactName);
		

//validate startdate in details page
		UtilityClassObject.getTest().log(Status.INFO, "Verify start date");
		String sdate = contactInfoP.getStartDateInfo().getText();
		soft.assertEquals(startDate.trim(),sdate );
		

//validate end date in details page
		UtilityClassObject.getTest().log(Status.INFO, "verify end date");
		String edate = contactInfoP.getEndDateInfo().getText();
		soft.assertEquals(endDate.trim(),edate );
		soft.assertAll();

	}

@Test(groups = "regressiontest")
	public void CreateContactWithOrg() throws EncryptedDocumentException, IOException {
	UtilityClassObject.getTest().log(Status.INFO, "Getting the data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2).toString() + jLib.getRandomNumber();

		HomePage homeP = new HomePage(driver);
		OrganizationsPage orgP = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createOrgP = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage orgInfoP = new OrganizationInformationPage(driver);
		ContactsPage contactP = new ContactsPage(driver);
		CreatingNewContactPage createConP = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);
		// click on organizations link
		homeP.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization link");
		// click on + button
		orgP.getOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Enter account name");
		// enter account name
		createOrgP.getOrgNameTxt().sendKeys(orgName);
		UtilityClassObject.getTest().log(Status.INFO, "Click on save button");
		// click on save button
		createOrgP.getSaveBtn().click();

		wLib.waitForPageLoad(driver);
		// validate org name in header of details page

		String header = orgInfoP.getOrgHeader().getText();
		UtilityClassObject.getTest().log(Status.INFO, "Verify org name");
		wLib.verifyMandatory(header, orgName);

		// validate org name in details page

		String actOrgName = orgInfoP.getOrgNameInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actOrgName.trim(), orgName);
		

		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();
		// click on contacts link
		homeP.getContactsLink().click();

		// click on + button
		contactP.getContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);
		UtilityClassObject.getTest().log(Status.INFO, "Enter contact name");
		// select org name from look up
		createConP.getOrgNameLookUp().click();
		UtilityClassObject.getTest().log(Status.INFO, "Select from org look up");
		// child window handling

		wLib.switchToWindowUrl(driver, "Accounts&action");
		UtilityClassObject.getTest().log(Status.INFO, "Switch windows");
		createConP.getSearchTxt().sendKeys(orgName);
		createConP.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		UtilityClassObject.getTest().log(Status.INFO, "Switch to parent window");
		// switching to parent window

		wLib.switchToWindowUrl(driver, "Contacts&action");
		// click on save button
		createConP.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Save the contact");
		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page
		UtilityClassObject.getTest().log(Status.INFO, "verify contact name");
		String cname = contactInfoP.getContactHeader().getText();

		wLib.verifyMandatory(cname, contactName);
		
       //validate org name  in  details page
		UtilityClassObject.getTest().log(Status.INFO, "verify org name");
		String oname = contactInfoP.getOrgInfo().getText();
		driver.findElement(By.id("mouseArea_Organization Name")).getText();
		soft.assertEquals(oname.trim(), orgName);
		
		soft.assertAll();
	}
}
