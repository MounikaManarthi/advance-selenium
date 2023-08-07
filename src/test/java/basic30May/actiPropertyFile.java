package basic30May;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class actiPropertyFile {

public static void main(String[] args) throws IOException {
		
WebDriver driver =new ChromeDriver();
/*
 //LAUNCHING ACTITIME BY HARDCODING DATA
driver.get("https://demo.actitime.com/login.do");
driver.manage().window().maximize();
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.xpath("//div[text()='Login ']")).click();
*/
//FETCHING DATA FROM EXERNAL RESOURCES

FileInputStream fis=new FileInputStream("src/test/resources/actiproperties.properties");
//PHYSICAL REPRESENTATION of actiproperties
Properties pro=new Properties();
pro.load(fis);//LOADING FILE
String actiURL = pro.getProperty("url");
String actiUSERNAME = pro.getProperty("username");
String actiPASSWORD = pro.getProperty("password");
driver.get(actiURL);
driver.findElement(By.id("username")).sendKeys(actiUSERNAME);
driver.findElement(By.name("pwd")).sendKeys(actiPASSWORD);
driver.findElement(By.xpath("//div[text()='Login ']")).click();
driver.quit();
}}
