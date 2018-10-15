package com.web.test.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.web.tests.beans.PersonData;

/**
 * Servlet implementation class MyServletHelp
 */
@WebServlet("/help")
public class MyServletHelp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MyServletHelp.class);
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletHelp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("param");
		
		if (StringUtils.isNotBlank(param) && param.equals("help")){
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("<span><font color=\"blue\">Help from server!</font></span>");
			
		}else if (StringUtils.isNotBlank(param) && param.equals("getList")){
			
			List<PersonData> list = new ArrayList<PersonData>();
			//public PersonData(String name, String phone, String contact, String date){
			list.add(new PersonData("name1", "phone1", "contact1", "date1"));
			list.add(new PersonData("name2", "phone2", "contact2", "date2"));
			
			String jsonList = new Gson().toJson(list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonList);
			
		}else if (StringUtils.isNotBlank(param) && param.equals("sendList")){
			
			try{
				String jsonList = request.getParameter("data");
				log.info("jsonList: " + jsonList);
				JsonParser parser = new JsonParser();
			    JsonArray array = parser.parse(jsonList).getAsJsonArray();
			    for (JsonElement obj : array){
			    	PersonData pd = new Gson().fromJson(obj, PersonData.class);
			    	pd.setDate(df.format(new Date()));
			    	log.info("Person info: " + pd.toString());
			    }
			    response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("<font color=\"red\">List processed in server!</font>");
				
			}catch(Exception e){
				log.error("Error: " + e.getStackTrace());
				throw new ServletException(e.getMessage());
			}
			
		}
		
		
		//también sería posible esta configuración:
//		String text = "some text";
//
//	    response.setContentType("text/plain");  
//	    response.setCharacterEncoding("UTF-8"); 
//	    response.getWriter().write(text); 
	}

}
