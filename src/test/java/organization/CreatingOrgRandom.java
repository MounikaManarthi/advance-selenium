package organization;

import java.io.FileInputStream;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingOrgRandom {
public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/index.php?action=index&module=Home");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//random-import javsa.util..
	
	Random r =new Random();
     int ranNum = r.nextInt(1000);
   WebElement orgName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
   orgName.sendKeys("qspiders229181"+ranNum);
	
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("3456787654");
	driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("mouni@gmail.com");
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);

	//SIGNOUT
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
}
}
