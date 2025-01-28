package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {
	
	@FindBy(className  = "lvtHeaderText")
	private WebElement vendorHeader;
	@FindBy(id  = "dtlview_Vendor Name")
	private WebElement vendorNameInfo;
	@FindBy(id  = "mouseArea_Vendor Name")
	private WebElement vendorInfo;

	public VendorInformationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	

	public WebElement getVendorHeader() {
		return vendorHeader;
	}



	public WebElement getVendorNameInfo() {
		return vendorNameInfo;
	}



	public WebElement getVendorInfo() {
		return vendorInfo;
	}
	
	
}
