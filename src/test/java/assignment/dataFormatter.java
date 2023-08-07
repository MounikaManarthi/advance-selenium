package assignment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dataFormatter {

	public static void main(String[] args) throws Throwable, Throwable {
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Ultimate\\Desktop\\exceldata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet("Sheet1");
		Row row = sht.getRow(4);
			Cell cel = row.getCell(4);
			
			DataFormatter format=new DataFormatter();
			//it will fetch the data what ever their in cell
			String data = format.formatCellValue(cel);
			System.out.println(data);

	}

}
