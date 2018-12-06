package com.qa.githubAPI.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	FileInputStream fis;
	
	public TestBase() {
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/githubAPI/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
