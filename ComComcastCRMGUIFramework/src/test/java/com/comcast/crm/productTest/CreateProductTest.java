package com.comcast.crm.productTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.BaseClassTest.BaseClass;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.ProprtiesUtility;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewProductPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.CreatingNewVendorPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.HomePage;
import com.comcast.crm.generic.ObjectRespositoryUtility.LoginPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.ProductInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.ProductsPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.VendorInformationPage;
import com.comcast.crm.generic.ObjectRespositoryUtility.VendorsPage;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {
	

	@Test(groups = "smoketest")
	public void CreateProduct() throws EncryptedDocumentException, IOException {
		
		 String productName = eLib.getDataFromExcel("products", 1, 2).toString()+ jLib.getRandomNumber();
			
		
		HomePage homeP = new HomePage(driver);
	
		ProductsPage productP = new ProductsPage(driver);
		CreatingNewProductPage createProdP = new CreatingNewProductPage(driver);
		ProductInformationPage productInfoP = new ProductInformationPage(driver);
	
		//click on products link
		homeP.getProductsLink().click();
		
		//click on + button
		productP.getProductBtn().click();
		
		//enter product name
		createProdP.getProductnameTxt().sendKeys(productName);
		
		//click on save button
		createProdP.getSaveBtn().click();
		
		wLib.waitForPageLoad(driver);
		//validate product name in header of details page
		
		String header = productInfoP.getProductHeader().getText();
			
		wLib.verifyMandatory(header,productName);
		
		//validate org name in details page
		
				String actproductName = productInfoP.getProductNameInfo().getText(); 
	
				wLib.verifyNotMandatory(actproductName,productName);
				wLib.assertAll();
	
	}
	
	@Test(groups = "regressiontest")
	
	public void CreateProductwithVendor() throws EncryptedDocumentException, IOException {
		
		String vendorName = eLib.getDataFromExcel("products", 4, 2).toString()+ jLib.getRandomNumber();
		 
		HomePage homeP = new HomePage(driver);
	
		VendorsPage vendorP = new VendorsPage(driver);
		CreatingNewVendorPage createVenP = new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfoP = new VendorInformationPage(driver);

		WebElement ele = homeP.getMoreLink();
	wLib.mouseMoveOnElement(driver, ele);
	
	//click on vendors link
	homeP.getVendorsLink().click();

	//click on + button
	vendorP.getVendorBtn().click();

	//enter vendor name
	createVenP.getVendorNameTxt().sendKeys(vendorName);

	//click on save button
	createVenP.getSaveBtn().click();

	wLib.waitForPageLoad(driver);
	//validate vendor name in header of details page
	
	String header = vendorInfoP.getVendorHeader().getText();

	wLib.verifyMandatory(header, vendorName);
	
	//validate vendor name in details page
	
			String actvendorName = vendorInfoP.getVendorNameInfo().getText();
				
			wLib.verifyNotMandatory(actvendorName,vendorName);
			
			ProductsPage productP = new ProductsPage(driver);
			CreatingNewProductPage createProdP = new CreatingNewProductPage(driver);
			ProductInformationPage productInfoP = new ProductInformationPage(driver);
		
			//click on products link
			homeP.getProductsLink().click();
			
			//click on + button
			productP.getProductBtn().click();
		
			String productName = eLib.getDataFromExcel("products", 1, 2).toString()+ jLib.getRandomNumber();
			//enter product name
			createProdP.getProductnameTxt().sendKeys(productName);
			
			//select vendor name from look up
			createProdP.getVendorNameLookUp().click();
		
			//child window handling
			
			wLib.switchToWindowTitle(driver, "Vendors&action");
			
			createProdP.getSearchTxt().sendKeys(vendorName);
			createProdP.getSearchBtn().click();
	
		driver.findElement(By.xpath("//a[text()='"+ vendorName+"']")).click();
		
		//switching to parent window
		
		wLib.switchToWindowUrl(driver, "Products&action");
	
			//click on save button
		createProdP.getSaveBtn().click();
		wLib.waitForPageLoad(driver);
			//validate product name  in header of details page
			
			String cname = productInfoP.getProductHeader().getText();
		
			wLib.verifyMandatory(cname, productName);
			
			//validate product name  in details page
			
			String actproductName = productInfoP.getProductNameInfo().getText();
			wLib.verifyNotMandatory(actproductName,productName);
		
//validate vendor name in details page			
			
			String vname = productInfoP.getVendorInfo().getText();

			wLib.verifyNotMandatory(vname,vendorName);
			wLib.assertAll();
		
	}
	
	
	@Test(groups = "smoketest")
	
	public void CreateVendor() throws EncryptedDocumentException, IOException {
		 String vendorName = eLib.getDataFromExcel("products", 4, 2).toString()+ jLib.getRandomNumber();
			
			HomePage homeP = new HomePage(driver);

			VendorsPage vendorP = new VendorsPage(driver);
			CreatingNewVendorPage createVenP = new CreatingNewVendorPage(driver);
			VendorInformationPage vendorInfoP = new VendorInformationPage(driver);

			WebElement ele = homeP.getMoreLink();
		wLib.mouseMoveOnElement(driver, ele);
		
		//click on vendors link
		homeP.getVendorsLink().click();
	
		//click on + button
		vendorP.getVendorBtn().click();
	
		//enter vendor name
		createVenP.getVendorNameTxt().sendKeys(vendorName);
	
		//click on save button
		createVenP.getSaveBtn().click();
	
		wLib.waitForPageLoad(driver);
		//validate vendor name in header of details page
		
		String header = vendorInfoP.getVendorHeader().getText();

		wLib.verifyMandatory(header, vendorName);
		
		//validate vendor name in details page
		
				String actvendorName = vendorInfoP.getVendorNameInfo().getText();
           SoftAssert s = new SoftAssert();
				
				s.assertTrue(actvendorName.equals("whats this"), "Test case fail");
				//wLib.verifyNotMandatory(actvendorName,"whats this");
				//wLib.assertAll();
				s.assertAll();
	
	}

}
