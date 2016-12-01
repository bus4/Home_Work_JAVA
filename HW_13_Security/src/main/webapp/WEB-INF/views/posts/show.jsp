<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Suser: Альберт
  Date: 14.11.2016
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}</title>
</head>
<body>
<h1>${post.title}</h1>
<small>Автор: ${post.author} / Дата: ${post.date}</small>
<p>${post.text}</p>

<h2>Комментарии:</h2>

<c:forEach var="comment" items="${post.comments}">
   <p>${comment.text}</p>
   <hr>
</c:forEach>



<a href="/posts">На главную </a>
</body>
</html>
