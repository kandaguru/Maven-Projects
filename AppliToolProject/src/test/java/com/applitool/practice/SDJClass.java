package com.applitool.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SDJClass {
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
	public static void Find_number_of_Broken_links() throws MalformedURLException, IOException {

		driver.get("https://www.google.com/?gws_rd=ssl");

		List<WebElement> listA = driver.findElements(By.tagName("a"));

		List<WebElement> listImg = driver.findElements(By.tagName("img"));

		System.out.println("Anchor tag =====>" + listA.size());
		System.out.println("Image Tag =========>" + listImg.size());

		List<WebElement> ListAll = new ArrayList<WebElement>();

		ListAll.addAll(listA);
		ListAll.addAll(listImg);

		List<WebElement> ListAll_without_null = new ArrayList<WebElement>();

		System.out.println("Total size =====>" + ListAll.size());

		for (int i = 0; i < ListAll.size(); i++) {

			if (!(ListAll.get(i).getAttribute("href") == null)
					&& (!(ListAll.get(i).getAttribute("href").contains("javascript")))) {

				ListAll_without_null.add(ListAll.get(i));

			}

		}

		System.out.println("Valid Links=========>" + ListAll_without_null.size());

		for (int j = 0; j < ListAll_without_null.size(); j++) {

			HttpURLConnection connection = (HttpURLConnection) new URL(ListAll_without_null.get(j).getAttribute("href"))
					.openConnection();

			connection.connect();
			String msg = connection.getResponseMessage();

			connection.disconnect();

			System.out.println(ListAll_without_null.get(j).getAttribute("href") + "===========>" + msg + "("
					+ connection.getResponseCode() + ")");

		}

	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
