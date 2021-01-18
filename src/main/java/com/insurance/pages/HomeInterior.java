package com.insurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.ExcelData;
import com.insurance.util.Screenshot;

@Test
public class HomeInterior extends Controller {

	String[] value = new String[32];
	int index, bathIndex, halfbathIndex, kitchenIndex, heatSrcIndex, fireIndex;

	
	public void homeInterior() throws Exception {
		
		Logger = reports.createTest("Home Interior Test");
		
		try {

			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
			String errorMessage = driver.findElement(By.xpath(prop.getProperty("heatSourceErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage+ " heat source");
			
			value = ExcelData.readExcel("Input");

			String bath1 = value[1];

			int bath = Integer.parseInt(bath1);

			if (bath == 1)
				bathIndex = 0;
			else if (bath == 2)
				bathIndex = 1;
			else if (bath == 3)
				bathIndex = 2;
			else if (bath == 4)
				bathIndex = 3;
			else if (bath == 5)
				bathIndex = 4;
			else if (bath == 6)
				bathIndex = 5;

			Select select1 = new Select(driver.findElement(By.xpath((prop.getProperty("fullBaths")))));
			select1.selectByIndex(bathIndex);

			for (int i = 0; i <= bathIndex; i++) {
				Select select = new Select(
						driver.findElement(By.xpath("//select[@id=\"fullBathQuality" + (i + 1) + "\"]")));
				select.selectByVisibleText(value[2 + i]);
			}
			Logger.log(Status.INFO,"Full Bath selected...");

			/***********
			 * Half Bath
			 ***********/
			value = ExcelData.readExcel("Input");

			String bath2 = value[8];
			int halfbath = Integer.parseInt(bath2);

			if (halfbath == 0)
				halfbathIndex = 0;
			else if (halfbath == 1)
				halfbathIndex = 1;
			else if (halfbath == 2)
				halfbathIndex = 2;
			else if (halfbath == 3)
				halfbathIndex = 3;
			else if (halfbath == 4)
				halfbathIndex = 4;
			else if (halfbath == 5)
				halfbathIndex = 5;
			else if (halfbath == 6)
				halfbathIndex = 6;

			Select select2 = new Select(driver.findElement(By.xpath((prop.getProperty("halfBaths")))));
			select2.selectByIndex(halfbathIndex);

			if (halfbathIndex == 0) {
				Select select = new Select(driver.findElement(By.xpath("//select[@id=\"halfBathQuality1\"]")));
				select.selectByVisibleText(value[9]);
			}
			for (int i = 0; i < halfbathIndex; i++) {
				Select select = new Select(
						driver.findElement(By.xpath("//select[@id=\"halfBathQuality" + (i + 1) + "\"]")));
				select.selectByVisibleText(value[9 + i]);
			}
			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking
																											// screenshot
			Logger.log(Status.INFO,"Half Bath selected...");
			/*********
			 * Kitchen
			 *********/
			value = ExcelData.readExcel("Input");

			String kit = value[15];
			int numKit = Integer.parseInt(kit);

			if (numKit == 1)
				kitchenIndex = 0;
			else if (numKit == 2)
				kitchenIndex = 1;
			else if (numKit == 3)
				kitchenIndex = 2;
			else if (numKit == 4)
				kitchenIndex = 3;

			Select select3 = new Select(driver.findElement(By.xpath((prop.getProperty("kitchen")))));
			select3.selectByIndex(kitchenIndex);

			for (int i = 0; i <= kitchenIndex; i++) {
				Select select = new Select(
						driver.findElement(By.xpath("//select[@id=\"kitchenQual" + (i + 1) + "\"]")));
				select.selectByVisibleText(value[16 + i]);
			}

			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking
																											// screenshot
			Logger.log(Status.INFO,"Kitchen selected...");
			/*************
			 * Heat Source
			 *************/
			if (value[20].equalsIgnoreCase("Central-Electric"))
				heatSrcIndex = 1;
			else if (value[20].equalsIgnoreCase("Central-Gas"))
				heatSrcIndex = 2;
			else if (value[20].equalsIgnoreCase("Central-Oil"))
				heatSrcIndex = 3;
			else if (value[20].equalsIgnoreCase("Other"))
				heatSrcIndex = 4;
			else if (value[20].equalsIgnoreCase("None"))
				heatSrcIndex = 5;

			for (int i = 0; i < heatSrcIndex; i++) {
				Select select = new Select(driver.findElement(By.xpath((prop.getProperty("heatSource")))));
				select.selectByIndex(heatSrcIndex);
			}
			Logger.log(Status.INFO,"Heat source selected...");
			/************
			 * Fire Place
			 ************/
			String fire = value[21];
			int fireplc = Integer.parseInt(fire);

			if (fireplc == 0)
				fireIndex = 0;
			else if (fireplc == 1)
				fireIndex = 1;
			else if (fireplc == 2)
				fireIndex = 2;
			else if (fireplc == 3)
				fireIndex = 3;
			else if (fireplc == 4)
				fireIndex = 4;
			else if (fireplc == 5)
				fireIndex = 5;

			Select select = new Select(driver.findElement(By.xpath((prop.getProperty("firePlace")))));
			select.selectByIndex(fireIndex);

			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
			Logger.log(Status.INFO,"Fire place selected...");
			
			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking
																											// screenshot
		} catch (Exception e) {
			System.out.println("Automation terminated due to invalid details... \nEnter valid details");
		}
		
		Logger.log(Status.PASS,"Home Interior Page Verified...");

	}

}
