package chaitraVtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		//WebDriver driver=new ChromeDriver();
		//step 1- load the file in java readable format
		FileInputStream fis =new FileInputStream("./src/test/resources/vtigerExcelTestdata.xlsx");
		
		//step 2-create the workbook for file loaded
		Workbook wb = WorkbookFactory.create(fis); // import -(inputstrean inp)
		
		//step 3- navigate to required sheet
		Sheet sht = wb.getSheet("contacts");
		
		//step 4- navigate to the required row 
		Row row = sht.getRow(2);
		
		//step 5- navigate to the required cell
		Cell cel = row.getCell(1);
		
		//step 6- capture the value inside the cell
		String value = cel.getStringCellValue();
		System.out.println(value);

	}

}
