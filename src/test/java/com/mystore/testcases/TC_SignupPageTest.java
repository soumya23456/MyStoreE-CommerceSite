package com.mystore.testcases;

import com.mystore.pageobject.SignupPage;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.mystore.pageobject.CustomerAccount;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LogoutPage;

public class TC_SignupPageTest extends BaseClass{

	@Ignore
	@Test
	public void verifysignupAccount() //changed verifysignInAndsignOut() ==verifysignupAccount/verifyNewAcc/verifylogOut
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		IndexPage indexPagelink = new IndexPage(driver, wait);
		SignupPage signup = new SignupPage(driver);

		indexPagelink.clickOnSignup();
		logger.info("clicked on signup link");
				
		signup.setFName("tanjiro");
		logger.info("entered first name");
	
		signup.setLName("kamado");
		logger.info("entered last name");
		
		signup.setEmail("tanjiro@kamado.com");
		logger.info("entered email");
		
		signup.setpwd("Tanjiro@1216");
		logger.info("entered password");
		
		signup.setrepwd("Tanjiro@1216");
		logger.info("entered confirm password");
		
		// get sign up elements
		System.out.println(signup.getFNameInput());
		System.out.println(signup.getLNameInput());
		System.out.println(signup.getEmailInput());
		System.out.println(signup.getpwdInput());
		
		signup.clickSubmitCreate();
		logger.info("clicked signup button");
	}
	
	@Ignore
	@Test(dependsOnMethods = "verifysignupAccount")
	public void verifyNewAcc() 
	{
		
		CustomerAccount accCreate = new CustomerAccount(driver);
		
//		wait.until(d-> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/"));
		//customer account created
		accCreate.customerName();
		logger.info("customer name");
	}
	
	@Ignore
	@Test(dependsOnMethods = {"verifysignupAccount", "verifyNewAcc"})
	public void verifylogOut() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(d-> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/"));
		LogoutPage logout = new LogoutPage(driver);
		//log out customer account
		logout.logoutdropdown();
		logger.info("clicked dropdown button");
		logout.logoutbuttonaccCreate();
		logger.info("clicked logout button");
		
//		accCreate.manageAddress();
//		logger.info("clicked managed address");
		
		
//		//add address
//		accCreate.addressUrl();
//		logger.info("addressUrl checked");
////		softassert.assertEquals(signup.getFNameInput());
////		softassert.assertTrue(signup.getLNameInput());
//		addAddress.setNumber("9573346019");
//		logger.info("entered number");
//		addAddress.setStreet("hyd");
//		logger.info("entered street");
//		addAddress.setState("American Samao");
//		logger.info("entered state");
//		addAddress.selectState("American Samao");
//		logger.info("selected state");
//		addAddress.setpostalCode("96799");
//		logger.info("entered postal code");
//		addAddress.setCountry("United States");
//		logger.info("entered country");
//		addAddress.selectCity("United States");
//		logger.info("selected country");
//		addAddress.clicksaveAddress();
//		logger.info("clicked save address");
		
	}

}

