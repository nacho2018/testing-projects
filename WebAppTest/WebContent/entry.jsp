<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>  
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE>

<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    
<title><%=request.getParameter("entryTitle") %></title>
</head>
<body>
 <c:set var="name" value="Frederic Trasher"/>
 <c:set var="lang" value="<%=session.getAttribute(\"lang\")%>"/>
 
  <div class="entry">
    <p>
      <a href="<%=request.getContextPath()%>/form">Press to access the form</a>
   </p>
  </div>
  <div id="foo" style="display:none">
    <p><a id="hideFoo" href="javascript:void(0)">Press to hide (<c:out value="${name}"/> )</a></p>
  </div>
  <a id="showFoo" href="javascript:void(0)">Press here to view foo div</a>
  
  <c:if test="${not empty lang}">
    <div><span>The language is <c:out value="${lang}"/></span></div>
  </c:if>
  
  <c:catch var="errorCode">
    <% String code = (String)session.getAttribute("code");
       System.out.println("Code is " + code + ", fragmenting....");
       String[] fragments = code.split(",");
    %>
  </c:catch>
  
  <c:if test="${errorCode != null}">
    <p>Error, code is not available</p>
  </c:if>
  
  <c:catch var="langError">
    <c:set var="langs" value="${fn:split(lang, ',')}"/>
  </c:catch>

   <c:choose>
     <c:when test="${langError != null}">
        <c:out value="No languages informed!"/>
     </c:when>
     <c:otherwise>
      <c:forEach items="${langs}" var="lang">
        <c:out value="${lang}"/>
      </c:forEach>
     </c:otherwise>
   </c:choose>  
 
  
</body>
<script>
(function(){
	
	$('#showFoo').on('click', function(){
		$('#foo').css('display', 'block');
		
	});
	$('#hideFoo').on('click', function(){
	    $('#foo').css('display', 'none');
	    
	  });
	
	
})();

	
	
    
</script>
</html>