/**
 * 
 */
package com.bookfari.utility;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class SearchIsbn {

	WebDriver driver;

	@Test
	public void openBookfari() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","E:\\vidushi\\BookFari\\Lib\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("http://www.bookfari.com/");
		Thread.sleep(4000);
		List<String>isbnList=new ExcelUtilityisbn().readExcel();
		for (String string : isbnList) {
			driver.findElement(By.id("Searchbooks")).sendKeys(string);
			driver.findElement(By.id("btnSearch")).click();
			driver.findElement(By.id("Searchbooks")).clear();
			//String a = driver.findElement(By.id("div_Isbn")).getText();
		}
		driver.quit();
	}

}
