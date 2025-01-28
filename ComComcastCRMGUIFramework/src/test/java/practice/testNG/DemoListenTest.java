package practice.testNG;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(practice.testNG.DemoListener.class)
public class DemoListenTest extends DemoBase {
	
	@Test(threadPoolSize = 2)
	
	public void example() {
		
		WebDriver driver = new ChromeDriver();
		System.out.println("========test========");
		
	}

}
