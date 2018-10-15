<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<title>Shows Stocks</title>
</head>
<body>
  <h2>Displays info of Stocks from REST WS</h2>
  
  <form name="form" id="form" action="<%=request.getContextPath()%>/webtester" method="post">
    <label for="id">Type stock id:</label>
    <input type="number" name="id" id="id"/>
    <br/>
    <input type="submit" value="Retrieve info"/>
  </form>
  <br/>
  <div id="stockInfo"></div>
  
  <script>
    (function(){
    	
    	 $('#form').on("submit", function(){
    		 event.preventDefault();
    		 var form = this;
    		 var to = form.getAttribute("action");
    		 
    		 $.ajax({
    			 url: to,
    			 type: "POST",
    			 data : {'id': $('#id').val()},
    			 dataType : 'json'
    		 })
    		 .done(function(response){
    			 console.log("ok");
    			 var data = '';
    			 data += 'CATEGORY:' + response.category + ' BUILDER:' + response.builder;
    			 data += ' RECORD_DATE:' + response.recordDate + ' STOCK:' + response.stock;
    			 data += ' AVAILABILITY:' + response.availability;
    			 $('#stockInfo').empty().html(data);
    		 })
    		 .fail(function(error){
    			 console.log("Error: ", error);
    			 $('#stockInfo').empty().html(error);
    		 });
    		 
    	 });
    	 
    })();
  </script>
</body>
</html>