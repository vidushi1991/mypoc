/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidushi Mishra
 *
 */
public class AddToCartScript extends Resources{
	
	public static void checkAddToCart() throws InterruptedException
	{
		driver.findElement(By.cssSelector(addToCartButton)).click();
		TakeScreenshot.getscreenshot(driver);
		Thread.sleep(4000);
		TakeScreenshot.getscreenshot(driver);
		WebDriverWait waitaddtocart = new WebDriverWait(driver, 40);//wait for 40 sec.
		WebElement elementaddtocart = waitaddtocart.until(ExpectedConditions.elementToBeClickable(By.xpath(goToCartButton)));
		System.out.println("go to cart button found");
	}

}
