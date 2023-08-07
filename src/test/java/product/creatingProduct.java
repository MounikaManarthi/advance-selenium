package product;
/* click on products,then click +,give product name,scroll down,click on save,then log out
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class creatingProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("laptop");
		WebElement save = driver.findElement(By.name("button"));
		Thread.sleep(2000);
	    Rectangle data = save.getRect();
	    System.out.println("x"+data.getX());//602
	    System.out.println("y"+data.getY());//229
		Thread.sleep(2000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    
	     for(int i=0;i<4;i++)
	     {
	    js.executeScript("window.scrollBy(0,229)");
		Thread.sleep(2000);
	     }
	     	//js.executeScript("window.scrollBy(0,1200)");
			save.click();
			Thread.sleep(2000);
//SIGNOUT
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
}}
