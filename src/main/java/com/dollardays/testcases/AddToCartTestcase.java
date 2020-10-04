package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.AddToCartPage;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class AddToCartTestcase extends BaseTest  {

	//getting the credentials from xlsx file from ADDToCartPPE
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddToCartPPE",  testcaseID = "TC1", runmode = "yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_02_add_one_item_to_cart(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{


		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Identifying menu icon and click
		addtocart.MenuPPE();

		WebElement item1 = addtocart.getItem();
		String s = item1.getAttribute("data-sku");
		System.out.println("The item added" +s);
		item1.click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on  product ");
		
		addtocart.getAddToMyCartbtn().click();	//Identify add to my cart button and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Click on add to my cart button ");

		addtocart.HandleAddtocartPopup();

		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 8 : Click on cart icon ");//Identify cart icon and click
		WebElement cartitem = driver.findElement(By.xpath("//*[contains(text(),'SKU #')]"));
		String s1 = (cartitem.getText()).substring(6);
		System.out.println("The item in the cart" +s1);
		if(s.equals(s1)) {
			System.out.println("Correct item added");
		}
		else {
			System.out.println("Wrong item added");
		}
		
		//Assert.assertTrue(driver.getTitle().equals("View Unplaced Order - DollarDays"));//Verifying the title of the redirected page

		//Validating the product added in the cart
		ExtentTestManager.getTest().log(Status.PASS, "Step 9 : Correct item added to the cart ");
		
		/*if(driver.findElement(By.xpath("//a[contains(text(),'Premium 75% Alcohol Wipes')]")).isDisplayed()) {
			System.out.println("testcase passed");
		}
		else {
			System.out.println("Wrong item placed in the cart");
		}

*/

	}

	//second scenario adding one item to the cart by clicking add to cart button on the product

	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_01_add_one_items_to_cart_2(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Clearing the cart ");
		//addtocart.clearcart();

		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		System.out.println("This is item added" +s);
		item.click();
		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		
		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			System.out.println("Correct item added");
		}
		else {
			System.out.println("Wrong item added");
		}


	}

	//Editing the quantity in the # of cases text box   
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_03_validate_no_of_cases_textbox_with_valid_data (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();

		addtocart.MenuPPE();

		addtocart.getItem().click();//Identify one item and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on item ");

		//clearing # of cases test box and typing 5
		addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Enter 5 in the # no of cases textbox ");
		addtocart.getquantitytxtbox().sendKeys("5");//entering 5 in the quantity textbox

		addtocart.getAddToMyCartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6 : Click on add to my cart button ");

		//Handle the pop up
		WebDriverWait wait = new WebDriverWait(driver,30);

		addtocart.HandleAddtocartPopup();

		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7 : Click on carticon ");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'Premium 75% Alcohol Wipes')]")).isDisplayed()) {
			System.out.println("Item added to the cart");
		}
		else {
			System.out.println("Wrong item placed in the cart");
		}
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_04_validate_clear_items_from_the_cart_from_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Click on clear cart button");
		//Validatin the shopping cart
		if(driver.findElement(By.xpath("//h1[contains(text(),'Your Shopping Cart is empty.')]")).isDisplayed())
			System.out.println("Cart is cleared successfully");
		else {
			System.out.println("Cart is not cleared");
		}

	}

@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void TC_08_validate_no_of_cases_textbox_with_zero (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);



	AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
	addtocart.clearcart();

	addtocart.MenuPPE();

	addtocart.getItem().click();//Identify one item and click
	ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on item ");

	//clearing # of cases test box and typing 5
	addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
	ExtentTestManager.getTest().log(Status.PASS, "Step  : Enter 0 in the # no of cases textbox ");
	addtocart.getquantitytxtbox().sendKeys("0");//entering 5 in the quantity textbox

	addtocart.getAddToMyCartbtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on add to my cart button ");
	addtocart.getqtyzeropopup();
	ExtentTestManager.getTest().log(Status.PASS, "Step  :  No Quantity is added should display" );

	

}
@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void TC_05_validate_no_of_cases_textbox_with_boundary_value (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);



	AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
	addtocart.clearcart();

	addtocart.MenuPPE();

	addtocart.getItem().click();//Identify one item and click
	ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on item ");

	//clearing # of cases test box and typing 5
	addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
	ExtentTestManager.getTest().log(Status.PASS, "Step  : Enter 0 in the # no of cases textbox ");
	addtocart.getquantitytxtbox().sendKeys("566678");//entering 566678 in the quantity textbox

	addtocart.getAddToMyCartbtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on add to my cart button ");
	addtocart.getqtyboundaryvalue().isDisplayed();
	ExtentTestManager.getTest().log(Status.PASS, "Step  : you've exceeded the number of available units. Please revise your quantity or call 877-837-9569." );

	}
@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void TC_07_validate_clear_items_from_the_cart_from_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);



	AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods

	addtocart.MenuPPE();
	List<WebElement> multipleitems = new ArrayList<WebElement>();
	multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/input[5]")));
	multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[2]/div/div[2]/div/input[5]")));
	multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[6]/div/div[2]/div/input[5]")));
	multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[7]/div/div[2]/div/input[5]")));
	List<String> skus = new ArrayList<String>();
	for(WebElement text:multipleitems) {
		System.out.println("This is" + text.getAttribute("data-sku"));
		skus.add(text.getAttribute("data-sku"));
		Thread.sleep(1000);
		text.click();
		Thread.sleep(1000);
		addtocart.HandleAddtocartPopup();
		
	}
		
	addtocart.getCarticon().click();
	List<WebElement>cartitems = new ArrayList<WebElement>();
	cartitems.addAll(driver.findElements(By.xpath("//*[contains(text(),'SKU #')]")));
	List<String> cartskus = new ArrayList<String>();
	for(WebElement cartitemtext:cartitems) {
		System.out.println("This is cart" +cartitemtext.getText());
		cartskus.add((cartitemtext.getText()).substring(6));
		Thread.sleep(1000);
	}
	Collections.sort(skus);
	Collections.sort(cartskus);
	System.out.println(skus.equals(cartskus));
}

}




	
		











