package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	ElementUtils eUtil;
	
	public ProductPage(WebDriver driver) {
		eUtil = new ElementUtils(driver);
		
	}
	private By macbookAirpart = By.linkText("MacBook Air");
	private By nextPage = By.xpath("//div[@class='btn-group']/..//h1");
	private By cartBtn = By.id("button-cart");
	//private By alertMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']//a[2][text() = 'shopping cart']");
	private By alertMessage1 =By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By productInfo = By.xpath("(//div[@id=\"content\"]//ul[@class=\"list-unstyled\"])[1]//li");
	Map<String,String> productInfoMap;
	
	
	
	public Boolean clickProductName() {
		String text = null;
		eUtil.getElementClick(macbookAirpart);
		if(eUtil.getElementIsDisplayed(nextPage)) {
		text = eUtil.getElement(nextPage).getText();
		}
		
		return text.contains("MacBook Air");
	}
	
	public Map<String, String> getproductinfo() {
		productInfoMap = new HashMap<String,String>();
		getListProductInfoData();
		System.out.println(productInfoMap);
		return productInfoMap;
	}
	
	public void getListProductInfoData() {
		
		List<WebElement> productInfoList = eUtil.getListData(productInfo);
		for(WebElement e:productInfoList) {
			String text = e.getText();
			String textSplit[] = text.split(":");
			String key = textSplit[0].trim();
			String value = textSplit[1].trim();
			productInfoMap.put(key, value);
			//System.out.println("text value of product page " +text);
		}
		//eUtil.getListData
	}
	public Boolean clickOnCart() {
		clickProductName();
		
		eUtil.getElementClick(cartBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String text = eUtil.getElement(alertMessage1).getText();
		System.out.println("text after success" +text);
		
		return text.contains("Success: You have added ");
		
	}
	
	//Success: You have added MacBook Air to your shopping cart!
}
