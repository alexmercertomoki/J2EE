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

	
	<body onLoad="document.setpassword.newPassword.focus()">

		<h2>Set Password for user ${form.userName}</h2>

		<jsp:include page="search-form.jsp"/>

		<jsp:include page="errors-and-messages.jsp"/>
		
		<form name="setpassword" action="set-password.do" method="post">
		    <input type="hidden" name="userName" value="${form.userName}" /></font></td>
			<table>
			    <tr>
			    	<td><font size="4">Password:</font></td>
			    	<td><font size="4"><input type="password" name="newPassword" size="20" /></font></td>
			    </tr>
			    <tr>
			    	<td><font size="4">Confirm Pwd:</font></td>
			    	<td><font size="4"><input type="password" name="confirmPassword" size="20" /></font></td>
			    </tr>
			    <tr>
			    	<td></td>
			    	<td><font size="4"><input type="submit" value="Submit" name="Submit" /></font></td>
			    </tr>
			</table>
		</form>

	</body>
</html>
