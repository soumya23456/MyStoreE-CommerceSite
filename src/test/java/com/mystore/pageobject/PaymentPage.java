package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utilities.HighLightElements;

public class PaymentPage {

//	RemoteWebDriver driver;
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor executor;
	HighLightElements highlightElements = new HighLightElements();
	
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")
	WebElement placeOrder;
	
	// constructor
//		public PaymentPage(RemoteWebDriver driver) {
//			this.driver = driver;
//			this.action = new Actions(driver);
//			this.executor = (JavascriptExecutor) driver;
//			PageFactory.initElements(driver, this);
//		}
		
		public PaymentPage(WebDriver driver) {
			this.driver = driver;
			this.action = new Actions(driver);
			this.executor = (JavascriptExecutor) driver;
			PageFactory.initElements(driver, this);
		}
		
		String checkoutsuccessurl = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
		
		
}
