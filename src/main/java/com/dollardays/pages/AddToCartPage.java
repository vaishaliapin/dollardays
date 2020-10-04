package com.dollardays.pages;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class AddToCartPage {
	//Instantiation of the webdriver 
	WebDriver driver;

	//Creating the constructor to call all the Webelements in this page .Ex : menuicon,ppe etc

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}	
	@FindBy(xpath = "//*[@id=\"sm_menu_ham\"]")
	private WebElement menuicon;

	public WebElement getMenuIcon() {
		return menuicon;
	}
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[2]/a")
	private WebElement ppemask;

	public WebElement getPPEmask() {
		return ppemask;
	}
	@FindBy(xpath = "//*//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[3]/div[1]/a")
	private WebElement item;

	public WebElement getItem() {    
		return item;     
	}

	@FindBy(xpath = "//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/input[5]")
	private WebElement itemaddtocart;

	public WebElement getItemaddtocart() {    
		return itemaddtocart;
	}

	@FindBy(xpath = "//button[@class='cart_newbtn btn dd-btn-secondary btn-quick-view bold jqatc fsig gtmAddCart btn-group-lg']")
	private WebElement addtomycartbtn;

	public WebElement getAddToMyCartbtn() {
		return addtomycartbtn;

	}
	@FindBy(xpath = "//img[@class='header-cart']")  
	private WebElement carticon;

	public WebElement getCarticon() {
		return carticon;

	}

	@FindBy(xpath = "//span[@id='ctl00_ddiPageHeader_liViewCartDesktop']")  
	private WebElement carticontxt;

	public WebElement getCarticontxt() {
		return carticontxt;
	}
	@FindBy(xpath =" //input[@name='picquantity'] ")
	private WebElement quantitytxtbox;

	public WebElement getquantitytxtbox() {
		return quantitytxtbox;
	}
	@FindBy(xpath = "noreturnmodal_msg")
	private WebElement popuptxt;

	public WebElement getpopuptxt() {
		return popuptxt;
	}
	@FindBy(id = "ctl00_cphContent_btnClearCart")
	private WebElement clearcart;

	public WebElement getclearcart() {
		return clearcart;
	}
	@FindBy(xpath = "//button[@class='btn btn-primary btn-cartclear']")
	private WebElement clearcartpopup;

	public WebElement getclearcartpopup() {
		return clearcartpopup;

	}
	@FindBy(xpath = "//*[@id=\"noreturnmodal\"]/div/div/div[2]/button")
	private WebElement addtocartpopup;

	public WebElement getaddtocartpopup() {
		return addtocartpopup;
	}
	@FindBy(xpath = "//h1[contains(text(),'Your Shopping Cart is empty.')]")
	private WebElement  emptyshopping;

	public WebElement getemptyshopping() {
		return emptyshopping;


	}


	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to clear your cart? This can')]")
	private WebElement clearcartpopuptxt;

	public WebElement getclearcartpopuptxt() {
		return clearcartpopuptxt;
	}
	@FindBy(xpath = "//div[@id='confirmationBox']//div[@class='modal-body']")
	private WebElement qtyzeropopup;

	public WebElement getqtyzeropopup() {
		return qtyzeropopup;

	}
	@FindBy(xpath = "//a[@class='dropdown-item padditem margn-top']")
	private WebElement qtyboundaryvalue;

	public WebElement getqtyboundaryvalue() {
		return qtyboundaryvalue;
	}
	@FindBy(xpath = "//*[contains(text(),'SKU #')]")
	private WebElement cartaddeditems;

	public WebElement getcartaddeditems() {
		return cartaddeditems;
	}

	public void clearcart() throws InterruptedException{

		getCarticon().click();
		Thread.sleep(1000);
		WebElement carttext = getCarticontxt();
		String h = carttext.getText();
		System.out.println("the value in the cart:" +h);
		if(Integer.parseInt(h)>0) {
			getclearcart().click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			String clearcartpopupmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-cartclear']"))).getText();
			System.out.println("Pop up message for clear cart::: " + clearcartpopupmessage);
			getclearcartpopup().click();
		}
		else {
			System.out.println("The cart is already empty");
		}

	}
	
	public void MenuPPE() throws InterruptedException{
		getMenuIcon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: click on Menu Icon ");
		Thread.sleep(1000);
		getPPEmask().click();//Identify Mask,sanitiser and PPE and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : Click on PPE Mask tab ");
		Thread.sleep(1000);
	}

	public void HandleAddtocartPopup()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noreturnmodal\"]/div/div/div[2]/button")));
		String addtocartpopuptext = driver.findElement(By.id("noreturnmodal_msg")).getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6 : Pop up message is : " + addtocartpopuptext);
		getaddtocartpopup().click();

	}






}



