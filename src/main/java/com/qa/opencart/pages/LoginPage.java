package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Story("Story ID: 1001 Loginpage class")
public class LoginPage {

	 WebDriver driver;
	 ElementUtils eleUtil;
	 //DriverFactory df;
	
	
	public LoginPage(WebDriver driver) {
		//df.init_driver();
		this.driver = driver;		
		eleUtil = new ElementUtils(driver);
	}
	
	private By emailid = By.name("email");
	private By pass = By.name("password");
	private By btn = By.xpath("//input[@type = 'submit']");
	private By registerLink = By.linkText("Register");
	private String username = "naveenanimation20@gmail.com";
	private String password = "Selenium12345";
	
	
	@Step("First method to login in with username:{0} and password:{1}")
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
	
	public AccountPage checkSearchFunctionality() {
		loginMethod( username, password);
		return new AccountPage(driver);
	}
	
	public HomePage homePageMethod() {
		eleUtil.getElementdata(emailid,username);	
		eleUtil.getElementdata(pass,password);
		eleUtil.getElementClick(btn);
		return new HomePage(driver);
	}
	
	
}
