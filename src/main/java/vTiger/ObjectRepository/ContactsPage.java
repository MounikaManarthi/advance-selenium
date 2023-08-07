package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}


	public ContactsPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	//business library
	public void clickOnCreatContactImg()
	{
		createContactLookUpImg.click();
	}
}
