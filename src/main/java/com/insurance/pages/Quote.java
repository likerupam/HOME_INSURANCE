package com.insurance.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.insurance.util.DateTime;
import com.insurance.util.ExcelData;
import com.insurance.util.Screenshot;

@Test
public class Quote extends Controller {

	String[] value = new String[32];
	String money, due, total, val;
	
	
	public void retrieveData() throws Exception
	{
		Logger = reports.createTest("Quote Test");
		
		String amount[]=new String[3];
		amount[0]= driver.findElement(By.xpath("//div[@id='propertyPolicyEstim']")).getText();	
		amount[1]= driver.findElement(By.xpath("//span[@class='premiumDueAmt']")).getText();	
		amount[2]= driver.findElement(By.xpath("//div[@class='col-12 fullTermPremiumText']")).getText();	
		
	
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		
		Thread.sleep(2000);
		Screenshot.takeSnapShot(driver, System.getProperty("user.dir")+"\\Screenshots\\"+DateTime.getTimeStamp()+".png") ;	//Taking screenshot

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("priceList"))));
		List<WebElement> dettails = driver.findElements(By.xpath(prop.getProperty("priceList")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("includedList"))));
		WebElement included = driver.findElement(By.xpath(prop.getProperty("includedList")));
		
		
		Logger.log(Status.INFO,"Data fetched and transfered to excel...");
		
		ExcelData.writeExcel(amount, dettails, included);
		
		Logger.log(Status.PASS,"Quote Page Verified...");
	}

}
