<html>
<head>
    <title>A Time JSP Example</title>
</head>
<body>
    <h1>
        Current time in milliseconds is
        <%= System.currentTimeMillis() %>
    </h1>
    <hr/>
    <h1>
        The local time is <%= new java.util.Date() %>
    </h1>
</body>
</html>
