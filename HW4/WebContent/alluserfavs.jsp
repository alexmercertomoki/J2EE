<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- for not logged in user to see the overall info of other people   -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> All User Favourites </title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
	.alluser{
		height : 300px;
	    background-color: green;
	}
	a{
		color: white;
	}
	td{
		font-size: 130%;	
	}
	
</style>

</head>


<div class="row">
	<br>
	<div class="col-md-2 alluser">
		
		<p>
	     	<a href="register.jsp">  Register  </a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	<a href="index.jsp">  Login  </a>
	    </p>
		<table>
		    <c:forEach items="${userinfo}" var="user">
		     	<tr>
		       	 	<td><a href="http://localhost:8080/J2EEHw3/alluserfavourites.do?userId=${user.userId}" >${user.firstName} &nbsp;&nbsp;&nbsp;&nbsp; ${user.lastName}</a></td>
		        </tr>
		        
		    </c:forEach>
		    
		</table>
		
	</div>
	
	<div class="col-md-10">
		<p> Seeing other people's Favourites </p>
		<table>
		    <c:forEach items="${allfavlist}" var="fav">
		     	<tr>
		     		<td> URL: </td>
		     		<td> ${fav.URL} </td>
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


<body>
	

</body>
</html>