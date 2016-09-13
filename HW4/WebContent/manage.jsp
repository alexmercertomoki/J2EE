<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- managing your account  -->
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
					     <a href='http://localhost:8080/J2EEHw3/manage.do?userId=${sessionScope.user_id}'> Manage you account </a>	
					 </div>
		 </div>
		 
		<div class="col-md-3">
			<form method="post" action="add.do">
		    
		   
				<table border="1">
				<tr>
					<td>URL:</td>
					<td>
					<input type="text" name="url" value="" />
					</td>
				</tr>
				<tr>
					<td>Comment</td>
					<td>
					<input type="text" name="comment" value="" />
					</td>
				</tr>
				
				
				<tr>
					<td colspan='2'>
					<input type="submit" name="add" value="add" />
					</td>
				</tr>
				</table>
			</form>
			
			<form method="post" action="logout.do">
				<input type="submit" name="logout" value="Logout" />
			</form>
	
		</div>
	
	

		<div class="col-md-3">
			<!--  showing the first name and last name -->
			<b><c:out value="${sessionScope.firstname}"/></b>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<b><c:out value="${sessionScope.lastname}"/></b>

			<table>
				    <c:forEach items="${favourites}" var="fav">
				     	<tr>
				     		<td> URL: </td>
				     		<td><a href='http://localhost:8080/J2EEHw3/jumpcount.do?url=${fav.URL}&click=${fav.click_count}'> ${fav.URL}</a></td>
				     		<td><a href='http://localhost:8080/J2EEHw3/delete.do?favId=${fav.fav_id}' class="btn-default"> Delete </a></td>
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
	    <div class="col-md-2">
	    	<form method="post" action="passchange.do">
		    
				<table border="1">
				<tr>
					<td>New Pass Word:</td>
					<td>
					<input type="password" name="password" value="" />
					</td>
				</tr>
				
				<tr>
					<td colspan='2'>
					<input type="submit" name="pass" value="change pass" />
					</td>
				</tr>
				</table>
				
				<input type="hidden" name="userId" value="${sessionScope.user_id}"/>
				
			</form>
			
			<b><font color='red'><c:out value="${info}"/></font></b>
	    	
	    </div>
	    
	</div>
	
	
</body>
</html>