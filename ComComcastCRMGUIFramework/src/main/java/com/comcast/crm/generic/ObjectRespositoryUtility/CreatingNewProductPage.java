package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	
	@FindBy(xpath  = "//input[@name = 'productname']")
	private WebElement productnameTxt;
	

	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	@FindBy(xpath= "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorNameLookUp;
	@FindBy(xpath= "//input[@name='search_text']")
	private WebElement searchTxt;
	@FindBy(xpath= "//input[@name='search']")
	private WebElement searchBtn;
	
	
	public WebElement getProductnameTxt() {
		return productnameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public CreatingNewProductPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getVendorNameLookUp() {
		return vendorNameLookUp;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}


}
