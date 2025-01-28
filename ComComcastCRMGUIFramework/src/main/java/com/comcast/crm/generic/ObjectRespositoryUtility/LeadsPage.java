package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath ="//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement leadBtn;
	
	@FindBy(xpath ="//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath ="//select[@class='txtBox']")
	private WebElement inDd;
	
	@FindBy(xpath = "//input[@name ='selected_id']")
	private WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}




	@FindBy(xpath ="//input[@value=' Search Now ']")
	private WebElement searchBtn;
	
	@FindBy(xpath ="//input[@value='Delete']")
	private WebElement deleteBtn;
	@FindBy(xpath ="//span[@class='genHeaderSmall']")
	private WebElement msgBox;
	
	
	public LeadsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getDeleteBtn() {
		return deleteBtn;
	}


	public WebElement getLeadBtn() {
		return leadBtn;
	}


	public WebElement getSearchTxt() {
		return searchTxt;
	}


	public WebElement getInDd() {
		return inDd;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	

	public WebElement getMsgBox() {
		return msgBox;
	}


	

}
