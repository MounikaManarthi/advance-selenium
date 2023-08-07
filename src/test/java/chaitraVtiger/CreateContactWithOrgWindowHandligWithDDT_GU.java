package chaitraVtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrgWindowHandligWithDDT_GU {

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
		 String CONTACTNAME = exUtil.getDataFromExcel("contacts", 1, 0);
		 String ORGNAME = exUtil.getDataFromExcel("organization", 4, 2);
		
		
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
		
		//step 3- load the url
		driver.get(URL);
	
		//step 4-login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		//clicking on contacts tab
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				//click on create contact icon
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
				
				//click on organization look up icon
				WebElement orglookup = driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]"));
				orglookup.click();
				//window handling through generic utilities-switching to child window
				wDUtil.switchToWindow(driver, "Accounts&action");
				//in child window -search box
				driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
				
				//clicking on orgname from table
				driver.findElement(By.xpath("(//td[contains(@style,'padding')])[4]/descendant::a[text()='qspiders']")).click();
	
				//switch back to parent window
				wDUtil.switchToWindow(driver, "Contacts&action");
	//save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(2000);
				       
        //step 10: validation -
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

        //step 11: log out of the application
		WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wDUtil.mouseHoverAction(driver, ADMINSTR);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("sign out is sucssful");
	
	}
}
/*Scenario 5: - end to end - Integration
Launch Browser
Login to application with valid credentials
Navigate to Contacts link
Click on Create contact look up image
Create con with manadatory fields
Select the Organization from organization look up image
Save and verify
logout of app*/




