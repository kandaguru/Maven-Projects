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

public class ExcelTestTwo {

	@Test
	public static void testMethodTwo() throws IOException {
		
		ArrayList<String> a= new ArrayList();

		FileInputStream fis = new FileInputStream("C:\\Users\\kbas663\\Desktop\\Test Stratergy\\DemoData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int numOfSheets = wb.getNumberOfSheets();

		for (int i = 0; i < numOfSheets; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("DataSheet 1")) {
				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

				Row firstRow = rows.next();
				Iterator<Cell> firstRowCells = firstRow.cellIterator();
				int col = 0;
				int k = 0;
				while (firstRowCells.hasNext()) {

					Cell firstRowCellValue = firstRowCells.next();
					if (firstRowCellValue.getStringCellValue().equalsIgnoreCase("TCs")) {

						col = k;

					}
					
				}

				
				while(rows.hasNext()) {
					Row newRow=rows.next();
					//Iterator<Cell> newRowCells = newRow.cellIterator();
					
					if(newRow.getCell(col).getStringCellValue().equalsIgnoreCase("Selenium")){
						Iterator<Cell> newRowCells = newRow.cellIterator();
						
						while(newRowCells.hasNext()) {
							
							Cell newRowCell=newRowCells.next();
							//System.out.println(newRowCell.toString());
							
							if(newRowCell.getCellTypeEnum()==CellType.STRING)
							{
							a.add(newRowCell.getStringCellValue());
							}
							else {
								
								
								a.add(NumberToTextConverter.toText(newRowCell.getNumericCellValue()));
								
							}
							
						}
						
						
					}
					
					
		
				}
				
				
				
				
				
				
				
			}

		}
		System.out.println(a);

	}
}
