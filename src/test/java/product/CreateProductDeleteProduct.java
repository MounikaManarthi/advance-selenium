package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductDeleteProduct {

	public static void main(String[] args) throws Throwable {
	//webdrivermanager.chro
		WebDriver driver=new ChromeDriver();
FileInputStream fis=new FileInputStream("src/test/resources/Vtigerprop.properties");
Properties prop=new Properties();
prop.load(fis);
String VTURL = prop.getProperty("url");
String VTuserName = prop.getProperty("username");
String VTpassword = prop.getProperty("password");
Thread.sleep(2000);
driver.get(VTURL);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
driver.findElement(By.name("user_name")).sendKeys(VTuserName);
driver.findElement(By.name("user_password")).sendKeys(VTuserName);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[text()='Products']")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

	}

}
