package com.comcast.crm.generic.ObjectRespositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy(xpath ="//img[@src = 'themes/softed/images/btnL3Add.gif']")
	private WebElement productBtn;
	
	
	public ProductsPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getProductBtn() {
		return productBtn;
	}

}
