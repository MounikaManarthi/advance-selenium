package chaitraVtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		// step 1- load the document in java readable format
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		
		//step 2- create the object of properties class from java.util
		Properties pro=new Properties();
		
		//step 3- load the file into properties class
		pro.load(fis);
		
		//step 4- provide the key and get the value
		String URL  = pro.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
	 
		driver.get(URL);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		
		

	}

}
