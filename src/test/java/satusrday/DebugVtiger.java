package satusrday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebugVtiger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	//calling maximize method from debug vitiger class
		MaxiVitiger.maximizeWindow(driver); 
		
	}

}
