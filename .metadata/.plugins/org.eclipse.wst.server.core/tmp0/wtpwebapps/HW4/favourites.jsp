<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- user's main favourite page  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>

	td a {
		color : steelblue;
	}
	.regi{
		height : 300px;
	    background-color: green;
	}
	.regi a{
		color: white;
	}
	
	
</style>

</head>
<body>

	<div class="row">
		<div class="col-md-2">
				<br>
					 <div class="regi">
					     <a href='http://localhost:8080/J2EEHw3/manage.do?userId=${sessionScope.user_id}'> Manage you account(Including Changing Password) </a>	
					 </div>
					
		       
		 </div>
		<div class="col-md-3">
			
			<form method="post" action="logout.do">
				<input type="submit" name="logout" value="Logout" />
			</form>
	
		</div>
	
	

		<div class="col-md-7">
			<!--  showing the first name and last name -->
			<b><c:out value="${firstname}"/></b>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<b><c:out value="${lastname}"/></b>

			<table>
				    <c:forEach items="${favourites}" var="fav">
				     	<tr>
				     		<td> URL: </td>
				     		<td><a href='http://localhost:8080/J2EEHw3/jumpcount.do?url=${fav.URL}&click=${fav.click_count}'> ${fav.URL}</a></td>
				     	</tr>
				     	<tr>
				     		<td> Comments: </td>
				     		<td> ${fav.comment} </td>
				     	</tr>
				     	<tr>
				     		<td> Count of Clicks:   </td>
				     		<td> ${fav.click_count} </td>
				        </tr>
				    </c:forEach>
				    
			</table>
	
	    </div>
	</div>
	
	
</body>
</html>