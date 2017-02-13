<#assign security=JspTaglibs ["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER')">
  <@security.authentication property="principal.name" var="username"/>
</@security.authorize>

<header>
    <div class="col-md-4 col-md-offset-8">
        Добро пожаловать, ${username!"Аноним"}
    </div>
</header>