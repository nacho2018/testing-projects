package com.crunchufy.restjersey;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/welcome")
public class MessageService {

	@GET
	@Path("/entry")
	@Produces("application/xml")
	public String giveWelcome(@DefaultValue("Welcome user!") @QueryParam("msg") String msg) {
 
		StringBuffer sb = new StringBuffer();
		sb.append("<output>");
		sb.append("The message is " + msg);
		sb.append("</output>");
		
		return sb.toString();
		
	}
	
	  @GET
	  @Path("/entryJson")
	  @Produces("application/json")
	  public Response giveWelcomeJson(@DefaultValue("Welcome user!") @QueryParam("msg") String msg) throws JSONException {
	
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("message", msg); 
		jsonObject.put("sender", "Peter Wellers");
	
		String result =  jsonObject.toString();
		return Response.status(200).entity(result).build();
	  }
	
}
