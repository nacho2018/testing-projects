package com.crunchufy.restjersey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class StockServiceTest {
		
	public static void main(String[] args){
		
		
		try{
			System.out.println("///////////////////////////////////////");
			System.out.println("Testing /stockservice/getListByStockId");
			System.out.println("///////////////////////////////////////");
			
			URL url = new URL("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/stockservice/getListByStockId/22");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			//receiving data
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			
			while ((line = in.readLine()) != null) {sb.append(line);}
			in.close();
			
			System.out.println("List from server: " + sb.toString());
			
			System.out.println("///////////////////////////////////////");
			System.out.println("Testing /stockservice/getStockById");
			System.out.println("///////////////////////////////////////");
			
			url = new URL("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/stockservice/getStockById/1");
			connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			//receiving data
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			sb = new StringBuffer();
			
			
			while ((line = in.readLine()) != null) {sb.append(line);}
			in.close();
			
			System.out.println("Data from server: " + sb.toString());

		}catch (Exception e) {
			System.out.println("\nError while calling stockservice/getStockById REST Service");
			System.out.println(e);
		}
	}
	
}
