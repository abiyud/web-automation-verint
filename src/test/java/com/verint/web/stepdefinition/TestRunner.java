package com.verint.web.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/",glue = {"com.verint.web.stepdefinition"}, monochrome = true, plugin = {"pretty","junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json", "html:target/HtmlReports"})
public class TestRunner {}
