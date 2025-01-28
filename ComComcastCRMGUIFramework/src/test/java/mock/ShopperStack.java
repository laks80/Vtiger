package mock;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class ShopperStack  {
	ExcelUtility eLib = new ExcelUtility();
	@Test
	
	public void shopper() throws EncryptedDocumentException, IOException {
		
		
		String fname = eLib.getDataFromExcel("mock", 1,0);
		String lname = eLib.getDataFromExcel("mock", 1, 1);
		String radio = eLib.getDataFromExcel("mock", 1, 2);
		
		String phone = eLib.getDataFromExcel("mock", 1, 3);
		String email = eLib.getDataFromExcel("mock", 1, 4);
		String password = eLib.getDataFromExcel("mock", 1, 5);
		String cpasswd = eLib.getDataFromExcel("mock", 1, 6);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.xpath("//span[text()='Create Account']")).click();
		driver.findElement(By.id("First Name")).sendKeys(fname);
		driver.findElement(By.id("Last Name")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name ='"+radio+"']")).click();
		driver.findElement(By.id("Phone Number")).sendKeys(phone);
		driver.findElement(By.id("Email Address")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("Confirm Password")).sendKeys(cpasswd);
		driver.findElement(By.id("Terms and Conditions")).click();
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File registerf = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(registerf, new File("./screenshot/register.png"));
		
		driver.quit();
	}
	@Test
	public void ex1() throws IOException, InterruptedException {
		
		
		String nemail = eLib.getDataFromExcel("mock", 2, 4);
		String pwd = eLib.getDataFromExcel("mock", 2, 5);
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver1.get("https://www.shoppersstack.com/");
		driver1.findElement(By.id("loginBtn")).click();
		driver1.findElement(By.id("Email")).sendKeys(nemail);
		driver1.findElement(By.id("Password")).sendKeys(pwd);
		driver1.findElement(By.xpath("//span[text()='Login']")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element = driver1.findElement(By.xpath("//a[@id='women']"));
		
		Actions a = new Actions(driver1);
		a.moveToElement(element).perform();
		
		driver1.findElement(By.xpath("//a[text()='Kurtas & Suits']"));
		//Thread.sleep(2000);
		driver1.findElement(By.xpath("(//button[text()='add to cart'])[1]")).click();
		driver1.findElement(By.id("cartIcon")).click();
		//Thread.sleep(2000);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver1.findElement(By.xpath("//span[text()='Buy Now']")).click();
		//Thread.sleep(2000);
		driver1.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		//Thread.sleep(2000);
		driver1.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(2000);
		//driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver1.findElement(By.xpath("//input[@value='COD']")).click();
		//Thread.sleep(2000);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver1.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Thread.sleep(2000);
		TakesScreenshot tse = (TakesScreenshot)driver1;
		File orderf = tse.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(orderf, new File("./screenshot/order.png"));
		//Thread.sleep(2000);
		 String act = driver1.findElement(By.xpath("//h1[text()='Order Confirmed']")).getText();
		Assert.assertEquals(act,"Order Confirmed");
		driver1.quit();
		
	}
		
		
		
		
	}


