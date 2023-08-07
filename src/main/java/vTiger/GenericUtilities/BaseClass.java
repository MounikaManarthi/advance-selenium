package vTiger.GenericUtilities;
/**
 * this class consist of all the basic configuration annotations for all the common actions
 * @author Ultimate
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	 public JavaUtility jUtil=new JavaUtility();
	public  ExcelFileUtility exUtil=new ExcelFileUtility();
	public  PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wDUtil=new WebDriverUtility();
	//public -we can access it from any child class(outside the class also)
	
       public WebDriver driver=null;
       
       //only used for listeners class to take screen shot
       //we made static bcz we can call directly with class name in listeners class
       public static WebDriver sdriver;

@BeforeSuite(groups = {"SmokeTesting","RegressionSuite"})
public void bsConfig()
{
System.out.println("++++++++++++++++++DB connection sucessfull++++++++++++++++");	
}


//@Parameters("browser")//for cross browser execution
@BeforeTest(alwaysRun =true)
//@BeforeClass(alwaysRun =true)//what ever the suite name it will run
public void bcConfig(/*String BROWSER*/) throws Throwable
{                     //for cross  browser
	//read browser name and URL from property file
	 String BROWSER = pUtil.getDataforPropertyFile("browser");
     String URL = pUtil.getDataforPropertyFile("url");//for cross browser comment this part
     
     if(BROWSER.equalsIgnoreCase("chrome"))
 		

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
 		 
 		//only used for listeners class
 		sdriver=driver;
 		//load the URL
 		driver.get(URL);

}


@BeforeMethod(alwaysRun =true)
public void bmConfig() throws Throwable
{
	//read username and password from property file
	String USERNAME = pUtil.getDataforPropertyFile("username");
	String PASSWORD = pUtil.getDataforPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);

	System.out.println("++++++++++++++++login sucessful++++++++++++++++");
}

@AfterMethod(alwaysRun =true)
public void amConfig() throws Throwable
{
HomePage hp=new HomePage(driver)	;
hp.logOutOfApp(driver);
System.out.println("++++++++++++++++logout sucessful++++++++++++++++");

}


@AfterTest(alwaysRun = true)
//@AfterClass
public void acConfig()
{
	driver.quit();
	System.out.println("++++++++++++++++BROWSER CLOSED++++++++++++++++");

}


@AfterSuite
public void asConfig()
{
	System.out.println("++++++++++++++++DB CONNECTION CLOSED++++++++++++++++");

	
}
}
