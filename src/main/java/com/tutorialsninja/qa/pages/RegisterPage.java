package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameFeild;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameFeild;
	
	@FindBy(id="input-email")
	private WebElement emailAddressFeild;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneFeild;
	
	@FindBy(id="input-password")
	private WebElement passwordFeild;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmfeild;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyFeild;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement dublicateEmailAddressWarning;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarning; 
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameFeild.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameFeild.sendKeys(lastNameText);
	}
	public void enterEmailAddress(String emailText) {
		emailAddressFeild.sendKeys(emailText);
	}
	public void enterTelephoneNumber(String telephoneText) {
		telephoneFeild.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordFeild.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmfeild.sendKeys(confirmPasswordText);
	}
	public void selectPrivacyPolicy() {
		privacyPolicyFeild.click();
	}
	public AccountSucessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSucessPage(driver);
	}
	public void selectNewsletterOption() {
		yesNewsletterOption.click();
	}
	public String retrieveDuplicateEmailAddressWarning() {
		String dublicateEmailWarningText = dublicateEmailAddressWarning.getText();
		return dublicateEmailWarningText;
	}
	public String retrievePrivacyPolicyWarning() {
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarning() {
		String  firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	public String retrievelastNameWarning() {
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	public String retrieveEmailWarning() {
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	public String retrievePasswordWarning() {
		String passwordWarningText= passwordWarning.getText();
		return passwordWarningText;
	}
	public String retrieveTelephoneWarning() {
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	public AccountSucessPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText, 
			String telephoneText,String passwordText, String confirmPasswordText) {
		firstNameFeild.sendKeys(firstNameText);
		lastNameFeild.sendKeys(lastNameText);
		emailAddressFeild.sendKeys(emailText);
		telephoneFeild.sendKeys(telephoneText);
		passwordFeild.sendKeys(passwordText);
		passwordConfirmfeild.sendKeys(confirmPasswordText);
		privacyPolicyFeild.click();
		continueButton.click();
		return new AccountSucessPage(driver);
	}
	public AccountSucessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, 
			String telephoneText,String passwordText, String confirmPasswordText) {
		firstNameFeild.sendKeys(firstNameText);
		lastNameFeild.sendKeys(lastNameText);
		emailAddressFeild.sendKeys(emailText);
		telephoneFeild.sendKeys(telephoneText);
		passwordFeild.sendKeys(passwordText);
		passwordConfirmfeild.sendKeys(confirmPasswordText);
		yesNewsletterOption.click();
		privacyPolicyFeild.click();
		continueButton.click();
		return new AccountSucessPage(driver);		
	}
	
	
	public boolean displayStatusoFWarningMessage(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning, 
			String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, 
			String expectedPasswordWarning) {
		
		boolean privacyPolicyWarningStatus= privacyPolicyWarning.getText().contains(expectedPasswordWarning);
		boolean firstNameWarningStatus= firstNameWarning.getText().equals(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus
				&& emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
		
		
	}
	
	
	
	
	
	
	

}
