package com.verint.web.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtill {
	public static WebDriver driver;

	public WebDriver initializeDriver() {
		String browserName = "chrome";
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/project/verint-web/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
}
