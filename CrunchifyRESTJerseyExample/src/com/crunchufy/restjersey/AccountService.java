package com.crunchufy.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;


@Path("/accountcreation")
public class AccountService {

	@GET
	@Produces("text/html")
	public Response accountCreation(
			@QueryParam("username") String username,
			@QueryParam("password") String password){
				
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			
			return Response.status(400).entity(badResponse()).build();
		}
		return Response.status(200).entity(response()).build();
	
	}
	
	private String badResponse(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><meta charset=\"utf-8\"><title>Account registration Error></title></head>");
		sb.append("<body><h1>Error</h1>");
		sb.append("<p>Error 400: Bad request params!</p></body></html>");
		
		return sb.toString();
	}
	private String response(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><meta charset=\"utf-8\"><title>Account registration></title></head>");
		sb.append("<body><h1>Welcome!</h1>");
		sb.append("<p>You have successfully registered your account!</p></body></html>");
		
		return sb.toString();
		
	}
}