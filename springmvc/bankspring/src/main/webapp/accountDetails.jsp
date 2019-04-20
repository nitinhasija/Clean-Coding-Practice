<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
   <% 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
     if(session.getAttribute("username")==null)
	     response.sendRedirect("login.jsp"); 
    %>
	<br>
	<br>
	<form action="accountDetails" method="post">
	  <div class="container">
          <label for="Account Number"><b>Account Number</b></label>
          <input type="number" placeholder="Enter Account Number" name="accountNumber" required>
    
         <button type="submit">Submit</button>
       </div>
	</form>
	
	<script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/bankspring/accountDetails.jsp");
	    }
          var Msg ='<%=request.getAttribute("doesDetailsExists")%>';
          if(Msg==="yes")
          alert("Customer ID: "+'<%=request.getAttribute("customerId")%>'+"\nCustomer EmailId: "+
        		  '<%=request.getAttribute("emailId")%>'+"\nCustomer Name: "+
        		  '<%=request.getAttribute("customerName")%>'+"\nBalance: "+'<%=request.getAttribute("balance")%>');
          
          else if(Msg != "null")
          alert(Msg);
   </script> 
   
</body>
</html>