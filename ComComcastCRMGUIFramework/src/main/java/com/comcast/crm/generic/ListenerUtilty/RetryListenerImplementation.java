package com.comcast.crm.generic.ListenerUtilty;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation  implements IRetryAnalyzer{
	int count = 0;
	int limitCount = 5;                    
	@Override
	public boolean retry(ITestResult result) {
		
		if(count < limitCount)
		{
			count++;
			System.out.println(count);
			return true;
		}
		return false;
	}
	

}
