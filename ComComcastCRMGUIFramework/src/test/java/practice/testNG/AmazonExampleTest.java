package practice.testNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class AmazonExampleTest {
	
	@Test(dataProvider = "amazonTest",dataProviderClass = DemoDataProvider.class)
	public void amazonTestExecute(String name,String product) throws EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone" +Keys.ENTER);
		//span[text()='OnePlus 13R | Smarter with OnePlus AI (12GB RAM, 256GB Storage Astral Trail)']/ancestor::div/following::div/following-sibling::div/div
	String ex=	driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]/ancestor::div/following::div/following-sibling::div/div")).getText();
	System.out.println(ex);
	driver.close();
}
}