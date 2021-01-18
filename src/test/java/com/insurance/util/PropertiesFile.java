package com.insurance.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesFile {
	public static Properties prop;
	
	@Test
	public static Properties dataread() // Reading data from properties file
	{
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\Property\\xpaths.properties"); // Property file location
				prop.load(file); // Loading property file
			} catch (Exception e) {
				e.printStackTrace(); // Printing actual error message
			}
		}
		
		return prop;

	}

}
