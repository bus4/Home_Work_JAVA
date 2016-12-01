<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Альберт
  Date: 30.11.2016
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h1>Авторизация</h1>

<c:if test="${error != null}">
    <p>Вы что-то не верно ввели! ${error}</p>
</c:if>

<form action="/login/process" method="post">
    Логин:<input type="text" name="login">
    Пароль:<input type="text" name="password">
    Запомнить меня<input type="checkbox" name="remember">
    <input type="submit" value="ВОЙТИ !!!">
</form>
<br>
<br>
<a href="/addsuser" style="font-size: 20px">Регистрация</a>

</body>
</html>
