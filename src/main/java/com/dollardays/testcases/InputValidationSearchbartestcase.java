
package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.InputValidationSearchbar;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class InputValidationSearchbartestcase extends BaseTest{
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_01_searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
	
		InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		searchpage.getSearchBar().clear();
		//searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : get search bar and clean");
		Thread.sleep(1500);

		searchpage.searchwithValidProductName(datatable.get("Product Name"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with valid product name in the search bar");
		Thread.sleep(1500);
		
		searchpage.getSearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(1500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+ categoryCount +"'");
		
		Thread.sleep(1500);
		loginPage.getUserDrodown().click();
		Thread.sleep(1500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC2", runmode = "No")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_02_searchwithInValidProductName(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
	
		InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
	//	searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
		//ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
		searchpage.getSearchBar().clear();

		searchpage.searchwithInValidProductName(datatable.get("Product Name"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with Invalid product name in the search bar");
		
		searchpage.getSearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_03_searchwithUpperCaseProductName(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			
			ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
			LoginPage loginPage = new LoginPage(driver);
			ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			Thread.sleep(1000);
		
			InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
			WebDriverWait wait = new WebDriverWait(driver,30);
			//searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
			//ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
			searchpage.getSearchBar().clear();

			searchpage.searchwithUpperCaseProductName(datatable.get("Product Name"));
			ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with UpperCase product name in the search bar");
			
			searchpage.getSearchBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
			Thread.sleep(500);
			
			String categoryCount = searchpage.getsearchCount().getText();
			ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
			
			Thread.sleep(500);
			loginPage.getUserDrodown().click();
			Thread.sleep(500);
			loginPage.getLogoutBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
		}
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC4", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_04_searchwithSpecialCharProductName(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
	
		InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
//		searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
	//	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
		searchpage.getSearchBar().clear();

		searchpage.searchwithSpecialCharProductName(datatable.get("Product Name"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with Special Character product name in the search bar");
		
		searchpage.getSearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC5", runmode = "No")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void TC_05_searchwithBlankProductName(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
	
		InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
//		searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
	//	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
		searchpage.getSearchBar().clear();

		searchpage.searchwithBlankProductName();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with Blank product name in the search bar");
		
		searchpage.getSearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
	
	    Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}

	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "SearchBar",  testcaseID = "TC6", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void TC_06_searchwithSKUProductName(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
	
	ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);

	InputValidationSearchbar searchpage = new InputValidationSearchbar(driver);
	WebDriverWait wait = new WebDriverWait(driver,30);
//	searchpage.getSearchBar().sendKeys(datatable.get("Product Name"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Enter search data in the search bar");
	

	searchpage.searchwithSKUProductName(datatable.get("Product Name"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 2  :  search with SKU product name in the search bar");
	
	searchpage.getSearchBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
	Thread.sleep(500);
	
	String categoryCount = searchpage.getsearchCount().getText();
	ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
	
	Thread.sleep(500);
	loginPage.getUserDrodown().click();
	Thread.sleep(500);
	loginPage.getLogoutBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
}


}
