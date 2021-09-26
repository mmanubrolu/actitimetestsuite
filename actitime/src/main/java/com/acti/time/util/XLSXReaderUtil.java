package com.acti.time.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.acti.time.model.LogingPageRequest;

public class XLSXReaderUtil {
	
	public static Row getRow(String fileName, String sheetName, int rowNum) {
		Row row =null;
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workbook=WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	public static int getRowCount(String fileName, String sheetName) {
		int rowCount=0;
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook workbook=WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			rowCount= sheet.getLastRowNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	public static int getColCount(Row row) {
		int colCount=0;
		colCount = row.getLastCellNum();
		return colCount;
	}
	
	public static String getCellData(Row row, int colNum) {
		String cellData = null;
		Cell cell = row.getCell(colNum);
		cellData = cell.getStringCellValue();
		return cellData;
	}
	
	public static ArrayList<Object[]> getLoginTestData(String fileName, String sheetName) {
	
		
		int rowCount = getRowCount(fileName, sheetName);
		
		ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
		int k=0;
		for(int i=1; i<=rowCount; i++) {
			Row row = getRow(fileName, sheetName, i);
			int colCount = getColCount(row);
			LogingPageRequest request = new LogingPageRequest();
			Object[] obj= new Object[1];
			for(int j=0; j<colCount; j++) {
				String cellData=getCellData(row, j);
				
				switch(j) {
				case 0:
					request.setTcId(cellData);
					break;
				case 1:
					request.setPriority(cellData);
					break;
				case 2 :
					request.setUserName(cellData);
					break;
				case 3:
					request.setPassword(cellData);
					break;
				}
			}
			obj[k] = request;
			arrayList.add(obj);
		}
		
		System.out.println("Array list size ::: " + arrayList.size());
		return arrayList;
	}
}
