package chaitraVtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		//step 1-load the excel file in java readable format..virtually opens in eclipse
		FileInputStream fis=new FileInputStream("./src/test/resources/vtigerExcelTestdata.xlsx");
		
		//step 2- create the workbook for file loaded
	     Workbook wb = WorkbookFactory.create(fis);
	     
	     //step 3- create sheet
	     Sheet sht = wb.createSheet("write");
	     
	     //step 4- create row
	    Row row = sht.createRow(3);
	    
	    //step 5-create cell
	    Cell cel = row.createCell(2);
	    
	    //step 6-set cell value into cell
	      cel.setCellValue("mounika");
	      
	    //step 7-open the file in java write format
	      FileOutputStream fos=new FileOutputStream("./src/test/resources/vtigerExcelTestdata.xlsx");
	      
	    //step 8-call the write method
	      wb.write(fos);
	      System.out.println("data added");
	    
	    //step 9-close the workbook
	      wb.close();
	      System.out.println("workbook closed");

		

	}

}
