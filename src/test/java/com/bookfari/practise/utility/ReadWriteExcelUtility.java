/**
 * 
 */
package com.vidu.utility;

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

import com.vidu.model.Customer;

/**
 * @author Vidushi Mishra
 *
 */
public class ReadWriteExcelUtility {

	public List<Customer> readExcelData() throws  Exception{

		String path ="D:/Vidushi Mishra/Bookfari/Selenium_Test_Data/TestData/Customer_Credential_Test_Data.xlsx";
		List<Customer> list =new ArrayList<Customer>();
		FileInputStream fis = new FileInputStream(new File(path));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet =workbook.getSheetAt(0);

		for (Row row : sheet) {
			String userName =row.getCell(0).getStringCellValue();
			String password =row.getCell(1).getStringCellValue();
			list.add(new Customer(userName, password));
		}

		workbook.close();
		fis.close();
		return list;

	}
	public void writeExcelUtility(List<Customer> customerlist) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Report");
		int rowcount =0;
		Row row1 =sheet.createRow(rowcount);
		row1.createCell(0).setCellValue("UserName");
		row1.createCell(1).setCellValue("Password");
		row1.createCell(2).setCellValue("Result");
		for (Customer cust : customerlist) {
			Row row =sheet.createRow(++rowcount);
			row.createCell(0).setCellValue(cust.getUserName());
			row.createCell(1).setCellValue(cust.getPassword());
			row.createCell(2).setCellValue(cust.getResult());

		}
		FileOutputStream outputstream = new FileOutputStream("Login_Report.xlsx");
		 workbook.write(outputstream);
	}

	public static void main(String args[]) throws Exception{
		ReadWriteExcelUtility rd = new ReadWriteExcelUtility();
		List<Customer> output =rd.readExcelData();
		rd.writeExcelUtility(output);
	
		
	}
}


