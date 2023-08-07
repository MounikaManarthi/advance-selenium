package chaitraVtiger;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactEWithDDt_GU {
	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=null;
		//creating objects for utilities class
		JavaUtility jUtil =new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility exUtil=new ExcelFileUtility();
		WebDriverUtility wDUtil=new WebDriverUtility();
		
		//step 1 :read all the neccesary data
		//read data from property file-common data
		String BROWSER = pUtil.getDataforPropertyFile("browser");
		String URL = pUtil.getDataforPropertyFile("url");
		String USERNAME = pUtil.getDataforPropertyFile("username");
		String PASSWORD = pUtil.getDataforPropertyFile("password");
		
		//read data from excel sheet-test data
		String CONTACTNAME = exUtil.getDataFromExcel("contacts", 1, 0);
		
		//step 2 :launch the browser
       if(BROWSER.contains("chrome"))
       {
    	    driver=new ChromeDriver();
    	    System.out.println(BROWSER+ " browser launched");
       }
       else if (BROWSER.contains("firefox"))
       {
    	   driver= new FirefoxDriver();
   	    System.out.println(BROWSER+ " browser launched");

       }
       
       else if (BROWSER.contains("edge"))
       {
    	   driver= new EdgeDriver();
   	    System.out.println(BROWSER+ " browser launched");
       
       }
       else
       {
    	   System.out.println("invalid browser name");
       }
       
       wDUtil.maximizeWindow(driver);
       wDUtil.waitForElementsToLoad(driver);
       
       //step 3 : load the url
       
		driver.get(URL);
		
		//step 4 :login to the application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		//clicking on contacts tab
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on create contact icon
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
		//save
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);
		
		//validation
				String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgHeader.contains(CONTACTNAME))
				{
					System.out.println("passed");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("failed");
				}
				Thread.sleep(2000);
		//signout
		 WebElement ADMINIST = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wDUtil.mouseHoverAction(driver, ADMINIST);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 System.out.println("signed out succesfully"); 
	}
}

/*http://localhost:8888
Username: admin
Password: admin

Scenario 1:
Launch Browser
Login to application with valid credentials
Navigate to Contacts link
Click on Create contact look Up Image
Create Contact with Mandatory fields
Save and Verify
logout of Application
*/