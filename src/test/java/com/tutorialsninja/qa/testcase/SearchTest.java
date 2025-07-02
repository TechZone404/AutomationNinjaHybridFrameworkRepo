package com.tutorialsninja.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

//Updated comment

public class SearchTest extends Base{
	
	SearchPage searchPage ;
	HomePage homePage = null;;
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initalizeBrowseAndOpenApplicationUrl(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void vrifySearchWithValidProduct() {
		
		searchPage= homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.displayStatusOfHpValidProduct(),"Valid product Hp is not displayed in the search results.");
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		searchPage= homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTestingSearchResult"), "No product message in search results is not displayed");
	}
	
	@Test(priority = 3,dependsOnMethods = {"vrifySearchWithValidProduct","verifySearchWithInvalidProduct"})
	public void verifySearchWithoutAnyProduct() {
		
		SearchPage searchPage = homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTestingSearchResult"), "No product message in search results is not displayed");
	}
}
