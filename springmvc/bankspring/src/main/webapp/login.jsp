<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style><%@include file="design.css"%></style> 
</head>
<body>
<h1 align="center">MY BANK APPLICATON</h1>
    <br>
	<br>
	<form action="login" method="post">
	 <div class="container">
       <label for="username"><b>Username</b></label>
       <input type="text" placeholder="Enter Username" name="username" required>

       <label for="password"><b>Password</b></label>
       <input type="password" placeholder="Enter Password" name="password" required>
        
       <button type="submit">Login</button>
     </div>
	</form>
		 
	<script type="text/javascript">
	    window.onload = function() {
	        history.replaceState("", "", "/bankspring/login.jsp");
	    }
          var Msg ='<%=request.getAttribute("loginError")%>';
          if (Msg != "null") {
          alert(Msg);
       }
      </script>
</body>
</html>