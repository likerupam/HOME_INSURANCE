package com.insurance.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelData {
	static WebDriver driver;
	public static  String path = System.getProperty("user.dir") + "\\ExcelData\\Input.xlsx";		//Fetching excel file from directory
	public static  File file;
	public static  FileInputStream fin;

	public static  XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileOutputStream fout;
	static XSSFRow row = null;
	
	public static String[] readExcel(String sheetName) throws Exception			//Reading data from excel sheet
	{
		file = new File(path);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet(sheetName);
		String[] s = new String[32];
		
		s[0] = sh.getRow(3).getCell(2).getStringCellValue();
		
		double n = sh.getRow(6).getCell(2).getNumericCellValue();				//Fetching numeric values from excel
		int m = (int)n;															//Converting numeric value to integer format
		s[1] = Integer.toString(m);		//full bathroom	
		s[2] = sh.getRow(10).getCell(2).getStringCellValue();
		s[3] = sh.getRow(13).getCell(2).getStringCellValue();
		s[4] = sh.getRow(16).getCell(2).getStringCellValue();
		s[5] = sh.getRow(19).getCell(2).getStringCellValue();
		s[6] = sh.getRow(22).getCell(2).getStringCellValue();
		s[7] = sh.getRow(25).getCell(2).getStringCellValue();
		
		double n1 = sh.getRow(28).getCell(2).getNumericCellValue();				//Fetching numeric values from excel
		int m1 = (int)n1;															//Converting numeric value to integer format
		s[8] = Integer.toString(m1);    //half bathroom
		s[9] = sh.getRow(32).getCell(2).getStringCellValue();
		
		s[10] = sh.getRow(35).getCell(2).getStringCellValue();
		
		s[11] = sh.getRow(38).getCell(2).getStringCellValue();
		s[12] = sh.getRow(41).getCell(2).getStringCellValue();
		s[13] = sh.getRow(44).getCell(2).getStringCellValue();
		s[14] = sh.getRow(47).getCell(2).getStringCellValue();
		
		double n2 = sh.getRow(50).getCell(2).getNumericCellValue();				//Fetching numeric values from excel
		int m2 = (int)n2;															//Converting numeric value to integer format
		s[15] = Integer.toString(m2);	//kitchen

		s[16] = sh.getRow(54).getCell(2).getStringCellValue();
		s[17] = sh.getRow(57).getCell(2).getStringCellValue();
		s[18] = sh.getRow(60).getCell(2).getStringCellValue();
		s[19] = sh.getRow(63).getCell(2).getStringCellValue();
		
		s[20] = sh.getRow(67).getCell(2).getStringCellValue();
		
		double n3 = sh.getRow(70).getCell(2).getNumericCellValue();				//Fetching numeric values from excel
		int m3 = (int)n3;															//Converting numeric value to integer format
		s[21] = Integer.toString(m3);  //fireplaces
		
		double n4 = sh.getRow(3).getCell(7).getNumericCellValue();				//Fetching numeric values from excel
		int m4 = (int)n4;															//Converting numeric value to integer format
		s[22] = Integer.toString(m4); //stories
		
		s[23] = sh.getRow(7).getCell(7).getStringCellValue();
		s[24] = sh.getRow(11).getCell(7).getStringCellValue();
		s[25] = sh.getRow(15).getCell(7).getStringCellValue();
		s[26] = sh.getRow(19).getCell(7).getStringCellValue();
		s[27] = sh.getRow(23).getCell(8).getStringCellValue();
		
		double n5 = sh.getRow(27).getCell(8).getNumericCellValue();				//Fetching numeric values from excel
		int m5 = (int)n5;															//Converting numeric value to integer format
		s[28] = Integer.toString(m5);
		
		s[29] = sh.getRow(31).getCell(8).getStringCellValue();
		
		s[30] = sh.getRow(35).getCell(8).getStringCellValue();
		
		double n6 = sh.getRow(38).getCell(8).getNumericCellValue();				//Fetching numeric values from excel
		int m6 = (int)n6;															//Converting numeric value to integer format
		s[31] = Integer.toString(m6);
		 
		 return s;																//Returning string array of values
	}

	public static void writeExcel(String amount[], List<WebElement> dettails, WebElement included) throws Exception 	//Passing values to excel sheet to save it
	{
//		String path1 = System.getProperty("user.dir") + "\\ExcelData\\Output.xlsx";			//Fetching excel file from directory
//		file = new File(path1);
//		fin = new FileInputStream(file);
//		wb = new XSSFWorkbook(fin);
//		sh = wb.getSheet("Output");
//		
//		for(int i=0; i<14 ;i=i+2)
//		{
//			System.out.println(policyList[i]+" "+policyList[i+1]);
//		}
//		
//		for(int i=0; i<18 ;i=i+2)
//		{
//			System.out.println(optionalList[i]+" "+optionalList[i+1]);
//		}
//		sh.createRow(0).createCell(0).setCellValue("Basic Coverage");	
//		sh.createRow(1).createCell(0).setCellValue("Basic Coverage Per Month");	
//		sh.createRow(2).createCell(0).setCellValue("Due Today");	
//		sh.createRow(3).createCell(0).setCellValue("Annual premium");

		String initialAmount[]=new String[3];
		initialAmount=amount;
		
		FileInputStream f=new FileInputStream(System.getProperty("user.dir") + "\\ExcelData\\Output.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sheet= wb.getSheetAt(0);
		
		//storing the names and price of elements displayed in webpage 
        
		//this is for the heading in the excel file
		sheet.createRow(0).createCell(0).setCellValue("Basic Coverage Per Month");
		sheet.getRow(0).createCell(1).setCellValue(initialAmount[0]);
		
		sheet.createRow(1).createCell(0).setCellValue("Due Today");
		sheet.getRow(1).createCell(1).setCellValue(initialAmount[1]);
		
		sheet.createRow(2).createCell(0).setCellValue("Overall year");
		sheet.getRow(2).createCell(1).setCellValue(initialAmount[2]);
		
		sheet.getRow(0).createCell(5).setCellValue("Coverage");
		sheet.getRow(0).createCell(6).setCellValue("Limit");
		sheet.getRow(1).createCell(4).setCellValue("Home Policy Coverages");
		sheet.getRow(1).createCell(5).setCellValue("Dwelling");
		sheet.getRow(2).createCell(5).setCellValue("Other Structures");
		sheet.createRow(3).createCell(5).setCellValue("Personal Property");
		sheet.createRow(4).createCell(5).setCellValue("Loss of Use");
		sheet.createRow(5).createCell(5).setCellValue("Personal Liability");
		sheet.createRow(6).createCell(5).setCellValue("Medical Payments to Others");
		sheet.createRow(7).createCell(5).setCellValue("All Peril Deductible");
		sheet.createRow(8).createCell(4).setCellValue("Optional Coverages");
		sheet.getRow(8).createCell(5).setCellValue("Additional Coverage Package");
		sheet.createRow(9).createCell(5).setCellValue("Equipment Breakdown");
		sheet.createRow(10).createCell(5).setCellValue("Decreasing Deductible®");
		sheet.createRow(11).createCell(5).setCellValue("Roofing and Siding Matching Package");
		sheet.createRow(12).createCell(5).setCellValue("Identity Fraud Expense");
		
		for(int i=0; i<dettails.size(); i++)
		{
			 sheet.getRow(i+1).createCell(6).setCellValue(dettails.get(i).getText());
			
		}
		
		sheet.createRow(13).createCell(5).setCellValue("Replacement Cost Personal Property");
		sheet.getRow(13).createCell(6).setCellValue(included.getText());
		
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		sh.autoSizeColumn(4);
		sh.autoSizeColumn(5);
		sh.autoSizeColumn(6);
		
		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir") + "\\ExcelData\\Output.xlsx");
		wb.write(fout);
		wb.close();
		
			

	}

}
