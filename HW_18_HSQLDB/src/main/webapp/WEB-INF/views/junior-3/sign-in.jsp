<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Форма входа</title>
</head>
<body>
<h1>Авторизация</h1>

<c:if test="${error != null}">
    <p style="color: red">Имя пользователя и пароль не подходят </p>
</c:if>

<form action="/junior-3/sign-in/process" method="post">
    <table>
        <tr>
            <td><p>Имя пользователя </p> </td>
            <td><input type="text" name="login" value="${defaultSuser}"> </td>
            <td><errors path="login" style="color: red"/> </td>
        </tr>
        <tr>
            <td><p>Пароль </p> </td>
            <td><input type="password" name="password"> </td>
            <td><errors path="password" style="color: red"/> </td>
        </tr>
    </table>

    <input type="submit" value="Войти" width="600px" >

</form>
<br>
<br>
<a href="/junior-3/sign-up" style="font-size: 20px">Регистрация</a>

</body>
</html>
