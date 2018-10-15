package com.restws.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebServicesTester
 */
@WebServlet(description = "Make calls to REST services", urlPatterns = { "/webtester" })
public class WebServicesTester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebServicesTester() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("id");
		
		if(param != null){
			
			try{
				String urlChain = "http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/stockservice/getStockById/";
				urlChain += param;
				URL url = new URL(urlChain);
				URLConnection connection = url.openConnection();
				
				connection.setDoOutput(true);
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				
				//receiving data
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line;
				
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				in.close();
				
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				response.getWriter().write(sb.toString());
				
				
			}catch (Exception e) {
				System.out.println("\nError while calling stockservice/getStockById REST Service");
				System.out.println(e);
			}
		}
		
		
	}

}
