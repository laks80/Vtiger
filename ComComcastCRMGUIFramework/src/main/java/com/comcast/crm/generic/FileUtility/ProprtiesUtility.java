package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProprtiesUtility {
	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		 FileInputStream fis = new FileInputStream("./configAppData/ex.property");
			
			Properties p = new Properties();
			p.load(fis);
			
			String data = p.getProperty(key);
			return data;
	}

}
