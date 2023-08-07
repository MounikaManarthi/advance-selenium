package basic30May;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicXpath {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		//to close login popup
	//driver.findElement(By.xpath("//span[@role='presentation']")).click();
	driver.findElement(By.xpath("//span[text()='Departure']")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//div[text()='June 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='14']")).click();
	Thread.sleep(2000);
	//generic entering month and date
	String month="July 2023";
	String num="25";
	Thread.sleep(2000);

	//concatinating date and month..changing the data outside the path
	driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+num+"']")).click();
	driver.findElement(By.xpath("//span[text()='Done']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[text()='Adults']/ancestor::div[1]/descendant::span[3]")).click();
	driver.findElement(By.xpath("//li[text()='business']")).click();
	driver.findElement(By.xpath("//a[text()='Done']")).click();
	driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
	}
}
