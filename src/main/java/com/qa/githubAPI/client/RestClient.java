package com.qa.githubAPI.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);  //http get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); //hitting GET url
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is "+statusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API "+responseJson);
		
		Header[] headers = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headers) {
			allHeaders.put(header.getName(),header.getValue());
		}
		System.out.println("All header values are "+headers);
	}
}
