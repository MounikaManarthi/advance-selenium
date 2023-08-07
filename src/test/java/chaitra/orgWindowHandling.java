package chaitra;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class orgWindowHandling {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	//ckick on organizations link
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	Random r=new Random(); 
	int ranNum = r.nextInt(1000);
	String orgName = "mouni"+ranNum;
	driver.findElement(By.name("lastname")).sendKeys(orgName);
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();


	}

}
