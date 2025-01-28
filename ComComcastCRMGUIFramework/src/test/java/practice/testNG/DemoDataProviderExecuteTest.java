package practice.testNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class DemoDataProviderExecuteTest {
	
	@Test(dataProvider = "demoTest",dataProviderClass = DemoDataProvider.class)
	
	public void demoExecute(String fname,String lname)
	{
		System.out.println("FirstName :"+fname+ "LastName:"+ lname);
	}

	
	    
	}

