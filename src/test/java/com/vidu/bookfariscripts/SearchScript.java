/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidushi Mishra
 *
 * This method will check the search functionality and auto complete suggestions 
 *
 */
public class SearchScript extends Resources {

	public static void checkSearch() throws InterruptedException{
		
		driver.findElement(By.id("Searchbooks")).sendKeys(isbn);
		TakeScreenshot.getscreenshot(driver);
		System.out.println("------isbn entered ");
		driver.findElement(By.id("btnSearch")).click();
		TakeScreenshot.getscreenshot(driver);
		System.out.println("-------clicked on search button ");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='bookTabs']/div/ul/li[2]/div[9]/div/button[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		WebDriverWait waitsearch = new WebDriverWait(driver, 100);//wait for 40 sec.
		WebElement elementsearch = waitsearch.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bookTabs']/div/ul/li[2]/div[9]/div/button[1]")));
		TakeScreenshot.getscreenshot(driver);
		System.out.println("---------add to cart button found  ");

	}
}
