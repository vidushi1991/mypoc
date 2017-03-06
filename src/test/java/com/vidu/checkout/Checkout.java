/**
 * 
 */
package com.vidu.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class Checkout {
	WebDriver driver;
	WebElement Select;
	@Test
	public void checkoutTesting() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev.bookfari.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li[5]/a/span")).click();
		driver.findElement(By.id("UserEmail")).sendKeys("vidushi@clavax.us");
		driver.findElement(By.id("UserPwd")).sendKeys("2wsx@WSX");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("Searchbooks")).sendKeys("9780300111927");	
		Thread.sleep(3000);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[onclick^=AddToCart]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//section[@id='bookTabs']/div/ul/li[2]/div[9]/div/button[2]")).click();
		driver.findElement(By.id("cartBlock")).click();
		driver.findElement(By.id("btndelivery")).click();
		Thread.sleep(4000);
		WebElement dropdown = driver.findElement(By.id("ddlShipTitle"));
        Select dropdownoption = new Select(dropdown);
        dropdownoption.selectByVisibleText("Miss.");
        Thread.sleep(2000);
        driver.findElement(By.id("btnShipContinue")).click();
        Thread.sleep(4000);
        WebElement carddropdown = driver.findElement(By.id("ddlSavedCards"));
        Select selectcard = new Select(carddropdown);
        selectcard.selectByVisibleText("MASTERCARD # 3897");
        Thread.sleep(3000);
        driver.findElement(By.id("btnComletePayment")).click();
        Thread.sleep(3000);
        driver.close();
        System.out.println("Log in Completed Successfullly");
         
		
	}
	
}
