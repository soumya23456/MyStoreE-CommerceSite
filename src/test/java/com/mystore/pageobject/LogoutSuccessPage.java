package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utilities.HighLightElements;

public class LogoutSuccessPage {

//	RemoteWebDriver driver;
	WebDriver driver;
	HighLightElements highlightElements = new HighLightElements();
	
	private static String url = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
	
	@FindBy(xpath = "//span[contains(@class,'base')]")
	WebElement signOutMessage;
	
	@FindBy(xpath = "//p[2]")
	WebElement reDirectMessage;
	
	//constructor
//	public LogoutSuccessPage(RemoteWebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public LogoutSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signOutMessage() {
		highlightElements.highlightElement(driver, signOutMessage);
	}
	
	public void reDirectMessage() {
		highlightElements.highlightElement(driver, reDirectMessage);
	}
	
	public boolean isUrl() {
		return driver.getCurrentUrl().equals(url);
	}

	public boolean isSignoutMessagePresent() {
		return signOutMessage.isDisplayed();
	}
}
