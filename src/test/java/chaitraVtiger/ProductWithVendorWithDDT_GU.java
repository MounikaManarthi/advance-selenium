package chaitraVtiger;
/*Scenario 1
Navigate to products link
Click on Create New Product
Create new Product with A vendor
Choose 303-interest-income in GL Account Drop down
Save the product n verify.*/
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

public class ProductWithVendorWithDDT_GU {
	public static void main(String[] args) throws Throwable {
		
	
	WebDriver driver=null;
	//create objects for utilities class
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//step 1: read all the neccesary data
		
		/*read data from property file-common data*/
		 String BROWSER = pUtil.getDataforPropertyFile("browser");
		 String URL = pUtil.getDataforPropertyFile("url");
		 String USERNAME = pUtil.getDataforPropertyFile("username");
		 String PASSWORD = pUtil.getDataforPropertyFile("password");
		 
		 /* read data from excel file -test data */
		 String VENDORNAME=eUtil.getDataFromExcel("products", 1, 3);
		 String GL_ACCOUNT = eUtil.getDataFromExcel("products", 1, 4);
		 String PRODUCTNAME=eUtil.getDataFromExcel("products", 1, 2);
		 //step 2:launch the browser-driver is acting based on runtime data-runtime polymorphism
		 if(BROWSER.contains("chrome"))
		 {
			 //WebdriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		     System.out.println(BROWSER + " browser launched");
			 
		 }
		 else if(BROWSER.contains("firefox"))
		 {
			 driver=new FirefoxDriver();
		     System.out.println(BROWSER + " browser launched");
		 }
		 else if(BROWSER.contains("edge"))
		 {
			 driver=new EdgeDriver();
		     System.out.println(BROWSER + " browser launched");
		 }
		 else
		 {
			 System.out.println("invalid browser name");
		 }
		 
		 wUtil.maximizeWindow(driver);
		 wUtil.waitForElementsToLoad(driver);
		 
		//step 3 : load the url
			 driver.get(URL);
			 
		//step 4 :login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(2000);
				/*creating vendor*/
				//click on more tab
				WebElement MORE = driver.findElement(By.xpath("//a[.='More']"));
				wUtil.mouseHoverAction(driver, MORE);
				//clicking on vendors
				driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		//step 6 : click on create vendor look up image
				driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		//step 7 :enter vendor name
				driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
				//selecting 303-Interest-Income in dropdown
				WebElement GLDROP = driver.findElement(By.name("glacct"));
				wUtil.handleDropDown(GLDROP, "303-Interest-Income");
				//save vendor
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 //step 17: validation for vendor-
			    String orgHeader1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			    if(orgHeader1.contains(VENDORNAME))
			    {
			    	System.out.println("passed");
			    	System.out.println(orgHeader1);
			    }
			    else
			    {
			    	System.out.println("failed");
			    }
			    System.out.println("vendor created");
				Thread.sleep(2000);
/*creating product*/
//click on product tab
				driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Products']")).click();
				//click on create product look up image
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
	//clicking on vendor look up image
	driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@alt='Select']")).click();
	wUtil.switchToWindow(driver, "Vendors&action");
	driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).click();//dynamic xpath
	//switch to parent window

	wUtil.switchToWindow(driver, "Products&action");
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

    //step 18: log out of the application
	WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, ADMINSTR);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	System.out.println("sign out is sucssful");

	
	
	}
}