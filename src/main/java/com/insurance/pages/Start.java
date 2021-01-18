package com.insurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.Screenshot;

@Test
public class Start extends Controller  {


	public void secondPage() throws Exception {
		
		Logger = reports.createTest("Start Page Test");
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("firstName"))));
		driver.findElement(By.xpath(prop.getProperty("firstName"))).sendKeys("test");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("lastName"))));
		driver.findElement(By.xpath(prop.getProperty("lastName"))).sendKeys("test");

		driver.findElement(By.xpath(prop.getProperty("addr"))).sendKeys("58 downey dr");

		Select gender = new Select(driver.findElement(By.id("genderDropdown")));
		gender.selectByVisibleText("Male");

		driver.findElement(By.xpath(prop.getProperty("mon"))).sendKeys("07");

		driver.findElement(By.xpath(prop.getProperty("day"))).sendKeys("07");

		driver.findElement(By.xpath(prop.getProperty("yr"))).sendKeys("1982");

		Thread.sleep(2000);
		Screenshot.takeSnapShot(driver, System.getProperty("user.dir")+"\\Screenshots\\"+DateTime.getTimeStamp()+".png") ;	//Taking screenshot

		driver.findElement(By.xpath(prop.getProperty("start"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("email"))));
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		
		String errorMessage = driver.findElement(By.xpath(prop.getProperty("errorMsg"))).getText();
		Logger.log(Status.ERROR,errorMessage+ " incorrect email");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("email"))).clear();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("email"))));
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys("test.demo@gmail.com");
		
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("no"))));
		driver.findElement(By.xpath(prop.getProperty("no"))).click();

		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		
		Logger.log(Status.PASS,"Start Page Verified...");

	}
	
	
}
