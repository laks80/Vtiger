package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	@FindBy(xpath ="//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement vendorBtn;
	
	
	public VendorsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getVendorBtn() {
		return vendorBtn;
	}

}
