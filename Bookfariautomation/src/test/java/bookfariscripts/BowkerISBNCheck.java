/**
 * 
 */
package bookfariscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vidu.model.ISBN;
import com.vidu.utility.ISBNUtility;

/**
 * @author Vidushi Mishra
 *
 */
public class BowkerISBNCheck extends Resources{


	public List<ISBN> bowkerUpdate() throws InterruptedException, IOException{
		System.setProperty(browserDriver, driverpath);
		List<ISBN> finalISBNlist = new ArrayList<ISBN>();

		/*
		 *Read ISBN from excel 
		 *@Return ISBN of type list
		 */
		ISBNUtility bowkerobj = new ISBNUtility();
		List<ISBN> list =bowkerobj.readISBN();
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver( options );
			driver.get(liveUrl);

			Thread.sleep(4000);

			for (ISBN isbn : list) {
				driver.findElement(By.id("Searchbooks")).sendKeys(isbn.getIsbn());
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				if (driver.getTitle().equalsIgnoreCase("Bookfari | The online Bookstore + Free Shipping.")) {
					driver.findElement(By.id("Searchbooks")).click();
					driver.findElement(By.id("Searchbooks")).clear();
					finalISBNlist.add(new ISBN(isbn.getIsbn(), "ISBN Not Found"));
				} else {
					driver.findElement(By.id("Searchbooks")).click();
					driver.findElement(By.id("Searchbooks")).clear();

					finalISBNlist.add(new ISBN(isbn.getIsbn(), "ISBN Found"));


				}
			}


		} catch (InterruptedException ie) {
			ie.printStackTrace();
			// TODO: handle exception
		}
		driver.close();
		return finalISBNlist;


	}

}
