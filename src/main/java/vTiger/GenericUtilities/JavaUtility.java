package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * this class consist of all the generic methods related to java
 * @author mounika
 * 
 */

public class JavaUtility {

	public int getRandomNumber()
	{
		/**
		 * this method will generate a random number for execution
		 * @return random value
		 */
		Random r =new Random();
		int random = r.nextInt(1000);
		return random;
	}
	
	/**
	 * this method will generate the system date
	 * @return
	 */

	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
		
	}
	/**
	 * this method will generate the method in specific format
	 * 
	 */
	public String getSystemDateInFormat()
	{
     Date d=new Date();
     String[] date = d.toString().split(" ");
     String CurrentDate = date[2];
     String month = date[1];
     String year = date[5];
     String time = date[3].replace(":", "-");
     String DateInFormat = CurrentDate+"/"+month+"/"+year+" time : "+time;
     return DateInFormat;
}
}
