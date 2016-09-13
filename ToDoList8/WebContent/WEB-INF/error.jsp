<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>ToDoList8 -- Error Page</title>
    </head>
    
	<body>
	
		<h2>ToDoList8 Error</h2>

		<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>
		
		<c:choose>
			<c:when test="${ (empty user) }">
				Click <a href="login.do">here</a> to login.
			</c:when>
			<c:otherwise>
				Click <a href="todolist.do">here</a> to return to the To Do List.
			</c:otherwise>
		</c:choose>

	</body>
</html>