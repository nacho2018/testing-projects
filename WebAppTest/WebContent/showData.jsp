<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.web.tests.beans.Entity" %>
<%@ page import="com.web.tests.beans.StaffData" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Showing entity data</title>
</head>
<body>

<%--   <jsp:useBean id="myEntity" class="com.web.tests.beans.Entity"> --%>
<%--     <jsp:setProperty name="myEntity" property="code" value="39283"/> --%>
<%--     <jsp:setProperty name="myEntity" property="numberStaff" value="435"/> --%>
<%--     <jsp:setProperty name="myEntity" property="address" value="34, Roses St."/> --%>
<%--   </jsp:useBean> --%>
<!--   <table> -->
<!--     <tr> -->
<%--       <td>Code: </td><td><jsp:getProperty name="myEntity" property="code"/></td> --%>
<%--       <td>Staff Number: </td><td><jsp:getProperty name="myEntity" property="numberStaff"/></td> --%>
<%--       <td>Address: </td><td><jsp:getProperty name="myEntity" property="address"/></td> --%>
<!--     </tr> -->
<!--   </table> -->

  <% String entry = (String)request.getAttribute("entry");
	  if (entry.equals("entityEntry")){
		  Entity myEntity = (Entity)request.getAttribute("entity");
	%>
	     <h2>Entity Data</h2>
		    <table>
		    <tr>
		      <td>Code: </td><td><% out.print(myEntity.getCode()); %></td>
		      <td>Staff Number: <% out.print(myEntity.getNumberStaff()); %></td>
		      <td>Address: </td><td><% out.print(myEntity.getAddress()); %></td>
		    </tr>
		  </table>
	<%}else if (entry.equals("staffEntry")) {
		  StaffData sd = (StaffData)request.getAttribute("staff");
	%>
	 <h2>Staff Data</h2>
	   <table>
        <tr>
          <td>Name: </td><td><% out.print(sd.getName()); %></td>
          <td>Office: <% out.print(sd.getOffice()); %></td>
          <td>Salary: </td><td><% out.print(sd.getSalary()); %></td>
        </tr>
      </table>
  <%}%>
  
</body>
</html>