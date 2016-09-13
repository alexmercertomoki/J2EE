<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- index page  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<title> Favorite Site </title>

</head>


<body>

	<div class="row">
	<div class="col-md-2">
		<br>
        <jsp:include page="navibar.jsp" />
	</div>
	<div class="col-md-10">
		<form method="post" action="login.do">
		
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
	</div>
	
	</div>
	

   <c:choose>
			<c:when test="${(not empty errormessage)}">
				<p><font color='red'>${errormessage}</font></p><br>
			</c:when>
	</c:choose>
        
	
</body>
</html>