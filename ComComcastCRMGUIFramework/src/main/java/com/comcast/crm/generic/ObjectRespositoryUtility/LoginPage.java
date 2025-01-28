package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name  = "user_name")
	private WebElement userNametxt;
	@FindBy(name  = "user_password")
	private WebElement passwordtxt;
	@FindBy(id  = "submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void login(String un,String pwd) {
		
		userNametxt.sendKeys(un);
		passwordtxt.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	

}
