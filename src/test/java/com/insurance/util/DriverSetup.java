package com.insurance.util;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class DriverSetup {

	public static WebDriver driver;
	ExtentReports reports;
	ExtentTest Logger;
	static Scanner sc = new Scanner(System.in);

	public static WebDriver getDriver() {
		System.out.println("Available Browers :\n1. Chrome\n2. Opera\n3. Edge\n\nSelect Option :"); // Suggesting user to choose a browser
		int option = sc.nextInt(); // User input stored

		if (option == 1) // Opting for chrome
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe"); // Fetching driver
			ChromeOptions options = new ChromeOptions(); // Getting access to chrome options
			options.addArguments("--disable-notifications"); // Disabling notifications
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		} else if (option == 2) // Opting for opera
		{
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe"); // Fetching driver
			driver = new OperaDriver();
			driver.manage().window().maximize(); // Maximizing window

		} else if (option == 3) // Opting for Edge
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe"); // Fetching driver
			driver = new EdgeDriver();
			driver.manage().window().maximize(); // Maximizing window

		}

		return driver;

	}

}
