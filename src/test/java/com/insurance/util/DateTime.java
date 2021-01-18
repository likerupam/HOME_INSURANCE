package com.insurance.util;

import java.util.Date;

import org.testng.annotations.Test;

public class DateTime {
	@Test
	public static String getTimeStamp() 
	{
		Date date = new Date();
		return date.toString().replaceAll(":","_").replaceAll(" ","_");
	}

}
