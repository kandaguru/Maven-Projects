package ExcelTestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestExcelPOI {

	@Test
	public void DataTest() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\DemoData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int Sheets = wb.getNumberOfSheets();

		ArrayList<String> arr = new ArrayList<String>();

		int col = 0;
		int k = 0;

		for (int sheetNumber = 0; sheetNumber < Sheets; sheetNumber++) {

			if (wb.getSheetName(sheetNumber).equalsIgnoreCase("DataSheet 1")) {

				XSSFSheet sheet = wb.getSheetAt(sheetNumber);

				int rowcount = sheet.getLastRowNum();
				// System.out.println("Row Count"+rowcount);

				for (int i = 0; i < rowcount; i++) {

					Row row = sheet.getRow(i);
					int cellCount = row.getLastCellNum() - row.getFirstCellNum();
					// System.out.println("CellCount"+cellCount);

					while (k < cellCount) {

						if (row.getCell(k).toString().equalsIgnoreCase("TCs")) {

							col = k;

						}

						k++;
					}

					int a = 0;
					
					while (a < cellCount) {

						if (row.getCell(col).getStringCellValue().equalsIgnoreCase("Selenium")) {

							if (row.getCell(a).getCellTypeEnum() == CellType.STRING) {
								
								arr.add(row.getCell(a).getStringCellValue());
								
								
								
							} else {

								arr.add(NumberToTextConverter.toText(row.getCell(a).getNumericCellValue()));

							}

						}
						a++;
					}

				}

			}

		}

		System.out.println(arr);
	}

}
