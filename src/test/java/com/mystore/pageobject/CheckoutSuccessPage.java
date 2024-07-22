package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utilities.HighLightElements;

public class CheckoutSuccessPage {


//	RemoteWebDriver driver;
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor executor;
	HighLightElements highlightElements = new HighLightElements();

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")
	WebElement ordernumerLink;

	// constructor
//		public CheckoutSuccessPage(RemoteWebDriver driver) {
//			this.driver = driver;
//			this.action = new Actions(driver);
//			this.executor = (JavascriptExecutor) driver;
//			PageFactory.initElements(driver, this);
//		}
		
		public CheckoutSuccessPage(WebDriver driver) {
			this.driver = driver;
			this.action = new Actions(driver);
			this.executor = (JavascriptExecutor) driver;
			PageFactory.initElements(driver, this);
		}
		
	String ordernumberurl = "https://magento.softwaretestingboard.com/sales/order/view/";

	public boolean ordernumberUrl() {
		return driver.getCurrentUrl().equals(ordernumberurl);
	}
}
