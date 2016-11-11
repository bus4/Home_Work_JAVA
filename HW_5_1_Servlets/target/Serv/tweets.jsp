<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Альберт
  Date: 10.11.2016
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
</head>
<body>

<h1>Twitter</h1>

<form action="/twitter" method="post">
    <label>Ваше сообщение: </label>
    <input type="text" name="message">
    <input type="submit">
</form>
<br>
<c:if test="${tweets.isEmpty()}">
    <p>Ничего пока нету :(</p>
</c:if>

<c:forEach items="${tweets}" var="tweet">
    <p>${tweet.messege}</p>
    <p>${tweet.createdAt}</p>
    <form action="/twitter/del" method="post">

        <input type="hidden" name="id" value="${tweet.id}">
        <input type="hidden" name="sr" value="${service}">
        <input type="submit" value="Удалить Твит">
    </form>

    <c:if test="${!tweet.comments.isEmpty()}">
        <p><b>Комментарии:</b></p>
    </c:if>
    <c:forEach items="${tweet.comments}" var="comment">
        <p><i>${comment}</i></p>

    </c:forEach>

    <form action="/twitter/com" method="post">

        <label>Ваш комментарий: </label>
        <input type="text" name="comment">
        <input type="hidden" name="comId" value="${tweet.id}">
        <input type="submit" value="Оставить комментарий">

    </form>


 <hr>
</c:forEach>

</body>
</html>
