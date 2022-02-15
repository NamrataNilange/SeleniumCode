package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	private ElementUtils eleUtil; 
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMsg = By.xpath("//div[@id = 'content']/h1");
	private By logOut = By.linkText("Logout");
	private By registerLink = By.linkText("Register");


	
	
	
	
	public RegistrationPage(WebDriver driver) {
		eleUtil = new ElementUtils(driver);
	}
	
	public Boolean doRegistration(String firstName,String lastName,String email,String telephone,String password,String subscribe)  {
		//Thread.sleep(5000);
		eleUtil.getElementdata(this.firstName, firstName);
		eleUtil.getElementdata(this.lastName, lastName);
		eleUtil.getElementdata(this.email, email);
		eleUtil.getElementdata(this.telephone, telephone);

		eleUtil.getElementdata(this.password, password);
		eleUtil.getElementdata(this.confirmpassword, password);
		
		if(subscribe.equals("yes")) {
			eleUtil.getElement(subscribeYes).click();
		}else
		{
			eleUtil.getElement(subscribeNo).click();
		}
		
		eleUtil.getElement(agreeCheckBox).click();
		eleUtil.getElement(continueButton).click();
		
		String text = eleUtil.getElement(successMsg).getText();
		if(text.equals(Constants.SUCCESS_MESSAGE)) {
			eleUtil.getElement(logOut).click();
			eleUtil.getElement(registerLink).click();
			return true;
		}
		return false;
	}
}
