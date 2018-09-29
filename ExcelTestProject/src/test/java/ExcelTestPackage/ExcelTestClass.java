package ExcelTestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelTestClass {

	@Test
	public static void TestMethod() throws IOException

	{
		FileInputStream fis = new FileInputStream("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\DemoData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int numberOfSheets = wb.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("DataSheet 2")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				// System.out.println(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				Iterator<Cell> firstRowCells = firstRow.cellIterator();

				int col = 0;
				int k = 0;
				while (firstRowCells.hasNext()) {

					Cell cellfirst = firstRowCells.next();
					if (cellfirst.getStringCellValue().equalsIgnoreCase("TestCase")) {

						col = k;

					}

					k++;
				}

				while (rows.hasNext()) {
					Row newRows = rows.next();

					if (newRows.getCell(col).getStringCellValue().equalsIgnoreCase("Auckland")) {

						Iterator<Cell> newRowCells = newRows.cellIterator();
						while (newRowCells.hasNext()) {

							Cell CellValue = newRowCells.next();
							String CellValueString = CellValue.toString();

							System.out.println(CellValueString);

						}

					}

				}

			}

		}

		wb.close();
	}

}
