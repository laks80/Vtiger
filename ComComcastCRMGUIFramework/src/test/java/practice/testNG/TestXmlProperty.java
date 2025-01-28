package practice.testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestXmlProperty {
	
	@Parameters({"url","username","password"})
	
	@Test
	
	public void testxml(String url,String un,String pw) throws IOException
	{
		
		//String url ="";
	//	String un ="";
	//	String pw ="";
	
		FileInputStream fis;
		try {
			fis = new FileInputStream("./configAppData/ex.property");
	
		Properties p = new Properties();
		p.load(fis);
	 url = p.getProperty("url");
	 System.out.println("taking from property");
		// un = p.getProperty("username");
	//	 pw = p.getProperty("password");
		
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			
}
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		driver.quit();
		
	
		
}
}