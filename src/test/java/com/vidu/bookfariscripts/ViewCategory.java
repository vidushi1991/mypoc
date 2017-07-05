/**
 * 
 */
package bookfariscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class ViewCategory extends Resources{

	WebDriver driver;

	public WebElement element;

	String xpathdepo ="//div[@id='mCSB_1_container']/div/p";
	

	@BeforeClass
	public void setUp() {

		System.setProperty(browserDriver, driverpath);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");

		driver = new ChromeDriver( options );

		driver.get(devUrl);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	/*
		This method will open the category page and store the 
		full directory in the list

	 */
	@Test(priority = 0)
	public void openCategoryPage() throws InterruptedException, NoSuchElementException
	{

		/*
		This will store the path of element in forhover, Action class will perform the mouse hover event in the browser

		 */
		WebElement forhover = driver.findElement(By.xpath("//section[@id='headerWrapper']/section/div/div/nav/ul/li/a/span"));
		Actions action = new Actions(driver);
		action.moveToElement(forhover).build().perform();
		try {
			element=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("See All Of Our Categories")));
			driver.findElement(By.linkText("See All Of Our Categories")).click();
			driver.getCurrentUrl();
		} catch (TimeoutException e) {
			// TODO: handle exception
		}


	}

	@Test(priority = 1)
	public void getActivedirectory() throws InterruptedException  
	{
		List<String> list = new ArrayList<String>();
		List<WebElement>depository = driver.findElements(By.xpath(xpathdepo));
		
		int size =depository.size();
		
		Thread.sleep(5000);
		
		
		for (int i=1; i<size;i++)
		
		{
			Thread.sleep(4000);

			String class_Name= driver.findElement(By.xpath("//div[@id='dirBlock']/div/div/div/p["+i+"]")).getAttribute("class");
			
			if (!class_Name.equalsIgnoreCase("disabled") )
			{
				/*@Todo 
				 * code to open every page under the active category
				*/
				List<WebElement> categories =driver.findElements(By.xpath("//*[@id='div_Html']/div/ul/li"));
				int liList=categories.size();
				for (i=1; i<=liList; i++)
				{
					driver.findElement(By.xpath("//div[@id='div_Html']/div/ul/li["+i+"]/a")).click();
					driver.get(categoryPage);
					
				}
				/*System.out.println("the class name is " +class_Name);
				String string =driver.findElement(By.xpath("//div[@id='dirBlock']/div/div/div/p["+i+"]")).getText();
				list.add(string);				
				Thread.sleep(4000);

				//	System.out.println("the alphabet is " +string );
				System.out.println(list);*/
						
			}
			
			driver.findElement(By.xpath("//div[@id='dirBlock']/div/div/div/p["+(i+1)+"]")).click();
			

		}
	}
	


	/*@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}*/





}
