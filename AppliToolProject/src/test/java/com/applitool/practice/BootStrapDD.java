package com.applitool.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootStrapDD {

	
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
	public static void testBootStrap() {
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en-GB&flowName=GlifWebSignIn&flowEntry=SignUp");


		By downArrow=By.xpath("//div[@class='TquXA']");
		driver.findElement(downArrow).click();
		
		By listofItems=By.xpath("//div[@role='listbox']//div//div//div//content[@class='vRMGwf oJeWuf']");
		
		List <WebElement> list = driver.findElements(listofItems);
		
		for(int i=0;i<list.size();i++) {
			
			System.out.println(list.get(i).getText());	
			
		}
		
		
		
	}
	
	
	
	
	
}
