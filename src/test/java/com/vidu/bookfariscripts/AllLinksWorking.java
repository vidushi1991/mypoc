/**
 * 
 */
package bookfariscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.vidu.model.Link;
import com.vidu.utility.WriteUtility;

/**
 * @author Vidushi Mishra
 * 
 * This script will check all links are workings
 *
 */
public class AllLinksWorking {
	WebDriver driver;
	
	@Test 
	public void linksworking() throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver.exe");
		List<String>clickedlinks = new ArrayList<String>();
		List<Link> finallinks = new ArrayList<Link>();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get("http://www.bookfari.com/");
		driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li[6]/a/span")).click();
		Thread.sleep(4000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
				 
		for (WebElement atag : links) {
			String linkname = atag.getText();
			System.out.println(linkname);
			if (!linkname.isEmpty())
			{
				
				clickedlinks.add(linkname);
				System.out.println(clickedlinks);
				/*WriteUtility wu = new WriteUtility();
				wu.writeExcel(finallinks);
				finallinks.add(new Link(linkname, "found"));

				System.out.println("add to list that has text" +clickedlinks);*/
			}
			
			
				
			
		}
 
		/*for (int i = 1; i<links.size(); i=i++)
 
		{
 
			
			
 
		}*/
 
	}

}
