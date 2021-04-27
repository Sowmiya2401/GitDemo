package framworktest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public ArrayList<String> getExcelData() throws IOException
	{
		ArrayList<String> ar = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sowmiya\\eclipse-workspace\\Sample\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			if(sheet.getSheetName().equalsIgnoreCase("data"))
			{
				Iterator<Row> rows = sheet.iterator();
			      Row r = rows.next();
			    Iterator<Cell> cl = r.cellIterator();
			    int k=0;
			    int column =0;
			    while(cl.hasNext())
			    {
			    	Cell c = cl.next();
			    	if(c.getStringCellValue().equalsIgnoreCase("Name"))
			    	{
			    		column=k;
			    	}
			    	System.out.println(column);
			    }
			   while(rows.hasNext())
			   {
				   Row cr = rows.next();
				   Iterator<Cell> it = cr.cellIterator();
				   while(it.hasNext())
				   {
					   Cell its = it.next();
					   if(its.getCellType()==CellType.STRING)
					   {
						   		ar.add(its.getStringCellValue());
					   }
					   else
					   {
						   ar.add(NumberToTextConverter.toText(its.getNumericCellValue()));
					   }
					   
				   }
			   }
			    
					
			}
			
		}
		return ar;
	}
	
}
