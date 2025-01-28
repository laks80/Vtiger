package practice.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoBatch {
	
	
	@BeforeClass
	
	public void a() {
		System.out.println("beforeClass ->a");
	}

@BeforeClass
	
	public void y() {
		System.out.println("beforeClass-->y");
	}
@BeforeClass

public void r() {
	System.out.println("beforeClass-->r");
}

@BeforeTest

public void aa() {
	System.out.println("before test-->aa");
}
	@Test
	public void aaa() {
		System.out.println("test-->aaa");
	}
	
@Test
public void  aba() {
	System.out.println("test-->aba");
}

@AfterTest
public void ba() {
	System.out.println("after test-->ba");
	
}
@AfterMethod

public void ac() {
	System.out.println("after method-->ac");
}
	
}
