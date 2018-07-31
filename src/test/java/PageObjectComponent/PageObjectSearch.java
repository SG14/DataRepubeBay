package PageObjectComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectSearch {
	
	
	public AndroidDriver driver;
	
	
	//first section

	public PageObjectSearch(AndroidDriver driver) 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}



	
	//second section - @FIndBy annotation
	
	@FindBy(id="kw")
	public WebElement searchbox;
	
	@FindBy(id="kw")
	public WebElement searchdata;
	
	@FindBy(xpath="//h3[contains(text(),'Reebok ZPump Fusion 2.5 FL Black White Men Running Training Shoes Sneaker AR0515')]")
	public WebElement searchShoeFound;
	
	@FindBy(id="vi-msku__select-box-1000")
	public WebElement dropDownElement;
	
	@FindBy(id="vi-msku__option-box-0")
	public WebElement selectValueFromDropdown;
	
	@FindBy(id="vi-cart-button")
	public WebElement addToCartBtn;
	
	@FindBy(id="gh-openSearch")
	public WebElement searchBtn;
	
	@FindBy(xpath="//h3[contains(text(),'Tommy Hilfiger The Denim Men Silicone Watch - 1791322')]")
	public WebElement searchWatchFound;
	
	@FindBy(xpath="//a[contains(text(),'View in cart')]")
	public WebElement viewInCart;
	
	@FindBy(id="checkoutBtnId")
	public WebElement checkoutBtn;
	
	@FindBy(xpath="//div[contains(text(),'Reebok ZPump Fusion 2.5 FL Black White Men Running Training Shoes Sneaker AR0515')]")
	public WebElement IsshoesPresentInCart;
	
	@FindBy(xpath="//div[contains(text(),'Tommy Hilfiger The Denim Men Silicone Watch - 1791322')]")
	public WebElement IswatchPresentInCart;
	

	
	
	
	//Third section - Methods to perform the actions
	
	public void clicksearchbox()
	{
		searchbox.click();
	}
	
	public void entersearchshoe(String value)
	{
		searchdata.sendKeys(value+"\n");
	}


	public void clickshoes()
	{
		searchShoeFound.click();
	}
	
	public void clickdropdown()
	{
		dropDownElement.click();
	}
	
	public void clickShoeSize()
	{
		selectValueFromDropdown.click();
	}
	
	public void clickAddToCart()
	{
		addToCartBtn.click();
	}
	
	public void clicksearchIcon()
	{
		searchBtn.click();
	}
	
	public void entersearchwatch(String value)
	{
		searchdata.sendKeys(value+"\n");
	}
	
	public void clickWatch()
	{
		searchWatchFound.click();
	}
	
	public void clickViewInCart()
	{
		viewInCart.click();
	}
	
	public boolean IsShoePresentInCartDisplayed()
	{
		boolean isShoeDisplayed = IsshoesPresentInCart.isDisplayed();
		return isShoeDisplayed;
	}
	
	public boolean IsWatchPresentInCartDisplayed()
	{
		boolean isWatchDisplayed = IswatchPresentInCart.isDisplayed();
		return isWatchDisplayed;
	}
	

}
