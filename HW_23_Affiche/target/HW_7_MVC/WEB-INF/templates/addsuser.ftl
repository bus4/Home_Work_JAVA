<#include "main-template.ftl"/>

<#macro m_body>
<div class="container">

    <div class="form-group row">
        <label for="inputEmail2" class="col-md-3 col-form-label">Регистрация нового пользователя</label>
    </div>

    <#--<#if error??>-->
        <#--<p class="alert-warning">Вы что-то не верно ввели!</p>-->
    <#--</#if>-->

    <form action="/addsuser" method="post" modelAttribute="userForm">
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" name="mail" class="form-control" id="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Пароль</label>
            <div class="col-sm-10">
                <input type="text" name="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Пароль еще раз</label>
            <div class="col-sm-10">
                <input type="text" name="repassword" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
            </div>
        </div>
    </form>
    <br>
    <a href="/posts" class="btn btn-link">Назад</a>
</div>
</#macro>

<@main title="Регистрация"/>

