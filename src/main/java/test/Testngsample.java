package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testngsample {

	  static WebDriver driver;
	  	
	  public Object[][] getData() throws IOException
	  {
		  Object[][] ar = null;
		  FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\Register.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  int sheets = workbook.getNumberOfSheets();
		  for(int i=0;i<sheets;i++)
		  {
			  if(workbook.getSheetName(i).equalsIgnoreCase("data"))
			  {
				  XSSFSheet sheet = workbook.getSheetAt(i);
				    	int noofrows = sheet.getPhysicalNumberOfRows();
				    	int noofcolumns = sheet.getRow(0).getPhysicalNumberOfCells();
				    	System.out.println(noofrows);
				    	System.out.println(noofcolumns);
				    	ar = new Object[noofrows][noofcolumns];
				    	for(int j=1;j<noofrows;j++)
				    	{ 
				    		Row rf = sheet.getRow(j);
				    		for(int k=0;k<noofcolumns;k++)
				    		{
				                Cell value = rf.getCell(k);
				    				if(value.getCellType()==CellType.STRING)
				    				{
				    					//ar.add(value.getStringCellValue());
				    					ar[j-1][k] = value.getStringCellValue();
				    					System.out.println(value.getStringCellValue());
				    			}
				    				else
				    				{
				    					//ar.add(NumberToTextConverter.toText(value.getNumericCellValue()));
				    					ar[j-1][k] = NumberToTextConverter.toText(value.getNumericCellValue());
				    					System.out.println(value.getNumericCellValue());
				    				}
				    		}
				    	}
				    	
				    	
				    }
				  
			  }
		  
		return ar;
		
		  }
		  
	  
	

}
