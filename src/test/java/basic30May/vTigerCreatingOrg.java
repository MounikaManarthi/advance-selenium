package basic30May;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class vTigerCreatingOrg {

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
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("qspiders");
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("3456787654");
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("mouni@gmail.com");
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
	    WebElement signout = driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);

		act.moveToElement(signout);
	} 

}
