package com.verint.web.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verint.web.keyword.WebKeyword;

public class HomePage {
	public WebDriver driver;
	public WebKeyword webKeyword;

	By btnSearch = By.xpath("//li/button[contains(@class,'button--search')]");
	By inputSearch = By.cssSelector("input#search-input--desktop");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.webKeyword = new WebKeyword(driver);
	}

	public void clickBtnSearch() {
		webKeyword.waitAndClick(btnSearch);
	}

	public void setTextSearch(String text) {
		webKeyword.waitAndSetText(inputSearch, text);
	}

	public List<WebElement> getListTitle(String text) {
		return driver.findElements(By.xpath("//*[contains(@class,'gray-card__heading h5') and contains(text(),'" + text.substring(0, 1).toUpperCase() + text.substring(1) + "')]"));
	}
}
