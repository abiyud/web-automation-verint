package com.verint.web.keyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.verint.web.driver.DriverUtill;

public class WebKeyword extends DriverUtill {
	protected int defaultTimeOut = 15;
	private WebDriverWait wait;

	public WebKeyword(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, defaultTimeOut);
	}

	public void openBrowser() {
		driver.manage().window();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void navigateTo(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
 
	public void delay(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void waitAndSetText(By by, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitAndClick(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PPSDS");
		}
	}
}
