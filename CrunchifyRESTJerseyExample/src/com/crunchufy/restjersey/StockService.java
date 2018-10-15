package com.crunchufy.restjersey;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/stockservice")
public class StockService {

	final private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@GET
	@Path("/getListByStockId/{idStock}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListByStockId(@PathParam("idStock") Integer idStock){
		
		JSONObject jsonObject = new JSONObject();
		String stuff = "";
		if (idStock == 1){
			stuff = "shoes, jewelry, hats, bracelets";
		}else if (idStock == 2){
			stuff = "jerseys, pullovers, runners";
		}else{
			stuff = "none";
		}
		
		List<String> myList = new ArrayList<String>(Arrays.asList(stuff.split(",")));
		jsonObject.put("stockList", myList);
		
		return Response.status(Response.Status.ACCEPTED).entity(jsonObject.toString()).build();
			
		
	}
	
	@GET
	@Path("/getStockById/{idStock}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStockById(@PathParam("idStock") Integer idStock){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("category", "hardware");
		jsonObject.put("builder", "ZANUSSI");
		jsonObject.put("recordDate", sdf.format(new Date()));
		jsonObject.put("stock", 250);
		jsonObject.put("availability", true);
		
		return Response.status(Response.Status.ACCEPTED).entity(jsonObject.toString()).build();
			
		
	}
	
	
	
	
	
}
