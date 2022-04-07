package comm.jquery;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.jquery.HomePage;
import pageObjects.jquery.PageGenerator;

import commons.BaseTest;

public class DataTable extends BaseTest {
	WebDriver driver;
	HomePage homePage;
	
	@Test
	public void DataTable_01() {
		homePage.clickToPaging("10");
		verifyTrue(homePage.isPageNumberActived("10"));
		homePage.clickToPaging("15");
		verifyTrue(homePage.isPageNumberActived("15"));
		homePage.clickToPaging("20");
		verifyTrue(homePage.isPageNumberActived("20"));
	}
	
	public void DataTable_02() {
		
		homePage.inputDynamicByHeaderText("Females","32132");
		homePage.inputDynamicByHeaderText("Country","Albania");
		
	}

	@BeforeClass
	@Parameters({"browser","url"})
	public void beforeClass(String browserName,String url) {
		driver = getBrowserDriver(browserName,url);
		homePage = PageGenerator.getHomePage(driver);
		

	}

	@AfterClass
	public void afterClass() {
	}

}
