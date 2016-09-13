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

		<jsp:include page="errors-and-messages.jsp"/>
	
		<form name="entry" action="update-entry.do" method="post">
			<input type="hidden" name="id" value="${form.id}"/>
			<input type="hidden" name="digest" value="${form.digest}"/>
			<table>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td colspan="3" />
					<td align="center">
						<input type="submit" name="button" value="Submit" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Last Name:</font></td>
					<td><input size="20" name="lastName" value="${form.lastName}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Last Name:</font></td>
					<td><input size="20" name="spouseLast" value="${form.spouseLast}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">First Names:</font></td>
					<td><input size="20" name="firstNames" value="${form.firstNames}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's First Name:</font></td>
					<td><input size="20" name="spouseFirst" value="${form.spouseFirst}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Birthday:</font></td>
					<td><input size="20" name="birthday" value="${form.birthday}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Birthday:</font></td>
					<td><input size="20" name="spouseBirthday" value="${form.spouseBirthday}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Home Phone:</font></td>
					<td><input size="20" name="homePhone" value="${form.homePhone}"/></td>
					<td bgcolor="aqua"><font size="4">Fax:</font></td>
					<td><input size="20" name="fax" value="${form.fax}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Cell Phone:</font></td>
					<td><input size="20" name="cellPhone" value="${form.cellPhone}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Cell Phone:</font></td>
					<td><input size="20" name="spouseCell" value="${form.spouseCell}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Work Phone:</font></td>
					<td><input size="20" name="workPhone" value="${form.workPhone}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Work Phone:</font></td>
					<td><input size="20" name="spouseWork" value="${form.spouseWork}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">e-mail:</font></td>
					<td colspan="3"><input size="72" name="email" value="${form.email}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Spouse's e-mail:</font></td>
					<td colspan="3"><input size="72" name="spouseEmail" value="${form.spouseEmail}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Additional:</font></td>
					<td colspan="3"><input size="72" name="additional" value="${form.additional}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Address:</font></td>
					<td colspan="3"><input size="72" name="address" value="${form.address}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">City:</font></td>
					<td><input size="20" name="city" value="${form.city}"/></td>
					<td bgcolor="aqua"><font size="4">State:</font></td>
					<td><input size="20" name="state" value="${form.state}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Zip:</font></td>
					<td><input size="20" name="zip" value="${form.zip}"/></td>
					<td bgcolor="aqua"><font size="4">Country:</font></td>
					<td><input size="20" name="country" value="${form.country}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Rec'd Cards:</font></td>
					<td colspan="3"><input size="72" name="receivedCards" value="${form.receivedCards}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Send Cards:</font></td>
					<td colspan="3"><input size="72" name="sentCards" value="${form.sentCards}"/></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"/>
					<td align="center">
						<input type="submit" name="button" value="Submit"/>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>
