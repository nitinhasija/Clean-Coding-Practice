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
	<form action="openAccount" method="post">
		<div class="container">
         <label for="Name"><b>Name</b></label>
         <input type="text" placeholder="Enter Name" name="name" required>
       
         <label for="email"><b>EmailId</b></label>
         <input type="text" placeholder="Enter EmailId" name="email" required>
        
         <label for="mobileNumber"><b>Mobile Number</b></label>
         <input type="number" placeholder="Enter Mobile Number" name="mobileNumber" required>
        
       <button type="submit">CREATE ACCOUNT</button>
       <p>*Fisrt letter of first name and last name should be in capital.*</p>
     </div>
	</form>
	     
	 <script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/bankspring/createAccount.jsp");
	    }
          var Msg ='<%=request.getAttribute("accountCreationStatus")%>';
          if (Msg != "null") {
          alert(Msg);
       }
 </script> 
</body>
</html>