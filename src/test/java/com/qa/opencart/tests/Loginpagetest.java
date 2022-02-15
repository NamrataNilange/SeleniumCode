package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Loginpagetest extends BaseTest {
	// WebDriver driver;
	
	
	
	
	@Test
	public void testdata() throws InterruptedException {
		
		
			lp.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
			Assert.assertTrue(lp.validatePageLogin());
		
//		 Assert.assertTrue(lp.isRegisterLinkExist());
//		 System.out.println("In loginpagetest  class"  + driver);		
		
		
	}
	

}
