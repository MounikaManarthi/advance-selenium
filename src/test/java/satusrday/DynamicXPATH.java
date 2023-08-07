package satusrday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicXPATH {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.get("https://www.makemytrip.com/");
driver.manage().window().maximize();
WebElement departure = driver.findElement(By.xpath("//label[@for='departure']"));
Actions act=new Actions(driver);
act.moveToElement(departure);
driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::p[text()='12']"));
}

}
