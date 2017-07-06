/**
 * 
 */
package bookfariscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 * @author Vidushi Mishra
 *
 */
public  class TakeScreenshot {
	
	static WebDriver driver;

	static File source;
	 public static void getscreenshot(WebDriver webDriver)   {
   
		 try { 
			 source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			 String destination = "D://test-outputclaimsScreenShot"+timestamp()+".png";
			 File dest = new File(destination);
		        
			 FileUtils.copyFile(source, dest);
			 System.out.println("Screenshot Taken!!!!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		 
            
     }
	 public static String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}


	 
}