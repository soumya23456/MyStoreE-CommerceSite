package com.mystore.pageobject;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.utilities.HighLightElements;

public class OrderSuccessPage {

//	RemoteWebDriver driver;
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor executor;
	HighLightElements highlightElements = new HighLightElements();

	@FindBy(xpath = "//*[@id=\"checkout\"]/div[1]/button")
	WebElement signinLink;

	@FindBy(id = "login-email")
	WebElement emailButton;

	@FindBy(id = "login-password")
	WebElement pwdButton;

	@FindBy(name = "action-login")
	WebElement signinButton;

	@FindBy(xpath = "//*[@id=\"opc-shipping_method\"]/div/div[1]")
	WebElement shippingorderElement;

	@FindBy(linkText = "Create an Account")
	WebElement ordersuccessMessage;

	@FindBy(xpath = "//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]")
	WebElement clickorderSummary;

	@FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
	WebElement checkoutradioButton;

	@FindBy(xpath = "//button[contains(@class,'button action continue primary')]")
	WebElement nextButton;

	@FindBy(xpath = "//button[contains(@class,'action primary checkout')]")
	WebElement placeorderButton;

	@FindBy(xpath = "//a[contains(@class,'order-number')]")
	WebElement orderNumber;

	@FindBy(linkText = "Print Order")
	WebElement printOrder;

	String paymenturl = "https://magento.softwaretestingboard.com/checkout/#payment";

	// constructor
//	public OrderSuccessPage(RemoteWebDriver driver, WebDriverWait wait) {
//		this.driver = driver;
//		this.wait = wait;
//		this.action = new Actions(driver);
//		this.executor = (JavascriptExecutor) driver;
//		PageFactory.initElements(driver, this);
//	}

	public OrderSuccessPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.action = new Actions(driver);
		this.executor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	String shippingurl = "https://magento.softwaretestingboard.com/checkout/#shipping";

	//click on sign in link
	public void signinLink() {
		signinLink.click();
	}

	//set sign in elements
	public void setemailButton(String email) {
		emailButton.sendKeys(email);
	}

	public void setpwdButton(String pwd) {
		pwdButton.sendKeys(pwd);
	}

	public void signinButton() {
		signinButton.click();
	}

	//high lighting shipping order element 
	public void shippingorderElement() {
		executor.executeScript("arguments[0].scrollIntoView();", shippingorderElement);
		highlightElements.highlightElement(driver, shippingorderElement);
	}

	//clicking fair rate option
	public void checkoutradioButton() {
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(checkoutradioButton));
		checkoutradioButton.click();
	}

	//clicking next
	public void nextButton() {
		executor.executeScript("arguments[0].scrollIntoView();", nextButton);
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		highlightElements.highlightElement(driver, nextButton);
		nextButton.click();
	}

	// placing the order
	public void placeorderButton() throws InterruptedException{
		executor.executeScript("arguments[0].scrollIntoView();", placeorderButton);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(placeorderButton));
		highlightElements.highlightElement(driver, placeorderButton);
		placeorderButton.click();
	}

	//clicking order number
	public void orderNumber() {
		highlightElements.highlightElement(driver, orderNumber);
		orderNumber.click();
	}

	// printing the order payment sheet
	public void printOrder() {
		executor.executeScript("arguments[0].scrollIntoView();", printOrder);
		printOrder.click();
	}

	// check URL
	public boolean shippingUrl() {
		return driver.getCurrentUrl().equals(shippingurl);
	}

	public boolean paymentUrl() {
		return driver.getCurrentUrl().equals(paymenturl);
	}
}
