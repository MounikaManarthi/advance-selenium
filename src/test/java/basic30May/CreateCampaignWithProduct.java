package basic30May;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		FileInputStream fis =new FileInputStream("src/test/resources/Vtigerprop.properties");
		Properties pro=new Properties();
		pro.load(fis);
		Thread.sleep(2000);
		
		String vTigerUrl = pro.getProperty("url");
		String VTUsername = pro.getProperty("username");
		String VTpassword = pro.getProperty("password");
		driver.get(vTigerUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(VTUsername);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(VTpassword);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	    Set<String> allwindows = driver.getWindowHandles();
	    //iterator-for looping..
	   Iterator<String> id = allwindows.iterator();
	   while(id.hasNext())
	   {
		   String window = id.next();//insertion order os not preserved in set
		   driver.switchTo().window(window);
			   String title = driver.getTitle();
			   if(title.contains("Products&action"))
			   {
				   break;
			   }
	   }
	   driver.findElement(By.xpath("//a[text()='laptop'])[1]")).click();


	}
}
