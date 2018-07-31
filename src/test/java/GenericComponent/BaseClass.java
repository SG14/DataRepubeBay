package GenericComponent;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static AndroidDriver driver;
	@Test
	public static void Init_App() throws MalformedURLException, InterruptedException
	{
	
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	//device details

		
		capabilities.setCapability("deviceName", "Redmi");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		
	
	//browser details
	capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");

	//appium server details
	driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 
	driver.get("https://www.ebay.com.au/");

	Thread.sleep(8000);
	}
	
	
	public void ExplicitWait(WebElement element, long i)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	public void snapshot(String TC_ID, AndroidDriver driver ) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(df.format(date)+".png");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Framework\\DataRepubEbay\\Screenshot"+TC_ID+"-"+file));
		                                  
	}

}
