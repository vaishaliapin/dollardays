package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class InputValidationSearchbar {
	WebDriver driver;

	public InputValidationSearchbar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input")
	public WebElement search;

	public WebElement getSearchBar() {
		return search;
	}
	
	//@FindBy(xpath = "//*[@id=\"header-main\"]/div/div/div[2]/div[1]/div[1]/div/div/button/i")
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/div/div/button/i")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	@FindBy(xpath = "//*[@id='facetrefinements']/aside[1]/div/h3/span[@class='sku-count']")
	private WebElement searchCount;

	public WebElement getsearchCount() {
		return searchCount;
	}
	@FindBy(xpath = "//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;
		private WebElement getnoDataFoundMsg() {
			return noDataFoundMsg;
	}
		@FindAll(@FindBy(xpath = "//div[@class='select-bar pagination-bar']//a[contains(@class,'page-link')]"))

		private List<WebElement> pageCount;

		public List<WebElement> getPageCount() {
			return pageCount;
		}
		
	@FindBy(xpath = "//a[@title='Next Page']")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@FindBy(xpath = "//a[@title='Last Page']")
	private WebElement lastPageBtn;

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}
	
	@FindBy(xpath = "//a[@title='First Page']")
	private WebElement firstPageBtn;

	public WebElement getfirstPageBtn() {
		return firstPageBtn;
	}
	
	@FindBy(xpath = "//li[@class='active page-item']")
	private WebElement lastBtntext;

	public WebElement getLastBtntext() {
		return lastBtntext;
	}
	
	@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	@FindBy(xpath = "//h3[contains(text(),'CATEGORY')]")
	private WebElement CategoryCount;

	public WebElement getCategoryCount() {
	return CategoryCount;
	}
	
	public void searchwithValidProductName(String productName) {
		//valid product name 
		System.out.println("valid product name test");
		getSearchBar().sendKeys(productName);
		getSearchBtn().click();
	}
	
	public void searchwithInValidProductName(String productName) {
		//valid product name 
		System.out.println("Invalid product name test");
		getSearchBar().sendKeys(productName);
		getSearchBtn().click();
	}
	

	//ValidProductName with Case Sensetive
	public void searchwithUpperCaseProductName(String productName) {
		//valid product name 
		System.out.println("UpperCase product name test");
		getSearchBar().sendKeys(productName);
		getSearchBtn().click();
	}

	//ValidProductName with Special Character
	public void searchwithSpecialCharProductName(String productName) {
		//valid product name 
		System.out.println("Special Charater product name test");
		getSearchBar().sendKeys(productName);
		getSearchBtn().click();
	}

	//Blank ProductName
	public void searchwithBlankProductName() {
		//valid product name 
		System.out.println("Blank product name test");
		getSearchBar().sendKeys("");
		getSearchBtn().click();
	}

	//ProductName with SKU
	public void searchwithSKUProductName(String productName) {
		//valid product name 
		System.out.println("SKU product name test");
		getSearchBar().sendKeys(productName);
		getSearchBtn().click();
	}
	
	//ValidProductName with wild character

		public void searchwithWildCharProductName(String productName) {
			//valid product name 
			System.out.println("Wild Char product name test");
			getSearchBar().sendKeys(productName);
			getSearchBtn().click();
		}

		public String CategoryCountValue() throws InterruptedException {
			String Categorydetails = getCategoryCount().getText();
			int size = Categorydetails.length();
			String Cnt = Categorydetails.substring(10,size-9);
			return Cnt;

			}

public String getSearchWithValue() throws InterruptedException {
		
		String msg=null;
		String result = getnoDataFoundMsg().getText();
		System.out.println("-->"+result);
		
		if(result.contains("No Results Found")) {
			msg = getnoDataFoundMsg().getText();
			
		}else {
			msg = getsearchCount().getText();
		}
		
		return msg;
	}

	
	public void getItemCount() throws InterruptedException 
	{
		getLastPageBtn().click();
		Thread.sleep(1000);
		String valuecount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
    	int itemcount =0;
		for(int i=1;i<Integer.parseInt(valuecount);i++) {
		    getNextBtn().click();
			Thread.sleep(1000);
			System.out.println("Page "+ i + "  contains " + getPageItemsCount().size() + " rows");
			ExtentTestManager.getTest().log(Status.PASS, "Page Number "+ i + "  contains " + getPageItemsCount().size() + " rows");
		    itemcount=itemcount+getPageItemsCount().size();
			Thread.sleep(1000);
			if (i<= Integer.parseInt(valuecount)-1)
			{
			 getNextBtn().click();
			}
		}
		System.out.println("Total Number dispalyed items are:" +itemcount);

	}
	
	public int getTotalPageItemCount() throws InterruptedException {
		
		String pagecount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
        int  itemcount=0;
		for(int i=1;i<=Integer.parseInt(pagecount);i++) {
		   	Thread.sleep(3000);
			itemcount=itemcount+getPageItemsCount().size();
			Thread.sleep(3000);
			if (i<= Integer.parseInt(pagecount)-1)
			{
			 getNextBtn().click();
			}
		}
		return itemcount;
	}	
	}
	