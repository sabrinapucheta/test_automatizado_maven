package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private enum browsers {
		EXPLORER, FIREFOX, CHROME
	};

	public static WebDriver levantarBrowser(WebDriver driver, String browsername, String URL) {
		switch (browsers.valueOf(browsername)) {
		case CHROME: {
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\recursos\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX: {
			System.setProperty("webdriver.geckodriver.driver", "src\\resources\\recursos\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case EXPLORER: {
			System.setProperty("webdriver.msedgedriver.driver", "src\\resources\\recursos\\msedgedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		
		
		return driver;
	}
}
