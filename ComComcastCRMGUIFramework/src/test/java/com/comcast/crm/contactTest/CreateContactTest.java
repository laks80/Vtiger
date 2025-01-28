package com.comcast.crm.contactTest;

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

@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smoketest")
	public void CreateContact() throws EncryptedDocumentException, IOException {
		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();

		HomePage homeP = new HomePage(driver);
	
		ContactsPage contactP = new ContactsPage(driver);
		CreatingNewContactPage createConP = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);

		// click on contacts link
		homeP.getContactsLink().click();

		// click on + button
		contactP.getContactBtn().click();

		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);

		// click on save button
		createConP.getSaveBtn().click();

		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page

		String header = contactInfoP.getContactHeader().getText();

		wLib.verifyMandatory(header, contactName);
		wLib.assertAll();
		

	}
	
@Test(groups = "regressiontest")
	public void CreateContactStartEndDate() throws EncryptedDocumentException, IOException {

		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();

		HomePage homeP = new HomePage(driver);

		ContactsPage contactP = new ContactsPage(driver);
		CreatingNewContactPage createConP = new CreatingNewContactPage(driver);
		ContactInformationPage contactInfoP = new ContactInformationPage(driver);

		// click on contacts link
		homeP.getContactsLink().click();

		// click on + button
		contactP.getContactBtn().click();

		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);

		String startDate = jLib.getDateYYYYMMDD();

		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		System.out.println("ed" + endDate);
		// enter start date
		createConP.getStartDateTxt().clear();
		createConP.getStartDateTxt().sendKeys(startDate);

		// enter end date
		createConP.getEndDateTxt().clear();
		createConP.getEndDateTxt().sendKeys(endDate);
//click on save button

		createConP.getSaveBtn().click();
		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page

		String header = contactInfoP.getContactHeader().getText();

		wLib.verifyNotMandatory(contactName, contactName);

//validate startdate in details page

		String sdate = contactInfoP.getStartDateInfo().getText();

		wLib.verifyNotMandatory(startDate, sdate);

//validate end date in details page

		String edate = contactInfoP.getEndDateInfo().getText();

		wLib.verifyNotMandatory(endDate, edate);
		wLib.assertAll();

	}

@Test(groups = "regressiontest")
	public void CreateContactWithOrg() throws EncryptedDocumentException, IOException {

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

		// click on + button
		orgP.getOrgBtn().click();

		// enter account name
		createOrgP.getOrgNameTxt().sendKeys(orgName);

		// click on save button
		createOrgP.getSaveBtn().click();

		wLib.waitForPageLoad(driver);
		// validate org name in header of details page

		String header = orgInfoP.getOrgHeader().getText();

		wLib.verifyMandatory(header, orgName);

		// validate org name in details page

		String actOrgName = orgInfoP.getOrgNameInfo().getText();

		wLib.verifyNotMandatory(actOrgName, orgName);

		String contactName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();
		// click on contacts link
		homeP.getContactsLink().click();

		// click on + button
		contactP.getContactBtn().click();

		// enter last name
		createConP.getLastNameTxt().sendKeys(contactName);

		// select org name from look up
		createConP.getOrgNameLookUp().click();

		// child window handling

		wLib.switchToWindowUrl(driver, "Accounts&action");

		createConP.getSearchTxt().sendKeys(orgName);
		createConP.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switching to parent window

		wLib.switchToWindowUrl(driver, "Contacts&action");
		// click on save button
		createConP.getSaveBtn().click();

		wLib.waitForPageLoad(driver);
		// validate contact name in header of details page

		String cname = contactInfoP.getContactHeader().getText();

		wLib.verifyMandatory(cname, contactName);

       //validate org name  in header of details page

		String oname = contactInfoP.getOrgInfo().getText();
		driver.findElement(By.id("mouseArea_Organization Name")).getText();
		wLib.verifyNotMandatory(oname, orgName);
		
wLib.assertAll();
	}
}
