package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.driverFactory.DriverFactory;

public class LoginPage {

	 WebDriver driver;
	 ElementUtils eleUtil;
	 DriverFactory df;
	
	
	public LoginPage(WebDriver driver) {
		//df.init_driver();
		this.driver = driver;		
		eleUtil = new ElementUtils(driver);
	}
	
	private By emailid = By.name("email");
	private By pass = By.name("password");
	private By btn = By.xpath("//input[@type = 'submit']");
	private By registerLink = By.linkText("Register");
	
	public void loginMethod(String userName,String password) {
		eleUtil.getElementdata(emailid,userName);	
		eleUtil.getElementdata(pass,password);
		eleUtil.getElementClick(btn);
		
		
	}
	public boolean getElement() {
		return eleUtil.getElementIsDisplayed(btn);
	}
	public boolean isRegisterLinkExist() throws InterruptedException {
		
		Thread.sleep(5000);
		return eleUtil.doIsDisplayed(registerLink);
	}
	public boolean validatePageLogin() {
		return eleUtil.getTitleOfPage().contains("My Account");
	}
	
	public RegistrationPage checkRegistration() {
		eleUtil.getElement(registerLink).click();
		return new RegistrationPage(driver);
	}
}
