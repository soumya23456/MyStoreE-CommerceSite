package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.utilities.HighLightElements;

public class SignupPage {
	
	WebDriver driver;
	HighLightElements highlightElements = new HighLightElements();

	@FindBy(name = "firstname")
	WebElement createFirstName;

	@FindBy(id = "lastname")
	WebElement createLastName;
	
	@FindBy(id = "email_address")
	WebElement createEmailId;
	
	@FindBy(id = "password")
	WebElement createPassword;
	
	@FindBy(id = "password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(className = "submit")
	WebElement createAccount;
	
	String url = "https://magento.softwaretestingboard.com/customer/account/create/";
	
	// constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// sign up elements
	public void setFName(String fname) {
		highlightElements.highlightElement(driver, createFirstName);
		createFirstName.sendKeys(fname);
	}
	
	//set inputs
	public void setLName(String lname) {
		highlightElements.highlightElement(driver, createLastName);
		createLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		highlightElements.highlightElement(driver, createEmailId);
		createEmailId.sendKeys(email);
	}
	
	public void setpwd(String pwd) {
		highlightElements.highlightElement(driver, createPassword);
		createPassword.sendKeys(pwd);
	}
	
	public void setrepwd(String repwd) {
		highlightElements.highlightElement(driver, confirmPassword);
		confirmPassword.sendKeys(repwd);
	}
	
	public void clickSubmitCreate() {
		createAccount.click();
	}
	
	//get inputs
	public String getFNameInput() {
		return createFirstName.getDomProperty("value");
	}
	
	public String getLNameInput() {
		return createLastName.getDomProperty("value");
	}
	
	public String getEmailInput() {
		return createEmailId.getDomProperty("value");
	}
	
	public String getpwdInput() {
		return createPassword.getDomProperty("value");
	}
	
	
	//check URL
	public boolean acccreateUrl() {
		return driver.getCurrentUrl().equals(url);
	}
}
