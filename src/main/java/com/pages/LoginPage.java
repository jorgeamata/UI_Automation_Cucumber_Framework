package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By locators
	private By emailId = By.name("ctl00$MainContent$txtUsuario");
	private By password = By.name("ctl00$MainContent$txtPassword");
	private By signInButton = By.name("ctl00$MainContent$btnIngresar");
	private By forgotPwdLink = By.xpath("//a[contains(text(),'Olvidaste')]");
	
	//2. Constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkPresent() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public MySpacePage signIn(String user, String pwd) {
		System.out.println("Login with " + user + pwd);
		
		driver.findElement(emailId).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		/*
		enterUserName(userName);
		enterPassword(password);
		clickOnLogin();
		*/
		
		return new MySpacePage(driver);
	}

}
