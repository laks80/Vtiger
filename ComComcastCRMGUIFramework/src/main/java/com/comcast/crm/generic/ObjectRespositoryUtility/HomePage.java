package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

public class HomePage {

	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}


	

	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutBtn;
	
	
	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

WebDriver driver;
	public WebElement getOrgLink() {
		return orgLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getProductsLink() {
		return productsLink;
	}


	public WebElement getLeadsLink() {
		return leadsLink;
	}


	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	public void logout()
	{
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.mouseMoveOnElement(driver, adminImg);
		signOutBtn.click();
	}
}
