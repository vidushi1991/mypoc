/**
 * 
 */
package bookfariscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Vidushi Mishra
 *
 */
public class Resources {
	static WebDriver driver;
	WebElement Select;
	
	public static String browserDriver = "webdriver.chrome.driver";
	public static String driverpath = "C://Users//Vidushi Mishra//workspace//Bookfari//Lib//chromedriver_win32//chromedriver.exe";
	public static String devUrl = "http://dev.bookfari.com/";
	public static String liveUrl = "http://www.bookfari.com/";
	public static String devUserName = "vidushi@clavax.us";
	public static String devPassword = "2wsx@WSX";
	public static String isbn = "9780553296983";
	public static String myAccountMenu = "//section[@id='headerWrapper']/section/div/div/nav/ul/li[5]/a/span";
	public static String addToCartButton = "button[onclick^=AddToCart]";
	public static String goToCartButton = "//section[@id='bookTabs']/div/ul/li[2]/div[9]/div/button[2]";
	public static String categoryPage = "http://dev.bookfari.com/Categories";
	public static String thanksPayment = "https://dev.bookfari.com/thanks-payment";
}
