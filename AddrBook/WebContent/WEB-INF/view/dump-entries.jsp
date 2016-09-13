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

	
	<body>
	
		&quot;id&quot;,&quot;lastName&quot;,&quot;firstNames&quot;,&quot;additional&quot;,&quot;address&quot;,&quot;city&quot;,&quot;state&quot;,&quot;country&quot;,&quot;zip&quot;,&quot;email&quot;,&quot;spouseEmail&quot;,&quot;homePhone&quot;,&quot;fax&quot;,&quot;cellPhone&quot;,&quot;spouseCell&quot;,&quot;workPhone&quot;,&quot;spouseWork&quot;,&quot;birthday&quot;,&quot;spouseBirthday&quot;,&quot;spouseLast&quot;,&quot;spouseFirst&quot;,&quot;receivedCards&quot;,&quot;sentCards&quot;,&quot;updated&quot;<br/>
		
		<c:forEach var="entry" items="${list}">
		
    		&quot;${entry.id}&quot,&quot;${entry.lastName}&quot,&quot;${entry.firstNames}&quot,&quot;${entry.additional}&quot,&quot;${entry.address}&quot,&quot;${entry.city}&quot,&quot;${entry.state}&quot,&quot;${entry.country}&quot,&quot;${entry.zip}&quot,&quot;${entry.email}&quot,&quot;${entry.spouseEmail}&quot,&quot;${entry.homePhone}&quot,&quot;${entry.fax}&quot,&quot;${entry.cellPhone}&quot,&quot;${entry.spouseCell}&quot,&quot;${entry.workPhone}&quot,&quot;${entry.spouseWork}&quot,&quot;<fmt:formatDate value="${entry.birthday}" type="date" pattern="MM/dd/yyyy"/>&quot,&quot;<fmt:formatDate value="${entry.spouseBirthday}" type="date" pattern="MM/dd/yyyy"/>&quot,&quot;${entry.spouseLast}&quot,&quot;${entry.spouseFirst}&quot,&quot;${entry.receivedCards}&quot,&quot;${entry.sentCards}&quot,&quot;<fmt:formatDate value="${entry.updated}" type="both" pattern="MM/dd/yyyy HH:mm"/>&quot<br/>
		
		</c:forEach>

	</body>
</html>
