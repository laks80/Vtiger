package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	
	@FindBy(xpath= "//input[@name = 'lastname']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath= "//input[@name = 'company']")
	private WebElement companyTxt;
	@FindBy(xpath= "//input[@value='U']")
	private WebElement userRadioBtn;
	@FindBy(xpath= "//input[@value='T']")
	private WebElement groupRadioBtn;
	@FindBy(xpath= "//select[@name = 'assigned_group_id']")
	private WebElement groupDd;
	@FindBy(xpath= "//select[@name = 'assigned_user_id']")
	private WebElement userDd;
	@FindBy(xpath= "//select[@name = 'leadstatus']")
	private WebElement statusDd;
	
	
	public CreatingNewLeadPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCompanyTxt() {
		return companyTxt;
	}

	public WebElement getUserRadioBtn() {
		return userRadioBtn;
	}

	public WebElement getUserDd() {
		return userDd;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getGroupDd() {
		return groupDd;
	}

	public WebElement getStatusDd() {
		return statusDd;
	}

	
}
