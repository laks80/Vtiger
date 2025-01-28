package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendorPage {
	
	@FindBy(xpath  = "//input[@name = 'vendorname']")
	private WebElement vendorNameTxt;
	

	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreatingNewVendorPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getVendorNameTxt() {
		return vendorNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


}
