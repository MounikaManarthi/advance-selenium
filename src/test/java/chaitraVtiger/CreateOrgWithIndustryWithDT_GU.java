package chaitraVtiger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

	public class CreateOrgWithIndustryWithDT_GU {

		public static void main(String[] args) throws Throwable {
			//WebDriver driver=new ChromeDriver();
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
			 
			 /*FileInputStream fis=new  FileInputStream("./src/test/resources/commonData.properties");
			Properties pro=new Properties();
			pro.load(fis);
			
			// provide the key and get the value
			 * 
			String BROWSER = pro.getProperty("browser");
			String URL  = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");*/
		    
			 
			//read data from excel sheet-test data
			 String ORGNAME = exUtil.getDataFromExcel("organization", 4, 2)+jUtil.getRandomNumber();
			String INDUSTRY = exUtil.getDataFromExcel("organization", 4, 3);
			 
			/*FileInputStream fis1=new  FileInputStream("./src/test/resources/vtigerExcelTestdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
		    Sheet sht = wb.getSheet("organization");
			String ORGNAME = sht.getRow(4).getCell(2).getStringCellValue()+random;
			String INDUSTRY = sht.getRow(4).getCell(3).getStringCellValue();
			 */
			
			
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
			wDUtil.handleDropDown( industryDrop,INDUSTRY);//import value
			
	        /*Select sel=new Select(industryDrop);
	        sel.selectByValue(INDUSTRY); */ 
	        
	        //step 9-: save
	        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	        Thread.sleep(2000);
	        
	        //step 10: validation -
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

	        //step 11: log out of the application
			WebElement ADMINSTR = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			/*WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act=new Actions(driver);
	        act.moveToElement(adminImg);*/
			wDUtil.mouseHoverAction(driver, ADMINSTR);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("sign out is sucssful");
		}

	}



























