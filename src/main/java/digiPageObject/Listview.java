package digiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Listview 
{
	WebDriver driver;
	
	@FindBy(xpath ="//a[.='List View']") private WebElement list;
	@FindBy(xpath ="//span[.='personal']") private WebElement personal;
	String pName="//table/tbody/tr/td[3]/span[contains(.,'%s')]";
	
	public Listview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement listView()
	{
		return list;
	}
	
	public WebElement personalList()
	{
		return personal;
	}
	

	private WebElement stringToWebElement(String partialXpath, String replaceData)
	{
		String xpath=String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getActualprofile(String expectedName)
	{
		return stringToWebElement(pName, expectedName);
	} 
	
}
