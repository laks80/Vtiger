package com.comcast.crm.generic.WebdriverUtility;

import static org.testng.Assert.assertTrue;

import java.time.Duration;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.FileUtility.*;
public class WebDriverUtility {
	 WebDriver driver;
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToWindowUrl(WebDriver driver,String partialUrl)
	{
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it =  wh.iterator();
		while(it.hasNext())
		{
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialUrl))
				break;
		}
	}	
		public void switchToWindowTitle(WebDriver driver,String partialTitle)
		{
			Set<String> wh = driver.getWindowHandles();
			Iterator<String> it =  wh.iterator();
			while(it.hasNext())
			{
				String windowId = it.next();
				driver.switchTo().window(windowId);
				String actUrl = driver.getTitle();
				if(actUrl.contains(partialTitle))
					break;
			}
		}	
			public void switchToFrame(WebDriver driver,int index)
			{
				
				driver.switchTo().frame(index);
			}
			public void switchToFrame(WebDriver driver,String name)
			{
				
				driver.switchTo().frame(name);
			}
			public void switchToFrame(WebDriver driver,WebElement element)
			{
			 
				driver.switchTo().frame(element);
			}
				
			public void switchToAlertAccept(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			public void switchToAlertDismiss(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
			public void selectDropdown(WebElement element,String text)
			{
				Select s = new Select(element);
				s.selectByVisibleText(text);
			}
			public void selectDropdown(WebElement element,int index)
			{
				Select s = new Select(element);
				s.selectByIndex(index);
				
			}
			public void selectDropdown(String value,WebElement element)
			{
				Select s = new Select(element);
				s.selectByValue(value);
			}
			public void deSelectDropdown(String text,WebElement element)
			{
				Select s = new Select(element);
				s.deselectByVisibleText(text);
			}
			public void deSelectDropdown(WebElement element,String value)
			{
				Select s = new Select(element);
				s.selectByValue(value);
			}
			public void deSelectDropdown(int index,WebElement element)
			{
				Select s = new Select(element);
				s.deselectByIndex(index);
			}
			public List<WebElement> selectDropdown(WebElement element)
			{
				Select s = new Select(element);
				return s.getOptions();
				
			}
			
			public void mouseMoveOnElement(WebDriver driver,WebElement element)
			{
				Actions act = new Actions(driver);
			
				act.moveToElement(element).perform();
			}
			public void doubleClick(WebDriver driver,WebElement element)
			{
				Actions act = new Actions(driver);
				act.doubleClick(element).perform();
				
			}
			public void scrollToElement(WebDriver driver,WebElement element)
			{
				Actions act = new Actions(driver);
			
				act.scrollToElement(element).perform();
			}
			public void scrollToElementWithAxis(WebDriver driver,WebElement element,int x,int y)
			{
				Actions act = new Actions(driver);
			
				act.scrollByAmount(x, y).perform();
			}
			public void rightClick(WebDriver driver,WebElement element)
			{
				Actions act = new Actions(driver);
			
				act.contextClick(element).perform();
			}
			
			
			public void verifyMandatory(String actName, String name)
			{	
			
				Assert.assertTrue(actName.contains(name), "Test Case Fail");
			
				    
			}
			
		
			public WebDriver launchBrowser(String browser)
			{
				
				if(browser.equals("chrome"))
				
				{ driver = new ChromeDriver();
				}else if(browser.equals("edge"))
				{
					driver = new EdgeDriver();
				
				}else if(browser.equals("firefox"))
				{
					driver = new FirefoxDriver();
				}else
				{
					driver = new ChromeDriver();
				}
				System.out.println(driver);
				return driver;
				
			}
			
			public void enterUrl(String url)
			{
			driver.get(url);
			}
			
			public void closeBrowser()
			{
				driver.quit();
			}
			
			public void minimizeBrowser()
			{
				driver.manage().window().minimize();
			}
	
			public void fullScreenBrowser()
			{
				driver.manage().window().fullscreen();
			}
			public void maximizeBrowser()
			{
				driver.manage().window().maximize();
			}
		
			public void scrollByVertical(WebDriver driver,int yAxis)
			{
				JavascriptExecutor jse= (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,"+yAxis+")");
			}
			public void scrollByHorizontal(WebDriver driver,int xAxis)
			{
				JavascriptExecutor jse= (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy("+xAxis+",0)");
			}
			
	}


