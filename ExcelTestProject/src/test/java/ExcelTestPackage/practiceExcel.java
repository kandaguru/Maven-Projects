package ExcelTestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class practiceExcel {
@Test
	public static void getData() throws IOException {

		ArrayList<ArrayList<String>> a1 = new ArrayList<ArrayList<String>>();

		ArrayList<String> a = new ArrayList<String>();

		int col = 0;
		int k = 0;
		Object[][] arr = null;

		int row_num, col_num;

		FileInputStream fis = new FileInputStream("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\DemoData.xlsx");

		XSSFWorkbook workBook = new XSSFWorkbook(fis);

		int numberOfSheets = workBook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {

			if (workBook.getSheetName(i).equalsIgnoreCase("DataSheet 1")) {

				XSSFSheet sheet = workBook.getSheetAt(i);
				row_num = sheet.getPhysicalNumberOfRows();
				col_num = sheet.getRow(0).getPhysicalNumberOfCells();
				arr = new String[row_num][col_num];

				// System.out.println(workBook.getSheetName(i));

				Iterator<Row> rowIterator = sheet.iterator();

				Row firstRow = rowIterator.next();

				Iterator<Cell> cellIterator = firstRow.cellIterator();

				while (cellIterator.hasNext()) {

					Cell firstCellValue = cellIterator.next();
					// System.out.println(firstCellValue.getStringCellValue());

					if (firstCellValue.getStringCellValue().equalsIgnoreCase("Scenario")) {

						col = k;

					}

					k++;

				}

				while (rowIterator.hasNext()) {

					Row nextRow = rowIterator.next();
					Iterator<Cell> nextRowCellIterator = nextRow.cellIterator();

					if (nextRow.getCell(col).getStringCellValue().equalsIgnoreCase("Login")) {

						while (nextRowCellIterator.hasNext()) {

							Cell cellValue = nextRowCellIterator.next();

							for (int l = 0; l < row_num; l++) {

								for (int j = 0; j < col_num; j++) {

									if (cellValue.getCellTypeEnum() == CellType.STRING) {

										// a.add(cellValue.getStringCellValue());

										arr[l][j] = cellValue.getStringCellValue();

									} else {

										// a.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));

										arr[l][j] = NumberToTextConverter.toText(cellValue.getNumericCellValue());

									}

								}

							}

						}

						//a1.add(a);
						// arr=a.toArray(new String[a.size()]);

					}

				}

				// System.out.println(a1);
				

			}

		}
		
		workBook.close();
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
			
		}
		
		
		//return arr;

	}
}
