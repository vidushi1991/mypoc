/**
 * 
 */
package com.vidu.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.vidu.model.ISBN;

import bookfariscripts.BowkerISBNCheck;

/**
 * @author Vidushi Mishra
 *
 */
public class ISBNUtility {

	public  List<ISBN> readISBN() throws IOException {
		File src = new File("C:\\Users\\Vidushi Mishra\\workspace\\Bookfariautomation\\TestData\\BowkerUpdate_Feb_2016_New_InStock_ISBN1.xlsx");
		ArrayList<ISBN> li = new ArrayList<ISBN>();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		int rowcount = sheet1.getLastRowNum();
		for (int i=0; i<rowcount; i++)
		{
			String isbn =sheet1.getRow(i).getCell(0).getStringCellValue();
			li.add(new ISBN(isbn));
		}
		
		workbook.close();
		fis.close();
		return li;

	}
	public void writeExcel(List<ISBN> isbnlist) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Report.xlsx");
		int rowCount = 0;
		Row row1 = sheet.createRow(rowCount);
		row1.createCell(0).setCellValue("ISBN");
		row1.createCell(1).setCellValue("Result");	

		for (ISBN isbn1 : isbnlist) {
			Row row = sheet.createRow(++rowCount);
			row.createCell(0).setCellValue(isbn1.getIsbn());; 
			row.createCell(1).setCellValue(isbn1.getResult());

		}
		FileOutputStream outputStream = new FileOutputStream("TestReport1.xlsx");
		workbook.write(outputStream);
		workbook.close();
	}
/*public static void main(String[] args) throws IOException, InterruptedException {
	BowkerISBNCheck obj = new BowkerISBNCheck();
	List<ISBN>lst = obj.bowkerUpdate();
	
	ISBNUtility writeExcel = new ISBNUtility();
	writeExcel.writeExcel(lst);
		
	}*/


}
