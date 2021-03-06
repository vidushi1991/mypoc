/**
 * 
 */
package com.bookfari.practise.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bookfari.practise.model.Customer;

/**
 * @author Vidushi Mishra
 *
 */
public class LoginUtility {

	WebDriver driver;

	public List<Customer> testLogin() throws InterruptedException, IOException,NoSuchElementException{
		System.setProperty("webdriver.chrome.driver","E:\\vidushi\\BookFari\\Lib\\chromedriver.exe" );
		//Calling excel Utility to read excel files
		ExcelUtility excelUtility=new ExcelUtility();
		List<Customer>customerList=excelUtility.readExcel();
		
		List<Customer>finalCustomerList=new ArrayList<Customer>();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("https://dev.bookfari.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li[5]/a/span")).click();
		for(Customer customer:customerList){
			Thread.sleep(4000);
			driver.findElement(By.id("UserEmail")).click();
			driver.findElement(By.id("UserEmail")).sendKeys(customer.getUserName());
			driver.findElement(By.id("UserPwd")).sendKeys(customer.getPassword());
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(8000);
			if(driver.findElement(By.id("UserEmailWrongCombinationErrorMsg")).isEnabled()){			
				driver.findElement(By.id("UserEmail")).clear();
				driver.findElement(By.id("UserPwd")).clear();
				finalCustomerList.add(new Customer(customer.getUserName(),customer.getPassword(),"Not Authenticate"));
			}
			else{
				finalCustomerList.add(new Customer(customer.getUserName(),customer.getPassword(),"Authenicate"));
				//TODO logout ki fucfd fdsf karo
				
			}

		}
		return finalCustomerList;
	}
	
}
