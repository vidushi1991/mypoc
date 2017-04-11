/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Vidushi Mishra
 * 
 * this method will find all links with href tag
 *
 */
public class FindAllLinks {
	WebDriver driver;
	
	public  List<WebElement> findAllLinks(WebDriver driver){
		List<WebElement> elementList = new ArrayList<WebElement>();
		List<WebElement> finallist = new ArrayList<WebElement>();
		
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement element : elementList) {
			if (element.getAttribute("href")!="null"){
				finallist.add(element);
			}
			
		}

		return finallist;
	}

}
