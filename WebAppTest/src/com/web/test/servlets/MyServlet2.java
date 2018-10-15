package com.web.test.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.web.tests.beans.Entity;
import com.web.tests.beans.StaffData;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet(urlPatterns = {"/getEntityData", "/getStaffData"})
public class MyServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MyServlet2.class);
	static final String ENTITY_DATA_CALL = "/getEntityData";
	static final String STAFF_DATA_CALL = "/getStaffData";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		log.info("path: " + path);
		
		if (path.equals(ENTITY_DATA_CALL)){
			Entity entity = new Entity("3244424", 200, "23, Andrews St. UK 345FF443");
			request.setAttribute("entity", entity);
			request.setAttribute("entry", "entityEntry");
		}else if (path.equals(STAFF_DATA_CALL)) {
			StaffData sd = new StaffData("Peter Reynolds", "Of384938", 1243);
			request.setAttribute("staff", sd);
			request.setAttribute("entry", "staffEntry");
		}
		request.getRequestDispatcher("/showData.jsp").forward(request, response);
		
		
	}

	

}
