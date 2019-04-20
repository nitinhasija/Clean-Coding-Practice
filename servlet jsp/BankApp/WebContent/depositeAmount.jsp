<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="design.css">
<link rel="stylesheet" type="text/css" href="navbar.css">
</head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <% 
     response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
     if(session.getAttribute("username")==null)
	     response.sendRedirect("login.jsp"); 
   %>
    
 	<div class="topnav">
		  <a href="welcomePage.jsp">Home</a>
		  <a href="createAccount.jsp">Create Account</a>
 		  <a href="deleteAccount.jsp">Delete Account</a>
		  <a href="accountDetails.jsp">Account Details</a>
		  <a href="withdrawAmount.jsp">Withdraw</a>
		  <a href="updateCustomerDetails.jsp">Update Details</a>
		  <a href="logout.jsp">Logout</a>
   </div>
  
	<br>
	<br>
	<form action="deposite" method="post">
		<div class="container">
         <label for="accountNumber"><b>Account Number</b></label>
         <input type="text" placeholder="Enter Account Number" name="accountNumber" required>
         
         <label for="amount"><b>AMOUNT</b></label>
         <input type="text" placeholder="Enter AMOUNT" name="amount" required>
         <button type="submit">CONFIRM</button>
     </div>
	</form>
	
	<script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/BankApp/depositeAmount.jsp");
	    }
          var Msg ='<%=request.getAttribute("amountDepositeStatus")%>';
          if (Msg != "null") {
          alert(Msg);
       }
   </script>
 
</body>
</html>