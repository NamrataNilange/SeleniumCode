package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	 WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;		
	}
//	public void getDriver(WebDriver driver) {
//		this.driver = driver;
//	}
	
	public WebElement getElement(By locator) {
		//getDriver(driver);
		WebElement element = driver.findElement(locator);
		return element;
		
	}
	public void getElementdata(By locator,String value) {
		getElement(locator);
		driver.findElement(locator).sendKeys(value);
		
		
	}
	public List<WebElement> getListData(By Locator) {
		//driver.manage(
		return driver.findElements(Locator);
	}
	
//	clear the input area
	public void clearTheInputText(By locator) {
		driver.findElement(locator).clear();
	}
/*****alert util class ****/
	public  void getData(List<WebElement> elements,WebDriver driver) throws InterruptedException  {
		//getDriver(driver);
		for(WebElement e : elements)
		{
			String text = e.getText();
			if(text.equalsIgnoreCase("edit")) {
				e.click();				
				break;
			}		
		}
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertext = alert.getText();
		System.out.println(alertext);
		if(alertext.equals("clicked: edit")) {
			alert.accept();
		}
		
		
	}
	public void getalert() {
		//getDriver(driver);
		//Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alertext = alert.getText();
		System.out.println(alertext);
		if(alertext.equals("clicked: edit")) {
			alert.accept();
		}
	}
	
	public boolean getElementIsDisplayed(By btn) {
		// TODO Auto-generated method stub
		return getElement(btn).isDisplayed();
//		driver.findElement(btn).click();
//		getElement(btn)
//		return false;
		
	}

	public void getElementClick(By btn) {
		// TODO Auto-generated method stub
		boolean flag = getElementIsDisplayed(btn);
		if(flag == true) {
		driver.findElement(btn).click();
		}
	}
		
	public boolean doIsDisplayed(By locator) {
		
		   // getDriver(driver);
			return getElement(locator).isDisplayed();
		}
	
	public String getTitleOfPage() {
		return driver.getTitle();
				
			}
		
		
	

}
