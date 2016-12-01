<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Suser: Альберт
  Date: 14.11.2016
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
</head>
<body>
<%--<a href="/posts/students" style="font-size: 30px">Студентлар</a>--%>
<a href="/posts">На главную</a>

<h1>Добро пожаловать в список студентов</h1>
<%--<form action="/posts" method="get">--%>
    <%--<input type="text" name="phraze" width="600px">--%>
    <%--<input type="submit" value="Search">--%>
<%--</form>--%>

<%--<a href="/posts/add">Добавить новый пост</a>--%>

<c:if test="${students.size()==0}">
    <p>Пока никого нет!</p>
</c:if>

<c:forEach var="student" items="${students}">
    <h2>${student.surname} ${student.name} ${student.lastname}</h2>
    <p> </p>
    <h3>Оценки студента:</h3>
    <c:forEach var="score" items="${student.score}">
    <p>Предмет: ${score.subjekt_type} Оценка: ${score.score}</p>
    </c:forEach>
    <h3>Сумма оценок студента = ${summap.get(student)} / Средняя оценка студента = ${avgmap.get(student)}</h3>
    <h3>Средняя оценка по предмету "${sbj}" = ${avgpmap.get(student)}</h3>
    <%--<p>${student.lastname}</p>--%>
    <%--<p>${post.text.substring(0,post.text.length()>127 ? 127: post.text.length())}</p>--%>
    <%--<a href="/posts/${post.id}">Читать полностью...</a><br>--%>
    <%--<a href="/posts/${post.id}/delete">Удалить пост</a>--%>
    <%--<a href="/post/${post.id}/edit">Редактировать</a>--%>
    <hr>
</c:forEach>

</body>
</html>
