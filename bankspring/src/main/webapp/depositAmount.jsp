<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<br>
	<br>
	<form action="deposit" method="post">
		<div class="container">
         <label for="accountNumber"><b>Account Number</b></label>
         <input type="number" placeholder="Enter Account Number" name="accountNumber" required>
         
         <label for="amount"><b>AMOUNT</b></label>
         <input type="text" placeholder="Enter AMOUNT" name="amount" required>
         <button type="submit">CONFIRM</button>
     </div>
	</form>
	
	<script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/bankspring/depositAmount.jsp");
	    }
          var Msg ='<%=request.getAttribute("amountDepositStatus")%>';
          if (Msg != "null") {
          alert(Msg);
       }
   </script>
 
</body>
</html>