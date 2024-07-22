package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utilities.HighLightElements;

public class CustomerAccount {

	// create object of webDriver
//	RemoteWebDriver driver;
	WebDriver driver;
	HighLightElements highlightElements = new HighLightElements();
	
	// identify web elements
	@FindBy(xpath = "//span[contains(@class,'logged-in')]")
	WebElement customerName;
	
	@FindBy(xpath = "//span[contains(@class,'logged-in')]")
	WebElement welcomeMessage;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[1]/a")
	WebElement manageAddress;
	
	// constructor
//	public CustomerAccount(RemoteWebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public CustomerAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String addressurl = "https://magento.softwaretestingboard.com/customer/address/new/";
	
	//get customer name
	public String customerName() {
		return customerName.getText();
	}
	
	public String getWelcomeMessage() {
		highlightElements.highlightElement(driver, welcomeMessage);
		return welcomeMessage.getText();
	}
	
	//click to create address 
	public void manageAddress() {
		 manageAddress.click();
	}
	
	public boolean addressUrl() {
		return driver.getCurrentUrl().equals(addressurl);
	}
}
