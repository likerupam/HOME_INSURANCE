package com.insurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.ExcelData;
import com.insurance.util.Screenshot;

@Test
public class HomeBasics extends Controller {

	String[] value = new String[32];
	int index;


	public void homeBasics() throws Exception {
		
		Logger = reports.createTest("Home Basics Page Test");
		
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
			String errorMessage = driver.findElement(By.xpath(prop.getProperty("yearBuiltErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage+ " yearBuiltErrorMsg ");

			String errorMessage1 = driver.findElement(By.xpath(prop.getProperty("purchaseDateErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage1+ " purchaseDateErrorMsg ");


			String errorMessage2 = driver.findElement(By.xpath(prop.getProperty("squareFootErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage2+ " squareFootErrorMsg");


			String errorMessage3 = driver.findElement(By.xpath(prop.getProperty("foundationErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage3 + " foundationErrorMsg");
	

			value = ExcelData.readExcel("Input");

			driver.findElement(By.xpath(prop.getProperty("yearBuilt"))).sendKeys("2008");

			driver.findElement(By.xpath(prop.getProperty("purchaseMonth"))).sendKeys("07");

			driver.findElement(By.xpath(prop.getProperty("purchaseYear"))).sendKeys("2009");

			driver.findElement(By.xpath(prop.getProperty("policyStartMonth"))).sendKeys("12");

			driver.findElement(By.xpath(prop.getProperty("policyStartDay"))).sendKeys("10");

			driver.findElement(By.xpath(prop.getProperty("policyStartYear"))).sendKeys("2020");

			driver.findElement(By.xpath(prop.getProperty("squareFoot"))).sendKeys("1050");

			if (value[0].equalsIgnoreCase("Slab"))
				index = 1;
			else if (value[0].equalsIgnoreCase("Crawl space"))
				index = 2;
			else if (value[0].equalsIgnoreCase("Basement"))
				index = 3;
			else if (value[0].equalsIgnoreCase("Open/Raised"))
				index = 4;
			
			Logger.log(Status.INFO,"Foundation type fetched successfully from excel...");

			Thread.sleep(2000);
			Select dropp = new Select(driver.findElement(By.xpath(prop.getProperty("foundation"))));
			dropp.selectByIndex(index);

			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking
																											// screenshot

			driver.findElement(By.xpath(prop.getProperty("radioNo1"))).click();

			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		} catch (Exception e) {
			System.out.println("Automation terminated due to invalid details... \nEnter valid details");
		}

		Logger.log(Status.PASS,"Home Basics Page Verified...");
	}

}
