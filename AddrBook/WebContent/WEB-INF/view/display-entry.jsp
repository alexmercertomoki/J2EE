<!doctype html>
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
	
		<form name="entry" action="modify-entry.do" method="post">
			<input type="hidden" name="id" value="${entry.id}"/>
			<table border="0">
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td colspan="2" />
					<td align="center">
						<input type="submit" name="button" value="Delete"/>
					</td>
					<td align="center">
						<input type="submit" name="button" value="Edit"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Last Name:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.lastName}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Spouse's Last Name:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.spouseLast}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">First Names:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.firstNames}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Spouse's First Name:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.spouseFirst}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Birthday:</font></td>
					<td>
						<font size="5">
							&nbsp;&nbsp;<fmt:formatDate value="${entry.birthday}" type="date" pattern="MM/dd/yyyy"/>&nbsp;&nbsp;
						</font>
					</td>
					<td bgcolor="aqua"><font size="4">Spouse's Birthday:</font></td>
					<td>
						<font size="5">
							&nbsp;&nbsp;<fmt:formatDate value="${entry.spouseBirthday}" type="date" pattern="MM/dd/yyyy"/>&nbsp;&nbsp;
						</font>
					</td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Home Phone:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.homePhone}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Fax:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.fax}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Cell Phone:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.cellPhone}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Spouse's Cell Phone:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.spouseCell}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Work Phone:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.workPhone}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Spouse's Work Phone:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.spouseWork}&nbsp;&nbsp;</font></td>
				</tr>
				<c:if test="${!(empty entry.email)}">
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">e-mail:</font></td>
						<td colspan="3"><font size="5">&nbsp;&nbsp;<a href="mailto:${entry.email}">${entry.email}</a>&nbsp;&nbsp;</font></td>
					</tr>
				</c:if>
				<c:if test="${!(empty entry.spouseEmail)}">
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">Spouse's e-mail:</font></td>
						<td colspan="3"><font size="5">&nbsp;&nbsp;<a href="mailto:${entry.spouseEmail}">${entry.spouseEmail}</a>&nbsp;&nbsp;</font></td>
					</tr>
				</c:if>
				<c:if test="${!(empty entry.additional)}">
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">Additional:</font></td>
						<td colspan="3"><font size="5">&nbsp;&nbsp;${entry.additional}&nbsp;&nbsp;</font></td>
					</tr>
				</c:if>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Address:</font></td>
					<td colspan="3"><font size="5">&nbsp;&nbsp;${entry.address}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">City:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.city}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">State:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.state}&nbsp;&nbsp;</font></td>
				</tr>
				<tr>
					<td></td>
					<td bgcolor="aqua"><font size="4">Zip:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.zip}&nbsp;&nbsp;</font></td>
					<td bgcolor="aqua"><font size="4">Country:</font></td>
					<td><font size="5">&nbsp;&nbsp;${entry.country}&nbsp;&nbsp;</font></td>
				</tr>
				<c:if test="${!(empty entry.receivedCards) || !(empty entry.sentCards)}">
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">Rec'd Cards:</font></td>
						<td colspan="3"><font size="5">&nbsp;&nbsp;${entry.receivedCards}&nbsp;&nbsp;</font></td>
					</tr>
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">Send Cards:</font></td>
						<td colspan="3"><font size="5">&nbsp;&nbsp;${entry.sentCards}&nbsp;&nbsp;</font></td>
					</tr>
				</c:if>
				<c:if test="${!(empty entry.updated)}">
					<tr>
						<td></td>
						<td bgcolor="aqua"><font size="4">Updated:</font></td>
						<td colspan="3">
							<font size="5">
								&nbsp;&nbsp;<fmt:formatDate value="${entry.updated}" type="both" pattern="MMM-dd-yyyy  h:mm aa"/>&nbsp;&nbsp;
							</font>
						</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="3" />
					<td align="center">
						<input type="submit" name="button" value="Delete"/>
					</td>
					<td align="center">
						<input type="submit" name="button" value="Edit"/>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>
