/**
 * 
 */
package com.bookfari.practise.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
}
