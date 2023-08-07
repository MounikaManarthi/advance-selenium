package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * this class consist of generic methods related to property file
 * @author Ultimate
 *
 */
public class PropertyFileUtility 
{
	/**
	 * 
	 * this method will read the data from property file based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
public String getDataforPropertyFile(String key) throws Throwable
{
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
Properties pro=new Properties();
pro.load(fis);
String value = pro.getProperty(key);
return value;


}
}
