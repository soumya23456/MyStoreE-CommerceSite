package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utilities.HighLightElements;

public class SigninPage {

//	RemoteWebDriver driver;
	WebDriver driver;
	HighLightElements highlightElements = new HighLightElements();

	@FindBy(id = "email")
	WebElement enterEmailId;
	
	@FindBy(id = "pass")
	WebElement enterPassword;
	
	@FindBy(xpath = "//button[contains(@id,'send2')]")
	WebElement signInButton;
	
	@FindBy(id = "email-error") 
	WebElement emailError;
	
	@FindBy(id = "pass-error") 
	WebElement passwordError;
	
	@FindBy(xpath = "//div[contains(@class,'page')]//div[contains(@class,'messages')]") 
	WebElement errorMessage;

	static String url = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";

	// constructor WebDriver
	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// constructor RemoteWebDriver
//	public SigninPage(RemoteWebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	// sign in 
	public void setEmail(String email) {
		enterEmailId.sendKeys(email);
	}
	
	public void setpwd(String pwd) {
		enterPassword.sendKeys(pwd);
	}
	
	public void clicklogInButton() {
		signInButton.click();
	}
	
	public String getEmail() {
		return enterEmailId.getDomProperty("value");
	}
	
	public String getpwd() {
		return enterPassword.getDomProperty("value");
	}
	
	public boolean isEmailErrorPresent() {
		return emailError.isDisplayed();
	}
	
	public String getEmailErrorMessage() {
		highlightElements.highlightElement(driver, emailError);
		return emailError.getText();
	}
	
	public String getPasswordErrorMessage() {
		highlightElements.highlightElement(driver, passwordError);
		return passwordError.getText();
	}
	
	public boolean isErrorMessagePresent() {
		return errorMessage.isDisplayed();
	}
	
	public String getErrorMessage() {
		highlightElements.highlightElement(driver, errorMessage);
		return errorMessage.getText();
	}
	public boolean signinUrl() {
		return driver.getCurrentUrl().equals(url);
	}
	
	
}
