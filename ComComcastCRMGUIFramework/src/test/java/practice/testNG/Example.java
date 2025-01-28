package practice.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		//TakesScreenshot ts = (TakesScreenshot)driver;
		//ts.getScreenshotAs(OutputType.FILE);
	WebElement ele = driver.findElement(By.id("APjFqb"));
	
	ele.sendKeys("java editor");
	File f = ele.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f, new File("C:/Users/athar/Desktop/le.png"));
		
}
}