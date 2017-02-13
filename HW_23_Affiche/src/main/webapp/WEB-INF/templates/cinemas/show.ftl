<#include "../main-template.ftl"/>

<#macro m_body>
<div class="col-md-8 col-md-offset-2 posts">

<#--<h1>${cinema.name}-->
<#--<@security.authentication property="principal.name"/>-->

<#--</h1>-->

<#--<form action="/logout" method="post">-->
<#--<input type="submit" value="Выход из аккаунта">-->
<#--</form>-->
<#--<br>-->
<#--<br>-->
<#--<form action="/cinemas" method="get">-->
<#--<input type="text" name="phraze" width="600px">-->
<#--<input type="submit" value="Search">-->
<#--</form>-->
<#--<br>-->


<#--<#list cinemas as cinema>-->
    <div class="post">
        <h1 class="post-head">${cinema.name}</h1>
        <p style="color: orange" class="post-head">Рейтинг: ${cinema.rating}</p>
    <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

        <p class="post-text">${cinema.description}</p>

        <a href="/cinemas" class="btn btn-link">Назад</a>

    <#--<p style="display: none;" class="post-text">${cinema.description}</p>-->
    <#--<#if (cinema.description?length > 127) >-->
    <#--<a href="/cinema/${cinema.id}" class="show-post-text">Читать полностью...</a><br>-->
    <#--</#if>-->

    <#--<div style="display: none;" class="cont"></div>-->

    <#--<a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>-->

    <#--<a href="/cinemas/${cinema.id}/delete" class="btn btn-danger delete-post">Удалить фильм</a>-->
    <#--<a href="/cinemas/${cinema.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
    </div>
<#--<#else>-->
<#--<p>Пока ничего нет!</p>-->
<#--</#list>-->

<#--<a href="/cinemas/${cinema.id}/seances" class="btn btn-default nedit-post">Расписание</a>-->

    <div class="add">
        <br class="post-head">

        <a href="/cinemas/${cinema.id?c}/comments/add" class="btn btn-default show-add-post">Добавить новый комментарий</a>

    <#--<div class="add-post">-->
        <div style="display: none;" class="add-post">
            <form action="/cinemas/${cinema.id?c}/comments/add" method="post" modelAttribute="comment">
                <br>
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Ваш комментарий</label>
                    <div class="col-sm-10">
                        <input type="text" name="text" class="form-control" id="inputEmail3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Ваша оценка кинотеатра</label>
                    <div class="col-sm-10">
                        <input type="number" min="0" max="10" name="rating" class="form-control" id="inputEmail3">
                    <#--<output for="inputEmail3" name="level">0</output>/10-->
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
                </div>
                <br>
            </form>
        </div>
    </div>

    <#list cinemaComments as comment>
        <div class="post">
            <h3 class="post-head">${comment.suser.name}</h3>
            <small class="post-head">Дата: ${comment.date}</small>
            <small style="color: orange" class="post-head">Оценка: ${comment.rating}</small>
        <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

            <p class="post-text">${comment.text[0..*127]}</p>
            <p style="display: none;" class="post-text">${comment.text}</p>
            <#if (comment.text?length > 127) >
                <a href="/cinemas/${cinema.id}/comments/${comment.id}" class="show-post-text">Читать полностью...</a><br>
            </#if>

        <#--<div style="display: none;" class="cont"></div>-->

        <#--<a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>-->

            <br class="post-head">

            <a href="/cinemas/${cinema.id}/comments/${comment.id?c}/delete" method="get" class="btn btn-danger">Удалить
                комментарий</a>
        <#--<a href="/comments/${comment.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
        </div>
    <#else>
        <p>Пока ничего нет!</p>
    </#list>
</div>
</#macro>
<#--<@main title="Афиша"/>-->
<@main title="Афиша" customScripts=["/resources/js/posts.js"]/>