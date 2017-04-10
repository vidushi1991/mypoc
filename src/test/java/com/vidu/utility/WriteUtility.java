/**
 * 
 */
package com.vidu.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vidu.model.Link;

/**
 * @author Vidushi Mishra
 *
 */
public class WriteUtility {
	
	public void writeExcel(List<Link> linklst) throws IOException{
	 	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Alllinks.xlsx");
        int rowCount = 0;
        Row row1 = sheet.createRow(rowCount);
        row1.createCell(0).setCellValue("Links");
        row1.createCell(1).setCellValue("Status");
        for (Link lst : linklst) {
        	 Row row = sheet.createRow(++rowCount);
             row.createCell(0).setCellValue(lst.getLink());
             row.createCell(1).setCellValue(lst.getStatus());
		}
        FileOutputStream outputStream = new FileOutputStream("TestReport.xlsx");
        workbook.write(outputStream);
        workbook.close();
}


}
