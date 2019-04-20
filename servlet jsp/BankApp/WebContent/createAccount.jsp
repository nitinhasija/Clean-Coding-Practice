<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="design.css">
<link rel="stylesheet" type="text/css" href="navbar.css">
</head>
<body>
<body>
  <% 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
     if(session.getAttribute("username")==null)
	     response.sendRedirect("login.jsp"); 
  %>
    
 <div class="topnav">
  <a href="welcomePage.jsp">Home</a>
  <a href="deleteAccount.jsp">Delete Account</a>
  <a href="accountDetails.jsp">Account Details</a>
  <a href="depositeAmount.jsp">Deposite</a>
  <a href="withdrawAmount.jsp">Withdraw</a>
  <a href="updateCustomerDetails.jsp">Update Details</a>
  <a href="logout.jsp">Logout</a>
</div>
	<br>
	<br>
	<form action="openAccount" method="post">
		<div class="container">
         <label for="Name"><b>Name</b></label>
         <input type="text" placeholder="Enter Name" name="name" required>
       
         <label for="email"><b>EmailId</b></label>
         <input type="text" placeholder="Enter EmailId" name="email" required>
        
         <label for="mobileNumber"><b>Mobile Number</b></label>
         <input type="text" placeholder="Enter Mobile Number" name="mobileNumber" required>
        
       <button type="submit">CREATE ACCOUNT</button>
       <p>*Fisrt letter of first name and last name should be in capital.*</p>
     </div>
	</form>
	     
	 <script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/BankApp/createAccount.jsp");
	    }
          var Msg ='<%=request.getAttribute("accountCreationStatus")%>';
          if (Msg != "null") {
          alert(Msg);
       }
 </script> 
</body>
</html>