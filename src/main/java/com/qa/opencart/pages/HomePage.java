package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	ElementUtils eUtil;
	public HomePage(WebDriver diver) {
		eUtil = new ElementUtils(diver);
	}
	
	private By homeIcon = By.xpath("//div[@id=\"account-account\"]/ul/li/a/i[@class=\"fa fa-home\"]");
	private By removeCartItem = By.id("cart");
	private By viewCartPage = By.xpath("//p[@class=\"text-right\"]/a/strong/i[@class=\"fa fa-shopping-cart\"]");
	private By removeItem = By.xpath("//button[@title=\"Remove\"]");
	private By textAfterRemoval = By.xpath("//ul[@class=\"dropdown-menu pull-right\"]/li/p");
	private By inputTextArea = By.xpath("//input[@type=\"text\" and @size=\"1\"]");
	private By refreshButton = By.xpath("//button[@data-original-title=\"Update\"]");
	////div[@id="carousel0"]//div[contains(@class , 'swiper-slide text-center'),@data-swiper-slide-index="0"]
	//private By icons = By.xpath("//div[@id=\"carousel0\"]//div[@class='swiper-slide text-center swiper-slide-active']/self::div | //div[@id=\"carousel0\"]//div[@class='swiper-slide text-center swiper-slide-active']/following-sibling::div//img");
	private By featuresList = By.xpath("//div[@id=\"content\"]/div[2]/div/div/div[@class=\"image\"]/a/img");
	private By successText = By.xpath("//i[@class=\"fa fa-check-circle\"]");
	
	public void clickHomeIcon() {
		eUtil.getElementClick(homeIcon);
	}
	
	public void getImageNames() {
		List<WebElement> homeIcons = eUtil.getListData(homeIcon);
		for(WebElement e:homeIcons) {
			String attributeName = e.getAttribute("alt");
			System.out.println(attributeName);
		}
	}	
	public int getFeatureList() {
		List<WebElement> featureListData = eUtil.getListData(featuresList);
		ArrayList<String> str = new ArrayList<String>();
		int i;
		for(WebElement e: featureListData) {
			String text = e.getAttribute("alt");
			str.add(text);	
			}
		System.out.println(str);
		return  i= str.size();
		
	}
	public void removeItemFromCart() {
		eUtil.getElementClick(removeCartItem);
	}
	public void viewCartPage() {
		removeItemFromCart();
		eUtil.getElementClick(viewCartPage);
		eUtil.getElement(refreshButton);
		
		
	}
	public void removeItem() {
		removeItemFromCart();
		eUtil.getElementClick(removeItem);
	}
	
	public void getTextAfterItemRemoval() {
		removeItemFromCart();
		String text = eUtil.getText(textAfterRemoval);
		System.out.println("text after removal of item " +text);
		
	}
	public void checkInputTextBox() {
		viewCartPage();
		eUtil.getElementdata(inputTextArea, "3");
		String text = eUtil.getText(successText);
		System.out.println(text);
	}
}
