package com.json.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class JsonTesting {

	public static void main(String[] args){
		
		 Map<String, String> parameters = new HashMap<String, String>();
		 parameters.put("name", args[0]);
		 parameters.put("phone", args[1]);
		 String json = new Gson().toJson(parameters);
		 System.out.println(json);
		 
		 System.out.println("####################################################");
		 
		// Serialization
		 BagOfPrimitives obj = new BagOfPrimitives();
		 obj.setValue3(34);
		 Gson gson = new Gson();
		 String json2 = gson.toJson(obj); 
		 System.out.println(json2);
		 
		 System.out.println("####################################################");
		 
		// Deserialization
		 BagOfPrimitives bop = gson.fromJson(json2, BagOfPrimitives.class);
		 System.out.println(bop.toString());
		 
		 System.out.println("####################################################");
		 		 
		 @SuppressWarnings("rawtypes")
		Collection collection = new ArrayList();
		 collection.add("hello");
		 collection.add(5);
		 collection.add(new Event("GREETINGS", "guest"));
		 
		 String data = new Gson().toJson(collection);
		 System.out.println(collection);
		 
	}
}
