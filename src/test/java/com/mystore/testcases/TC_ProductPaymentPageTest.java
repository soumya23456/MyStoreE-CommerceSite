package com.mystore.testcases;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LogoutPage;
import com.mystore.pageobject.OrderSuccessPage;
import com.mystore.pageobject.SearchProductPage;
import com.mystore.pageobject.SigninPage;

	public class TC_ProductPaymentPageTest extends BaseClass{
	
//	@Ignore
	@Test()
	public void VerifyUrltoSearchProduct() throws InterruptedException{
		
		logger.info("*************************VerifyProductSearchTest Starts**************************");
		logger.info("Verfiy product search test execution started...");
		logger.info(driver.getCurrentUrl());
		logger.info("Index page opened!");
	}
	
//	@Ignore
	@Test(priority = 1,dependsOnMethods = "VerifyUrltoSearchProduct")
	public void VerifyLogIn() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage indexPageLink = new IndexPage(driver, wait);
		indexPageLink.clickOnSignin();
		logger.info("login link clicked!");
	}	
		
//	@Ignore
	@Test(priority = 2,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn"})
	public void VerifyLogInOpen() throws InterruptedException{
	
		logger.info(driver.getCurrentUrl());
		logger.info("login page opened!");
	}
	
//	@Ignore
	@Test(priority = 3,dependsOnMethods = "VerifyLogIn")
	public void VerifySetEmail() throws InterruptedException{
	
		SigninPage signinPageLink = new SigninPage(driver);
		//type Input values
		signinPageLink.setEmail("tanjiro@kamado.com");
		logger.info("Entered email address");
	}	
	
//	@Ignore
	@Test(priority = 4,dependsOnMethods = "VerifyLogIn")
	public void VerifySetPwd() throws InterruptedException{
		
		SigninPage signinPageLink = new SigninPage(driver);
		signinPageLink.setpwd("Tanjiro@1216");
		logger.info("Entered password");
	}		
//	@Ignore
	@Test(priority = 5,dependsOnMethods = "VerifyLogIn")
	public void VerifyLogInSubmit() throws InterruptedException{

		SigninPage signinPageLink = new SigninPage(driver);
		//click submit button
		signinPageLink.clicklogInButton();
		logger.info("login submit button clicked!");
	}
	
//	@Ignore
	@Test(priority = 6,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit"})
	public void VerifySearchedEntry() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage indexPageLink = new IndexPage(driver, wait);
		String searchEntry = "Radient Tee";
		//Enter product name in search input
		indexPageLink.setSearchInputData(searchEntry + Keys.ENTER);
		logger.info("Entered product name in search input and clicked enter!");
	}

//	@Ignore
	@Test(priority = 7,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry"})
	public void VerifyRedirecttoProductItem() throws InterruptedException{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/catalogsearch/result/?q=Radient+Tee"));
		logger.info(driver.getCurrentUrl());
		logger.info("Redirected to searched product page!");
	}	
	
//	@Ignore
	@Test(priority = 8,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem"})
	public void VerifyAssertProdEntryandPage() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		String searchEntry = "Radient Tee";
		assertTrue(searchProductPage.searchValuePresent(searchEntry));
		logger.info("");
	}
	
//	@Ignore
	@Test(priority = 9,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage"})
	public void VerifyGetSearchedProd() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		String searchEntry = "Radient Tee";
		searchProductPage.getSearchedProduct();
		assertFalse(searchProductPage.searchedProductPresent(searchEntry));
		logger.info("searched product found!");
	}
	
//	@Ignore
	@Test(priority = 10,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd"})
	public void VerifyProdSize() throws InterruptedException{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.selectSize();
		logger.info("selected size of the product!");
	}
		
//	@Ignore
	@Test(priority = 11,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd"})
	public void VerifyProdColor() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.selectProductColor();
		logger.info("selected color of the product!");
	}
	
//	@Ignore
	@Test(priority = 12,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd"})
	public void VerifyaddtocartButton() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.clickProdAddtoCart();
		logger.info("Clicked add to cart button!");
	}
	
//	@Ignore
	@Test(priority = 13,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton"})
	public void VerifyProdAlertMsg() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		//success add to cart alert
		wait.until(d->searchProductPage.isProductAddedToCartAlertPresent());
		searchProductPage.isProductAddedToCartAlertPresent();
		logger.info("product cart alert message");
	}
	
//	@Ignore
	@Test(priority = 14,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg"})
	public void VerifyAddtoCartDropdown() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		//add to cart drop down
		searchProductPage.addtocartsectionLink();
		logger.info("clicked on add to cart dropdown");
	}
	
//	@Ignore
	@Test(priority = 15,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown"})
	public void VerifyProceedtoCheckout() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
		searchProductPage.clickProceedtoCheckoutButton();
		logger.info("clicked on proceed to check out");
	}
			
//	@Ignore//priority = 2
	@Test(priority = 16,dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown"})
	public void VerifyCheckShippingUrl() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/#shipping"));
		logger.info(driver. getCurrentUrl());
		logger.info("current shipping url checked");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl"})
	public void VerifyShippingOrder() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.shippingorderElement();
		logger.info("shipping order");
	}
		
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder"})
	public void VerifyClickNext() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.checkoutradioButton();
		Thread.sleep(2000);
		ordersuccessPage.nextButton();
		logger.info("clicked next step button");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext"})
	public void VerifycheckUrl() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Thread.sleep(2000);
		wait.until(d -> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/checkout/#payment"));
		logger.info("checked payment url");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl"})
	public void VerifyPlaceOrderButton() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.placeorderButton();
		logger.info("clicked place order button");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton"})
	public void VerifycheckoutSuccess() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Thread.sleep(2000);
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/onepage/success/"));
		logger.info("checked out successfully");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess"})
	public void VerifyClickOrderNumber() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.orderNumber();
		logger.info("clicked order number button");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess", "VerifyClickOrderNumber"})
	public void VerifyPrintOrder() throws InterruptedException{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.printOrder();
		Object[] currentWindowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window(currentWindowHandles[1].toString());
		logger.info("order printing");
	
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess", "VerifyClickOrderNumber", "VerifyPrintOrder"})
	public void VerifyCloseDriver() throws InterruptedException{
	
		driver.close();
		logger.info("closing driver");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess", "VerifyClickOrderNumber", "VerifyPrintOrder", "VerifyCloseDriver"})
	public void VerifyViewOrderId() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Object[] newWindowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window(newWindowHandles[0].toString());
		wait.until(d -> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sales/order/view/order_id/"));
		logger.info("check view order id details");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess", "VerifyClickOrderNumber", "VerifyPrintOrder", "VerifyCloseDriver", "VerifyViewOrderId"})
	public void VerifyDropdownLogout() throws InterruptedException{
		
		LogoutPage logout = new LogoutPage(driver);
		logout.logoutdropdownaccCreate();
		logger.info("log out drop down");
	}
	
//	@Ignore
	@Test(dependsOnMethods = {"VerifyUrltoSearchProduct", "VerifyLogIn", "VerifySetEmail", "VerifySetPwd", "VerifyLogInSubmit", "VerifySearchedEntry", "VerifyRedirecttoProductItem", "VerifyAssertProdEntryandPage", "VerifyGetSearchedProd", "VerifyProdSize", "VerifyProdColor", "VerifyaddtocartButton", "VerifyProdAlertMsg", "VerifyAddtoCartDropdown", "VerifyProceedtoCheckout", "VerifyCheckShippingUrl", "VerifyShippingOrder", "VerifyClickNext", "VerifycheckUrl", "VerifyPlaceOrderButton", "VerifycheckoutSuccess", "VerifyClickOrderNumber", "VerifyPrintOrder", "VerifyCloseDriver", "VerifyViewOrderId", "VerifyDropdownLogout"})
	public void VerifylogoutButton() throws InterruptedException{
		
		LogoutPage logout = new LogoutPage(driver);
		logout.logoutbutton();
		logger.info("logged out");
	}
	
	}

