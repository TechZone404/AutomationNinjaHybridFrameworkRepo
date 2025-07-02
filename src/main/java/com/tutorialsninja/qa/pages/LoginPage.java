package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailAddressFeild;

	@FindBy(id="input-password")
	private WebElement passwordFeild;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public LoginPage(WebDriver driver ) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddrees(String emailText) {
		emailAddressFeild.sendKeys(emailText);
	}
	
	public void enetrPassword(String passwordText) {
		passwordFeild.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String emailText,String passwordText  ) {
		emailAddressFeild.sendKeys(emailText);
		passwordFeild.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String reteriveEmailPasswordNotMatchingWarningMessageText() {
		String warningText= emailPasswordNotMatchingWarning.getText();
		return warningText;
		
	}
	
	
	
	
	
	
	
	
}
