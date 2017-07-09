/**
 * 
 */
package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Vidushi Mishra
 *
 */
public class BaseUtilTest extends TestListenerAdapter{

	protected static WebDriver driver;
	private static WebElement element;

	static String browserDriver = "webdriver.chrome.driver";
	static String driverpath = "E:\\vidushi\\BookFari\\Lib\\chromedriver_win32 (1)\\chromedriver.exe";

	@BeforeMethod
	public static void openBrowser()
	{
		System.setProperty(browserDriver, driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get("http://www.google.com");
		//Assert.assertEquals(driver.getCurrentUrl(), "http://www.google.com");
	}
	@Test(priority=1)
	public static void search(){
		driver.findElement(By.id("lst-ib")).sendKeys("Hello World");
		element = driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		element.click();
		Assert.assertTrue(true);

	}
	/*@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}*/

	/*public WebDriver getDriverInstance()
	{
		return driver;
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		onTestFailure(result);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseUtilTest) currentClass).getDriverInstance();

		if (driver != null)
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try
			{
				String fileNameToCopy = "target/custom-test-reports/" + result.getTestClass().getName()
						+ "_screenshot.png";
				FileUtils.copyFile(scrFile, new File(fileNameToCopy));
				Reporter.log("[Console Log] Screenshot saved in " + result.getTestClass().getName() + "_screenshot.png");
			} catch (IOException ex)
			{
				// Log error message
			}
		}
	}
*/
}
