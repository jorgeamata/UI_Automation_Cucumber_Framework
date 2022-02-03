package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	
	/**
	 * This method is to get/load all the properties from config.properties file
	 * @return it returns Property prop object
	 */
	
	public Properties init_Prop() {
		prop = new Properties();
		
		try {
			FileInputStream inputStream = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		
		return prop;
	}

}
