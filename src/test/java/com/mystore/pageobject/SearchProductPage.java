package com.mystore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.testcases.BaseClass;
import com.mystore.utilities.HighLightElements;

public class SearchProductPage extends BaseClass{

	// create object of webDriver
//		RemoteWebDriver driver;
		WebDriver driver;
		WebDriverWait wait;
		Actions action;
		JavascriptExecutor executor;
		HighLightElements highlightElements = new HighLightElements();
		
		@FindBy(xpath = "//span[contains(@class,'base')]")
		WebElement searchResult;
		
		@FindBy(xpath = "(//li[contains(@class,'product-item')])[3]")
		WebElement searchedProduct;
		
		@FindBy(linkText = "Radiant Tee")
		WebElement searchedProductName;
		
		@FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[3]/div[1]/div/div[1]")
		WebElement productSize;
		
		@FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[3]/div[2]/div/div[2]")
		WebElement productColor;
		
		@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[3]/div/div/div[4]/div/div[1]/form/button")
		WebElement prodAddtoCart;
		
		@FindBy(xpath = "//div[contains(@role,'alert')]")
		WebElement successCartMsg;
		
		@FindBy(xpath = "//a[contains(@class,'showcart')]")
		WebElement cartButton;
		
		@FindBy(xpath = "//span[contains(@class,'counter-number')]") 
		WebElement cartCount;
		
		@FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
		WebElement proceedtoCheckout;
		
		@FindBy(xpath = "//*[@id=\"top-cart-btn-checkout\"]")
		WebElement proceedtoCheckoutButton;

		static String CartUrl = "https://magento.softwaretestingboard.com/checkout/cart/";
		static String searchUrl = "https://magento.softwaretestingboard.com/"; 
		static String shippingUrl = "https://magento.softwaretestingboard.com/checkout/#shipping";
		
		// constructor
//				public SearchProductPage(RemoteWebDriver driver, WebDriverWait wait) {
//					this.driver = driver;
//					this.wait = wait;
//					this.action = new Actions(driver);
//					this.executor = (JavascriptExecutor) driver;
//					PageFactory.initElements(driver, this);
//				}
				
				public SearchProductPage(WebDriver driver, WebDriverWait wait) {
					this.driver = driver;
					this.wait = wait;
					this.action = new Actions(driver);
					this.executor = (JavascriptExecutor) driver;
					PageFactory.initElements(driver, this);
				}

		//check search value present in search heading
		public boolean searchValuePresent(String search) {
			highlightElements.highlightElement(driver, searchResult);
			return searchResult.getText().contains(search);
		}
		
		//move to searched product item
		public void getSearchedProduct() {
			executor.executeScript("arguments[0].scrollIntoView();", searchedProduct);
			wait.until(d -> searchedProduct.isDisplayed());
			highlightElements.highlightElement(driver, searchedProduct);
			action.moveToElement(searchedProduct).build().perform();
			action.moveToElement(searchedProduct).build().perform();		
			action.moveToElement(searchedProduct).build().perform();
		}
		
		//check product name is same as search entry
		public boolean searchedProductPresent(String search) {
			highlightElements.highlightElement(driver, searchedProductName);
			System.out.println(searchedProductName.getText());
			return searchedProductName.getText().contains(search);
		}
		
		//Select xl size for product
		public void selectSize() {
			highlightElements.highlightElement(driver, productSize);
			productSize.click();
		}
		
		//Select orange product color
		public void selectProductColor() {
			highlightElements.highlightElement(driver, productColor);
			productColor.click();
		}
		
		//click add to cart button
		public void clickProdAddtoCart() {
			highlightElements.highlightElement(driver, prodAddtoCart);
			prodAddtoCart.click();
		}	

		//check alert message if product is successfully added to cart 
		public boolean isProductAddedToCartAlertPresent() {
			executor.executeScript("arguments[0].scrollIntoView();", successCartMsg);
			wait.until(d->successCartMsg.isDisplayed());
			highlightElements.highlightElement(driver, successCartMsg);
			return successCartMsg.isDisplayed();
		}
		
		//check cart count is updated 
		public void addtocartsectionLink() {	
			
			highlightElements.highlightElement(driver, cartButton);
			cartButton.click();
		}
		
		//check cart count is updated 
		public void clickProceedtoCheckout() {
			executor.executeScript("arguments[0].scrollIntoView();", proceedtoCheckout);
			wait.until(ExpectedConditions.elementToBeClickable(proceedtoCheckout));
			highlightElements.highlightElement(driver, proceedtoCheckout);
			proceedtoCheckout.click();
		}
		
		public void clickProceedtoCheckoutButton() {
			executor.executeScript("arguments[0].scrollIntoView();", proceedtoCheckoutButton);
			wait.until(ExpectedConditions.elementToBeClickable(proceedtoCheckoutButton));
			highlightElements.highlightElement(driver, proceedtoCheckoutButton);
			proceedtoCheckoutButton.click();
		}
		
	//check URL
		public boolean isUrl() {
			return driver.getCurrentUrl().equals(searchUrl);
		}
		
		public boolean cartUrl() {
			return driver.getCurrentUrl().equals(CartUrl);
		}
		
		public boolean shippingUrl() {
			return driver.getCurrentUrl().equals(shippingUrl);
		}

		
}
