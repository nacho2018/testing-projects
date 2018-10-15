package com.web.test.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * Servlet implementation class MyServletDownload
 */
@WebServlet(
		name = "MyServletDownload",
		description = "Servlet de descargas", 
		urlPatterns = {"/download"},
		initParams = { 
			@WebInitParam(name = "download-department", 
			value = "WEB-INF/resources/department.txt"),
			@WebInitParam(name = "download-employer", 
			value = "WEB-INF/resources/employer.txt")
		})
public class MyServletDownload extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MyServletDownload.class);
	
	private File fileToDept = null;
	private File fileToEmpl = null;
	private String downloadPathDept;
	private String downloadPathEmpl;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletDownload() {
        super();
        
    }
    
    public void init(ServletConfig config) throws ServletException {
		
		log.info("Executing init() from MyServletDownload");
		
		String downloadDept = config.getInitParameter("download-department");
		String downloadEmp = config.getInitParameter("download-employer");
		ServletContext sc = config.getServletContext();
		String webAppPath = sc.getRealPath("/");
		downloadPathDept = webAppPath + downloadDept;
		downloadPathEmpl = webAppPath + downloadEmp;
		fileToDept = new File(downloadPathDept);
		fileToEmpl = new File(downloadPathEmpl);
		
		if (!fileToDept.exists()) {
			log.error("Dept file does not exist");
		} 
		if (!fileToEmpl.exists()) {
			log.error("Employer file does not exist");
		} 
		
		super.init(config);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("doGet() from MyServletDownload");
		

		String param = request.getParameter("file");
		boolean downloadValid = false;
		BufferedReader br = null; //file reader
		String line; //stores lines from file
		StringBuffer sb = null; 
		
		if (StringUtils.isNotBlank(param) && 
				(StringUtils.equals(param, "department") || 
						StringUtils.equals(param, "employer") )){
							downloadValid = true;
		}
		
		if (!downloadValid){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body><div>");
			pw.println("<h2><font color=\"red\">Not a valid file request</font></h2>");
			pw.println("</div>");
			pw.println("</body></html>");
			pw.flush();
			
		}else{
			boolean isDept = true;
			//checking file
			if (param.equals("department")){
				br = new BufferedReader(new FileReader(fileToDept));
			}else if (param.equals("employer")){
				br = new BufferedReader(new FileReader(fileToEmpl));
				isDept = false;
			}
			
			//reading lines
			sb = new StringBuffer();
			while((line = br.readLine()) != null){
			   sb.append(line);
			   sb.append("\n");
			}
			br.close();
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter pw = response.getWriter();
//			pw.println("<html><body><div>");
//			pw.println(sb.toString());
//			pw.println("</div></body></html>");
//			pw.flush();
			response.setContentType("text;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename=" + ((isDept) ? "department.txt" : "employer.txt"));
			response.setHeader("Content-Length", isDept ? Long.toString(fileToDept.length()) : 
				Long.toString(fileToEmpl.length())); 
			
			File file = null;
			try  {
				file = isDept ? fileToDept : fileToEmpl;
				FileInputStream fis = new FileInputStream(file);
				IOUtils.copy(fis, response.getOutputStream());
			}catch (Exception e) {
				log.error(e,e);
			} finally {
				try {
					if (file != null && !file.isDirectory() && file.exists()) {
						file.delete();
					}
				} catch (Exception e) {
					log.error(e,e);
				}
			}
				
			response.flushBuffer();
			
		}
	}

	

}
