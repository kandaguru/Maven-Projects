package com.applitool.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HighlightElem {

public static WebDriver driver;	
	
	@Test
	public void loginSample() {
		
		driver.get("http://toolsqa.com/automation-practice-form/#go");
		
		WebElement jseDrop=driver.findElement(By.id("continents"));
		
	}
	
	
	public static void flash(WebDriver driver,WebElement elem) {
		
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		
		
		

		
	}
	
	
	
}
