package chaitraVtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class OpportunityWithContactDDT_GU {
	public static void main(String[] args) throws Throwable {
		
	WebDriver driver=null;
	 
	 //recreating objects for utilities class
	 JavaUtility jUtil=new JavaUtility();
	 ExcelFileUtility exUtil=new ExcelFileUtility();
	 PropertyFileUtility pUtil=new PropertyFileUtility();
	 WebDriverUtility wDUtil=new WebDriverUtility();
	 //step 1-read all the necessary data
	 
	//read data from property file -common data
	
	String BROWSER = pUtil.getDataforPropertyFile("browser");
	 String URL = pUtil.getDataforPropertyFile("url");
	 String USERNAME = pUtil.getDataforPropertyFile("username");
	 String PASSWORD = pUtil.getDataforPropertyFile("password");
	 
	 //read data from excel sheet-test data
	 String CAMPAIGNNAME = exUtil.getDataFromExcel("campaign", 1, 2);
	String PRODUCTNAME = exUtil.getDataFromExcel("products", 2, 2);
	 
 //step 2- launch the browser-driver is acting based on runtime data-RunTime Polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	//if(BROWSER.contains("chrome"))

	{
	     driver=new ChromeDriver();
		System.out.println(BROWSER+ "browser launched");
	}
	else  if(BROWSER.equalsIgnoreCase("firefox"))
	{
		 driver=new FirefoxDriver();
		System.out.println(BROWSER+ "browser launched");
	}
	else 
	{
		
		System.out.println("invalid browser name");
	}
	
	
	wDUtil.maximizeWindow(driver);
	wDUtil.waitForElementsToLoad(driver);
	
	/*driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
	
	//step 3- load the url
	driver.get(URL);

	
	//step 4-login to the application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

}
}
