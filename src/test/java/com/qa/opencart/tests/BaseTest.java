package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driverFactory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.ElementUtils;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
	 WebDriver driver;
	 DriverFactory df;
	 LoginPage lp;
	 AccountPage aP;
	 ElementUtils eUtil;
	Properties prop;
	RegistrationPage registrationPage;
	ProductPage productpage;
	HomePage homepage;
	//ExcelUtil exUtil;
	
	@BeforeTest
	public void getStarted() {
		df = new DriverFactory();
		//df.init_driver();
		prop = df.init_prop();		
		
		
		driver = df.init_driver(prop);	
		lp = new LoginPage(driver);
		
	}
//	@BeforeMethod
//	public void getMethodStarted() {
//		df = new DriverFactory();
//		//df.init_driver();
//		prop = df.init_prop();		
//		
//		
//		driver = df.init_driver(prop);	
//		lp = new LoginPage(driver);
//		aP = lp.checkSearchFunctionality();
//	}
//	
//	@AfterMethod
//	public void tearDownBrowser() {
//		driver.close();
//	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
