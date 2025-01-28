package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testData/vtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	public void setDataToExcel(String sheetName,int rownum,int cellnum, String data) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testData/vtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testData/vtiger.xlsx");
		wb.write(fos);
	
	}
	public int getRownumFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testData/vtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		int data = wb.getSheet(sheetName).getLastRowNum();
		return data;
	}

}
