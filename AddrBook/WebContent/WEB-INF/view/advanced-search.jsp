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
	<script type="text/javascript" src="advanced-search.js"> </script>
</head>

<body onLoad="document.getElementById('lastName').focus()">
	<jsp:include page="search-form.jsp"/>
	
	<table>
		<tr>
			<td width="600" valign="top">
				<h2>Advanced Search</h2>
				<table border="">
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Last Name:</font></td>
						<td colspan="3"><input size="72" name="lastName" id="lastName" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">First Name:</font></td>
						<td colspan="3"><input size="72" name="firstName" id="firstName" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Phone:</font></td>
						<td colspan="3"><input size="72" name="anyPhone" id="anyPhone" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">e-mail:</font></td>
						<td colspan="3"><input size="72" name="email" id="email" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Additional:</font></td>
						<td colspan="3"><input size="72" name="additional" id="additional" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Address:</font></td>
						<td colspan="3"><input size="72" name="address" id="address" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">City:</font></td>
						<td><input size="20" name="city" id="city" onKeyUp="advancedSearch();" autocomplete="off"/></td>
						<td bgcolor="#CCCCCC"><font size="4">State:</font></td>
						<td><input size="20" name="state" id="state" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Zip:</font></td>
						<td><input size="20" name="zip" id="zip" onKeyUp="advancedSearch();" autocomplete="off"/></td>
						<td bgcolor="#CCCCCC"><font size="4">Country:</font></td>
						<td><input size="20" name="country" id="country" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Rec'd Cards:</font></td>
						<td colspan="3"><input size="72" name="receivedCards" id="receivedCards" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
					<tr>
						<td bgcolor="#CCCCCC"><font size="4">Send Cards:</font></td>
						<td colspan="3"><input size="72" name="sentCards" id="sentCards" onKeyUp="advancedSearch();" autocomplete="off"/></td>
					</tr>
				</table>
			</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td id="searchResults" valign="top">
			</td>
		</tr>
	</table>
</body>
</html>
