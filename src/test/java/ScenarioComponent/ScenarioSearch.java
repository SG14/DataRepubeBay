package ScenarioComponent;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericComponent.BaseClass;
import PageObjectComponent.PageObjectSearch;

public class ScenarioSearch extends BaseClass {
	
	//Logger for log4j
	public static Logger log = Logger.getLogger(ScenarioSearch.class);

	SoftAssert sAssert = new SoftAssert();
	
	@Test(dataProvider="dp_search",dataProviderClass=DataProviderComponent.DataProvider_Search.class,groups={"smoke"})
	public void testsearch(Map search) throws InterruptedException, IOException
	{

		
		//Collecting the data from the Map
		String TC_ID = search.get("TC_ID").toString();
		String Search_Item1 = search.get("Search_Item1").toString();
		String Search_Item2 = search.get("Search_Item2").toString();
		
		log.info("Executing The TestCase" + TC_ID);
		
		Init_App();
		SearchShoe(Search_Item1);
		SearchWatch(Search_Item2);
		validateProductsInCart(TC_ID);
		

		
	}
	
	public void SearchShoe(String Search_Item1)
	{
       PageObjectSearch ebay_pob = new PageObjectSearch(driver);
		
		ExplicitWait(ebay_pob.searchbox,10);
		
		ebay_pob.clicksearchbox();
		ebay_pob.entersearchshoe(Search_Item1);
		ebay_pob.clickshoes();
		
		ebay_pob.clickdropdown();
		ebay_pob.clickShoeSize();
		ebay_pob.clickAddToCart();
		
		log.info("Shoe added to cart");
	}
	
	public void SearchWatch(String Search_Item2)
	{
		PageObjectSearch ebay_pob = new PageObjectSearch(driver);

		ExplicitWait(ebay_pob.viewInCart, 8);
		
		ebay_pob.clicksearchIcon();
		ebay_pob.clicksearchbox();
		ebay_pob.entersearchwatch(Search_Item2);
		ebay_pob.clickWatch();
		ebay_pob.clickAddToCart();
		
		log.info("Watch added to cart");
	}

	public void validateProductsInCart(String TC_ID) throws IOException
	{
		PageObjectSearch ebay_pob = new PageObjectSearch(driver);
		ExplicitWait(ebay_pob.viewInCart, 5);
		ebay_pob.clickViewInCart();
		
		ExplicitWait(ebay_pob.checkoutBtn, 10);
		String actualResult; 
		
		if((ebay_pob.IsShoePresentInCartDisplayed()) && (ebay_pob.IsWatchPresentInCartDisplayed()))
		{
			 actualResult = "True";
		}
		else
		{
			 actualResult ="False";
		}
		
		
		try{
			snapshot(TC_ID, driver);
			sAssert.assertEquals(actualResult, "True", " Shoe and watch are added to the cart, Hence Pass");
			log.info(" Shoes and Watch are added to cart");
		
		}
		catch (AssertionError e) {
			System.out.println("Catch block starts here");
			log.info("Shoe and watch are not added to the cart, Hence Fail");
			snapshot(TC_ID,driver); throw e;
			
		}	
		finally{
			System.out.println("Finally block starts here");
			driver.close();
			sAssert.assertAll();}
		
	}
}
