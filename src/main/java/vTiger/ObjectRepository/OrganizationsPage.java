package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//declartion
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement createOrgLookUpImg;

//initialization
public OrganizationsPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
//utilization
public WebElement getCreateOrgLookUpImg() {
	return createOrgLookUpImg;
}

//business library
public void clickOnCreateOrgLookUpImg()
{
	createOrgLookUpImg.click();
}



}
