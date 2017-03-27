/**
 * 
 */
package com.bookfari.practise.script;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.bookfari.practise.utility.ISBNExcel;

/**
 * @author Vidushi Mishra
 *
 */
public class SearchISBN {

	WebDriver driver;

	@Test
	public void bowkerUpdate() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\vidushi\\BookFari\\Lib\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("https://dev.bookfari.com/");
		Thread.sleep(4000);
		ISBNExcel obj =new ISBNExcel();
		List<String> li=obj.readISBN();
		for (String string : li) {
			driver.findElement(By.id("Searchbooks")).sendKeys(string);
			driver.findElement(By.id("btnSearch")).click();
			driver.findElement(By.id("Searchbooks")).click();
			driver.findElement(By.id("Searchbooks")).clear();


		}
		

	}
}
