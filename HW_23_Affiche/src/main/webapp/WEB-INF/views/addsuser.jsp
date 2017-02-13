<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  Suser: Альберт
  Date: 14.11.2016
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация нового пользователя</h1>
<form:form action="/addsuser" method="post" modelAttribute="userForm">
    <table>
        <tr>
            <td><form:label path="mail">Ваш E-mail </form:label> </td>
            <td><form:input path="mail"/> </td>
            <td><form:errors path="mail"/> </td>
        </tr>
        <tr>
            <td><form:label path="password">Пароль </form:label> </td>
            <td><form:password path="password"/> </td>
            <td><form:errors path="password"/> </td>
        </tr>
<tr>
            <td><form:label path="repassword">Повторите Пароль </form:label> </td>
            <td><form:password path="repassword"/> </td>
            <td><form:errors path="repassword"/> </td>
        </tr>

    </table>

    <input type="submit" value="Зарегистрироваться" width="600px" >

</form:form>
<a href="/posts">На главную</a>

</body>
</html>
