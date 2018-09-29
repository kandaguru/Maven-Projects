package com.applitool.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import resources.AppliBase;

public class AppliLoginTC1 extends AppliBase {

	private static Eyes eyes = new Eyes();
	


	@BeforeTest
	public void openBrowser() throws IOException {

		InvokeBrowser();

	}

	@Test
	public void openURL() {
		
		
		Actions a = new Actions(driver);
	
		
		
		eyes.setApiKey("ZNG0V102QUBu9Ci9Hg2sQDxBRmTHOkG7tONR4h5pFDU8I110");

		eyes.open(driver, "Hello World!", "My first Selenium Java test!", new RectangleSize(800, 600)); // open a
																										// rectangle
																										// viewport

		driver.get("https://google.com");
		System.out.println(driver.getTitle());

		eyes.checkWindow("LandingPage!");
		driver.findElement(By.id("")).sendKeys("Selenium");;

		eyes.checkWindow("click!");

		eyes.close();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		eyes.abortIfNotClosed();

	}

}
