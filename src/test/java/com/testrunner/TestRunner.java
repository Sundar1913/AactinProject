package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import com.base.BaseClass;
import com.report.ReportClass;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = (""), features = "src\\test\\resources", snippets = SnippetType.CAMELCASE, glue = "com.stepdefinition", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:target\\Output.html","json:target\\Output.json" })

public class TestRunner extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		ReportClass.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonpath"));

	}

}
