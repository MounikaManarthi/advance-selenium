package vTigerOrganizationsTests;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.HomePage;

public class CreateMultipleOrgIndustryTest {
    PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility exUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	WebDriver driver=null;
	@Test(dataProvider ="getData")
public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
{
		/*read data from property file -common data*/
		String BROWSER = pUtil.getDataforPropertyFile("browser");
		 String URL = pUtil.getDataforPropertyFile("url");
		 String USERNAME = pUtil.getDataforPropertyFile("username");
		 String PASSWORD = pUtil.getDataforPropertyFile("password");
		 
		 //read data from excel sheet-test data
		 String ORGNAME = ORG+jUtil.getRandomNumber();
		
		
		
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
		
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
		
		//step 3- load the url
		driver.get(URL);
	
		
		//step 4-login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 5 : click on organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step 6 :click create organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step 7-industry dropdown
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Thread.sleep(2000);
       
		  //step 8-choose chemicals in industry dropdown
		wUtil.handleDropDown( industryDrop,INDUSTRY);//import value
		
       //step 9-: save
       driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
       Thread.sleep(2000);
       
       //step 10: validation -
       String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
       if(orgHeader.contains(ORGNAME))
       {
       	System.out.println("passed");
       	//logout of application
       	HomePage hp=new HomePage(driver);
       	hp.logOutOfApp(driver);
}}

//before creating method we should write data provider
@DataProvider
public Object[][] getData() throws EncryptedDocumentException, Throwable
{                                   //sheetname
	return exUtil.readMultipleData("multipleOrg");
}
}
