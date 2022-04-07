package comm.blueimp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.blueimp.HomePage;
import pageObjects.blueimp.PageGenerators;

public class UploadFile extends BaseTest {
	@Test
	public void Upload_TC_01() {
    homePage.uploadMultipleFiles(driver, fileCapture1,fileCapture2,fileCapture3);
    homePage.clicktoStartButton();
	}

	@BeforeClass
	@Parameters ({"browser","url"})
	public void beforeClass(String browserName, String url) {
		driver= getBrowserDriver(browserName, url);
		homePage= PageGenerators.getHomePage(driver);
		//homePage.clickToAddFile();
	}

	@AfterClass
	public void afterClass() {
		
	}
HomePage homePage;
WebDriver driver;
String projectPath = System.getProperty("usr.dir");
String fileCapture1 ="Capture_1.PNG";
String fileCapture2 ="Capture_2.PNG";
String fileCapture3 ="Capture_3.PNG";
}
