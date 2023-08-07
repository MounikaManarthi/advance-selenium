package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * this class consist of all reusable methods related to web driver actions
 * @author Ultimate
 *
 */
public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
 public void maximizeWindow(WebDriver driver)
 {
	 driver.manage().window().maximize();
 }
 
 /**
  * this method will minimize the window
  * @param driver
  */
 public void minimizeWindow(WebDriver driver)

 {
	 driver.manage().window().minimize();
 }
 
 /**
  * this mwthod will wait for all the findElament and findElements
  * operations to be performed
  * @param driver
  */
 public void waitForElementsToLoad(WebDriver driver)
 {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 }

 /**
  * this method will wait until the specific element is visible in DOM

  * @param driver
  * @param element
  */
 public void waitForElementToBeVisible1(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));//which element we dont know , caller will decide so parametrsd
	
 }

 /**
  * this method will wait until the specific element is visible in DOM

  * @param driver
  * @param element
  */
 public void waitForElementToBeClickable(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(element));//which element we dont know , caller will decide so parametrsd

}


 /**
  * this method will wait until the specific element title contains DOM

  * @param driver
  * @param element
  */
 public void waitForElementTitleContains(WebDriver driver,String title)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.titleContains(title));
}
 
 /**
  * this method will wait until the specific element is selected in DOM

  * @param driver
  * @param element
  */
 public void waitForElementToBeSelected(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeSelected(element));//which element we dont know , caller will decide so parametrsd
}
 
 
 /**
  * this method will handle dropdown using select class by index
  * 
  * @param element
  * @param index
  */
 public void handleDropDown(WebElement element,int index)
 {
	 Select sel=new Select(element);//no need of webdriver
	 sel.selectByIndex(index);
 }
 
 /**
  * this method will handle drop down by using value
  * @param element
  * @param value
  */
 public void handleDropDown(WebElement element,String value)
 {
	 Select sel=new Select(element);//no need of webdriver
	 sel.selectByValue(value);
 }
 
 
 /**
  * 
  * this method will  handle dropdown using visible text
  * @param text
  * @param element
  */
 public void handleDropDown(String text,WebElement element)//method overloading with diff parameters
 {                                                   //orgumnt order should be different
	 Select sel=new Select(element);
	 sel.selectByVisibleText(text);
	 
 }

 /**
  * this method will perform mouse hover action on targeted element
  * 
  * @param driver
  * @param element
  */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

/**
 * 
 * this method will perform double click action on anywhere on the web page
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver); 
	act.doubleClick().perform();
}

/**
 * this method will perform double click action on targeted element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver); 
	act.doubleClick(element).perform();
}

/**
 * this method will perform right click action on any where on the web page
 * @param driver
 */
public void rightClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
	}

/**
 * this method will perform right click action on targeted element
 * @param driver
 * @param element
 */
public void rightClickActiob(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();;
}

/**
 * this method will perform drag and drop action
 * @param driver
 * @param sourceEle
 * @param targetEle
 */
public void dragAndDropAction(WebDriver driver,WebElement sourceEle,WebElement targetEle)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(sourceEle, targetEle).perform();
}

/**
 * this method is used to move the cursor anywhere on the web page based on the offset values
 * @param driver
 * @param xOffset
 * @param yOffset
 */
public void moveAcrossWebPage(WebDriver driver,int xOffset,int yOffset)
{
	Actions act=new Actions(driver);
	act.moveByOffset(xOffset, yOffset).click().perform();
}

/**
 * this method will scroll vertically for 500 pixels
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("window.scrollby(0,500):", "");
}

/**
 * this method will scroll vertically until the reference element
 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	int y = element.getLocation().getY();
	jse.executeScript("window.scrollBy(0,"+y+");", element);
   // jse.executeScript("argument[0].scollIntoView();",element);
}

/**
 * this method will accept the alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
	}

/**
 * this method will cancel the confirmation popup
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * this method will enter the text in prompt pop up
 * @param driver
 * @param text
 */
public void sendTextToAlert(WebDriver driver,String text)
{
driver.switchTo().alert().sendKeys(text);	
}

public void getAlertText(WebDriver driver)
{
	driver.switchTo().alert().getText();
	}

/**
 * this method will handle frame based on frame index
 * @param driver
 * @param index
 */
public void handleFrames(WebDriver driver,int index)
{
driver.switchTo().frame(index);
}

/**
 * this method will handle frame based on value of name or id attributes
 * @param driver
 * @param nameOrId
 */
public void handleFrame(WebDriver driver,String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}

/**
 *this method will handle the frame based on web element
 *@param driver
 *@param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
	}

/**
 * this method will help to switch control back to immediate parent
 * @param driver
 */
public void switchToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}

/**
 * this method will help to switch the control back to current page
 * @param driver
 */
public void switchToDefaultPage(WebDriver driver)
{
driver.switchTo().defaultContent();	
}

/**
 * this method will switch the selenium control from parent to child or 
 * from child to parent based  on partial window title 
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle)
{
	//step 1 : capture all the window IDs
	Set<String> allWindowIds = driver.getWindowHandles();
	
	//step 2: iterate through individual IDs
	for(String winID:allWindowIds) //3 window ids
	{
		
	//step 3: switch to each ID and capture the title
		String currentTitle = driver.switchTo().window(winID).getTitle();

	//step 4: compare the title with required reference
		if(currentTitle.contains(partialWindowTitle))         //parameterised bcz we r giving in the script of window title
		{
		break;	
		}
	}
}	

/**
 * this method will take screen shot and return the absolute path of it
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */
public String takeScreeShot(WebDriver driver,String screenShotName) throws IOException
{
TakesScreenshot ts=(TakesScreenshot)driver;	
File src = ts.getScreenshotAs(OutputType.FILE);
File dest = new File(".\\ScreenShot\\"+screenShotName+".png");  //to copy in project-so add apache common io dependency
Files.copy(src, dest);//this class is from common IO tool
return dest.getAbsolutePath();//it will give complete path bcz attach screen shot to extent report


}

}

