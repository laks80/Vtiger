package practice.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRetry {
	@Test(retryAnalyzer = com.comcast.crm.generic.ListenerUtilty.RetryListenerImplementation.class)
	
	public void activate() {
		
		Assert.assertEquals("home", "home");
	}

}
