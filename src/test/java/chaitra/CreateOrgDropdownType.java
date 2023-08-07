package chaitra;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgDropdownType {

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
		Random r=new Random();
		int ranName = r.nextInt(1000);
		WebElement orgName = driver.findElement(By.name("accountname"));
		orgName.sendKeys("qspiderjsfkrj"+ranName);
		//industry dropdown
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Thread.sleep(2000);

        Select sel=new Select(industryDrop);
        sel.selectByValue("Energy");     
        //rating dropdown
        WebElement rating = driver.findElement(By.name("rating"));
        Select sel2=new Select(rating);
        sel2.selectByValue("Active");
        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
/*Scenario 4:
Launch Browser
Login to application with valid credentials
Navigate to Organizations link
Click on Create Organization look Up Image
Create Organization with Mandatory fields
Select "Energy" in the industry drop down
Select "active" in the rating Drop down 
Save and Verify
logout of Application*/