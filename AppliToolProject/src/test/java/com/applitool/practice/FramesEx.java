package com.applitool.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesEx {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.freecrm.com/index.html");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.switchTo().frame("intercom-borderless-frame");

		Actions action = new Actions(driver);

		JavascriptExecutor jse = ((JavascriptExecutor) driver);

		Thread.sleep(3000);

		action.moveToElement(driver.findElement(By.xpath("//span[@class='intercom-author-summary-name']"))).build()
				.perform();

		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']/span")).click();

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kbas663");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kbas663_01");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		// loginBtn.click();
		jse.executeScript("arguments[0].click();", loginBtn);

	}

	public int giveFrameCount(By byloc) throws InterruptedException {

		List<WebElement> frames = driver.findElements(By.tagName("frame"));

		int a = frames.size();

		System.out.println("size:" + a);

		int frameNum = -1;

		for (int i = 0; i < a; i++) {

			driver.switchTo().frame(i);

			List<WebElement> txt = driver.findElements(byloc);

			System.out.println("element size" + txt.size());

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
	public void testFrames() throws InterruptedException {

		// driver.switchTo().defaultContent();

		int number = giveFrameCount(By.xpath("//a[contains(text(),'Contacts')]"));

		System.out.println("Frame number" + number);

		driver.switchTo().defaultContent();

		driver.switchTo().frame(number);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// driver.findElement(By.linkText("Hello world!")).click();

		// driver.switchTo().defaultContent();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
