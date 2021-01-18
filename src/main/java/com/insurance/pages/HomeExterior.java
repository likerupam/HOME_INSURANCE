package com.insurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.ExcelData;
import com.insurance.util.Screenshot;

@Test
public class HomeExterior extends Controller {

	String[] value = new String[32];
	int floorIndex, propIndex, sidingIndex, roofIndex, roofTypeIndex, garageTypeIndex, carsIndex, windowTypeIndex;

	
	public void homeExterior() throws Exception {
		
		Logger = reports.createTest("Home Exterior Test");
		
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
			String errorMessage = driver.findElement(By.xpath(prop.getProperty("constErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage+" construction type");
	

			String errorMessage1 = driver.findElement(By.xpath(prop.getProperty("roofErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage1+" roof");
			

			String errorMessage2 = driver.findElement(By.xpath(prop.getProperty("yearRoofErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage2+" yr roof");
	

			String errorMessage3 = driver.findElement(By.xpath(prop.getProperty("garageErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage3+" garage");


			String errorMessage4 = driver.findElement(By.xpath(prop.getProperty("windowErrorMsg"))).getText();
			Logger.log(Status.ERROR,errorMessage4+" window");
		

			value = ExcelData.readExcel("Input");

			String radioButton = value[30];

			if (radioButton.equalsIgnoreCase("Yes")) {

				driver.findElement(By.xpath(prop.getProperty("radioYes"))).click();
			} else if (radioButton.equalsIgnoreCase("No")) {

				driver.findElement(By.xpath(prop.getProperty("radioNo"))).click();
			}

			String stories1 = value[22];
			double stories = Double.parseDouble(stories1);

			if (stories == 1)
				floorIndex = 0;
			else if (stories == 1.5)
				floorIndex = 1;
			else if (stories == 2)
				floorIndex = 2;
			else if (stories == 2.5)
				floorIndex = 3;
			else if (stories == 3)
				floorIndex = 4;
			else
				floorIndex = 5;

			Select sel1 = new Select(driver.findElement(By.xpath(prop.getProperty("floor"))));
			sel1.selectByIndex(floorIndex);

			if (value[23].equalsIgnoreCase("Frame"))
				propIndex = 1;
			else if (value[23].equalsIgnoreCase("Masonry"))
				propIndex = 2;
			else if (value[23].equalsIgnoreCase("Concrete"))
				propIndex = 3;
			else if (value[23].equalsIgnoreCase("Steel"))
				propIndex = 4;
			else if (value[23].equalsIgnoreCase("Modular"))
				propIndex = 5;
			else if (value[23].equalsIgnoreCase("Log Home"))
				propIndex = 6;
			else if (value[23].equalsIgnoreCase("Mobile or Manufactured"))
				propIndex = 7;

			Select constructionDropdown = new Select(driver.findElement(By.xpath(prop.getProperty("consType"))));
			constructionDropdown.selectByIndex(propIndex);

			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking
																											// screenshot
			Logger.log(Status.INFO,"Construction type selected...");
			// TYPE OF SIDING

			if (value[24].equalsIgnoreCase("Vinyl"))
				sidingIndex = 1;
			else if (value[24].equalsIgnoreCase("Aluminium/Steel"))
				sidingIndex = 2;
			else if (value[24].equalsIgnoreCase("Clapboard"))
				sidingIndex = 3;
			else if (value[24].equalsIgnoreCase("Wood"))
				sidingIndex = 4;
			else if (value[24].equalsIgnoreCase("Brick/Masonary Veneer"))
				sidingIndex = 5;
			else if (value[24].equalsIgnoreCase("Stone Veener"))
				sidingIndex = 6;
			else if (value[24].equalsIgnoreCase("Stucco"))
				sidingIndex = 7;
			else if (value[24].equalsIgnoreCase("Cement Fiber"))
				sidingIndex = 8;
			else if (value[24].equalsIgnoreCase("Adobe"))
				sidingIndex = 9;
			else if (value[24].equalsIgnoreCase("Asbestos"))
				sidingIndex = 10;
			else if (value[24].equalsIgnoreCase("Exterior Insulation"))
				sidingIndex = 11;
			else if (value[24].equalsIgnoreCase("Other"))
				sidingIndex = 12;

			driver.findElement(By.xpath(prop.getProperty("siding"))).click();

			driver.findElement(By.xpath(("//div[@optionnumber='" + sidingIndex + "']"))).click();

			driver.findElement(By.xpath(prop.getProperty("sidingConfirm"))).click();

			Logger.log(Status.INFO,"Siding selected...");
			
			// SHAPE OF ROOF
			driver.findElement(By.xpath(prop.getProperty("roof"))).click();

			if (value[25].equalsIgnoreCase("Gable"))
				roofIndex = 1;
			else if (value[25].equalsIgnoreCase("Hip"))
				roofIndex = 2;
			else if (value[25].equalsIgnoreCase("Gambrel"))
				roofIndex = 3;
			else if (value[25].equalsIgnoreCase("Complex"))
				roofIndex = 4;
			else if (value[25].equalsIgnoreCase("Shed"))
				roofIndex = 5;
			else if (value[25].equalsIgnoreCase("Flat"))
				roofIndex = 6;
			else if (value[25].equalsIgnoreCase("Other"))
				roofIndex = 7;

			driver.findElement(By.xpath("//div[@optionnumber='" + roofIndex + "']")).click();

			driver.findElement(By.xpath(prop.getProperty("roofConfirm"))).click();

			Logger.log(Status.INFO,"Roof shape selected...");
			
			// TYPE OF ROOF
			driver.findElement(By.xpath(prop.getProperty("roofType"))).click();

			if (value[26].equalsIgnoreCase("Architectural shingle"))
				roofTypeIndex = 1;
			else if (value[26].equalsIgnoreCase("Asphalt-Fiberglass"))
				roofTypeIndex = 2;
			else if (value[26].equalsIgnoreCase("Clay or Concrete Tile"))
				roofTypeIndex = 3;
			else if (value[26].equalsIgnoreCase("Slate"))
				roofTypeIndex = 4;
			else if (value[26].equalsIgnoreCase("Metal"))
				roofTypeIndex = 5;
			else if (value[26].equalsIgnoreCase("Wood Shake/ Wood Shingle"))
				roofTypeIndex = 6;
			else if (value[26].equalsIgnoreCase("Composition over Wood Shake/Wood Shingle"))
				roofTypeIndex = 7;
			else if (value[26].equalsIgnoreCase("T-Lock"))
				roofTypeIndex = 8;
			else if (value[26].equalsIgnoreCase("Modified Polymer"))
				roofTypeIndex = 9;
			else if (value[26].equalsIgnoreCase("Asbestos"))
				roofTypeIndex = 10;
			else if (value[26].equalsIgnoreCase("Other"))
				roofTypeIndex = 11;

			driver.findElement(By.xpath("//div[@optionnumber='" + roofTypeIndex + "']")).click();

			driver.findElement(By.xpath(prop.getProperty("roofTypeConfirm"))).click();

			driver.findElement(By.xpath(prop.getProperty("roofYear"))).sendKeys(value[31]);
			
			Logger.log(Status.INFO,"Roof type selected...");

			// GARAGE TYPE
			driver.findElement(By.xpath(prop.getProperty("garageButton"))).click();

			if (value[27].equalsIgnoreCase("None"))
				garageTypeIndex = 1;
			else if (value[27].equalsIgnoreCase("Attached Garage"))
				garageTypeIndex = 2;
			else if (value[27].equalsIgnoreCase("Built-in Garage"))
				garageTypeIndex = 3;
			else if (value[27].equalsIgnoreCase("Detached"))
				garageTypeIndex = 4;
			else if (value[27].equalsIgnoreCase("Carport"))
				garageTypeIndex = 5;

			driver.findElement(By.xpath(("//div[@optionnumber='" + garageTypeIndex + "']"))).click();

			driver.findElement(By.xpath(prop.getProperty("garageTypeConfirm"))).click();
			
			Logger.log(Status.INFO,"Garage type selected...");

			// NO OF CARS IN GARAGE

			String carsValue = value[28];
			int cars = Integer.parseInt(carsValue);

			if (cars == 1)
				carsIndex = 1;
			else if (cars == 2)
				carsIndex = 2;
			else if (cars == 3)
				carsIndex = 3;
			else if (cars == 4)
				carsIndex = 4;
			else
				carsIndex = 5;

			Select garageSizeDropdown = new Select(driver.findElement(By.xpath(prop.getProperty("sizeOfGarage"))));
			garageSizeDropdown.selectByIndex(carsIndex);

			if (value[29].equalsIgnoreCase("No"))
				windowTypeIndex = 1;
			else if (value[29].equalsIgnoreCase("Engineered"))
				windowTypeIndex = 2;
			else if (value[29].equalsIgnoreCase("Non-Engineered"))
				windowTypeIndex = 3;

			Select windowDropdown = new Select(driver.findElement(By.xpath(prop.getProperty("stormShutterWindow"))));
			windowDropdown.selectByIndex(windowTypeIndex);

			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver,
					System.getProperty("user.dir") + "\\Screenshots\\" + DateTime.getTimeStamp() + ".png"); // Taking screenshot
			
			Logger.log(Status.INFO,"No of cars in garage selected...");

			driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		} catch (Exception e) {
			System.out.println("Automation terminated due to invalid details... \nEnter valid details");
		}

		Logger.log(Status.PASS,"Home Exterior Page Verified...");
	}

}
