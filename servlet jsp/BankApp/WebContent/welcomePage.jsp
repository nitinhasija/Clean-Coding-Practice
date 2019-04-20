<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="navbar.css">
</head>
<body>
  <% 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
     if(session.getAttribute("username")==null)
	     response.sendRedirect("login.jsp"); 
  %>
    
 	<div class="topnav">
  		<a href="createAccount.jsp">Create Account</a>
 		 <a href="deleteAccount.jsp">Delete Account</a>
  		<a href="accountDetails.jsp">Account Details</a>
  		<a href="depositeAmount.jsp">Deposite</a>
  		<a href="withdrawAmount.jsp">Withdraw</a>
  		<a href="updateCustomerDetails.jsp">Update Details</a>
 		 <a href="logout.jsp">Logout</a>
  </div>

<div style="padding-left:16px">
  <h1>Welcome To The Bank</h1>
</div>

</body>
</html>
