package ExcelTestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.google.common.graph.ElementOrder.Type;

public class TestDataDrivenNew {

	@Test
	public void tableTestnew() throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\DemoData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int numberOfSheets = wb.getNumberOfSheets();

		Object[][] data = null;

		for (int shno = 0; shno < numberOfSheets; shno++) {

			if (wb.getSheetName(shno).equalsIgnoreCase("DataSheet 2")) {

				XSSFSheet sheet = wb.getSheetAt(shno);

				// System.out.println();
				// System.out.println(sheet.getFirstRowNum());
				// System.out.println(sheet.getLastRowNum());

				int rowCount = sheet.getLastRowNum();

				for (int i = 0; i < rowCount; i++) {
					Row row = sheet.getRow(i + 1);

					for (int j = 0; j < row.getLastCellNum(); j++) {

						if (row.getCell(j).getCellTypeEnum() == CellType.STRING) {

							// String cellValue = row.getCell(j).getStringsCellValue();

							data = new Object[rowCount][row.getLastCellNum()];

							data[i][j] = row.getCell(j).toString();

							// System.out.println(data[i][j]);

							// a.add(cellValue);

						}

						else {

							// a.add(NumberToTextConverter.toText(row.getCell(j).getNumericCellValue()));

							data = new Object[rowCount][row.getLastCellNum()];
							data[i][j] = NumberToTextConverter.toText(row.getCell(j).getNumericCellValue());
							// System.out.println(data[i][j]);
						}

					}

				}

			}

		}
		
			
		System.out.println(data);
		wb.close();
		//return data;
	}

}
