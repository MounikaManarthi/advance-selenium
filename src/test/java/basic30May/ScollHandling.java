package basic30May;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScollHandling {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com");
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	//untill scroll this element getting y axis
	WebElement element = driver.findElement(By.xpath("//h2[text()='Essentials For Students']"));
	int y =element.getLocation().getY();
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,"+y+")");
	
}
}
