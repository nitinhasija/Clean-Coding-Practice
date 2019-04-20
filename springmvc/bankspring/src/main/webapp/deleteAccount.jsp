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
	<form action="deleteAccount" method="post">
		 <label for="accountNumber"><b>Account Number</b></label>
         <input type="text" placeholder="Enter Account Number" name="accountNumber" required>
        
       <button type="submit">SUBMIT</button>
	</form>
	
	<script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/bankspring/deleteAccount.jsp");
	    }
          var Msg ='<%=request.getAttribute("accountDeletionStatus")%>';
          if(Msg != "null"){
              alert(Msg);
          }
   </script>
 
</body>
</html>