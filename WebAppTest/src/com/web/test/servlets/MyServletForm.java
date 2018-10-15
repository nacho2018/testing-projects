package com.web.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.web.tests.beans.PersonData;

/**
 * Servlet implementation class MyServletForm
 */
@WebServlet("/form")
public class MyServletForm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MyServletForm.class);
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletForm() {
        super();
        
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("param");
		if (StringUtils.isNotBlank(param) && "people".equals(param)){
			
			String value = request.getParameter("value");
			if (StringUtils.isNotBlank(value) && "name1".equals(value)){
				
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("<div><span color=\"red\">This the info for people for \"name1\".</span></div>");
				
			}else if (StringUtils.isNotBlank(value) && "name2".equals(value)){
				
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("<div><span color=\"red\">This the info for people for \"name2\".</span></div>");
			}
			
		}else{
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String contact = request.getParameter("contact");
			String date = df.format(new Date());
			
			String data = "Info: " + name + " " + phone + " " + contact + " " + date;
			log.info(data);
			PersonData pd = new PersonData();
			pd.setName(name);
			pd.setContact(contact);
			pd.setDate(date);
			pd.setPhone(phone);
			
			String json = new Gson().toJson(pd); 
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		}
		
		
	}
	
	

}
