package basic30May;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class wrireDataToExcel {

	public static void main(String[] args) throws  IOException {
		WebDriver driver=new ChromeDriver();
		//step-1 
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Ultimate\\Desktop\\exceldata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet("Sheet1");
		Row rw = sht.createRow(8);
		Cell cel = rw.createCell(9);
		cel.setCellValue("doggi");
		
		//write data to excel
		 FileOutputStream fos=new FileOutputStream("src/test/resources/exceldata.xlsx");
		 //FileOutputStream fos=new FileOutputStream("C:\\Users\\Ultimate\\Desktop\\exceldata.xlsx");
		 wb.write(fos);
		 wb.close();
	}

}
