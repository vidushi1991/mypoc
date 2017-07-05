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
public class GoToCartScript extends Resources {
	
	public static void checkGoToCart()
	{
		driver.findElement(By.xpath(goToCartButton)).click();
		TakeScreenshot.getscreenshot(driver);
		WebDriverWait waitaddtocart = new WebDriverWait(driver, 60);//wait for 40 sec.
		WebElement elementaddtocart = waitaddtocart.until(ExpectedConditions.elementToBeClickable(By.id("cartBlock")));
	}

}
