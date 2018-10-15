<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<title>Form Customer</title>
</head>
<body>

  <form name="customerForm" id="customerForm" action="<%=request.getContextPath()%>/form" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"/><br/><br/>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone"/><br/><br/>
    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact"/><br/><br/>

    <input type="submit" value="Submit">
  </form>
  
  <br/><br/>
  
  <form name="peopleForm" id="peopleForm" action="<%=request.getContextPath()%>/form">
    <label for="people">People in list: </label>
    <select id="people"></select><br/><br/>
    <div id="infoPeople"></div>
  </form>
    
  <br/><br/>
  
  <div id="showContent"></div>
  <br/><br/>
  <table>
    <tr>
      <td><button id="bhelp">Press to get help...</button></td>
      <td><button id="bget">Press to get list from server</button></td>
      <td><button id="bsend">Press to send list to server</button></td>
    </tr>
  </table>
  
  
  
  
</body>
<script>
   (function(){
	
	   var sendList = [
		    {name : 'Laura Bright', phone : '111111', contact : 'laura66@gmail.com'},
		    {name : 'Sammuel Jones', phone : '22222', contact : 'sam33@gmail.com'},
		   ];
	   
	   const SERVER_RESPONSE = 'Error from server';
	   
	 //adapting css styles
       $('#people').css('width', '100px');
	   
	   
		$( "#customerForm" ).submit(function( event ) {
		 
		  // Stop form from submitting normally
		  event.preventDefault();
		  
		  //validación
		  var name = $('#name').val();
	    var phone = $('#phone').val();
	    var contact = $('#contact').val();
	         
      if (!name || !phone || !contact){
        $('#showContent').css('color', 'red');
        $('#showContent').html('Complete all the fields!');
        return false;
      }
		 
		  var $form = $( this ),
		  url = $form.attr( "action" );
		 
		  // Send the data using post
		  $.post( url, $('#customerForm').serialize() )
		  .done(function( data ) {
			  $('#showContent').css('color', 'black');
		    var content = data.name + " " + data.phone + " " + data.contact + " " + data.date;
		    $('#showContent').empty().append(content);
		  }).fail(function(){
			  $('#showContent').css('color', 'red');
		    $('#showContent').empty().append('Error from server!');
		  });
   });
		
		$('#bhelp').click(function(){
			
			var url = '<%=request.getContextPath()%>/help';
			$.post(url, {param : 'help'})
			.done(function(data){
				$('#showContent').css('color', 'black');
		    $('#showContent').empty().append(data);
			})
			.fail(function(){
				$('#showContent').css('color', 'red');
				$('#showContent').empty().append('Error from server!');
			});
			
		});
		
		$('#bget').click(function(){
		      
		      var url = '<%=request.getContextPath()%>/help';
		      $.post(url, {param : 'getList'})
		      .done(function(data){
		    	  if (data && data.length > 0){
		    		  var content = '';
		    		  data.forEach(function(elem){
		    			  content += elem.name + ' ' + elem.phone + ' ' + elem.contact + ' ' + elem.date;
		    			  content += '<br/>';
		    		  });
		    		  $('#showContent').css('color', 'black');
		          $('#showContent').empty().append(content);
		          
		          //fill the combo of people
		          var options= [];
		          data.forEach(function(elem){
		              options.push('<option value="', elem.name, '">', elem.contact, '</option>');  
		          });
		          $('#people').html(options.join(''));
		        
		    		  
		    	  }else{
		    		  $('#showContent').css('color', 'red');
		          $('#showContent').empty().append('Empty content from server!');
		    	  }

		      })
		      .fail(function(){
		        $('#showContent').css('color', 'red');
		        $('#showContent').empty().append('Error from server!');
		      });
		      
		    });
		
	    $('#bsend').click(function(){
	          
	          var url = '<%=request.getContextPath()%>/help';
	          var arrayToString = JSON.stringify(sendList);
	          console.log(arrayToString);
	          $.post(url, {param : 'sendList', data : arrayToString})
	          .done(function(data){
	              $('#showContent').css('color', 'black');
	              $('#showContent').empty().append(data);
	          })
	          .fail(function(){
	            $('#showContent').css('color', 'red');
	            $('#showContent').empty().append('Error from server!');
	          });
	          
	        });
	    
	    $('#people').change(function(){
	    	
	    	//sending form to be processed
	    	var form = $('#peopleForm');
	    	var select = $(this);
	    	var url = form.attr("action");
	    	$.ajax({
	    		url : url,
	    		data : {param : 'people', value: select.val()},
	    		type : 'post',
	    		dataType : 'html'
	    	})
	    	.done(function(response){
	    		console.log("ok from server");
	    		$('#infoPeople').empty().append(response);
	    		
	    	})
	    	.fail(function(){
	    		console.error("ko from server");
	    		$('#infoPeople').empty().append(SERVER_RESPONSE);
	    	});
	    	
	    });
	   
	   
 })();
</script>
</html>