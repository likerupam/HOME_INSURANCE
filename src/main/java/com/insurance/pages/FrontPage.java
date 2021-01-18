package com.insurance.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.DriverSetup;
import com.insurance.util.PropertiesFile;
import com.insurance.util.Screenshot;
import com.insurance.util.WaitPeriod;

@Test
public class FrontPage extends Controller
{	
	public void openURL() throws Exception // Directing to the Website
	{
		Logger = reports.createTest("Site Verifying Test");
		
		driver=DriverSetup.getDriver();
		prop = PropertiesFile.dataread();
		wait= WaitPeriod.waitTime();
		
		driver.get(prop.getProperty("siteLink")); // Fetching link from properties file
		
		String title = driver.getTitle();
		
		Logger.log(Status.INFO,"Started taking screenshots...");
		Logger.log(Status.INFO,"Travelers site is opened...");
		
		if(title.contains("Travelers Insurance"))
		{
			Logger.log(Status.INFO,title);
			Logger.log(Status.PASS,"Site Verified...");
		}
		else
		{
			Logger.log(Status.FAIL,"Incorrect Site...");
			System.exit(0);
		}
			
		
	}
	
	public void frontPage() throws Exception {
		
		Logger = reports.createTest("Front Page Test");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("homeId"))));
		driver.findElement(By.xpath(prop.getProperty("homeId"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("homeOwners"))));
		driver.findElement(By.xpath(prop.getProperty("homeOwners"))).click();
				
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("zip"))).sendKeys("06040");
		}
		catch(Exception e)
		{
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath(prop.getProperty("zip"))).sendKeys("06040");
				}
			catch(Exception e1)
			{
			driver.findElement(By.xpath(prop.getProperty("zip2"))).sendKeys("06040");
			}
		}
		
		Thread.sleep(2000);
		Screenshot.takeSnapShot(driver, System.getProperty("user.dir")+"\\Screenshots\\"+DateTime.getTimeStamp()+".png") ;	//Taking screenshot

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("submit"))));
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("continue"))));
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		
		Logger.log(Status.PASS,"Front Page Verified...");

	}
}
