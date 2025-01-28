package practice.testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class DemoDataProvider {
	
	@DataProvider
	
	public Object demoTest() {
		
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "tony";
		objArr[0][1] = "stark";
		objArr[1][0] = "pepper";
		objArr[1][1] = "potts";
		objArr[2][0] = "happy";
		objArr[2][1] = "hogan";
		return objArr;
	}
	
	@DataProvider
	 public Object amazonTest() throws EncryptedDocumentException, IOException
	 {
		
		ExcelUtility eLib = new ExcelUtility();
	    int rownum =eLib.getRownumFromExcel("amazon");
	   
	    
		Object[][] obj= new Object[rownum][2]; 
		
		for(int i =0;i< rownum ;i++)
		{
			obj[i][0]= eLib.getDataFromExcel("amazon",i+1, 0);
			obj[i][1]= eLib.getDataFromExcel("amazon",i+1, 1);
			
		}
		
		
		return obj;
	 }
	
	@DataProvider
	 public Object excelTest() throws EncryptedDocumentException, IOException
	 {
		
		FileInputStream fis = new FileInputStream("./testData/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("amazon");
		 int rownum=sheet.getLastRowNum();
		Object[][]  obj= new Object[rownum][3];
		for(int i =0  ;i<rownum ;i++)
		{
			int colnum = sheet.getRow(i).getLastCellNum();
			
			for(int j = 0;j< colnum;j++)
			{
			obj[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			obj[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
	
		return obj;
	 }
	
		
	}
	
 
	


