package chaitra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContacctTest {

	//public static void main(String[] args) throws InterruptedException {
@Test
public void createContTest() throws Throwable
{	
	    WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("mounika");
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
/*http://localhost:8888
Username: admin
Password: admin

Scenario 1:
Launch Browser
Login to application with valid credentials
Navigate to Contacts link
Click on Create contact look Up Image
Create Contact with Mandatory fields
Save and Verify
logout of Application
*/
