<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="edu.cmu.bilei.beans.FavouriteBean"%>
<%
	if(request.getAttribute("firstname") != null && request.getAttribute("lastname") != null){
	    out.print("<p><font color='steelblue'>" + request.getAttribute("firstname") +"  "+ request.getAttribute("lastname") + "</font></p><br>");
	}

%>

	<form method="post" action="add">
	
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
	
	<form method="post" action="logout">
		<input type="submit" name="logout" value="Logout" />
	</form>
	
	<%
	
	if(request.getAttribute("favourites") != null){
		
		 // why can't:
		List<FavouriteBean>  favlist = (List<FavouriteBean>)request.getAttribute("favourites");
		for(FavouriteBean fvb : favlist){
	   		 out.print("<p><a href='http://localhost:8080/J2EEHw3/JumpCount?url="+fvb.getURL()+"&click="+fvb.getClick_count()+"'>" +fvb.getURL() + "</a></p><br>");
	   		 
	   		 //out.print("<p><a href="+fvb.getURL()+">" +fvb.getURL() + "</a></p><br>");
	   		 
	   		 out.print("<p><font color='steelblue'>" +fvb.getComment() + "</font></p><br>");
	   		 out.print("<p><font color='steelblue'>" +fvb.getClick_count() + "</font></p><br>");
		}  

	}
	
	%>
	
	
	
</body>
</html>