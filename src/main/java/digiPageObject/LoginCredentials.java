package digiPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCredentials 
{
	@FindBy(xpath ="//input[@name='userid']") private WebElement userid;
	@FindBy(xpath ="//button[@type='button']") private WebElement NextBtn;
	@FindBy(xpath ="//input[@type='password']") private WebElement pwd;
	@FindBy(xpath ="//button[.='Sign In']") private WebElement signin;
	
	public LoginCredentials(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement UserText()
	{
		return userid;
	}
	public WebElement NextBtn()
	{
		return NextBtn;
	}
	public WebElement passwordText()
	{
		return pwd;
	}
	public WebElement signinButton()
	{
		return signin;
	}
	

}
