/**
 * 
 */
package bookfariscripts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vidu.model.URL;

/**
 * @author Vidushi Mishra
 * @param <URLBean>
 *
 */
public class FindBrokenLinks<URLBean> extends Resources {


	@BeforeClass
	public void setUp() {

		System.setProperty(browserDriver, driverpath);
		driver = new ChromeDriver();ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		driver.get(liveUrl);
	}

	@Test
	public void checkLink() throws IOException{
		try {
			List<String> finallist= mergeList();
			List<URL> requested_URL=verifyUrl(finallist);
			writeExcel(requested_URL);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*
	 * Store all a tag url in final list
	 * @Return List<String> finalAnchorlist
	 */

	public List<String> anchorList(){
		List<String> finalAnchorlist = new ArrayList<String>();
		List<WebElement>anchorlist=driver.findElements(By.tagName("a"));
		for (WebElement anchorelement : anchorlist) {
			String url = anchorelement.getAttribute("href");
			if(StringUtils.isNotBlank(url))
			{
				if (!url.contains("javascript:void(0);"))
				{
					finalAnchorlist.add(url);
				}

			}

		}
		return finalAnchorlist;

	}
	/*
	 * Store all img tag url in final list
	 * @Return List<String> finalImagelist
	 */

	public List<String> imageList(){
		List<String> finalImagelist = new ArrayList<String>();
		List<WebElement>imagelist = driver.findElements(By.tagName("img"));
		for (WebElement imageElement : imagelist) {
			String url = imageElement.getAttribute("src");
			if (StringUtils.isNotBlank(url)) {

				if(!url.contains("javascript:void(0);"))
				{
					finalImagelist.add(url);
				}

			} 
		}
		return finalImagelist;
	}
	/*
	 * merge both list
	 * @Return List<String> finallist
	 */

	public List<String> mergeList(){
		List<String>list = new ArrayList<String>();

		list.addAll(anchorList());
		list.addAll(imageList());
		System.out.println(list.size());
		return list;
	}
	/*
	 * check the response code of url
	 * 
	 */

	public List<URL> verifyUrl(List<String>finalList){
		List<URL>list=new ArrayList<URL>();
		try{
			for (String url : finalList) {

				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(url);
				HttpResponse response = client.execute(request);
				int statusCode =response.getStatusLine().getStatusCode();
				// verifying response code the HttpStatus should be 200 if not,
				// increment as invalid images count
				if (statusCode != 200)
				{
					System.out.println("The broken or redirected" +url);
				}
				list.add(new URL(url, statusCode));	
				System.out.println(url  +"**********" + statusCode);
			} 

		}catch(Exception e){
			System.out.println(e);
		}
		return list;

	}

	public void writeExcel(List<URL> List) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Report");
		int rowCount = 0;
		Row row1 = sheet.createRow(rowCount);
		row1.createCell(0).setCellValue("URLList");
		row1.createCell(1).setCellValue("Status");
		for (URL combinelist : List) {
			Row row = sheet.createRow(++rowCount);
			row.createCell(0).setCellValue(combinelist.getUrl());
			row.createCell(1).setCellValue(combinelist.getStatus());
		}
		FileOutputStream outputStream = new FileOutputStream("BrokenLinkReport.xlsx");
		workbook.write(outputStream);
		workbook.close();
	}




	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}



}
