package chaitra;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrgDropdownTest {

	//public static void main(String[] args) throws Throwable {
		
	@Test
	public void createOrgDropTest() throws Throwable
	{
		Random r=new Random();
		int ranNum = r.nextInt(1000);
	
	//step 1:launch the browser
		WebDriver driver=new ChromeDriver();
		//WebDriverManager().chromeDriver.setup();
		//webDriverManager.firefoxdriver.setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2:load the url
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		
		
		//step 3: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
		//step 4 : click on organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step 5 :create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//
		driver.findElement(By.name("accountname")).sendKeys("qspiderljsfhkjlhbrj"+ranNum);
		
		//industry dropdown
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Thread.sleep(2000);
		
        //choose chemicals in industry dropdown
        Select sel=new Select(industryDrop);
        sel.selectByValue("Chemicals");     
        //step : save
        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
        Thread.sleep(2000);
        
        //step : validation -
        String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(orgHeader.contains("qspiderljsfhkjlhbrj"))
        {
        	System.out.println("passed");
        	System.out.println(orgHeader);
        }
        else
        {
        	System.out.println("failed");
        }
		Thread.sleep(2000);

        //step : log out of the application
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		/*WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
        act.moveToElement(adminImg);*/
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("sign out is sucssful");
	}
}
/*
Scenario 3:
Launch Browser
Login to application with valid credentials
Navigate to Organizations link
Click on Create Organization look Up Image
Create Organization with Mandatory fields
Select "Chemicals" in the industry drop down
Save and Verify
logout of Application*/