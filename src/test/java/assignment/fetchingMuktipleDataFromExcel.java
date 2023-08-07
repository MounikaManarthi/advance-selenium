package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchingMuktipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sht = wb.getSheet("sheet2");
	
	System.out.println(sht.getLastRowNum());
	for(int i=0;i<sht.getLastRowNum();i++)
	{
		Row row = sht.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++)
		{
			Cell cel = row.getCell(j);
			DataFormatter format=new DataFormatter();
			String data = format.formatCellValue(cel);
			System.out.println(data);
		}
		
	}
	}
}
