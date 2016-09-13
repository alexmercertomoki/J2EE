<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="expires" content="0">
		<title>AddrBook</title>
		<link href="search-form.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="ajax.js"> </script>
		<script type="text/javascript" src="search-suggest.js"> </script>
	</head>
	
    <body onLoad="document.getElementById('last').focus()">

		<jsp:include page="search-form.jsp"/>

		<h2>Manage Users</h2>

		<jsp:include page="errors-and-messages.jsp"/>

		<table cellpadding="3">
			<c:forEach var="u" items="${userList}">
				<tr>
					<form action="manage-users.do" method="post">
						<input type="hidden" name="userName" value="${u.userName}" />
						<td> <font size="4"> ${u.userName} </font> </td>
					    <td> <input type="submit" name="button" value="Set Password" /> </td>
					    <c:choose>
							<c:when test="${u.userName != user.userName}">
							    <td> <input type="submit" name="button" value="Delete" /> </td>
							</c:when>
							<c:otherwise>
								<td>&nbsp;  </td>
							</c:otherwise>
						</c:choose>
					</form>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;  </td>
				<td colspan="2" align="center">
					<form action="create-user.do" method="post">
						<input type="submit" name="button" value="Create New User" />
					</form>
				</td>
			</tr>
		</table>
		
	</body>
</html>
