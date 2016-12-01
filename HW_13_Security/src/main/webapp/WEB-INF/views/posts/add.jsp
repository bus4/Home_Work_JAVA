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
    <title>Добавление нового поста</title>
</head>
<body>
<h1>Добавлениие нового поста</h1>
<form:form action="/posts/add" method="post" modelAttribute="post">
    <table>
        <tr>
            <td><form:label path="title">Заголовок</form:label> </td>
            <td><form:input path="title"/> </td>
            <td><form:errors path="title"/> </td>
        </tr>
        <tr>
            <td><form:label path="text">Текст</form:label> </td>
            <td><form:input path="text"/> </td>
            <td><form:errors path="text"/> </td>
        </tr>
        <%--<tr>--%>
            <%--<td><form:label path="author">Текст</form:label> </td>--%>
            <%--<td><form:input path="author"/> </td>--%>
            <%--<td><form:errors path="author"/> </td>--%>
        <%--</tr>--%>

    </table>

    <input type="submit" value="Сохранить" width="600px" >

</form:form>
<a href="/posts">На главную</a>

</body>
</html>
