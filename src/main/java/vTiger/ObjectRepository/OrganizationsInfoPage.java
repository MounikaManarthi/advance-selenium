package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	//initialization
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement orgHeaderText;

//creating constructor declaration
  public OrganizationsInfoPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

  //utilization

public WebElement getOrgHeaderText() {
	return orgHeaderText;
}


//business library
public String getHeaderText()
{
	return orgHeaderText.getText();
	
}
  
}
