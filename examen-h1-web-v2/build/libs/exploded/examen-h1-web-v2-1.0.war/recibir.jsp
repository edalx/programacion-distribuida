<%--
  Created by IntelliJ IDEA.
  User: eacuji
  Date: 18/01/2018
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="GET" action='/recibir' name="good">
    <h2>Cadena recuperada: </h2>
    <input type="text" name="done" value='<%=request.getAttribute("textValue")%>'/>
</form>
</body>
</html>
