
package com.monkoauth.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class NetworkHandler {
	
	private NetworkHandler() {
		
	}
	
	private static NetworkHandler instance;
	private final String USER_AGENT = "Mozilla/5.0";
	
	public static NetworkHandler getInstance() {
		
		if(instance == null ) {
			
			synchronized(NetworkHandler.class) {
				
				if(instance == null ) {
					
					instance = new NetworkHandler();
					
				}
				
			}
			
		}
		
		return instance;
		
	}
	
	public String formatString(String baseUrl , Map<String , Object> queries) 
			throws MalformedURLException {
		
		
		String queryString = "";
		
		if(queries != null ) {
			
			queryString = "?";
			
			for(String key : queries.keySet()) {
				
				queryString += key+"="+queries.get(key)+"&";
				
			}
			
			queryString = queryString.substring(0 , queryString.length() - 1);
			
			
		}
		
		URL mainUrl = new URL(baseUrl + queryString);
		
		return mainUrl.toString();
	}
	
	public String formatString(Map<String,Object> params) throws UnsupportedEncodingException {
		

		String queryString = "";
		
		if(params != null ) {
					
			
			for(String key : params.keySet()) {
				
				queryString += key+"="+
				params.get(key) instanceof String ? URLEncoder.encode((String) params.get(key), "UTF-8") : params.get(key)
				+"&";
				
			}
			
			queryString = queryString.substring(0 , queryString.length() - 1);
			
			GeneralUtils.printStackTrace(queryString);
			
			return queryString;
			
		}else {
			return "";
		}
		
//		
	}
	
	public String sendGet(String baseUrl , Map queries, Map<String, String> headers) throws IOException {
		
		URL mainUrl = new URL(formatString(baseUrl , queries));
		
		GeneralUtils.printStackTrace("GET : " + mainUrl.toString());
		
		HttpURLConnection connection = (HttpURLConnection) mainUrl.openConnection();
		
		connection.setRequestProperty("user-agent", USER_AGENT);
		
		if(headers != null) {
			for(String key: headers.keySet()) {
				connection.setRequestProperty(key, headers.get(key));
			}
		}
		
		connection.setRequestMethod("GET");
			
		
		int responseCode = connection.getResponseCode();
		
		if(responseCode != 200) {
			
			throw new RuntimeException("GET request at "+mainUrl.toString() 
										+" \n responseCode : "+responseCode);
			
		}else {
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.
			        		getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return response.toString();
			
		}
		
	}
	
	public String sendGet(String baseUrl , Map queries) throws IOException {
		return sendGet(baseUrl, queries, null);
	}
	
	public String formatBaseUrl(String baseUrl , String...paths) {
		for(String path : paths)
			baseUrl += "/"+path;
		return baseUrl;
	}
	
	
	public String sendPOST(String baseUrl , Map queries) throws IOException {
		URL obj = new URL(baseUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("user-agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(formatString(queries).getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			return response.toString() ;
		} else {
			throw new RuntimeException("POST request failed");
		}
	}

	
}

