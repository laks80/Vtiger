package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	@FindBy(xpath  = "//input[@name='lastname']")
	private WebElement lastNameTxt;
	@FindBy(xpath  = "//input[@name='support_start_date']")
	private WebElement startDateTxt;
	@FindBy(xpath  = "//input[@name='support_end_date']")
	private WebElement endDateTxt;
	@FindBy(xpath  = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUp;
	
	@FindBy(xpath  = "//input[@name='search_text']")
	private WebElement searchTxt;
	@FindBy(xpath  = "//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateTxt() {
		return startDateTxt;
	}

	public WebElement getEndDateTxt() {
		return endDateTxt;
	}

	public WebElement getOrgNameLookUp() {
		return orgNameLookUp;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	

}
