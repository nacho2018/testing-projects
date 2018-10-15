package com.crunchufy.restjersey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CtoFServiceTest {

	public static void main(String[] args){
		
		//test de convertCtoF()
		try{
			URL url = new URL("http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			//receiving data
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			int read = 0;
			while ((line = in.readLine()) != null) {
				read ++;
				sb.append(line);
			}
			System.out.println("\nctofservice REST Service Invoked Successfully..Number of lines read: " + read);
			System.out.println("\nData from service:\n" + sb.toString());
			in.close();
			
		}catch (Exception e) {
			System.out.println("\nError while calling ctofservice without params REST Service");
			System.out.println(e);
		}
	}
}
