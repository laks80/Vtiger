package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	@FindBy(className  = "lvtHeaderText")
	private WebElement productHeader;
	@FindBy(id  = "dtlview_Product Name")
	private WebElement productNameInfo;
	@FindBy(id  = "mouseArea_Vendor Name")
	private WebElement vendorInfo;
	
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getProductHeader() {
		return productHeader;
	}


	public WebElement getProductNameInfo() {
		return productNameInfo;
	}


	public WebElement getVendorInfo() {
		return vendorInfo;
	}
	

}
