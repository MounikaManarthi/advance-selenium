package vTigerOrganizationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class VCreateOrgWithIndustryBaseTest extends BaseClass {
	//public static void main(String[] args) throws Throwable {
	//WebDriver driver=new ChromeDriver();
@Test
public void orgWithIndustry() throws Throwable
{

	 
	
	 //step 1-read all the necessary data
	 
	
	 //read data from excel sheet-test data
	 String ORGNAME = exUtil.getDataFromExcel("organization", 7, 2)+jUtil.getRandomNumber();
	String INDUSTRY = exUtil.getDataFromExcel("organization", 8, 3);
	 String TYPE = exUtil.getDataFromExcel("organization",8 , 4);
	
	
	
 	wDUtil.maximizeWindow(driver);
	wDUtil.waitForElementsToLoad(driver);
	
	/*driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

	
	//step 5 : click on organization link
	//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	HomePage hp=new HomePage(driver);
	hp.clickOnOrgLink();
	
	//step 6 :click create organization lookup image
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	OrganizationsPage orgp=new OrganizationsPage(driver);
	orgp.clickOnCreateOrgLookUpImg();
	//
	
	CreateNewOrganizationsPage newp=new CreateNewOrganizationsPage(driver);
	newp.createOranization(ORGNAME, INDUSTRY, TYPE);
	
	
    
    //step 10: validation -
OrganizationsInfoPage info=new OrganizationsInfoPage(driver);
String ORGHEADER = info.getHeaderText();
Assert.assertTrue(ORGHEADER.contains(ORGNAME));
System.out.println("org created");
}

}
