/**
 * 
 */
package bookfariScript;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author Vidushi Mishra
 *
 */
public class CheckActiveLink {

	private WebDriver driver;
	private int invalidLinksCount;

	private String driverProperty="webdriver.chrome.driver";
	private String driverpath="E:\\vidushi\\BookFari\\Lib\\chromedriver.exe";
	private String location="http://bookfari.com/";

	@BeforeClass
	public void setUp() {

		System.setProperty(driverProperty,driverpath);
		driver = new ChromeDriver();
		driver.get(location);
	}

	@Test
	public void checkLink() throws IOException{

		List<String>finalList=mergeTwoList();
		List<URLBean>urlAndStatus=verifyUrl(finalList);
		
		writeExcel(urlAndStatus);
	}
	/**
	 * hold anchor tag in list
	 * @return
	 */
	private List<String> anchorTagList(){
		List<String>finalAnchorList=new ArrayList<String>();
		List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
		for (WebElement webElement : anchorTagsList) {
			finalAnchorList.add(webElement.getAttribute("href"));
		}
		return finalAnchorList;
	}
	/**
	 * hold image tag in list
	 */
	private List<String> imageTagList(){
		List<String> finalImageList = new ArrayList<String>();
		List<WebElement> imageTags =driver.findElements(By.tagName("img"));
		for (WebElement webElement : imageTags) {
			finalImageList.add(webElement.getAttribute("href"));

		}
		return finalImageList;
	}

	/**
	 *  Merge two list into one list
	 */
	public List<String> mergeTwoList(){
		List<String>finalList=new ArrayList<String>();
		List<String>finalAnchorList=anchorTagList();
		List<String>finalImageList = imageTagList();
		finalAnchorList.addAll(finalImageList);
		for (String list : finalAnchorList) {
			if(StringUtils.isNotBlank(list)){
				finalList.add(list);
			}
		}
		return finalList;
	}

	public List<URLBean> verifyUrl(List<String>finalList){
		List<URLBean>list=new ArrayList<URLBean>();
		try{
			for (String url : finalList) {
			Response response =
					given().get(url)
					.then().extract().response();
			int statusCode=response.statusCode();
			list.add(new URLBean(url, statusCode));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;

	}
	
	public void writeExcel(List<URLBean> List) throws IOException{
	 	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Report");
        int rowCount = 0;
        Row row1 = sheet.createRow(rowCount);
        row1.createCell(0).setCellValue("URLList");
        row1.createCell(1).setCellValue("Status");
        	for (URLBean combinelist : List) {
        	 Row row = sheet.createRow(++rowCount);
             row.createCell(0).setCellValue(combinelist.getUrl());
             row.createCell(1).setCellValue(combinelist.getStatus());
		}
        FileOutputStream outputStream = new FileOutputStream("BrokenLinkReport.xlsx");
        workbook.write(outputStream);
        workbook.close();
}


}
