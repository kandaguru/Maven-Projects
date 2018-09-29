package com.dataprovider;

import com.utility.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelTestPackage.*;

public class DataProviderEx {

	
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test(dataProvider = "dataproviderfunc")
	public void loginVerification(String Scenario, String Username, String Lastname, String email) {

		System.out.println(Username + "  " + email);

//		write login code and provide assertion

	}

	@DataProvider
	public Object[][] dataproviderfunc() throws IOException {

		Object[][] object = DriveDataExcel.getData();

		return object;
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}




//
//@Test
//public void OperationalMethod() {
//	try {
//		// Execute a query
//		stmt = conn.createStatement();
//		resultSet = stmt.executeQuery("select * from sampletable");
//
//		// Get the all row of UI Table
//		List<WebElement> lstTr = driver.findElement(By.id("grdData")).findElements(By.tagName("tr"));
//
//		// Index for Row
//		int rowCount = 0;
//
//		// Count of Matched Column
//		int matchColumnCount = 0;
//
//		// Count of Matched Row
//		int matchRowCount = 0;
//
//		System.out.println("Row Count => " + lstTr.size());
//
//		// Extract the data from Table
//		while (resultSet.next()) {
//
//		
//		//(rowCount + 1) because first row is a header row , Get all the columns from a particular row
//		List<WebElement> lstTd = lstTr.get(rowCount + 1).findElements(By.tagName("td"));
//		System.out.println("Cloumn Count => " + lstTd.size());
//
//		for (int j = 0; j < lstTd.size(); j++) {
//			String uiCell = lstTd.get(j).getText();
//			System.out.println("UI Cell Data => " + uiCell);
//
//			/*
//			* (j + 1) in the resultSet => because index is start from 1
//			* and here loop is starting from 0
//			*/
//			String dbCell = resultSet.getString(j + 1);
//			System.out.println("DB Cell Data => " + dbCell);
//
//			// Comparison between both string
//			if (uiCell.trim().equalsIgnoreCase(dbCell.trim())) {
//				matchColumnCount++;
//			}
//		}
//			
//		if (matchColumnCount == lstTd.size()) {
//			matchRowCount++;
//			System.out.println("========ROW MATCHED==========");
//		}
//
//		// Set 'matchColumnCount' to 0 for next row	matchColumnCount = 0;
//			rowCount++;
//		}
//			assertEquals(matchRowCount, rowCount, "UI Table is the exact copy of Database Table");
//			
//	} catch (Exception e) {
//			System.out.println(e);
//	}
//}
//
//
//




//public class collectiondemo {
//
//public static void main(String[] args) { // TODO Auto-generated method stub
//
//int a[] ={ 4,5,5,5,4,6,6,9,4}; // Print unique number from the list- Amazon  //print the string in reverse 
//ArrayList<Integer>ab =new ArrayList<Integer>(); 
//for(int i=0;i<a.length;i++) { 
//	int k=0; 
//	if(!ab.contains(a[i])) {
//		ab.add(a[i]);
//		k++; 
//		for(int j=i+1;j<a.length;j++) { 
//			if(a[i]==a[j]) {
//				k++; }
//			} 
//		// System.out.println(a[i]); 
//		//System.out.println(k); 
//		if(k==1) 
//			System.out.println(a[i]+"is unique number"); 
//		} 
//	} 
//}
//		
//	
//}
