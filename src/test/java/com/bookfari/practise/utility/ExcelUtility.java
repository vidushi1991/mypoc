/**
 * 
 */
package com.bookfari.practise.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bookfari.practise.model.Customer;

/**
 * @author Vidushi Mishra
 *
 */
public class ExcelUtility {

	/**
	 * Read cell value from Excel Sheet
	 * @throws IOException 
	 */
	public List<Customer> readExcel() throws IOException{
		String excelFilePath = "E:\\vidushi\\BookfariAutomation\\Testdata\\Testdata1.xlsx";
		List<Customer>list=new ArrayList<Customer>();
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		for (Row row : firstSheet) {
			String userName=row.getCell(0).getStringCellValue();
			String password=row.getCell(1).getStringCellValue();
			list.add(new Customer(userName, password));
		}
		workbook.close();
		inputStream.close();
		return list;
	}
	
	/**
	 * Write excel Data in new Excel File... 
	 * @throws IOException 
	 */
	public void writeExcel(List<Customer> customerList) throws IOException{
		 	XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Report");
	        int rowCount = 0;
	        Row row1 = sheet.createRow(rowCount);
            row1.createCell(0).setCellValue("UserName");
            row1.createCell(1).setCellValue("Password");
            row1.createCell(2).setCellValue("Result");	 
	        for (Customer customer : customerList) {
	        	 Row row = sheet.createRow(++rowCount);
	             row.createCell(0).setCellValue(customer.getUserName());
	             row.createCell(1).setCellValue(customer.getPassword());
	             row.createCell(2).setCellValue(customer.getResult());	             
			}
	        FileOutputStream outputStream = new FileOutputStream("TestReport.xlsx");
	        workbook.write(outputStream);
	}
}
