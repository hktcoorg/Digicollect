package com.testNGpractice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

import com.digicollect.Genric.FileUtility;
import com.digicollect.Genric.IConstantPath;
import com.digicollect.Genric.PropertyFileKeys;

import digiPageObject.HomePage;
import digiPageObject.Listview;
import digiPageObject.LoginCredentials;
import digiPageObject.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class digi
{

	@Test
	public void Assignment() throws InterruptedException, IOException
	{

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);


		WebDriverWait wait=new WebDriverWait(driver, 20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Random ran=new Random();

		loginPage loginpage=new loginPage(driver);
		LoginCredentials logcre=new LoginCredentials(driver);
		HomePage hpage=new HomePage(driver);
		Listview list=new Listview(driver);
		
		FileUtility file=new FileUtility();
		file.openPropertyFile(IConstantPath.PROPERTIES_PATH);

		driver.get(file.getDataFromPropertyFile(PropertyFileKeys.DIGIURL.converttoString()));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement loginPage = loginpage.signinText();
		wait.until(ExpectedConditions.visibilityOf(loginPage));
		Assert.assertTrue(loginPage.isDisplayed());
		System.out.println("Login page displayed");

		logcre.UserText().sendKeys(file.getDataFromPropertyFile("userid"));
		logcre.NextBtn().click();
		logcre.passwordText().sendKeys(file.getDataFromPropertyFile("password"));
		logcre.signinButton().click();

		WebElement homePage = hpage.dashbordText();
		wait.until(ExpectedConditions.visibilityOf(homePage));
		Assert.assertTrue(homePage.isDisplayed());
		System.out.println("User is Successfully loged in");

		try {
			WebElement contact = hpage.contactTNB();
			wait.until(ExpectedConditions.visibilityOf(contact));
			contact.click();
		}
		catch(Exception e)
		{
			WebElement contacts = hpage.contactTNB1();
			wait.until(ExpectedConditions.visibilityOf(contacts));
			contacts.click();
		}
		hpage.createNewDrop().click();

		Thread.sleep(2000);
		WebElement personalRadio = hpage.personalRadio();
		personalRadio.click();

		hpage.avatharRadio().click();

		WebElement titleDrop = hpage.titleDrop1();
		titleDrop.click();

		hpage.MrDrop().click();


		hpage.fNameTF().sendKeys(file.getDataFromPropertyFile("fname")+ran.nextInt(500));
		hpage.mNameTF().sendKeys(file.getDataFromPropertyFile("mname"));
		hpage.lNameTF().sendKeys(file.getDataFromPropertyFile("lname"));

		WebElement relationDrop = hpage.relatDrop();
		relationDrop.click();

		hpage.colleagueDrop().click();
		hpage.notesTF().sendKeys(file.getDataFromPropertyFile("notes"));

		hpage.primailTF().sendKeys(file.getDataFromPropertyFile("pmail"));

		hpage.flagDrop().click();	
		hpage.indiaPhnone().click();
		hpage.mobNoTF().sendKeys(file.getDataFromPropertyFile("mobNo"));



		WebElement saveButton = hpage.saveBTN();
		Point save = saveButton.getLocation();
		int x = save.getX();int y = save.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
		saveButton.click();
		System.out.println("Contact is Created");


		try {
			WebElement contact = hpage.contactTNB();
			wait.until(ExpectedConditions.visibilityOf(contact));
			contact.click();
		}
		catch(Exception e)
		{
			WebElement contacts = hpage.contactTNB1();
			wait.until(ExpectedConditions.visibilityOf(contacts));
			contacts.click();
		}
		
		list.listView().click();
		list.personalList().click();

		String expectedName = file.getDataFromPropertyFile("fname");
		
		WebElement myProfile = list.getActualprofile(expectedName);
		if(myProfile.isDisplayed())
		{
			System.out.println("Test case is Pass and Contact is displayed in List view");
		}
		else
		{
			System.out.println("Test case is failed");
		}
		file.closePropertyFile();
		driver.quit();
	}

}
