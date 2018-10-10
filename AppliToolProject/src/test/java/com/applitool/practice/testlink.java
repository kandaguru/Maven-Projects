package com.applitool.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testlink {

	
	public static void main(String args[]) {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		driver.get("https://saas.test.auckland.ac.nz/perfectshop");
		driver.findElement(By.id("username")).sendKeys("kbas663");
		driver.findElement(By.id("password")).sendKeys("Kbas663_01");
		driver.findElement(By.id("_eventId_proceed")).click();
		
		By linktest1=By.linkText("Winc (formerly Staples)");
		
		wait.until(ExpectedConditions.elementToBeClickable(linktest1));
		driver.findElement(linktest1).click();
	}
}
