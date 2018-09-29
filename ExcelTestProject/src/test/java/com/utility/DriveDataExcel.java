package com.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.dataDrivenExcel.Xls_Reader;

public class DriveDataExcel {

	public static Xls_Reader reader;

	public static Object[][] getData() {

		String SheetName = "Sheet1";

		reader = new Xls_Reader("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\Data.xlsx");
		
		//C:\Users\kbas663\Desktop\Test Stratergy

		int rowCount = reader.getRowCount(SheetName);
		System.out.println(rowCount);

		int colCount = reader.getColumnCount(SheetName);
		System.out.println(colCount);

		Object[][] str = new Object[rowCount-1][colCount];

		for (int i = 2; i <= rowCount; i++) {

			for (int j = 0; j < colCount; j++) {

				str[i-2][j] = reader.getCellData(SheetName, j, i);

			}

		}

		return str;

	}
	
	
	
	
	
	

//	public static List<List<String>> pushToList(Object[][] object) ===> push a 2d array into arraylist
	// {
//		
//		//String [][]array2D = {{"A", "B"}, {"C", "D"}, {"E", "F"}};
//    
//	List<List<String>> arrayList = new ArrayList<List<String>>();
//    for (int i = 0; i < object.length; i++) {
//        List<String> eachRecord = new ArrayList<String>();
//        for (int j = 0; j < object[i].length; j++) {
//            eachRecord.add(String.valueOf(object[i][j]));
//        }
//        arrayList.add(eachRecord);
//    
//    
//    }
//	
//	return arrayList;
//	
//	}

}
