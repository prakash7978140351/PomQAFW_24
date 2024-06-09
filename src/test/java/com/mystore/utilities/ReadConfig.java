package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	//String path1="D:\\SW-2024\\MyStorev1\\Configuration\\config.properties";
	
	String path=System.getProperty("user.dir")+"//Configuration//config.properties";
	
	//constructor
	public ReadConfig() {
		try {
		properties=new Properties();
		
		
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if(value!=null) {
		return value;
	}else throw new RuntimeException("url not spcecified in config file");
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if(value!=null) {
		return value;
	}else throw new RuntimeException("Browser not spcecified in config file");
	}
	
	
}
