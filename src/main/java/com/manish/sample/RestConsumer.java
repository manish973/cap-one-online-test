package com.manish.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class RestConsumer {
	
	
	/*
	 * For testing you can change the uid, token and apitoken from these final vairables.
	 * 
	 */
	static final Integer uid = 1110590645;
	static final String token = "2F13414BF0177A5AE0D5E109BAEBDA08";
	static final String apitoken = "AppTokenForInterview";
	
	public static void main(String[] args) {
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpPost postRequest = new HttpPost("https://2016.api.levelmoney.com/api/v2/core/get-all-transactions");
			postRequest.addHeader("Content-Type", "application/json");
			postRequest.addHeader("Accept", "application/json");
			StringEntity input = new StringEntity("{\"args\":{\"uid\":"+uid+",\"token\":\""+ token + "\",\"api-token\":\""+ apitoken+ "\",\"json-strict-mode\":true,\"json-verbose-response\": true}}");
			input.setContentType("application/json");
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));
			ApiResponse apiResponse = readJson(br);
			List<Transaction> transactions = apiResponse.getTransactions();
			Collections.sort(transactions);
		
			TransactionLogic tl = new TransactionLogic();
		
			System.out.println("*************************************************************************************************");
			System.out.println("**********************Totals and Averages Of All Transactions************************************");
			System.out.println("*************************************************************************************************");
			//Calculating everything as expenses
			tl.calculate(false, transactions);
			System.out.println("*************************************************************************************************");
			System.out.println("*********************Totals and Averages Excluding Donut Transactions****************************");
			System.out.println("*************************************************************************************************");
			//Excluding donuts from expenses.
			tl.calculate(true, transactions);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpClient.getConnectionManager().shutdown();
	}
	
	
	/**
	 * Converts Raw JSON into Java Object
	 * @param br
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static ApiResponse readJson(BufferedReader br) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
			// Convert JSON string from file to Object
		return mapper.readValue(br, ApiResponse.class);
	}


}
