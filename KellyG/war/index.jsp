<%-- 
    Document   : project1task3
    Created on : Jan 27, 2015, 8:24:03 PM
    Author     : kailigu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype") %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="kellyg" method="GET">
            Please enter a text to test if it's a palindrome : <br>
            <input type="text" name="txt">
            <br>
            <br>
            <input type="submit" value="Submit">
    </body>
</html>
