package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(priority=1,invocationCount = 2)
	
	private void demotestngtest8()
	{
		System.out.println("this is a demo test1");
		
	}
	
	@Test(dataProvider = "getData")
	public void demotestngtest5(String name,String lname)
	{
		
		System.out.println("FirstName :"+name+ "LastName:"+ lname);
		System.out.println("this is a demo test2");
	}
	
	@DataProvider
	public Object getData()
	{
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "tony";
		objArr[0][1] = "stark";
		objArr[1][0] = "pepper";
		objArr[1][1] = "potts";
		objArr[2][0] = "happy";
		objArr[2][1] = "hogan";
		return objArr;
		
	}
	
	@Test(dataProvider = "excelTest",dataProviderClass = DemoDataProvider.class)
	
	public void genericDataExcel(String name,String lname,String l) {
		
		
		System.out.println("FirstName :"+name+ "LastName:"+ lname);
		
		
	}
	
	
}
