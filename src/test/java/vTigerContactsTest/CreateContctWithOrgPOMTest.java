package vTigerContactsTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContctWithOrgPOMTest {
	//public static void main(String[] args) throws Throwable {
	@Test(groups = "SmokeTesting")
	public void createContactWithOrg() throws Throwable
	{
	
	WebDriver driver=null;
		
		/* Create Organization*/
		
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
		 String ORGNAME=eUtil.getDataFromExcel("contacts", 4, 3)+jUtil.getRandomNumber();
		 String LASTNAME = eUtil.getDataFromExcel("contacts", 4, 2);
		 
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
				/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();*/
			 LoginPage lp=new LoginPage(driver);
			 lp.loginToApp(USERNAME, PASSWORD);
			 
				 
				Thread.sleep(2000);
		//step 5 :CLICK ON organization tab
				//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		HomePage hmP=new HomePage(driver);
		hmP.clickOnOrgLink();
				
		//step 6 : click on create organization look up image
				//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		OrganizationsPage orgP=new OrganizationsPage(driver);
		orgP.clickOnCreateOrgLookUpImg();
		//step 7 :enter organization name
				//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	CreateNewOrganizationsPage newOrg=new CreateNewOrganizationsPage(driver);
	newOrg.createOranization(ORGNAME);
		
		//step 8 : save organization
				//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
				//hread.sleep(2000);

		//step 9:validation or organization
				//String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
				
				OrganizationsInfoPage oInfoP=new OrganizationsInfoPage(driver);
				String orgHeader = oInfoP.getHeaderText();
				
				 Assert.assertTrue(orgHeader.contains(ORGNAME));
					System.out.println(orgHeader);
/*
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println("passed");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("failed");
				}*/
		 
		 
		 
		/*create Contact Using Organization*/
		//step 10: clicking on contacts tab
				//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				hmP.clickOnContactsLink();
		//step 11 :click on create contact look up image
				//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				ContactsPage cntP=new ContactsPage(driver);
				cntP.clickOnCreatContactImg();
				
		//step 12 : create contact with mandatory information		
				//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);//contactname
				CreateNewContactPage newCnt=new CreateNewContactPage(driver);
				newCnt.createContact(driver, LASTNAME, ORGNAME);
				
	/*	//step 13 :click on organization look up icon
				//WebElement orglookup = driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]"));
				//orglookup.click();dont use index use dynamic xpath
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
				
		//step 14 :window handling through generic utilities-switching to child window
				wUtil.switchToWindow(driver, "Accounts&action");
				
		//step 14 :search box-search for organization
				driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
			
		//clicking on orgname from table
	           //driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//dynamic xpath
		//step 15 :switch back to parent window
				wUtil.switchToWindow(driver, "Contacts&action");
	   //step 16: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(2000); */
				       
	    //step 17: validation for contacts-
	    //String orgHeader1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    ContactInfoPage cntInfo=new ContactInfoPage(driver);
	    String orgHeader1 = cntInfo.getContactHeader();
				
	    Assert.assertTrue(orgHeader1.contains(LASTNAME));
    	System.out.println(orgHeader1);
/*
				if(orgHeader1.contains(LASTNAME))
	    {
	    	System.out.println("passed");
	    	System.out.println(orgHeader1);
	    }
	    else
	    {
	    	System.out.println("failed");
	    }
		Thread.sleep(2000);*/

	    //step 18: log out of the application
		/*WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ADMINSTR);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
		hmP.logOutOfApp(driver);
		System.out.println("sign out is sucessful");

	}
		@Test
		public void demo()
		{
			System.out.println("demo created");
		}
	}

	

