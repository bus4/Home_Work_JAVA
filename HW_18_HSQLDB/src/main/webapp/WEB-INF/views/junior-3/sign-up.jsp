<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация нового пользователя</h1>
<form:form action="/junior-3/sign-up" method="post" modelAttribute="userForm">
    <table>
        <tr>
            <td><form:label path="mail">Имя пользователя </form:label></td>
            <td><form:input path="mail"/></td>
            <td><form:errors path="mail" style="color: red"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Пароль </form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" style="color: red"/></td>
        </tr>
        <tr>
            <td><form:label path="repassword">Повторите Пароль </form:label></td>
            <td><form:password path="repassword"/></td>
            <td><form:errors path="repassword" style="color: red"/></td>
        </tr>

    </table>
    <br>
    <input type="submit" value="Зарегистрироваться" width="600px">

</form:form>
<a href="/junior-3">На главную</a>

</body>
</html>
