package com.mystore.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mystore.pageobject.*;


public class TC_SigninPageTest extends BaseClass{

//	@Ignore
	@Test
	public void VerifySignIn() throws IOException, InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(8));
			IndexPage pglink = new IndexPage(driver, wait);
			SigninPage signin = new SigninPage(driver);
			CustomerAccount accCreate = new CustomerAccount(driver);
			LogoutPage logout = new LogoutPage(driver);
			//opened sign in URL
			pglink.clickOnSignin();
			wait.until(d -> signin.signinUrl());
			
			signin.setEmail("tanjiro@kamado.com");
			logger.info("entered signin email");
			signin.setpwd("Tanjiro@1216");
			logger.info("entered signin password");
			signin.clicklogInButton();
			logger.info("clicked signin");
			
			wait.until(d -> pglink.isUrl());
		  	String userName = accCreate.customerName();
		  	Thread.sleep(2000);
		  	
			if(userName.contains("tanjiro kamado"))
			{
				
				logger.info("Verifylogin - passed");
				logout.logoutdropdown();
				logger.info("account dropdown opened");				
				logout.logoutbutton();
				logger.info("logout clicked");
			}
			else
			{
				logger.info("Verifylogin - failed");
				captureScreenShot(driver, "Verifylogin");
				
			}
		
	}
}
