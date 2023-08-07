package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * this class consists of generic methods related to excel file
 * @author Ultimate
 *
 */
public class ExcelFileUtility {
	/**
	 * this method will read the data from excel sheet based on sheet name,row number and 
	 * cell number given by the caller
	 * @param sheet
	 * @param rownum
	 * @param celnum
	 * @return value
	 * @throws Throwable
	 */
public String getDataFromExcel(String sheetname,int rownum,int celnum) throws Throwable
{
	FileInputStream fis =new FileInputStream(Iconstants.excelFilePath);
	//here we are accessing path from iconstants interface
	Workbook wb = WorkbookFactory.create(fis);
	 String value = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).getStringCellValue();
	 wb.close();
	  return value;
	}

/**
 * this method will write the data into excel sheet
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @return
 * @throws Throwable
 */
public void writeDataIntoExcel( String sheetName,int rowNum,int cellNum,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream(Iconstants.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sht = wb.createSheet(sheetName);
	Row row=sht.createRow(rowNum);
	Cell cel = row.createCell(cellNum);
	cel.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(Iconstants.excelFilePath);
	wb.write(fos);
	wb.close();
	//for  writing there is no need to return any data .bcz we r writing into excel
	//but for reading we should return and we should give the return type
	//create sheet creates new sheet.getsheet will get the sheet which is already created
}
	/**
	 * this method will read all the data inside a sheet to used in  data provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis=new FileInputStream(Iconstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh=wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();//capture no of rows
		 short lastCell = sh.getRow(0).getLastCellNum();//capture no of cells
		//here we r giving sh.getrow() y bcz we cant directly fetch cell no.
		 //we use row to access the cell no
		 Object[][] data=new Object[lastRow][lastCell];
		 
		 for(int i=0;i<lastRow;i++)  //for row navigation
		 {
			 for(int j=0;j<lastCell;j++)  //for cell navigation
			 {
				 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				 
			 }
		 }
		return data;
		
	}
}

