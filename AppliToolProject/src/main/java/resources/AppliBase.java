package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppliBase {

	public static WebDriver driver;

	public static Properties prop = new Properties();

	public static Logger log = LogManager.getLogger(AppliBase.class.getName());

	public void InvokeBrowser() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\kbas663\\Maven Projects-Sel\\AppliToolProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kbas663\\Downloads\\eclips_selenium\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else {

			log.fatal("No Browser");
		}

	}
}