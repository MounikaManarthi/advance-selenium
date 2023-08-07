package vTigerOrganizationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrgDrop_POMTest{
	//public static void main(String[] args) throws Throwable {
		//WebDriver driver=new ChromeDriver();
	@Test
	public void createOrgDropDwn() throws Throwable
	{
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
		 String ORGNAME = exUtil.getDataFromExcel("organization", 7, 2)+jUtil.getRandomNumber();
		String INDUSTRY = exUtil.getDataFromExcel("organization", 8, 3);
		 String TYPE = exUtil.getDataFromExcel("organization",8 , 4);
		
		
		
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
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//by POM class
		LoginPage lp=new LoginPage(driver);
		
	 /* lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();*/
		
		//through business library
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step 5 : click on organization link
		
		HomePage hmP=new HomePage(driver);
		hmP.clickOnOrgLink();
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step 6 :click create organization lookup image
		OrganizationsPage orgp=new OrganizationsPage(driver);

		orgp.clickOnCreateOrgLookUpImg();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		CreateNewOrganizationsPage createOrg=new CreateNewOrganizationsPage(driver);
		//createOrg.createOranization(ORGNAME);only org name
		createOrg.createOranization(ORGNAME,INDUSTRY,TYPE );
		
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step 7-industry dropdown
		//WebElement industryDrop = driver.findElement(By.name("industry"));
		//Thread.sleep(2000);//img[@alt='Create Organization...']
        
		  //step 8-choose chemicals in industry dropdown
		//wDUtil.handleDropDown( industryDrop,INDUSTRY);//import value
		//type dropdown
		//WebElement typeDrop = driver.findElement(By.name("accounttype"));
		//wDUtil.handleDropDown(typeDrop,TYPE);
        
        //step 9-: save
       // driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
        Thread.sleep(2000);
        
        //step 10: validation -
       // String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        
        OrganizationsInfoPage infop=new OrganizationsInfoPage(driver)    ;
        String orgHeader = infop.getHeaderText();
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
       System.out.println("organization is created");
        
        
        
       //step 11: log out of the application
	/*	WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wDUtil.mouseHoverAction(driver, ADMINSTR);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
        
        hmP.logOutOfApp(driver);
		System.out.println("sign out is sucssful");
	
}

}

