package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String url;
	static String browser;

	public static void readConfig() throws IOException {

		String path = "src\\main\\java\\readconfig\\ReadConfig.properties";
		Properties prop = new Properties();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		prop.load(fr);
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");

	}

	public static WebDriver init() throws IOException {
		
		readConfig();
		
		if(browser.equalsIgnoreCase("chrome")) {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			
		System.setProperty("webdriver.gecko.driver", "Drivers\\chromedriver.exe");
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}

	public static void tearDown() {

		driver.close();
		driver.quit();

	}

}
