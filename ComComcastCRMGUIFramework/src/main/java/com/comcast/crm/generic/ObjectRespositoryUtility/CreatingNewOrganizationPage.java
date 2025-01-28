package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	@FindBy(xpath= "//input[@name = 'accountname']")
	private WebElement orgNameTxt;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath= "//select[@name='industry']")
	private WebElement industryDd;
	@FindBy(xpath= "//select[@name='accounttype']")
	private WebElement typeDd;
	@FindBy(id= "phone")
	private WebElement phoneTxt;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	

	public WebElement getIndustryDd() {
		return industryDd;
	}


	public WebElement getTypeDd() {
		return typeDd;
	}


	public WebElement getPhoneTxt() {
		return phoneTxt;
	}


	public WebElement getOrgNameTxt() {
		return orgNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

}
