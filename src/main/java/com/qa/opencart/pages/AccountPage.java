package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;
	ElementUtils etUtils;
	
	
	public AccountPage(WebDriver driver){
		this.driver = driver;
		etUtils = new ElementUtils(driver);
		
	}
	
	private By searchInput = By.name("search");
	//private By searchBtn = By.classNames("btn btn-default btn-lg");
	private By searchButton = By.cssSelector("div#search button");
	
	public void doSearch() {
		etUtils.getElement(searchInput).sendKeys("Macbook");		
	}
	
	public Boolean doPressBtn() {
		doSearch();
		
		etUtils.getElementClick(searchButton);
		String titleOfSearchProduct = etUtils.getTitleOfPage();
		System.out.println(titleOfSearchProduct);
		return titleOfSearchProduct.contains("Search - Macbook");
	}
	public ProductPage goToProductPage() {
		doPressBtn();
		return new ProductPage(driver);
	}
	public void clearTheInputTextArea() {
		etUtils.clearTheInputText(searchInput);
	}
}
