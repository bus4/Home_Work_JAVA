<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Альберт
  Date: 26.11.2016
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h1>Для доступа к полному функционалу авторизуйтесь</h1>
<%--<p>Your message is</p>--%>
<%--<a href="/autorizatetest" methods="post">Авторизоваться</a>--%>
<%--<form action="/autorizatetest" method="post" modelAttribute="suser">--%>
<form action="/autorizatetest" method="post">
    <table>
        <tr>
            <td><label>Ваш E-mail: </label></td>
            <td><input type="text" name="mail" value=${mail}></td>
            <td><label> ${mailE}</label></td>
        </tr>
        <tr>
            <td><label>Ваш пароль: </label> </td>
            <td><input type="text" name="password" value=${password}></td>
            <td><label> ${passwordE}</label></td>
        </tr>
    </table>
    <input type="submit">
</form>
<br>
<a href="/posts">На главную</a>

</body>
</html>
