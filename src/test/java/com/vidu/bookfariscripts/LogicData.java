/**
 * 
 */
package com.testing.logic;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.model.geom.IfElseExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class LogicData {
	WebDriver driver;
	public WebElement element;
	@Test
	public List<String> testingLogic() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E:\\vidushi\\BookFari\\Lib\\chromedriver.exe" );
		List<String>categoryList=new ArrayList<String>();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bookfari.com/");
		Thread.sleep(4000);
		
		//Step1- FETCH AND STORE disable nhi haim jo  BOOK Category List
		WebElement forhover = driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li/a/span"));
		Actions action = new Actions(driver);
		   action.moveToElement(forhover).build().perform();
		   try {
			   element=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("See All Of Our Categories")));
			   driver.findElement(By.linkText("See All Of Our Categories")).click();
		} catch (TimeoutException e) {
		}
		    


		   
		   List<WebElement>listEl=driver.findElements(By.xpath("//div[@id='mCSB_1_container']/div/p"));
		   int directorySize= listEl.size();
			// TODO: handle exception
		    for(int i=1;i<=directorySize;i++){
		    	
		    	WebElement ele = driver.findElement(By.xpath("//div[@id='mCSB_1_container']/div/p["+i+"]"));
		    	
		    	String class_name = ele.getAttribute("class");
		    	
		    	if(!StringUtils.equalsIgnoreCase("disabled", class_name)){
		    		categoryList.add(String.valueOf(i));
		    		System.out.println(categoryList);
		    	}
		    	
				
		    } 
		    
		  for (String string : categoryList) {
			System.out.println(string);
			 driver.findElement(By.xpath("//div[@id='mCSB_1_container']/div/p["+string+"]")).click();
			 Thread.sleep(5000);
			 
		
				List<WebElement>liCategoryName=driver.findElements(By.xpath("//div[@id='div_Html']/div/ul/li/a"));

				int howmanycategory = liCategoryName.size();
				for(int i=1;i<=howmanycategory;i++)
					
				{
					driver.findElement(By.xpath("//div[@id='div_Html']/div/ul/li/a["+i+"]")).click();
					
				}
			 driver.navigate().refresh();
			//div[@id='mCSB_1_container']/div/p[2]
		}
			
		
				
			
		  
		return categoryList;
		   
		
		}
	/*public void findCategory(){
		List<WebElement> liCategoryName= driver.findElements(By.xpath("//div[@id='dirBlock']/div/ul/li"));
		System.out.println("list items -------------" +liCategoryName);
		int howmanycategory = liCategoryName.size();
		for(int i=1;i<=howmanycategory;i++)
			
		{
			driver.findElement(By.xpath("//div[@id='dirBlock']/div/ul/li["+i+"]")).click();
		}
	}*/
	public static void main(String[] args) throws InterruptedException {
		LogicData obj = new LogicData();
		obj.testingLogic();
		
	}

	}

