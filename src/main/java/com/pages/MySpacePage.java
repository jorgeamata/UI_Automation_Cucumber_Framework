package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MySpacePage {
	
	private WebDriver driver;
	
	//1. By locators
	private By accountSections = By.cssSelector("section#content div");
	
	//2. Constructor
	public MySpacePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page actions
	
	public String getMySpacePageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountSectionsCount() {
		return driver.findElements(accountSections).size() - 1;
	}
	
	public List<String> getAccountSectionsList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountElements = driver.findElements(accountSections);
		
		for(WebElement e : accountElements) {
			String text = e.getText();
			System.out.println(text);
			
			accountList.add(text);
		}
		
		return accountList;
		
		
		
	}
	
}
