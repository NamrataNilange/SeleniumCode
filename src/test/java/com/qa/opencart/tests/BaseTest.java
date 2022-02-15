package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driverFactory.DriverFactory;
import com.qa.opencart.pages.ElementUtils;
import com.qa.opencart.pages.ExcelUtil;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
	 WebDriver driver;
	 DriverFactory df;
	 LoginPage lp;
	 ElementUtils eUtil;
	Properties prop;
	RegistrationPage registrationPage;
	//ExcelUtil exUtil;
	
	@BeforeTest
	public void getStarted() {
		df = new DriverFactory();
		//df.init_driver();
		prop = df.init_prop();		
		
		
		driver = df.init_driver(prop);	
		lp = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
