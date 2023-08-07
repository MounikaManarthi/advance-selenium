package basic30May;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchexcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver =new ChromeDriver();
		//STEP 1 : SETTING THE PATH
		FileInputStream fis=new FileInputStream("src/test/resources/exceldata.xlsx");
		//FileInputStream fis=new FileInputStream("C:\Users\Ultimate\Desktop\exceldata.xlsx");
	
		//STEP 2 : OPEN WORKBOOK IN READ MODE
		//for reading from excel use create()
		//for write into excel use write()
        Workbook wb=WorkbookFactory.create(fis);
      //workbook-interface
        //WorkbookFactory-abstract class
        
        //STEP 3-GET CONTROL TO THESHEET
       Sheet sh= wb.getSheet("Sheet1");
       
       //STEP 4-GET THE CONTROL TO THE ROW
       Row row=sh.getRow(2);
       
       //STEP 5 :GET THE CONTROL TO THE CELL
       Cell cell=row.getCell(0);
       
       //STEP 6-FETCHING THE DATA FROM THE CELL
       String data=cell.getStringCellValue();
       System.out.println(data);
       
       Row row1=sh.createRow(3);
       Cell cell1=row1.createCell(5);
      cell1.setCellValue("amma");
      
       
     //  FileInputStream fis1=new FileInputStream("src/test/resources/exceldata.xlsx");
       //wb.write(fis1);
       

       
	}

	}


