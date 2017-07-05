/**
 * 
 */
package bookfariscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class Checkout extends Resources {
	WebElement Select;
	
	


	/*@BeforeClass
	public void setUp() {

		System.setProperty(browserDriver, driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get(devUrl);

	}*/
	
	@Test
	public static void checkoutTesting() throws InterruptedException
	{	
		try {
				
				/*try {
					driver.findElement(By.id("signInBtn")).click();
					TakeScreenshot.getscreenshot(driver);
					driver.findElement(By.id("UserEmail")).sendKeys(devUserName);
					driver.findElement(By.id("UserPwd")).sendKeys(devPassword);
					TakeScreenshot.getscreenshot(driver);
					driver.findElement(By.id("btnLogin")).click();
					TakeScreenshot.getscreenshot(driver);
					Thread.sleep(4000);
				} 
				catch (Exception e) {
					System.out.println("Login fails" +e.getMessage());
					
				}*/
			
			
			
			
			/*driver.findElement(By.id("Searchbooks")).sendKeys(isbn);
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(3000);
			driver.findElement(By.id("btnSearch")).click();
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(3000);*/
			
			
			
			/*driver.findElement(By.cssSelector(addToCartButton)).click();
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(4000);
			*/
			
			
			/*driver.findElement(By.xpath(goToCartButton)).click();
			TakeScreenshot.getscreenshot(driver);*/
			
			
			driver.findElement(By.id("cartBlock")).click();
			TakeScreenshot.getscreenshot(driver);
			driver.findElement(By.id("btndelivery")).click();
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(4000);
			WebElement dropdown = driver.findElement(By.id("ddlShipTitle"));
			Select dropdownoption = new Select(dropdown);
			dropdownoption.selectByVisibleText("Miss.");
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(2000);
			driver.findElement(By.id("btnShipContinue")).click();
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(4000);
			WebElement carddropdown = driver.findElement(By.id("ddlSavedCards"));
			Select selectcard = new Select(carddropdown);
			selectcard.selectByIndex(2);
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(3000);
			driver.findElement(By.id("btnComletePayment")).click();
			TakeScreenshot.getscreenshot(driver);
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait(driver, 40);//wait for 40 sec.
			String thanksPage =driver.getCurrentUrl();
			Boolean element = wait.until(ExpectedConditions.urlMatches(thanksPage));
			
			
			System.out.println("Checkout Completed Successfullly " + thanksPage);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		

	}
	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}
