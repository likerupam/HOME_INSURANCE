package com.insurance.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.insurance.util.DateTime;

@Test
public class Controller {
	static WebDriver driver;
	static Properties prop;
	static WebDriverWait wait;

	static ExtentReports reports;
	static ExtentHtmlReporter htmlReporter;
	static ExtentTest Logger;

	public void startTest() {

		reports = new ExtentReports(); // Creating extent report object

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "//test-output//" + DateTime.getTimeStamp() + ".html"); // Fetching
																											// file from
																											// directory
		reports.attachReporter(htmlReporter); // attaching report object to existing html file

		// Set the system info of the report
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Environment", "UAT");
		reports.setSystemInfo("Build number", "10.8.1");
		reports.setSystemInfo("Browser", "Firefox, Chrome and Edge");

		// Set the htmlReporter properties
		htmlReporter.config().setDocumentTitle("Travelers");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

	}

	@AfterSuite
	public void browserQuit() // Quit process
	{
		driver.quit();
		reports.flush();
	}

}
