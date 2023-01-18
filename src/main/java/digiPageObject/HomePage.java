package digiPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath ="//div/span[.='Dashboard']") private WebElement dashbord;
	@FindBy(xpath ="//li[@id='menu-dropdown']/a/span[.='Contacts']") private WebElement contact;
	@FindBy(xpath ="//span[.='Contacts']/../div[@class='mt-2']") private WebElement contact1;
	@FindBy(xpath ="//a[.='+ Create New']") private WebElement createNew;
	@FindBy(xpath ="//span[.='Personal Contact']/../div/label/span[@class='radio-icon']") private WebElement personal;
	@FindBy(xpath ="//span[.='Avatar']/../div/label/span[@class='radio-icon']") private WebElement avathar;
	@FindBy(xpath ="//span[contains(.,'Title') and contains(.,'*')]/following-sibling::div/div/div/div[@class='multiselect__select']") private WebElement title;
	@FindBy(xpath ="//li[@class='multiselect__element']/span/span[.='Mr']") private WebElement mr;
	@FindBy(xpath ="//input[@class='inputFieldNew']") private WebElement fName;
	@FindBy(xpath ="//input[@class='inputFieldNew input-height' and @placeholder='Enter Middle Name']") private WebElement mName;
	@FindBy(xpath ="//input[@class='inputFieldNew input-height' and @name='lastname']") private WebElement lName;
	@FindBy(xpath ="//span[contains(.,'Relation') and contains(.,'*')]/following-sibling::div/div/div/div[@class='multiselect__select']") private WebElement relation;
	@FindBy(xpath ="//li[@class='multiselect__element']/span/span[.='Colleague']") private WebElement colleague;
	@FindBy(xpath ="//input[@class='inputFieldNew input-height' and @name='notes']") private WebElement notes;
	@FindBy(xpath ="//input[@class='inputFieldNew input-height email-text-valid' and @name='primary_email']") private WebElement Primail;
	@FindBy(xpath ="//span[contains(.,'Mobile Number')]/following-sibling::div/div/div/div/span/span") private WebElement flag;
	@FindBy(xpath ="//li/strong[contains(.,'India ')]") private WebElement india;
	@FindBy(xpath ="//input[@class='vti__input' and @name='mobile_number']") private WebElement mobNo;
	@FindBy(xpath ="//div/button[.='Save']") private WebElement save;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement dashbordText()
	{
		return dashbord;
	}
	public WebElement contactTNB()
	{
		return contact;
	}
	public WebElement contactTNB1()
	{
		return contact1;
	}

	public WebElement createNewDrop()
	{
		return createNew;
	}
	public WebElement personalRadio()
	{
		return personal;
	}
	public WebElement avatharRadio()
	{
		return avathar;
	}
	public WebElement titleDrop1()
	{
		return title;
	}
	
	public WebElement MrDrop()
	{
		return mr;
	}
	public WebElement fNameTF()
	{
		return fName;
	}
	public WebElement mNameTF()
	{
		return mName;
	}
	public WebElement lNameTF()
	{
		return lName;
	}
	public WebElement relatDrop()
	{
		return relation;
	}
	public WebElement colleagueDrop()
	{
		return colleague;
	}
	
	public WebElement notesTF()
	{
		return notes;
	}
	
	public WebElement primailTF()
	{
		return Primail;
	}
	public WebElement flagDrop()
	{
		return flag;
	}
	public WebElement indiaPhnone()
	{
		return india;
	}
	
	public WebElement mobNoTF()
	{
		return mobNo;
	}
	
	public WebElement saveBTN()
	{
		return save;
	}
	
}
