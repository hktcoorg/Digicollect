package digiPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	@FindBy(xpath ="//span[.='Sign in']") private WebElement signin;
	
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement signinText()
	{
		return signin;
	}
	

}
