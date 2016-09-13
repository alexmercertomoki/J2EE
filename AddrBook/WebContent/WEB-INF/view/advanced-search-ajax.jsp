<?xml version="1.0" encoding="utf-8"?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% response.setHeader("Content-Type","text/xml"); %>

<results>
	<c:forEach var="entry" items="${entryList}">
		<result>
			<id>${entry.id}</id>
			<firstNames><c:out value="${entry.firstNames}"/></firstNames>
			<lastName><c:out value="${entry.lastName}"/></lastName>
		</result>
	</c:forEach>
</results>
