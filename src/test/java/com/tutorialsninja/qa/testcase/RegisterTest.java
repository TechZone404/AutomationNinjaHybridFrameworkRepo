package com.tutorialsninja.qa.testcase;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSucessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	RegisterPage registerPage;
	AccountSucessPage accountSucessPage;
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initalizeBrowseAndOpenApplicationUrl(prop.getProperty("browserName"));	
		HomePage homePage= new HomePage(driver);
		homePage.navigateToRegisterPage();
		registerPage = new RegisterPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyRegisteringWithMandatoryFeilds() {
		
		accountSucessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), 
				Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSucessPage.reteriveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success is not displayed");	
		
	}
	@Test(priority = 2)
	public void verifyRegisteringWithAllFeilds() { 

	    accountSucessPage = registerPage.registerWithAllFields(  // ✅ capture return value
	        dataProp.getProperty("firstName"),
	        dataProp.getProperty("lastName"),
	        Utilities.generateEmailWithTimeStamp(),
	        dataProp.getProperty("telephoneNumber"),
	        prop.getProperty("validPassword"),
	        prop.getProperty("validPassword")
	    );

	    String actualSuccessHeading = accountSucessPage.reteriveAccountSuccessPageHeading();
	    Assert.assertEquals(
	        actualSuccessHeading,
	        dataProp.getProperty("accountSuccessfullyCreatedHeading"),
	        "Account Success is not displayed"
	    );
	}
	
	@Test(priority = 3)
	public void vrifyRegisteringAccountwithExistingEmailAddress() { 
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNewsletterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		
		String actualWarning = registerPage.retrieveDuplicateEmailAddressWarning();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWaring")), "Warning message regaring duplicate email address is not displayed");
		
	
	}
	
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusoFWarningMessage(
				dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), 
				dataProp.getProperty("lastNameWarning"), 
				dataProp.getProperty("emailWarning"),
				dataProp.getProperty("telephoneWarning"), 
				dataProp.getProperty("passwordWarning")));
		
	}
	
}
