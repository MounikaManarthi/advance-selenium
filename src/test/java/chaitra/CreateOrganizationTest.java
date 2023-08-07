package chaitra;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

public class CreateOrganizationTest {

	//public static void main(String[] args) throws Throwable
	
	@Test
	public void createOrgTest() throws Throwable
	{	
	WebDriver driver=new ChromeDriver();
	Random r=new Random();
	int ranNum = r.nextInt(1000);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("qspiderhhjjsssf"+ranNum);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);

		//validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("qspiderhhjjsssf"))
		{
			System.out.println("passed");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("failed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
/*Scenario 2: 
Launch Browser
Login to application with valid credentials 
Navigate to Organizations link 
Click on Create Organization look Up Image 
Create Organizatio with Mandatory fields 
Save and Verify 
logout of Application 
*/