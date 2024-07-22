package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.testcases.BaseClass;
import com.mystore.utilities.HighLightElements;

public class LogoutPage extends BaseClass{
	
//	RemoteWebDriver driver;
	WebDriver driver;
	HighLightElements highlightElements = new HighLightElements();
	
//	@FindBy(xpath = "//button")
//	WebElement logoutdropdownaccCreate;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	WebElement logoutdropdownaccCreate;
	
//	@FindBy(xpath = "//button[contains(@class,'switch')][1]")
//	WebElement logoutdropdown;
	
	@FindBy(xpath = "//button[contains(@class,'switch')]")
	WebElement logoutdropdown;

	@FindBy(linkText = "Sign Out")
	WebElement logoutbutton;
	
	@FindBy(linkText = "Sign Out")
	WebElement logoutbuttonaccCreate;//	 "\r\n"+ "Sign Out "

	
	String url = "https://magento.softwaretestingboard.com/customer/account/";
	String addtocarturl = "https://magento.softwaretestingboard.com/selene-yoga-hoodie.html";
	String ordersuccessurl = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
	
	public void logoutdropdownaccCreate() {
		logoutdropdownaccCreate.click();
	}
	
	public void logoutbuttonaccCreate() {
		logoutbuttonaccCreate.click();
	}
	
	public void logoutdropdown() {
		logoutdropdown.click();
	}
	
	public void logoutbutton() {
		logoutbutton.click();
	}
	
	// constructor
//	public LogoutPage(RemoteWebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//check URL
	public boolean isUrl() {
		return driver.getCurrentUrl().equals(url);
	}
	
	public boolean addtocartUrl() {
		return driver.getCurrentUrl().equals(addtocarturl);
	}
	
	public boolean ordersuccessUrl() {
		return driver.getCurrentUrl().equals(addtocarturl);
	}
	
	public boolean isDropdownVisible() {
		return logoutdropdown.isDisplayed();
	}
}
