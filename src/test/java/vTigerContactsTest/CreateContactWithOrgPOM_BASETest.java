package vTigerContactsTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
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
		


public class CreateContactWithOrgPOM_BASETest extends BaseClass {
@Test(groups = "RegressionSuite")
public void createContactWithOrgTest() throws Throwable
{
			 /* create organization*/
			 /* read data from excel file -test data */
			 String ORGNAME=exUtil.getDataFromExcel("contacts", 4, 3)+jUtil.getRandomNumber();
			 String LASTNAME = exUtil.getDataFromExcel("contacts", 4, 2);
			 
			
			//step 5 :CLICK ON organization tab
					//
			HomePage hmP=new HomePage(driver);
			hmP.clickOnOrgLink();
					
			//step 6 : click on create organization look up image
					
			OrganizationsPage orgP=new OrganizationsPage(driver);
			orgP.clickOnCreateOrgLookUpImg();
			
			//step 7 :enter organization name
		CreateNewOrganizationsPage newOrg=new CreateNewOrganizationsPage(driver);
		newOrg.createOranization(ORGNAME);
			
								
					OrganizationsInfoPage oInfoP=new OrganizationsInfoPage(driver);
					String orgHeader = oInfoP.getHeaderText();
					
					Assert.assertTrue(orgHeader.contains(ORGNAME));
					System.out.println(orgHeader);

					/*if(orgHeader.contains(ORGNAME))
					{
						System.out.println("passed");
						System.out.println(orgHeader);
					}
					else
					{
						System.out.println("failed");
					}
			 */
			 
			 
			/*create Contact Using Organization*/
					
			//step 10: clicking on contacts tab
					hmP.clickOnContactsLink();
					
			//step 11 :click on create contact look up image
					ContactsPage cntP=new ContactsPage(driver);
					cntP.clickOnCreatContactImg();
					
			//step 12 : create contact with mandatory information		
					CreateNewContactPage newCnt=new CreateNewContactPage(driver);
					newCnt.createContact(driver, LASTNAME, ORGNAME);
					
				    //step 17: validation for contacts-
		    ContactInfoPage cntInfo=new ContactInfoPage(driver);
		    String orgHeader1 = cntInfo.getContactHeader();
			
		    Assert.assertTrue(orgHeader1.contains(LASTNAME));
	    	System.out.println(orgHeader1);

	    	/*                                            //for single argument-use assertTrue
	    	                                               //2 arguments-assertEquals
					if(orgHeader1.contains(LASTNAME))
		    {
		    	System.out.println("passed");
		    	System.out.println(orgHeader1);
		    }
		    else
		    {
		    	System.out.println("failed");
		    }*/
			Thread.sleep(2000);

		    
			System.out.println("sign out is sucessful");

		}

		@Test
		public void demo()
		{
			System.out.println("demo test executed");
		}
}
