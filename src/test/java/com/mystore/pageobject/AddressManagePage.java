package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.testcases.BaseClass;
import com.mystore.utilities.HighLightElements;

public class AddressManagePage extends BaseClass{
	
	WebDriver driver;
//	RemoteWebDriver driver;
	HighLightElements highlightElements = new HighLightElements();
			
		// identify webelements
	
		@FindBy(id = "id_gender2") //Title-Mrs
		WebElement titleMrs;

		@FindBy(id = "id_gender1") //Title-Mrs
		WebElement titleMr;
		
		@FindBy(xpath = "//*[@id=\"firstname\"]")
		WebElement fName;
	
		@FindBy(xpath = "//*[@id=\"lastname\"]")
		WebElement lName;
		
//		@FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[1]/div[4]/div")
//		WebElement PhoneNumber;
		
		@FindBy(id="phone_mobile")
		WebElement PhoneNumber;
	
//		@FindBy(xpath = "//*[@id=\"street_1\"]")
//		WebElement Street;
		
		@FindBy(xpath = "street")
		WebElement Street;
		
//		@FindBy(xpath = "//*[@id=\"form-validate\"]/fieldset[2]/div[2]/div")
//		WebElement City;
		
		@FindBy(id="city")
		WebElement City;

		@FindBy(id="id_state")
		WebElement State;
		
//		@FindBy(xpath = "//*[@id=\"region_id\"]/option[4]")
//		WebElement State;

//		@FindBy(xpath = "//*[@id=\"zip\"]")
//		WebElement PostalCode;
		
		@FindBy(id="postcode")
		WebElement PostalCode;
		
//		@FindBy(xpath = "//*[@id=\"country\"]/option[236]")
//		WebElement Country;
		
		@FindBy(id="id_country")
		WebElement Country;
		
//		@FindBy(xpath = "Create an Account")
//		WebElement Paymentway;
		
//		@FindBy(xpath = "Create an Account")
//		WebElement ClickNext;
				
//		@FindBy(xpath = "Create an Account")
//		WebElement ClickPlaceOrder;
			
		@FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
		WebElement SaveAddressButton;
		
				
		String AccCreateUrl = "https://magento.softwaretestingboard.com/customer/account/create/";		
		String checkoutAddressUrl = "https://magento.softwaretestingboard.com/checkout/#shipping";
		String PaymentUrl = "https://magento.softwaretestingboard.com/checkout/#payment";
		String OrderSuccessUrl = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
		String IndexUrl = "https://magento.softwaretestingboard.com/"; 
	
	// constructor
//		public AddressManagePage(RemoteWebDriver driver) {
//			
//			this.driver = driver;
//			PageFactory.initElements(driver, this);
//		}
		
		public AddressManagePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    }
		
//		public void setFName(String fname) {
//			highlightElements.highlightElement(driver, fname);
////			fname.sendKeys(fname);
//		}
//		
//		//set inputs
//		public void setLName(String lname) {
//			highlightElements.highlightElement(driver, lname);
//			lname.sendKeys(lname);
//		}
		
		public void setNumber(String number) {
			
			highlightElements.highlightElement(driver, PhoneNumber);
			PhoneNumber.sendKeys(number);
		}
		
		//alias
		@FindBy(id="alias")
		WebElement alias;
		
		public void selectTitleMrs(){
			
			titleMrs.click();
		}

		public void selectTitleMr(){
			
			titleMr.click();
		}
		
		public void setStreet(String street) {
			
			highlightElements.highlightElement(driver, Street);
			Street.sendKeys(street);
		}
		
		public void selectCity(String city) {
			
			highlightElements.highlightElement(driver, City);
			City.sendKeys(city);
		}
		
		public void setState(String state) {
			
			highlightElements.highlightElement(driver, State);
			State.sendKeys(state);
		}
		
		public void selectState(String text)
		{
			Select obj = new Select(State);
			obj.selectByVisibleText(text);
		}
		
		public void setpostalCode(String postalcode) 
		{	
			highlightElements.highlightElement(driver, PostalCode);
			PostalCode.sendKeys(postalcode);
		}
		
		public void setCountry(String country) 
		{	
			highlightElements.highlightElement(driver, Country);
			Country.sendKeys(country);
		}
		
		public void selectCountry(String text)
		{
			Select obj = new Select(Country);
			obj.selectByVisibleText(text);
		}
		
		public void clicksaveAddress() 
		{
			SaveAddressButton.click();
		}
		
		public boolean isUrl() {
			return driver.getCurrentUrl().equals(IndexUrl);
		}
		
		public boolean AccCreateUrl() 
		{
			return driver.getCurrentUrl().equals(AccCreateUrl);
		}
		
		public boolean PaymentUrl() {
			return driver.getCurrentUrl().equals(PaymentUrl);
		}
		
		public boolean OrderSuccessUrl() {
			return driver.getCurrentUrl().equals(OrderSuccessUrl);
		}
}
