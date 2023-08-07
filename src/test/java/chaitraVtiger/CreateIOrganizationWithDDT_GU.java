package chaitraVtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateIOrganizationWithDDT_GU {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= null;
		//creating objects for utilities class
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility exUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//READ ALL THE NECCESARY DATA
		//read the data from property file-common data
		String BROWSER = pUtil.getDataforPropertyFile("browser");
		String URL = pUtil.getDataforPropertyFile("url");
		String USERNAME = pUtil.getDataforPropertyFile("username");
		String PASSWORD = pUtil.getDataforPropertyFile("password");
		
		//read the data from excel-test data
		String ORGNAME = exUtil.getDataFromExcel("organization", 1, 2)+jUtil.getRandomNumber();
		
		
		//launching the browser
		if(BROWSER.contains("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if(BROWSER.contains("edge"))
		{
			driver=new EdgeDriver();
			System.out.println("edge browser launched");	
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//load the url
		driver.get(URL);
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		//CLICK ON organization tab
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//enter organization name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);

		//validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("passed");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("failed");
		}
		Thread.sleep(2000);
		//sign out
		WebElement ADMINST = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ADMINST);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("signed out succesfully");
	}
}
/*Scenario 2: 
Launch Browser
Login to application with valid credentials 
Navigate to Organizations link 
Click on Create Organization look Up Image 
Create Organizatio with Mandatory fields 
Save and Verify 
logout of Application 
*/

