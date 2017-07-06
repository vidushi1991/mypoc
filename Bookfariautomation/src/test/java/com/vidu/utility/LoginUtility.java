/**
 * 
 */
package com.vidu.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vidu.model.Customer;

import bookfariscripts.Resources;

/**
 * @author Vidushi Mishra
 *
 */
public class LoginUtility extends Resources {

	WebDriver driver;
	boolean result = false;
	public List<Customer> loginTesting() throws InterruptedException, IOException, NoSuchElementException{
		System.setProperty(browserDriver, driverpath);
		ExcelUtility excelUtility=new ExcelUtility();
		List<Customer>customerList=excelUtility.readExcel();

		List<Customer>finalCustomerList=new ArrayList<Customer>();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		Thread.sleep(4000);
		driver.get(devUrl);
		Thread.sleep(4000);
		driver.findElement(By.xpath(myAccountMenu)).click();
		String currentURL = "https://dev.bookfari.com/login";
		for(Customer customer:customerList){
			Thread.sleep(4000);
			driver.findElement(By.id("UserEmail")).click();
			driver.findElement(By.id("UserEmail")).sendKeys(customer.getUserName());
			driver.findElement(By.id("UserPwd")).sendKeys(customer.getPassword());
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(4000);
			if (driver.getCurrentUrl().equalsIgnoreCase(currentURL)) {
				driver.findElement(By.id("UserEmail")).clear();
				driver.findElement(By.id("UserPwd")).clear();
				finalCustomerList.add(new Customer(customer.getUserName(),"#########","Not Authenticate"));
			} else {

				driver.findElement(By.linkText("LOGOUT.")).click();
				Thread.sleep(3000);
				finalCustomerList.add(new Customer(customer.getUserName(),"#########","Authenicate"));
				Thread.sleep(4000);
			}

		}
		driver.close();
		return finalCustomerList;
	}

}


