package vTigerOrganizationsTests;

	import org.testng.annotations.Test;
	import static org.testng.Assert.fail;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
	import vTiger.GenericUtilities.JavaUtility;
	import vTiger.GenericUtilities.PropertyFileUtility;
	import vTiger.GenericUtilities.WebDriverUtility;
	import vTiger.ObjectRepository.CreateNewOrganizationsPage;
	import vTiger.ObjectRepository.HomePage;
	import vTiger.ObjectRepository.LoginPage;
	import vTiger.ObjectRepository.OrganizationsInfoPage;
	import vTiger.ObjectRepository.OrganizationsPage;
   
	//@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
	          //copy qualified class name from ListenerImplementationClass then put .class
	public class CreateOrgDropBaseListenersTest extends BaseClass{
		@Test
		public void createOrgdrop() throws Throwable
		{
			 //read data from excel sheet-test data
			 String ORGNAME = exUtil.getDataFromExcel("organization", 7, 2)+jUtil.getRandomNumber();
			String INDUSTRY = exUtil.getDataFromExcel("organization", 8, 3);
			 String TYPE = exUtil.getDataFromExcel("organization",8 , 4);
			
					
			//step 5 : click on organization link
			
			HomePage hmP=new HomePage(driver);
			hmP.clickOnOrgLink();
			
			Reporter.log("org link clicked");
			
			
			//step 6 :click create organization lookup image
			//Assert.fail();so in reports  after this it will not print
			OrganizationsPage orgp=new OrganizationsPage(driver);
			orgp.clickOnCreateOrgLookUpImg();
			
			Reporter.log("create org look up image is clicked");

			CreateNewOrganizationsPage createOrg=new CreateNewOrganizationsPage(driver);
			createOrg.createOranization(ORGNAME,INDUSTRY,TYPE );
			Reporter.log("orgnization is created with industry and type drop down");

	        
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
	}
		@Test
		public void demo()
		{
			Assert.fail();
			System.out.println("demo method");
		}

}
