package comm.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageOject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class PageGenerator extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageOject loginPageObject;
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;
	BaseTest baseTest;
	String firstName = "abc";
	String lastName = "123";
	String validEmail = "alpha" + generateFakeNumber() + "@mail.com";
	String invalidEmail = "alpha" + generateFakeNumber();
	String incorrectEmail = "alpha" + generateFakeNumber() + "@mail.com";
	String password = "123456";
	String confPassword = "123456";

	public int generateFakeNumber() {
		Random number = new Random();
		return number.nextInt(10000);
	}
	@Test
	  public void Login_01_Empty_Data() {
		loginPageObject= homePageObject.clickToLoginLink();
		 
		  loginPageObject.clickToLoginButton();
		  Assert.assertEquals(loginPageObject.getEmailErrorMessage(), "Please enter your email");
		  
	  }


	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
	driver=	getBrowserDriver(browserName,url);
	homePageObject = PageGeneratorManager.getHomePageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		

		

	}

	@AfterClass
	public void afterClass() {
	}

}
