package vTigerCampaignTest;
/*Scenario 2
Navigate to compaigns link
Click on Create new campaign
Create a campaign with following details:
Choose campaign type as 'Webinar'
Choose campaign status as 'Active'
choose a product 
save campaign and verify
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;


public class CreateampaignDDT_GU_POM {
	
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


		/*creating product*/
		//click on product tab
						driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Products']")).click();
						//click on create product look up image
						driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
				//save product
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 //step 17: validation for product
		  String orgHeader2 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  if(orgHeader2.contains(PRODUCTNAME))
		  {
		  	System.out.println("passed");
		  	System.out.println(PRODUCTNAME);
		  }
		  else
		  {
		  	System.out.println("failed");
		  }
		  System.out.println("product created");
			Thread.sleep(2000);
			
			/*creating campaign*/
			//move to the more tab
			WebElement MORE = driver.findElement(By.xpath("//a[text()='More']"));
			wDUtil.mouseHoverAction(driver, MORE);
			//clicking on campaign
			driver.findElement(By.name("Campaigns")).click();
			//clicking on create campaign look up image
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);

			//campign status dropdown
			WebElement STATUSDROP = driver.findElement(By.name("campaignstatus"));
		wDUtil.handleDropDown(STATUSDROP, "Active");

			//clickin on product look up image
			driver.findElement(By.xpath("//input[@name='product_id']/following-sibling::img[@alt='Select']")).click();
		wDUtil.switchToWindow(driver, "Products&action");
		//search text field
		driver.findElement(By.name("search_text")).sendKeys(PRODUCTNAME);
		//CLICKING ON SEARCH NOW
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+PRODUCTNAME+"']")).click();
		//switching to parent window
		wDUtil.switchToWindow(driver, "Campaigns&action");
		//saving campaign
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//validation of campaign
		String orgHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(CAMPAIGNNAME))
		{
			System.out.println("passed");
			System.out.println(CAMPAIGNNAME);
		}
		else
		{
			System.out.println("failed");
		}
		System.out.println("campaign created");

		  //step 18: log out of the application
			WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wDUtil.mouseHoverAction(driver, ADMINSTR);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("sign out is sucssful");

			
			}
		
	
}
