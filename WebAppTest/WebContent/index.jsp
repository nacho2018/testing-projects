<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entrada a la Aplicación</title>
</head>
<body>

<%
   session.setAttribute("lang", "ESP,ENG,ITA,PORT");

   List<String> names = new ArrayList<String>();
   names.add( "Peter Collins");
   names.add("Anthony Queen");
%>

  <jsp:forward page="entry.jsp">
    <jsp:param name="entryTitle" value="Entry Title"/>
  </jsp:forward>
</body>
</html>