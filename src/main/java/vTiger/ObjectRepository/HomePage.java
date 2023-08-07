package vTiger.ObjectRepository;

import java.awt.event.MouseAdapter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//rule 1: create a separate class for every web page
	//rule 2:identify the web elements using @FindBy, @FindBys,@FindAll

	@FindBy(linkText="Organizations")
   private WebElement organizationsLnk;
	
   @FindBy(linkText="Contacts")
   private WebElement contactsLnk;
	
   @FindBy(linkText="Products")
   private WebElement productsLnk;
	
   @FindBy(linkText="Opportunities")
   private WebElement opportunitiesLnk;
   
   @FindBy(linkText="More")
   private WebElement moreLnk;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement administratorImg;
   
  @FindBy(linkText="Sign Out")
   private WebElement signOutLnk;
   
	//rule 3:create a constructor to initialize the web elements

   //initialization
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
	   
   }
	//rule 4 :provide getters to access these web elements

public WebElement getOrganizationsLnk() {
	return organizationsLnk;
}

public WebElement getContactsLnk() {
	return contactsLnk;
}

public WebElement getProductsLnk() {
	return productsLnk;
}

public WebElement getOpportunitiesLnk() {
	return opportunitiesLnk;
}

public WebElement getMoreLnk() {
	return moreLnk;
}

public WebElement getAdministratorImg() {
	return administratorImg;
}
public WebElement getSignOutLnk() {
	return signOutLnk;
}

//business library
/**
 * this method will click on organizations link
 */
public void clickOnOrgLink()
{
	organizationsLnk.click();	
}


/**
 * this method will click on contacts link
 */
public void clickOnContactsLink()
{
	contactsLnk.click();
}

/**
 * this method will perform click operation on product link
 * @param driver
 * @throws Throwable
 */
public void clickOnProductLnk()
 {
	 productsLnk.click();
	 
 }
 
/**
 * this method will perform log out of application
 * @param driver
 * @throws Throwable
 */
public void logOutOfApp(WebDriver driver) throws Throwable
{
mouseHoverAction(driver, administratorImg);	
//by using extends to webdriverutility we can access web driver methods directly
Thread.sleep(2000);
signOutLnk.click();

}



}