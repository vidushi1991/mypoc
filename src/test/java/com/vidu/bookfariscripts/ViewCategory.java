/**
 * 
 */
package bookfariscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class ViewCategory {
	WebDriver driver;
	public WebElement element;
	@Test
	public void openCategoryPage() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev.bookfari.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement forhover = driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li/a/span"));
		Actions action = new Actions(driver);
		   action.moveToElement(forhover).build().perform();
		   try {
			   element=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("See All Of Our Categories")));
			   driver.findElement(By.linkText("See All Of Our Categories")).click();
		} catch (TimeoutException e) {
			// TODO: handle exception
		}
		  
	}

}
