<%-- 
    Document   : index
    Created on : Jan 18, 2015, 10:10:16 PM
    Author     : Fuhao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mini Calculator</title>
    </head>
    <body>
        <h2>Mini Calculator</h2>
        <h3>Give me two numbers(Integer) and choose an operation, I can give you the result.</h3>
        <form action="hellohao" method="GET">
            <label for="letter">First Number:  </label>
            <input type="text" name="number1" value=<%= request.getAttribute("number1") == null ? "" : request.getAttribute("number1") %> ><br>
            <br>
            <label for="letter">Second Number: </label>
            <input type="text" name="number2" value=<%= request.getAttribute("number2") == null ? "" : request.getAttribute("number2") %> ><br>
            <br>
            <label for="letter">Operation:     </label>
            <select name="operation">
                <option value="add">add</option>
                <option value="multiply">multiply</option>
                <option value="relativelyPrime">relativePrime</option>
                <option value="mod">mod</option>
                <option value="modInverse">modInverse</option>
                <option value="power">power</option>
            </select><br>
            <br>
            <input type="submit" value="Submit" /><br>
            <br>
            <label><%= request.getAttribute("result") == null ? "" : request.getAttribute("result") %><label>
        </form>
        
    </body>
</html>
