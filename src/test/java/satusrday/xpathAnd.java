package satusrday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathAnd {

	public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/index.php?action=index&module=Home");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type='asrd' or @name='user_password']")).sendKeys("admin");
	Thread.sleep(1000);
driver.navigate().to("https://www.google.com/");
//SVG ELEMENT- 4 dots
driver.findElement(By.xpath("//*[name()='svg' and @class='gb_h']")).click();
	}

}
