package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//rule 1:create a separate POM class for every web page
	//rule 2: identify the web elements using @FindBy, @FindBys, @FindAll
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3: create a constructor to initialize the web elements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
    //rule 4 :provide getters to access these web elements	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    
	//Business library-project specific generic method
	/**
	 * this method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
}
