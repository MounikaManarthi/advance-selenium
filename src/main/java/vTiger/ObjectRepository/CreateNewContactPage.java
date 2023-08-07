package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement OrgsearchBoxEdt;
	
	@FindBy(name="search")
	private WebElement OrgsearchBtn;

/*	@FindBy(xpath="	//a[text()='qspiders']")
	private WebElement orgName;*/
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		
	}
	

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSearchBox() {
		return OrgsearchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return OrgsearchBtn;
	}


	public WebElement getContactNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	
	/**
	 * this method will perform create contact with mandatory information
	 * @param LASTNAME
	 */
	public void createContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		OrgsearchBtn.click();

	}
	
	
	/**
	 * this method will perform create contact with last name and relavant org name
	 * @param driver
	 * @param LASTNAME
	 */
	public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgNameLookUpImg.click();
		switchToWindow(driver,"Accounts");//child window
		OrgsearchBoxEdt.sendKeys(ORGNAME);
		OrgsearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		//here it is dynamic xpath so during run time it cant be created
		switchToWindow(driver, "Contacts");//parent window
		saveBtn.click();
		
		
	}
}
