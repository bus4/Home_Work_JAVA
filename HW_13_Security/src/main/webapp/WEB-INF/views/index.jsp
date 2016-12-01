<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>БЛОГ</h2>
<br>
<a href="/posts">ВОЙТИ</a>

<br>
<br>
<security:authorize ifAnyGranted="ROLE_USER">
    <h3>Это секретный текст для залогиненых</h3>
</security:authorize>

</body>
</html>
