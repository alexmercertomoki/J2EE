<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- for people to register  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title> Let's Register </title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>

<body>
	<form method="post" action="register.do">
	<div class="row">
		<div class="col-md-2">
			<br>
	        <jsp:include page="navibar.jsp" />
	    </div>
	 <div class="col-md-10">   
			<table border="1">
				<tr>
					<td>Email:</td>
					<td>
					<input type="text" name="email" value="" />
					</td>
				</tr>
				<tr>
					<td>First name:</td>
					<td>
					<input type="text" name="fname" value="" />
					</td>
				</tr>
				
				<tr>
					<td>Last name:</td>
					<td>
					<input type="text" name="lname" value="" />
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
					<input type="submit" name="register" value="register" />
					</td>
				</tr>
			
			</table>
		</div>
	  </div>
	</form>
	
   
    <c:choose>
			<c:when test="${(not empty errormessage)}">
				<p><font color='red'>${errormessage}</font></p><br>
			</c:when>
	</c:choose> 
   
   
   
	
</body>
</html>