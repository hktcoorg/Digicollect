package com.testNGpractice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Assignment Create contact by DigiCollect
 * @author THRINESH
 *
 */
public class DigiCollect 
{
	@Test
	public void Assignment() throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);


		WebDriverWait wait=new WebDriverWait(driver, 20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Random ran=new Random();


		driver.get("https://testcrm.digicollect.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement loginPage = driver.findElement(By.xpath("//span[.='Sign in']"));
		wait.until(ExpectedConditions.visibilityOf(loginPage));
		Assert.assertTrue(loginPage.isDisplayed());
		System.out.println("Login page displayed");

		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("Digihelp@test.com");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		WebElement homePage = driver.findElement(By.xpath("//div/span[.='Dashboard']"));
		Assert.assertTrue(homePage.isDisplayed());
		System.out.println("User is Successfully loged in");

		try {
			WebElement contact = driver.findElement(By.xpath("//li[@id='menu-dropdown']/a/span[.='Contacts']"));
			wait.until(ExpectedConditions.visibilityOf(contact));
			contact.click();
		}
		catch(Exception e)
		{
			WebElement contacts = driver.findElement(By.xpath("//span[.='Contacts']/../div[@class='mt-2']"));
			wait.until(ExpectedConditions.visibilityOf(contacts));
			contacts.click();
		}
		driver.findElement(By.xpath("//a[.='+ Create New']")).click();

		Thread.sleep(2000);
		WebElement personalRadio = driver.findElement(By.xpath("//span[.='Personal Contact']/../div/label/span[@class='radio-icon']"));
		personalRadio.click();
		
		driver.findElement(By.xpath("//span[.='Avatar']/../div/label/span[@class='radio-icon']")).click();

		WebElement titleDrop = driver.findElement(By.xpath("//span[contains(.,'Title') and contains(.,'*')]/following-sibling::div/div/div/div[@class='multiselect__select']"));
		titleDrop.click();

		driver.findElement(By.xpath("//li[@class='multiselect__element']/span/span[.='Mr']")).click();


		driver.findElement(By.xpath("//input[@class='inputFieldNew']")).sendKeys("Thrinesh"+ran.nextInt(500));
		driver.findElement(By.xpath("//input[@class='inputFieldNew input-height' and @placeholder='Enter Middle Name']")).sendKeys("HKT");
		driver.findElement(By.xpath("//input[@class='inputFieldNew input-height' and @name='lastname']")).sendKeys("Coorg");

		WebElement relationDrop = driver.findElement(By.xpath("//span[contains(.,'Relation') and contains(.,'*')]/following-sibling::div/div/div/div[@class='multiselect__select']"));
		relationDrop.click();

		driver.findElement(By.xpath("//li[@class='multiselect__element']/span/span[.='Colleague']")).click();
		driver.findElement(By.xpath("//input[@class='inputFieldNew input-height' and @name='notes']")).sendKeys("Hello Digicollect");

		driver.findElement(By.xpath("//input[@class='inputFieldNew input-height email-text-valid' and @name='primary_email']")).sendKeys("hktcoorg@gmail.com");

		driver.findElement(By.xpath("//span[contains(.,'Mobile Number')]/following-sibling::div/div/div/div/span/span")).click();	
		driver.findElement(By.xpath("//li/strong[contains(.,'India ')]")).click();
		driver.findElement(By.xpath("//input[@class='vti__input' and @name='mobile_number']")).sendKeys("7204412345");



		WebElement saveButton = driver.findElement(By.xpath("//div/button[.='Save']"));
		Point save = saveButton.getLocation();
		int x = save.getX();int y = save.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
		saveButton.click();
		System.out.println("Contact is Created");
		
		
		try {
			WebElement contact = driver.findElement(By.xpath("//li[@id='menu-dropdown']/a/span[.='Contacts']"));
			wait.until(ExpectedConditions.visibilityOf(contact));
			contact.click();
		}
		catch(Exception e)
		{
			WebElement contacts = driver.findElement(By.xpath("//span[.='Contacts']/../div[@class='mt-2']"));
			wait.until(ExpectedConditions.visibilityOf(contacts));
			contacts.click();
		}
		driver.findElement(By.xpath("//a[.='List View']")).click();
		driver.findElement(By.xpath("//span[.='personal']")).click();

		String expectedName = "Thrinesh";
		WebElement myProfile = driver.findElement(By.xpath("//table/tbody/tr/td[3]/span[contains(.,'"+expectedName+"')]"));
		if(myProfile.isDisplayed())
		{
			System.out.println("Test case is Pass and Contact is displayed in List view");
		}
		else
		{
			System.out.println("Test case is failed");
		}
		driver.quit();
	}
}
