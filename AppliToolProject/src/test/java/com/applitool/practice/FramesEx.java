package com.applitool.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesEx {

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

	public int giveFrameCount(By byloc) {

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		int a = frames.size();

		System.out.println("size:" + a);

		int frameNum = -1;

		for (int i = 0; i < a; i++) {

			driver.switchTo().frame(i);

			List<WebElement> txt = driver.findElements(byloc);

			System.out.println("txt" + txt.size());

			if (txt.size() > 0) {

				frameNum = i;
				System.out.println(frameNum);
				break;
			}

			driver.switchTo().defaultContent();

		}

		return frameNum;

	}

	@Test
	public void testFrames() {

	

		driver.get("http://toolsqa.com/iframe-practice-page/");

		int number = giveFrameCount(By.linkText("Hello world!"));

		System.out.println(number);

		driver.switchTo().defaultContent();

		driver.switchTo().frame(number);

		driver.findElement(By.linkText("Hello world!")).click();

		// driver.switchTo().defaultContent();

		
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
