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

import com.aventstack.extentreports.Status;
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
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
@Listeners(com.comcast.crm.generic.ListenerUtilty.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {
	

	@Test(groups = "smoketest")
	public void CreateProduct() throws EncryptedDocumentException, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		
		 String productName = eLib.getDataFromExcel("products", 1, 2).toString()+ jLib.getRandomNumber();
			
		
		HomePage homeP = new HomePage(driver);
	
		ProductsPage productP = new ProductsPage(driver);
		CreatingNewProductPage createProdP = new CreatingNewProductPage(driver);
		ProductInformationPage productInfoP = new ProductInformationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to products link");
		//click on products link
		homeP.getProductsLink().click();
		
		//click on + button
		productP.getProductBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Enter product name");
		//enter product name
		createProdP.getProductnameTxt().sendKeys(productName);
		UtilityClassObject.getTest().log(Status.INFO, "Save the product");
		//click on save button
		createProdP.getSaveBtn().click();
		
		wLib.waitForPageLoad(driver);
		//validate product name in header of details page
		
		String header = productInfoP.getProductHeader().getText();
			
		wLib.verifyMandatory(header,productName);
		UtilityClassObject.getTest().log(Status.INFO, "verify the product name");
		//validate org name in details page
		
				String actproductName = productInfoP.getProductNameInfo().getText(); 
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(actproductName.trim(), productName);
				
				soft.assertAll();
				
	
	}
	
	@Test(groups = "regressiontest")
	
	public void CreateProductwithVendor() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		String vendorName = eLib.getDataFromExcel("products", 4, 2).toString()+ jLib.getRandomNumber();
		 
		HomePage homeP = new HomePage(driver);
	
		VendorsPage vendorP = new VendorsPage(driver);
		CreatingNewVendorPage createVenP = new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInfoP = new VendorInformationPage(driver);

		WebElement ele = homeP.getMoreLink();
	wLib.mouseMoveOnElement(driver, ele);
	UtilityClassObject.getTest().log(Status.INFO, "navigate to vendors link");
	//click on vendors link
	homeP.getVendorsLink().click();

	//click on + button
	vendorP.getVendorBtn().click();
	UtilityClassObject.getTest().log(Status.INFO, "Enter the vendor name");
	//enter vendor name
	createVenP.getVendorNameTxt().sendKeys(vendorName);
	UtilityClassObject.getTest().log(Status.INFO, "save the vendor");
	//click on save button
	createVenP.getSaveBtn().click();

	wLib.waitForPageLoad(driver);
	//validate vendor name in header of details page
	
	String header = vendorInfoP.getVendorHeader().getText();
	UtilityClassObject.getTest().log(Status.INFO, "verify vendor name");
	wLib.verifyMandatory(header, vendorName);
	
	//validate vendor name in details page
	
			String actvendorName = vendorInfoP.getVendorNameInfo().getText();
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actvendorName.trim(), vendorName);
			
			
			
			
			ProductsPage productP = new ProductsPage(driver);
			CreatingNewProductPage createProdP = new CreatingNewProductPage(driver);
			ProductInformationPage productInfoP = new ProductInformationPage(driver);
			UtilityClassObject.getTest().log(Status.INFO, "navigate to products link");
			//click on products link
			homeP.getProductsLink().click();
			
			//click on + button
			productP.getProductBtn().click();
		
			String productName = eLib.getDataFromExcel("products", 1, 2).toString()+ jLib.getRandomNumber();
			//enter product name
			createProdP.getProductnameTxt().sendKeys(productName);
			UtilityClassObject.getTest().log(Status.INFO, "Enter product name");
			//select vendor name from look up
			createProdP.getVendorNameLookUp().click();
			UtilityClassObject.getTest().log(Status.INFO, "Select vendor name");
			//child window handling
			
			wLib.switchToWindowTitle(driver, "Vendors&action");
			
			createProdP.getSearchTxt().sendKeys(vendorName);
			createProdP.getSearchBtn().click();
	
		driver.findElement(By.xpath("//a[text()='"+ vendorName+"']")).click();
		
		//switching to parent window
		
		wLib.switchToWindowUrl(driver, "Products&action");
		UtilityClassObject.getTest().log(Status.INFO, "Save the product");
			//click on save button
		createProdP.getSaveBtn().click();
		wLib.waitForPageLoad(driver);
			//validate product name  in header of details page
			
			String cname = productInfoP.getProductHeader().getText();
			UtilityClassObject.getTest().log(Status.INFO, "verify the product name");
			wLib.verifyMandatory(cname, productName);
			
			//validate product name  in details page
			
			String actproductName = productInfoP.getProductNameInfo().getText();
			soft.assertEquals(actproductName.trim(), productName);
		
		
//validate vendor name in details page			
			
			String vname = productInfoP.getVendorInfo().getText();
			soft.assertEquals(vname.trim(), vendorName);
			
			soft.assertAll();
		
	}
	
	
	@Test(groups = "smoketest")
	
	public void CreateVendor() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "Get data from excel");
		 String vendorName = eLib.getDataFromExcel("products", 4, 2).toString()+ jLib.getRandomNumber();
			
			HomePage homeP = new HomePage(driver);

			VendorsPage vendorP = new VendorsPage(driver);
			CreatingNewVendorPage createVenP = new CreatingNewVendorPage(driver);
			VendorInformationPage vendorInfoP = new VendorInformationPage(driver);

			WebElement ele = homeP.getMoreLink();
		wLib.mouseMoveOnElement(driver, ele);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to vendors link");
		//click on vendors link
		homeP.getVendorsLink().click();
	
		//click on + button
		vendorP.getVendorBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Enter the vendor name");
		//enter vendor name
		createVenP.getVendorNameTxt().sendKeys(vendorName);
		UtilityClassObject.getTest().log(Status.INFO, "save the vendor");
		//click on save button
		createVenP.getSaveBtn().click();
	
		wLib.waitForPageLoad(driver);
		//validate vendor name in header of details page
		
		String header = vendorInfoP.getVendorHeader().getText();

		wLib.verifyMandatory(header, vendorName);
		UtilityClassObject.getTest().log(Status.INFO, "verify vendor name");
		//validate vendor name in details page
		
				String actvendorName = vendorInfoP.getVendorNameInfo().getText();
           
				
           SoftAssert soft = new SoftAssert();
			soft.assertEquals(actvendorName.trim(), vendorName);
			
			soft.assertAll();
	
	}

}
