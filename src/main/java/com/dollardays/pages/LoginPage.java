package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.commons.Base64;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space(.)='Sign in']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	@FindBy(xpath = "//a[normalize-space(.)='Sign In']")
	private WebElement dropdownsignIn;

	public WebElement getDropdownsignIn() {
		return dropdownsignIn;
	}

	@FindBy(xpath = "//*[@id='inputLoginUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = "//*[@id='inputLoginPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[normalize-space(.)='Sign in']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[3]/div/ul/li[1]/a")
	private WebElement userDrodown;

	public WebElement getUserDrodown() {
		return userDrodown;
	}	
	
	@FindBy(xpath = "//a[normalize-space(.)='Sign Out']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}	
	

	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
	//	getLoginBtn().click();
		Thread.sleep(1000);
		getPassword().submit();
		Thread.sleep(1000);
	}
	
	public void invokeLogin() throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		getUsername().sendKeys("srikanthtesting100@gmail.com");
		getPassword().sendKeys(Base64.decrypt("cGFzc3dvcmQxMjM="));
		getPassword().submit();
		Thread.sleep(1000);
		//getLoginBtn().click();
	}

}
