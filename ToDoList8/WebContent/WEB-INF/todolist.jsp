<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>ToDoList8 </title>
    </head>
    
    <body>
    
        <h2>ToDoList8 Example</h2>
		
		<c:forEach var="error" items="${errors}">
			<h3 style="color:red"> ${error} </h3>
		</c:forEach>

        <form action="add.do" method="POST">
            <table>
                <tr> <td colspan="3"> <hr /> </td> </tr>
                <tr>
                    <td style="font-size: large">
                        Item to Add:
                    </td>
                    <td colspan="2">
                        <input id="item" type="text" size="40" name="item"/>
                    </td>
                </tr>
                <tr>
                    <td/>
                    <td>
                        <input type="submit" name="action" value="Add to Top" />
                    </td>
                    <td>
                        <input type="submit" name="action" value="Add to Bottom" />
                    </td>
                </tr>
                <tr> <td colspan="3"> <hr /> </td> </tr>
            </table>
        </form>

		<p style="font-size: x-large">The list now has ${ fn:length(items) } items.</p>

		<table>
			<c:set var="count" value="0" />
			<c:forEach var="item" items="${items}">
				<c:set var="count" value="${ count+1 }" />
           		<tr>
       				<td>
			            <form action="delete.do" method="POST">
                			<input type="hidden" name="id" value="${ item.id }" />
                			<input type="submit" name="button" value="X" />
           				</form>
        			</td>
        			<td valign="baseline" style="font-size: x-large"> &nbsp; ${ count }. &nbsp; </td>
        			<td valign="baseline">
        				<span style="font-size: x-large">
        					<c:out value="${ item.item }" />
        				</span>
                        (uniqueId = ${ item.id },
                        user = ${ item.userName },
                        ipAddr = ${ item.ipAddress })
        			</td>
   				</tr>
   			</c:forEach>
		</table>

       	Click <a href="logout.do">here</a> to log out.
    </body>
</html>