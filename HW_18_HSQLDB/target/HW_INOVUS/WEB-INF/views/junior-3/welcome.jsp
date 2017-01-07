<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Приветствие</title>
</head>
<body>
<h1>${timesOfDay}, <security:authentication property="principal.mail"/>!</h1>

<form action="/logout" method="post">
    <input type="submit" value="Выйти">
</form>

</body>
</html>
