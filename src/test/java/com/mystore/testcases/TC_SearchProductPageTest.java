package com.mystore.testcases;

import static org.testng.Assert.*;

import java.time.Duration;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchProductPage;
import com.mystore.pageobject.SigninPage;

public class TC_SearchProductPageTest extends BaseClass {
	
	@Test
	public void VerifyUrlOpen() throws InterruptedException {

		logger.info("*************************VerifyProductSearchTest Starts**************************");

		logger.info("Verfiy product search test execution started...");
		logger.info(driver.getCurrentUrl());
		logger.info("URL opened!");
	}


	@Test
	public void VerifyLogin() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage indexPageLink = new IndexPage(driver, wait);
		indexPageLink.clickOnSignin();
		logger.info("login link clicked!");
	}


	@Test(dependsOnMethods = "VerifyLogin")
	public void VerifyNavigatetoLogin() throws InterruptedException {
		
		// navigated to login page
		
		logger.info("Navigating to login page!");
	}


	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin"})
	public void VerifyLoginPageOpen() throws InterruptedException {
		
		logger.info(driver.getCurrentUrl());
		logger.info("login page opened!");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen"})
	public void VerifyEmailLoggingIn() throws InterruptedException{

		SigninPage signinPageLink = new SigninPage(driver);
		// type Input values
		signinPageLink.setEmail("tanjiro@kamado.com");
		logger.info("Entered email address");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen"})
	public void VerifyPwdLoggingIn() throws InterruptedException{
	
		SigninPage signinPageLink = new SigninPage(driver);
		signinPageLink.setpwd("Tanjiro@1216");
		logger.info("Entered password");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen"})
	public void VerifySignInButtonLoggingIn() throws InterruptedException{
		
		SigninPage signinPageLink = new SigninPage(driver);
		// click submit button
		signinPageLink.clicklogInButton();
		logger.info("login submit button clicked!");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn"})
	public void VerifySearchEntry() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage indexPageLink = new IndexPage(driver, wait);
		String searchEntry = "Radient Tee";
		// Enter product name in search input
		indexPageLink.setSearchInputData(searchEntry + Keys.ENTER);
		logger.info("Entered product name in search input and clicked enter!");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry"})
	public void VerifyRedirectSearch() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		String searchtexturl = "https://magento.softwaretestingboard.com/catalogsearch/result/?q=Radient+Tee";
		System.out.println(driver.getCurrentUrl());
		wait.until(d -> driver.getCurrentUrl().equals(searchtexturl));
		logger.info("Redirected to searched product page!");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry"})
	public void VerifyAssertSearchEntry() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		String searchEntry = "Radient Tee";
		assertTrue(searchProductPage.searchValuePresent(searchEntry));
		logger.info("asserting TRUE Redirected searched product and searched entry ");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry"})
	public void VerifySearchProductFound() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		String searchEntry = "Radient Tee";
		searchProductPage.getSearchedProduct();
		assertFalse(searchProductPage.searchedProductPresent(searchEntry));
		logger.info("searched product found!");
	}

	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry"})
	public void VerifySearchedProductLink() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/catalogsearch/result/?q=Radient+Tee"));
		logger.info(driver.getCurrentUrl());
		logger.info("checking searched product link ");
	}

	@Test()
	public void VerifySizeofProductPage() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.selectSize();
		logger.info("selected size of the product!");
	}

	@Test()
	public void VerifyColorofProduct() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.selectProductColor();
		logger.info("selected color of the product!");
	}

	@Test()
	public void VerifyProdAddtoCart() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.clickProdAddtoCart();
		logger.info("Clicked add to cart button!");
	}

	@Test()
	public void VerifyProdAddedToCartAlertPresent() throws InterruptedException{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		// success add to cart alert
		wait.until(d -> searchProductPage.isProductAddedToCartAlertPresent());
		Thread.sleep(4000);
		searchProductPage.isProductAddedToCartAlertPresent();
		logger.info("product cart alert message");
	}
		
//	@Ignore
//	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry", "VerifySearchedProductLink", "VerifyProdAddedToCartAlertPresent"})
//	public void VerifyProdaddtocartsectionLink() throws InterruptedException{
//	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
//		//add to cart drop down
//		searchProductPage.addtocartsectionLink();
//		logger.info("clicked on add to cart dropdown");
//	}
//
////	wait.until(d->driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/cart/"));
//			
//	@Ignore
//	@Test(dependsOnMethods = {"VerifyLogin", "VerifyNavigatetoLogin","VerifyLoginPageOpen", "VerifySignInButtonLoggingIn", "VerifySearchEntry", "VerifySearchedProductLink", "VerifyProdaddtocartsectionLink"})
//	public void VerifyProceedtoCheckout() throws InterruptedException{
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
//		Thread.sleep(4000);
//		searchProductPage.clickProceedtoCheckout();
//		logger.info("clicked on proceed to check out");
//
////		wait.until(d->driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/#shipping"));
////		logger.info("Product checked out");
////		logger.info("*************************search product success**************************");
//	}
	}



