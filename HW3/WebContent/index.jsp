<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="log_in">
	
		<table border="1">
		<tr>
			<td>Email:</td>
			<td>
			<input type="text" name="email" value="" />
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
			<input type="password" name="password" value="" />
			</td>
		</tr>
		<tr>
			<td colspan='2'>
			<input type="submit" name="login" value="login" />
			</td>
		</tr>
		</table>
	</form>
	
	<a href="register.jsp"> Register </a>
	
	<%
                
                if(request.getAttribute("errormessage") != null){
                    out.print("<p><font color='red'>" + request.getAttribute("errormessage") + "</font></p><br>");
                }
                
   %>
        
	
</body>
</html>