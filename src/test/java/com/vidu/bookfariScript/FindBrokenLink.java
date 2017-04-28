/**
 * 
 */
package bookfariScript;



/**
 * @author Vidushi Mishra
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author Vidushi Mishra
 *
 */
public class FindBrokenLink {

	
		private WebDriver driver;
		private int invalidLinksCount;

		@BeforeClass
		public void setUp() {

			System.setProperty("webdriver.chrome.driver", "E:\\vidushi\\BookFari\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://google.com");
		}

		@Test
		public void checkLink() throws IOException{
			FindBrokenLink findbrokenlink = new FindBrokenLink();
			/*List<URL> finalurllist =*/ findbrokenlink.validateInvalidLinks();
			//findbrokenlink.writeExcel(finalurllist);
		}
		
		
		
		
		
		public void validateInvalidLinks() {
			List<URLBean> tempurllist = new ArrayList<URLBean>();
			
			driver.findElements(By.tagName("a"));

			try {
				invalidLinksCount = 0;
				
				List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
				
				anchorTagsList.addAll(driver.findElements(By.tagName("img")));
				
				
				
				System.out.println("Total no. of links are " + anchorTagsList.size());
				
				for (WebElement anchorTagElement : anchorTagsList) {
					
					if (anchorTagElement != null) {
						
						String url = anchorTagElement.getAttribute("href");
						
						verifyURLStatus(url);
						
						tempurllist.add(new URLBean(url));
					}
				}
						
						for (URLBean url1 : tempurllist) {
							
							if (url1 != null && !url1.equals("javascript")) {
								

								writeExcel(tempurllist);
								
								

						}
							else {
								
								invalidLinksCount++;
							}
													
							
						} 
					
				

				System.out.println("Total no. of invalid links are "
						+ invalidLinksCount);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			/*return tempurllist;*/
		}

		@AfterClass
		public void tearDown() {
			if (driver != null)
				driver.quit();
		}

		public void verifyURLStatus(String URL) {

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(URL);
			try {
				HttpResponse response = client.execute(request);
				// verifying response code and The HttpStatus should be 200 if not,
				// increment invalid link count
				////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
				if (response.getStatusLine().getStatusCode() != 200)
				{
					invalidLinksCount++;
				    String status = "URL is Broken ";
				}
				else {
					String status = "URL is Not Broken";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void writeExcel(List<URLBean> urllist) throws IOException{
		 	XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Report");
	        int rowCount = 0;
	        Row row1 = sheet.createRow(rowCount);
            row1.createCell(0).setCellValue("HREF Links");
            row1.createCell(1).setCellValue("Status");
	        for (URLBean url : urllist) {
	        	 Row row = sheet.createRow(++rowCount);
	             row.createCell(0).setCellValue(url.getUrl());
	             row.createCell(1).setCellValue(url.getStatus());
			}
	        FileOutputStream outputStream = new FileOutputStream("BrokenLinkReport.xlsx");
	        workbook.write(outputStream);
	        workbook.close();
	}
	
	
}

   

