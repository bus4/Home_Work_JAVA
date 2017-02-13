<#include "main-template.ftl"/>

<#macro m_body>
<div class="container">

    <div class="form-group row">
        <label for="inputEmail2" class="col-md-3 col-form-label">Авторизация</label>
    </div>

    <#if error??>
        <p class="alert-warning">Вы что-то не верно ввели!</p>
    </#if>

    <form action="/login/process" method="post">
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" name="login" class="form-control" id="inputEmail3" placeholder="Name">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Войти</button>
            </div>
        </div>
    </form>
    <br>
    <a href="/addsuser" class="btn btn-link">Регистрация</a>
</div>
</#macro>

<@main title="Логин"/>

