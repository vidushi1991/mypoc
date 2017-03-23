/**
 * 
 */
package com.bookfari.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Vidushi Mishra
 *
 */
public class ExcelUtilityisbn {

	/**
	 * Read cell value from Excel Sheet
	 * @return cell value
	 * @throws IOException 
	 */
	public List<String> readExcel() throws IOException{
		String excelFilePath = "E:\\vidushi\\BookfariAutomation\\Testdata\\Testdata.xlsx";
		List<String>list=new ArrayList<String>();
		String isbnValue="";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		while(iterator.hasNext()){
			Row nextRow=iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while(cellIterator.hasNext()){
				Cell cell =cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					list.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
			}
		}
		workbook.close();
		inputStream.close();
		return list;
	}
}

