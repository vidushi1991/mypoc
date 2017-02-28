/**
 * 
 */
package com.vidu.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vidu.model.Customer;

/**
 * @author Vidushi Mishra
 *
 */
public class LoginUtility {
	
	WebDriver driver;
	public void loginTesting() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C://Users//Vidushi Mishra//workspace//Bookfariautomation//Lib//chromedriver.exe");
		driver = new ChromeDriver();
		ReadWriteExcelUtility readwrite = new ReadWriteExcelUtility();
		
		List<Customer> customerList =readwrite.readExcelData();
		
		List<Customer>finalCustomerList=new ArrayList<Customer>();
		
		driver.get("https://dev.bookfari.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li[5]/a/span")).click();
		
		for (Customer customer : customerList) 
			
		 {
			driver.findElement(By.id("UserEmail")).sendKeys("userName");
			driver.findElement(By.id("UserPwd")).sendKeys("password");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(4000);
		}
		
		if (driver.findElement(By.id("UserEmailWrongCombinationErrorMsg")).isEnabled()){
			driver.findElement(By.id("UserEmail")).clear();
			driver.findElement(By.id("UserPwd")).clear();
			finalCustomerList.add(new Customer(Customer.getUserName(), Customer.getPassword(), "UnAuthenticate"));
			
		}
		
	}

}


