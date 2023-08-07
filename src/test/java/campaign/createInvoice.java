package campaign;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createInvoice {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
		driver.findElement(By.name("subject")).sendKeys("mobile");
		driver.findElement(By.xpath("(//img[@alt='Select'])[3]")).click();
		//driver.findElement(By.xpath("//a[text()='qspiders']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while(id.hasNext())
		{
			String window = id.next();
			driver.switchTo().window(window);
		String title = driver.getTitle();
		if(title.contains("Accounts&action"))
		{
			Thread.sleep(2000);
			break;
		}
		driver.findElement(By.id("qspiders")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		}
		
	}
}
