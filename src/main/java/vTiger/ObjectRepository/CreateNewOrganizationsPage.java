package vTiger.ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import vTiger.GenericUtilities.WebDriverUtility;
	public class CreateNewOrganizationsPage  extends WebDriverUtility {

		//declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;

	@FindBy(name="industry")
	private WebElement industryDropDown;

	@FindBy(name="accounttype")
	private WebElement accountTypeDropDown;

	@FindBy(name="rating")
	private WebElement ratingDropDown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	//initialization
	public  CreateNewOrganizationsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAccountTypeDropDown() {
		return accountTypeDropDown;
	}

	public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library
	/**
	 * THIS METHOD WILL CREATE ORGANIZATION WITH MANDOTARY FIELDS
	 * @param ORGNAME
	 */
	public void createOranization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}

	/**
	 * this method will create organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOranization(String ORGNAME,String INDUSTRY)
	{//method over loading
		orgNameEdt.sendKeys(ORGNAME);
	handleDropDown(industryDropDown, INDUSTRY);
	saveBtn.click();

	}
	
	/**
	 * this method will create organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */

	public void createOranization(String ORGNAME,String INDUSTRY,String TYPE)
	{//method over loading
	orgNameEdt.sendKeys(ORGNAME);
	handleDropDown(industryDropDown, INDUSTRY);
	handleDropDown( accountTypeDropDown,TYPE);
	saveBtn.click();

	}

	}


