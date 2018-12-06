package com.qa.githubAPI.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.githubAPI.base.TestBase;
import com.qa.githubAPI.client.RestClient;

public class GetAPITest extends TestBase{
	
	TestBase testBase;
	String finalUrl;
	RestClient restClient;
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		String url = prop.getProperty("URL");
		String appURL = prop.getProperty("searchURL");	
		//  https://api.github.com/search/repositories
		
		finalUrl = url + appURL;
		System.out.println("Final URL is "+finalUrl);
		
	}
	
	@Test
	public void getTest() {
		restClient = new RestClient();
		try {
			restClient.get(finalUrl);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
