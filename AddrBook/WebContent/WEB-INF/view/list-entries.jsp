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

		<jsp:include page="errors-and-messages.jsp"/>
		
		<c:if test="${!(empty list)}">
		    Matches:<br/>
	        <c:forEach var="entry" items="${list}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="lookup-entry.do?id=${entry.id}">${entry.lastName}, ${entry.firstNames}</a>
				<c:if test="${!(empty entry.spouseLast) || !(empty entry.spouseFirst)}">
					& ${entry.spouseLast}, ${entry.spouseFirst}
				</c:if>
				<br/>
	        </c:forEach>
			<br/>
		</c:if>

		<c:if test="${!(empty spouseList)}">
		    Spouse Matches:<br/>
	        <c:forEach var="entry" items="${spouseList}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${entry.lastName}, ${entry.firstNames} &
                <a href="lookup-entry.do?id=${entry.id}">${entry.spouseLast}, ${entry.spouseFirst}</a><br/>
	        </c:forEach>
			<br/>
		</c:if>
		
	</body>
</html>
