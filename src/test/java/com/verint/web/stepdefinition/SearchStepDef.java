package com.verint.web.stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verint.web.driver.DriverUtill;
import com.verint.web.keyword.WebKeyword;
import com.verint.web.pageobject.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchStepDef {
	DriverUtill driverUtill = new DriverUtill();
	WebDriver driver = driverUtill.initializeDriver();
	WebKeyword webKeyword = new WebKeyword(driver);
	HomePage homePage = new HomePage(driver);

	@Given("^user open verint website")
	public void user_open_verint_website() throws InterruptedException {
		String url = "https://www.verint.com/";
		webKeyword.navigateTo(url);
	}

	@When("^click button search")
	public void click_button_search() {
		homePage.clickBtnSearch();
	}

	@When("^user search (.*)$")
	public void user_search(String text) {
		homePage.setTextSearch(text);
	}

	@Then("^page shows articles contain (.*)$")
	public void page_shows_articles_contain(String text) throws InterruptedException {
		Thread.sleep(10000);
		String[] arrStr = text.split(" ");
		for (String str : arrStr) {
			List<WebElement> elements = homePage.getListTitle(str);
			Assert.assertNotNull(elements);
		}
		webKeyword.closeBrowser();
	}

}
