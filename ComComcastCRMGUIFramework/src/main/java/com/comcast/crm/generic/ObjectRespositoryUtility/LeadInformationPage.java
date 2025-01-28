package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement leadHeader;
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement leadInfo;
	
	@FindBy(id = "mouseArea_Lead Status")
	private WebElement statusinfo;
	
	@FindBy(id = "mouseArea_Company")
	private WebElement companyInfo;
	
	@FindBy(id = "mouseArea_Assigned To")
	private WebElement assignInfo;
	
	
	
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}



	public WebElement getLeadHeader() {
		return leadHeader;
	}



	public WebElement getLeadInfo() {
		return leadInfo;
	}



	public WebElement getStatusinfo() {
		return statusinfo;
	}



	public WebElement getCompanyInfo() {
		return companyInfo;
	}



	public WebElement getAssignInfo() {
		return assignInfo;
	}
	

}
