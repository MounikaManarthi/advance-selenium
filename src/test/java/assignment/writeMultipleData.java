package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class writeMultipleData {
	public static void main(String[] args) throws InterruptedException, Throwable, Throwable {
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("./src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Ultimate\\Desktop\\exceldata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet("Sheet2");
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		//fetching all links
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
				//we don't know how many links present in the page
				//so i call a method size().it will fetch all links present in the page
		//it will give complete size of links..calling from java.util.list.web element method
		
		//for loop
		for(int i=0;i<=allLinks.size();i++)
		{
			Thread.sleep(3000);
			Row row=sht.createRow(i);//row starts from i..0 to .......
			Cell cel = row.createCell(0);//column starts with 0
			cel.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		Thread.sleep(3000);
		FileOutputStream fos=new FileOutputStream("src/test/resources/exceldata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
//get(i)-index value0,getattribute()-hrefindicates links & attribute value passed to the excel sheet
