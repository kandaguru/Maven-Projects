package com.applitool.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Prompt {

	
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	


@Test
public void handlePrompt() throws InterruptedException {
	
	driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
	
	driver.findElement(By.xpath("//button[contains(text(),'Prompt Pop up')]")).click();
	
	
	Alert alert=driver.switchTo().alert();	
	
	alert.sendKeys("hellooo");
	
	Thread.sleep(6000);
	alert.accept();
}




}
