package com.insurance.util;

import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPeriod extends DriverSetup {
	
//	public static wait;
	
	public static WebDriverWait waitTime()
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		return wait;
	}

}
