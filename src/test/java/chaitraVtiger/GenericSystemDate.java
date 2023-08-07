package chaitraVtiger;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericSystemDate {

	public static void main(String[] args) throws Throwable
	{
		JavaUtility ju=new JavaUtility();
		String date = ju.getSystemDate();
		System.out.println(date);
		
         String Dateinformat = ju.getSystemDateInFormat();
         System.out.println(Dateinformat);
         
            PropertyFileUtility propUtil=new PropertyFileUtility() ;
        	String value1 = propUtil.getDataforPropertyFile("password");
        	System.out.println(value1);
        	 
        	ExcelFileUtility excelutil=new ExcelFileUtility();
        	 String value = excelutil.getDataFromExcel("organization", 4, 1);
        	 System.out.println(value);
        	 
        	 
        	  excelutil.writeDataIntoExcel("products", 1, 1,"laptop" );
         }
	}


