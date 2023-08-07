package chaitra;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgRandom {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//random class
		Random r=new Random();
		int random = r.nextInt();
		String orgName = "QSPIDERS"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);

		//validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(orgName))
		{
			System.out.println("+passed");
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
