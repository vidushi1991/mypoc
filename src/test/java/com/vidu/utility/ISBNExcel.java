/**
 * 
 */
package com.bookfari.practise.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


/**
 * @author Vidushi Mishra
 *
 */
public class ISBNExcel {
	
	public List<String> readISBN() throws Exception{
		File src = new File("E:\\vidushi\\BookfariHome\\isbnlist1.xlsx");
		List<String>li =new ArrayList<String>();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 =wb.getSheetAt(0);
		int rowCount =sheet1.getLastRowNum();
		for(int i=0;i<rowCount;i++){
			String isbn =sheet1.getRow(i).getCell(0).getStringCellValue();
			li.add(isbn);

		}

		wb.close();
		return li;
		
}
	
}