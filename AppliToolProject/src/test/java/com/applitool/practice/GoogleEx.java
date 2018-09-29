package com.applitool.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleEx {

	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void autoSugestuveDropDown() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		
		
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("test");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.DOWN);	
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.DOWN);	
		
		Thread.sleep(500);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		String text=(String) jse.executeScript("return document.getElementById(\"lst-ib\").value");
		
		while(!text.equalsIgnoreCase("test")){
			
			Thread.sleep(500);
			
			text=(String) jse.executeScript("return document.getElementById(\"lst-ib\").value");
			driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.DOWN);	
			Thread.sleep(500);
			//text=(String) jse.executeScript("return document.getElementById(\"lst-ib\").value");
			System.out.println(text);
			}
		
		
		
		
		 
		
		
		/*
		
		int i=0;
		while(!text.equalsIgnoreCase("test and tag")) {
			
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys(Keys.DOWN);	
		Thread.sleep(500);
		text=(String) jse.executeScript("return document.getElementById(\"lst-ib\").value");
		System.out.println(text);
		i++;
		
		if(i>20) {
			
			break;
		}
		
		
		}
	*/
		
}
}