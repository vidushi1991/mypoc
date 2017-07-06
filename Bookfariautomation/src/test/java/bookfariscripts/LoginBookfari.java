/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidushi Mishra
 * 
 * This will automate the login script 
 *
 */
public class LoginBookfari extends Resources{
	
	public static void checkLogin()
	{
		

	
	try {
		driver.findElement(By.id("signInBtn")).click();
		TakeScreenshot.getscreenshot(driver);
		System.out.println("////////click on signn in button ");

		driver.findElement(By.id("UserEmail")).sendKeys(devUserName);
		TakeScreenshot.getscreenshot(driver);
		System.out.println("/////////entered email ");

		driver.findElement(By.id("UserPwd")).sendKeys(devPassword);
		TakeScreenshot.getscreenshot(driver);
		System.out.println("////////entered password ");

		driver.findElement(By.id("btnLogin")).click();
		TakeScreenshot.getscreenshot(driver);
		System.out.println(" /////////clicked on login button");
		WebDriverWait wait = new WebDriverWait(driver, 60);//wait for 40 sec.
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='account-Block']")));
		System.out.println("//////////account- block found ");
	} 
	catch (Exception e) {
		System.out.println(" +++++++Login fails ++++++++++++" +e.getMessage());
		TakeScreenshot.getscreenshot(driver);
	}
	}

}
