/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Vidushi Mishra
 *
 */
public class BookfariInOneGo extends Resources{
	
	
	@Test (priority=1)
	public static WebDriver openBrowser()
	{
		System.setProperty(browserDriver, driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		return driver = new ChromeDriver( options );
	}
	
	@Test (priority=2)	
	public static void loadWebsite() throws Exception{
		
		
		try {
			
			driver.get(devUrl);
			TakeScreenshot.getscreenshot(driver);
			System.out.println("website load ");
		
		
		} catch (Exception e) {
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("website not load ");

		}
	}
	@Test (priority=3)
	public static void testLogin()
	{
		try {
			LoginBookfari.checkLogin();
			TakeScreenshot.getscreenshot(driver);
			System.out.println("user login ");


			
		} catch (Exception e) {
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("user not loggedin  ");


		}
	}
	@Test (priority=4)
	public static void testSearch(){
		try {
			SearchScript.checkSearch();
			TakeScreenshot.getscreenshot(driver);
			System.out.println("search done ");

		} catch (Exception e) {
			System.out.println("I am in Exception" +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("search not done ");

			// TODO: handle exception
		}
	}
	@Test (priority=5)	
	public static void testAddToCart(){
		try {
			AddToCartScript.checkAddToCart();
			TakeScreenshot.getscreenshot(driver);
			System.out.println("item added to cart ");

		} catch (Exception e) {
			System.out.println("I am in Exception   " +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("item not added to cart ");

		}
	}
	@Test (priority=6)	
	public static void testGoToCart(){
		try {
			GoToCartScript.checkGoToCart();
			TakeScreenshot.getscreenshot(driver);
			System.out.println("i am in check out page ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("I am in Exception   " +e.getMessage());
			TakeScreenshot.getscreenshot(driver);
			System.out.println("not in checkout page    ");
		}
	}
	
	@Test (priority=7)	
	public static void testCheckout() throws Exception{
		
		try {
			
			Checkout.checkoutTesting();
// call method to take screenshot
			TakeScreenshot.getscreenshot(driver);
			System.out.println("checkout done ");

			
			
		} catch (Exception e) {
// call method to take screenshot
			System.out.println("I am in Exception" +e.getMessage());
						TakeScreenshot.getscreenshot(driver);	
						System.out.println("checkout not done ");

		}
	}
	
/*	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath = TakeScreenshot.getscreenshot(driver);
		}
	}*/

}
