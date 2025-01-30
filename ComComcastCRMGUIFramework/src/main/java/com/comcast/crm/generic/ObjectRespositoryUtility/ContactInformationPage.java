package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	

	@FindBy(xpath  ="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	@FindBy(id = "mouseArea_Last Name")
	private WebElement contactInfo;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgInfo;
	@FindBy(xpath  = "//span[@id='dtlview_Support Start Date']")
	private WebElement startDateInfo;
	@FindBy(xpath  = "//span[@id='dtlview_Support End Date']")
	private WebElement endDateInfo;
	
	

	public WebElement getContactInfo() {
		return contactInfo;
	}


	public WebElement getContactHeader() {
		return contactHeader;
	}


	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}


	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	

	

}
