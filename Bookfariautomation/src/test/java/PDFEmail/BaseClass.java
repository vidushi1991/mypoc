/**
 * 
 */
package PDFEmail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import bookfariscripts.Resources;

/**
 * @author Vidushi Mishra
 *
 */
public class BaseClass extends Resources {
	
	static WebDriver driver;
	public static WebDriver openBrowser()
	
	{
		if(driver==null){
			System.setProperty(browserDriver, driverpath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			return driver = new ChromeDriver( options );
		}
		return driver;
		
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination 
				File DestFile=new File(fileWithPath);
				//Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);
			
	}
	
}
