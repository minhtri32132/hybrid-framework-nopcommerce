package comm.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.ComputersObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;

public class SortCommerce extends BaseTest {
	WebDriver driver;
	ComputersObject computersObject;
	HomePageObject homePageObject;
  
  public void Deskop_TC01_Sort_By_Name() {
	  homePageObject= PageGeneratorManager.getHomePageObject(driver);
	  
	  homePageObject.clickToSubMenuList(driver, "Computers ", "Desktops ");;
	  
	  
	  computersObject = PageGeneratorManager.getComputers(driver);
	  computersObject.selectDropdownSortBy(driver, "5");
	  computersObject.areJQueryAndJSLoadedSuccess(driver);
	  Assert.assertTrue(computersObject.sortByAsc(driver));
	  
	  computersObject.selectDropdownSortBy(driver, "5");
	  computersObject.areJQueryAndJSLoadedSuccess(driver);
	  //	Assert.assertTrue(computersObject.sortByDesc(driver));
	  
	  
	  computersObject.selectDropdownSortBy(driver, "6");
	  computersObject.areJQueryAndJSLoadedSuccess(driver);
	  Assert.assertTrue(computersObject.sortByDesc(driver));
  }
  @Test
  public void Deskop_TC02_Sort_By_Price() {
	  homePageObject= PageGeneratorManager.getHomePageObject(driver);
	  
		homePageObject.clickToSubMenuList(driver, "Computers ", "Desktops ");;
		
		
		computersObject = PageGeneratorManager.getComputers(driver);
		computersObject.selectDropdownSortBy(driver, "10");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortPriceByAsc(driver));
		
	
		computersObject.selectDropdownSortBy(driver, "11");
		computersObject.areJQueryAndJSLoadedSuccess(driver);
		Assert.assertTrue(computersObject.sortPriceByDesc(driver));
  }
  @Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		driver = getBrowserDriver(browserName,url);
		
		
		
	//	homePageObject = new HomePageObject(driver);

	}

  @AfterClass
  public void afterClass() {
	 // driver.quit();
  }

}
