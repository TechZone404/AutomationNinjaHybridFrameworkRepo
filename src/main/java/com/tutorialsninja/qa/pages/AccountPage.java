package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	WebElement editYourAccountInformatingOption;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDidplayStatusOfEditYourAccountInformationOption() {
		boolean displayStatus = editYourAccountInformatingOption.isDisplayed();
		return displayStatus;
	}

}
