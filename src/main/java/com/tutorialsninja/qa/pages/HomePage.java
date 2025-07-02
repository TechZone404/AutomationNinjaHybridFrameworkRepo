package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
	
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	 private WebElement regiseterOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath ="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions 
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	public LoginPage selectloginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage selectRegisterOption() {
		regiseterOption.click();
		return new RegisterPage(driver);
	}
	public void enterProductNameIntoSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	public SearchPage searchForAProduct(String productText) {
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		regiseterOption.click();
		return new RegisterPage(driver);
	}
}
