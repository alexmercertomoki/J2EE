<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

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
			<input type="hidden" name="id" value="${entry.id}"/>
			<input type="hidden" name="digest" value="${digest}"/>
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
					<td><input size="20" name="lastName" value="${entry.lastName}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Last Name:</font></td>
					<td><input size="20" name="spouseLast" value="${entry.spouseLast}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">First Names:</font></td>
					<td><input size="20" name="firstNames" value="${entry.firstNames}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's First Name:</font></td>
					<td><input size="20" name="spouseFirst" value="${entry.spouseFirst}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Birthday:</font></td>
					<td><input size="20" name="birthday" value="<fmt:formatDate value='${entry.birthday}' type='date' pattern='MM/dd/yyyy'/>"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Birthday:</font></td>
					<td><input size="20" name="spouseBirthday" value="<fmt:formatDate value='${entry.spouseBirthday}' type='date' pattern='MM/dd/yyyy'/>"/>
				</td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Home Phone:</font></td>
					<td><input size="20" name="homePhone" value="${entry.homePhone}"/></td>
					<td bgcolor="aqua"><font size="4">Fax:</font></td>
					<td><input size="20" name="fax" value="${entry.fax}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Cell Phone:</font></td>
					<td><input size="20" name="cellPhone" value="${entry.cellPhone}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Cell Phone:</font></td>
					<td><input size="20" name="spouseCell" value="${entry.spouseCell}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Work Phone:</font></td>
					<td><input size="20" name="workPhone" value="${entry.workPhone}"/></td>
					<td bgcolor="aqua"><font size="4">Spouse's Work Phone:</font></td>
					<td><input size="20" name="spouseWork" value="${entry.spouseWork}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">e-mail:</font></td>
					<td colspan="3"><input size="72" name="email" value="${entry.email}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Spouse's e-mail:</font></td>
					<td colspan="3"><input size="72" name="spouseEmail" value="${entry.spouseEmail}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Additional:</font></td>
					<td colspan="3"><input size="72" name="additional" value="${entry.additional}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Address:</font></td>
					<td colspan="3"><input size="72" name="address" value="${entry.address}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">City:</font></td>
					<td><input size="20" name="city" value="${entry.city}"/></td>
					<td bgcolor="aqua"><font size="4">State:</font></td>
					<td><input size="20" name="state" value="${entry.state}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Zip:</font></td>
					<td><input size="20" name="zip" value="${entry.zip}"/></td>
					<td bgcolor="aqua"><font size="4">Country:</font></td>
					<td><input size="20" name="country" value="${entry.country}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Rec'd Cards:</font></td>
					<td colspan="3"><input size="72" name="receivedCards" value="${entry.receivedCards}"/></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Send Cards:</font></td>
					<td colspan="3"><input size="72" name="sentCards" value="${entry.sentCards}"/></td>
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
