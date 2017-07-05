/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Vidushi Mishra
 *
 */
public class RunChromeBrowser {
	WebDriver driver;

	public void openGoogleChromeBrowser1() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get("https://dev.bookfari.com/");
		Thread.sleep(4000);

	}

}
