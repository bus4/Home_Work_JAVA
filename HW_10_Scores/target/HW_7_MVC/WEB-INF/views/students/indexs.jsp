<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
</head>
<body>

<h1>Добро пожаловать в список студентов</h1>

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
    <hr>
</c:forEach>

</body>
</html>
