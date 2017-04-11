/**
 * 
 */
package bookfariscripts;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import logic.FindAllLinks;
import logic.FindBrokenLink;

/**
 * @author Vidushi Mishra
 *
 */
public class CheckBrokenLinks {

	WebDriver driver;
	
	@Test
	public void isAllLinksWorking() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfariautomation//Lib//chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver( options );
		
		driver.get("http://www.bookfari.com/");

		Thread.sleep(4000);

		FindAllLinks fl = new FindAllLinks();
		
		FindBrokenLink fbl =  new FindBrokenLink();

		java.util.List<WebElement> allImages= fl.findAllLinks(driver);

		System.out.println("Total number of elements found " + allImages.size());
		
		for( WebElement element : allImages){
			 
	    	try

	    	{

		        System.out.println("URL: " + element.getAttribute("href")  + " returned "  + fbl.isLinkBroken(new URL(element.getAttribute("href"))));

	    	}

	    	catch(Exception exp)

	    	{

	    		System.out.println("At " + element.getAttribute("href") + "Text on screen : " +element.getText() + " Exception occured -&gt; " + exp.getMessage());	    		

	    	}

	    }
	}



}
