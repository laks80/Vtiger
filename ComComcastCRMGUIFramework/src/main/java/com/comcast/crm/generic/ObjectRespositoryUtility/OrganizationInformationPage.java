package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(className  = "dvHeaderText")
	private WebElement orgHeader;
	@FindBy(className  = "dvtCellInfo")
	private WebElement orgNameInfo;
	@FindBy(id  = "dtlview_Industry")
	private WebElement industryInfo;
	@FindBy(id  = "dtlview_Phone")
	private WebElement phoneInfo;
	
	
	
	public WebElement getOrgHeader() {
		return orgHeader;
	}

	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	
	
	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getPhoneInfo() {
		return phoneInfo;
	}

	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}
